/**
 * @author Tracy Bullock 
 * CMSC 335 7382 Object-Oriented and Concurrent Programming (2218) 
 * Project 2 
 * November 16, 2021 
 * Created with Eclipse IDE
 * 
 * Torus.java - A class that draws a three dimensional
 * shape of a torus and calculates the volume by prompting 
 * the user for the inner and outer diameter. Shape is drawn with
 * default image and not based on sizes given by user.
 * 
 */

package javaShapeMaker;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Torus extends ThreeDimensionalShape {

	private static final long serialVersionUID = 1L;
	JTextField txtInnerDiameter, txtOuterDiameter;
	double innerDiameter, outerDiameter, innerRadius, outerRadius;
	boolean validInner, validOuter;

	/**
	 * Torus - default constructor that calls the parent
	 * class and adds needed components.
	 */
	public Torus() {
		super("Torus");
		addComponents();
	}
	
	/**
	 * addComponents - method to control the needed components.
	 */
	public void addComponents() {
		
		JLabel lblInnerDiameter = new JLabel("Inner-Diameter:");
		lblInnerDiameter.setForeground(Color.WHITE);
		measurementPane.add(lblInnerDiameter);
		
		txtInnerDiameter = new JTextField();
		txtInnerDiameter.addFocusListener(fl);
		measurementPane.add(txtInnerDiameter);
		
		JLabel lblOuterDiameter = new JLabel("Outer-Diameter:");
		lblOuterDiameter.setForeground(Color.WHITE);
		measurementPane.add(lblOuterDiameter);
	
		txtOuterDiameter = new JTextField();
		txtInnerDiameter.addFocusListener(fl);
		measurementPane.add(txtOuterDiameter);
	}
	
	/**
	 * getInnerDiameter - method that returns the inner
	 * diameter of the shape.
	 * 
	 * @return innerDiameter of type double.
	 */
	public double getInnerDiameter() {
		return innerDiameter;
	}

	/**
	 * setInnerDiameter - method to set the inner diameter
	 * and radius of a shape.
	 * 
	 * @param innerDiameter of type double.
	 */
	public void setInnerDiameter(double innerDiameter) {
		this.innerDiameter = innerDiameter;
		setInnerRadius(innerDiameter / 2);
	}

	/**
	 * getOuterDiameter - method that returns the outer
	 * diameter of a shape.
	 * 
	 * @return outDiameter of type double.
	 */
	public double getOuterDiameter() {
		return outerDiameter;
	}

	/**
	 * setOuterDiameter - method to set the outer diameter
	 * and radius of a shape.
	 * 
	 * @param outerDiameter of type double.
	 * @throws InvalidInputException.
	 */
	public void setOuterDiameter(double outerDiameter) throws InvalidInputException {
		if (outerDiameter <= innerDiameter) {
			throw new InvalidInputException("The outer diameter must be larger than the inner diameter!");
		}
		this.outerDiameter = outerDiameter;
		setOuterRadius(outerDiameter / 2);
	}

	/**
	 * getInnerRadius - method that returns the inner radius
	 * of a shape.
	 * 
	 * @return innerRadius of type double.
	 */
	public double getInnerRadius() {
		return innerRadius;
	}

	/**
	 * setInnerRadius - method that sets the inner 
	 * radius of a shape.
	 * 
	 * @param innerRadius of type double.
	 */
	public void setInnerRadius(double innerRadius) {
		this.innerRadius = innerRadius;
		setValidInner(true);
	}

	/**
	 * getOuterRadius - method that returns the outer 
	 * radius of a shape.
	 * 
	 * @return outerRadius of type double.
	 */
	public double getOuterRadius() {
		return outerRadius;
	}

	/**
	 * setOuterRadius - method to set the outer radius
	 * of a shape.
	 * 
	 * @param outerRadius of type double.
	 */
	public void setOuterRadius(double outerRadius) {
		this.outerRadius = outerRadius;
		setValidOuter(true);
	}
	
	/**
	 * isValidInner - a method to check if a valid
	 * inner diameter has been set.
	 * 
	 * @return validInner of type boolean.
	 */
	public boolean isValidInner() {
		return validInner;
	}

	/**
	 * setValidInner - a method to set if shape has 
	 * a valid inner diameter.
	 * 
	 * @param validInner of type boolean.
	 */
	public void setValidInner(boolean validInner) {
		this.validInner = validInner;
	}

	/**
	 * isValidOuter - a method to check if a valid
	 * outer diameter has been set.
	 * 
	 * @return validOuter of type boolean.
	 */
	public boolean isValidOuter() {
		return validOuter;
	}

	/**
	 * setValidOuter - a method to set if shape has 
	 * a valid outer diameter.
	 * 
	 * @param validOuter of type boolean.
	 */
	public void setValidOuter(boolean validOuter) {
		this.validOuter = validOuter;
	}

	/**
	 * resetValidityChecks - a method to reset all validity
	 * checks for each measurment.
	 */
	@Override
	public void resetValidityChecks() {
		setValidInner(false);
		setValidOuter(false);
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
				setInnerDiameter(validateInput("Inner diameter", txtInnerDiameter.getText()));
				setOuterDiameter(validateInput("Outer diameter", txtOuterDiameter.getText()));
				setVolume(2 * Math.pow(Math.PI, 2) * (outerRadius * Math.pow(innerRadius, 2)));
				add(lblVolume);
				add(txtVolume);
				drawShape();
			} catch (InvalidInputException ix) {
				JOptionPane.showMessageDialog(null, ix.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				if (!isValidInner()) {
					txtInnerDiameter.setText("");
				} else {
					txtOuterDiameter.setText("");
				}
			}
		}
	}
}
