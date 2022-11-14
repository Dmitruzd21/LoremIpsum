import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        Map<Character, Integer> charsOfLoremIpsum = new HashMap<>();

        convertTextToMapOfCharsWithFrequency(loremIpsum, charsOfLoremIpsum);
        System.out.println("Коллекция набора символ-частота: " + charsOfLoremIpsum);

        int maxNumberOfLetterFrequency = getMaxNumberOfLetterFrequency(charsOfLoremIpsum);
        int minNumberOfLetterFrequency = getMinNumberOfLetterFrequency(charsOfLoremIpsum);

        List<Character> mostCommonLetters = getMostCommonLetter(maxNumberOfLetterFrequency, charsOfLoremIpsum);
        List<Character> mostRareLetters = getMostRareLetter(minNumberOfLetterFrequency, charsOfLoremIpsum);

        String mostCommonLettersStr = convertListToString(mostCommonLetters);
        String leastCommonLettersStr = convertListToString(mostRareLetters);

        System.out.println("Наибольшая встречаемость буквы в тексте: " + maxNumberOfLetterFrequency);
        System.out.println("Наименьшая встречаемость буквы в тексте: " + minNumberOfLetterFrequency);

        System.out.println("Буква/ы " + mostCommonLettersStr + " встречается/ются чаще всего");
        System.out.println("Буква/ы " + leastCommonLettersStr + " встречается/ются реже всего");
    }

    public static void convertTextToMapOfCharsWithFrequency(String text, Map<Character, Integer> map) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean isChar = map.containsKey(c);
            if (isChar) {
                int charFrequency = map.get(c);
                map.put(c, charFrequency + 1);
            } else {
                map.put(c, 1);
            }
        }
    }

    public static int getMaxNumberOfLetterFrequency(Map<Character, Integer> charsOfText) {
        int maxFrequency = 0;
        for (Map.Entry<Character, Integer> kv : charsOfText.entrySet()) {
            if (kv.getValue() > maxFrequency && Character.isLetter(kv.getKey())) {
                maxFrequency = kv.getValue();
            }
        }
        return maxFrequency;
    }

    public static int getMinNumberOfLetterFrequency(Map<Character, Integer> charsOfText) {
        int minFrequency = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> kv : charsOfText.entrySet()) {
            if (kv.getValue() < minFrequency && Character.isLetter(kv.getKey())) {
                minFrequency = kv.getValue();
            }
        }
        return minFrequency;
    }

    public static List<Character> getMostCommonLetter(int maxNumberOfLetterFrequency, Map<Character, Integer> charsOfText) {
        List<Character> lettersWithMostCommonFrequency = new ArrayList<>();
        for (Map.Entry<Character, Integer> kv : charsOfText.entrySet()) {
            if (kv.getValue().equals(maxNumberOfLetterFrequency) && Character.isLetter(kv.getKey())) {
                lettersWithMostCommonFrequency.add(kv.getKey());
            }
        }
        return lettersWithMostCommonFrequency;
    }

    public static List<Character> getMostRareLetter(int minNumberOfLetterFrequency, Map<Character, Integer> charsOfText) {
        List<Character> lettersWithMostRareFrequency = new ArrayList<>();
        for (Map.Entry<Character, Integer> kv : charsOfText.entrySet()) {
            if (kv.getValue().equals(minNumberOfLetterFrequency) && Character.isLetter(kv.getKey())) {
                lettersWithMostRareFrequency.add(kv.getKey());
            }
        }
        return lettersWithMostRareFrequency;
    }

    public static String convertListToString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (Character unit : list) {
            sb.append(unit);
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1); // удаляем последний символ (пробел)
    }
}






