package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ParamService {
	@Autowired
	HttpServletRequest request;
	
	public String getString(String name, String defaultValue) {
		return request.getParameter(name);
	}
//	public int getInt(String name,int defaultValue) {
//		
//	} 
//	public double getDouble(String name, double defaultValue) {
//		
//	}
	public boolean getBoolean(String name, boolean defaultValue) {
		return Boolean.parseBoolean(request.getParameter(name));
	}
//	public Date getDate(String name, String pattern) {
//		
//	}
//	public Five save(MultipartFile file, String path) {
//		
//	}
	
}
