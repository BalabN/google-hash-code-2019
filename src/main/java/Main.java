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
        List<Photo> photos = new ArrayList<>();

        String [] inputs = {"b_lovely_landscapes"};
        for(String in: inputs){
            String fileName2 = "C:\\Users\\Lenovo\\Documents\\google-hash-code-2019\\" + in;
            ParseInput parseInput = new ParseInput(fileName2);
            System.out.println("For stavek Konec main" + fileName2);
            photos = parseInput.inputParser();

//            System.out.println("rezultat od input parserja tvojga " + parseInput.inputParser());
        }
        System.out.println("photos " + photos.toString());


//        List<Photo> photos = ParseInput.parseInput(fileName);


        System.out.println("fileName args" + fileName);
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
            if ((usedSlides.size() == slides.size()) || usedSlides.size() == 690)
                break;
            // for (int i = 0; i < slides.size(); i++){
            Slide pair = SlideshowGenerator.GetBestSlidePair(currentSlide, slides, usedSlides);

            usedSlides.add(pair);
            slideshowTest.add(pair);
            currentSlide = pair;
        }


        ParseInput.printOut(slideshowTest, "bOut_Test2");


        // }
    }
// go through all slides and search for best pairs for every image

}
