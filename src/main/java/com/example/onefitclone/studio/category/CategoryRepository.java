package com.example.onefitclone.studio.category;

import com.example.onefitclone.common.repository.GenericRepository;
import com.example.onefitclone.studio.category.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CategoryRepository extends GenericRepository<Category, String> {
}
