
/**
 * This class is designed to represent a Scrabble tile, giving it's Character,
 * and it's score value in the game.
 *
 * @author Graydon Hall
 *
 */
public class Tile {
	/**
	 * letter for the tile
	 */
	private char letter;

	/**
	 * score value of the tile
	 */
	private int value;


	/**
	 * Constructs the tile class, setting default values for letter and
	 * value to A and 1, respectively.
	 */
	public Tile(){
		this.letter = 'A';
		this.value = 1;
	}

	/**
	 * Constructs the Tile class, building the tile with user specified values for letter and score.
	 * @param letter the letter on the tile
	 * @param value  the score value of the tile.
	 */
	public Tile(char letter, int value){
		this.letter = letter;
		this.value = value;
	}

	/**
	 * Returns a string representation of the tile, with tile's Letter and score
	 * @return String of the tile's Letter and Score
	 */
	@Override
	public String toString(){
		return this.letter + "[" + this.value + "]";
	}

	/**
	 * Checks whether two tiles are equal
	 * @param obj a tile object
	 * @return boolean as to whether the two tiles are equals
	 */
	@Override
	public boolean equals(Object obj) {

		// check not null
		if (obj == null) {
			return false;
		}

		// make sure we have a tile class
		if (this.getClass() != obj.getClass()){
			return false;
		}

		Tile that = (Tile) obj; // cast object to student class
		return this.toString().equals(that.toString());
	}

	/**
	 * main method used for testing the tile class
	 * @param args args
	 */
	public static void main(String[] args) {

		Tile testTile0 = new Tile();
		Tile testTile1 = new Tile();
		Tile testTile2 = new Tile('Z', 10);

		System.out.println("Tile 0: " + testTile0);
		System.out.println("Tile 1: " + testTile1);
		System.out.println("Tile 2: " + testTile2);

		// check for tile equality:
		System.out.println("Tile 0 is equal to Tile 1 is " + testTile0.equals(testTile1));
		System.out.println("Tile 0 is equal to Tile 2 is " + testTile0.equals(testTile2));

	}

}
