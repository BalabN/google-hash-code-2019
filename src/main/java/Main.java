import logic.SlideshowGenerator;
import models.*;
import service.ParseInput;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new Exception("Invalid number of input args");
        }
        String fileName = args[0];

        List<Photo> photos = ParseInput.parseInput(fileName);
        List<Photo> usedPhotos = new ArrayList<>();

        System.out.println(photos.size());

        List<Slide> slides = SlideshowGenerator.GetSlides(photos);

        for (int i = 0; i < slides.size(); i++){
            System.out.println("slide " + slides.get(i).id);
            System.out.println("orientation " + slides.get(i).orientation);
            if (slides.get(i).orientation == Photo.Orientation.HORIZONTAL){
                System.out.println("photo1 " + slides.get(i).photo1.getId());
            }else {
                System.out.println("photo1 " + slides.get(i).photo1.getId());
                System.out.println("photo2 " + slides.get(i).photo2.getId());
            }

        }
    }
// go through all slides and search for best pairs for every image

}
