package org.example.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapGenerator {
    public static HashMap<Integer, int[]> generateRandomRectangularMap(int rows, int cols) {
        HashMap<Integer, int[]> residents = new HashMap<>();
        Random random = new Random();

        for (int y = 1; y <= rows; y++) {
            for (int x = 1; x <= cols; x++) {
                int key = random.nextInt(100);
                residents.put(key, new int[]{x, y});
            }
        }

        return residents;
    }
}
