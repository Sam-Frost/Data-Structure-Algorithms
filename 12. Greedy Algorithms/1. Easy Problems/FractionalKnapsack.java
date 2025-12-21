/* 
 * Time Complexity: O(N log N) for sorting the items.
 * Space Complexity: O(N) for the pairs array.
 */

import java.util.Arrays;

public class FractionalKnapsack {

    public double fractionalKnapsack(int[] val, int[] wt, long cap) {

        double totalVal = 0.0;

        Pair[] pairs = new Pair[val.length];

        for (int i = 0; i < val.length; i++) {
            Pair temp = new Pair();

            temp.value = val[i];
            temp.wt = wt[i];
            temp.ratio = (double) val[i] / wt[i];

            pairs[i] = temp;
        }

        // Sort By Ratio
        Arrays.sort(pairs, (a, b) -> Double.compare(b.ratio, a.ratio));

        int i = 0;

        while (i < pairs.length && cap >= 0) {
            if (pairs[i].wt <= cap) {
                totalVal += pairs[i].value;
                cap -= pairs[i].wt;
            } else {
                totalVal += pairs[i].value * ((double) cap / pairs[i].wt);
                cap -= pairs[i].wt * ((double) cap / pairs[i].wt);
            }
            i++;
        }

        return totalVal;
    }
}

class Pair {

    public double ratio;
    public int value;
    public int wt;

    public Pair() {
    }

    public Pair(double ratio, int value, int wt) {
        this.ratio = ratio;
        this.value = value;
        this.wt = wt;
    }
}
