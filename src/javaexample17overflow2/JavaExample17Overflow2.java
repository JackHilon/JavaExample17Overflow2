package javaexample17overflow2;

import java.math.BigInteger;

public class JavaExample17Overflow2 {

    private static final BigInteger bigMaxInt = BigInteger.valueOf(Integer.MAX_VALUE);

    private static final BigInteger bigMinInt = BigInteger.valueOf(Integer.MIN_VALUE);

    public static void main(String[] args) {
        // This compliant solution uses the BigInteger technique to detect overflow:

    } // end main()

    public static BigInteger intRangeCheck(BigInteger val) {
        if (val.compareTo(bigMaxInt) == 1
                || val.compareTo(bigMinInt) == -1) {
            throw new ArithmeticException("Integer overflow");
        }
        return val;
    }

    public static int multAccum(int oldAcc, int newVal, int scale) {
        BigInteger product
                = BigInteger.valueOf(newVal).multiply(BigInteger.valueOf(scale));
        BigInteger res
                = intRangeCheck(BigInteger.valueOf(oldAcc).add(product));
        return res.intValue(); // Safe conversion
    }

}
