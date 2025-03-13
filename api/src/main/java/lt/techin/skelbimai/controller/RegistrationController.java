package lt.techin.skelbimai.controller;

import lt.techin.skelbimai.model.Registration;
import lt.techin.skelbimai.model.Skelbimai;
import lt.techin.skelbimai.model.SkelbimaiDate;
import lt.techin.skelbimai.model.User;
import lt.techin.skelbimai.repository.RegistrationRepository;
import lt.techin.skelbimai.repository.SkelbimaiDateRepository;
import lt.techin.skelbimai.repository.SkelbimaiRepository;
import lt.techin.skelbimai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private SkelbimaiRepository skelbimaiRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SkelbimaiDateRepository skelbimaiDateRepository;

    @PostMapping
    public Registration registerUserForSkelbimai(@RequestParam Long userId,
                                            @RequestParam Long skelbimaiId,
                                            @RequestParam Long skelbimaiDateId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Skelbimai skelbimai = skelbimaiRepository.findById(skelbimaiId)
                .orElseThrow(() -> new RuntimeException("Skelbimas not found"));
        SkelbimaiDate skelbimaiDate = skelbimaiDateRepository.findById(skelbimaiDateId)
                .orElseThrow(() -> new RuntimeException("Skelbimas date not found"));

        Registration registration = new Registration();
        registration.setUser(user);
        registration.setSkelbimai(skelbimai);
        registration.setSkelbimaiDate(skelbimaiDate);

        return registrationRepository.save(registration);
    }

    @DeleteMapping("/{id}")
    public void cancelRegistration(@PathVariable Long id) {
        registrationRepository.deleteById(id);
    }
}