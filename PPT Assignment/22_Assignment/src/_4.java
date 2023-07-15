class SameTreeCheck {
    boolean checkSameTree(int[] preorder, int[] inorder, int[] postorder, int preStart, int inStart, int postStart, int length) {
        if (length == 0) {
            return true;
        }

        if (length == 1) {
            return (preorder[preStart] == inorder[inStart]) && (inorder[inStart] == postorder[postStart]);
        }

        int root = preorder[preStart];
        int inIndex = -1;
        for (int i = inStart; i < inStart + length; i++) {
            if (inorder[i] == root) {
                inIndex = i;
                break;
            }
        }

        int leftLength = inIndex - inStart;
        int rightLength = length - leftLength - 1;

        boolean isLeftSame = checkSameTree(preorder, inorder, postorder, preStart + 1, inStart, postStart, leftLength);
        boolean isRightSame = checkSameTree(preorder, inorder, postorder, preStart + leftLength + 1, inIndex + 1, postStart + leftLength, rightLength);

        return isLeftSame && isRightSame && (root == postorder[postStart + leftLength]);
    }

    public static void main(String[] args) {
        SameTreeCheck stc = new SameTreeCheck();

        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        int length = preorder.length;

        boolean isSameTree = stc.checkSameTree(preorder, inorder, postorder, 0, 0, 0, length);

        System.out.println("Are the traversals of the same tree? " + isSameTree);
    }
}
class SameTreeCheck {
    boolean checkSameTree(int[] preorder, int[] inorder, int[] postorder, int preStart, int inStart, int postStart, int length) {
        if (length == 0) {
            return true;
        }

        if (length == 1) {
            return (preorder[preStart] == inorder[inStart]) && (inorder[inStart] == postorder[postStart]);
        }

        int root = preorder[preStart];
        int inIndex = -1;
        for (int i = inStart; i < inStart + length; i++) {
            if (inorder[i] == root) {
                inIndex = i;
                break;
            }
        }

        int leftLength = inIndex - inStart;
        int rightLength = length - leftLength - 1;

        boolean isLeftSame = checkSameTree(preorder, inorder, postorder, preStart + 1, inStart, postStart, leftLength);
        boolean isRightSame = checkSameTree(preorder, inorder, postorder, preStart + leftLength + 1, inIndex + 1, postStart + leftLength, rightLength);

        return isLeftSame && isRightSame && (root == postorder[postStart + leftLength]);
    }

    public static void main(String[] args) {
        SameTreeCheck stc = new SameTreeCheck();

        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        int length = preorder.length;

        boolean isSameTree = stc.checkSameTree(preorder, inorder, postorder, 0, 0, 0, length);

        System.out.println("Are the traversals of the same tree? " + isSameTree);
    }
}
