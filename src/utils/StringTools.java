package utils;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class StringTools {
    public static String removeChars(String str, String c1, String c2) {
        str = str.replace(c1, "");
        str = str.replace(c2, "");
        return str;
    }

    public static int countOccurences(String[] array, String word) {
        int count = 0;
        for (String s : array) {
            if (s.equals(word)) {
                count++;
            }
        }
        return count;
    }

    public static List<String> removeDuplicatesFromList(List<String> list) {
        Set<String> set = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(set);
        return list;
    }
}
