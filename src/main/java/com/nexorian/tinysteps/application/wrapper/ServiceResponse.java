package com.nexorian.tinysteps.application.wrapper;

import lombok.Data;

@Data
public class ServiceResponse <T> {
	private ResStatus status = ResStatus.SUCCESS;
	private String message;
	private T data;
	private String errorStackTrace;
	private int statusCode;

	 

	@Override
	public String toString() {
		return String.format("Response [data=%s, message=%s, status=%s]", data, message, status);
	}
	public enum ResStatus {
		SUCCESS, WARNING, ERROR;

		public String toString() {
			return this.name().toLowerCase();
		}
	}

	public static <T> ServiceResponse<T> buildResponse(T data) {
		ServiceResponse<T> response = new ServiceResponse<>();
		response.setMessage("Operation Successful");
		response.setErrorStackTrace(null);
		response.setStatus(ResStatus.SUCCESS);
		response.setStatusCode(200);
		response.setData(data);
		return response;
	}

	public static <T> ServiceResponse<T> buildErrorResponse(String message) {
		ServiceResponse<T> response = new ServiceResponse<>();
		response.setStatus(ResStatus.ERROR);
		response.setMessage(message);
		response.setStatusCode(400);
		response.setErrorStackTrace(null);
		response.setData(null);
		return response;
	}
}
