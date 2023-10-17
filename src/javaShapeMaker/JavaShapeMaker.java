/**
 * @author Tracy Bullock
 * CMSC 335 7382 Object-Oriented and Concurrent Programming (2218)
 * Project 2
 * November 16, 2021
 * Created with Eclipse IDE
 * 
 * JavaShapeMaker.java - The main class that prompts the user to
 * select a shape and then asks for specific deminsions of the 
 * shape to draw the shape and provide the area or volume of
 * that shape. Shapes can can only be drawn to a certain size,
 * therefor the screen is not resizable. However, shape dimensions
 * are not limited and will always give the correct area or volume.
 */

package javaShapeMaker;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class JavaShapeMaker extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel mainPane, contentPane;
	private CardLayout cardLayout = new CardLayout();
	private final ButtonGroup rbButtonGroup = new ButtonGroup();
	private JRadioButton rbTwoDimensional, rbThreeDimensional;
	private JComboBox<String> cbShapes;
	private JButton btnCreateShape, btnReturnToMenu;
	private final String[] twoDimShapes = {"Select Shape", "Circle", "Square", "Triangle", "Rectangle"};
	private final String[] threeDimShapes = {"Select Shape", "Sphere", "Cube", "Cone", "Cylinder", "Torus"};

	/**
	 * main - the main method that customized the dialog boxes
	 * and creates the frame.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		JDialog.setDefaultLookAndFeelDecorated(true);
		UIManager.put("OptionPane.messageFont", new FontUIResource("Tahoma", Font.BOLD, 12));
		UIManager.put("OptionPane.background", new ColorUIResource(Color.DARK_GRAY));
		UIManager.put("OptionPane.messageForeground", new ColorUIResource(Color.WHITE));
		UIManager.put("Panel.background", new ColorUIResource(Color.DARK_GRAY));
		
		JavaShapeMaker frame = new JavaShapeMaker();
		frame.setVisible(true);

	}
	
	/**
	 * JavaShapeMaker - default constructor that 
	 * initializes the components.
	 */
	public JavaShapeMaker() {
		initComponents();
	}
	
	/**
	 * initComponents - a method to initialize all of the components
	 * within the class.
	 */
	public void initComponents() {
		setTitle("Java Shape Maker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		
		try {
			Image shapeImg = ImageIO.read(this.getClass().getResource("logo.png"));
			setIconImage(shapeImg);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "An error has occured with the logo!", 
					"LOGO ERROR", JOptionPane.WARNING_MESSAGE);
		}
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);
		
		mainPane = new JPanel();
		mainPane.setBackground(Color.DARK_GRAY);
		mainPane.setLayout(null);
		contentPane.add(mainPane, "Menu");
		
		cardLayout.show(contentPane, "Menu");
		
		JLabel lblSelectShape = new JLabel("Please select a shape to create.");
		lblSelectShape.setForeground(Color.WHITE);
		lblSelectShape.setBounds(203, 35, 184, 14);
		mainPane.add(lblSelectShape);
		
		cbShapes = new JComboBox<String>();
		cbShapes.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Shape"}));
		cbShapes.setSelectedIndex(0);
		cbShapes.addActionListener(this);
		cbShapes.setEnabled(false);
		cbShapes.setToolTipText("Select shape Dimensions first!");
		cbShapes.setBounds(222, 150, 156, 22);
		mainPane.add(cbShapes);
		
		rbTwoDimensional = new JRadioButton("Two Dimensional");
		rbTwoDimensional.setBackground(Color.LIGHT_GRAY);
		rbTwoDimensional.addActionListener(this);
		rbButtonGroup.add(rbTwoDimensional);
		rbTwoDimensional.setBounds(160, 90, 132, 23);
		mainPane.add(rbTwoDimensional);
		
		rbThreeDimensional = new JRadioButton("Three Dimensional");
		rbThreeDimensional.setBackground(Color.LIGHT_GRAY);
		rbThreeDimensional.addActionListener(this);
		rbButtonGroup.add(rbThreeDimensional);
		rbThreeDimensional.setBounds(310, 90, 145, 23);
		mainPane.add(rbThreeDimensional);
		
		btnCreateShape = new JButton("Create Shape");
		btnCreateShape.setBounds(237, 292, 126, 23);
		btnCreateShape.addActionListener(this);
		disableButton();
		mainPane.add(btnCreateShape);
		
		btnReturnToMenu = new JButton("Return to menu");
		btnReturnToMenu.setBounds(237, 292, 126, 23);
		btnReturnToMenu.addActionListener(this);
	}

	/**
	 * actionPerformed - method that overrides the original
	 * method within the ActionListner and controls the
	 * actions for the radio buttons, comboBox, and other
	 * buttons.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(rbTwoDimensional)) {
			cbShapes.setModel(new DefaultComboBoxModel<String>(twoDimShapes));
			disableButton();
		} else if (e.getSource().equals(rbThreeDimensional)) {
			cbShapes.setModel(new DefaultComboBoxModel<String>(threeDimShapes));
			disableButton();
		} else if (e.getSource().equals(cbShapes)) {
			if (!(cbShapes.getSelectedIndex() == 0)) {
				btnCreateShape.setEnabled(true);
				btnCreateShape.setToolTipText(null);
			} else {
				disableButton();
			}
		} else if (e.getSource().equals(btnCreateShape)) {
			if (cbShapes.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null, "You must select a Shape!", 
						"ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				changePanels("CreateShape");
			}
		} else {
			changePanels("Menu");
		}
		
		cbShapes.setEnabled(true);
		cbShapes.setToolTipText(null);
	}
	
	/**
	 * disableButton - method to disable the createShape
	 * button and reduce code duplication.
	 */
	public void disableButton() {
		btnCreateShape.setEnabled(false);
		btnCreateShape.setToolTipText("Select a shape first!");
	}
	
	/**
	 * changePanels - a method to change the panels
	 * on the cardLayout and switch between creating
	 * a shape and the main menu.
	 * 
	 * @param command of type String.
	 */
	public void changePanels(String command) {
		if (command.equals("CreateShape")) {
			Shape s = createShape(cbShapes);
			s.add(btnReturnToMenu);
			contentPane.add(s, "Shape");
			cardLayout.show(contentPane, "Shape");
		} else {
			cardLayout.show(contentPane, "Menu");
		}
		disableButton();
		rbButtonGroup.clearSelection();
		cbShapes.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Shape"}));
		cbShapes.setToolTipText("Select shape Dimensions first!");
	}
	
	/**
	 * createShape - method to create the shape once
	 * the user has selected it from the main menu.
	 * 
	 * @param cb of type JComboBox<String>
	 * @return specified shape of type Shape.
	 */
	public Shape createShape(JComboBox<String> cb) {
		String shape = cb.getSelectedItem().toString();
		if (shape.equals("Circle")) {
			return new Circle();
		} else if(shape.equals("Square")) {
			return new Square();
		} else if(shape.equals("Rectangle")){
			return new Rectangle();
		} else if(shape.equals("Triangle")) {
			return new Triangle();
		} else if (shape.equals("Cone")) {
			return new Cone();
		} else if (shape.equals("Cube")) {
			return new Cube();
		} else if (shape.equals("Cylinder")) {
			return new Cylinder();
		} else if(shape.equals("Sphere")) {
			return new Sphere();
		} else {
			return new Torus();
		}
	}

}
