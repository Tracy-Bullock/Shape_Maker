/**
 * @author Tracy Bullock
 * CMSC 335 7382 Object-Oriented and Concurrent Programming (2218)
 * Project 2
 * November 16, 2021
 * Created with Eclipse IDE
 * 
 * Shape.java - A class that creates an object of type shape.
 * Each shape has a number of dimensions and can have one or 
 * more of the variables length, width, height, and diameter,
 * which are also prompted to the user to input when needed.
 * 
 */

package javaShapeMaker;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class Shape extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	String shapeType;
	int numofDimensions;
	double shapeLength, shapeWidth, shapeHeight, shapeDiameter, shapeRadius;
	boolean validLength, validWidth, validHeight;
	JLabel lblLength, lblWidth, lblHeight, lblDiameter;
	JTextField txtLength, txtWidth, txtHeight, txtDiameter;
	JButton btnDrawShape;
	JPanel drawingPane, measurementPane;
	DecimalFormat numFormat = new DecimalFormat("#,###.##");

	/**
	 * Shape - parameterized constructor that creates a shape,
	 * initializing the number of dimensions, shape type, and
	 * components of the JPanel.
	 * 
	 * @param dimensions of type int.
	 * @param shape of type String.
	 */
	public Shape(int dimensions, String shape) {
		numofDimensions = dimensions;
		shapeType = shape;
		initComponents();
	}
	
	/**
	 * initComponents - a method to initialize and 
	 * control all of the components of a shape.
	 */
	private void initComponents() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel lblSelectedShape = new JLabel("You have selected a " + shapeType + ".");
		lblSelectedShape.setBounds(203, 35, 184, 14);
		lblSelectedShape.setForeground(Color.WHITE);
		add(lblSelectedShape);
		
		JLabel lblMeasurements = new JLabel("Measurements:");
		lblMeasurements.setBounds(27, 86, 131, 14);
		lblMeasurements.setForeground(Color.WHITE);
		add(lblMeasurements);
		
		measurementPane = new JPanel();
		measurementPane.setBounds(27, 111, 131, 86);
		measurementPane.setBackground(Color.DARK_GRAY);
		add(measurementPane);
		measurementPane.setLayout(new GridLayout(4,2));
		
		lblLength = new JLabel("Length:");
		lblLength.setForeground(Color.WHITE);
		
		txtLength = new JTextField();
		
		lblWidth = new JLabel("Width:");
		lblWidth.setForeground(Color.WHITE);
		
		txtWidth = new JTextField();
		
		lblHeight = new JLabel("Height:");
		lblHeight.setForeground(Color.WHITE);
		
		txtHeight = new JTextField();
		
		lblDiameter = new JLabel("Diameter:");
		lblDiameter.setForeground(Color.WHITE);
		
		txtDiameter = new JTextField();
		
		btnDrawShape = new JButton("Draw Shape");
		btnDrawShape.setBounds(27, 208, 131, 23);
		btnDrawShape.addActionListener(this);
		add(btnDrawShape);
	}
	
	/**
	 * getShapeLength - a method that returns the 
	 * length of a shape.
	 * 
	 * @return shapeLength of type double.
	 */
	public double getShapeLength() {
		return shapeLength;
	}

	/**
	 * setShapeLength - a method to set the length of
	 * a shape and validate that it has been set.
	 * 
	 * @param length of type double.
	 */
	public void setShapeLength(double length) {
		this.shapeLength = length;
		setValidLength(true);
	}

	/**
	 * getShapeWidth - a method that returns the 
	 * width of a shape.
	 * 
	 * @return shapeWidth of type double.
	 */
	public double getShapeWidth() {
		return shapeWidth;
	}

	/**
	 * setShapeWidth - a method to set the width of a
	 * shape and validate that it has been set.
	 * 
	 * @param width of type double.
	 */
	public void setShapeWidth(double width) {
		this.shapeWidth = width;
		setValidWidth(true);
	}

	/**
	 * getShapeHeight - a method that return the height
	 * of a shape.
	 * 
	 * @return shapeHeight of type double.
	 */
	public double getShapeHeight() {
		return shapeHeight;
	}

	/**
	 * setShapeHeight - a method to set the height of a
	 * shape and validate that it has been set.
	 * 
	 * @param height of type double.
	 */
	public void setShapeHeight(double height) {
		this.shapeHeight = height;
		setValidHeight(true);
	}

	/**
	 * getShapeDiameter - a method that return the diameter
	 * of a shape.
	 * 
	 * @return shapeDiameter of type double.
	 */
	public double getShapeDiameter() {
		return shapeDiameter;
	}

	/**
	 * setShapeDiameter - a method to set the diameter and
	 * radius of a shape.
	 * 
	 * @param diameter of type double.
	 */
	public void setShapeDiameter(double diameter) {
		this.shapeDiameter = diameter;
		setShapeRadius(diameter / 2);
	}

	/**
	 * getShapeRadius - a method that returns the
	 * radius of a shape.
	 * 
	 * @return shapeRadius of type double.
	 */
	public double getShapeRadius() {
		return shapeRadius;
	}

	/**
	 * setShapeRadius - a method to set the
	 * radius of a shape.
	 * 
	 * @param radius of type double.
	 */
	public void setShapeRadius(double radius) {
		this.shapeRadius = radius;
	}
	
	/**
	 * isValidLength - a method to check if a valid
	 * length has been set.
	 * 
	 * @return validLength of type boolean.
	 */
	public boolean isValidLength() {
		return validLength;
	}

	/**
	 * setValidLength - a method to set if shape has 
	 * a valid length.
	 * 
	 * @param validLength of type boolean.
	 */
	public void setValidLength(boolean validLength) {
		this.validLength = validLength;
	}

	/**
	 * isValidWidth - a method to check if a valid
	 * width has been set.
	 * 
	 * @return validWidth of type boolean.
	 */
	public boolean isValidWidth() {
		return validWidth;
	}

	/**
	 * setValidWidth - a method to set if a shape has a 
	 * valid width.
	 * 
	 * @param validWidth of type boolean.
	 */
	public void setValidWidth(boolean validWidth) {
		this.validWidth = validWidth;
	}

	/**
	 * isValidHeight - a method to check if a valid
	 * height has been set.
	 * 
	 * @return validHeight of type boolean.
	 */
	public boolean isValidHeight() {
		return validHeight;
	}

	/**
	 * setValidHeight - a method to set if a shape has a 
	 * valid height.
	 * 
	 * @param validHeight of type boolean.
	 */
	public void setValidHeight(boolean validHeight) {
		this.validHeight = validHeight;
	}
	
	/**
	 * resetValidityChecks - a method to reset all validity
	 * checks for each measurment.
	 */
	public void resetValidityChecks() {
		setValidLength(false);
		setValidWidth(false);
		setValidHeight(false);
	}

	/**
	 * validateInput - a method to validate the user's input.
	 * 
	 * @param measurement of type String.
	 * @param input of type String.
	 * @return userInput of type double.
	 * @throws InvalidInputException
	 */
	public double validateInput(String measurement, String input) throws InvalidInputException {
		double userInput;
		
		if (input.isBlank()) {
			throw new InvalidInputException(measurement + " must have a value!");
		} else if (!input.matches("[0-9.-]{1,50}")) {
			throw new InvalidInputException("Only valid numeric values allowed!");
		} else if (input.contains("-")) {
			if (input.startsWith("-")) {
				throw new InvalidInputException("Negative numbers are not allowed!");
			} else {
				throw new InvalidInputException("Invalid Input for " + measurement + "!");
			}
		} else {
			userInput = Double.parseDouble(input);
			if (userInput == 0) {
				throw new InvalidInputException(measurement + " must be greater than 0!");
			}
		}
		return userInput;
	}

	/**
	 * actionPerformed - method that overrides original method in
	 * ActionListner and controls actions of buttons.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//overriden in child classes.
	}
	
	

}
