package codecheck;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        // Length of agrs must be large than 4.
        if (args.length < 4) {
            return;
        }
        String ai1 = args[0];
        String ai2 = args[1];
        String start = args[2];
        List<String> words = new ArrayList<>();
        for (int i = 3, l = args.length; i < l; i++) {
            words.add(args[i]);
        }

    }

    private static String ai(String ai, String start, List<String> words) {
        String cmd = ai + " " + start;
        for (String word : words) {
            cmd += " " + word;
        }
        return exec(cmd);
    }

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
