import models.*;
import service.ParseInput;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int GetCommonTags(Photo photo1, Photo photo2) {
        int commonTags = 0;
        for (int i = 0; i < photo1.getTags().size(); i++) {
            System.out.println("1:"+photo1.getTags().get(i));
            for (int j = 0; j < photo2.getTags().size(); j++) {
                System.out.println("1:"+photo2.getTags().get(j));
                if (photo1.getTags().get(i).compareTo(photo2.getTags().get(j)) == 0) {
                    System.out.println("common");
                    commonTags++;
                    break;
                }
            }
        }

        return commonTags;
    }

    public static Photo GetBestVerticalPair(Photo photo,  List<Photo> photosTMP) {
        int maxtogether = 0;
        Photo bestPairPhoto = new Photo();
        for (Photo photo1 : photosTMP) {
            int common = GetCommonTags(photo, photo1);
            int together = photo.getTags().size() + photo1.getTags().size() - common;

            if (together > maxtogether) {
                bestPairPhoto = photo1;
            }

            System.out.println("photo2 tags: "+photo.getTags().size());
            System.out.println("photo1 tags: "+photo1.getTags().size());
            System.out.println("common: "+common);
            System.out.println("interest: " + Math.min(photo.getTags().size() - common,Math.min(common,photo1.getTags().size()- common)));
        }

       // photosTMP.remove(bestPairPhoto);

        return bestPairPhoto;
    }

    public static void main(String[] args) throws Exception {

        if (args.length < 1) {
            throw new Exception("Invalid number of input args");
        }
        String fileName = args[0];

        List<Photo> photos = ParseInput.parseInput(fileName);

        System.out.println(photos.size());

        ArrayList<Slide> slides = new ArrayList<>(); //parse
        // go through all vertical photos and make pairs with most different tags together
        // add them as slides

        Slide slide;
        Photo photo;
        for (int i = 0; i < photos.size(); i++) {
            photo = photos.get(i);
            System.out.println("i:"+i);
            System.out.println("photo num:"+photo.getNumOfTags());
            if (photo.getOrientation() == Photo.Orientation.HORIZONTAL) {
                slide = new Slide(/*photo*/);
            } else {
                //find most different pair to this vertical
                // minimal common, max together
                Photo bestPair = GetBestVerticalPair(photo, photos);



                slide = new Slide(/*photo*/);
            }
            slides.add(slide);
        }
    }


// go through all slides and search for best pairs for every image

}
