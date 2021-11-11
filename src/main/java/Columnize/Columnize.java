package Columnize;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class Columnize {

    public static String columnize(String[] input, int numberOfColumns) {


        int rowLength = input.length / numberOfColumns;
        if ( input.length % numberOfColumns > 0 ) rowLength += 1;

        int columnLength;
        if( numberOfColumns > input.length){
            columnLength = input.length;
        }else{
            columnLength = numberOfColumns;
        }

        String rowColumn[][]= new String[rowLength][columnLength];
        int i=0;
        for( int r = 0; r < rowLength; r++) {
            for (int c = 0; c < columnLength; c++) {
                if ( i < input.length ){
                    rowColumn[r][c] = input[i];
                    i++;
                }else{
                    break;
                }
            }
        }

//        for( int r = 0; r < rowLength; r++) {
//            for (int c = 0; c < columnLength; c++) {
//                System.out.print(rowColumn[r][c]+" | ");
//            }
//            System.out.println();
//        }

        int max = 0;
        for(int c = 0; c < columnLength; c++) {
            max = rowColumn[0][c].length();
            for ( int r = 0; r < rowLength; r++)
                if (rowColumn[r][c] != null)
                    if (rowColumn[r][c].length() > max)
                        max = rowColumn[r][c].length();
            for ( int r = 0; r < rowLength; r++)
                if (rowColumn[r][c] != null)
                    rowColumn[r][c] += getBlanc(rowColumn[r][c].length(), max);

        }

//        String[] outputArray = new String[row.length];
//        for (int r=0; r< row.length; r++)
//            for ( int c=0; c<columnLength; c++){
//                outputArray[r] +=  rowColumn[r][c];
////                    Arrays.asList(rowColumn[r]).stream().collect(Collectors.joining("\n"));
//        }
        
        String outputString = "";
//        outputString = Arrays.asList(outputArray).stream().collect(Collectors.joining(" | "));
        for( int r=0; r<rowLength; r++) {
            for ( int c=0 ; c < columnLength; c++) {
                if (rowColumn[r][c] != null) {
                    outputString += rowColumn[r][c];
                    if ( c != (columnLength-1) ){
                        if (rowColumn[r][c].equals(" ")) {
                            outputString += "|";
                        } else {
                            if( (rowColumn[r][c+1] != null) && (c+1 != columnLength))
                                outputString += " | ";
                        }
                    }
                }
            }
            if ( r != (rowLength-1) )
                outputString += "\n";
        }

        System.out.println(outputString);

        return outputString;
    }

    public static String getBlanc(int length, int max){
        String blancs = "";
        for (int k = 0; k < (max - length) ; k++)
            blancs += " ";
        return blancs;
    }

}
