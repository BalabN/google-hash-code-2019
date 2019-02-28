package utlis;

public class MathUtils {
    public static int getMD(Pair<Integer, Integer> startCoordinate, Pair<Integer, Integer> endCoordinate) {
        return Math.abs(endCoordinate.getFirst()-startCoordinate.getFirst()) + Math.abs(endCoordinate.getSecond()-startCoordinate.getSecond());
    }
}
