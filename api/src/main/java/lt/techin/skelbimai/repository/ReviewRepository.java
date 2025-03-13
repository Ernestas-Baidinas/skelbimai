package lt.techin.skelbimai.repository;

import lt.techin.skelbimai.model.Review;
import lt.techin.skelbimai.model.Skelbimai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findBySkelbimai(Skelbimai skelbimai);

    List<Review> findBySkelbimaiId(Long skelbimaiId);
}