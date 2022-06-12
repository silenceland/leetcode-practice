package com.silenceland.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 * 3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class TwoChaTreeJuChiBianLi {

    public static void main(String[] args) {
        // method
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelsize = queue.size();
            for (int i = 1; i <= currentLevelsize; i ++) {
                TreeNode node = queue.poll();
                level.add(node.getValue());

                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }

                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            res.add(level);

        }
        return res;
    }


}
