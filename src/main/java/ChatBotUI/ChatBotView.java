package ChatBotUI;

import javax.swing.*;
import java.awt.*;
import com.formdev.flatlaf.FlatLightLaf;

/**
 * Interface gráfica moderna do chatbot usando FlatLaf e layouts profissionais.
 */
public class ChatBotView extends JFrame {

    public JTextArea chatArea;
    public JTextField inputField;
    public JButton sendButton;

    /**
     * Construtor que monta toda a GUI.
     */
    public ChatBotView() {
        // Aplica tema FlatLaf (moderno e limpo)
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("FlatLaf não pôde ser carregado.");
        }

        setTitle("Elgyem IT Support Bot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 720);
        setLocationRelativeTo(null); // Centraliza a janela
        setResizable(false);

        // Layout principal da janela
        setLayout(new BorderLayout(10, 10));

        // Área de conversa com scroll
        chatArea = new JTextArea();
        chatArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // suaviza rolagem
        add(scrollPane, BorderLayout.CENTER);

        // Painel inferior para entrada e botão
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.setBackground(new Color(250, 250, 250));

        inputField = new JTextField();
        inputField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        inputField.setPreferredSize(new Dimension(400, 40));
        inputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        sendButton = new JButton("Enviar");
        sendButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        sendButton.setPreferredSize(new Dimension(80, 40));

        inputPanel.add(inputField);
        inputPanel.add(Box.createRigidArea(new Dimension(10, 0))); // espaço entre campo e botão
        inputPanel.add(sendButton);

        add(inputPanel, BorderLayout.SOUTH);
    }

    /**
     * Método utilitário para rolar o texto para o final.
     * Deve ser chamado após atualizar o chatArea.
     */
    public void scrollToBottom() {
        SwingUtilities.invokeLater(() -> {
            chatArea.setCaretPosition(chatArea.getDocument().getLength());
        });
    }
}