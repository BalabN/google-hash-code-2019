package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Slideshow {

    private List<Slide> slideList;

    public Slideshow(List<Slide> slideList) {
        this.slideList = slideList;
    }

    public long calculateScore() {

        int score = 0;
        for (int i = 0; i < slideList.size() - 1; i++) {

            Slide slide1 = slideList.get(i);
            Slide slide2 = slideList.get(i+1);
            int tagSlideOne = slide1.getUniqueTags(slide2).size();
            int tagSlideTwo = slide2.getUniqueTags(slide1).size();
            int tagSlideCom = slide2.getCommonTags(slide1).size();

            score+=Math.min(tagSlideOne,Math.min(tagSlideTwo,tagSlideCom));

        }
        return score;
    }

    public String toString() {
        StringBuilder toString = new StringBuilder(Long.toString(slideList.size())).append("\n");
        for(Slide slide : slideList) {
            toString.append(slide.toString()).append("\n");
        }
        return toString.toString();
    }

    public Slideshow clone() {
        List<Slide> slides = new ArrayList<>();
        for(Slide slide : this.slideList) {
            slides.add(slide.clone());
        }
        return new Slideshow(slides);
    }

    public Photo getBestMatch(List<Photo> photos, Photo photo){

        int score= 0;
        Photo bestMatch=null;
        for (int i = 0; i < photos.size()-1; i++) {
            int tmp=photo.getScore(photos.get(i));
            if (score<tmp)
            {
                score=tmp;
                bestMatch=photos.get(i);
            }
        }
        return bestMatch;
    }
}
