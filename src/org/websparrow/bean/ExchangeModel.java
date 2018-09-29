package org.websparrow.bean;

import microsoft.exchange.webservices.data.property.complex.ItemId;
import microsoft.exchange.webservices.data.property.complex.MessageBody;

public class ExchangeModel {
	
	private String subject, to, cc;
	private ItemId id;
	private MessageBody body;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public ItemId getId() {
		return id;
	}
	public void setId(ItemId id) {
		this.id = id;
	}
	public MessageBody getBody() {
		return body;
	}
	public void setBody(MessageBody body) {
		this.body = body;
	}
	
}
