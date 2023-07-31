package Q44;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        if (!s.isEmpty() && p.isEmpty()) {
            return false;
        }
        if (s.length() == 1 && p.equals("?")) {
            return true;
        }
        if (p.length() >= 2) {
            String pFirst2 = p.substring(0,2);
            if (pFirst2.equals("**")) {
                return isMatch(s, p.substring(1));
            }
        }
        if (p.equals("*")) {
            return true;
        }
        if (s.isEmpty() && !p.isEmpty()) {
            return false;
        }

        char s0 = s.charAt(0);
        char p0 = p.charAt(0);
        if (s0 == p0) {
            return isMatch(s.substring(1), p.substring(1));
        }
        if (p0 == '?') {
            return isMatch(s.substring(1), p.substring(1));
        }
        if (p0 == '*') {
            return isMatch(s, p.substring(1)) || isMatch(s.substring(1), p.substring(1)) || isMatch(s.substring(1), p);
        }
        return false;
    }
}
