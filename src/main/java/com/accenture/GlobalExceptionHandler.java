package com.accenture;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class GlobalExceptionHandler {
		
@ExceptionHandler(MultipartException.class)
public String ErrorHandler(MultipartException e,Model model){
	
	model.addAttribute("message",e.getCause().getMessage());
	return "redirect:/Result";
}
}
