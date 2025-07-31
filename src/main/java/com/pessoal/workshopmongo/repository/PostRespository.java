package com.pessoal.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pessoal.workshopmongo.domain.Post;

@Repository
public interface PostRespository extends MongoRepository<Post, String> {

}
