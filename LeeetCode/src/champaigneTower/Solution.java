package champaigneTower;

import java.math.BigInteger;

public class Solution {


    public static void main(String[] args) {
        BigInteger one = BigInteger.ZERO;
        BigInteger two = BigInteger.ZERO;

        String s1 = "3141592653589793238462643383279502884197169399375105820974944592";
        String s2 = "2718281828459045235360287471352662497757247093699959574966967627";

        BigInteger mult = BigInteger.ONE;
        for (int i = s1.length() - 1; i >= 0; i--) {
            BigInteger thisChar1 = BigInteger.valueOf((long) s1.charAt(i) - '0').multiply(mult);
            BigInteger thisChar2 = BigInteger.valueOf((long) s2.charAt(i) - '0').multiply(mult);

            one = one.add(thisChar1);
            two = two.add(thisChar2);
            mult = mult.multiply(BigInteger.TEN);
        }

        System.out.println(karatsuba(one, two));
    }

    public static BigInteger karatsuba(BigInteger x, BigInteger y) {

        // cutoff to brute force
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) return x.multiply(y);                // optimize this parameter

        // number of bits divided by 2, rounded up
        N = (N / 2) + (N % 2);

        // x = a + 2^N b,   y = c + 2^N d
        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        // compute sub-expressions
        BigInteger ac = karatsuba(a, c);
        BigInteger bd = karatsuba(b, d);
        BigInteger abcd = karatsuba(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2 * N));
    }
}
