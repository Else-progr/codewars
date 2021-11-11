package Carboat;

public class Carboat {


    public static void main(String[] args) {

        System.out.println( howmuch(1, 100) );
        System.out.println( howmuch(1000, 1100) );
        System.out.println( howmuch(10000, 9950) );
        System.out.println( howmuch(0, 200) );
        System.out.println( howmuch(2950, 2950) );
    }

    public static String howmuch(int m, int n) {

        if(n>m){  int c = m;  m = n;  n = c;  }

        String sol = "[";

        for( int b = 1 ; b < m ; b++){

            if( (7*b+1) % 9 == 0){
                int c = (7*b+1) / 9;
                int f = 7*b+2;
                if ( f > m) break;
                if ( f < n) continue;
                sol = sol +"[M: "+f+" B: "+b+" C: "+c+"]";
            }
        }
        sol = sol +"]";

        return sol;
    }
}
