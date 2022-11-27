package com.ivanov_sergey.cryptoanalyser.text_processing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Decoder {

    private Decoder() {
    }

//    public static void decryptionWithKey(String pathFrom, String pathTo, int key) {
//
//        Coder.encryption(pathFrom, pathTo, -key);
//    }
//
//    public static void manualDecryptionBruteForce(String pathFrom, String pathTo) {
//
//        for (int key = 1; key < TextProcessing.choiceOfAlphabet(TextProcessing.language).length; key++) {
//
//            String pathKey = getNewFileName(key, pathTo);
//            Coder.encryption(pathFrom, pathKey, key);
//        }
//    }
//
//    public static void autoDecryptionBruteForce(String pathFrom, String pathTo) {
//
//        for (int key = 1; key < TextProcessing.choiceOfAlphabet(TextProcessing.language).length; key++) {
//
//            Coder.encryption(pathFrom, pathTo, key);
//
//            if (Checks.autoSelectOfCorrectDecryption(pathTo)) {
//                break;
//            }
//        }
//    }
//
//    public static void manualDecryptionWithStatistic(String pathFrom, String pathTo) {
//
//        char[] chars = TextProcessing.getArrayGreatestFrequentLettersOfAlphabets(TextProcessing.language);
//        int indexOfMostFrequentLetterOfText = TextProcessing.getIndex(TextProcessing.getMostFrequentLetterOfText(pathFrom),
//                TextProcessing.language);
//
//        for (int ind = 0; ind < chars.length; ind++) {
//
//            int foundKey = indexOfMostFrequentLetterOfText
//                    - TextProcessing.getIndex(chars[ind], TextProcessing.language);
//
//            String pathKey = getNewFileName(foundKey, pathTo);
//
//            decryptionWithKey(pathFrom, pathKey, foundKey);
//        }
//    }
//
//    public static void autoDecryptionWithStatistic(String pathFrom, String pathTo) {
//
//        char[] chars = TextProcessing.getArrayGreatestFrequentLettersOfAlphabets(TextProcessing.language);
//        int indexOfMostFrequentLetterOfText = TextProcessing.getIndex(
//                TextProcessing.getMostFrequentLetterOfText(pathFrom), TextProcessing.language);
//
//        for (int ind = 0; ind < chars.length; ind++) {
//
//            int indexOfMostFrequentLetterOfAlphabet = TextProcessing.getIndex(chars[ind], TextProcessing.language);
//            int foundKey = indexOfMostFrequentLetterOfText - indexOfMostFrequentLetterOfAlphabet;
//
//            decryptionWithKey(pathFrom, pathTo, foundKey);
//
//            if (Checks.autoSelectOfCorrectDecryption(pathTo)) {
//                break;
//            }
//        }
//    }
//
//    public static String getNewFileName(int key, String pathTo) {
//        return pathTo + System.getProperty("file.separator") + "Decode_key_" + key + ".txt";
//    }

    public static void decryptionWithKey(HttpServletRequest req, StringBuilder stringBuilder, int key) throws IOException, ServletException {

        Coder.encryption(req, stringBuilder, -key);
    }

    public static void manualDecryptionBruteForce(HttpServletRequest req, StringBuilder stringBuilder) throws IOException, ServletException {

        for (int key = 1; key < TextProcessing.choiceOfAlphabet(TextProcessing.language).length; key++) {
            stringBuilder.append("<p>Key = " + key + "</p><br>");
            Decoder.decryptionWithKey(req, stringBuilder, key);
            stringBuilder.append("<br><br>");
        }
    }

    public static void autoDecryptionBruteForce(HttpServletRequest req, StringBuilder stringBuilder)
            throws ServletException, IOException {

        for (int key = 1; key < TextProcessing.choiceOfAlphabet(TextProcessing.language).length; key++) {
            Coder.encryption(req, stringBuilder, key);

            if (Checks.autoSelectOfCorrectDecryption(stringBuilder)) {
                break;
            }
            stringBuilder.setLength(0);
        }

        if (stringBuilder.length() == 0){
            stringBuilder.append("Decryption is not successfully");
        }
    }

    public static void manualDecryptionWithStatistic(HttpServletRequest req, StringBuilder stringBuilder)
            throws IOException, ServletException {

        char[] frequentLetters = TextProcessing.getArrayGreatestFrequentLettersOfAlphabets(TextProcessing.language);
        int indexOfMostFrequentLetterOfText = TextProcessing.getIndex(
                TextProcessing.getMostFrequentLetterOfText(req), TextProcessing.language);

        for (char frequentLetter : frequentLetters) {
            int foundKey = indexOfMostFrequentLetterOfText
                    - TextProcessing.getIndex(frequentLetter, TextProcessing.language);

            decryptionWithKey(req, stringBuilder, foundKey);

            if (Checks.autoSelectOfCorrectDecryption(stringBuilder)) {
                break;
            }
            stringBuilder.setLength(0);
        }
        if (stringBuilder.length() == 0){
            stringBuilder.append("Decryption is not successfully");
        }
    }
    public static void autoDecryptionWithStatistic(HttpServletRequest req, StringBuilder stringBuilder) throws ServletException, IOException {

        char[] chars = TextProcessing.getArrayGreatestFrequentLettersOfAlphabets(TextProcessing.language);
        int indexOfMostFrequentLetterOfText = TextProcessing.getIndex(
                TextProcessing.getMostFrequentLetterOfText(req), TextProcessing.language);

        for (int ind = 0; ind < chars.length; ind++) {

            int indexOfMostFrequentLetterOfAlphabet = TextProcessing.getIndex(chars[ind], TextProcessing.language);
            int foundKey = indexOfMostFrequentLetterOfText - indexOfMostFrequentLetterOfAlphabet;

            decryptionWithKey(req, stringBuilder, foundKey);

            if (Checks.autoSelectOfCorrectDecryption(stringBuilder)) {
                break;
            }
        }
    }
}
