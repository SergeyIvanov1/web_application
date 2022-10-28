package com.ivanov_sergey.cryptoanalyser.text_processing;


//import com.ivanovsergey.cryptoanalyser.exceptions.PathProcessingException;
//import com.ivanovsergey.cryptoanalyser.exceptions.ReadWrightFileException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Coder {

    private static final String FILE_NOT_FOUND = "File: \"%s\" not found\n";
    private static final String INVALID_READ_ACCESS_TO_THE_FILE_S = "Invalid read access to the file: \"%s\"";

    private Coder() {
    }

//    public static void encryption(String pathFrom, String pathTo, int key) {
//
//        try (FileInputStream fileInputStream = new FileInputStream(pathFrom);
//             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
//
//            try (FileOutputStream fileOutputStream = new FileOutputStream(pathTo);
//                 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream))) {
//
//                int unencryptedChar;
//                while ((unencryptedChar = bufferedReader.read()) != -1) {
//
//                    char wantedChar;
//                    if (Character.isLetter(unencryptedChar)) {
//
//                        boolean flagUpperCase = Character.isUpperCase(unencryptedChar);
//                        if (flagUpperCase) {
//                            unencryptedChar = (char) Character.toLowerCase(unencryptedChar);
//                        }
//
//                        int index = TextProcessing.getIndex((char) unencryptedChar, TextProcessing.language);
//                        if (index >= 0) {
//
//                            char[] arrayAlphabet = TextProcessing.choiceOfAlphabet(TextProcessing.language);
//
//                            int secretCharInd = (index + key) % arrayAlphabet.length;
//                            if (secretCharInd < 0) {
//                                secretCharInd = arrayAlphabet.length - Math.abs(secretCharInd);
//                            }
//
//                            wantedChar = arrayAlphabet[secretCharInd];
//
//                            if (flagUpperCase) {
//                                bufferedWriter.append(Character.toUpperCase(wantedChar));
//                            } else {
//                                bufferedWriter.append(wantedChar);
//                            }
//                        }
//
//                    } else {
//
//                        char[] array = TextProcessing.choiceOfAlphabet(TextProcessing.ALPHABET_OF_SYMBOLS);
//
//                        for (int j = 0; j < array.length; j++) {
//                            if (unencryptedChar == array[j]) {
//
//                                wantedChar = array[j];
//                                bufferedWriter.append(wantedChar);
//                            }
//                        }
//                    }
//                }
//                bufferedWriter.flush();
//
//            } catch (FileNotFoundException e) {
//
//                String message = String.format(FILE_NOT_FOUND, pathTo);
//                throw new PathProcessingException(message, e);
//
//            } catch (SecurityException e) {
//
//                String message = String.format(INVALID_READ_ACCESS_TO_THE_FILE_S, pathTo);
//                throw new PathProcessingException(message, e);
//
//            } catch (IOException e) {
//
//                String message = "An Input error occurs with file \"" + pathTo + "\"";
//                throw new ReadWrightFileException(message, e);
//            }
//
//        } catch (FileNotFoundException e) {
//
//            String message = String.format(FILE_NOT_FOUND, pathFrom);
//            throw new PathProcessingException(message, e);
//
//        } catch (SecurityException e) {
//
//            String message = String.format(INVALID_READ_ACCESS_TO_THE_FILE_S, pathFrom);
//            throw new PathProcessingException(message, e);
//
//        } catch (IOException e) {
//
//            String message = "An Output error occurs with file \"" + pathFrom + "\"";
//            throw new ReadWrightFileException(message, e);
//        }
//    }

    public static void encryption(HttpServletRequest req, StringBuilder stringBuilder, int key) throws ServletException, IOException {

        Part filePart = req.getPart("file");
        try (InputStream inputStream = filePart.getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            int unencryptedChar;
            while ((unencryptedChar = bufferedReader.read()) != -1) {

                char wantedChar;
                if (Character.isLetter(unencryptedChar)) {

                    boolean flagUpperCase = Character.isUpperCase(unencryptedChar);
                    if (flagUpperCase) {
                        unencryptedChar = (char) Character.toLowerCase(unencryptedChar);
                    }

                    int index = TextProcessing.getIndex((char) unencryptedChar, TextProcessing.language);
                    if (index >= 0) {

                        char[] arrayAlphabet = TextProcessing.choiceOfAlphabet(TextProcessing.language);

                        int secretCharInd = (index + key) % arrayAlphabet.length;
                        if (secretCharInd < 0) {
                            secretCharInd = arrayAlphabet.length - Math.abs(secretCharInd);
                        }

                        wantedChar = arrayAlphabet[secretCharInd];

                        if (flagUpperCase) {
                            stringBuilder.append(Character.toUpperCase(wantedChar));
                        } else {
                            stringBuilder.append(wantedChar);
                        }
                    }

                } else {

                    char[] array = TextProcessing.choiceOfAlphabet(TextProcessing.ALPHABET_OF_SYMBOLS);

                    for (int j = 0; j < array.length; j++) {
                        if (unencryptedChar == array[j]) {

                            wantedChar = array[j];
                            stringBuilder.append(wantedChar);
                        }
                    }
                }
            }
//        } catch (FileNotFoundException e) {
//            throw new PathProcessingException(FILE_NOT_FOUND, e);

//        } catch (SecurityException e) {
//            throw new PathProcessingException(INVALID_READ_ACCESS_TO_THE_FILE_S, e);

//        } catch (IOException e) {
//            throw new ReadWrightFileException("An Output error occurs with file", e);
        }
    }
}
