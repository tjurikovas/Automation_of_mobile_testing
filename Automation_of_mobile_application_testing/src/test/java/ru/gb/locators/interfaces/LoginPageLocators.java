package ru.gb.locators.interfaces;

import org.openqa.selenium.By;

public interface LoginPageLocators {

    By inputEmail ();
    By inputPassword ();
    By clickButtonLogin ();
    By errorTextLocator ();
    By errorTextLocatorWithoutEmail ();
}
