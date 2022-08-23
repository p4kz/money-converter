import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App implements ActionListener {

	private static JLabel userValuelabel;
	private static JTextField userValueInput;
	private static JLabel result;
	private static JButton buttonConverter;
	private static JComboBox<String> comboBox;

	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();

		// Window
		frame.setSize(325, 175);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setResizable(false);
		panel.setLayout(null);

		// Create label
		userValuelabel = new JLabel("Valor para ser convertido");
		userValuelabel.setBounds(10, 10, 250, 25);
		panel.add(userValuelabel);

		// Create input
		userValueInput = new JTextField("", 20);
		userValueInput.setBounds(200, 10, 100, 25);
		panel.add(userValueInput);

		// Create combo box
		String comboBoxOptions[] = { 
			"De BRL/Real para USD/Dolar", 
			"De USD/Dolar para BRL/Real",
			"De BRL/Real para EUR/Euro",
			"De EUR/Euro para BRL/Real",
			"De BRL/Real para GBP/Libra Esterlina",
			"De GBP/Libra Esterlina para BRL/Real",
			"De BRL/Real para ARS/Peso Argentino",
			"De ARS/Peso Argentino para BRL/Real",
			"De BRL/Real para CLP/Peso Chileno",
			"De CLP/Peso Chileno para BRL/Real"
		};

		comboBox = new JComboBox<>(comboBoxOptions);
		comboBox.setBounds(10, 45, 290, 30);
		panel.add(comboBox);

		// Create label result
		result = new JLabel("");
		result.setBounds(10, 75, 290, 25);
		panel.add(result);

		// Create button converter
		buttonConverter = new JButton("Converter");
		buttonConverter.setBounds(10, 100, 290, 25);
		panel.add(buttonConverter);

		buttonConverter.addActionListener(new App());
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String userText = userValueInput.getText();
		String selectedComboBox = String.valueOf(comboBox.getSelectedItem());
		
		Convert BRLToUSD = new Convert(5.17, "$", userText);		
		Convert BRLToEUR = new Convert(5.19, "€", userText);
		Convert BRLToGBP = new Convert(6.16, "£", userText);
		Convert BRLToARS = new Convert(0.038, "$", userText);
		Convert BRLToCLP = new Convert(0.005, "$", userText);
				
		try {
			switch(selectedComboBox) {
			case "De BRL/Real para USD/Dolar":
				result.setText(BRLToUSD.valueToToken());
				break;
			case "De USD/Dolar para BRL/Real":
				result.setText(BRLToUSD.tokenToValue());
				break;
			case "De BRL/Real para EUR/Euro":
				result.setText(BRLToEUR.valueToToken());	  
				break;
			case "De EUR/Euro para BRL/Real":
				result.setText(BRLToEUR.tokenToValue());		  
				break;
			case "De BRL/Real para GBP/Libra Esterlina":
				result.setText(BRLToGBP.valueToToken());		  
				break;
			case "De GBP/Libra Esterlina para BRL/Real":
				result.setText(BRLToGBP.tokenToValue());		  
				break;
			case "De BRL/Real para ARS/Peso Argentino":
				result.setText(BRLToARS.valueToToken());		  	
				break;
			case "De ARS/Peso Argentino para BRL/Real":
				result.setText(BRLToARS.tokenToValue());
				break;
			case "De BRL/Real para CLP/Peso Chileno":
				result.setText(BRLToCLP.valueToToken());
				break;
			case "De CLP/Peso Chileno para BRL/Real":
				result.setText(BRLToCLP.tokenToValue());
				break;		    
			}
			
		} catch (Exception e2) {
			result.setText("Valor invalido");
		}
		
	}

}