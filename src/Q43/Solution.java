package Q43;

public class Solution {
    public String multiply(String num1, String num2) {
        final int len1 = num1.length();
        final int len2 = num2.length();
        int[] result = new int[len1 + len2];
        int index2 = len2 - 1;
        while (index2 >= 0) {
            int index1 = len1 - 1;
            int digit2 = num2.charAt(index2) - '0';
            while (index1 >= 0) {
                int digit1 = num1.charAt(index1) - '0';
                int localResult =  digit1 * digit2;
                int baseIndex = len1-index1+len2-index2-2;
                result[baseIndex] = result[baseIndex] + localResult % 10;
                result[baseIndex+1] = result[baseIndex+1] + localResult / 10;
                index1--;
            }
            index2--;
        }
        int index = 0;
        while (index < len1 + len2 - 1) {
            if (result[index] > 9) {
                result[index+1] = result[index+1] + result[index] / 10;
                result[index] = result[index] % 10;
            }
            index++;
        }

        StringBuilder s = new StringBuilder();
        index = len1 + len2 - 1;
        while (index >= 0 && result[index] == 0) {
            index--;
        }
        while (index >= 0) {
            s.append(result[index]);
            index--;
        }
        if (s.isEmpty()) {
            s.append(0);
        }
        return s.toString();
    }
}
