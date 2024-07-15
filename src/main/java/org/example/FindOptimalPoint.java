package org.example;

import java.util.*;

public class FindOptimalPoint {

    public static final int X_COORDINATE_INDEX = 0;
    public static final int Y_COORDINATE_INDEX = 1;
    public static final int TRIPS_COUNT_INDEX = 2;

    public static int[] findOptimalPlacement(HashMap<Integer, int[]> residents) {
        List<int[]> weightedPoints = new ArrayList<>();

        for (Map.Entry<Integer, int[]> entry : residents.entrySet()) {
            int trips = entry.getKey();
            int[] coordinates = entry.getValue();
            weightedPoints.add(new int[]{coordinates[X_COORDINATE_INDEX], coordinates[Y_COORDINATE_INDEX], trips});
        }

        weightedPoints.sort(Comparator.comparingInt(a -> a[X_COORDINATE_INDEX]));
        int medianX = findWeightedMedian(weightedPoints);

        weightedPoints.sort(Comparator.comparingInt(a -> a[Y_COORDINATE_INDEX]));
        int medianY = findWeightedMedian(weightedPoints);

        return new int[]{medianX, medianY};
    }

    private static int findWeightedMedian(List<int[]> weightedPoints) {
        int totalWeight = weightedPoints.stream()
                .mapToInt(a -> a[TRIPS_COUNT_INDEX])
                .sum();
        int cumulativeWeight = 0;

        for (int[] point : weightedPoints) {
            cumulativeWeight += point[TRIPS_COUNT_INDEX];
            if (cumulativeWeight >= totalWeight / 2) {
                return point[0];
            }
        }
        return weightedPoints.get(weightedPoints.size() - 1)[X_COORDINATE_INDEX];
    }
}
