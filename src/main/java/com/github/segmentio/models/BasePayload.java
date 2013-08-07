package com.github.segmentio.models;

import java.io.Serializable;

import org.joda.time.DateTime;

/**
 * The base model for for Track / Identify payload
 *
 */
public class BasePayload implements Serializable {

	private String userId;
	private Context context;
	private DateTime timestamp;
	
	private transient Callback callback;
	
	public BasePayload(String userId, 
					   DateTime timestamp, 
					   Context context, 
					   Callback callback) {
		
		this.userId = userId;
		this.timestamp = timestamp;
		this.context = context;
		
		this.callback = callback;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public DateTime getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(DateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
	public Callback getCallback() {
		return callback;
	}
	
	public void setCallback(Callback callback) {
		this.callback = callback;
	}

}
