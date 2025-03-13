package lt.techin.skelbimai.repository;

import lt.techin.skelbimai.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByUserId(Long userId);
    List<Registration> findBySkelbimaiId(Long skelbimaiId);
}