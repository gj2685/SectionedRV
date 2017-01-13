package com.dev.sectionedrv;

public class Model {
    private String name;
    private int age;
    private String imgUrl;

    public Model(String name, int age, String imgUrl) {
        this.name = name;
        this.age = age;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
