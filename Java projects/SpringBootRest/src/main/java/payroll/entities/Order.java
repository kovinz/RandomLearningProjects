package payroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import payroll.Status;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer_order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;
  private Status status;

  public Order(String description, Status status) {

    this.description = description;
    this.status = status;
  }
}