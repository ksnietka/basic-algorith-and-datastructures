package com.ksnietka.intervals;

import java.util.ArrayList;

public class CollapseIntervals {
    static class Inter {
        int max;
        int min;

        Inter(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public boolean isOverlapped(Inter inter) {
            return inter.min > min && inter.min < max || inter.max < max && inter.max > min;
        }

        public void merge(Inter inter) {
            max = Math.max(max, inter.max);
            min = Math.min(min, inter.min);

        }
    }

    private static int sumIntervals(int[][] ints) {
        final ArrayList<Inter> intervals = new ArrayList<>();
        final ArrayList<Inter> toRemove = new ArrayList<>();
        int sum = 0;


        for (int[] interval :ints) {
            intervals.add(new Inter(interval[0], interval[1]));
        }

        for(Inter interval: intervals) {
            for(Inter anotherInterval: intervals) {
                if(interval != anotherInterval && interval.isOverlapped(anotherInterval)) {
                    interval.merge(anotherInterval);
                    toRemove.add(anotherInterval);
                }
            }
        }

        intervals.removeAll(toRemove);

        for(Inter i: intervals) {
            sum += i.max - i.min;
        }
        return sum;
    }
}
