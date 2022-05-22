package com.leader.platzimarket.persistence.mappers;

import com.leader.platzimarket.domain.DomainCategory;
import com.leader.platzimarket.persistence.entities.Category;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "id",target = "categoryId"),
            @Mapping(source = "description",target = "category"),
            @Mapping(source = "status",target = "active"),

    })
    DomainCategory toDomainCategory(Category category);

    @InheritConfiguration
    @Mapping(target = "products",ignore = true)
    Category toCategory(DomainCategory category);


}
