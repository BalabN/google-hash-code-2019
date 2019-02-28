package models;

import java.util.ArrayList;
import java.util.List;

import utlis.MathUtils;
import utlis.Pair;

public class Car {
    private Pair<Integer, Integer> currentPosition = new Pair<>(0,0);
    private int currentSteps = -1;
    private List<Pair<Ride, Float>> rides = new ArrayList<>();
    private int distanceToStart;
    private int distanceToEnd;
    private int currentRideIndex = -1;
    private boolean isDriving;
    private int hasPassenger;

    public Car() {
    }


    public void addRide(Ride ride, Float k) {
        rides.add(new Pair<>(ride, k));
    }

    public Ride calculateCoefficient(List<Ride> rides, int worldStep) {
        float tempK;
        float k = Integer.MAX_VALUE;
        Ride minRide = null;
        for (Ride ride : rides) {
            if (!isDriving) {
                tempK = (ride.getEarliestStart() - worldStep) +
                    ((MathUtils.getMD(currentPosition, ride.getRideStart()) + MathUtils.getMD(ride.getRideStart(), ride.getRideEnd())) /
                     (ride.getEarliestStart() - ride.getLatestFinish()));
            } else {
                tempK = (ride.getEarliestStart() - worldStep) +
                    (currentSteps +
                     (MathUtils.getMD(currentPosition, ride.getRideStart()) + MathUtils.getMD(ride.getRideStart(), ride.getRideEnd())) /
                     (ride.getEarliestStart() - ride.getLatestFinish()));
            }

            if (tempK < k) {
                k = tempK;
                minRide = ride;
            }
        }
        if (minRide != null) {
            addRide(minRide, k);
        }
        return minRide;
    }

    public void nextStep() {
        updateCurrentPosition();

        if (currentSteps > -1) {
            currentSteps--;
        }
    }

    private void updateCurrentPosition() {
        if(this.currentRideIndex <= -1) {
            return;
        }
        Ride currentRide = this.rides.get(this.currentRideIndex).getFirst();
        Pair finalDestination = currentRide.getRideEnd();
        int x = currentPosition.getFirst(), y = currentPosition.getSecond();
        if (((Integer) finalDestination.getFirst()) < currentPosition.getFirst()) {
            x -= 1;
        } else if (((Integer) finalDestination.getFirst()) > currentPosition.getFirst()) {
            x += 1;
        }

        if (((Integer) finalDestination.getSecond()) > currentPosition.getSecond()) {
            y += 1;
        } else if (((Integer) finalDestination.getSecond()) < currentPosition.getSecond()) {
            y -= 1;
        }

        this.currentPosition = new Pair<>(x, y);
    }

    public List<Pair<Ride, Float>> getRides() {
        return rides;
    }
}
