package com.jpaproject.jpaproject.domain.Item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("B")
public class Bottom extends Item{

    private String size;
    private String etc;
}
