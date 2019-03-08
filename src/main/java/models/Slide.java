package models;

import java.util.ArrayList;
import java.util.List;

public class Slide {

    private int id;
    private Photo photo1;
    private Photo photo2;
    private Photo.Orientation orientation;

    private int numOfTags;


    public Slide(){}

    @Override
    public String toString() {
        return "Slide{" +
                "id=" + id +
                ", photo1=" + photo1 +
                ", photo2=" + photo2 +
                ", orientation=" + orientation +
                ", numOfTags=" + numOfTags +
                '}';
    }

    public Slide(int _id, Photo _photo1){
        id =_id;
        orientation = Photo.Orientation.HORIZONTAL;
        photo1 = _photo1;
        photo2 = null;
    }

    public Slide(int _id, Photo _photo1, Photo _photo2){
        id =_id;
        orientation = Photo.Orientation.VERTICAL;
        photo1 = _photo1;
        photo2 = _photo2;
    }

    public List<String> getTags() {
        List<String> tags = new ArrayList<>(photo1.getTags());
        if (photo2 == null) {
            return photo1.getTags();
        }

        tags.addAll(photo2.getTags());
        return tags;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Photo getPhoto1() {
        return photo1;
    }

    public void setPhoto1(Photo photo1) {
        this.photo1 = photo1;
    }

    public Photo getPhoto2() {
        return photo2;
    }

    public void setPhoto2(Photo photo2) {
        this.photo2 = photo2;
    }

    public List<Photo> getPhotos() {
        List<Photo> photos = new ArrayList<>();
        photos.add(photo1);
        if (photo2 != null) {
            photos.add(photo2);
        }
        return photos;
    }

    public Photo.Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Photo.Orientation orientation) {
        this.orientation = orientation;
    }

    public int getNumOfTags() {
        return numOfTags;
    }

    public void setNumOfTags(int numOfTags) {
        this.numOfTags = numOfTags;
    }
}
