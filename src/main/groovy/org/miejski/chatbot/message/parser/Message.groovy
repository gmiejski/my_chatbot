package org.miejski.chatbot.message.parser


class Message {

    private String content
    private String author
    private String dateTime

    Message(String content, String author, String dateTime) {
        this.content = content
        this.author = author
        this.dateTime = dateTime
    }

    String getContent() {
        return content
    }

    String getAuthor() {
        return author
    }

    String getDateTime() {
        return dateTime
    }
}
