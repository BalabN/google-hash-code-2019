package logic;

import models.Photo;
import models.Slide;

import java.util.ArrayList;
import java.util.List;

public class SlideshowGenerator {

    public static List<Slide> GetSlides(List<Photo> photos) {//parse
        // go through all vertical photos and make pairs with most different tags together
        // add them as slides
        List<Photo> usedPhotos = new ArrayList<>();
        List<Slide> slides = new ArrayList<>();
        Slide slide;
        Photo photo;
        int slideId = 0;
        for (int i = 0; i < photos.size(); i++) {

            photo = photos.get(i);
            if (usedPhotos.contains(photo))
                continue;
            System.out.println(photo.getId());
            if (photo.getOrientation() == Photo.Orientation.HORIZONTAL) {
                slide = new Slide(slideId, photo);
                slide.setTags(photo.getTags());
                slide.setNumOfTags(photo.getNumOfTags());
                slideId++;
            } else {
                //find most different pair to this vertical
                // minimal common, max together
                Photo bestPair = GetBestVerticalPair(photo, photos, usedPhotos,true); // boolean leastCommon if true search for least common else most common

                int common = GetCommonTags(photo, bestPair);
                int together = photo.getTags().size() + bestPair.getTags().size() - common;
                System.out.println("together: " + together);
                slide = new Slide(slideId, photo,bestPair);
                slide.setTags(photo.getTags());
                slide.setNumOfTags(photo.getNumOfTags());
                slideId++;
                usedPhotos.add(bestPair);
            }
            usedPhotos.add(photo);
            slides.add(slide);
        }
        return slides;
    }

    public static int GetCommonTags(Photo photo1, Photo photo2) {
        int commonTags = 0;
        for (int i = 0; i < photo1.getTags().size(); i++) {
            //System.out.println("1:" + photo1.getTags().get(i));
            for (int j = 0; j < photo2.getTags().size(); j++) {
                //System.out.println("2:" + photo2.getTags().get(j));
                if (photo1.getTags().get(i).compareTo(photo2.getTags().get(j)) == 0) {
                    System.out.println("common");
                    commonTags++;
                    break;
                }
            }
        }

        return commonTags;
    }

    public static int GetCommonTagsSlides(Slide slide1, Slide slide2) {
        int commonTags = 0;
        for (int i = 0; i < slide1.getTags().size(); i++) {
            //System.out.println("1:" + photo1.getTags().get(i));
            for (int j = 0; j < slide2.getTags().size(); j++) {
                //System.out.println("2:" + photo2.getTags().get(j));
                if (slide1.getTags().get(i).compareTo(slide2.getTags().get(j)) == 0) {
                    System.out.println("common");
                    commonTags++;
                    break;
                }
            }
        }

        return commonTags;
    }

    public static Photo GetBestVerticalPair(Photo photo,  List<Photo> photos, List<Photo>usedPhotos, boolean leastCommon) {
        int maxtogether = 0;
        int maxCommon = 0;
        Photo bestPairPhoto = new Photo();
        for (Photo photo1 : photos) {
            if (usedPhotos.contains(photo))
                continue;
            if (photo1.getOrientation() == Photo.Orientation.VERTICAL) {

                int common = GetCommonTags(photo, photo1);
                int together = photo.getTags().size() + photo1.getTags().size() - common;

                if (leastCommon){
                    if (together > maxtogether) {
                        bestPairPhoto = photo1;
                        maxtogether = together;
                    }
                }
                else {
                    if (common > maxCommon) {
                        bestPairPhoto = photo1;
                        maxCommon = common;
                    }
                }

                System.out.println("common: " + common);
//            System.out.println("photo2 tags: "+photo.getTags().size());
//            System.out.println("photo1 tags: "+photo1.getTags().size());
//            System.out.println("common: "+common);
                // System.out.println("interest: " + Math.min(photo.getTags().size() - common, Math.min(common, photo1.getTags().size() - common)));
            }
        }
        System.out.println("maxtogether: " + maxtogether);
        // photosTMP.remove(bestPairPhoto);

        return bestPairPhoto;
    }

}