package doba.app.library.services;

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
    private final CategoryRepository repository;

    @Autowired
    public CategoryService(final CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryEntity> getAllCategoryPaginated() {
        return repository.findAll();
    }

    public CategoryEntity getOneCategoryById(UUID id) throws Exception {
        Optional<CategoryEntity> category = repository.findById(id);
        if (category.isEmpty()) {
            throw new Exception("Category not found");
        }
        return category.get();
    }

    public CategoryEntity createCategory(CategoryEntity category) {
        return repository.save(category);
    }

    public CategoryEntity updateOneCategoryById(UUID id, UpdateCategoryDto dto) throws Exception {
        Optional<CategoryEntity> findOneCategory = repository.findById(id);
        if (findOneCategory.isEmpty()) {
            throw new Exception("Category not found");
        }
        CategoryEntity category = findOneCategory.get();
        if (dto.getName() != null) {
            category.setName(dto.getName());
        }
        return repository.save(category);
    }

    public CategoryEntity deleteOneCategoryById(UUID id) throws Exception {
        Optional<CategoryEntity> findOneCategory = repository.findById(id);
        if (findOneCategory.isEmpty()) {
            throw new Exception("Category not found");
        }
        CategoryEntity category = findOneCategory.get();
        repository.delete(category);
        return category;
    }
}
