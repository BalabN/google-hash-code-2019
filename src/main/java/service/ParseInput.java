package service;

import models.Photo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseInput {

    public static List<Photo> parseInput(String inputFileName) throws IOException {
        System.out.println("Reading file " + inputFileName);
        Stream<String> stream = Files.lines(Paths.get(inputFileName));
        List<String> content = stream.collect(Collectors.toList());
        String[] firstLine = content.get(0).split(" ");

        int numPhotos = Integer.parseInt(firstLine[0]);
        int id = 0;
        List<Photo> photos = new ArrayList<>();
        Iterator<String> iterator = content.iterator();
        iterator.next();

        for (int i = 0; iterator.hasNext(); i++) {
            String line = iterator.next();
            String[] lineTags = line.split(" ");
            Photo photo = new Photo();
            List<String> tags = new ArrayList<>();

            for (int j = 0; j < lineTags.length; j++) {
                if (j == 0) {
                    if (lineTags[j].toLowerCase().equals("h")) {
                        photo.setOrientation(Photo.Orientation.HORIZONTAL);
                    } else {
                        photo.setOrientation(Photo.Orientation.VERTICAL);
                    }
                } else if (j == 1) {
                    photo.setNumOfTags(Integer.parseInt(lineTags[j]));
                } else {
                    tags.add(lineTags[j]);
                }

            }
            photo.setTags(tags);
            photo.setId(id);
            photos.add(photo);
            id++;
        }
        return photos;
    }
}
