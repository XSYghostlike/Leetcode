package Q224;

class Solution {
    private int eval(String s) {
        int result = 0;
        char currOp = '+';
        int currNum = 0;
        char innerOp = '0';
        int innerNum = 0;
        int i = 0;
        while (i<s.length()) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                if (innerOp == '0') {
                    currNum = currNum * 10;
                    currNum = currNum + s.charAt(i) - '0';
                } else {
                    innerNum = innerNum * 10;
                    innerNum = innerNum + s.charAt(i) - '0';
                }
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (innerOp == '*') {
                    currNum = currNum * innerNum;
                    innerOp = '0';
                }
                if (innerOp == '/') {
                    currNum = currNum / innerNum;
                    innerOp = '0';
                }
                if (currOp == '+') {
                    result = result + currNum;
                }
                if (currOp == '-') {
                    result = result - currNum;
                }
                currOp = s.charAt(i);
                currNum = 0;
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (innerOp == '0') {
                    innerOp = s.charAt(i);
                    innerNum = 0;
                } else {
                    if (innerOp == '*') {
                        currNum = currNum * innerNum;
                    }
                    if (innerOp == '/') {
                        currNum = currNum / innerNum;
                    }
                    innerOp = s.charAt(i);
                }
            } else {
                if (s.charAt(i) == '(') {
                    int count = 1;
                    int j;
                    for (j=i+1;j<s.length();j++) {
                        if (s.charAt(j) == '(') {
                            count++;
                        }
                        if (s.charAt(j) == ')') {
                            count--;
                        }
                        if (count == 0) {
                            break;
                        }
                    }
                    if (innerOp == '0') {
                        currNum = eval(s.substring(i+1,j));
                    } else {
                        innerNum = eval(s.substring(i+1,j));
                    }
                    i=j;
                }
            }
            i++;
        }
        if (innerOp == '*') {
            currNum = currNum * innerNum;
        }
        if (innerOp == '/') {
            currNum = currNum / innerNum;
        }
        if (currOp == '+') {
            result = result + currNum;
        }
        if (currOp == '-') {
            result = result - currNum;
        }
        return result;
    }

    public int calculate(String s) {
        return eval(s);
    }
}
