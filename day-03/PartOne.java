// Find the blurb for today's exercise here:
// http://adventofcode.com/2017/day/3/
// My answer was 438

class PartOne {

	public static void main(String[] args) {

		int input = 265149;
		int size = (int) Math.ceil(Math.sqrt(input));
		int distance = 0;

		if (size % 2 == 0) {
			size += 1;
		}

		int center = size / 2;
		int x = center;
		int y = center;
		int grid[][] = new int[size][size];
		int n = 1;

		for (int i = 1; i <= size; i += 2) {
			for (int j = 0; j < i - 2; j++) {
				grid[x][y] = n++;
				y -= 1;
			}
			for (int j = 0; j < i - 1; j++) {
				grid[x][y] = n++;
				x -= 1;
			}
			for (int j = 0; j < i - 1; j++) {
				grid[x][y] = n++;
				y += 1;
			}
			for (int j = 0; j < i; j++) {
				grid[x][y] = n++;
				x += 1;
			}
		}

		for (y = 0; y < size; y++) {
			for (x = 0; x < size; x++) {
				if (grid[x][y] == input) {
					distance = Math.abs(x - center) + Math.abs(y - center);
				}
			}
		}

		System.out.println(distance);

	}

}
