package models;

import java.util.List;

public class World {
    private int rows;
    private int cols;
    private List<Car> cars;
    private List<Ride> rides;
    private int bonus;
    private int steps;

    public World(int rows, int cols, List<Car> cars, List<Ride> rides, int bonus, int steps) {
        this.rows = rows;
        this.cols = cols;
        this.cars = cars;
        this.rides = rides;
        this.bonus = bonus;
        this.steps = steps;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "World{" +
                "rows=" + rows +
                ", cols=" + cols +
                ", cars=" + cars +
                ", rides=" + rides +
                ", bonus=" + bonus +
                ", steps=" + steps +
                '}';
    }

    public void printResult() {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            String carOutput = car.getRides().size() + "";
            for (int j = 0; j < car.getRides().size(); j++) {
                carOutput += " " + car.getRides().get(j).getFirst().getId();
            }

            System.out.println(carOutput);
        }
    }
}
