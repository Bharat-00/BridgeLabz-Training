import java.util.Stack;
public class SortStackRecursion {
    static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            sortStack(stack);
            insertSorted(stack, x);
        }
    }
    static void insertSorted(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || stack.peek() <= x) {
            stack.push(x);
            return;
        }
        int temp = stack.pop();
        insertSorted(stack, x);
        stack.push(temp);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(20);
        stack.push(5);
        sortStack(stack);
        System.out.println("Sorted Stack:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

