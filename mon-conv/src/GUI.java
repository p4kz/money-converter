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
		userValueInput = new JTextField(20);
		userValueInput.setBounds(200, 10, 100, 25);
		panel.add(userValueInput);

		// Create checkbox
		String convertOptions[] = { "De BRL/Real para USD/Dolar", "De USD/Dolar para BRL/Real", };

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
		double userValue = Double.parseDouble(userText);

		double USDPrice = 5.17;

		if (comboBox.getSelectedItem() == "De BRL/Real para USD/Dolar") {
			double calc = userValue / USDPrice;
			result.setText(String.valueOf("$ " + new DecimalFormat("#.##").format(calc)));
		}

		if (comboBox.getSelectedItem() == "De USD/Dolar para BRL/Real") {
			double calc = userValue * USDPrice;
			result.setText(String.valueOf("R$ " + new DecimalFormat("#.##").format(calc)));
		}

	}

}
