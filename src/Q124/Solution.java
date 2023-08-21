package Q124;

import java.util.*;

public class Solution {
    public void addToList(TreeNode root, Stack<TreeNode> target) {
        if (root != null) {
            target.add(root);
            addToList(root.left, target);
            addToList(root.right, target);
        }
    }

    public int maxPathSum(TreeNode root) {
        Map<TreeNode, Integer> longestBranch = new HashMap<>();
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> searchQueue = new Stack<>();
        addToList(root, searchQueue);
        while (! searchQueue.isEmpty()) {
            TreeNode top = searchQueue.peek();
            if (top.left == null && top.right == null) {
                longestBranch.put(top, top.val);
                results.add(top.val);
            } else if (top.left != null && top.right != null) {
                results.add(top.val + Math.max(longestBranch.get(top.left), 0) + Math.max(longestBranch.get(top.right), 0));
                longestBranch.put(top, Math.max(Math.max(longestBranch.get(top.left), longestBranch.get(top.right)), 0) + top.val);
            } else if (top.left != null) {
                longestBranch.put(top, Math.max(longestBranch.get(top.left), 0) + top.val);
                results.add(top.val + Math.max(longestBranch.get(top.left), 0));
            } else {
                longestBranch.put(top, Math.max(longestBranch.get(top.right), 0) + top.val);
                results.add(top.val + Math.max(longestBranch.get(top.right), 0));
            }
            searchQueue.pop();
        }
        Integer tempMax = Integer.MIN_VALUE;
        for (Integer i : results) {
            if (i > tempMax) {
                tempMax = i;
            }
        }
        return tempMax;
    }
}
