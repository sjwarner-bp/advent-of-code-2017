import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

class PartTwo {

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

			int division_1 = 0, division_2 = 0;
            
			outerloop:
			for(int curr : i_numbers){
				for(int curr_i : i_numbers){
					if(curr == curr_i){
						continue;
					} else if(curr % curr_i == 0){ //even
						division_1 = curr;
						division_2 = curr_i;
						break outerloop;
					}
				}
			}
			int division = division_1 / division_2;
			checksum += division;
		}
        
		System.out.println(checksum);

	}

}
