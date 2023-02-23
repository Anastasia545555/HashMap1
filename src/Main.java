import java.util.*;

public class Main {
    public static String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed " +
            "do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim " +
            "ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut " +
            "aliquip ex ea commodo consequat. Duis aute irure dolor in " +
            "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla " +
            "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
            "culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        char c;
        int num;
        int max = -2147483648;
        int min = 2147483647;
        String tempMin = "";
        String tempMax = "";
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            c=Character.toLowerCase(c);
            if (Character.isLetter(c)) {
                if (map.containsKey(c)) {
                    Integer number = map.get(c);
                    map.replace(c, number + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }
        for (Character m : map.keySet()) {
            String key = m.toString();
            String value = map.get(m).toString();
            System.out.println(value + " " + key);
        }
        for (Character m : map.keySet()) {
            Integer value = map.get(m);
            //num=Integer.parseInt(value);
            if (value < min) {
                min = value;
                tempMin = m.toString();
            }
            if (value > max) {
                max = value;
                tempMax = m.toString();
            }
        }
        System.out.printf("\nЧаще всего использовалась буква %s, количество в тексте: %d", tempMax, max);
        System.out.printf("\nРеже всего использовалась буква %s, количество в тексте: %d", tempMin, min);
    }
}