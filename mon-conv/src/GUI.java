import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {

	private static JLabel userValuelabel;
	private static JTextField userValueInput;
	private static JLabel result;
	private static JButton buttonConverter;
	private static JComboBox<String> comboBox;

	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();

		// Window config
		frame.setSize(310, 175);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.setLayout(null);

		// Create label
		userValuelabel = new JLabel("Valor para ser convertido");
		userValuelabel.setBounds(10, 10, 250, 25);
		panel.add(userValuelabel);

		// Create input
		userValueInput = new JTextField(" ", 20);
		userValueInput.setBounds(200, 10, 100, 25);
		panel.add(userValueInput);

		// Create checkbox
		String convertOptions[] = { 
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

		comboBox = new JComboBox<>(convertOptions);
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

		buttonConverter.addActionListener(new GUI());

		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String userText = userValueInput.getText();
		
		Convert BRLToUSD = new Convert();
		BRLToUSD.setUserValue(userText);
		BRLToUSD.setTokenValue(5.17, "$");
		
		Convert BRLToEUR = new Convert();
		BRLToEUR.setUserValue(userText);
		BRLToEUR.setTokenValue(5.19, "€");
		
		Convert BRLToGBP = new Convert();
		BRLToGBP.setUserValue(userText);
		BRLToGBP.setTokenValue(6.16, "£");
		
		Convert ARSToBRL = new Convert();
		ARSToBRL.setUserValue(userText);
		ARSToBRL.setTokenValue(0.038, "$");
		
		Convert CLPToBRL = new Convert();
		CLPToBRL.setUserValue(userText);
		CLPToBRL.setTokenValue(0.005, "$");
		
		// Dolar 
		
		if (comboBox.getSelectedItem() == "De BRL/Real para USD/Dolar") {
			result.setText(BRLToUSD.valueToToken());
		}
		
		if (comboBox.getSelectedItem() == "De USD/Dolar para BRL/Real") {
			result.setText(BRLToUSD.tokenToValue());
		}
		
		// Euro
		
		if (comboBox.getSelectedItem() == "De BRL/Real para EUR/Euro") {
			result.setText(BRLToEUR.valueToToken());
		}
		
		if (comboBox.getSelectedItem() == "De EUR/Euro para BRL/Real") {
			result.setText(BRLToEUR.tokenToValue());
		}
		
		// Libra Esterlina
		
		if (comboBox.getSelectedItem() == "De BRL/Real para GBP/Libra Esterlina") {
			result.setText(BRLToGBP.valueToToken());
		}
		
		if (comboBox.getSelectedItem() == "De GBP/Libra Esterlina para BRL/Real") {
			result.setText(BRLToGBP.tokenToValue());
		}
		
		// Peso Argentino
		
		if (comboBox.getSelectedItem() == "De BRL/Real para ARS/Peso Argentino") {
			result.setText(ARSToBRL.valueToToken());
		}
		
		if (comboBox.getSelectedItem() == "De ARS/Peso Argentino para BRL/Real") {
			result.setText(ARSToBRL.tokenToValue());
		}
		
		// Peso Chileno
		
		if (comboBox.getSelectedItem() == "De BRL/Real para CLP/Peso Chileno") {
			result.setText(CLPToBRL.valueToToken());
		}
		
		if (comboBox.getSelectedItem() == "De CLP/Peso Chileno para BRL/Real") {
			result.setText(CLPToBRL.tokenToValue());
		}

	}

}
