package com.example.demo.domain.items;

import com.example.demo.domain.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "Movie")
public class Movie extends Item {

    private String director;

    private String actor;
}
