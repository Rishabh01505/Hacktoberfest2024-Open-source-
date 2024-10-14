import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<int[]> mergeOverlap(int[][] arr) {
      
        // Sort intervals based on start values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        res.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] curr = arr[i];

            // If current overlaps with the last merged, merge them
            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                // Add current to the result
                res.add(curr);
            }
        }

        return res;
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] arr = {{6, 8}, {1, 9}, {2, 4}, {4, 7}};
        List<int[]> res = mergeOverlap(arr);

        System.out.print("The Merged Intervals are: ");
        for (int[] interval : res) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
    }
}
