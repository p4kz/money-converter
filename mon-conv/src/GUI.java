import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {

	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		
		// Window config
		frame.setSize(310, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		// Create label
		JLabel userLabel = new JLabel("Valor para ser convertido");
		userLabel.setBounds(10, 20, 250, 25);
		panel.add(userLabel);
		
		// Create input
		JTextField userText = new JTextField(20);
		userText.setBounds(200, 20, 100, 25);
		panel.add(userText);
		
		// Create label result
		JLabel result = new JLabel("");
		result.setBounds(10, 50, 290, 25);
		panel.add(result);
		
		// Create button converter
		JButton buttonConverter = new JButton("Converter");
		buttonConverter.setBounds(10, 80, 290, 25 );
		panel.add(buttonConverter);
		
		buttonConverter.addActionListener(new GUI());
		

		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Click");
	}

}
