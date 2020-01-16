package lessons.Lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TelephoneDirectory {
    HashMap<String, ArrayList<String>> directory;
    String [] array;

    public TelephoneDirectory(HashMap directory) {
                this.directory = directory;
                    }

    public TelephoneDirectory(String[] array) {
        this.array = array;
    }

        public ArrayList<String> getTelephone(String surname) {
        return directory.get(surname);


    }

    public void addSurnameTelephone(String surname, String telephone) {
        if (directory.containsKey(surname)) {
            directory.get(surname).add(telephone);
        } else {
            ArrayList<String> arrayList = new ArrayList<>(2);
            arrayList.add(telephone);
            directory.put(surname, arrayList);
        }

    }

    public HashSet<String> uniqueElements(String[] Array) {
        HashSet<String> set = new HashSet<>();
        for (String lena : Array) {
            set.add(lena);
        }
        return set;
    }

    public ArrayList<String> numberofElements(String[] Array) {
        HashSet<String> set = new HashSet<>();
                for (String arrayelent : Array) {
            set.add(arrayelent);
        }
        ArrayList<String> arrayList = new ArrayList<>(set.size());

        for (String setelement : set) {
            int n = 0;
            for (String arrayelement : Array) {

                if (setelement.equals(arrayelement)) {
                    n++;
                }
            }
                arrayList.add("слово " + setelement + " встречается " + n + " раз" );

        }
        return arrayList;
    }
}
