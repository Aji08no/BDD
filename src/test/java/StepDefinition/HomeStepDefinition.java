package StepDefinition;

import io.cucumber.java.en.Then;

public class HomeStepDefinition {

    LoginStepDefinition l=new LoginStepDefinition();

    @Then("the user should be able to see the Practice List")
    public void the_user_should_be_able_to_see_the_practice_list() {
        l.homepage.clickPracticeList();
    }
}
