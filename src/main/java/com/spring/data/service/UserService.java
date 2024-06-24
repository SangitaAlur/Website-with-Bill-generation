package com.spring.data.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.data.entity.User;
import com.spring.data.repository.UserRepository;
@Service
public class UserService {
	 @Autowired
	    private UserRepository userRepository;

	    public User register(User user) {
	        return userRepository.save(user);
	    }

	    public User login(String username, String password) {
	        return userRepository.findByUsernameAndPassword(username, password);
	    }

		public User findByUsername(String username) {
			return userRepository.findByUsername(username);
		}
}
