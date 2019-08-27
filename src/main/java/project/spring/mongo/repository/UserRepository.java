package project.spring.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import project.spring.mongo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
