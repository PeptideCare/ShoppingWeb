package com.jpaproject.jpaproject.domain.Item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("T")
public class Top extends Item{

    private String size;
    private String etc;
}
