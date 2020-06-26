package com.odx.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "demo")
public class Demo {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    public Demo(String name) {
        this.name = name;
    }
}
