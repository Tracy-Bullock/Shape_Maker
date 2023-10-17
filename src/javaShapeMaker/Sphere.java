/**
 * @author Tracy Bullock 
 * CMSC 335 7382 Object-Oriented and Concurrent Programming (2218) 
 * Project 2 
 * November 16, 2021 
 * Created with Eclipse IDE
 * 
 * Sphere.java - A class that draws a three dimensional
 * shape of a sphere and calculates the volume by prompting 
 * the user for the diameter. Shape is drawn with
 * default image and not based on sizes given by user.
 * 
 */

package javaShapeMaker;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class Sphere extends ThreeDimensionalShape {

	private static final long serialVersionUID = 1L;

	/**
	 * Sphere - default constructor that calls the parent
	 * class and adds needed components.
	 */
	public Sphere() {
		super("Sphere");
		addComponents();
	}
	
	/**
	 * addComponents - method to control the needed components.
	 */
	public void addComponents() {
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
			try {
				setShapeDiameter(validateInput("Diameter", txtDiameter.getText()));
				setVolume(4.0/3.0 * Math.PI * Math.pow(shapeRadius, 3));
				add(lblVolume);
				add(txtVolume);
				drawShape();
			} catch (InvalidInputException ix) {
				JOptionPane.showMessageDialog(null, ix.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				txtDiameter.setText("");
			}
		}
	}
}
