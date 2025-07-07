package ChatBotProperties;

import ChatBotCore.ChatBotEngine;
import ChatBotCore.ChatBotResponder;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

// Esta Classe e uma GodClass, precisa ser quebrada em outros pacotes e entrar no principio SOLID
public class ChatBotMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JButton btnSend;
	JTextArea textArea;

	private final ChatBotResponder responder = new ChatBotEngine();
	
	// Iniciar o app | Launch the app

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatBotMain frame = new ChatBotMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	// GUI do app | GUI of the app

	
	public ChatBotMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 428, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					action();
				}
			}
			
		});
		textField_1.setFont(new Font("Arial", Font.PLAIN, 23));
		textField_1.setBounds(0, 555, 338, 60);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		btnSend = new JButton("Enviar");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action();
			}
		});
		btnSend.setBounds(341, 555, 75, 59);
		contentPane.add(btnSend);
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 19));
		textArea.setEditable(false);
		textArea.setBounds(0, 0, 396, 554);
		contentPane.add(textArea);		
	}
	

      // Funcionamento da aplica��o | Application operation


	void action() {
		String query = textField_1.getText();
		textArea.append(" Eu -> " + query + "\n");
		String response = responder.respond(query);
		Elgyem(response);
	}
	
	
	// Inteligencia Artificial | Artificial Intelligence
	void Elgyem(String s)
	{
		textArea.append(" Elgyem->"+s+"\n\n");
		textField_1.setText("");
	}
}