import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Window {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 638, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*----------------------------------------*/
		// Onde coloca atalho da código HTML

		textField = new JTextField();
		textField.setBounds(69, 11, 398, 32);
		textField.setColumns(10);
		/*----------------------------------------*/
		// Botão de analisar

		JButton btnNewButton = new JButton("Analisar");
		btnNewButton.setBounds(473, 11, 101, 32);
		/*----------------------------------------*/

		// Escrita arquivo
		
		JLabel lblNewLabel = new JLabel("Arquivo:");
		lblNewLabel.setBounds(10, 14, 55, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		/*----------------------------------------*/

		// Painel onde irá exibir se o código está bem formatado

		JTextPane textPane = new JTextPane();
		textPane.setBounds(23, 84, 576, 183);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(textPane);
		/*----------------------------------------*/

		// Tabela onde ira exibira a quantidade de tags

		table = new JTable();
		table.setBounds(210, 405, 1, 1);
		frame.getContentPane().add(table);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 294, 576, 147);
		frame.getContentPane().add(scrollPane);

		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setViewportView(scrollBar);

		table_1 = new JTable();
		table_1.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Tag", "N\u00FAmero de ocorr\u00EAncia" }));
		scrollPane.setViewportView(table_1);
	}
}
