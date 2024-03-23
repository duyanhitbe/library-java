package doba.app.library.services;

import doba.app.library.dto.category.CreateCategoryDto;
import doba.app.library.dto.category.UpdateCategoryDto;
import doba.app.library.entities.CategoryEntity;
import doba.app.library.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //Get list of categories with pagination
    public List<CategoryEntity> getAllCategoryPaginated() {
        return categoryRepository.findAll();
    }

    //Get one category by id
    public CategoryEntity getOneCategoryById(UUID id) throws Exception {
        Optional<CategoryEntity> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new Exception("Category not found");
        }
        return category.get();
    }

    //Create a new category
    public CategoryEntity createCategory(CreateCategoryDto dto) {
        CategoryEntity category = new CategoryEntity(dto.getName());
        return categoryRepository.save(category);
    }

    //Update one category by id
    public CategoryEntity updateOneCategoryById(UUID id, UpdateCategoryDto dto) throws Exception {
        Optional<CategoryEntity> findOneCategory = categoryRepository.findById(id);
        if (findOneCategory.isEmpty()) {
            throw new Exception("Category not found");
        }
        CategoryEntity category = findOneCategory.get();
        if (dto.getName() != null) {
            category.setName(dto.getName());
        }
        return categoryRepository.save(category);
    }

    //Delete one category by id
    public CategoryEntity deleteOneCategoryById(UUID id) throws Exception {
        Optional<CategoryEntity> findOneCategory = categoryRepository.findById(id);
        if (findOneCategory.isEmpty()) {
            throw new Exception("Category not found");
        }
        CategoryEntity category = findOneCategory.get();
        categoryRepository.delete(category);
        return category;
    }
}
