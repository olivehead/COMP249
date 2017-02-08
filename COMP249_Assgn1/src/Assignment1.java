
/**
 * Olivier D'Angelo #26729916
 * COMP249 Section PP 
 * Assignment #1
 * Due Date 4/1/2017
 */
import java.util.*;

class Battleship {
	private char[][] Board;
	private static int computerGrenadesHit = 0;
	private static int playerGrenadesHit = 0;
	private final int BOARD_SIZE = 8;
	private final int SHIP_NUM = 6;
	private final int GRENADE_NUM = 4;
	private static int playerShipNum;
	private static int computerShipNum;

	/**
	 * Run the game strictly using methods within this class
	 */
	public Battleship() {
		Board = new char[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				Board[i][j] = '_';
			}
		}

	}

	/**
	 * Initialize game and select position for ship and grenade
	 */
	public void initializeHuman() {
		Scanner input = new Scanner(System.in);
		String inputPosition = null;
		System.out.println("Let's play battleship!");
		System.out.println("\n");
		for (int i = 0; i < SHIP_NUM; i++) {
			while (checkCoordinate(inputPosition) > 0) {
				switch (checkCoordinate(inputPosition)) {
				case 1:
					break;
				case 2:
				case 3:
					System.out.println("Coordinates are out of range. Try again.");
					break;
				case 4:
					System.out.println("Coordinates already used. Try again.");
					break;
				default:
					System.out.println("System error.");
				}
				System.out.println("Enter the coordinates of your ship #" + (i + 1) + ": ");
				inputPosition = input.next();
			}
			setPosition(inputPosition, 's');
			inputPosition = null;
		}
		for (int i = 0; i < GRENADE_NUM; i++) {
			while (checkCoordinate(inputPosition) > 0) {
				switch (checkCoordinate(inputPosition)) {
				case 1:
					break;
				case 2:
				case 3:
					System.out.println("Coordinates are out of range. Try again.");
					break;
				case 4:
					System.out.println("Coordinates already used. Try again.");
					break;
				default:
					System.out.println("System error.");
				}
				System.out.println("Enter the coordinates of your grenade #" + (i + 1) + ": ");
				inputPosition = input.next();

			}
			setPosition(inputPosition, 'g');
			inputPosition = null;
		}
	}

	/**
	 * Initialize computer grenade and ship positions
	 * 
	 */
	public void initializeComputer() {
		int randomRow = 0, randomColumn = 0;
		Random rand = new Random();
		for (int i = 0; i < SHIP_NUM; i++) {
			randomRow = rand.nextInt(BOARD_SIZE);
			randomColumn = rand.nextInt(BOARD_SIZE);
			while (!checkCoordinate(randomRow, randomColumn)) {
				randomRow = rand.nextInt(BOARD_SIZE);
				randomColumn = rand.nextInt(BOARD_SIZE);
			}
			Board[randomRow][randomColumn] = 'S';
		}
		for (int i = 0; i < GRENADE_NUM; i++) {
			randomRow = rand.nextInt(BOARD_SIZE);
			randomColumn = rand.nextInt(BOARD_SIZE);
			while (!checkCoordinate(randomRow, randomColumn)) {
				randomRow = rand.nextInt(BOARD_SIZE);
				randomColumn = rand.nextInt(BOARD_SIZE);
			}
			Board[randomRow][randomColumn] = 'G';
		}
		System.out.println("The computer has placed its pieces. Let's Play!");
	}

	/**
	 * Check for error in human player input coordinate
	 * 
	 * @return position of either grenade or ship
	 */
	public int checkCoordinate(String position) {
		if (position == null)
			return 1;
		if (((int) position.charAt(0)) < ((int) 'a') || ((int) position.charAt(0)) > ((int) 'h')) {
			return 2;
		}
		if ((int) position.charAt(1) < (int) '1' || (int) position.charAt(1) > (int) '8') {
			return 3;
		}
		if (getPosition(position) == 'g' || getPosition(position) == 's') {
			return 4;
		}
		return 0;
	}

	/**
	 * Checks for grenades or ships at the selected position for the computer
	 * 
	 * @param row
	 *            integer of Board
	 * @param column
	 *            integer of Board
	 * @return true if board coordinate is not already taken by ship or grenade
	 */
	public boolean checkCoordinate(int row, int column) {
		if (Board[row][column] == 'g' || Board[row][column] == 's' || Board[row][column] == 'G'
				|| Board[row][column] == 'S')
			return false;
		return true;
	}

	/**
	 * Get method to retrieve character at specified board position
	 * 
	 * @param position
	 *            coordinate ex. A6
	 * @return character at the position on board
	 */
	public char getPosition(String position) {
		int row = (int) position.charAt(1) - 49, column = (int) position.charAt(0) - 97;
		return Board[row][column];
	}

	/**
	 * Sets player and computer ships and grenades
	 * 
	 * @param position
	 *            = coordinates
	 * @param newchar
	 *            = representing ship or grenade
	 */
	public void setPosition(String position, char newchar) {
		int row = (int) position.charAt(1) - 49, column = (int) position.charAt(0) - 97;
		Board[row][column] = newchar;
	}

	/**
	 * Print out board
	 */
	public void boardStatus() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.print("\t");
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(Board[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * @param whosTurn:
	 *            true == human, false == computer
	 */
	public String playerTurn() {
		Scanner input = new Scanner(System.in);
		String coordinate = input.next();
		while (checkCoordinate(coordinate) > 0 && checkCoordinate(coordinate) != 4) {
			System.out.println("position out of bounds. Try again.");
			coordinate = input.next();
		}
		return coordinate;
	}

	public String computerTurn() {
		String coordinate = "";
		Random rand = new Random();
		int row = rand.nextInt(BOARD_SIZE), column = rand.nextInt(BOARD_SIZE);
		coordinate = String.valueOf((char) (column + 97)) + String.valueOf((char) (row + 49));
		return coordinate;
	}

	public void NextTurn(boolean whosTurn, Battleship gameBoard) {
		String coordinate;
		System.out.println("position of " + ((whosTurn) ? "your" : "my") + " rocket: ");
		if (whosTurn) {
			coordinate = playerTurn();
		} else {
			coordinate = computerTurn();
		}
		if (gameBoard.getPosition(coordinate) != '_') {
			System.out.println("Position already called.");
		} else {
			switch (getPosition(coordinate)) {
			case 's':
				System.out.println("shit hit.");
				gameBoard.setPosition(coordinate, 's');

				break;
			case 'S':
				System.out.println("shit hit.");
				gameBoard.setPosition(coordinate, 'S');
				break;
			case 'g':
				System.out.println("grenade hit.");
				gameBoard.setPosition(coordinate, 'g');
				break;
			case 'G':
				System.out.println("grenade hit.");
				gameBoard.setPosition(coordinate, 'G');
				break;
			case '_':
				System.out.println("nothing.");
				gameBoard.setPosition(coordinate, '*');
				break;
			default:
				System.out.println("Error");
				break;
			}
		}
	}

	public static void run() {
		Battleship solutionBoard = new Battleship(), gameBoard = new Battleship();
		solutionBoard.initializeHuman();
		solutionBoard.initializeComputer();
		solutionBoard.boardStatus();
	}

}

/**
 * Driver Class
 */
public class Assignment1 {
	public static void main(String[] args) {
		Battleship.run();
		
	}
}
