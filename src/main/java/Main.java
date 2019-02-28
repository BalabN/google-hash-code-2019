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

        Slideshow slideshow = new Slideshow();

        boolean finish = false;

        Slide currentSlide = slides.get(0);
        List<Slide> usedSlides = new ArrayList<>();
        usedSlides.add(currentSlide);

        List<Slide> slideshowTest = new ArrayList<>();
        slideshowTest.add(currentSlide);
        while (!finish) {
            System.out.println("slides:" + slides.size());
            System.out.println("usedSlides:" + usedSlides.size());
            if ((usedSlides.size() == slides.size()) || usedSlides.size() == 909)
                break;
            // for (int i = 0; i < slides.size(); i++){
            System.out.println("a");
            Slide pair = SlideshowGenerator.GetBestSlidePair(currentSlide, slides, usedSlides);

            System.out.println("ea");
            usedSlides.add(pair);
            slideshowTest.add(pair);
            currentSlide = pair;
        }

        System.out.println(ParseInput.printOutput(slideshowTest));

        System.out.println("end");
        // }
    }
// go through all slides and search for best pairs for every image

}
