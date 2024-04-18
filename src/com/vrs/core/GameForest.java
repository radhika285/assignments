package com.vrs.core;

import java.util.Random;

public class GameForest {
	static char array[][];
	static Random generator = new Random();
	static final char[] charactersData = new char[] { '.', 'T' };

	public static void main(String args[]) {

		char[][] forest = generateForest(3, 3);
		displayForest(forest);
		movePlayer(forest, 'D');
	}

	public static char[][] generateForest(int rows, int cols) {
		array = new char[rows][cols];
		for (int i = 0; i < 3; i++) {
			for (int y = 0; y < 3; y++) {
				array[i][y] = getRandomNumber('.');
			}
		}
		while (array[generator.nextInt(3)][generator.nextInt(3)] != 'T') {
			array[generator.nextInt(3)][generator.nextInt(3)] = 'P';
			break;
		}
		return array;
	}

	public static char getRandomNumber(char val) {
		int p = generator.nextInt(10);
		if (p < 3) {
			return charactersData[generator.nextInt(charactersData.length)];
		} else {
			return val;
		}
	}

	public static void displayForest(char[][] forest) {
		for (int i = 0; i < 3; i++) {
			for (int y = 0; y < 3; y++) {
				System.out.println(forest[i][y]);
			}
		}
	}

	/**
	 * 'W' for Up, 'S' for Down, 'A' for Left, 'D' for Right
	 * 
	 * @param forest
	 * @param direction
	 */

	public static void movePlayer(char[][] forest, char direction) {
		int row = forest.length;
		int col = forest[0].length;
		System.out.println(row);
		System.out.println(col);
		int i = 0;
		int j = 0;
		if (direction == 'W') {
			try {
				while (array[i][j] != 'T' && i <= row && j <= col) {
					System.out.println("Move is valid");
					i++;
					j++;
					movePlayer();
					array[i][j] = 'P';
					break;
				}
			} catch (Exception ex) {
				System.out.println("Move is invalid");
			}

		} else if (direction == 'S') {
			System.out.println(row);
			System.out.println(col);
			int p = row;
			int q = col;

			while (array[p-1][q-1] != 'T' && p >= row && q >= col) {
				System.out.println("Move is valid");
				p--;
				q--;
				movePlayer();
				array[p][q] = 'P';
				break;
			}

		} else if (direction == 'A') {
			int r = row / 2;
			int s = col / 2;
			while (array[r][s] != 'T' && r <= row && s <= col) {
				System.out.println("Move is valid");
				r--;
				s--;
				movePlayer();
				array[r][s] = 'P';
				break;
			}
		}

		else if (direction == 'D') {
			int g = row / 2;
			int h = col / 2;
			while (array[g][h] != 'T' && g <= row && h <= col) {
				System.out.println("Move is valid");
				g++;
				h++;
				movePlayer();
				array[g][h] = 'P';
				break;
			}

		}

	}

	private static void movePlayer() {
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++) {
				if (array[a][b] == 'P') {
					array[a][b] = '.';
				}
			}
		}
	}

}
