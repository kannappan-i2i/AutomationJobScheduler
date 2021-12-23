
package com.automationjobscheduler.domain;

import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Robots {

    @PlanningId
    @Id @GeneratedValue
    private Long id;

    private String name;

    // No-arg constructor required for Hibernate
    public Robots() {
    }

    public Robots(String name) {
        this.name = name.trim();
    }

    public Robots(long id, String name) {
        this(name);
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

    // ************************************************************************
    // Getters and setters
    // ************************************************************************

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
