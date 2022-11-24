package com.ivanov_sergey.game.servlets;

import com.ivanov_sergey.game.repository.Repository;
import com.ivanov_sergey.game.service.ModuleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationServletTest {

    @Mock
    ModuleService moduleService;

    @Mock
    Repository repository;

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response ;

    @Mock
    HttpSession session;

    @BeforeEach
    void setup(){

    }

    @Test
    void doGet() {

    }

    @Test
    void doPost() {
    }
}