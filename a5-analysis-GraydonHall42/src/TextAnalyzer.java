/**
 * @author Graydon Hall
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Class used to analyze text, and return the number of words and sentences
 * @author Graydon Hall
 */
public class TextAnalyzer {

    private int numOfSentences=0;  // initial counter for number of words
    private int numOfWords=0;  // initial counter for number of sentences


    /**
     * Constructs the TextAnalyzer object, by analyzing the text provided and determining the number
     * of words and sentences
     * @param text String text to be analyzed
     */
    public TextAnalyzer(String text) {
        numOfWords = countWords(text);  // count words in text
        numOfSentences = countSentences(text);  // count sentences in text
    }

    /**
     * String representation of the TextAnalyzer, which shows the number of words
     * and sentences in the text provided.
     * @return String showing the number of words and sentences in the provided text.
     */
    @Override
    public String toString() {
        return "Number of Words: " + numOfWords
                + "\nNumber of Sentences: " + numOfSentences;
    }


    /**
     * @param text the text to analyze
     * @return integer count of words in the text
     */
    private static int countWords(String text) {
        StringTokenizer tokens = new StringTokenizer(text);
        return tokens.countTokens();
    }

    /**
     * @param text the text to analyze
     * @return integer count of sentences in the text
     */
    private static int countSentences(String text) {
        String[] tok = text.trim().split("[.!?]");
        if(tok[0].equals("")) return 0;  // so we don't count an empty string
        return tok.length;
    }

    /**
     * getter to return number of sentences
     * @return integer number of sentences
     */
    public int getNumOfSentences() {
        return numOfSentences;
    }

    /**
     * getter to return number of words
     * @return integer number of words
     */
    public int getNumOfWords() {
        return numOfWords;
    }

}
