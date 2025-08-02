package com.pessoal.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoal.workshopmongo.domain.Post;
import com.pessoal.workshopmongo.repository.PostRespository;
import com.pessoal.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRespository postRepository;
	

	public Post findById(String id) {
		
		Optional<Post> user = postRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		
		return postRepository.findByTitleContainingIgnoreCase(text);
		
	}

}
