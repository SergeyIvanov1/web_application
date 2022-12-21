package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.Helper;
import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Personage;
import com.ivanov_sergey.game.entity.Storage;
import com.ivanov_sergey.game.service.exceptions.InvalidParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LocationServiceImplTest {

    private LocationService locationService;
    @Mock
    private  Storage sessionRepo;
    @Mock
    private  Hero hero;
    @Mock
    private Helper helper;
    @Mock
    private Personage personage;
    private  String personageName = "personageName";
    private  String lastLocation = "lastLocation";
    private String nextQuestion = "nextQuestion";
    private  int index = 0;

    @BeforeEach
    void setup() {
        locationService = new LocationServiceImpl(sessionRepo);
    }

    @Test
    void getClientIPAddress_ShouldThrowException_IfParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getClientIPAddress(null));
    }

    @Test
    void getArmors_ShouldThrowException_IfParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getArmors(null));
    }

    @Test
    void getPotions_ShouldThrowException_IfParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getPotions(null));
    }

    @Test
    void getHelpers_ShouldThrowException_IfParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getHelpers(null));
    }

    @Test
    void getWeapons_ShouldThrowException_IfParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getWeapons(null));
    }

    @Test
    void getLocation_ShouldThrowException_IfParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getLocation(null));
    }

    @Test
    void passQuestToHero_ShouldThrowException_IfFirstParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.passQuestToHero(null, lastLocation, hero));
    }

    @Test
    void passQuestToHero_ShouldThrowException_IfSecondParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.passQuestToHero(personageName, null, hero));
    }

    @Test
    void passQuestToHero_ShouldThrowException_IfThirdParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.passQuestToHero(personageName, lastLocation, null));
    }

    @Test
    void passQuestToHero_ShouldThrowException_IfAllParametersByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.passQuestToHero(null, null, null));
    }


    @Test
    void calculateIssue_ShouldThrowException_IfFirstParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.calculateIssue(null, hero, lastLocation));
    }

    @Test
    void calculateIssue_ShouldThrowException_IfSecondParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.calculateIssue(personageName, null, lastLocation));
    }

    @Test
    void calculateIssue_ShouldThrowException_IfThirdParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.calculateIssue(personageName, hero, null));
    }

    @Test
    void calculateIssue_ShouldThrowException_IfAllParametersByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.calculateIssue(null, null, null));
    }



    @Test
    void finishQuest_ShouldThrowException_IfFirstParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.finishQuest(null, lastLocation, hero));
    }

    @Test
    void finishQuest_ShouldThrowException_IfSecondParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.finishQuest(helper, null, hero));
    }

    @Test
    void finishQuest_ShouldThrowException_IfThirdParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.finishQuest(helper, lastLocation, null));
    }

    @Test
    void finishQuest_ShouldThrowException_IfAllParametersByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.finishQuest(null, null, null));
    }



    @Test
    void getPersonage_ShouldThrowException_IfFirstParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getPersonage(null, lastLocation));
    }

    @Test
    void getPersonage_ShouldThrowException_IfSecondParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getPersonage(personageName, null));
    }

    @Test
    void getPersonage_ShouldThrowException_IfAllParametersByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getPersonage(null, null));
    }


    @Test
    void getIssue_ShouldThrowException_IfFirstParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getIssue(null, nextQuestion, lastLocation));
    }

    @Test
    void getIssue_ShouldThrowException_IfSecondParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getIssue(personageName, null, lastLocation));
    }

    @Test
    void getIssue_ShouldThrowException_IfThirdParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getIssue(personageName, nextQuestion, null));
    }

    @Test
    void getIssue_ShouldThrowException_IfAllParametersByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getIssue(null, null, null));
    }

    //______
    @Test
    void getFirstIssue_ShouldThrowException_IfFirstParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getFirstIssue(null, index));
    }

    @Test
    void getFirstIssue_ShouldThrowException_IfSecondParameterByNegative() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getFirstIssue(personage, -5));
    }

    @Test
    void getFirstIssue_ShouldThrowException_IfAllParametersByInvalid() {
        assertThrows(InvalidParameters.class,
                () -> locationService.getFirstIssue(null, -5));
    }

    @Test
    void toOpenWickets_ShouldThrowException_IfParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> locationService.toOpenWickets(null));
    }

    @Test
    void getClientIPAddress() {
    }

    @Test
    void getArmors() {
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
    void passQuestToHero() {
    }

    @Test
    void calculateIssue() {
    }

    @Test
    void finishQuest() {
    }

    @Test
    void getSessionRepo() {
    }

    @Test
    void getPersonage() {
    }

    @Test
    void getIssue() {
    }

    @Test
    void getFirstIssue() {
    }

    @Test
    void toOpenWickets() {
    }
}