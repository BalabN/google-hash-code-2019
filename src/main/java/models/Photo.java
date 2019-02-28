package models;

import java.util.List;

public class Photo {

    private int id;
    private int orientation;
    private List tags;

    public int getOrientation(){
        return orientation;
    }

    public int id(){
        return id;
    }

    public List tags (){
        return tags;
    }

    public void setTags(List tags){
        this.tags = tags;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setOrientation(int orientation){
        this.orientation = orientation;
    }
}
