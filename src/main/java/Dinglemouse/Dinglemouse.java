package Dinglemouse;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;


public class Dinglemouse {

    public static HashMap<String,String> eating = new HashMap<>();
//    public static ArrayList<String> outputList;
    public static String[] output;
    public static String[] zooArray;
    public static String predator;
    public static String prey;
    public static int outputRows;


    public static String[] whoEatsWho(String zoo) {


        outputRows=0;
        zooArray = zoo.split(",");
        output = new String[zooArray.length+1];
        output[outputRows++] = zoo;

        eating.put("antelope","grass");
        eating.put("big-fish", "little-fish");
        eating.put("bug","leaves");
        eating.put("bear","big-fish,bug,chicken,cow,leaves,sheep");
        eating.put("chicken","bug");
        eating.put("cow","grass");
        eating.put("fox","chicken,sheep");
        eating.put("giraffe","leaves");
        eating.put("lion","antelope,cow");
        eating.put("panda","leaves");
        eating.put("sheep","grass");


        buildOutput(zoo);

//        output = buildStringArray(outputList);

//        for (String i: output) {
//            System.out.println(i);
//        }

        return Arrays.stream(output).filter(Objects::nonNull).toArray(String[]::new);

    }


    private static void buildOutput(String zoo) {

        for (int i = 0; i < zooArray.length; i++) {
            if (i != 0) {
                predator = zooArray[i];
                prey = zooArray[i - 1];
                if (findPrey(predator, prey)) {
                    zooArray = removePrey(zooArray, i - 1);
                    zoo = String.join(",", zooArray);
                    buildOutput(zoo);
                    return;
                }
            }
            if (i != zooArray.length - 1) {
                predator = zooArray[i];
                prey = zooArray[i + 1];
                if (findPrey(predator, prey)) {
                    zooArray = removePrey(zooArray, i + 1);
                    zoo = String.join(",", zooArray);
//                            Arrays.stream(zooArray).filter(x -> !x.equals(prey))
//                            .collect(Collectors.joining(","));
//                    zooArray = Arrays.stream(zooArray).filter(x -> !x.equals(prey))
//                            .toArray(String[]::new);
                    buildOutput(zoo);
                    return;
                }
            }
        }
            output[outputRows++] = zoo;

    }

    private static String[] removePrey(String[] zooArray, int removeAtIndex) {
        int zooRows = 0;
        String[] copyArray = zooArray;
        zooArray = new String[copyArray.length-1];

        for(int i = 0; i < copyArray.length; i++) {
            if ( i != removeAtIndex ) {
                zooArray[zooRows] = copyArray[i];
                zooRows++;
            }

        }

        return zooArray;
    }

//    public static String testEating(String predator, String prey){
//        if( findPrey(predator,prey)) {
//            return Arrays.stream(zooArray).filter(x -> !x.equals(prey))
//                    .collect(Collectors.joining(","));
//        }
//         return "";
//    }

    public static boolean findPrey(String predator, String prey){
        boolean bool=false;
        String preyString = eating.get(predator);
        try {
            String[] preyList = preyString.split(",");
            for (String x : preyList) {
                bool = x.equals(prey);
                if (bool) {
//                    System.out.println(predator + " eats " + x);
                    output[outputRows++] = predator + " eats " + x;
//                    outputList.add(predator + " eats " + x);
                    break;
                }
            }
        }catch (NullPointerException e){
            return false;
        }
        return bool;
    }

//    public static  String[] getPreyList(String preyList){
//        return preyList.split(",");
//    }

//    public static  String getPrey(String[] preyList, int i){
//        return preyList[i];
//    }

//    public static int howManyPreys(String[] preyList){
//        return preyList.length;
//    }


}
