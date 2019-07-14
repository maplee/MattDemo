package com.matt.childone;

public class MessageEvent {

    private int msgId;
    private String data;

    public MessageEvent(int msgId, String data) {
        this.msgId = msgId;
        this.data = data;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MessageEvent{" +
                "msgId=" + msgId +
                ", data='" + data + '\'' +
                '}';
    }
}
