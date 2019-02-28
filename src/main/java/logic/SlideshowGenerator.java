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
                System.out.println("slideId: " + slide.getId());
                System.out.println("slideId size: " + slide.getTags().size());
                slide.setNumOfTags(photo.getNumOfTags());
                System.out.println("setNumOfTags: " + slide.getNumOfTags());
                slideId++;
            } else {
                //find most different pair to this vertical
                // minimal common, max together
                Photo bestPair = GetBestVerticalPair(photo, photos, usedPhotos, true); // boolean leastCommon if true search for least common else most common

                int common = GetCommonTags(photo, bestPair);
                int together = photo.getTags().size() + bestPair.getTags().size() - common;
                System.out.println("together: " + together);
                slide = new Slide(slideId, photo,bestPair);

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

        int slides1 = slide1.getTags().size();
        int slides2 = slide2.getTags().size();

        for (int i = 0; i < slides1; i++) {
            for (int j = 0; j < slides2; j++) {
                if (slide1.getTags().get(i).equals(slide2.getTags().get(j))) {
                    System.out.println("slide common");
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

                if (leastCommon) {
                    if (together > maxtogether) {
                        bestPairPhoto = photo1;
                        maxtogether = together;
                    }
                } else {
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

    public static Slide GetBestSlidePair(Slide slide, List<Slide> slides, List<Slide> usedSlides) {
        int maxInterest = 0;
        Slide bestPairSlide = new Slide();
        for (Slide slide1 : slides) {
            if (usedSlides.contains(slide1))
                continue;

            int common = GetCommonTagsSlides(slide, slide1);
            int restSlide = slide.getNumOfTags() - common;
            int restSlide1 = slide1.getNumOfTags() - common;
            int interest = Math.min(restSlide, Math.min(common, restSlide1));

            if (interest > maxInterest) {
                bestPairSlide = slide1;
                maxInterest = interest;
            }

        }

        return bestPairSlide;
    }

}