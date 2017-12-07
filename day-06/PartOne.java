// Day six! Blurb can be found here https://adventofcode.com/2017/day/6
// My personal string can be found in input.txt
// My answer was 6681

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.nio.file.Paths;



class PartOne {

	public static void main(String[] args) throws IOException {
    
        String input = new String(Files.readAllBytes(Paths.get("input.txt"))).trim();
		String[] numbers = input.split("\\s+");
		int[] memBlocks = new int[numbers.length];
    
        for (int i = 0; i < memBlocks.length; i++) {
			memBlocks[i] = Integer.valueOf(numbers[i]);
		}
    
        HashMap<String, Boolean> states = new HashMap<>();
		int steps = 0;
    
        while (true) {
    
            int largest = 0;
    
            for (int i = 1; i < memBlocks.length; i++) {
				if (memBlocks[i] > memBlocks[largest]) {
					largest = i;
				}
			}
    
            int add = memBlocks[largest];
			memBlocks[largest] = 0;
    
            for (int i = 0; i < add; i++) {
				memBlocks[(largest + 1 + i) % memBlocks.length]++;
			}
    
            steps++;
			String key = Arrays.toString(memBlocks);
    
            if (states.containsKey(key)) {
				break;
			}
    
            states.put(key, true);
    
        }
    
        System.out.println(steps);
    
    }
    
}
