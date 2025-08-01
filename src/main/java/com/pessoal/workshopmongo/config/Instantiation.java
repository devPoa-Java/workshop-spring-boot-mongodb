package com.pessoal.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pessoal.workshopmongo.domain.Post;
import com.pessoal.workshopmongo.domain.User;
import com.pessoal.workshopmongo.dto.AuthorDTO;
import com.pessoal.workshopmongo.dto.CommentDTO;
import com.pessoal.workshopmongo.repository.PostRespository;
import com.pessoal.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
    @Autowired
    private PostRespository postRepository;
	

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom Dia", "Acordei feliz hoje",new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Aproveite", sdf.parse("22/02/2018"), new AuthorDTO(maria));
		CommentDTO c2 = new CommentDTO("Boa viagem mano!", sdf.parse("21/02/2018"), new AuthorDTO(alex));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/02/2018"), new AuthorDTO(maria));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	
	   maria.getPosts().addAll(Arrays.asList(post1, post2));
	   userRepository.save(maria);
	
	}
	

}
