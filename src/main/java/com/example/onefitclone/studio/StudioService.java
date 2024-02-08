package com.example.onefitclone.studio;

import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.location.LocationRepository;
import com.example.onefitclone.location.entity.Location;
import com.example.onefitclone.studio.category.CategoryRepository;
import com.example.onefitclone.studio.category.entity.Category;
import com.example.onefitclone.studio.dto.StudioCreateDto;
import com.example.onefitclone.studio.dto.StudioResponseDto;
import com.example.onefitclone.studio.dto.StudioUpdateDto;
import com.example.onefitclone.studio.entity.Studio;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Getter
@RequiredArgsConstructor
public class StudioService extends GenericService<Studio, UUID, StudioCreateDto, StudioResponseDto, StudioUpdateDto> {
    private final StudioRepository repository;
    private final CategoryRepository categoryRepository;
    private final LocationRepository locationRepository;
    private final Class<Studio> entityClass = Studio.class;
    private final StudioDtoMapper mapper;

    @Override
    protected StudioResponseDto internalCreate(StudioCreateDto studioCreateDto) {
        Studio studio = mapper.toEntity(studioCreateDto);

        Set<String> dtoCategoryNames = studioCreateDto.getCategories();
        Set<Category> categories = categoryRepository.findAllByNameIn(dtoCategoryNames);
        if (dtoCategoryNames.size() != categories.size()) {
            Set<String> categoryNames = categories.stream().map(Category::getName).collect(Collectors.toSet());
            dtoCategoryNames.removeAll(categoryNames);
            throw new EntityNotFoundException("Categories with these names are not found. Categories: %s".formatted(dtoCategoryNames));
        }
        studio.setCategories(categories);

        String locationName = studioCreateDto.getLocation();
        Location location = locationRepository.findByName(locationName).orElseThrow();

        studio.setLocation(location);
        studio.setId(UUID.randomUUID());
        location.setStudio(studio);
        Studio savedStudio = repository.save(studio);
        locationRepository.save(location);

        return mapper.toResponseDto(savedStudio);
    }

    @Override
    protected StudioResponseDto internalUpdate(UUID uuid, StudioUpdateDto studioUpdateDto) {
        Studio studio = repository
                .findById(uuid)
                .orElseThrow(
                        () -> new EntityNotFoundException("Studio not found")
                );
        mapper.toEntity(studioUpdateDto, studio);
        Studio saved = repository.save(studio);
        return mapper.toResponseDto(saved);
    }

    public StudioResponseDto addCategory(UUID studioId, String name) {
        Studio studio = repository.findById(studioId).orElseThrow(() -> new EntityNotFoundException("Studio not found"));
        Category category = categoryRepository.findById(name).orElseThrow(() -> new EntityNotFoundException("Category not found"));
        studio.getCategories().add(category);
        Studio saved = repository.save(studio);
        categoryRepository.save(category);
        return mapper.toResponseDto(saved);
    }
}
