/**
 * @author Tracy Bullock
 * CMSC 335 7382 Object-Oriented and Concurrent Programming (2218)
 * Project 2
 * November 16, 2021
 * Created with Eclipse IDE
 * 
 * Circle.java - A class that creates a two dimensional shape 
 * object of a circle. This class draws a circle on the screen,
 * determines the radius of a circle, and then calculates
 * the area by prompting the user for the diameter.
 */

package javaShapeMaker;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class Circle extends TwoDimensionalShape {

	private static final long serialVersionUID = 1L;

	/**
	 * Circle - default constructor that calls the parent class and adds the
	 * components to the application.
	 */
	public Circle() {
		super("Circle");
		addComponents();
	}

	/**
	 * addComponents - a method to control the components of the application.
	 */
	public void addComponents() {
		measurementPane.add(lblDiameter);
		measurementPane.add(txtDiameter);
	}

	/**
	 * actionPerformed - method that overrides the original method within the
	 * ActionListner and controls the actions of the drawShape button.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnDrawShape)) {
			drawingPane.removeAll();
			try {
				setShapeDiameter(validateInput("Diameter", txtDiameter.getText()));
				drawingPane.add(new DrawShape());
				setArea(Math.PI * Math.pow(shapeRadius, 2));
				add(lblArea);
				add(txtArea);
				repaint();
			} catch (InvalidInputException ix) {
				JOptionPane.showMessageDialog(null, ix.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				txtDiameter.setText("");
			}
		}
	}
}
