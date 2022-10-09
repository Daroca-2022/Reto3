package com.usa.mintic.reto3.service;

import com.example.demoo.model.Category;
import com.example.demoo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getMachine(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c){
        if(c.getIdCategory()==null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> e = categoryRepository.getCategory(c.getIdCategory());
            if(e.isPresent()){
                return c;
            }else {
                return categoryRepository.save(c);
            }
        }

    }

    public Category update(Category c){
        if (c.getIdCategory()!=null){
            Optional<Category> m = categoryRepository.getCategory(c.getIdCategory());
            if(m.isPresent()){
                if (c.getName()!= null){
                    m.get().setName(c.getName());
                }
                if (c.getDescription()!=null){
                    m.get().setDescription(c.getDescription());
                }
                categoryRepository.save(m.get());
                return m.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean delete(int id){
        Optional<Category> c = categoryRepository.getCategory(id);
        boolean flag = false;
        if (c.isPresent()){
            categoryRepository.delete(c.get());
            flag = true;
        }
        return flag;
    }
}