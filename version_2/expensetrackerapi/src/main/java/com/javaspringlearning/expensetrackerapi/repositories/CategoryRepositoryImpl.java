package com.javaspringlearning.expensetrackerapi.repositories;

import java.util.List;

import com.javaspringlearning.expensetrackerapi.domain.Category;
import com.javaspringlearning.expensetrackerapi.exceptions.EtBadRequestException;
import com.javaspringlearning.expensetrackerapi.exceptions.EtResourceNotFoundException;

public class CategoryRepositoryImpl implements CategoryRepository {

    @Override
    public List<Category> findAll(Integer userId) throws EtResourceNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Category findById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer create(Integer userId, String title, String description) throws EtBadRequestException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Integer userId, Integer categoryId, Category category) throws EtBadRequestException {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeById(Integer userId, Integer categoryId) {
        // TODO Auto-generated method stub

    }

}
