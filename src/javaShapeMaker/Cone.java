/**
 * @author Tracy Bullock 
 * CMSC 335 7382 Object-Oriented and Concurrent Programming (2218) 
 * Project 2 
 * November 16, 2021 
 * Created with Eclipse IDE
 * 
 * Cone.java - A class that draws a three dimensional
 * shape of a cone and calculates the volume by prompting 
 * the user for the diameter and height. Shape is drawn with
 * default image and not based on sizes given by user.
 * 
 */

package javaShapeMaker;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class Cone extends ThreeDimensionalShape {

	private static final long serialVersionUID = 1L;

	/**
	 * Cone - default constructor that calls the parent
	 * class and adds needed components.
	 */
	public Cone() {
		super("Cone");
		addComponents();
	}
	
	/**
	 * addComponents - method to control the needed components.
	 */
	public void addComponents() {
		measurementPane.add(lblHeight);
		measurementPane.add(txtHeight);
		measurementPane.add(lblDiameter);
		measurementPane.add(txtDiameter);
	}
	
	/**
	 * actionPerformed - method that overrides original method
	 * in ActionListener and controls button actions.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnDrawShape)) {
			resetValidityChecks();
			try {
				setShapeHeight(validateInput("Height", txtHeight.getText()));
				setShapeDiameter(validateInput("Diameter", txtDiameter.getText()));
				setVolume(1.0/3.0 * Math.PI * Math.pow(shapeRadius, 2) * shapeHeight);
				add(lblVolume);
				add(txtVolume);
				drawShape();
			} catch (InvalidInputException ix) {
				JOptionPane.showMessageDialog(null, ix.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				if (!isValidHeight()) {
					txtHeight.setText("");
				} else {
					txtDiameter.setText("");
				}
			}
		}
	}
}
