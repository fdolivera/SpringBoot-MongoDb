package project.spring.mongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.spring.mongo.domain.User;
import project.spring.mongo.domain.dto.UserDTO;
import project.spring.mongo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> list = userService.findAll();
		List<UserDTO> listDto = list.stream().map(resp -> new UserDTO(resp)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
}
