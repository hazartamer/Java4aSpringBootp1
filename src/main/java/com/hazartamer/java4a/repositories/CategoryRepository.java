package com.hazartamer.java4a.repositories;

import com.hazartamer.java4a.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>
{

}
