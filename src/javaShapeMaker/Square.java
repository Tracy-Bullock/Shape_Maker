/**
 * @author Tracy Bullock 
 * CMSC 335 7382 Object-Oriented and Concurrent Programming (2218) 
 * Project 2 
 * November 16, 2021 
 * Created with Eclipse IDE
 * 
 * Square.java - A class that draws a two dimensional shape of a 
 * square and calculates the area by prompting the user for the length.
 * It is assumed that all squares are equal sides and only needs the 
 * measurement of one side to calculate the area.
 * 
 */

package javaShapeMaker;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class Square extends TwoDimensionalShape {

	private static final long serialVersionUID = 1L;

	/**
	 * Square - default constructor that calls the parent
	 * class and adds needed components.
	 */
	public Square() {
		super("Square");
		addComponents();
	}
	
	/**
	 * addComponents - method to control the needed components.
	 */
	public void addComponents() {
		measurementPane.add(lblLength);
		measurementPane.add(txtLength);
	}
	
	/**
	 * actionPerformed - method that overrides original method
	 * in ActionListener and controls button actions.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		drawingPane.removeAll();
		if (e.getSource().equals(btnDrawShape)) {
			try {
				setShapeLength(validateInput("Length", txtLength.getText()));
				setShapeWidth(shapeLength);
				drawingPane.add(new DrawShape());
				setArea(shapeWidth * shapeLength);
				add(lblArea);
				add(txtArea);
				repaint();
			} catch (InvalidInputException ix) {
				JOptionPane.showMessageDialog(null, ix.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				txtLength.setText("");
			}
		}
	}
}
