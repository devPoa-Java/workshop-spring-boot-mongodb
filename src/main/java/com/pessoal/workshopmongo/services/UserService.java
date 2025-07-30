package com.pessoal.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoal.workshopmongo.domain.User;
import com.pessoal.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
	 return	userRepository.findAll();		
	}

}
