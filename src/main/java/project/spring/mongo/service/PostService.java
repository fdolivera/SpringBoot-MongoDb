package project.spring.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.mongo.domain.Post;
import project.spring.mongo.repository.PostRepository;
import project.spring.mongo.service.exception.ObjectNotFound;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		
		Post post = postRepository.findOne(id);
		if (post == null) {
			throw new ObjectNotFound("Objeto nao encontrado");
		}
		return post;
	}
	
	public List<Post> findTitle(String text) {
		return postRepository.searchTitle(text);
	}
}
