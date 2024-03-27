package doba.app.library.controllers;

import doba.app.library.dto.category.CreateCategoryDto;
import doba.app.library.dto.category.UpdateCategoryDto;
import doba.app.library.entities.CategoryEntity;
import doba.app.library.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/")
    CategoryEntity createCategory(@RequestBody CreateCategoryDto dto) {
        return categoryService.createCategory(dto);
    }

    @GetMapping("/")
    List<CategoryEntity> getAllCategoryPaginated() {
        return categoryService.getAllCategoryPaginated();
    }

    @GetMapping("/{id}")
    CategoryEntity getOneCategoryById(@PathVariable("id") UUID id) throws Exception {
        return categoryService.getOneCategoryById(id);
    }

    @PatchMapping("/{id}")
    CategoryEntity updateOneCategoryById(@PathVariable("id") UUID id, @RequestBody UpdateCategoryDto dto) throws Exception {
        return categoryService.updateOneCategoryById(id, dto);
    }

    @DeleteMapping("/{id}")
    CategoryEntity deleteOneCategoryById(@PathVariable("id") UUID id) throws Exception {
        return categoryService.deleteOneCategoryById(id);
    }
}
