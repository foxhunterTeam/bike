package com.poshbike.core.web;

import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

public class RestError {

	private final HttpStatus status;
	private final int code;
	private final String message;
	private final String developerMessage;

	public RestError(HttpStatus status, int code, String message,
			String developerMessage) {
		if (status == null) {
			throw new NullPointerException(
					"HttpStatus argument cannot be null.");
		}
		this.status = status;
		this.code = code;
		this.message = message;
		this.developerMessage = developerMessage;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof RestError) {
			RestError re = (RestError) o;
			return ObjectUtils.nullSafeEquals(getStatus(), re.getStatus())
					&& getCode() == re.getCode()
					&& ObjectUtils
							.nullSafeEquals(getMessage(), re.getMessage())
					&& ObjectUtils.nullSafeEquals(getDeveloperMessage(),
							re.getDeveloperMessage());
		}

		return false;
	}

	@Override
	public int hashCode() {
		// noinspection ThrowableResultOfMethodCallIgnored
		return ObjectUtils.nullSafeHashCode(new Object[] { getStatus(),
				getCode(), getMessage(), getDeveloperMessage() });
	}

	public String toString() {
		// noinspection StringBufferReplaceableByString
		return new StringBuilder().append(getStatus().value()).append(" (")
				.append(getStatus().getReasonPhrase()).append(" )").toString();
	}

}