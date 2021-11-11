package Smaller;

import java.util.Arrays;
import java.util.Objects;

    public class Smaller {

        public static int[] smaller;
        public static int[] sorted;

        public static int[] smaller(int[] unsorted) {

            long start_time = System.currentTimeMillis();

            int length = unsorted.length;
                System.out.println("länge="+length);
            smaller = new int[length];
            sorted = new int[2];

            startSorting(unsorted);

            for( int k=length-3 ; k>=0 ; k-- ){
                int pos = findPosition(unsorted[k]);
//                int pos = findPositionBinary(sorted, unsorted[k]);
                sorted = insertElement(sorted, pos, unsorted[k]);
                smaller[k] = pos;
            }

//     System.out.println("ergebnis: ");
//     print(smaller);

            long end_time = System.currentTimeMillis();
            System.out.println("zeit in ms = "+(end_time-start_time));

            return smaller;
        }
        
        

        private static void startSorting(int[] unsorted) {

            int length = unsorted.length;
            
            smaller[length-1] = 0;

            if( unsorted[length-1] < unsorted[length-2] ){
                sorted[0]= unsorted[length-1];
                sorted[1]= unsorted[length-2];
                smaller[length-2] = 1;
            }else{
                sorted[0]= unsorted[length-2];
                sorted[1]= unsorted[length-1];
                smaller[length-2] = 0;
            }
        }


        public static int findPosition(int element){

            int startInterval = 0;
            int endInterval = sorted.length;
            int half = endInterval/2;

            while( half>0 ){
                if( element < sorted[half] ){
                    if( Math.abs(endInterval-half) == 1 ){ break; }
                    endInterval = half;
                    half = half/2-startInterval;
                }else if( element > sorted[half] ){
                    if( Math.abs(endInterval-half) == 1 ){ break; }
                    startInterval = half;
                    half = half + (endInterval-half)/2;
                }else{
                    break;
                }
            }

            int pos = endInterval;
            for( int i=startInterval; i< endInterval; i++  )
                if( element <= sorted[i] ){
                    pos = i;
                    break;
                }

//          int pos =sorted.length;
//          for( int i=0; i< sorted.length; i++  )
//              if( unsorted[k] <= sorted[i] ){
//                  pos = i;
//                  break;
//              }

            return pos;
        }

        
        public static int[] insertElement(int[] sorted, int pos, int toInsert){

            int[] elementAdded = new int[sorted.length + 1];

            System.arraycopy(sorted, 0, elementAdded, 0, pos);
            elementAdded[pos] = toInsert;
            System.arraycopy(sorted, pos, elementAdded, pos+1, sorted.length-pos );

            return elementAdded;

        }


        private static void countSmaller(int[] unsorted) {

            int length = unsorted.length;
            smaller = new int[length];

            // initialize all the counts in smaller array as 0
            for (int i = 0; i < length; i++)
                smaller[i] = 0;

            for (int i = 0; i < length; i++)
            {
                for (int j = i + 1; j < length; j++)
                {
                    if (unsorted[j] < unsorted[i])
                        smaller[i]++;
                }
            }
        }
        

        public int findPositionBinary(int[] sorted, int element){

           int pos = Arrays.binarySearch(sorted, element);
           if(pos>0){
                while( sorted[pos-1] == sorted[pos]){
                    pos--;
                    if(pos==0) break;
                }
           }
           if (pos < 0)  pos = -pos -1;

           return pos;
        }


        public static void print(int[] arr){

            for( int k=0; k<arr.length; k++ ){
                System.out.print(arr[k]);
                if( k != arr.length-1 ) System.out.print(", ");
            }
            System.out.println();
        }
    }
