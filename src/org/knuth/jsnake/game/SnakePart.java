package org.knuth.jsnake.game;


/**
 * Represents a Part of the Snake
 * @author Lukas Knuth
 *
 */
public class SnakePart{
	
	/** The Standard SeriaVersionUID */
	private static final long serialVersionUID = 1L;
	/** The Point of this Snake-Part */
	private Point pos;
	/** The Previous position of the Part */
	private Point old_pos;
	
	/**
	 * Create a new Snake-Part
	 * @param pos Point of the last Part
	 */
	public SnakePart(Point pos){
		// Set the new Point
		this.pos = new Point(pos.getX(), pos.getY()+Game.SNAKE_PART_SIZE);
		this.old_pos = null;
	}
	
	/**
	 * Returns the current Position
	 * @return The Current Position of the Part
	 */
	public Point getPosition(){
		return this.pos;
	}
	
	/**
	 * Returns the previous Position
	 * @return The previous Position of the Part
	 */
	public Point getOldPosition(){
		return this.old_pos;
	}
	
	/**
	 * Move the Snake-Part to the given Point
	 * @param p The Point to move the Part to
	 */
	public void setPosition(Point p){
		// Store the Old Position:
		this.old_pos = this.pos;
		// Set the New Position:
		this.pos = p;
	}
	
	/**
	 * Tests if the Part of the Snake was hit
	 * @param p Represents the Point of the Snake-Head
	 * @return True if the Head hit the Part
	 */
	public boolean isHit(Point p){
		return this.pos.gotHit(p, 10);
	}
}
