package com.jpapractice.models;

import java.util.Map;

public class ResponseMessage<K,V>
{
	Map<K, V> message;

	public ResponseMessage() {
		super();
	}

	public ResponseMessage(Map<K, V> message) {
		super();
		this.message = message;
	}

	public Map<K, V> getMessage() {
		return message;
	}

	public void setMessage(Map<K, V> message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + "]";
	}
}