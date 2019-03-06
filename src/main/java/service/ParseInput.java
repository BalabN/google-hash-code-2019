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
            // nastavimo buffered reader na konstrukt od file Nama
            bufferedReader = new BufferedReader(new FileReader(this.fileName + ".txt"), buffersize);
            List<String> result = new ArrayList<>();
            int id = 0;

            // stem dobim prvo linijo
            String line = bufferedReader.readLine();

            while( (line = bufferedReader.readLine() ) != null) {
                System.out.printf(line.concat("\n"));
                result.add(line.concat("\n"));
            }
            //result je pr men content!!!!
            String[] firstLine = result.get(0).split(" ");
//            System.out.println("firstLine je " + firstLine);

//            System.out.println("result je " + result.get(0));

            List<Photo> gallery = new ArrayList<>();
            Iterator<String> iterator = result.iterator();
            iterator.hasNext();

            for(int i = 0; iterator.hasNext(); i++){
                String line3 = iterator.next();
                String[] line3Traits = line3.split(" ");
                Photo photo = new Photo();
                List<String> photoTraits = new ArrayList<>();

                for(int j = 0; j < line3Traits.length; j++){
                    if(j == 0){
                        if(line3Traits[j].toLowerCase().equals("h")){
                            photo.setOrientation(Photo.Orientation.HORIZONTAL);
                        } else {
                            photo.setOrientation(Photo.Orientation.VERTICAL);
                        }
                    } else if (j == 1){
                            photo.setNumOfTags(Integer.parseInt(line3Traits[j]));
                    } else {
                        photoTraits.add(line3Traits[j]);
                    }

                }
                photo.setTags(photoTraits);
                photo.setId(id);
                gallery.add(photo);
                id++;

                System.out.println("gallery " + gallery);
                return gallery;
            }

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

    public static String printOutput(List<Slide> slides) throws IOException {

        TypeTester t = new TypeTester();

        File file = new File("C:\\Users\\Lenovo\\Documents\\google-hash-code-2019\\aTry2.txt");

        // creates the file
        file.createNewFile();

        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file);


        String content = Integer.toString(slides.size());
       // content = content.concat("\n");
        writer.write(" ");



        for(int i = 0; i < slides.size(); i++){
            Slide slide = slides.get(i);
            int numPhotos = slide.getPhotos().size();
            for (int j = 0; j < numPhotos; j++) {
                content = content.concat(String.valueOf(slide.getPhotos().get(j).getId()));
                content = content.concat(" ");
            }
            if (i != slides.size() - 1) {
                content = content.concat("\n");
            }
        }
        writer.write(content);
        System.out.println("content nakoncu je " + content);
        writer.close();
        return content;
    }

}
