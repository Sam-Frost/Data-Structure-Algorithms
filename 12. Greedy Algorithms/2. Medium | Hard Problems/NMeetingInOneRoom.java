/*
 * Time Complexity: O(N log N) due to sorting
 * Space Complexity: O(N) for storing meeting intervals
 */
import java.util.Arrays;

public class NMeetingInOneRoom {

    public int maxMeetings(int[] start, int[] end) {

        Node[] arr = new Node[start.length];

        for (int i = 0; i < start.length; i++) {
            arr[i] = new Node(start[i], end[i]);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.end, b.end));

        int count = 1;

        int endTime = arr[0].end;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].start > endTime) {
                count++;
                endTime = arr[i].end;
            }
        }

        return count;
    }

    class Node {

        int start;
        int end;

        // Constructor
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
