package view;

import java.awt.Container;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Secondary window solely for displaying the total revenue since the program started. 
 * 
 *
 */
public class TotalRevenueView extends JFrame implements Observer
{

	double totRev;
	JLabel totRevLabel = new JLabel("0:-");
	
	public TotalRevenueView()
	{
		super("Total Revenue"); 
		
		//Set window options: 
		setSize(300,150); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane(); 
		contentPane.add(totRevLabel);
		setVisible (true);
		totRevLabel.setFont(new Font("Arial", Font.PLAIN, 30));
	}

	public void update(Observable o, Object arg) 
	{
		totRev += (Double)arg;
		totRevLabel.setText(totRev + ":-");	
	}

}
