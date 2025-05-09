import java.util.Stack;

public class C20250509_3 {

    public static void main(String[] args) {

        String s = "()()()((())()()()()()";

        System.out.println(solution(s));

    }

    public static boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();


        char[] a = s.toCharArray();


        if (a[a.length - 1] == '(') {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') {
                stack.add(a[i]);
                continue;
            }

            if (a[i] == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }


        }

        if (!stack.isEmpty()) {
            return false;
        }

        return answer;
    }


}
