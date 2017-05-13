package org.miejski.chatbot.message.parser


class ConversationThread {

    List<Message> messages = []

    def addMessage(Message message) {
        messages.add(message)
    }

    def List<Message> messagesForUser(String userName) {
        return messages.findAll { it.getAuthor() == userName}
    }
}
