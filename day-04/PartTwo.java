// Day Two! Blurb can be found here https://adventofcode.com/2017/day/4
// My personal string can be found in input.txt
// My answer was 231

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PartTwo {

    private static File file;
    private static List<String> input;
    private static int invalid;

    public static void main(String[] args) {

        try {
            file = new File(args[0]);
            input = Files.readAllLines(file.toPath());
        } catch (ArrayIndexOutOfBoundsException e) {
            file = new File("input.txt");
        } catch (IOException e) {
            System.out.println("Error in file");
        }

        outerloop:
        for (String line : input) {
            String words[] = line.split(" ");
            
            for (int i = 0; i < words.length; i++) {
                for (int j = i+1; j < words.length; j++) {
                    char[] wordOne = words[i].toCharArray();
                    char[] wordTwo = words[j].toCharArray();
                    Arrays.sort(wordOne);
                    Arrays.sort(wordTwo);
                    if (Arrays.equals(wordOne, wordTwo)) {
                        invalid += 1;
                        continue outerloop;
                    }
                }
            }

        }

        System.out.println(input.size() - invalid);

    }

}
