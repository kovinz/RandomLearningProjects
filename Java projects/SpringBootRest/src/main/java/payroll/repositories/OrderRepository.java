package payroll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import payroll.entities.Order;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
  Optional<Order> findById(Long id);
  void deleteById(Long Id);
}