package com.jpaproject.jpaproject.domain.Item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("H")
public class Hat extends Item{
    private String size;
    private String etc;
}
