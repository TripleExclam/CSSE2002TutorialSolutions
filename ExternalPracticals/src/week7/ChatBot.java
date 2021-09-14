package week7;

import java.util.List;
import java.util.ArrayList;

/**
 * A basic chat bot that can play a guessing game.
 * TODO - fix the bugs in this code
 */
public class ChatBot {

    private static final int SECRET_NUMBER = 42;

    /**
     * Splits a string into a list of words, separated by space characters (' ').
     *
     * @param input
     *      The string being entered
     * @return
     *      The words that input consists of, after being split.
     */
    private static List<String> split(String input) {
        List<String> output = new ArrayList<>();
        int index = 0, newIndex;

        do {
            newIndex = input.indexOf(' ', index + 1);
            if (newIndex == -1) {
                output.add(input.substring(index));
            } else {
                output.add(input.substring(index, newIndex));
            }
            index = newIndex + 1;
        } while (newIndex != -1);

        return output;
    }

    /**
     * Takes an input message, and produces a reply to it. If the bot does not plan on replying to
     * the message, it will return null.
     *
     * @param message
     *      The message being sent to the bot.
     * @return
     *      The reply of the bot to message, or null if there is none.
     */
    public static String replyTo(String message) {
        if (message.equals("!help")) {
            return "Guessing game bot!\n" +
                "There are 3 options\n" +
                "1) guess higher <number>\n" +
                "2) guess lower <number>\n" +
                "3) guess equal <number>\n";
        } else if (message.startsWith("guess")) {
            List<String> words = split(message);
            if (words.size() != 3) {
                return "incorrect guess format";
            }
            String type = words.get(1);
            if (type.equals("higher")) {
                try {
                    int guess = Integer.parseInt(words.get(2));
                    return guess > SECRET_NUMBER ? "yes" : "no";
                } catch (NumberFormatException e) {
                    return "not a valid number";
                }
            } else if (type.equals("lower")) {
                try {
                    int guess = Integer.parseInt(words.get(2));
                    return guess < SECRET_NUMBER ? "yes" : "no";
                } catch (NumberFormatException e) {
                    return "not a valid number";
                }
            } else if (type.equals("equal")) {
                try {
                    int guess = Integer.parseInt(words.get(2));
                    return guess == SECRET_NUMBER ? "you win!" : "you lose!";
                } catch (NumberFormatException e) {
                    return "not a valid number";
                }
            } else {
                return "incorrect guess format";
            }
        } else {
            // we only reply to "!help" and "guess" so ignore the other messages
            return null;
        }
    }
}
