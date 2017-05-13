package org.miejski.chatbot.message.parser

import java.nio.file.Files


class MessageParser {

    public static void main(String[] args) {

        File file = new File("./src/main/resources/messages.htm")

        ChatHistory chatHistory = new ChatHistory()

        def rootNode = new XmlSlurper().parse(file)
        rootNode.depthFirst().findAll { it.name() == "div" && it.@class == "thread" }.each {
            def thread = new ConversationThread()

            def subnodes = it.childNodes().collect { it }
            for (int i = 0; i < subnodes.size(); i += 2) {
                def messageDetailsDiv = subnodes[i]
                def contentNode = subnodes[i + 1]

                def content = getMessageContent(contentNode)
                def (author, date) = authorAndDate(messageDetailsDiv)

                thread.addMessage(new Message(content, author, date))
            }

            chatHistory.addConversationThread(thread)

        }

        def myUserName = "Grzesiek Miejski"

        def words = chatHistory.getWordsWithCount(myUserName)
        for (t in words) {
            println("${t[0]} ---> ${t[1]}")
        }
    }


    def static private String getMessageContent(groovy.util.slurpersupport.Node p) {
        return p.text()
    }

    def static private Tuple authorAndDate(groovy.util.slurpersupport.Node messageDiv) {
        if (messageDiv.attributes["class"] != "message") {
            throw new RuntimeException("messageDiv without 'message' class")
        }
        def message = messageDiv.children()[0]


        return new Tuple(message.children()[0].text(), message.children()[1].text())
    }
}
