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

        System.out.println(photos.size());

        List<Slide> slides = SlideshowGenerator.GetSlies(photos);
    }
// go through all slides and search for best pairs for every image

}
