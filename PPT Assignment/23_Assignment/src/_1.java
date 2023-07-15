import java.util.Stack;

class BinaryTreeDepth {
    static int calculateDepth(String preorder) {
        int depth = 0;
        Stack<Character> stack = new Stack<>();

        for (char ch : preorder.toCharArray()) {
            if (ch == 'n') {
                depth++;
                stack.push('n');
            } else if (ch == 'l') {
                if (!stack.isEmpty() && stack.peek() == 'n') {
                    stack.pop();
                    depth--;
                }
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        String preorder = "nlnll";
        int depth = calculateDepth(preorder);
        System.out.println("Depth of the binary tree: " + depth);
    }
}
