package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.entity.Hero;
import com.ivanov_sergey.game.entity.Location;
import com.ivanov_sergey.game.service.exceptions.InvalidParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ThingsServiceImplTest {

    @Mock
    Location location;
    @Mock
    Hero hero;
    ThingsService thingsService;
    String stringValue = "stringValue";

    @BeforeEach
    void setup(){
        thingsService = new ThingsServiceImpl();
    }

    @Test
    void transferThingFromBoxToInventory_ShouldThrowException_IfFirstParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.transferThingFromBoxToInventory(null, location, hero));
    }

    @Test
    void transferThingFromBoxToInventory_ShouldThrowException_IfSecondParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.transferThingFromBoxToInventory(stringValue, null, hero));
    }

    @Test
    void transferThingFromBoxToInventory_ShouldThrowException_IfThirdParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.transferThingFromBoxToInventory(stringValue, location, null));
    }

    @Test
    void transferThingFromBoxToInventory_ShouldThrowException_IfAllParametersByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.transferThingFromBoxToInventory(null, null, null));
    }

    //________

    @Test
    void useThing_ShouldThrowException_IfFirstParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useThing(null, location, hero));
    }

    @Test
    void useThing_ShouldThrowException_IfSecondParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useThing(stringValue, null, hero));
    }

    @Test
    void useThing_ShouldThrowException_IfThirdParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useThing(stringValue, location, null));
    }

    @Test
    void useThing_ShouldThrowException_IfAllParametersByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useThing(null, null, null));
    }

    //________

    @Test
    void useArmor_ShouldThrowException_IfFirstParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useArmor(null, location, hero));
    }

    @Test
    void useArmor_ShouldThrowException_IfSecondParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useArmor(stringValue, null, hero));
    }

    @Test
    void useArmor_ShouldThrowException_IfThirdParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useArmor(stringValue, location, null));
    }

    @Test
    void useArmor_ShouldThrowException_IfAllParametersByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useArmor(null, null, null));
    }

    //________

    @Test
    void usePotion_ShouldThrowException_IfFirstParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.usePotion(null, location, hero));
    }

    @Test
    void usePotion_ShouldThrowException_IfSecondParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.usePotion(stringValue, null, hero));
    }

    @Test
    void usePotion_ShouldThrowException_IfThirdParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.usePotion(stringValue, location, null));
    }

    @Test
    void usePotion_ShouldThrowException_IfAllParametersByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.usePotion(null, null, null));
    }

    //________

    @Test
    void useKey_ShouldThrowException_IfFirstParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useKey(null, location, hero));
    }

    @Test
    void useKey_ShouldThrowException_IfSecondParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useKey(stringValue, null, hero));
    }

    @Test
    void useKey_ShouldThrowException_IfThirdParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useKey(stringValue, location, null));
    }

    @Test
    void useKey_ShouldThrowException_IfAllParametersByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useKey(null, null, null));
    }

    //________

    @Test
    void useWeapon_ShouldThrowException_IfFirstParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useWeapon(null, location, hero));
    }

    @Test
    void useWeapon_ShouldThrowException_IfSecondParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useWeapon(stringValue, null, hero));
    }

    @Test
    void useWeapon_ShouldThrowException_IfThirdParameterByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useWeapon(stringValue, location, null));
    }

    @Test
    void useWeapon_ShouldThrowException_IfAllParametersByNull() {
        assertThrows(InvalidParameters.class,
                () -> thingsService.useWeapon(null, null, null));
    }

    @Test
    void transferThingFromBoxToInventory() {
    }

    @Test
    void useThing() {
    }

    @Test
    void useArmor() {
    }

    @Test
    void usePotion() {
    }

    @Test
    void useKey() {
    }

    @Test
    void useWeapon() {
    }
}