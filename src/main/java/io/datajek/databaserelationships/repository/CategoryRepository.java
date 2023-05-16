package io.datajek.databaserelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.datajek.databaserelationships.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
