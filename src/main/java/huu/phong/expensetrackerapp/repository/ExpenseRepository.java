package huu.phong.expensetrackerapp.repository;

import huu.phong.expensetrackerapp.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
