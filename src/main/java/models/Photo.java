package models;

import java.util.List;

public class Photo {

    enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    private int id;
    private Orientation orientation;
    private List tags;

    public Orientation getOrientation(){
        return orientation;
    }

    public int getId(){
        return id;
    }

    public List getTags (){
        return tags;
    }

    public void setTags(List tags){
        this.tags = tags;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setOrientation(Orientation orientation){
        this.orientation = orientation;
    }
}
