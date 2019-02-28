package models;

import java.util.ArrayList;
import java.util.List;

public class Slide {

    public int id;
    public Photo photo1;
    public Photo photo2;
    public Photo.Orientation orientation;

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
}
