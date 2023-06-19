package org.manager.customer.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ExceptionDetail {

	private String exception;
	private String summary;
	private HttpStatus statudCode;
	private String path;
	
}
