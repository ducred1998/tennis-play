package io.datajek.databaserelationships.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.databaserelationships.entity.Category;
import io.datajek.databaserelationships.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}

	public Category getCategory(int id) {
		return categoryRepository.findById(id).get();
	}

	public Category addCategory(Category category) {
		category.setId(0);
		return categoryRepository.save(category);
	}

	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}
}
