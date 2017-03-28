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
            if (word.charAt(0) == lastCharacter) {
                System.out.println(word);
                System.exit(0);
            }
        }
        System.out.println(getRandomWord(lastCharacter));
        System.exit(-1);
    }

    private final static String characters = "abcdefghijklmbopqrstuvwxyz";

    public static String getRandomChar() {
        int i = -1;
        while (i == -1 || i > 25) {
            i = (int) (Math.random() * 100);
        }
        return String.valueOf(characters.charAt(i));
    }

    public static String getRandomWord(char first) {
        String temp = String.valueOf(first);
        int length = (int) (Math.random() * 10);
        for (int j = 1; j < length; j++) {
            temp += getRandomChar();
        }
        return temp;
    }

}
