 import java.util.*;
public class Npuzzle
{

	public static void main(String[] args)
	{
		//This asks the user for what size puzzle do they want to solve.
		Scanner PuzzleInput = new Scanner(System.in);
		int PuzzleSize;
                System.out.println("Enter the size!");
		PuzzleSize = PuzzleInput.nextInt();

		//This Ask the user how many times they want to shuffle the board.
		Scanner ShuffleBoard = new Scanner(System.in);
                System.out.println("Enter no. of shuffles!");
		int NumberOfShuffles;
		NumberOfShuffles = ShuffleBoard.nextInt();

		//This creates a starting puzzle and goal board (dependent on size of puzzle) in a single array then converst both to a double array.
		int[] Board = PuzzleSingleArray(PuzzleSize, NumberOfShuffles);
		int[] GoalBoard = GoalState(PuzzleSize);
		int[][] Board2D = PuzzleDoubleArray(PuzzleSize, Board);
		int[][] GoalBoard2D = PuzzleDoubleArray(PuzzleSize,
                        );

		//This is the staring puzzle configration
		PrintPuzzle(Board2D);


		//This ask the user what algotithum they want to preform.
		Scanner TestInput = new Scanner(System.in);
                System.out.println("What Algoritum do you want to preform b = breadth-first or a = A*");
		char TestMethod;
                
		TestMethod = (char)TestInput.nextByte();

		PrintPuzzle(GoalBoard2D);
	}

	public static int[] PuzzleSingleArray(int Size, int Shuffle)
	{
		int puzzle[] = new int[Size+1];  //this makes the size of the single array
		int index;
		int Shuffles = Shuffle;  //This is the input for number of shuffles

		// Put all numbers into the array
		for (index = 0; index <= Size; index++)
			puzzle[index] = index;

		// Make random numbers
		for (int i = 0; i < Shuffles; i++)  //this for loop runs for the amount of times the user wanted to shuffle
		{
			for (index = 0; index < Size; index++)
			{
				int randomIndex = (int)Math.floor(Math.random() * Size);
				int temp = puzzle[index];
				puzzle[index] = puzzle[randomIndex];
				puzzle[randomIndex] = temp;
			}
		}
		return puzzle;
	}

	//load single aray into double array
	public static int[][] PuzzleDoubleArray(int Size, int[] puzzle)
	{
		int[][] board = new int[1][1];
		if (Size == 8)
		{
			board = new int[3][3];
			int k = 0;
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					board[i][j] = puzzle[k];
					k++;
				}
			}
			return board;
		}
		else if (Size == 15)
		{
			board = new int[4][4];
			int k = 0;
			for (int i = 0; i < 4; i++)
			{
				for (int j = 0; j < 4; j++)
				{
					board[i][j] = puzzle[k];
					k++;
				}
			}
			return board;
		}
		else if (Size == 24)
		{
			board = new int[5][5];
			int k = 0;
			for (int i = 0; i < 5; i++)
			{
				for (int j = 0; j < 5; j++)
				{
					board[i][j] = puzzle[k];
					k++;
				}
			}
			return board;
		}
		else if (Size == 35)
		{
			board = new int[6][6];
			int k = 0;
			for (int i = 0; i < 6; i++)
			{
				for (int j = 0; j < 6; j++)
				{
					board[i][j] = puzzle[k];
					k++;
				}
			}
			return board;
		}
		return board;
	}

	public static int[] GoalState(int Size)
	{
		int[] Goal = new int[1];
		if (Size == 8)
		{
			Goal = new int[9];
			for (int i = 0; i < 9 - 1; i++)
				Goal[i] = i + 1;
			Goal[9 - 1] = 0;
			return Goal;
		}
		else if (Size == 15)
		{
			Goal = new int[16];
			for (int i = 0; i < 16 - 1; i++)
				Goal[i] = i + 1;
			Goal[16 - 1] = 0;
			return Goal;
		}
		else if (Size == 24)
		{
			Goal = new int[25];
			for (int i = 0; i < 25 - 1; i++)
				Goal[i] = i + 1;
			Goal[25 - 1] = 0;
			return Goal;
		}
		else if (Size == 35)
		{
			Goal = new int[36];
			for (int i = 0; i < 36 - 1; i++)
				Goal[i] = i + 1;
			Goal[36 - 1] = 0;
			return Goal;
		}
		return Goal;
	}

	public static void PrintPuzzle(int[][] Board)
	{
		for (int i = 0; i < Board.length; i++)
		{
			for (int j = 0; j < Board[0].length; j++)
			{
				System.out.print(" " + Board[i][j]);
			}
			System.out.println();
		}
	}

}
