package com.sparta.as.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefs {
    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
    }


    @Then("It will take me to the {string} page")
    public void itWillTakeMeToTheNewPage() {
    }

    @When("I click on {string} page")
    public void iClickOnPage(String arg0) {
    }

}
