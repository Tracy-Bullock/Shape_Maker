/**
 * @author Tracy Bullock 
 * CMSC 335 7382 Object-Oriented and Concurrent Programming (2218) 
 * Project 2 
 * November 16, 2021 
 * Created with Eclipse IDE
 * 
 * DrawingPane2D.java - A class that creates a JPanel to draw the
 * shapes on.
 * 
 */

package javaShapeMaker;

import java.awt.Color;

import javax.swing.JPanel;

public class DrawingPane2D extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * DrawingPane2D - default constructor that controls
	 * the component.
	 */
	public DrawingPane2D() {
		setBounds(200, 60, 385, 230);
		setBackground(Color.DARK_GRAY);
	}
}
