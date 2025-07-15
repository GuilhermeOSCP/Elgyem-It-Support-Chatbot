package main.java.Application;

import main.java.ChatBotUI.ChatBotController;
import main.java.ChatBotCore.ChatBotEngine;

/**
 * Classe responsável por iniciar a aplicação.
 * Aplica o princípio da responsabilidade única (SRP) ao manter apenas a lógica de inicialização.
 */
public class AppLauncher {
    public static void main(String[] args) {
        // Instancia o controlador com a lógica de resposta (engine)
        ChatBotController controller = new ChatBotController(new ChatBotEngine());
        // Inicia a interface gráfica
        controller.init();
    }
}
