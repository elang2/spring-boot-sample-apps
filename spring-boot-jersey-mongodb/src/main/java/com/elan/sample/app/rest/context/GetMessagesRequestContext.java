package com.elan.sample.app.rest.context;

import com.elan.sample.app.api.MessageFilterTypeEnum;

public class GetMessagesRequestContext {

	private String userId;

	private MessageFilterTypeEnum filterType;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public MessageFilterTypeEnum getFilterType() {
		return filterType;
	}

	public void setFilterType(MessageFilterTypeEnum filterType) {
		this.filterType = filterType;
	}

}
