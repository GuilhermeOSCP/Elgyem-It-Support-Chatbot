package ChatBotUI;

import javax.swing.*;
import java.awt.*;

/**
 * Classe responsável exclusivamente pela interface gráfica do chatbot.
 * Aplica SRP: não trata eventos nem lógica de negócio.
 */
public class ChatBotView extends JFrame {

    // Componentes da interface visíveis e acessíveis pelo controlador
    public JTextArea chatArea;
    public JTextField inputField;
    public JButton sendButton;

    /**
     * Construtor que define e posiciona os componentes da interface.
     */
    public ChatBotView() {
        setTitle("Elgyem IT Support Bot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(428, 657);
        setLocationRelativeTo(null); // Centraliza a janela

        JPanel contentPane = new JPanel(null); // Layout manual
        setContentPane(contentPane);

        // Área de chat (exibição das mensagens)
        chatArea = new JTextArea();
        chatArea.setFont(new Font("Arial", Font.PLAIN, 19));
        chatArea.setEditable(false);
        chatArea.setBounds(0, 0, 396, 554);
        contentPane.add(chatArea);

        // Campo de entrada de texto
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 23));
        inputField.setBounds(0, 555, 338, 60);
        contentPane.add(inputField);

        // Botão de envio
        sendButton = new JButton("Enviar");
        sendButton.setBounds(341, 555, 75, 59);
        contentPane.add(sendButton);
    }
}