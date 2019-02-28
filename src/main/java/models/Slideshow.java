package models;

import java.util.List;

public class Slideshow {

    private List<Slide> slideList;

    public Slideshow(List<Slide> slideList) {
        this.slideList = slideList;
    }

    public long calculateScore() {
        //TODO: calcute the score of the slideshow
        return 0L;
    }

    public String toString() {
        StringBuilder toString = new StringBuilder(Long.toString(slideList.size())).append("\n");
        for(Slide slide : slideList) {
            toString.append(slide.toString()).append("\n");
        }
        return toString.toString();
    }
}
