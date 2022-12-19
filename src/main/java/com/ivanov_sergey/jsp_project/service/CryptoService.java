package com.ivanov_sergey.jsp_project.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface CryptoService {
    public String manualDecryptionBruteForce(HttpServletRequest req) throws ServletException, IOException;
    public String autoDecryptionBruteForce(HttpServletRequest req) throws ServletException, IOException;
    public String encryption(HttpServletRequest req) throws ServletException, IOException;
    public String decryptionWithKey(HttpServletRequest req) throws IOException, ServletException;
    public String autoDecryptionWithStatistic(HttpServletRequest req) throws ServletException, IOException;
}
