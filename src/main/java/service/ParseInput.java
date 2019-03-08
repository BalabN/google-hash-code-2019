package service;
import models.Photo;
import models.Slide;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseInput {

    private String fileName;

    public ParseInput(String filename){
        this.fileName = filename;
    }


    public List<Photo> inputParser(){
        int buffersize = 8 * 1024;
        BufferedReader bufferedReader = null;

        try{
            bufferedReader = new BufferedReader(new FileReader(this.fileName + ".txt"), buffersize);
            List<String> result = new ArrayList<>();
            int id = -1;

            List<Photo> gallery = new ArrayList<>();
            String line = bufferedReader.readLine();


            while( (line = bufferedReader.readLine() ) != null) {
                Photo photo = new Photo();
                List<String> tags = new ArrayList<>();
                String[] lines = line.split(" ", 4);
                id++;

                if (lines.length != 4) { // Not enough tokens (e.g., empty line) read
                    continue;
                }
//                System.out.println("linije" + Arrays.toString(lines));
                for(int i = 0; i <lines.length; i++){
                    if(i == 0){
                        if(lines[0].toLowerCase().equals("h")){
                            photo.setOrientation(Photo.Orientation.HORIZONTAL);
                        } else {
                            photo.setOrientation(Photo.Orientation.VERTICAL);
                        }
                    } else if(i == 1){
                        photo.setNumOfTags(Integer.parseInt(lines[1]));
                    } else {
                        tags.add(lines[i]);
                    }
                }

                System.out.println("id je " + id);
                photo.setId(id);
                photo.setTags(tags);
                gallery.add(photo);

//                System.out.println("Line 54: " + gallery.toString());
//                System.out.println("Line 55: " + gallery.size());
            }
            return gallery;

// System.out.println("Line xx: ");

        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void outputParser(){

    }

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

    public static String printOut(List<Slide> slides, String fileName) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter( fileName + ".out", "UTF-8");

            System.out.println("printOut number of slides" + slides.size());

            int numOfSlides = slides.size();
            String content = Integer.toString(numOfSlides);
            writer.print(content);
            writer.println();

            for(int i = 0; i < numOfSlides; i++){
                Slide slide = slides.get(i);
                int numOfPhotos = slide.getPhotos().size();
//                System.out.println("output slides are" + slide.toString());
                for(int j = 0; j< numOfPhotos; j++){
                    if(slide.getPhotos().size() == 2){
                        content = String.valueOf(slide.getPhotos().get(j).getId()).concat(" ");
                        writer.print(content);
                    } else{
                        content = String.valueOf(slide.getPhotos().get(j).getId());
                        writer.print(content);
                        writer.println();
                    }

                    System.out.println("content je " + content);
                }

            }

            writer.close();






        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return "";
    }

}
