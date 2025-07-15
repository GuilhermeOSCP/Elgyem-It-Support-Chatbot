package ChatBotCore;

/**
 * Interface que define o contrato para qualquer mecanismo de resposta de chatbot.
 * Aplica o princípio da inversão de dependência (DIP) e a segregação de interface (ISP).
 */
public interface ChatBotResponder {
    /**
     * Processa a entrada do usuário e retorna uma resposta.
     *
     * @param input Texto digitado pelo usuário
     * @return Resposta gerada pelo chatbot
     */
    String respond(String input);
}
