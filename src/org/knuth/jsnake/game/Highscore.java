package org.knuth.jsnake.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Manages the High-Scores for the Game.
 * 
 * This enumeration is a Singleton!
 * @author Lukas Knuth
 *
 */
public enum Highscore {
	
	INSTANCE;
	
	private long highscore = -1;
	
	/**
	 * Reads the High-Score (on first execution) and saves
	 *  it for later use.
	 *  
	 * This method should be preferred to {@code readHighscore()}
	 *  as it caches the result and does not read the File
	 *  every time it's called.
	 * @return
	 */
	public long getHighscore(){
		if (highscore == -1){
			// Has not been read:
			this.highscore = readHighscore();
		}
		return highscore;
	}
	
	/**
	 * Reads the High-Score from the {@code highscore.conf}-File
	 *  in the same directory as the Game.
	 * @return The High-Score read from the file.
	 */
	public long readHighscore(){
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("highscore.conf"))));
			String input = in.readLine();
			return Long.parseLong(input);
		} catch (Exception e) {
			// There is no High-Score file:
			return 0;
		} finally {
			// Close the Stream
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Write a new High-Score to the {@code highscore.conf}-File
	 *  in the same directory as the Game.
	 *  
	 * If there is no such file, the Game will create it.
	 * @param new_score The new High-Score.
	 */
	public void writeHighscore(long new_score){
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("highscore.conf"))));
			out.write(""+new_score);
			out.flush();
			this.highscore = new_score;
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
