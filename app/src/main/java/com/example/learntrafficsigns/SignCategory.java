package com.example.learntrafficsigns;

public class SignCategory {
    private final String name;
    private final int imageResId; // ID ресурса картинки

    public SignCategory(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}

