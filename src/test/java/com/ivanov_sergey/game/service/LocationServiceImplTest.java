package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.Personage;
import com.ivanov_sergey.game.entity.Storage;
import com.ivanov_sergey.game.service.exceptions.LocationInvalidParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class LocationServiceImplTest {

    @Mock
    Storage repository;

    @Mock
    Personage personage;
    LocationServiceImpl service;


    @BeforeEach
    void Setup(){
        service = new LocationServiceImpl(repository);
    }

    @Test
    void getClientIPAddress() {
    }

    @Test
    void test_getArmors_ShouldThrowException_WhenLocationNameIsNull() {

    }

    @Test
    void getPotions() {
    }

    @Test
    void getHelpers() {
    }

    @Test
    void getWeapons() {
    }

    @Test
    void getLocation() {
    }

    @Test
    void getLocations() {

    }

    @Test
    void getRepository() {
    }

    @Test
    void getPersonage() {
    }

    @Test
    void getIssue() {
    }

    @Test
    void test_getFirstIssue_ShouldThrowException_WhenFirstParameterIsNull() {
        assertThrows(LocationInvalidParameters.class,
                () -> service.getFirstIssue(null, 1));
    }

//    @Test
//    void test_getFirstIssue_ShouldThrowException_WhenSecondParameterIsInvalid() {
////        Personage mockedPersonage = mock(Personage.class);
//        Issue mockedIssue = mock(Issue.class);
//        List<Issue> issues = List.of(mockedIssue);
//        when(personage.getIssues()).thenReturn(issues);
//        when(issues.get(1)).thenReturn(mockedIssue);
//
//        assertThrows(LocationInvalidParameters.class,
//                () -> service.getFirstIssue(personage, 2));
//    }

    @Test
    void test_checkParameterByNull_ShouldThrowException_IfParameterIsNull() {
        assertThrows(LocationInvalidParameters.class,
                () -> service.checkParameterByNull(null));
    }
}