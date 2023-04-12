package com.assignment.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.project.service.UrlService;

@RestController
@RequestMapping("/url")
public class UrlController {
	
	@Autowired
	UrlService urlService;
	
	@GetMapping("/{shortenedUrl}")
	   public String redirect(@PathVariable String shortenedUrl) {
	      String originalUrl = urlService.getOriginalUrl(shortenedUrl);
	      return "redirect:" + originalUrl;
	   }

	   @GetMapping("/shortenUrl/{orginalUrl}")
	   public String shortenUrl(@PathVariable String originalUrl) {
		   System.out.println(originalUrl);
	      String shortenedUrl = urlService.shortenUrl(originalUrl);
	      return shortenedUrl;
	   }
	   @GetMapping("/urlcontroller")
		public String hello() {
			return "urlcontroller";
		}

}
