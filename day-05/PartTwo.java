// Find the blurb for this day here:
// http://adventofcode.com/2017/day/5 
// My input can be found in input.txt
// My personal answer was 26395586 

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

class PartTwo {

    private static File file;
    private static List<String> input;
    private static ArrayList<Integer> memory = new ArrayList<>();

    public static void main(String[] args) {

        try {
            file = new File(args[0]);
            input = Files.readAllLines(file.toPath());
        } catch (ArrayIndexOutOfBoundsException e) {
            file = new File("input.txt");
        } catch (IOException e) {
            System.out.println("Error in file");
        }
    
        for(String cell : input) {
            memory.add(Integer.parseInt(cell));
        }

        int steps = 0;
        int pos = 0;

        while (true) {

            int val = 0; 
            
            try {
                val = memory.get(pos);
            } catch (IndexOutOfBoundsException ex) {
                break;
            }

            if (val >= 3) {
                memory.set(pos , val - 1);
            } else {
                memory.set(pos, val + 1);
            }
            pos += val;

            steps++;

        }

        System.out.println(steps);

    }


}
