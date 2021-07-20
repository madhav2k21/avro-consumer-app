package com.techleads.app.model;

public class MyMessage {
    private Integer msgId;
    private String message;
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MyMessage(Integer msgId, String message) {
		this.msgId = msgId;
		this.message = message;
	}
	public MyMessage() {
		
	}
    

}
