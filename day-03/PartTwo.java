// Find the blurb for today's exercise here:
// http://adventofcode.com/2017/day/3/
// My answer was 266330 

class PartTwo {

	public static void main(String[] args) {

		int input = 265149;
		int size = (int) Math.ceil(Math.sqrt(input));
		int result = Integer.MAX_VALUE;

		if (size % 2 == 0) {
			size += 1;
		}

		int center = size / 2;
		int x = center;
		int y = center;
		int grid[][] = new int[size][size];

		for (int i = 1; i <= size; i += 2) {
			for (int j = 0; j < i - 2; j++) {
				populate(grid, x, y);
				y -= 1;
			}
			for (int j = 0; j < i - 1; j++) {
				populate(grid, x, y);
				x -= 1;
			}
			for (int j = 0; j < i - 1; j++) {
				populate(grid, x, y);
				y += 1;
			}
			for (int j = 0; j < i; j++) {
				populate(grid, x, y);
				x += 1;
			}
		}

		for (y = 0; y < size; y++) {
			for (x = 0; x < size; x++) {
				if (grid[x][y] >= input) {
					result = Math.min(result, grid[x][y]);
				}
			}
		}

		System.out.println(result);

	}

	private static void populate(int[][] grid, int x, int y) {

		int sum = 0;

		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i < 0 || i >= grid.length) {
					continue;
				}
				if (j < 0 || j >= grid[i].length) {
					continue;
				}
				if (i == x && j == y) {
					continue;
				}
				sum += grid[i][j];
			}
		}

		if (sum == 0) {
			sum = 1;
		}

		grid[x][y] = sum;

	}

}
