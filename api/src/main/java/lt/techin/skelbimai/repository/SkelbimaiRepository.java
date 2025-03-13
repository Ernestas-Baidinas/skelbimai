package lt.techin.skelbimai.repository;

import lt.techin.skelbimai.model.Skelbimai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface SkelbimaiRepository extends JpaRepository<Skelbimai, Long> {
    @Query("SELECT s FROM Skelbimai s WHERE :date MEMBER OF s.availableDates")
    List<Skelbimai> findByAvailableDatesContaining(@Param("date") String date);
}