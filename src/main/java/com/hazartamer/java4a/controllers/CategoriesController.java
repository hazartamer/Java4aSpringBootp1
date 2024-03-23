package com.hazartamer.java4a.controllers;

import com.hazartamer.java4a.entities.Category;
import com.hazartamer.java4a.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private CategoryRepository categoryRepository;

    //Ctor Injection
    //Dependency Injection

    public CategoriesController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //Spring IoC -> perşembeye kadar araştırma ödevi

    @GetMapping
    public List<Category> getAll(){
        //işlevi yerine getirebilmek için başka bir nesneye ihtiyaç duyarsa(CategoryRepository) gibi
        //ona Dependency denir.
        return categoryRepository.findAll();
    }
    @PostMapping
    public void add(@RequestBody Category category){
        categoryRepository.save(category);
    }
    @PutMapping
    public String update(@RequestBody Category category){
        categoryRepository.save(category);
        return "Başarıyla güncellendi";
    }
    @DeleteMapping
    public String delete(@RequestParam int id){
       Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Kategori yok")) ;
        categoryRepository.delete(category);
        return "Başarıyla Silindi";

    }
}
