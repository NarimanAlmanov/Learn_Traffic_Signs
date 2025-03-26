package com.example.learntrafficsigns;

public class TrafficSign {
    public int id;
    public String name;
    public String category;
    public String picture;
    public TrafficSign(int id, String name, String category, String pictureFileName) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.picture = pictureFileName;
    }

    public String getPicture() {
        return picture;
    }
}
