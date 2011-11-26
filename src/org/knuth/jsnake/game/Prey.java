package org.knuth.jsnake.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * This class represents the Pray, which increases the Size
 * of the Snake
 * @author Lukas Knuth
 *
 */
public class Prey {
	
	/** The Point which represents the Position of the Pray */
	private Point pos;
	/** Random for generating the Random Position of the Pray */
	private Random rnd;
	/** The height of the Game-Field (necessary for making it appear Randomly) */
	private int field_height;
	/** The width of the Game-Field (necessary for making it appear Randomly) */
	private int field_width;
	/** The size of the Pray in Pixel */
	private int size;
	
	/**
	 * Creates a new Prey at a Random Point
	 * @param height The height of the Game-Field
	 * @param width The width of the Game-Field
	 * @param size The Size of the Prey in Pixel
	 */
	public Prey(int height, int width, int size){
		// Set the field-size:
		this.field_height = height -10;
		this.field_width = width -10;
		this.size = size;
		// Initialize the Random:
		this.rnd = new Random();
		// Create the Pray at a Random position:
		this.huntMe();
	}
	
	/**
	 * Generates a new Position for the Prey (after hit)
	 */
	private void huntMe(){
		// Draw a Number:
		this.pos = new Point(rnd.nextInt(field_width), rnd.nextInt(field_height));
	}
	
	/**
	 * Sets the Size of the Prey
	 * @param size Size in Pixel
	 */
	public void setSize(int size){
		this.size = size;
	}
	
	/**
	 * Paints the Prey on the given Graphics Object
	 * @param g The Graphics Object to paint on
	 * @return The painted Graphics Object
	 */
	public Graphics paintPrey(Graphics g){
		// Draw the Prey:
		g.setColor(Color.red);
		g.drawOval(pos.getX(), pos.getY(), size, size);
		return g;
	}
	
	/**
	 * Tests if the Prey was hit/eaten by the Snake
	 * @param p The Point of the Snake-Head
	 * @return True if hit, otherwise false
	 */
	public boolean isHit(Point p){
		if (pos.gotHit(p, 10)){
			this.huntMe();
			return true;
		}
		return false;
	}

}
