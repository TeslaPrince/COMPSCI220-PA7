package PA7;

import java.math.*;
import java.util.Arrays;

public class TicTacToe{
	char M[][];
	char turn;
	public TicTacToe(final int d){
		char M[][] = new char[d][d];
		turn ='x';
		for(int i = 0; i < d; i++) {
			for(int j = 0; j < d; j++) {
				M[i][j] = '\0';
			}
		}
	}
	private boolean checkWin(final int r, final int c) {
		int count = 0;
		boolean out = false;
		double D = Math.sqrt((M.length * M[0].length));
		// accross
		count = 0;
		for (int i =0; i < D; i++) {
			for (int j = 0; j < D; j++) {
				if (M[i][j] == turn) {
					count++;
				}
				if (count == D) {
					out = true;
				}
				else if(count < D && i == D - 1 && j == D - 1) {
					out = false;
				}
				else {
					out = false;
				}
			}
		}
		// down
		count = 0;
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < D; j++) {
				if (M[j][i] == turn) {
					count++;
				}
				if (count == D) {
					out = true;
				}
				else if(count < D && i == D - 1 && j == D - 1) {
					out = false;
				}
				else {
					out = false;
				}
			}
		}
		// left to right diagonal
		count = 0;
		for(int i = 0; i < D; i++) {
			if(M[i][i] == turn) {
				count++;
			}
			if (count == D) {
				out = true;
			}
			else {
				out = false;
			}
		}
		// right to left diagonal
		count = 0;
		for(int i = 0; i < D; i++) {
			if(M[i][(int)D - i] == turn) {
				count++;
			}
			if (count == D) {
				out = true;
			}
			else {
				out = false;
			}
		}
		return out;
	}
	private void printBoard() {
	 	double D = 0;
	 	if ((M.length * M[0].length) > 0) {
	 		D = Math.sqrt((M.length * M[0].length));
	 	}
	 	System.out.println("[");
		for(int i = 0; i < D; i++) {
			for(int j = 0; j < D; j++) {
				if (j > 0 && j < D-1) {
					System.out.print(M[i][j] + ", ");
				}
				else if (j == 0 || j == D - 1) {
					System.out.print(M[i][j]);
				}
			}
		}
	}
	public void play(final int[] choiceSequence){
		printBoard();
		int r = 0;
		int c = 0;
		for(int i = 0; i <= choiceSequence.length; i++) {
			int choice = choiceSequence[i];
			System.out.println("***Turn for " + turn + ": chooses " + choice + "***");
			if(choice < 0 || choice > (M.length * M[0].length)) {
				System.out.println("Invalid choice! Please choose a number between 0 and " + (M.length * M[0].length));
			}
			r = choice / (M.length * M[0].length);
			c = choice % (M.length * M[0].length);
			if(M[r][c] != '\0') {
				System.out.println("Invalid choice! " + choice + " is already taken.");
				continue;
			}
			else {
				M[r][c] = turn;
				boolean b = checkWin(r,c);
				if (b) {
					System.out.println(turn + " has won!");
					break;
				}
				else {
					continue;
				}
			}
		}
	}
}
