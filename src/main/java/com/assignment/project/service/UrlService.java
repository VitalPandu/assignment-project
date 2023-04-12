package com.assignment.project.service;



public interface UrlService {
	
	public String shortenUrl(String originalUrl);
	
	public String getOriginalUrl(String shortnedUrl);
	
	
}
