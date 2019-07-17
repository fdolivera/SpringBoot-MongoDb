package project.spring.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.mongo.domain.User;
import project.spring.mongo.domain.dto.UserDTO;
import project.spring.mongo.repository.UserRepository;
import project.spring.mongo.service.exception.ObjectNotFound;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		User user = userRepository.findOne(id);
		if (user == null) {
			throw new ObjectNotFound("Objeto não encontrado !");
		}
		return user;
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public User fromDTO(UserDTO dtoObj) {
		return new User(dtoObj.getId(), dtoObj.getName(), dtoObj.getEmail());
	}
}



