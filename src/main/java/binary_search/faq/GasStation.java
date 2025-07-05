package binary_search.faq;

import java.util.Arrays;
import java.util.PriorityQueue;

public class GasStation {
    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        //System.out.println(gasStation.minimiseMaxDistance(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
        //System.out.println(gasStation.minimiseMaxDistance(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1));
        //System.out.println(gasStation.minimiseMaxDistance(new int[]{3, 6, 12, 19, 33, 44, 67, 72, 89, 95}, 2));
        System.out.println(gasStation.minimiseMaxDistance(new int[]{1, 2, 3, 4}, 5));
    }

    public double minimiseMaxDistance(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        double ans = -1;
        double low = 0;
        double high = Double.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (high < diff) {
                high = diff;
            }
        }
        double mid;
        while (high - low > 0.000001) {
            mid = low + ((high - low) / 2.0);
            int noOfGasStations = getNumberOfGasStations(arr, mid);

            if (noOfGasStations > k) {
                low = mid;
            } else {
                ans = mid;
                high = mid;
            }
        }
        return ans;
    }

    private int getNumberOfGasStations(int[] arr, double maxDistance) {
        int noOfGasStation = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            int numberInBetween = (int) Math.floor(diff / maxDistance);
            if (numberInBetween * maxDistance == diff) {
                numberInBetween--;
            }
            noOfGasStation += numberInBetween;

        }
        return noOfGasStation;
    }

    private static double betterSolution(int[] arr, int k) {
        PriorityQueue<DistanceDiffToGasStation> diffDistance = new PriorityQueue<>(
                (d1, d2) -> {
                    double segment1 = (d1.getDiff() * 1.0) / d1.getCount();
                    double segment2 = (d2.getDiff() * 1.0) / d2.getCount();
                    return Double.compare(segment2, segment1);
                }
        );
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            diffDistance.add(new DistanceDiffToGasStation(diff, 1));
        }

        for (int i = 0; i < k; i++) {
            DistanceDiffToGasStation existingSegment = diffDistance.poll();
            assert existingSegment != null;
            existingSegment.setCount(existingSegment.getCount() + 1);
            diffDistance.add(existingSegment);
        }
        DistanceDiffToGasStation peek = diffDistance.peek();
        assert peek != null;
        return (peek.getDiff() * 1.0) / peek.getCount();
    }

    private static double bruteForceSolution(int[] arr, int k) {
        int[] howMany = new int[arr.length - 1];
        for (int i = 1; i <= k; i++) {
            int maxIndex = -1;
            double maximumSection = Double.MIN_VALUE;
            for (int j = 0; j < arr.length - 1; j++) {
                int diff = arr[j + 1] - arr[j];
                double sectionLength = diff / (howMany[j] + 1.0);

                if (maximumSection < sectionLength) {
                    maximumSection = sectionLength;
                    maxIndex = j;
                }
            }
            howMany[maxIndex]++;
        }

        double maxAns = Double.MIN_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            double sectionLength = (arr[i + 1] - arr[i]) / (howMany[i] + 1.0);
            maxAns = Math.max(maxAns, sectionLength);

        }
        return maxAns;
    }

    static class DistanceDiffToGasStation {
        private final int diff;
        private int count;

        public DistanceDiffToGasStation(int diff, int count) {
            this.diff = diff;
            this.count = count;
        }

        public int getDiff() {
            return diff;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
