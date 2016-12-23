package com.elan.sample.app.api;

public enum MessageFilterTypeEnum {

	SENT("sent"), RECEIVED("received"), ALL("all");

	private String filter;

	private MessageFilterTypeEnum(String filter) {
		this.filter = filter;
	}

	public String getFilter() {
		return filter;
	}

	public static MessageFilterTypeEnum getFilterTypeFromString(String filter) {
		for (MessageFilterTypeEnum filterTypeEnum : MessageFilterTypeEnum.values()) {
			if (filter.equalsIgnoreCase(filterTypeEnum.getFilter())) {
				return filterTypeEnum;
			}
		}
		throw new IllegalArgumentException(String.format("Illegal argument %s", filter));
	}
}
