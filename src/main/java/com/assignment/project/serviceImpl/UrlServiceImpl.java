package com.assignment.project.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.project.entity.Url;
import com.assignment.project.respository.UrlRepository;
import com.assignment.project.service.UrlService;

@Service
public class UrlServiceImpl implements UrlService {
	
	
	@Autowired
	UrlRepository urlRepository;


	public String shortenUrl(String originalUrl) {
		String shortnedUrl = generateShortUrl();
		Url url = new Url(originalUrl, shortnedUrl);
		urlRepository.save(url);
		
		return shortnedUrl;
	}


	public String getOriginalUrl(String shortnedUrl) {
		Optional<Url> urlOptional = urlRepository.findByShortenedUrl(shortnedUrl);
		if(urlOptional.isPresent()) {
			return urlOptional.get().getOrginalUrl();
		}else {
			throw new RuntimeException("URL not found.");
		}
		
	}


	private String generateShortUrl() {
	    String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    int length = 7;
	    String shortUrl = "";

	    boolean isUnique = false;
	    while (!isUnique) {
	        StringBuilder shortUrlBuilder = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            int randomIndex = (int) (Math.random() * allowedChars.length());
	            shortUrlBuilder.append(allowedChars.charAt(randomIndex));
	        }
	        shortUrl = shortUrlBuilder.toString();
	        isUnique = urlRepository.findByShortenedUrl(shortUrl).isEmpty();
	    }

	    return shortUrl;
	}


}
