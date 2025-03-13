package lt.techin.skelbimai.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "skelbimai")
public class Skelbimai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    private Integer duration;

    private Double price;

    private Double averageRating = 0.0;

    @OneToMany(mappedBy = "skelbimai", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SkelbimaiDate> skelbimaiDates;

    @OneToMany(mappedBy = "skelbimai", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Registration> registrations;

    @ElementCollection
    @CollectionTable(name = "skelbimai_available_dates", joinColumns = @JoinColumn(name = "skelbimai_id"))
    @Column(name = "available_date")
    private List<String> availableDates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Set<SkelbimaiDate> getSkelbimaiDates() {
        return skelbimaiDates;
    }

    public void setSkelbimaiDates(Set<SkelbimaiDate> skelbimaiDates) {
        this.skelbimaiDates = skelbimaiDates;
    }

    public Set<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }

    public List<String> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<String> availableDates) {
        this.availableDates = availableDates;
    }
}