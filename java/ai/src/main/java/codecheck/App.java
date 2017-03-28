package codecheck;

public class App {

    public static void main(String[] args) {
        // Length of agrs must be large than 2, exit with -2.
        // -2 represents parameter error.
        if (args.length < 2) {
            System.exit(-2);
        }
        // Get last word.
        String last = args[0];
        char lastCharacter = last.charAt(last.length() - 1);
        for (int i = 1, l = args.length; i < l; i++) {
            String word = args[i];
            // Make a valid answer if the word is found.
            if (word.charAt(0) == lastCharacter) {
                System.out.println(word);
                System.exit(0);
            }
        }
        // AI program does not find a valid answer.
        // Make a random word and print it.
        System.out.println(getRandomWord(lastCharacter));
        System.exit(-1);
    }

    // Characters for creating random word.
    private final static String characters = "abcdefghijklmbopqrstuvwxyz";

    /**
     * Get a random character
     *
     * @return
     */
    public static String getRandomChar() {
        int i = -1;
        while (i == -1 || i > 25) {
            i = (int) (Math.random() * 100);
        }
        return String.valueOf(characters.charAt(i));
    }

    /**
     * Create a random word.
     * Its length is from 2 to 10.
     *
     * @param first The first charater in the random word
     * @return
     */
    public static String getRandomWord(char first) {
        String temp = String.valueOf(first);
        int length = (int) (Math.random() * 10);
        // Create random word by adding random character.
        for (int j = 1; j < length; j++) {
            temp += getRandomChar();
        }
        return temp;
    }

}
