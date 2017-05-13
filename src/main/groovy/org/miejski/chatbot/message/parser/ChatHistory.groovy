package org.miejski.chatbot.message.parser

import java.util.stream.Collectors

class ChatHistory {

    List<ConversationThread> conversationsThreads = []

    def addConversationThread(ConversationThread conversationThread) {
        conversationsThreads.add(conversationThread)
    }

    def List<Tuple<String, Integer>> getWordsWithCount(String userName) {
        def a = conversationsThreads.stream()
                .flatMap { it.messagesForUser(userName).stream() }
                .map { it.content.replace("-","") }
                .flatMap { Arrays.stream(it.tokenize(" \n,.?!")) }
                .flatMap { it.stream() }
                .collect(Collectors.toList())
        return a.countBy { it }.sort({ -it.value }).entrySet().stream()
                .limit(1000)
                .collect(Collectors.toList())
                .collect { new Tuple(it.key, it.value) }
    }
}
