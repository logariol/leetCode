package productExceptSelf;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SolutionOptimal s = new SolutionOptimal();
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
