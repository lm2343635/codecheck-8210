package codecheck;

public class App {
    public static void main(String[] args) {
        // Length of agrs must be large than 2.
        if (args.length < 2) {
            return;
        }
        // Get last word.
        String last = args[0];
        char lastCharacter = last.charAt(last.length() - 1);
        for (int i = 1, l = args.length; i < l; i++) {
            String word = args[i];
            if (word.charAt(0) == lastCharacter) {
                System.out.println(word);
                return;
            }
        }
    }
}
