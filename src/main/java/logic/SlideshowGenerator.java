package logic;

import models.Photo;
import models.Slide;

import java.util.ArrayList;
import java.util.List;

public class SlideshowGenerator {

    public static List<Slide> GetSlies(List<Photo> photos) {//parse
        // go through all vertical photos and make pairs with most different tags together
        // add them as slides

        List<Slide> slides = new ArrayList<>();
        Slide slide;
        Photo photo;
        for (int i = 0; i < photos.size(); i++) {
            photo = photos.get(i);
            if (photo.getOrientation() == Photo.Orientation.HORIZONTAL) {
                slide = new Slide(/*photo*/);
            } else {
                //find most different pair to this vertical
                // minimal common, max together
                Photo bestPair = GetBestVerticalPair(photo, photos);

                int common = GetCommonTags(photo, bestPair);
                int together = photo.getTags().size() + bestPair.getTags().size() - common;
                System.out.println("together: " + together);
                slide = new Slide(/*photo*/);
            }
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

    public static Photo GetBestVerticalPair(Photo photo,  List<Photo> photos) {
        int maxtogether = 0;
        Photo bestPairPhoto = new Photo();
        for (Photo photo1 : photos) {
            if (photo1.getOrientation() == Photo.Orientation.VERTICAL) {

                int common = GetCommonTags(photo, photo1);
                int together = photo.getTags().size() + photo1.getTags().size() - common;

                if (together > maxtogether) {
                    bestPairPhoto = photo1;
                    maxtogether = together;
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