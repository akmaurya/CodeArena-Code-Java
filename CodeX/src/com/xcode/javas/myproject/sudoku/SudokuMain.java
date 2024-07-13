package com.xcode.javas.myproject.sudoku;

import java.util.Scanner;

public class SudokuMain
{
    public static void main(String[] args)
    {
    	int matrix[][] = new int[9][9];
    	Scanner input = new Scanner(System.in);
        System.out.println("Enter SUDOKU Matrix, Fill 0 at the place of blank");
        for(int rowNum=0;rowNum<9;rowNum++)
        {
        	String row = input.nextLine();
        	for(int colNum=0;colNum<9;colNum++)
        		matrix[rowNum][colNum] = Integer.parseInt(""+row.charAt(colNum));
        }
        System.out.println("Problem Sudoku:");
        printSudoku(matrix);
        solveSudoku(matrix);
        System.out.println("\n\n\nSolution Sudoku:");
        printSudoku(matrix);
        
    }

	private static void solveSudoku(int[][] matrix) {
		fillOneBlankRow(matrix);
		fillOneBlankColumn(matrix);
		fillOneBlankMatrix(matrix);
		//fillTwoBlankRow(matrix);
		
		
		
	}
	
	
	
	private static void fillOneBlankRow(int[][] matrix) {
		
		int missedRowIndex = 0;		
		int missedColumnIndex = 0;
		for(int i=0;i<9;i++) {
			int countZero = 0;
			int sum = 0;
			for(int j=0;j<9;j++) {
				sum = sum+matrix[i][j];
				if(matrix[i][j]==0) {
					countZero++;
					missedRowIndex = i;
					missedColumnIndex = j;
				}
				if(countZero>1)
					break;
			}
			if(countZero == 1)
				matrix[missedRowIndex][missedColumnIndex] = 45-sum;
		}
		
	}

	private static void fillOneBlankColumn(int[][] matrix) {
		int missedRowIndex = 0;		
		int missedColumnIndex = 0;
		for(int i=0;i<9;i++) {
			int countZero = 0;
			int sum = 0;
			for(int j=0;j<9;j++) {
				sum = sum+matrix[j][i];
				if(matrix[j][i]==0) {
					countZero++;
					missedRowIndex = j;
					missedColumnIndex = i;
				}
				if(countZero>1)
					break;
			}
			if(countZero == 1)
				matrix[missedRowIndex][missedColumnIndex] = 45-sum;
		}
	}
	
	private static void fillOneBlankMatrix(int[][] matrix) {
		int missedRowIndex = 0;		
		int missedColumnIndex = 0;
		for(int mi=0;mi<3;mi++){
			for(int mj=0;mj<3;mj++){				
				int countZero = 0;
				int sum = 0;
				for(int i=0;i<3;i++){	
					for(int j=0;j<3;j++){
						sum = sum+matrix[mi*3+i][mj*3+j];
						if(matrix[mi*3+i][mj*3+j]==0) {
							countZero++;
							missedRowIndex = mi*3+i;
							missedColumnIndex = mj*3+j;
							
						}
						if(countZero>1)
							break;
					}
					if(countZero>1)
						break;
				}	
				if(countZero == 1)
					matrix[missedRowIndex][missedColumnIndex] = 45-sum;
			}                   
		}
	}

	


	private static void printSudoku(int[][] matrix) {
		System.out.println(" _______________________________");
        for(int rowNum=1;rowNum<=9;rowNum++)
        {
        	System.out.print(" | ");
        	for(int colNum=1;colNum<=9;colNum++) {
        		System.out.print(matrix[rowNum-1][colNum-1]!=0?matrix[rowNum-1][colNum-1]:"_");
        		if(colNum%3==0)
        		System.out.print(" | ");
        		else
        		System.out.print("  ");
        	}
        		
        	System.out.println("");
        	if(rowNum%3==0)
        		System.out.println(" _______________________________");
        }
		
	}
}
/*
100060000
980000605
000005001
000000304
060130900
040720000
093076100
006480007
500902460
*/
/*
504712369
100060000
980000605
000005001
000000304
060130900
040720000
093076100
006480007

*/
/*
504712369
100060000
980000605
000005001
200000304
360130900
440720000
693076100
706480007

 */
/*
504712303
103060000
986000605
000123001
000467304
060890902
040720459
093076236
006480107

 */
/*
027154396
905327148
340689752
593068271
472503689
618970435
786235014
154796803
239841560
*/
