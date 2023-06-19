package org.manager.customer.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;

@ControllerAdvice
public class ExceptionHandlerService {

	@ExceptionHandler(DetailNotFoundException.class)
	public ResponseEntity<ExceptionDetail> detailNotFound(Exception ex, HandlerMethod handlerMethod, HttpServletRequest request) {

		ExceptionDetail detail = new ExceptionDetail();
		detail.setException(ex.getMessage());
		detail.setStatudCode(HttpStatus.BAD_REQUEST);
		detail.setSummary("Request details not found");
		detail.setPath(request.getContextPath() + request.getRequestURI());
		return new ResponseEntity<ExceptionDetail>(detail, HttpStatus.BAD_REQUEST);
	}
}
