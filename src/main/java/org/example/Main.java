package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        readArrayFromFile();
    }

    public static void checkFirstWord(String[] words) {
        boolean checker = false;
        for (String word : words) {
            if (word.startsWith("a")) {
                System.out.println("First word which starts with a letter 'a': " + word);
                checker = true;
                break;
            }
        }
        if (!checker) {
            System.out.println("There isn't word which starts with a letter 'a'");
        }
    }

    public static void readArrayFromFile() {
        String desktopPath = "C:\\Users\\roman\\OneDrive\\Робочий стіл\\";
        String fullPath = desktopPath + "t.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fullPath));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                checkFirstWord(splitString(line));
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] splitString(String str) {
        ArrayList<String> words = new ArrayList<>();
        String word = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isWhitespace(ch)) {
                if (!word.isEmpty()) {
                    words.add(word);
                    word = "";
                }
            } else {
                word += ch;
            }
        }
        if (!word.isEmpty()) {
            words.add(word);
        }
        return words.toArray(new String[0]);
    }
}
