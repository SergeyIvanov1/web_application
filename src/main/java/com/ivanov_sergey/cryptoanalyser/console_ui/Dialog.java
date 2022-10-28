package com.ivanov_sergey.cryptoanalyser.console_ui;

//import com.ivanovsergey.cryptoanalyser.exceptions.KeyInvalidException;
//import com.ivanovsergey.cryptoanalyser.exceptions.PathProcessingException;
//import com.ivanovsergey.cryptoanalyser.exceptions.ReadWrightFileException;

public class Dialog {

    private static final String PATH_SPECIFIED_WRONG = "\nPath specified wrong.";
    private static final String ERROR_READING_WRITING_FILE = "\nError reading/writing file";
    private static final String STRING_IS_EMPTY_ERROR_MESSAGE = "String is empty";
    private static final String WRONG_KEY = "\nWrong key: ";
    private static final String SELECTED_FUNCTION_ENCODE = "encode";
    private static final String SELECTED_FUNCTION_DECODE = "decode";
    private static final String QUERY_OF_CONTINUATION = "Completion function. "
            + "select the menu number to continue the program or enter \"exit\" for exit";
    private static final int EXIT_STATUS_1 = 1;
    private static final int EXIT_STATUS_2 = 2;
    private static final int EXIT_STATUS_3 = 3;
    private static final int EXIT_STATUS_4 = 4;
    private static String pathFrom;
    private static String pathTo;
    private static String key;

    private Dialog() {
    }

//    public static void start() {
//        Scanner console = new Scanner(System.in);
//
//        System.out.println("The program \"Crypto analyser\".\n");
//
//        System.out.println("Choose language for Encode/Decode:" +
//                " russian or english (enter \"en\" or \"ru\")");
//
//        while (true) {
//            String answer = console.nextLine();
//
//            if ("en".equalsIgnoreCase(answer)) {
//                TextProcessing.language = TextProcessing.ENGLISH_LANGUAGE;
//                break;
//            } else if ("ru".equalsIgnoreCase(answer)) {
//                TextProcessing.language = TextProcessing.RUSSIAN_LANGUAGE;
//                break;
//            } else {
//                System.out.println("Enter \"en\" or \"ru\"");
//            }
//        }
//
//        System.out.println("\nSelect the menu number the program:\n"
//                + "1 - Encode text\n"
//                + "2 - Decode text, using the key\n"
//                + "3 - Decode text, using \"Brute force\" method, using manual selection\n"
//                + "4 - Decode text, using \"Brute force\" method, using auto selection\n"
//                + "5 - Decode text, using \"Statistic analise\" method, using manual selection\n"
//                + "6 - Decode text, using \"Statistic analise\" method, using auto selection\n");
//
//        String choice;
//        while (!("exit").equalsIgnoreCase(choice = console.nextLine())) {
//            switch (choice) {
//                case "1":
//
//                    try {
//                        requestPath(console, SELECTED_FUNCTION_ENCODE);
//                    } catch (PathProcessingException ex) {
//                        messageToUserAboutError(ex, PATH_SPECIFIED_WRONG, EXIT_STATUS_1);
//                    }
//
//                    try {
//                        requestKey(console);
//                    } catch (KeyInvalidException e) {
//                        messageToUserAboutError(e, WRONG_KEY, EXIT_STATUS_2);
//                    }
//
//                    try {
//                        Coder.encryption(pathFrom, pathTo, Integer.parseInt(key));
//                    } catch (PathProcessingException e) {
//                        messageToUserAboutError(e, PATH_SPECIFIED_WRONG, EXIT_STATUS_3);
//                    } catch (ReadWrightFileException ex) {
//                        messageToUserAboutError(ex, ERROR_READING_WRITING_FILE, EXIT_STATUS_4);
//                    }
//
//                    System.out.println(QUERY_OF_CONTINUATION);
//                    break;
//
//                case "2":
//
//                    try {
//                        requestPath(console, SELECTED_FUNCTION_DECODE);
//                    } catch (PathProcessingException ex) {
//                        messageToUserAboutError(ex, PATH_SPECIFIED_WRONG, EXIT_STATUS_1);
//                    }
//
//                    try {
//                        requestKey(console);
//                    } catch (KeyInvalidException e) {
//                        messageToUserAboutError(e, WRONG_KEY, EXIT_STATUS_2);
//                    }
//
//                    try {
//                        Decoder.decryptionWithKey(pathFrom, pathTo, Integer.parseInt(key));
//                    } catch (PathProcessingException e) {
//                        messageToUserAboutError(e, PATH_SPECIFIED_WRONG, EXIT_STATUS_3);
//                    } catch (ReadWrightFileException ex) {
//                        messageToUserAboutError(ex, ERROR_READING_WRITING_FILE, EXIT_STATUS_4);
//                    }
//
//                    System.out.println(QUERY_OF_CONTINUATION);
//                    break;
//
//                case "3":
//
//                    try {
//                        requestFileAddress(console);
//                        requestDirectoryAddress(console);
//                    } catch (PathProcessingException ex) {
//                        messageToUserAboutError(ex, PATH_SPECIFIED_WRONG, EXIT_STATUS_1);
//                    }
//
//                    try {
//                        Decoder.manualDecryptionBruteForce(pathFrom, pathTo);
//                    } catch (PathProcessingException e) {
//                        messageToUserAboutError(e, PATH_SPECIFIED_WRONG, EXIT_STATUS_3);
//                    } catch (ReadWrightFileException ex) {
//                        messageToUserAboutError(ex, ERROR_READING_WRITING_FILE, EXIT_STATUS_4);
//                    }
//
//                    System.out.println(QUERY_OF_CONTINUATION);
//                    break;
//
//                case "4":
//
//                    try {
//                        requestPath(console, SELECTED_FUNCTION_DECODE);
//                    } catch (PathProcessingException ex) {
//                        messageToUserAboutError(ex, PATH_SPECIFIED_WRONG, EXIT_STATUS_1);
//                    }
//
//                    try {
//                        Decoder.autoDecryptionBruteForce(pathFrom, pathTo);
//                    } catch (PathProcessingException e) {
//                        messageToUserAboutError(e, PATH_SPECIFIED_WRONG, EXIT_STATUS_3);
//                    } catch (ReadWrightFileException ex) {
//                        messageToUserAboutError(ex, ERROR_READING_WRITING_FILE, EXIT_STATUS_4);
//                    }
//
//                    System.out.println(QUERY_OF_CONTINUATION);
//                    break;
//
//                case "5":
//
//                    try {
//                        requestFileAddress(console);
//                        requestDirectoryAddress(console);
//                    } catch (PathProcessingException ex) {
//                        messageToUserAboutError(ex, PATH_SPECIFIED_WRONG, EXIT_STATUS_1);
//                    }
//
//                    try {
//                        Decoder.manualDecryptionWithStatistic(pathFrom, pathTo);
//                    } catch (PathProcessingException e) {
//                        messageToUserAboutError(e, PATH_SPECIFIED_WRONG, EXIT_STATUS_3);
//                    } catch (ReadWrightFileException ex) {
//                        messageToUserAboutError(ex, ERROR_READING_WRITING_FILE, EXIT_STATUS_4);
//                    }
//
//                    System.out.println(QUERY_OF_CONTINUATION);
//                    break;
//
//                case "6":
//
//                    try {
//                        requestPath(console, SELECTED_FUNCTION_DECODE);
//                    } catch (PathProcessingException ex) {
//                        messageToUserAboutError(ex, PATH_SPECIFIED_WRONG, EXIT_STATUS_1);
//                    }
//
//                    try {
//                        Decoder.autoDecryptionWithStatistic(pathFrom, pathTo);
//                    } catch (PathProcessingException e) {
//                        messageToUserAboutError(e, PATH_SPECIFIED_WRONG, EXIT_STATUS_3);
//                    } catch (ReadWrightFileException ex) {
//                        messageToUserAboutError(ex, ERROR_READING_WRITING_FILE, EXIT_STATUS_4);
//                    }
//
//                    System.out.println(QUERY_OF_CONTINUATION);
//                    break;
//
//                default:
//                    System.out.println("Select the menu number the program or enter \"exit\" for exit");
//            }
//        }
//    }
//
//    private static void messageToUserAboutError(Exception ex, String message, Integer exitStatus) {
//        System.out.println(message);
//        System.err.println(ex.getMessage());
//        System.exit(exitStatus);
//    }
//
//    private static void requestPath(Scanner console, String selectFunction) {
//        System.out.println("Enter file address (\".txt\" format), where is text for " + selectFunction);
//        pathFrom = console.nextLine();
//        if (pathFrom.isEmpty()) {
//            throw new PathProcessingException(STRING_IS_EMPTY_ERROR_MESSAGE);
//        }
//        Checks.isFile(pathFrom);
//
//        System.out.println("Enter file address (\".txt\" format), "
//                + "where will save result of " + selectFunction);
//
//        pathTo = console.nextLine();
//        if (pathTo.isEmpty()) {
//            throw new PathProcessingException(STRING_IS_EMPTY_ERROR_MESSAGE);
//        }
//
//        Checks.isFile(pathTo);
//    }
//
//    private static void requestFileAddress(Scanner console) {
//
//        System.out.println("Enter file address (\".txt\" format), where is text for decode");
//        pathFrom = console.nextLine();
//
//        if (pathFrom.isEmpty()) {
//            throw new PathProcessingException(STRING_IS_EMPTY_ERROR_MESSAGE);
//        }
//
//        Checks.isFile(pathFrom);
//    }
//
//    private static void requestDirectoryAddress(Scanner console) {
//
//        System.out.println("Enter folder address, where will save result of decode");
//        pathTo = console.nextLine();
//
//        if (pathTo.isEmpty()) {
//            throw new PathProcessingException(STRING_IS_EMPTY_ERROR_MESSAGE);
//        }
//
//        Checks.whetherPathIsDirectory(pathTo);
//    }
//
//    private static void requestKey(Scanner console) {
//
//        System.out.println("Enter the key");
//        key = console.nextLine();
//        Checks.notKey(key, TextProcessing.language);
//    }
}
