package ChatBotCore;

import java.util.Random;

public class ChatBotEngine implements ChatBotResponder {

    @Override
    public String respond(String input) {
        if (input == null || input.isBlank()) return "Pode digitar algo?";

        String query = input.toLowerCase();
        Random rand = new Random();

        if (query.contains("oi") || query.contains("ola") || query.contains("hey")) {
            return switch (rand.nextInt(5)) {
                case 0 -> "Oi, estou aqui";
                case 1 -> "Hey, como está?";
                case 2 -> "Ei, tudo certo?";
                case 3 -> "Olá, como está?";
                default -> "Saudações, tudo certo?";
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

        if (query.contains("tudo bem?") || query.contains("como vai")) {
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