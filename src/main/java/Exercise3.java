import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise3 {

    /*
     * implement the method below so that it extracts a URL from a String
     * I will write the basics for this one method, you will have to implement the
     * other two methods from scratch
     */

    public static String extractURL(String text) {
        String regex1 = "https://\\S+";
        String regex2 = "http://\\S+";

        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher1 = pattern1.matcher(text);
        Matcher matcher2 = pattern2.matcher(text);

        if (matcher1.find()) {
            return matcher1.group();
        } else if (matcher2.find()) {
            return matcher2.group();
        } else {
            return null;
        }
    }

    /*
     * Implement the method below to validate an email address.
     */

    public static boolean validateEmail(String email) {
        String regex = "^(?=[A-Za-z0-9_-]{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /*
     * implement the method below so that it returns a list of words with repeated
     * letters
     */

    // public static List<String> findWordsWithRepeatLetters(String input) {
    // List<String> wordsWithRepeatLetters = new ArrayList<>();
    // return wordsWithRepeatLetters;
    // // TODO
    // }

    public static List<String> findWordsWithRepeatLetters(String input) {
        List<String> wordsWithRepeatLetters = new ArrayList<>();
        String[] words = input.split("\\s+");

        for (String word : words) {
            if (hasRepeatedLetters(word)) {
                wordsWithRepeatLetters.add(word);
            }
        }

        return wordsWithRepeatLetters;
    }
    private static boolean hasRepeatedLetters(String word) {
        Set<Character> seenLetters = new HashSet<>();
        for (char letter : word.toCharArray()) {
            if (!seenLetters.add(letter)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Bonus Problem ;)
     * implement the method below so that it returns a list of words that are
     * repeated twice accidentally in a string
     * for example: "appleapple orange pearpear pineapple" -> ["appleapple",
     * "pearpear"]
     */

//    public static List<String> findReapetdWords(String input) {
//        List<String> repeatedWords = new ArrayList<>();
//        return repeatedWords;
//        // TODO
//    }

    public static List<String> findRepeatedWords(String input) {
        List<String> repeatedWords = new ArrayList<>();

        String[] words = input.split("\\s+");

        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].equals(words[i + 1])) {
                repeatedWords.add(words[i]);
            }
        }

        return repeatedWords;
    }

    public static void main(String[] args) {
        // test your code here!

        // System.err.println(extractURL("https://www.shahidbeheshti.ir"));
        System.err.println(validateEmail("hello_World@geeksforgeeks.org"));
    }
}