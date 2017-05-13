package org.miejski.chatbot.message.parser


class ConversationThread {

    def messages = []

    def addMessage(Message message) {
        messages.add(message)
    }
}
