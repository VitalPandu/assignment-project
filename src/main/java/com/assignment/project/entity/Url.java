package com.assignment.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
@Entity
@Table(name = "Url")
public class Url {

		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		private Long Id;
		
		@Column(name="orginal_url")
		private String orginalUrl;
		
		@Column(name="shortned_url")
		private String shortenedUrl;

		public Url(String orginalUrl, String shortenedUrl) {
			this.orginalUrl = orginalUrl;
			this.shortenedUrl = shortenedUrl;
		}

		public String getOrginalUrl() {
			return orginalUrl;
		}

		public String getShortenedUrl() {
			return shortenedUrl;
		}

	
		
		
}
