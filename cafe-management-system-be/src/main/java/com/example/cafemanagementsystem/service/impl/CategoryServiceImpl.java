package com.example.cafemanagementsystem.service.impl;

import com.example.cafemanagementsystem.config.security.JwtFilter;
import com.example.cafemanagementsystem.constants.CafeConstants;
import com.example.cafemanagementsystem.mapper.CategoryMapper;
import com.example.cafemanagementsystem.model.dto.CategoryDto;
import com.example.cafemanagementsystem.model.entity.CategoryEntity;
import com.example.cafemanagementsystem.repository.CategoryRepository;
import com.example.cafemanagementsystem.service.CategoryService;
import com.example.cafemanagementsystem.util.CafeUtils;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final JwtFilter jwtFilter;

    @Autowired
    public CategoryServiceImpl(@NotNull final CategoryRepository categoryRepository,
                               @NotNull final JwtFilter jwtFilter) {
        this.categoryRepository = categoryRepository;
        this.jwtFilter = jwtFilter;
    }

    @Override
    public ResponseEntity<String> create(@NotNull final CategoryDto categoryDto) {
        try {
            if (jwtFilter.isAdmin()) {
                CategoryEntity categoryEntity = CategoryMapper.INSTANCE.categoryDtoToCategoryEntity(categoryDto);
                categoryEntity = categoryRepository.save(categoryEntity);
                return CafeUtils.getResponseEntity(String.format("Category Added Successfully: [id:%s]", categoryEntity.getId()), HttpStatus.CREATED);
            } else {
                return CafeUtils.getResponseEntity(CafeConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            log.error("Failed create category", ex);
            return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<CategoryDto>> findAll() {
        try {
            final List<CategoryDto> categories = categoryRepository.findAll()
                    .stream()
                    .map(c -> CategoryMapper.INSTANCE.categoryEntityToCategoryDto(c))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Failed call findAll", ex);
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> update(@NotNull final CategoryDto categoryDto) {
        try {
            if (jwtFilter.isAdmin()) {
                Optional<CategoryEntity> categoryWrapper = categoryRepository.findById(categoryDto.id());
                if (categoryWrapper.isPresent()) {
                    CategoryEntity category = categoryWrapper.get();
                    category.setName(categoryDto.name());
                    categoryRepository.save(category);
                    return CafeUtils.getResponseEntity("Category Updated Successfully", HttpStatus.OK);
                } else {
                    return CafeUtils.getResponseEntity("Category id does not exist", HttpStatus.BAD_REQUEST);
                }
            } else {
                return CafeUtils.getResponseEntity(CafeConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            log.error("Failed update category", ex);
            return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
