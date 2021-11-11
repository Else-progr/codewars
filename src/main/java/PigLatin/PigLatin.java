package PigLatin;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PigLatin {

    public static String pigIt(String str) {
        List<String> pigLatinList = Arrays.asList(str.split(" "));
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
//        return pigLatinList.stream().map(x -> rearrange(x)).collect(Collectors.joining(" "));
    }


    public static String rearrange(String str){
//        char[] punction = {'!',',','.',';',':','§','$','%','&','/',
//                '(',')','=','?','"','}','[',']','\\'};
//        char firstPosition = str.charAt(0);
//        for (char c : punction)
//            if ( c == punction) return str;


        return str.matches("[\\w]+") ? str.substring(1)+str.substring(0,1)+"ay" : str ;
    }
}
