package models;

import java.util.List;

public class Photo {

    public enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    private int id;
    private Orientation orientation;
    private List<String> tags;

    public Orientation getOrientation(){
        return orientation;
    }

    public int getId(){
        return id;
    }

    public List<String> getTags (){
        return tags;
    }

    public void setTags(List<String> tags){
        this.tags = tags;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setOrientation(Orientation orientation){
        this.orientation = orientation;
    }
}
