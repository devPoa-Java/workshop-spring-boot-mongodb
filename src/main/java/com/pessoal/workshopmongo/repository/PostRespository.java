package com.pessoal.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pessoal.workshopmongo.domain.Post;

@Repository
public interface PostRespository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitleQuery(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);

}
