package org.miejski.chatbot.message.parser


class ChatHistory {

    def conversationsThreads = []

    def addConversationThread(ConversationThread conversationThread) {
        conversationsThreads.add(conversationThread)
    }

}
