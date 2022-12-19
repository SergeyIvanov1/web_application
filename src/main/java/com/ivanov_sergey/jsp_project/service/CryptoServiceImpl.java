package com.ivanov_sergey.jsp_project.service;

import com.ivanov_sergey.cryptoanalyser.text_processing.Coder;
import com.ivanov_sergey.cryptoanalyser.text_processing.Decoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CryptoServiceImpl implements CryptoService{
    public String manualDecryptionBruteForce(HttpServletRequest req) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Decoder.manualDecryptionBruteForce(req, stringBuilder);
        return stringBuilder.toString();
    }

    public String autoDecryptionBruteForce(HttpServletRequest req) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Decoder.autoDecryptionBruteForce(req, stringBuilder);
        return stringBuilder.toString();
    }

    public String encryption(HttpServletRequest req) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int key = Integer.parseInt(req.getParameter("key"));
        Coder.encryption(req, stringBuilder, key);
        return stringBuilder.toString();
    }

    public String decryptionWithKey(HttpServletRequest req) throws IOException, ServletException {
        StringBuilder stringBuilder = new StringBuilder();
        int key = Integer.parseInt(req.getParameter("key"));
        Decoder.decryptionWithKey(req, stringBuilder, key);
        return stringBuilder.toString();
    }

    public String autoDecryptionWithStatistic(HttpServletRequest req) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Decoder.autoDecryptionWithStatistic(req, stringBuilder);
        return stringBuilder.toString();
    }
}
