package lt.techin.skelbimai.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "skelbimai_dates")
public class SkelbimaiDate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "skelbimai_id", nullable = false)
  private Skelbimai skelbimai;

  @Column(nullable = false)
  private LocalDate skelbimaiDate;

  public SkelbimaiDate() {
  }

  public Long getId() {
    return id;
  }

  public Skelbimai getSkelbimai() {
    return skelbimai;
  }

  public void setSkelbimai(Skelbimai skelbimai) {
    this.skelbimai = skelbimai;
  }

  public LocalDate getSkelbimaiDate() {
    return skelbimaiDate;
  }

  public void setSkelbimaiDate(LocalDate skelbimaiDate) {
    this.skelbimaiDate = skelbimaiDate;
  }
}