package com.assignment.project.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.project.entity.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

	public Optional<Url> findByShortenedUrl(String shortnedUrl);
}
