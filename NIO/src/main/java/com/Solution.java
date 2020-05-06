package com;

public class Solution {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for (int preNum = 1; preNum < preorder.length; preNum++) {

            boolean flag = false;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == root.val) {
                    flag = true;
                }
                if (preorder[preNum] == inorder[i] ) {

                    if (!flag) {
                        root.left = new TreeNode(preorder[preNum]);
                    } else {
                        root.right = new TreeNode(preorder[preNum]);
                    }
                    break;
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
    }
}
