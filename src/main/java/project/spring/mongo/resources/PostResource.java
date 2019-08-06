package project.spring.mongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.spring.mongo.domain.Post;
import project.spring.mongo.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService postService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post postId = postService.findById(id);
		return ResponseEntity.ok().body(postId);
	}
}
