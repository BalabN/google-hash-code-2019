package models;

import java.util.ArrayList;
import java.util.List;

public class Slide {

    private List photos;
    private ArrayList combTags;

    public List getPhotos(){
        return photos;
    }
    public ArrayList getCombTags(){
        return combTags;
    }

    public void setCombTags(ArrayList combTags){
        this.combTags = combTags;
    }

    public void setPhotos(List photos){
        this.photos = photos;
    }


}
