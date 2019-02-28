package models;
import java.util.List;

public class Slideshow {

    private List slideList;
    private int score;

    public List getSlideList(){
        return slideList;
    }
    public int getScore(){
        return score;
    }

    public void  setScore(int score){
        this.score = score;
    }

    public void setSlideList(List slideList){
        this.slideList = slideList;
    }

}
