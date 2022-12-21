package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.service.exceptions.InvalidParameters;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ModuleServiceImplTest {
    @Mock
    private SessionFactory sessionFactory;
    private ModuleService moduleService;
    private final int NEGATIVE_ID = -5;

    @BeforeEach
    void setup(){
    moduleService = new ModuleServiceImpl(sessionFactory);
    }

    @Test
    void getLocation_ShouldThrowException_IfParameterByNegative() {
        assertThrows(InvalidParameters.class,
                () -> moduleService.getLocation(NEGATIVE_ID));
    }

    @Test
    void getLocation_ShouldThrowException_IfParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> moduleService.getLocation(null));
    }

    @Test
    void getOrCreateHero_ShouldThrowException_IfParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> moduleService.getOrCreateHero(null));
    }

    @Test
    void saveHero_ShouldThrowException_IfParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> moduleService.saveHero(null));
    }

    @Test
    void increaseCountOfGame_ShouldThrowException_IfParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> moduleService.increaseCountOfGame(null));
    }

    @Test
    void fillRepositoryDBData_ShouldThrowException_IfParameterByNegative() {
        assertThrows(InvalidParameters.class,
                () -> moduleService.fillRepositoryDBData(NEGATIVE_ID));
    }

    @Test
    void copyObject_ShouldThrowException_IfParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> moduleService.copyObject(null));
    }

    @Test
    void getLocation() {
    }

    @Test
    void testGetLocation() {
    }

    @Test
    void getOrCreateHero() {
    }

    @Test
    void saveHero() {
    }

    @Test
    void increaseCountOfGame() {
    }

    @Test
    void fillRepositoryDBData() {
    }

    @Test
    void getAllHero() {
    }

    @Test
    void copyObject() {
    }
}