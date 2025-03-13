package lt.techin.skelbimai.model;

import jakarta.persistence.*;

@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "skelbimai_id", nullable = false)
    private Skelbimai skelbimai;

    @ManyToOne
    @JoinColumn(name = "skelbimai_date_id", nullable = false)
    private SkelbimaiDate skelbimaiDate;

    public Registration() {
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skelbimai getSkelbimai() {
        return skelbimai;
    }

    public void setSkelbimai(Skelbimai skelbimai) {
        this.skelbimai = skelbimai;
    }

    public SkelbimaiDate getSkelbimaiDate() {
        return skelbimaiDate;
    }

    public void setSkelbimaiDate(SkelbimaiDate skelbimaiDate) {
        this.skelbimaiDate = skelbimaiDate;
    }
}