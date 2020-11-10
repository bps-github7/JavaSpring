package com.javaspringlearning.expensetrackerapi.services;

import java.util.List;

import com.javaspringlearning.expensetrackerapi.domain.Category;
import com.javaspringlearning.expensetrackerapi.exceptions.EtBadRequestException;
import com.javaspringlearning.expensetrackerapi.exceptions.EtResourceNotFoundException;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> fetchAllCategories(Integer userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Category addCategory(Integer userId, String title, String description) throws EtBadRequestException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeCategoryWithAllTransactions(Integer userId, Integer categoryId)
            throws EtResourceNotFoundException {
        // TODO Auto-generated method stub

    }

}
