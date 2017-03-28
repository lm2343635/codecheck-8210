package codecheck;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        // Length of agrs must be large than 4.
        // -2 represents parameter error.
        if (args.length < 4) {
            System.exit(-2);
        }
        // Get info from args.
        String ai1 = args[0];
        String ai2 = args[1];
        String start = args[2];
        List<String> words = new ArrayList<>();
        for (int i = 3, l = args.length; i < l; i++) {
            words.add(args[i]);
        }
        // Flag to mark the first AI and the second AI.
        boolean first = true;
        String next = null;
        while (true) {
            next = ai(first ? ai1 : ai2, start, words);
            // S/he returns a word not included in the set of words at that time.
            if (!words.contains(next)) {
                break;
            }
            // S/he returns the word not beginning with the last character of the other player's most recent answer.
            if (!judge(start, next)) {
                break;
            }
            // Remove next word in words list and reset start word.
            words.remove(next);
            start = next;
            // Output OK info.
            System.out.println((first ? "FIRST" : "SECOND") + " (OK): " + next);
            // Change AI program.
            first = !first;
        }
        System.out.println((first ? "FIRST" : "SECOND") + " (NG): " + next);
        System.out.println("WIN - " + (first ? "SECOND" : "FIRST"));
        // Normal end, output win/lose result, and return 0 as end code.
        System.exit(0);
    }

    /**
     * Execute AI.
     *
     * @param ai    AI program
     * @param start start word
     * @param words word group
     * @return next word
     */
    private static String ai(String ai, String start, List<String> words) {
        // Create an AI command.
        String cmd = ai + " " + start;
        for (String word : words) {
            cmd += " " + word;
        }
        // Execute AI command.
        return exec(cmd);
    }

    /**
     * Judge method.
     * Return true if the last character in the start word is sample to the first character in the next word.
     *
     * @param start
     * @param next
     * @return
     */
    private static boolean judge(String start, String next) {
        char lastInStart = start.charAt(start.length() - 1);
        char firstInNext = next.charAt(0);
        return lastInStart == firstInNext;
    }

    /**
     * Execute a command
     *
     * @param cmd
     * @return result
     */
    private static String exec(String cmd) {
        String output = "";
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String line = null;
            while ((line = input.readLine()) != null) {
                output += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

}
