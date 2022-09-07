import java.util.*;

public class Main {
    public static String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
            " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam," +
            " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat" +
            " nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia " +
            "deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> letter = new HashMap<>();
        char[] symbols = loremIpsum.toLowerCase(Locale.ROOT).toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            if (!Character.isLetter(loremIpsum.charAt(i))) {
                letter.remove('i');
            } else if (!letter.containsKey(symbols[i])) {
                letter.put(symbols[i], 1);
            } else {
                int maxValue = (letter.get(symbols[i]) + 1);
                letter.put(symbols[i], maxValue);
            }
        }
        
        System.out.println(letter);

        int max = 0;
        int min = 0;
        for (Character key : letter.keySet()) {
            int value = letter.get(key);
            if (value > max) {
                max = value;
            }
            if (value < Integer.MAX_VALUE) {
                min = value;
            }

        }
        System.out.println("Чаще всего встречается символ - " + getKey(letter, max));
        System.out.println("Реже всего встречается символ - " + getKey(letter, min));

    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}

