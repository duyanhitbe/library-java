package doba.app.library.controllers;

import doba.app.library.dto.category.CreateCategoryDto;
import doba.app.library.dto.category.UpdateCategoryDto;
import doba.app.library.entities.CategoryEntity;
import doba.app.library.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/v1/category")
    CategoryEntity createCategory(@RequestBody CreateCategoryDto dto) {
        return categoryService.createCategory(dto);
    }

    @GetMapping("/v1/category")
    List<CategoryEntity> getAllCategoryPaginated() {
        return categoryService.getAllCategoryPaginated();
    }

    @GetMapping("/v1/category/{id}")
    CategoryEntity getOneCategoryById(@PathVariable("id") UUID id) throws Exception {
        return categoryService.getOneCategoryById(id);
    }

    @PatchMapping("/v1/category/{id}")
    CategoryEntity updateOneCategoryById(@PathVariable("id") UUID id, @RequestBody UpdateCategoryDto dto) throws Exception {
        return categoryService.updateOneCategoryById(id, dto);
    }

    @DeleteMapping("/v1/category/{id}")
    CategoryEntity deleteOneCategoryById(@PathVariable("id") UUID id) throws Exception {
        return categoryService.deleteOneCategoryById(id);
    }
}
