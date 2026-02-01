package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int [][]intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println("Merge Intervals: " + Arrays.deepToString(merge(intervals)));
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals,(a, b)->Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for(int[] interval: intervals){
            if(interval[0]<=newInterval[1]){
                newInterval[1]= Math.max(interval[1],newInterval[1]);
            }
            else{
                newInterval= interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}

/*
Step-by-Step Explanation

Base Case:
        if (intervals.length <= 1)
        return intervals;
If the input has only one interval or no intervals at all, the result is simply the input itself because there is nothing to merge.

Sorting the Intervals:
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
The intervals are sorted by their starting point (the first element in each interval). Sorting is essential to ensure we can sequentially check for overlaps and merge them in an orderly fashion.

Example:
Before Sorting: [[1,3],[2,6],[8,10],[15,18]]
After Sorting:  [[1,3],[2,6],[8,10],[15,18]] (already sorted in this case)

Merging Intervals:
List<int[]> result = new ArrayList<>();
int[] newInterval = intervals[0];
result.add(newInterval);
We initialize the result list (result) that will hold the merged intervals.
We also set the first interval (intervals[0]) as the current interval (newInterval) and add it to the result list.

Loop through the intervals:
        for (int[] interval : intervals) {
        if (interval[0] <= newInterval[1])
newInterval[1] = Math.max(newInterval[1], interval[1]);
    else {
newInterval = interval;
        result.add(newInterval);
    }
            }
Condition 1 (Overlapping Intervals):

If the start of the current interval (interval[0]) is less than or equal to the end of the newInterval (newInterval[1]), this means that the intervals overlap.
        In this case, we merge them by updating the end of newInterval to the maximum of the current interval’s end and the existing newInterval's end:
newInterval[1] = Math.max(newInterval[1], interval[1]);
This ensures that the newInterval now covers the entire overlapping range.
        Condition 2 (Non-overlapping Intervals):

If the current interval doesn’t overlap with newInterval, we set the current interval as the new newInterval:
newInterval = interval;
We also add this newInterval to the result list since it doesn't overlap with the previous one.

Return the Result:
        return result.toArray(new int[result.size()][]);
After processing all the intervals, we convert the list of arrays (result) back into a 2D array and return it as the output.


T.C = o(nlogn)
*/