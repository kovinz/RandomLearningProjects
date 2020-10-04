package payroll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import payroll.entities.Employee;

import java.util.Optional;
// allows to use JPA to Employee entity
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  Optional<Employee> findById(Long id);
  void deleteById(Long Id);
}