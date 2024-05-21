package huu.phong.expensetrackerapp.repository;

import huu.phong.expensetrackerapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
