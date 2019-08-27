package project.spring.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.mongo.dto.UserDTO;
import project.spring.mongo.model.User;
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
	
	public User upDate(User obj) {
		User newObj = findById(obj.getId());
		upDateData(newObj, obj);
		return userRepository.save(newObj);
	}

	private void upDateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	public void delete(String id) {
		userRepository.delete(id);
	}
	
	public User fromDTO(UserDTO dtoObj) {
		return new User(dtoObj.getId(), dtoObj.getName(), dtoObj.getEmail());
	}
}



