/**
 * @author Tracy Bullock 
 * CMSC 335 7382 Object-Oriented and Concurrent Programming (2218) 
 * Project 2 
 * November 16, 2021 
 * Created with Eclipse IDE
 * 
 * ThreeDimensionalShape.java - A class that draws a three dimensional
 * shape by extending the shape class and adding a volume to the shape, allowing
 * the user to calculate it. **NOTE** shape size is drawn with a default picture and
 * not based off of the dimensions given by the user.
 * 
 */

package javaShapeMaker;

import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ThreeDimensionalShape extends Shape {

	private static final long serialVersionUID = 1L;
	private Image shapeImg;
	JPanel drawingPane;
	JLabel lblVolume;
	JTextField txtVolume;
	double volume;
	boolean drawShape = false;
	FocusListener fl;
	
	/**
	 * ThreeDimensionalShape - parameterized constructor that
	 * calls the parent class, initialized the components, and
	 * sets the image for the 3D shape. 
	 * 
	 * @param shape
	 */
	public ThreeDimensionalShape(String shape) {
		super(3, shape);
		initComponents(shape);
		setImage(shape);
	}
	
	/**
	 * initComponents - method to initialize and control the 
	 * components.
	 * 
	 * @param shape of type String.
	 */
	public void initComponents(String shape) {
		lblVolume = new JLabel("The " + shape + "'s volume is:");
		lblVolume.setBounds(27, 260, 140, 14);
		lblVolume.setForeground(Color.WHITE);
		lblVolume.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtVolume = new JTextField();
		txtVolume.setBounds(47,280,100,20);
		txtVolume.setEditable(false);
		
		drawingPane = new DrawingPane3D();
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
	 * drawShape - method to draw the shape.
	 */
	public void drawShape() {
		drawShape = true;
		repaint();
	}
	
	/**
	 * getVolume - method that returns the volume 
	 * of the shape.
	 * 
	 * @return volume of type double.
	 */
	public double getVolume() {
		return volume;
	}

	/**
	 * setVolume - method to set the volume of a shape
	 * and set txtVolume for output.
	 * 
	 * @param volume of type double.
	 */
	public void setVolume(double volume) {
		this.volume = volume;
		txtVolume.setText(numFormat.format(volume));
	}
	
	/**
	 * setImage - method to set the image of a shape to
	 * be drawn.
	 * 
	 * @param shape of type String.
	 * @return shapeImg of type Image.
	 */
	private Image setImage(String shape) {
		try {
		if (shape.equals("Cube")) {
			shapeImg = ImageIO.read(this.getClass().getResource("cube.png"));
		} else if (shape.equals("Sphere")) {
			shapeImg = ImageIO.read(this.getClass().getResource("sphere.png"));
		} else if (shape.equals("Cone")) {
			shapeImg = ImageIO.read(this.getClass().getResource("cone.png"));
		} else if (shape.equals("Cylinder")) {
			shapeImg = ImageIO.read(this.getClass().getResource("cylinder.png"));
		} else {
			shapeImg = ImageIO.read(this.getClass().getResource("torus.png"));
		}
		} catch (Exception e) {
			
		}
		return shapeImg;
	}
	
	/**
	 * resetPane - method to reset the pane when a user
	 * focuses on a text field.
	 */
	public void resetPane() {
		txtVolume.setText("");
		drawShape = false;
		repaint();
	}
	
	/**
	 * actionPerformed - method that overrides the original
	 * method of ActionListener and controls the action of 
	 * the buttons.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnDrawShape)) {
			DrawingPane3D drawingPane = new DrawingPane3D();
			add(drawingPane);
		}
	}

	/**
	 * DrawingPane3D - class to create a drawing panel to
	 * draw the shape.
	 * 
	 * @author Tracy
	 *
	 */
	class DrawingPane3D extends DrawingPane2D {
		
		private static final long serialVersionUID = 1L;
		
		/**
		 * paintComponent - method that overrides paintComonent
		 * to draw the shape on the panel.
		 */
		@Override
		public void paintComponent(Graphics g) {
			if (drawShape == true) {
				super.paintComponent(g);
				g.drawImage(shapeImg, 50, 20, this);
			}
		}
	}
}
