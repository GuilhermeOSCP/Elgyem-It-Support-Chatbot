package ChatBotProperties;

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

// Est� Classe � uma GodClass, precisa ser quebrada em outros pacotes e entrar no principio SOLID
public class ChatBotMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JButton btnSend;
	JTextArea textArea;
	
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

	
	void action()
	{
		
		String query=textField_1.getText();
		textArea.append(" Eu-> "+query+"\n");
		//query.trim();
		query=query.toLowerCase();
		if(query.contains("clear screen")||query.contains("clr")||query.contains("cls"))
		{
			textArea.setText("");
			textField_1.setText("");
		}
		else if(query.contains("oi")||query.contains("hey")||query.contains("ei")||query.contains("ol�")||query.contains("ola"))
		{
			Random rand=new Random();
			int a=rand.nextInt(4);
			if(a==0)
			{
				Elgyem("Oi, estou aqui");
			}
			else if(a==1)
			{
				Elgyem("Hey, como est�?");
			}
			else if(a==2)
			{
				Elgyem("Ei, tudo certo?");
			}
			else if(a==3)
			{
				Elgyem("Ol�,como est�?");
			}
			else if(a==4)
			{
				Elgyem("Sauda��es, Tudo Certo?");
			}
			
		}
		else if(query.contains("bem")||query.contains("Eu estou bem")||query.contains("estou bem"))
		{
			Random rand=new Random();
			int a=rand.nextInt(4);
			if(a==0)
			{
				Elgyem("� bom saber que voc� est� bem");
			}
			else if(a==1)
			{
				Elgyem("� um prazer saber que voc� est� bem");
			}
			else if(a==2)
			{
				Elgyem("Que �timo");
			}
			else if(a==3)
			{
				Elgyem("Oh, uma �tima not�cia");
			}
			else if(a==4)
			{
				Elgyem("Desejo, voc� sempre fica bem");
			}
		}
		else if(query.contains("tudo certo?")||query.contains("tudo bem?")||query.contains("como voc� est�?")||query.contains("como vai voc�?")
				||query.contains("tudo bem por ai?")||query.contains("como est� indo?"))
		{
			Elgyem("Eu estou bem e voc�?");
		}
		else if(query.contains("sim")||query.contains("tudo certo")||query.contains("estou bem"))
		{
			Random rand=new Random();
			int a=rand.nextInt(2);
			if(a==0)
			{
				Elgyem("Que �timo");
			}
			else if(a==1)
			{
				Elgyem("Oh, uma �tima not�cia");
			}
			else if(a==2)
			{
				Elgyem("Legal");
			}
		}
		else if(query.contains("n�o")||query.contains("nada bem"))
		{
			Random rand=new Random();
			int a=rand.nextInt(2);
			if(a==0)
			{
				Elgyem("Por qu�?");
			}
			else if(a==1)
			{
				Elgyem("Porque? de acordo com eu sei que voc� � uma pessoa muito legal");
			}
			else if(a==2)
			{
				Elgyem("Porque? N�o perca seu tempo assim");
			}
		}
		else{
			Random rand=new Random();
			int a=rand.nextInt(4);
			if(a==0)
			{
				Elgyem("Desculpe, n�o consegui te entender");
			}
			else if(a==1)
			{
				Elgyem("Poderia repetir por gentileza?");
			}
			else if(a==2)
			{
				Elgyem("N�o estou entendendo sua resposta");
			}
			else if(a==3)
			{
				Elgyem("Est� complicado, poderia repetir?");
			}
		}
	}
	
	
	// Intelig�ncia Artificial | Artificial Intelligence
	void Elgyem(String s)
	{
		textArea.append(" Elgyem->"+s+"\n\n");
		textField_1.setText("");
	}
}