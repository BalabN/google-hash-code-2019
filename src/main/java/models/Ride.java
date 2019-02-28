package models;

import utlis.Pair;

public class Ride {

    private int id;
    private Pair<Integer, Integer> rideStart;
    private Pair<Integer, Integer> rideEnd;
    private int earliestStart;
    private int latestFinish;

    public Ride(String line, int id) {
        this.id = id;
        String[] content = line.split(" ");
        this.rideStart = new Pair<>(Integer.parseInt(content[0]), Integer.parseInt(content[1]));
        this.rideEnd = new Pair<>(Integer.parseInt(content[2]), Integer.parseInt(content[3]));
        this.earliestStart = Integer.parseInt(content[4]);
        this.latestFinish = Integer.parseInt(content[5]);
    }

    public Ride(int a, int b, int x, int y, int earliestStart, int latestFinish) {
        this.rideStart = new Pair<>(a, b);
        this.rideEnd = new Pair<>(x, y);
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    public Ride(Pair<Integer, Integer> rideStart, Pair<Integer, Integer> rideEnd, int earliestStart, int latestFinish) {
        this.rideStart = rideStart;
        this.rideEnd = rideEnd;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pair<Integer, Integer> getRideStart() {
        return rideStart;
    }

    public void setRideStart(Pair<Integer, Integer> rideStart) {
        this.rideStart = rideStart;
    }

    public Pair<Integer, Integer> getRideEnd() {
        return rideEnd;
    }

    public void setRideEnd(Pair<Integer, Integer> rideEnd) {
        this.rideEnd = rideEnd;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(int earliestStart) {
        this.earliestStart = earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(int latestFinish) {
        this.latestFinish = latestFinish;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", rideStart[0]=" + rideStart.getFirst() + "rideStart[1]=" + rideStart.getSecond() +
                ", rideEnd[0]=" + rideEnd.getFirst() + ", rideEnd[1]=" + rideEnd.getSecond() +
                ", earliestStart=" + earliestStart +
                ", latestFinish=" + latestFinish +
                '}';
    }
}
