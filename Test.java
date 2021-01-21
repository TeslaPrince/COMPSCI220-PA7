package PA7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	
	private static final String FOLDER_PATH = "src/PA7/"; // adjust the folder path according to your setup

	public static void test(String filePath) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		int dimension = Integer.parseInt(br.readLine());
		String[] tokens = br.readLine().split(" ");
		int[] testSequence = new int[tokens.length];
		for (int i = 0; i < tokens.length; i++)
			testSequence[i] = Integer.parseInt(tokens[i]);
		new TicTacToe(dimension).play(testSequence);
		br.close();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException { 
		test(FOLDER_PATH + "3by3_XWins.txt");
		System.out.println();
		test(FOLDER_PATH + "3by3_YWins.txt");
		System.out.println();
		test(FOLDER_PATH + "3by3_Draw.txt");
		System.out.println();
		test(FOLDER_PATH + "4by4_XWins.txt");
		System.out.println();
		test(FOLDER_PATH + "4by4_YWins.txt");
		System.out.println();
		test(FOLDER_PATH + "4by4_Draw.txt");
	}
}