package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Location;
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
class FightingServiceImplTest {
    private  FightingService fightingService;

    @Mock
    private Storage sessionRepo;
    @Mock
    private Hero hero;
    @Mock
    private Personage personage;
    @Mock
    private Location location;

    private String action = "attack";


    @BeforeEach
    void setup(){
        fightingService = new FightingServiceImpl(sessionRepo);
    }

    @Test
    void personageKickHero_ShouldThrowException_ifFirstParameterByNull() {
        assertThrows(InvalidParameters.class,
                ()->fightingService.personageKickHero(null, personage, action));
    }

    @Test
    void personageKickHero_ShouldThrowException_ifSecondParameterByNull() {
        assertThrows(InvalidParameters.class,
                ()->fightingService.personageKickHero(hero, null, action));
    }

    @Test
    void personageKickHero_ShouldThrowException_ifThirdParameterByNull() {
        assertThrows(InvalidParameters.class,
                ()->fightingService.personageKickHero(hero, personage, null));
    }

    @Test
    void personageKickHero_ShouldThrowException_ifAllParametersByNull() {
        assertThrows(InvalidParameters.class,
                ()->fightingService.personageKickHero(null, null, null));
    }

    @Test
    void heroKickPersonage_ShouldThrowException_ifFirstParameterByNull() {
        assertThrows(InvalidParameters.class,
                ()->fightingService.heroKickPersonage(null, personage, action));
    }

    @Test
    void heroKickPersonage_ShouldThrowException_ifSecondParameterByNull() {
        assertThrows(InvalidParameters.class,
                ()->fightingService.heroKickPersonage(hero, null, action));
    }

    @Test
    void heroKickPersonage_ShouldThrowException_ifThirdParameterByNull() {
        assertThrows(InvalidParameters.class,
                ()->fightingService.heroKickPersonage(hero, personage, null));
    }

    @Test
    void heroKickPersonage_ShouldThrowException_ifAllParametersByNull() {
        assertThrows(InvalidParameters.class,
                ()->fightingService.heroKickPersonage(null, null, null));
    }

    @Test
    void deletePersonage_ShouldThrowException_ifFirstParameterByNull() {
    assertThrows(InvalidParameters.class,
            ()-> fightingService.deletePersonage(null,location));
    }

    @Test
    void deletePersonage_ShouldThrowException_ifSecondParameterByNull() {
        assertThrows(InvalidParameters.class,
                ()-> fightingService.deletePersonage(personage,null));
    }

    @Test
    void heroKickPersonage() {
    }

    @Test
    void personageKickHero(){

    }

    @Test
    void deletePersonage(){

    }
}