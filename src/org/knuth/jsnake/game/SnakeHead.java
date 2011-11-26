package org.knuth.jsnake.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


/**
 * Class, which represents the Snake
 * @author Lukas Knuth
 *
 */
public class SnakeHead{
	
	/** The Standard SeriaVersionUID */
	private static final long serialVersionUID = 1L;
	/** The Parts of the Snake */
	private ArrayList<SnakePart> parts;
	/** The Head's Point */
	private Point pos;
	
	/**
	 * Create the Snakes Head and it's first Part
	 */
	public SnakeHead(){
		// Set X and Y Positions:
		this.pos = new Point(200, 200);
		// Create the First Part:
		this.parts = new ArrayList<SnakePart>();
		parts.add(new SnakePart(pos));
		parts.add(new SnakePart(parts.get(0).getPosition()));
	}
	
	/**
	 * Paints the Snake on a Graphics-Object
	 * @param g The Graphics-Object to paint on
	 * @return The painted Graphics Object
	 */
	public Graphics paintSnake(Graphics g){
		// Paint the Head:
		g.setColor(Color.gray);
		g.fillRect(pos.getX(), pos.getY(), Game.SNAKE_PART_SIZE, Game.SNAKE_PART_SIZE);
		// Paint the Parts:
		g.setColor(Color.black);
		for (SnakePart part: parts){
			g.fillRect(part.getPosition().getX(), part.getPosition().getY(), Game.SNAKE_PART_SIZE, Game.SNAKE_PART_SIZE);
		}
		// return the Graphics:
		return g;
	}
	
	/**
	 * Checks, if the Snake has left the Field
	 * @param width Width of the Game-Field in Pixel
	 * @param height Height of the Game-Field in Pixel
	 * @return True if the Field was left, otherwise False
	 */
	public boolean leftField(int width, int height){
		if (pos.getX() > width || pos.getX() < 0 ||
			pos.getY() > height || pos.getY() < 0){
			return true;
		}
		return false;
	}
	
	/**
	 * Tests if the Snake-Head hit a Snake-Part
	 * @return True if a Part was hit, False otherwise
	 */
	public boolean hitSelf(){
		for (SnakePart part: parts){
			if (part.isHit(pos)) return true;
		}
		return false;
	}
	
	/**
	 * Adds new Snake-Parts to the Snake
	 * @param n Count of the Snake-Parts to add
	 */
	public void addParts(int n){
		for (int i = 0; i < n; i++){
			// Add the Parts
			parts.add(new SnakePart(parts.get( parts.size()-1 ).getPosition()));
		}
	}
	
	/**
	 * Returns the current Position of the Snake Head as a Point-Object
	 * @return The current Position as a Point-Object
	 */
	public Point getPoint(){
		return this.pos;
	}
	
	/**
	 * Sets the next direction to move the Snake to to Left
	 */
	public void moveLeft(){
		pos.nextMoveDirection(Point.LEFT);
	}
	
	/**
	 * Sets the next direction to move the Snake to to Right
	 */
	public void moveRight(){
		pos.nextMoveDirection(Point.RIGHT);
	}
	
	/**
	 * Sets the next direction to move the Snake to to Up
	 */
	public void moveUp(){
		pos.nextMoveDirection(Point.UP);
	}
	
	/**
	 * Sets the next direction to move the Snake to to Down
	 */
	public void moveDown(){
		pos.nextMoveDirection(Point.DOWN);
	}
	
	/**
	 * Move the whole Snake to the set direction 
	 */
	public void moveAll(){
		// Temporary Point:
		Point tmp = new Point(pos.getX(), pos.getY());
		// Move the Head:
		pos.move(Game.SPEED);
		// Move the Parts:
		for (SnakePart part: parts){
			part.setPosition(tmp);
			tmp = part.getOldPosition();
		}
	}
	
	
}
