package com.ivanov_sergey.cryptoanalyser.text_processing;


//import com.ivanovsergey.cryptoanalyser.exceptions.KeyInvalidException;
//import com.ivanovsergey.cryptoanalyser.exceptions.PathProcessingException;
//import com.ivanovsergey.cryptoanalyser.exceptions.ReadWrightFileException;

public class Checks {

    private static final int NUMBER_OF_LETTERS_FROM_BEGINNING = 4;
    private static final String PATH_IS_INVALID = "path: \"%s\", cannot be converted to a Path, it is invalid\n";

    private Checks() {
    }

//    public static void isFile(String path) {
//
//        Path filePath;
//        try {
//            filePath = Path.of(path);
//        } catch (InvalidPathException ex) {
//
//            String message = String.format(PATH_IS_INVALID, path);
//            throw new PathProcessingException(message, ex);
//        }
//
//        if (!Files.isReadable(filePath)) {
//            String message = "File: " + filePath + " is not readable";
//            throw new PathProcessingException(message);
//        }
//
//        if (Files.isDirectory(filePath)) {
//
//            String message = "Path: " + filePath + " is directory";
//            throw new PathProcessingException(message);
//        }
//
//        if (!path.endsWith(".txt")) {
//            String message = "Path: " + filePath + " is not ended .txt";
//            throw new PathProcessingException(message);
//        }
//    }

//    public static void whetherPathIsDirectory(String path) {
//
//        Path filePath;
//        try {
//            filePath = Path.of(path);
//
//        } catch (InvalidPathException ex) {
//
//            String message = String.format(PATH_IS_INVALID, path);
//            throw new PathProcessingException(message, ex);
//        }
//
//        if (!Files.isDirectory(filePath)) {
//
//            String message = "This path is not directory " + filePath;
//            throw new PathProcessingException(message);
//        }
//    }
//
//    public static void notKey(String key, String alphabetName) {
//
//        try {
//            int valueKey = Integer.parseInt(key);
//
//            if ((valueKey % TextProcessing.choiceOfAlphabet(alphabetName).length) == 0) {
//
//                String message = "The key does not equals 0 or length of alphabet ("
//                        + TextProcessing.choiceOfAlphabet(alphabetName).length + "), text will not change";
//                throw new KeyInvalidException(message);
//            }
//        } catch (NumberFormatException e) {
//            String message = "The string \"" + key + "\" does not contain a parsable Integer";
//            throw new KeyInvalidException(message, e);
//        }
//    }

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

//    public static boolean autoSelectOfCorrectDecryption(String pathTo) {
//
//        try (FileInputStream fileInputStream = new FileInputStream(pathTo);
//             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
//
//            StringBuilder stringBuilder = new StringBuilder();
//            String secondWordFromFile = null;
//            int count = 0;
//            int symbol;
//
//            while ((symbol = bufferedReader.read()) != -1) {
//                String wordFromFile;
//
//                if (Character.isLetter(symbol) || Character.isWhitespace(symbol)) {
//
//                    if (Character.isWhitespace(symbol) || TextProcessing.isSymbol((char) symbol)) {
//
//                        wordFromFile = stringBuilder.toString();
//                        stringBuilder.delete(0, wordFromFile.length());
//
//                        if (Checks.isCorrespondFrequentWords(wordFromFile) &&
//                                !(wordFromFile.equalsIgnoreCase(secondWordFromFile))) {
//
//                            count++;
//
//                            // if "count" > 1, means two different words from Alphabets.STRINGS
//                            // match with content "pathFrom"
//                            if (count > 1) {
//
//                                return true;
//                            }
//                            secondWordFromFile = wordFromFile;
//                        }
//                    } else {
//                        stringBuilder.append((char) symbol);
//                    }
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//
//            String message = "File: \"" + pathTo + "\" not found";
//            throw new PathProcessingException(message, e);
//
//        } catch (SecurityException e) {
//
//            String message = "Invalid read access to the file: \"" + pathTo + "\"";
//            throw new PathProcessingException(message, e);
//
//        } catch (IOException e) {
//
//            String message = "An Output error occurs with file \"" + pathTo + "\"";
//            throw new ReadWrightFileException(message, e);
//        }
//        return false;
//    }

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

                        // if "count" > 1, means two different words from Alphabets.STRINGS
                        // match with content "pathFrom"
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
