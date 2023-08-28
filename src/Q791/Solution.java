package Q791;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i=0;i<order.length();i++) {
            orderMap.put(order.charAt(i), i);
        }
        Character[] arr = new Character[s.length()];
        int loggedIndex = 0;
        int notLoggedIndex = s.length()-1;
        for (int i=0;i<s.length();i++) {
            if (orderMap.containsKey(s.charAt(i))) {
                arr[loggedIndex] = s.charAt(i);
                loggedIndex++;
            } else {
                arr[notLoggedIndex] = s.charAt(i);
                notLoggedIndex--;
            }
        }
        Arrays.sort(arr, 0, loggedIndex, (a, b) -> orderMap.get(a) - orderMap.get(b));
        StringBuilder sb = new StringBuilder();
        for (Character c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}
