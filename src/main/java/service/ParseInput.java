package service;

import models.Car;
import models.Ride;
import models.World;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseInput {

    public static World parseInput(String inputFileName) throws IOException{
        System.out.println("Reading file " + inputFileName);
        Stream<String> stream = Files.lines(Paths.get(inputFileName));
        List<String> content = stream.collect(Collectors.toList());
        String[] firstLine = content.get(0).split(" ");
        int rows = Integer.parseInt(firstLine[0]);
        int cols = Integer.parseInt(firstLine[1]);
        int noCars = Integer.parseInt(firstLine[2]);
        int noRides = Integer.parseInt(firstLine[3]);
        int bonus = Integer.parseInt(firstLine[4]);
        int steps = Integer.parseInt(firstLine[5]);
        List<Car> cars = new ArrayList<>();
        List<Ride> rides = new ArrayList<>();
        for(int i = 0; i < noCars; i++) {
            cars.add(new Car());
        }
        Iterator<String> iterator = content.iterator();
        iterator.next();
        for(int i = 0; iterator.hasNext(); i++) {
            rides.add(new Ride(iterator.next(), i));
        }
        World w = new World(rows, cols, cars, rides, bonus, steps);
        System.out.println(w.toString());
        return w;
    }
}
