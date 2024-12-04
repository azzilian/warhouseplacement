import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.example.FindOptimalPoint;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindOptimalPointTest {

    private static HashMap<Integer, int[]> residents;

    @BeforeAll
    public static void setUp() {
        residents = new HashMap<>();
        residents.put(1, new int[]{1, 1});
        residents.put(8, new int[]{1, 2});
        residents.put(45, new int[]{1, 3});
        residents.put(65, new int[]{2, 1});
        residents.put(5, new int[]{2, 2});
        residents.put(63, new int[]{2, 3});
        residents.put(32, new int[]{3, 1});
        residents.put(31, new int[]{3, 2});
        residents.put(1, new int[]{3, 3});
    }

    @Test
    public void testFindOptimalPlacement() {
        int[] expectedOptimalPoint = {2, 3};
        int[] actualOptimalPoint = FindOptimalPoint.findOptimalPlacement(residents);

        assertArrayEquals(expectedOptimalPoint, actualOptimalPoint, "Optimal placement for warehouse should be at: (2, 2)");
    }
}
