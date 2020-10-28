package generateParenthesis;

public class Main {
    public static void main(String[] args) {
        Fastest s = new Fastest();
        System.out.println(s.generateParenthesis(3));
    }
}
/*
 "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
 */