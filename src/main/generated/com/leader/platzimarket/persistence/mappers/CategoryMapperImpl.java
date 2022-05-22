package com.leader.platzimarket.persistence.mappers;

import com.leader.platzimarket.domain.DomainCategory;
import com.leader.platzimarket.persistence.entities.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-20T22:18:40-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public DomainCategory toDomainCategory(Category category) {
        if ( category == null ) {
            return null;
        }

        DomainCategory domainCategory = new DomainCategory();

        if ( category.getId() != null ) {
            domainCategory.setCategoryId( category.getId() );
        }
        domainCategory.setCategory( category.getDescription() );
        domainCategory.setActive( category.isStatus() );

        return domainCategory;
    }

    @Override
    public Category toCategory(DomainCategory category) {
        if ( category == null ) {
            return null;
        }

        Category category1 = new Category();

        return category1;
    }
}
