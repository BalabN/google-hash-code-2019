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

    public Slide(Photo photo1, Photo photo2) {
        this.photoList = new ArrayList<>();
        photoList.add(photo1);
        photoList.add(photo2);
        this.tags = new HashSet<>();
        tags.addAll(photo1.getTags());
        tags.addAll(photo2.getTags());
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

    public Set<String> getCommonTags(Slide otherSlide){
        Set<String> Tags1 = new HashSet<>(this.tags);
        Set<String> Tags2 = new HashSet<>(otherSlide.tags);
        Tags1.retainAll(Tags2);
        return Tags1;
    }

    public Set<String> getUniqueTags(Slide otherSlide){
        Set<String> Tags1 = new HashSet<>(this.tags);
        Set<String> Tags2 = new HashSet<>(otherSlide.tags);
        Tags1.removeAll(Tags2);
        return Tags1;
    }

    public int getScore(Slide other) {
        int common = this.getCommonTags(other).size();
        int diffFirst = this.getUniqueTags(other).size();
        int diffSecond = other.getUniqueTags(this).size();
        return Math.min(common, Math.min(diffFirst, diffSecond));
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
