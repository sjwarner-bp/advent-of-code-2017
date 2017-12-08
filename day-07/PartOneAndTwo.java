// I got very stuck on this one (or maybe I was just tired)
// So I took a large amount of inspiration from another
// implementation of this project! Yay for open source.

// Play along here: http://adventofcode.com/2017/day/7
// My answers were: part one - xegshds, part two - 299

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class PartOneAndTwo {

	private static Map<String, Node> nodes = new HashMap<>();

	public static void main(String[] args) throws IOException {
		for (String row : Files.readAllLines(Paths.get("input.txt"))) {
			String part1 = row.split("->")[0].trim();
			Node uusi = new Node(part1);
			nodes.put(uusi.name, uusi);
			if (row.split("->").length > 1) {
				for (String substr : row.split("->")[1].trim().split(",")) {
					uusi.leafs.put(substr.trim(), null);
				}
			}
		}
		for (Entry<String, Node> entry : nodes.entrySet()) {
			for (Entry<String, Node> leafEntry : entry.getValue().leafs.entrySet()) {
				Node leaf = nodes.get(leafEntry.getKey());
				leaf.parent = entry.getValue();
				leafEntry.setValue(leaf);
			}
		}
		Node root = nodes.values().iterator().next();
		while (root.parent != null) {
			root = root.parent;
		}
		Node diff = root;
		while (diff.diffNode() != null) {
			diff = diff.diffNode();
		}
		for (Node node : diff.parent.leafs.values()) {
			if (diff != node) {
				System.out.println("Part2: " + (diff.weight - (diff.weight() - node.weight())));
				break;
			}
		}
		System.out.println("Part1: " + root.name);
	}

	private static class Node {
		private String name;
		private int weight;
		private Node parent;
		private Map<String, Node> leafs = new HashMap<>();

		public Node(String data) {
			this.name = data.split("\\s")[0];
			this.weight = Integer.valueOf(data.split("\\s")[1].replace("(", "").replace(")", ""));
		}

		private int weight() {
			int sum = this.weight;
			for (Node leaf : leafs.values()) {
				sum += leaf.weight();
			}
			return sum;
		}

		private Node diffNode() {
			int diffWeigth = 0;
			Map<Integer, Long> collect = leafs.values().stream().map(n -> n.weight()).collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
            
            for (Entry<Integer, Long> entry : collect.entrySet()) {
				if (entry.getValue() == 1) {
					diffWeigth = entry.getKey();
				}
            }
            
			for (Node leaf : leafs.values()) {
            
                if (leaf.weight() == diffWeigth) {
					return leaf;
				}
            
            }

		}

	}

}