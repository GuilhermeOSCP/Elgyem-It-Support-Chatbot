package main.java.ChatBotCore;

import java.util.Random;

/**
 * Implementação básica da lógica de respostas do chatbot.
 * Aplica SRP: trata apenas da geração da resposta com base na entrada.
 */
public class ChatBotEngine implements ChatBotResponder {

    private final Random rand = new Random();

    @Override
    public String respond(String input) {
        if (input == null || input.isBlank()) return "Pode digitar algo?";

        String query = input.toLowerCase();

        if (query.contains("clear screen") || query.contains("cls") || query.contains("limpar")) {
            return "Tela limpa (simulada).";
        }

        if (query.contains("oi") || query.contains("ola") || query.contains("hey")) {
            return switch (rand.nextInt(5)) {
                case 0 -> "Oi, estou aqui!";
                case 1 -> "Hey, como está?";
                case 2 -> "Ei, tudo certo?";
                case 3 -> "Olá, como vai?";
                default -> "Saudações, tudo bem?";
            };
        }

        if (query.contains("bem") || query.contains("estou bem")) {
            return switch (rand.nextInt(4)) {
                case 0 -> "Que ótimo!";
                case 1 -> "Fico feliz em saber!";
                case 2 -> "Boa notícia!";
                default -> "Que bom saber disso!";
            };
        }

        if (query.contains("tudo bem") || query.contains("como vai")) {
            return "Eu estou bem e você?";
        }

        if (query.contains("não") || query.contains("nada bem")) {
            return "Sinto muito! Quer conversar sobre isso?";
        }

        return switch (rand.nextInt(3)) {
            case 0 -> "Desculpe, não entendi.";
            case 1 -> "Pode repetir, por favor?";
            default -> "Estou com dificuldades para entender.";
        };
    }
}