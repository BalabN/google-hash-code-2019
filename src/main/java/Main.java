import models.Car;
import models.Ride;
import models.Slideshow;
import service.ParseInput2019;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length < 1) {
            throw new Exception("Invalid number of input args");
        }
        String fileName = args[0];
        Slideshow slideshow = ParseInput2019.getSlideshow(fileName);
        System.out.println(slideshow.toString());
    }
}
