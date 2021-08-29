
/**
 * Represents a secret word, which starts off with all its letters hidden by '*', and is revealed letter
 * by letter as the user correctly guesses letters in the word.
 *
 * @author Graydon Hall
 *
 */
public class SecretWord {

    /**
     * Word displayed to the user. It is the secret word, with un-guessed characters disguised by *.
     */
    private String displayedWord;


    /**
     * Secret word which the user is trying to guess.
     */
    private String secretWord;

    /**
     * Constructs the secret word object, setting the value of the secret word, and then replacing all characters
     * in it with * to generate the displayed word.
     */
    public SecretWord() {
        this.secretWord = "walrus";
        this.displayedWord = replaceChars(secretWord, '*');
    }

    /**
     * replaces all characters in string s with character c, and returns that string.
     *
     * @param s string to replace characters in
     * @param c character to replace all characters in String s.
     * @return reformatted version of string s with all characters replaced by c.
     */
    public String replaceChars(String s, char c){
        return s.replaceAll(".", Character.toString(c));  // regex to replace all characters with c.
    }

    /**
     * @param s1 original string with no characters hidden
     * @param s2 version of string s with un-guessed characters disguised by by *
     * @param ch the character to un-hide in s2 if that character is in s1.
     */
    public void replaceChars(String s1, String s2, char ch){
        String newString = "";  // start with empty string.

        for(int i = 0, n = s1.length() ; i < n ; i++) {  // iterate through each character in s1
            if(s1.charAt(i) == ch){  // if that character at s1 matches ch
                newString = newString + ch;  // add ch to new string
            }
            else{  // character at s1 does not mach ch
                newString = newString + s2.charAt(i); // keep original char from s2 at that position.
            }
        }

        this.displayedWord = newString; // final string with ch revealed, other characters in s2 unchanged.
    }

    /**
     * getter function to return the displayedWord to user.
     *
     * @return displayedWord
     */
    public String getDisplayedWord() {
        return displayedWord;
    }

    /**
     * User guesses to see if charAt is in the secret word. If yes, charAt is revealed in displayedWord, and value of
     * true is returned. If no, returns false.
     *
     * @param charAt guessed character.
     * @return boolean value of whether charAt exists within the secretWord.
     */
    public boolean makeGuess(char charAt) {
        if (this.secretWord.indexOf(charAt) >= 0){  // if the character is in the secret word
            this.replaceChars(secretWord, displayedWord,charAt);  // reveal charAt in displayedWord
            return true;  // return true to signify that charAt is in the secretWord.
        }
        else {
            System.out.println("No match");
            return false;  // return false because charAt is Not in the secretWord.
        }
    }

    /**
     * getter function for the secretWord
     *
     * @return secretWord
     */
    public String getSecretWord() {
        return secretWord;
    }


}
