import models.*;
import service.ParseInput;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int GetCommonTags(Photo photo1, Photo photo2){
        int commonTags = 0;
        for (int i = 0;  i<photo1.getTags().size(); i++){
            for (int j = 0;  j<photo2.getTags().size(); j++){
                if(photo1.getTags().get(i).compareTo(photo2.getTags().get(j)) == 0){
                    commonTags++;
                    break;
                }
            }
        }

        return commonTags;
    }

    public static void main(String[] args) throws Exception {

        if (args.length < 1) {
            throw new Exception("Invalid number of input args");
        }
        String fileName = args[0];


        ArrayList<Photo> photos = new ArrayList<>(); //parse
        ArrayList<Slide> slides = new ArrayList<>(); //parse
        // go through all vertical photos and make pairs with most different tags together
        // add them as slides

        Slide slide;
        for (Photo photo : photos) {
            if (photo.getOrientation() == Photo.Orientation.HORIZONTAL) {
                slide = new Slide(/*photo*/);
            } else {
                //find most different pair to this vertical
                // minimal common, max together
                int minCommon = 99999, maxtogetgher = 0;
                for (Photo photo1 : photos) {
                    int common = GetCommonTags(photo, photo1);
                    System.out.println("photo2 tags: "+photo.getTags().size());
                    System.out.println("photo1 tags: "+photo1.getTags().size());
                    System.out.println("common: "+common);
                    System.out.println("interest: " + Math.min(photo.getTags().size() - common,Math.min(common,photo1.getTags().size()- common)));
                }
                slide = new Slide(/*photo*/);
            }
            slides.add(slide);
        }
    }


    // go through all slides and search for best pairs for every image

}
