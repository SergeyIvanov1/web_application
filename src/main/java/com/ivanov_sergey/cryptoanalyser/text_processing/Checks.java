package com.ivanov_sergey.cryptoanalyser.text_processing;

public class Checks {

    private static final int NUMBER_OF_LETTERS_FROM_BEGINNING = 4;
    private static final String PATH_IS_INVALID = "path: \"%s\", cannot be converted to a Path, it is invalid\n";

    private Checks() {
    }

    public static boolean isCorrespondFrequentWords(String word) {

        String[] array = TextProcessing.getArrayFrequentWords(TextProcessing.language);

        for (int i = 0; i < array.length; i++) {
            String value;
            String fromStrings = array[i];

            if (word.length() > NUMBER_OF_LETTERS_FROM_BEGINNING
                    && fromStrings.length() > NUMBER_OF_LETTERS_FROM_BEGINNING) {

                value = word.substring(0, NUMBER_OF_LETTERS_FROM_BEGINNING);
                fromStrings = fromStrings.substring(0, NUMBER_OF_LETTERS_FROM_BEGINNING);

                if (value.equalsIgnoreCase(fromStrings)) {
                    return true;
                }

            } else if (word.equalsIgnoreCase(fromStrings)) {
                return true;
            }
        }
        return false;
    }

    public static boolean autoSelectOfCorrectDecryption(StringBuilder stringBuilder2) {
        byte[] bytes = stringBuilder2.toString().getBytes();

        StringBuilder stringBuilder = new StringBuilder();
        String secondWordFromFile = null;
        int count = 0;
        int symbol;
        for (int i = 0; i < bytes.length; i++) {
            symbol = bytes[i];
            String wordFromFile;

            if (Character.isLetter(symbol) || Character.isWhitespace(symbol)) {

                if (Character.isWhitespace(symbol) || TextProcessing.isSymbol((char) symbol)) {

                    wordFromFile = stringBuilder.toString();
                    stringBuilder.delete(0, wordFromFile.length());

                    if (Checks.isCorrespondFrequentWords(wordFromFile) &&
                            !(wordFromFile.equalsIgnoreCase(secondWordFromFile))) {
                        count++;

                        if (count > 1) {
                            return true;
                        }
                        secondWordFromFile = wordFromFile;
                    }
                } else {
                    stringBuilder.append((char) symbol);
                }
            }
        }
        return false;
    }
}
