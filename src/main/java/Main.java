import models.Photo;
import models.Slideshow;
import service.ParseInput2019;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length < 1) {
            throw new Exception("Invalid number of input args");
        }
        String fileName = args[0];
        List<Photo> photos = ParseInput2019.getPhotosFromFile(fileName);
//        Slideshow slideshow = ParseInput2019.getSlideshowFromFile(fileName);
        Slideshow slideshow = ParseInput2019.getSlideshow(photos);
        System.out.println("Score: " + slideshow.calculateScore());
        System.out.println("Slideshow:\n" + slideshow.toString());
    }
}
