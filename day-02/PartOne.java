import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

class PartOne {

	private static File file;
	private static List<String> input;
    
	public static void main(String[] args) {

		try {
			file = new File(args[0]);
			input = Files.readAllLines(file.toPath());
		} catch (ArrayIndexOutOfBoundsException e) {
			file = new File("input.txt");
		} catch (IOException e) {
			System.out.println("Error in file");
		}
	
		int checksum = 0;

		for(String line : input){
			String[] numbers = line.split("\t");
			ArrayList<Integer> i_numbers = new ArrayList<>();

			for(String curr : numbers){
				i_numbers.add(Integer.parseInt(curr));
			}
            
			int highest_value = Integer.MIN_VALUE, lowest_value = Integer.MAX_VALUE;

			for(int curr : i_numbers){
				if(highest_value < curr){
					highest_value = curr;
				} else if(lowest_value > curr) {
					lowest_value = curr;
				}
			}

				int difference = highest_value - lowest_value;
				checksum += difference;
		}

		System.out.println(checksum);

	}

}
