package lt.techin.skelbimai.controller;

import lt.techin.skelbimai.model.Skelbimai;
import lt.techin.skelbimai.model.Review;
import lt.techin.skelbimai.repository.SkelbimaiRepository;
import lt.techin.skelbimai.repository.ReviewRepository;
import lt.techin.skelbimai.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/skelbimai")
public class SkelbimaiController {

    @Autowired
    private SkelbimaiRepository skelbimaiRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @GetMapping
    public List<Skelbimai> getAllSkelbimai() {
        return skelbimaiRepository.findAll();
    }

    @GetMapping("/{id}")
    public Skelbimai getSkelbimai(@PathVariable Long id) {
        return skelbimaiRepository.findById(id).orElseThrow(() -> new RuntimeException("Skelbimas not found"));
    }

    @PostMapping
    public Skelbimai createSkelbimai(@RequestBody Skelbimai skelbimai) {
        return skelbimaiRepository.save(skelbimai);
    }

    @PutMapping("/{id}")
    public Skelbimai updateSkelbimai(@PathVariable Long id, @RequestBody Skelbimai skelbimaiDetails) {
        Skelbimai skelbimai = skelbimaiRepository.findById(id).orElseThrow(() -> new RuntimeException("Skelbimas not found"));
        skelbimai.setName(skelbimaiDetails.getName());
        skelbimai.setDescription(skelbimaiDetails.getDescription());
        skelbimai.setImageUrl(skelbimaiDetails.getImageUrl());
        skelbimai.setDuration(skelbimaiDetails.getDuration());
        skelbimai.setPrice(skelbimaiDetails.getPrice());
        return skelbimaiRepository.save(skelbimai);
    }

    @DeleteMapping("/{id}")
    public void deleteSkelbimai(@PathVariable Long id) {
        skelbimaiRepository.deleteById(id);
    }

    @PostMapping("/{skelbimaiId}/reviews")
    public Review addReview(@PathVariable Long skelbimaiId, @RequestBody Review review) {
        Skelbimai skelbimai = skelbimaiRepository.findById(skelbimaiId).orElseThrow(() -> new RuntimeException("Skelbimas not found"));
        review.setSkelbimai(skelbimai);
        return reviewRepository.save(review);
    }

    @GetMapping("/{skelbimaiId}/average-rating")
    public Double getAverageRating(@PathVariable Long skelbimaiId) {
        List<Review> reviews = reviewRepository.findBySkelbimaiId(skelbimaiId);
        return reviews.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);
    }
}