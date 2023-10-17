/**
 * @author Tracy Bullock 
 * CMSC 335 7382 Object-Oriented and Concurrent Programming (2218) 
 * Project 2 
 * November 16, 2021 
 * Created with Eclipse IDE
 * 
 * Triangle.java - A class that draws a two dimensional shape of
 * a triangle and calculates the area by prompting the user for the
 * width and height of the triangle.
 * 
 */

package javaShapeMaker;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class Triangle extends TwoDimensionalShape{

	private static final long serialVersionUID = 1L;

	/**
	 * Triangle - default constructor that calls the parent
	 * class and adds needed components.
	 */
	public Triangle() {
		super("Triangle");
		addComponents();
	}
	
	/**
	 * addComponents - method to control the needed components.
	 */
	public void addComponents() {
		measurementPane.add(lblHeight);
		measurementPane.add(txtHeight);
		measurementPane.add(lblWidth);
		measurementPane.add(txtWidth);
		
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
				setShapeHeight(validateInput("Height", txtHeight.getText()));
				setShapeWidth(validateInput("Width", txtWidth.getText()));
				drawingPane.add(new DrawShape());
				setArea(0.5 * shapeWidth * shapeHeight);
				add(lblArea);
				add(txtArea);
				repaint();
			} catch (InvalidInputException ix) {
				JOptionPane.showMessageDialog(null, ix.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				if (!isValidHeight()) {
					txtHeight.setText("");
				} else {
					txtWidth.setText("");
				}
			}
		}
	}
}
