package com.ecom.shopease.batch;

import com.ecom.shopease.entities.Category;
import org.springframework.batch.item.ItemProcessor;

public class CategoryProcessor implements ItemProcessor<Category, Category> {
    @Override
    public Category process(Category category) throws Exception {
        return category;
    }
}
