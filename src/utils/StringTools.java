package utils;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static boolean containsOrderUUID(String order) {
        String pattern = "orderUUID=[\\w-]+";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(order);

        return matcher.find();
    }

    public static String extractOrderUUIDFromString(String order) {
        Pattern regex = Pattern.compile("orderUUID=([\\w-]+)");
        Matcher matcher = regex.matcher(order);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "orderUUID not found";
        }
    }

    public static String extractEmailFromString(String str) {
        Pattern regex = Pattern.compile("([\\w]+@[\\w]+\\.[\\w]+)");
        Matcher matcher = regex.matcher(str);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "email not found";
        }
    }

    public static int extractNumOfOrdersCreated(String str) {
        Pattern regex = Pattern.compile("\\[([\\d]+)]");
        Matcher matcher = regex.matcher(str);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            return 0;
        }
    }
}
