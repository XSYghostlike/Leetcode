package Q283;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = new int[]{0, 1};
        s.moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }
}
