package com.javaspringlearning.expensetrackerapi.repositories;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import com.javaspringlearning.expensetrackerapi.domain.Category;
import com.javaspringlearning.expensetrackerapi.exceptions.EtBadRequestException;
import com.javaspringlearning.expensetrackerapi.exceptions.EtResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private static final String SQL_CREATE = "INSERT INTO ET_CATEGORIES (CATEGORY_ID, USER_ID, TITLE, DESCRIPTION) VALUES (NEXTVAL('ET_CATEGORIES_SEQ'), ?, ?, ?)";

    // TODO: you should put a comment here explaining why this query is so
    // complex...
    private static final String SQL_FIND_BY_ID = "SELECT C.CATEGORY_ID, C.USER_ID, C.TITLE, C.DESCRIPTION, "
            + "COALESCE(SUM(T.AMOUNT), 0) TOTAL_EXPENSE "
            + "FROM ET_TRANSACTIONS T RIGHT OUTER JOIN ET_CATEGORIES C ON C.CATEGORY_ID = T.CATEGORY_ID "
            + "WHERE C.USER_ID = ? AND C.CATEGORY_ID = ? GROUP BY C.CATEGORY_ID";

    private static final String SQL_FIND_ALL = "SELECT C.CATEGORY_ID, C.USER_ID, C.TITLE, C.DESCRIPTION, "
            + "COALESCE(SUM(T.AMOUNT), 0) TOTAL_EXPENSE "
            + "FROM ET_TRANSACTIONS T RIGHT OUTER JOIN ET_CATEGORIES C ON C.CATEGORY_ID = T.CATEGORY_ID "
            + "WHERE C.USER_ID = ? GROUP BY C.CATEGORY_ID";

    private static final String SQL_UPDATE = "UPDATE ET_CATEGORIES SET TITLE = ?, DESCRIPTION = ? "
            + "WHERE USER_ID = ? AND CATEGORY_ID = ?";

    private static final String SQL_DELETE_CATEGORY = "DELETE FROM ET_CATEGORIES WHERE USER_ID = ? AND CATEGORY_ID = ?";

    private static final String SQL_DELETE_ALL_TRANSACTIONS = "DELETE FROM ET_TRANSACTIONS WHERE CATEGORY_ID = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> findAll(Integer userId) throws EtResourceNotFoundException {
        /* 
        
        */
        return jdbcTemplate.query(SQL_FIND_ALL, new Object[] { userId }, categoryRowMapper);
    }

    @Override
    public Category findById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
        /*
         * For looking up a specific category using its Ids
         * 
         * Params: Integer userId and Integer categoryId.
         * 
         * Returns: query object containing values from the row looked up.
         * 
         * Exceptions: EtResourceNotFoundException with HttpStatus code 404.
         */
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[] { userId, categoryId }, categoryRowMapper);
        } catch (Exception e) {
            throw new EtResourceNotFoundException("Category not found");
        }
    }

    @Override
    public Integer create(Integer userId, String title, String description) throws EtBadRequestException {

        /*
         * creates a new category entity in ET_CATEGORY table of expensetrackerdb
         * database.
         * 
         * Params: Integer userId, String title and String description.
         * 
         * Returns: the CATEGORY_ID of freshly created row. This is an int generated
         * based on rows ordinal position.
         * 
         * Throws: EtBadRequestException with HttpStatusCode 400
         */
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, userId);
                ps.setString(2, title);
                ps.setString(3, description);
                return ps;
            }, keyHolder);
            // get the key
            return (Integer) keyHolder.getKeys().get("CATEGORY_ID");
        } catch (Exception e) {
            throw new EtBadRequestException("Invalid request");
        }
    }

    @Override
    public void update(Integer userId, Integer categoryId, Category category) throws EtBadRequestException {
        /* 
        
        */
        try {
            jdbcTemplate.update(SQL_UPDATE,
                    new Object[] { category.getTitle(), category.getDescription(), userId, categoryId });
        } catch (Exception e) {
            throw new EtBadRequestException("Invalid request.");
        }

    }

    @Override
    public void removeById(Integer userId, Integer categoryId) {
        /* 
        */
        this.removeAllCategoryTransactions(categoryId);
        jdbcTemplate.update(SQL_DELETE_CATEGORY, new Object[] { userId, categoryId });

    }

    private void removeAllCategoryTransactions(Integer categoryId) {
        jdbcTemplate.update(SQL_DELETE_ALL_TRANSACTIONS, new Object[] { categoryId });
    }

    // Row mapper for use in translating from expensetrackerdb entity values to
    // jdbcTemplate.
    private RowMapper<Category> categoryRowMapper = ((rs, rowNum) -> {
        return new Category(rs.getInt("CATEGORY_ID"), rs.getInt("USER_ID"), rs.getString("TITLE"),
                rs.getString("DESCRIPTION"), rs.getDouble("TOTAL_EXPENSE"));
    });
}
