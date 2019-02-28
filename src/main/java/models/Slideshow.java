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

    public static Photo getBestMatch(List<Photo> photos, Photo photo){

        int score= -1;
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

//    public List<Photo> getSlideList(List<Photo> inputList) {
//        List<Photo> orderedPhotos = new ArrayList<>();
//        for (Photo singlePhoto : inputList) {
//            //get only horizontal pictures first
//            if (singlePhoto.isHorizontal()){
//                Photo matchingPhoto = getBestMatch(inputList, singlePhoto);
//                orderedPhotos.add(singlePhoto)
//            }
//        }
//        return slideList;
//    }

    public static List<Photo> recursiveSearch(List<Photo> photos, Photo photo){
        if (photos.isEmpty()) {
            return new ArrayList<>();
        }
        List<Photo> bestList = new ArrayList<>();
        bestList.add(photo);
//        for (Photo currentPhoto : photos){
//            Photo bestMatch = getBestMatch(photos, bestList.get(bestList.size()-1));
//            recursiveSearch(photos.subList(1, photos.size()), )
//        }
        Photo bestMatch = getBestMatch(photos, photo);
        List<Photo> bestMatches = recursiveSearch(photos.subList(1, photos.size()), bestMatch);
        bestList.addAll(new ArrayList<>(bestMatches));
        return bestList;

    }
}
