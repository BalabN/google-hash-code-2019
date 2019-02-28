import models.Car;
import models.Ride;
import models.World;
import service.ParseInput;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length < 1) {
            throw new Exception("Invalid number of input args");
        }
        String fileName = args[0];
        World world = ParseInput.parseInput(fileName);

        for (int i = 0; i < world.getSteps(); i++) {
            for (Car car : world.getCars()) {
                Ride ride = car.calculateCoefficient(world.getRides(), i);
                world.getRides().remove(ride);
            }

            for (Car car : world.getCars()) {
                car.nextStep();
            }
        }

        world.printResult();
    }
}
