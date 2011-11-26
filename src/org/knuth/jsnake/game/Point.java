package org.knuth.jsnake.game;

/**
 * Simply represents a Point with X and Y-Position
 * @author Lukas Knuth
 *
 */
public class Point {

	/** The X-Position of this Point */
	private int x;
	/** The Y-Position of this Point */
	private int y;
	/** Constant for Moving-Direction - Left */
	public static final int LEFT = 0;
	/** Constant for Moving-Direction - Right */
	public static final int RIGHT = 1;
	/** Constant for Moving-Direction - Up */
	public static final int UP = 2;
	/** Constant for Moving-Direction - Down */
	public static final int DOWN = 3;
	/** The next direction to move to Snake to */
	private int nextDir;
	
	/**
	 * Creates the Point
	 * @param x The X-Position of the new Point
	 * @param y The Y-Position of the new Point
	 */
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Sets the next direction to move to for this Point
	 * @param direction Direction to move to
	 */
	public void nextMoveDirection(int direction){
		switch (direction) {
		case LEFT:
			if (nextDir != RIGHT){
				nextDir = direction;
			}
			break;
		case RIGHT:
			if (nextDir != LEFT){
				nextDir = direction;
			}
			break;
		case UP:
			if (nextDir != DOWN){
				nextDir = direction;
			}
			break;
		case DOWN:
			if (nextDir != UP){
				nextDir = direction;
			}
		}
		
	}
	
	/**
	 * Moves the Point to the given Direction
	 * @param speed Speed of the Moving
	 */
	public void move(int speed){
		switch (nextDir){
		case LEFT:
			this.x -= speed;
			break;
		case RIGHT:
			this.x += speed;
			break;
		case UP:
			this.y -= speed;
			break;
		case DOWN:
			this.y += speed;
			break;
		default:
			System.err.println("Can't move...");
		}
	}
	
	/**
	 * Returns the X-Position of this Point
	 * @return The Point's X-Position
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * Returns the Y-Position of this Point
	 * @return The Point's Y-Position
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * Returns a String with the current Position
	 * for Debugging stuff...
	 * @return The Debug-String
	 */
	public String toString(){
		return x+"|"+y;
	}
	
	/**
	 * Tests if the Point is equal to this Point
	 * @param p The Point to test
	 * @return True if equal, otherwise false
	 */
	public boolean gotHit(Point p, int tollerance){
		// Compute the sectors:
		double x = p.getX() - this.x;
		double y = p.getY() - this.y;
		// get the distance
		double distance = Math.sqrt ((x*x) + (y*y));
		// If the distance is less then tolerance, it was hit
		if (distance < tollerance) {
			return true;
		} else {
			return false;
		}
	}
}
