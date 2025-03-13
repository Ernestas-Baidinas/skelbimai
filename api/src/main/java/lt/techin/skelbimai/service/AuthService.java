package lt.techin.skelbimai.service;

import lt.techin.skelbimai.controller.UserRegistrationRequest;
import lt.techin.skelbimai.model.User;
import lt.techin.skelbimai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired
  private UserRepository userRepository;

  public void registerUser(UserRegistrationRequest request) {
    User user = new User();
    user.setUsername(request.getUsername());
    user.setPassword(request.getPassword());
    userRepository.save(user);
  }
}