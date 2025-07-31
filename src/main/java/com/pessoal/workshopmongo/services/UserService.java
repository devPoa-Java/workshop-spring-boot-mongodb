package com.pessoal.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoal.workshopmongo.domain.User;
import com.pessoal.workshopmongo.dto.UserDTO;
import com.pessoal.workshopmongo.repository.UserRepository;
import com.pessoal.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return userRepository.insert(obj);
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}

	public void delete(String id) {
		userRepository.deleteById(id);
	}

	public User update(User obj) {
		User user = findById(obj.getId());
		updateData(user, obj);
		return userRepository.save(user);
	}

	private void updateData(User user, User obj) {
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
	}

}
