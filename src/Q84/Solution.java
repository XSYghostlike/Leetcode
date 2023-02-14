package Q84;

import java.util.LinkedList;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] maxRecWithBar = new int[len];
        int[] leftEnd = new int[len];
        LinkedList<Integer> barStack = new LinkedList<>();
        for (int i=0;i<len;i++) {
            if (barStack.isEmpty() || heights[barStack.peekLast()] < heights[i]) {
                barStack.add(i);
                leftEnd[i] = i;
            } else if (heights[barStack.peekLast()] == heights[i]) {
                leftEnd[i] = leftEnd[barStack.peekLast()];
                barStack.add(i);
            } else {
                int last = 0;
                while (! barStack.isEmpty() && heights[barStack.peekLast()] > heights[i]) {
                    last = barStack.pollLast();
                    int backCount = i - leftEnd[last];
                    maxRecWithBar[last] = heights[last] * backCount;
                }
                barStack.add(i);
                leftEnd[i] = leftEnd[last];
            }
        }

        while (! barStack.isEmpty()) {
            int last = barStack.pollLast();
            int backCount = len - leftEnd[last];
            maxRecWithBar[last] = heights[last] * backCount;
        }

        int result = Integer.MIN_VALUE;
        for (int i=0;i<len;i++) {
            if (maxRecWithBar[i] > result) {
                result = maxRecWithBar[i];
            }
        }
        return result;
    }
}
