package lessons.Lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class StartMain {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> directory = new HashMap<>();
        TelephoneDirectory directory1 = new TelephoneDirectory(directory);
        directory1.addSurnameTelephone("Ivanov", "25-64-96");
        directory1.addSurnameTelephone("Ivanov", "55-55-55");
        directory1.addSurnameTelephone("Kim", "15-14-16");
        directory1.addSurnameTelephone("Li", "25-64-96");


        System.out.println(directory1.getTelephone("Ivanov"));
        System.out.println(directory1.getTelephone("Kim"));
        System.out.println(directory1.getTelephone("Iva"));



        String[] lenaArray = new String[]{"mama", "my", "my", "Papa", "my", "mama", "papa and mama", "nora", "my", "JAVA", "JAVA"} ;
        TelephoneDirectory directory2 = new TelephoneDirectory(lenaArray);


        System.out.println(directory2.uniqueElements(lenaArray));
        System.out.println(directory2.numberofElements(lenaArray));

        }


    }

