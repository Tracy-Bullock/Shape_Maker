/**
 * @author Tracy Bullock 
 * CMSC 335 7382 Object-Oriented and Concurrent Programming (2218) 
 * Project 2 
 * November 16, 2021 
 * Created with Eclipse IDE
 * 
 * Cube.java - A class that draws a three dimensional
 * shape of a cube and calculates the volume by prompting
 * the user for the width. It is assumed that all cubes have 
 * equal sides. Shape is drawn with default image and not 
 * based on sizes given by user.
 * 
 */

package javaShapeMaker;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class Cube extends ThreeDimensionalShape {

	private static final long serialVersionUID = 1L;

	/**
	 * Cube - default constructor that calls the parent
	 * class and adds needed components.
	 */
	public Cube() {
		super("Cube");
		addComponents();
	}
	
	/**
	 * addComponents - method to control the needed components.
	 */
	public void addComponents() {
		measurementPane.add(lblHeight);
		measurementPane.add(txtHeight);
	}
	
	/**
	 * actionPerformed - method that overrides original method
	 * in ActionListener and controls button actions.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnDrawShape)) {
			try {
				setShapeHeight(validateInput("Height", txtHeight.getText()));
				shapeLength = shapeWidth = shapeHeight;
				setVolume(Math.pow(shapeHeight, 3));
				add(lblVolume);
				add(txtVolume);
				drawShape();
			} catch (InvalidInputException ix) {
				JOptionPane.showMessageDialog(null, ix.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				txtHeight.setText("");
			}
		}
	}
}
