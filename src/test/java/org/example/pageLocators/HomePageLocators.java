package org.example.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

    @FindBy(xpath = "//*[@id=\"menuToggle\"]/input")
    public WebElement hamburger_menu;

    @FindBy(linkText = "Online Products")
    public WebElement online_prodPageLinkText;
}
