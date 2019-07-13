package testing.view;

import java.awt.event.*;

import javax.swing.*;
import testing.model.*;
import testing.controller.TestingController;

public class TestingPanel extends JPanel 
{
	private MVCFactory factory;
	private TestingController baseController;
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JLabel weightLabel;
	private JLabel sizeLabel;
	private JTextField nameField;
	private JTextField descriptionField;
	private JTextField weightField;
	private JTextField sizeField;
	private JButton createWidgetButton;
	private JButton createWhatsitButton;
	private SpringLayout baseLayout;
	
	public TestingPanel(TestingController baseController)
	{
		this.baseController = baseController;
		
		nameLabel = new JLabel("Type the name of the Whatsit");
		descriptionLabel = new JLabel("Decribe the Widget");
		weightLabel = new JLabel("Enter the weight of the Widget");
		sizeLabel = new JLabel("Enter the size of the Whatsit");
		
		nameField = new JTextField(20);
		descriptionField = new JTextField(20);
		weightField = new JTextField(10);
		sizeField = new JTextField(10);
		
		createWidgetButton = new JButton("Make a Widget");
		createWhatsitButton = new JButton("Make a Whatsit");
		
		baseLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, createWidgetButton, 0, SpringLayout.NORTH, createWhatsitButton);
		baseLayout.putConstraint(SpringLayout.WEST, createWidgetButton, 0, SpringLayout.WEST, descriptionField);
		baseLayout.putConstraint(SpringLayout.NORTH, createWhatsitButton, 83, SpringLayout.SOUTH, sizeField);
		baseLayout.putConstraint(SpringLayout.WEST, createWhatsitButton, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.NORTH, weightLabel, 0, SpringLayout.NORTH, sizeLabel);
		baseLayout.putConstraint(SpringLayout.WEST, weightLabel, 0, SpringLayout.WEST, descriptionField);
		baseLayout.putConstraint(SpringLayout.WEST, sizeLabel, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.SOUTH, sizeLabel, -15, SpringLayout.NORTH, sizeField);
		baseLayout.putConstraint(SpringLayout.NORTH, nameLabel, 0, SpringLayout.NORTH, descriptionLabel);
		baseLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.WEST, descriptionLabel, 0, SpringLayout.WEST, descriptionField);
		baseLayout.putConstraint(SpringLayout.SOUTH, descriptionLabel, -9, SpringLayout.NORTH, descriptionField);
		baseLayout.putConstraint(SpringLayout.NORTH, weightField, 0, SpringLayout.NORTH, sizeField);
		baseLayout.putConstraint(SpringLayout.WEST, weightField, 0, SpringLayout.WEST, descriptionField);
		baseLayout.putConstraint(SpringLayout.WEST, nameField, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sizeField, 80, SpringLayout.SOUTH, nameField);
		baseLayout.putConstraint(SpringLayout.WEST, sizeField, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.NORTH, nameField, 0, SpringLayout.NORTH, descriptionField);
		baseLayout.putConstraint(SpringLayout.NORTH, descriptionField, 96, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, descriptionField, -93, SpringLayout.EAST, this);
	}
	
	private void setupPanel()
	{	
		this.setSize(700, 700);
		this.setLayout(baseLayout);
		this.add(createWhatsitButton);
		this.add(createWidgetButton);
		this.add(descriptionField);
		this.add(nameField);
		this.add(sizeField);
		this.add(weightField);
		this.add(descriptionLabel);
		this.add(nameLabel);
		this.add(sizeLabel);
		this.add(weightLabel);
	}
	
	private boolean checkInteger(String currentInput)
	{
		boolean isInteger = false;
		
		try
		{
			Integer.parseInt(currentInput);
			isInteger = true;
		}
		catch(NumberFormatException currentException)
		{
			JOptionPane.showMessageDialog(this, "Please type an integer in the size field");
		}
		return isInteger;
	}
	
	private boolean checkDouble(String currentInput)
	{
		boolean isDouble = false;
		
		try
		{
			Double.parseDouble(currentInput);
			isDouble = true;
		}
		catch(NumberFormatException currentException)
		{
			JOptionPane.showMessageDialog(this, "Please type an double in the weight field");
		}
		return isDouble;
	}
	
	private void setupListeners()
	{
		createWidgetButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				String description = descriptionField.getText();
				double currentWeight = 0.0;
				if(checkDouble(weightField.getText()))
				{
					currentWeight = Double.parseDouble(weightField.getText());
					if(baseController.getAppFactory().makeWidget(currentWeight, description))
					{
						JOptionPane.showMessageDialog(baseController.getAppFrame(), "Congrats, succesfully created a widget.");
					}
					else
					{
						JOptionPane.showMessageDialog(baseController.getAppFrame(), "The number of resources to make widget not enough.");
					}
				}
			}
		});
		
		createWhatsitButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				String name = nameField.getText();
				int currentSize = 0;
				if(checkInteger(sizeField.getText()))
				{
					currentSize = Integer.parseInt(sizeField.getText());
					if(baseController.getAppFactory().makeWhatsit(currentSize, name))
					{
						JOptionPane.showMessageDialog(baseController.getAppFrame(), "Congrats, succesfully created a whatsit.");
					}
					else
					{
						JOptionPane.showMessageDialog(baseController.getAppFrame(), "The number of resources to make whatsit not enough.");
					}
				}
			}
		});
	}
}
