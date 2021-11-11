package Kingdom;


import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Kingdom {

    public static String translate(String speech, String[] vocabulary) {

        if(speech.equals("")) return "";

        String[] array = speech.split(" ");
//        Arrays.stream(array)
//                .collect(Collectors.toList())
//                .forEach(System.out::print);
//        System.out.println();
        String[] end = new String[100];
        int position = 0;
        for (String x : array){
            int lastPosition = x.length()-1;
            if ( x.charAt(lastPosition) == ',' ) {
                String[] split = x.split(",");
                end[position++] = split[0];
                end[position++] = ",";
            }else if ( x.charAt(lastPosition) == '.' ) {
                String[] split = x.split("\\.");
                end[position++] = split[0];
                end[position++] = ".";
            }else if ( x.charAt(lastPosition) == '!' ) {
                String[] split = x.split("!");
                end[position++] = split[0];
                end[position++] = "!";
            }else if ( x.charAt(lastPosition) == '?' ) {
                String[] split = x.split("\\?");
                end[position++] = split[0];
                end[position++] = "!";
            } else{
                end[position++] = x;
            }
        }
        List<String> list = Arrays.stream(end).filter(x ->  x != null )
                .collect(Collectors.toList());


        String found = "";
        StringBuilder solutions = new StringBuilder();

        for ( String e : list) {
//            System.out.println(e);
            boolean b = false;
            for( String voc : vocabulary){
                if (e.length() == voc.length() || e.length()==1) {
                    for ( int i=0; i< e.length(); i++ ) {
                        if (e.length()==1 && b==false) {
                            solutions.deleteCharAt(solutions.length()-1);
                            solutions.append(e.charAt(i));
                            found = "";
                            b=true;
//                    System.out.println("i = " + i + ": " + solutions);
                            break;
                        } else if (e.charAt(i) == '*' || e.charAt(i) == voc.charAt(i)) {
                            found += voc.charAt(i);
//                    System.out.println("i = "+(i-start)+": "+found);
                            continue;
                        } else {
                            found = "";
                            break;
                        }
                    }

                }
                solutions.append(found);
                found="";
            }
            solutions.append(" ");
            b=false;

        }
        solutions.deleteCharAt(solutions.length()-1);
        System.out.println(solutions);

        return solutions.toString();
    }
}
