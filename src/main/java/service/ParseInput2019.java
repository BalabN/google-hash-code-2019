package service;

import models.Photo;
import models.Slide;
import models.Slideshow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ParseInput2019 {

    public static List<Photo> getPhotosFromFile(String fileName) {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            List<Photo> photos = new ArrayList<>();
            long N = Long.parseLong(br.readLine());
            for(int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                boolean orientation = line[0].equals("H");
                HashSet<String> tags = new HashSet<>(Arrays.asList(line).subList(1, line.length));
                photos.add(new Photo(i, orientation, tags));
            }
            return photos;
        } catch (IOException ioe) {
            System.out.println("WTF IS WRONG WITH YOU? " + ioe.getMessage());
            ioe.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static Slideshow getSlideshow(String fileName) {
        List<Photo> photos = getPhotosFromFile(fileName);
        List<Slide> slides = new ArrayList<>();
        List<Photo> lastPhoto = new ArrayList<>();
        for(Photo photo : photos) {
            if(photo.isOrientation()) {
                slides.add(new Slide(photo));
            } else {
                if(!lastPhoto.isEmpty()) {
                    lastPhoto.add(photo);
                    slides.add(new Slide(lastPhoto));
                } else {
                    lastPhoto = new ArrayList<>();
                    lastPhoto.add(photo);
                }
            }
        }
        return new Slideshow(slides);
    }
}
