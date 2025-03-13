package lt.techin.skelbimai.service;

import lt.techin.skelbimai.dto.UserDTO;
import lt.techin.skelbimai.model.User;
import lt.techin.skelbimai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void register(UserDTO userDTO) {
    }
}