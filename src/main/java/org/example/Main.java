import java.util.HashMap;
import org.example.FindOptimalPoint;
import org.example.service.MapGenerator;

public class Main {
    public static final int X_COORDINATE_INDEX = 0;
    public static final int Y_COORDINATE_INDEX = 1;
    public static final int ROWS_COUNT = 4;
    public static final int COLUMNS_COUNT = 5;

    private static FindOptimalPoint findOptimalPoint;

    public static void main(String[] args) {
        HashMap<Integer, int[]> residents = new HashMap<>();
        residents.put(1, new int[]{1, 1});
        residents.put(8, new int[]{1, 2});
        residents.put(45, new int[]{1, 3});
        residents.put(65, new int[]{2, 1});
        residents.put(5, new int[]{2, 2});
        residents.put(63, new int[]{2, 3});
        residents.put(32, new int[]{3, 1});
        residents.put(31, new int[]{3, 2});
        residents.put(1, new int[]{3, 3});


        int[] optimalPoint = FindOptimalPoint.findOptimalPlacement(residents);
        System.out.println("Optimal placement for warehouse is at: ("
                + optimalPoint[X_COORDINATE_INDEX]
                + ", "
                + optimalPoint[Y_COORDINATE_INDEX]
                + ")");

        int[] optimalPointRandom = FindOptimalPoint.findOptimalPlacement(MapGenerator.generateRandomRectangularMap(ROWS_COUNT, COLUMNS_COUNT));
        System.out.println("Optimal placement for warehouse is at: ("
                + optimalPointRandom[X_COORDINATE_INDEX]
                + ", "
                + optimalPointRandom[Y_COORDINATE_INDEX]
                + ")");
    }
}
