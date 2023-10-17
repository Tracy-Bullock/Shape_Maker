/**
 * @author Tracy Bullock 
 * CMSC 335 7382 Object-Oriented and Concurrent Programming (2218) 
 * Project 2 
 * November 16, 2021 
 * Created with Eclipse IDE
 * 
 * TwoDimensionalShape.java - A class that draws a two dimensional
 * shape by extending the shape class and adding an area to the shape,
 * allowing the user to calculate the area of a given two dimensional 
 * shape.
 *  
 */

package javaShapeMaker;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class TwoDimensionalShape extends Shape {

	private static final long serialVersionUID = 1L;
	JPanel drawingPane;
	JLabel lblArea;
	JTextField txtArea;
	double area;
	FocusListener fl;

	/**
	 * TwoDimensionalShape - parameterized constructor that calles
	 * parent class and initializes the components.
	 * 
	 * @param shape of type String.
	 */
	public TwoDimensionalShape(String shape) {
		super(2, shape);
		initComponents(shape);
	}
	
	/**
	 * initComponents - method to control the components.
	 * 
	 * @param shape of type String.
	 */
	public void initComponents(String shape) {
		
		lblArea = new JLabel("The " + shape + "'s area is:");
		lblArea.setBounds(27, 260, 140, 14);
		lblArea.setForeground(Color.WHITE);
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtArea = new JTextField();
		txtArea.setBounds(45,280,100,20);
		txtArea.setEditable(false);
		
		drawingPane = new DrawingPane2D();
		add(drawingPane);
		
		fl = new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				resetPane();
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		};
		
		txtLength.addFocusListener(fl);
		txtWidth.addFocusListener(fl);
		txtHeight.addFocusListener(fl);
		txtDiameter.addFocusListener(fl);
	}
	
	/**
	 * getArea - method that returns the area of 
	 * a shape.
	 * 
	 * @return area of type double.
	 */
	public double getArea() {
		return area;
	}

	/**
	 * setArea - method to set the area of a shape
	 * and set the txtArea for output.
	 * 
	 * @param area of type double.
	 */
	public void setArea(double area) {
		this.area = area;
		txtArea.setText(numFormat.format(area));
	}
	
	/**
	 * resetPane - method to reset the JPanel once
	 * a user focuses on a text field.
	 */
	public void resetPane() {
		txtArea.setText("");
		drawingPane.removeAll();
	}

	/**
	 * DrawShape - a class that creates a canvas to
	 * draw the shape.
	 * 
	 * @author Tracy
	 *
	 */
	class DrawShape extends Canvas {

		private static final long serialVersionUID = 1L;
		
		/**
		 * DrawShape - default constructor that controls the 
		 * component.
		 */
		public DrawShape() {
			setBounds(0, 0, 385, 230);
			setBackground(Color.DARK_GRAY);
		}
		
		/**
		 * paint - overrides the paint method to draw the 
		 * shape.
		 */
		@Override
		public void paint(Graphics g) {
			
			Graphics2D g2D = (Graphics2D) g;
			g2D.setColor(Color.RED);
			if (shapeType.equals("Triangle")) {
				Polygon triangle = new Polygon();
				triangle.addPoint(0, (int)Math.round(shapeHeight));
				triangle.addPoint((int)Math.round(shapeWidth), (int)Math.round(shapeHeight));
				triangle.addPoint((int)Math.round(shapeWidth) /2, 0);
				g2D.fill(triangle);
			} else if (shapeType.equals("Circle")) {
				g2D.fillOval(0, 0, (int)Math.round(shapeDiameter), (int)Math.round(shapeDiameter));
			} else {
				g2D.fillRect(10, 10, (int)Math.round(shapeWidth), (int)Math.round(shapeLength));
			}
		
		}
	}
}
