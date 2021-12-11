package com.example.playmarket.model;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
    private String name;
    private List<Program> programList;

    public Category(String name, List<Program> programList) {
        this.name = name;
        this.programList = programList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Program> getProgramList() {
        return programList;
    }

    public void setProgramList(List<Program> programList) {
        this.programList = programList;
    }
}
