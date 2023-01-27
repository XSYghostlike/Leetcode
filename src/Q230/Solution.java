package Q230;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        midOrderBst(root, arr);
        return arr.get(k-1);
    }

    void midOrderBst(TreeNode root, List<Integer> passThruArr) {
        if (root != null) {
            midOrderBst(root.left, passThruArr);
            passThruArr.add(root.val);
            midOrderBst(root.right, passThruArr);
        }
    }
}
