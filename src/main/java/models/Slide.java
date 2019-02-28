package models;

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
}
