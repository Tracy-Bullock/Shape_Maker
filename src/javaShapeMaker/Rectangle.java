/**
 * @author Tracy Bullock 
 * CMSC 335 7382 Object-Oriented and Concurrent Programming (2218) 
 * Project 2 
 * November 16, 2021 
 * Created with Eclipse IDE
 * 
 * Rectangle.java - A class that draws a two dimensional shape of
 * a rectangle and calculates the area by prompting the user for the
 * width and length. If the user gives even measurements then it will
 * be recognized as a square.
 * 
 */

package javaShapeMaker;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class Rectangle extends TwoDimensionalShape {

	private static final long serialVersionUID = 1L;

	/**
	 * Rectanlge - default constructor that calls the parent
	 * class and adds needed components.
	 */
	public Rectangle() {
		super("Rectangle");
		addComponents();
	}
	
	/**
	 * addComponents - method to control the needed components.
	 */
	public void addComponents() {
		measurementPane.add(lblLength);
		measurementPane.add(txtLength);
		measurementPane.add(lblWidth);
		measurementPane.add(txtWidth);
	}
	
	/**
	 * checkShape - a method to check to see if the rectangle has
	 * even sides. If it does, then it is a square.
	 */
	public void checkShape() {
		if (shapeLength == shapeWidth) {
			JOptionPane.showMessageDialog(null, "This would be a Square!", "SHAPE CHANGE", JOptionPane.INFORMATION_MESSAGE);
			lblArea.setText("The Square's area is:");
		} else {
			lblArea.setText("The Rectangle's area is:");
		}
	}
	
	/**
	 * actionPerformed - method that overrides original method
	 * in ActionListener and controls button actions.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnDrawShape)) {
			drawingPane.removeAll();
			resetValidityChecks();
			try {
				setShapeLength(validateInput("Length", txtLength.getText()));
				setShapeWidth(validateInput("Width", txtWidth.getText()));
				checkShape();
				drawingPane.add(new DrawShape());
				setArea(shapeWidth * shapeLength);
				add(lblArea);
				add(txtArea);
				repaint();
			} catch (InvalidInputException ix) {
				JOptionPane.showMessageDialog(null, ix.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				if (!isValidLength()) {
					txtLength.setText("");
				} else {
					txtWidth.setText("");
				}
			}
		}
	}
}
