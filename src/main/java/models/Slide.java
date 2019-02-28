package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Slide {

    private List<Photo> photoList;
    private Set<String> tags;

    public Slide(List<Photo> photoList) {
        this.photoList = photoList;
        this.tags = new HashSet<>();
        for(Photo photo : photoList) {
            this.tags.addAll(photo.getTags());
        }
    }

    public Slide(Photo photo) {
        this.photoList = new ArrayList<>();
        photoList.add(photo);
        this.tags = new HashSet<>(photo.getTags());
    }

    public String toString() {
        StringBuilder toString = new StringBuilder();
        for(Photo photo : photoList) {
            toString.append(photo.toString()).append(" ");
        }
        return toString.toString();
    }
}
