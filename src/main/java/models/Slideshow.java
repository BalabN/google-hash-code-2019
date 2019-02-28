package models;

import java.util.ArrayList;

public class Slideshow {

    private ArrayList slideList;
    private int score;

    public ArrayList getSlideList(){
        return slideList;
    }
    public int getScore(){
        return score;
    }

    public void  setScore(int score){
        this.score = score;
    }

    public void setSlideList(ArrayList slideList){
        this.slideList = slideList;
    }

}
