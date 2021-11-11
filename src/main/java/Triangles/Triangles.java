package Triangles;

import java.math.BigInteger;

public class Triangles {

    public static char triangle(final String row) {

        System.out.println("New Row: "+row);

        String convert2Int = char2Int(row);
        System.out.println("convertiert: "+convert2Int);

        Character sol = getSolution(convert2Int);

        System.out.println(sol);
        System.out.println();

        return sol;
    }

    private static char getSolution(String convert2Int) {

        BigInteger sum = BigInteger.ZERO;
        int n = convert2Int.length();
        BigInteger binomial = BigInteger.ONE;

        for ( int k=1; k<=n; k++) {
            BigInteger coeff = convertChar2Big(convert2Int.charAt(k-1));
            System.out.println("coeff = "+coeff);
            if( k > 1 ) binomial = binomialcoefficientIterarion(binomial,n - 1, k - 1);
            sum = sum.add( coeff.multiply(binomial) );
        }
        if( n%2 == 0) sum = sum.multiply(BigInteger.valueOf(-1));
        sum = sum.mod( BigInteger.valueOf(3));

        return int2Char(sum.toString());
    }

    private static BigInteger binomialcoefficientIterarion(BigInteger binomial, int n, int k) {

        BigInteger bigN = BigInteger.valueOf(n);
        BigInteger bigK = BigInteger.valueOf(k);

        return (binomial.multiply( bigN.subtract(bigK).add(BigInteger.ONE)))
                .divide(bigK);
    }

    private static BigInteger convertChar2Big(char charAt) {
        String char2str = String.valueOf(charAt);
        int str2int = Integer.parseInt(char2str);
        return BigInteger.valueOf( str2int );
    }

    private static String char2Int(String str) {

        str = str.replace('B', '0');
        str = str.replace('G', '1');
        str = str.replace('R', '2');

        return str;
    }

    private static Character int2Char(String str) {

        str = str.replace('0', 'B');
        str = str.replace('1', 'G');
        str = str.replace('2', 'R');

        return str.charAt(0);
    }


    public static BigInteger binomialcoefficient(int n , int k){
        return factorial(n).divide( factorial(k).multiply( factorial(n-k)) );
    }

    private static BigInteger factorial(int f) {

        if( f <= 1 ) return BigInteger.ONE;

        return BigInteger.valueOf(f).multiply(factorial(f-1));
    }
}
