package doba.app.library.services;

import doba.app.library.dto.category.CreateCategoryDto;
import doba.app.library.dto.category.UpdateCategoryDto;
import doba.app.library.entities.CategoryEntity;
import doba.app.library.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    //Get list of categories with pagination
    public List<CategoryEntity> getAllCategoryPaginated() {
        return categoryRepository.findAll();
    }

    //Get one category by id
    public CategoryEntity getOneCategoryById(UUID id) throws Exception {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Category not found"));
    }

    //Create a new category
    public CategoryEntity createCategory(CreateCategoryDto dto) {
        CategoryEntity category = CategoryEntity
                .builder()
                .name(dto.getName())
                .build();
        return categoryRepository.save(category);
    }

    //Update one category by id
    public CategoryEntity updateOneCategoryById(UUID id, UpdateCategoryDto dto) throws Exception {
        CategoryEntity category = this.getOneCategoryById(id);

        String name = dto.getName();

        String updatedName = name != null ? name : category.getName();

        category.setName(updatedName);

        return categoryRepository.save(category);
    }

    //Delete one category by id
    public CategoryEntity deleteOneCategoryById(UUID id) throws Exception {
        CategoryEntity category = this.getOneCategoryById(id);
        categoryRepository.delete(category);
        return category;
    }
}
