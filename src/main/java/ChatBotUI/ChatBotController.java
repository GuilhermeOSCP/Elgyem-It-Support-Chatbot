package main.java.ChatBotUI;

import ChatBotUI.ChatBotView;
import main.java.ChatBotCore.ChatBotResponder;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

/**
 * Classe responsável por controlar os eventos da interface.
 * Conecta a view à lógica de resposta (engine), aplicando DIP e SRP.
 */
public class ChatBotController {

    private final ChatBotView view = new ChatBotView(); // GUI
    private final ChatBotResponder responder; // Interface de resposta (engine)

    /**
     * Construtor que recebe a engine (injeção de dependência via interface).
     * Isso permite trocar facilmente a lógica de resposta.
     */
    public ChatBotController(ChatBotResponder responder) {
        this.responder = responder;
    }

    /**
     * Inicializa a interface e os eventos do chatbot.
     */
    public void init() {
        // Evento de clique no botão "Enviar"
        view.sendButton.addActionListener(this::handleSend);

        // Evento de pressionar Enter no campo de entrada
        view.inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    handleSend(null);
                }
            }
        });

        // Exibe a janela na tela
        SwingUtilities.invokeLater(() -> view.setVisible(true));
    }

    /**
     * Método que processa o envio de mensagem do usuário.
     * Atualiza a interface com a pergunta e a resposta.
     */
    private void handleSend(ActionEvent e) {
        String input = view.inputField.getText();
        view.chatArea.append("Eu -> " + input + "\n");

        String response = responder.respond(input);
        view.chatArea.append("Elgyem -> " + response + "\n\n");
        view.scrollToBottom();

        view.inputField.setText("");
    }
}