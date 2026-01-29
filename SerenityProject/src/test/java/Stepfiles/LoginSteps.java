package Stepfiles;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import locatorsfile.BookReviewDetails;
import locatorsfile.Books;
import locatorsfile.LoginPage;
import locatorsfile.LoginSerenitySteps;
import net.serenitybdd.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

public class LoginSteps {

    @Steps
    LoginSerenitySteps loginSerenitySteps;
    @Steps
    Books books;
    @Steps
    BookReviewDetails bookReviewDetails;
    LoginPage loginPage;

    @Given("the user is on the login page")
    public void navigate_application() {
        loginSerenitySteps.loginUser();
    }

    @When("click on books and add review")
    public void click_on_books_and_add_review() {
        books.addingReviewMain();
    }

    @And("user adds the details review title {string} and review text {string}")
    public void userAddsTheDetailsReviewTitleAndReviewText(String reviewTitle, String reviewText) {
        bookReviewDetails.addingReviewDetails(reviewTitle, reviewText);
    }

    @Then("validation of title and text {string} and review text {string}")
    public void validationOfTitleAndTextAndReviewText(String expectedTitle, String expectedText) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(loginPage.getLastReviewTitle()).isEqualTo(expectedTitle);
        softly.assertThat(loginPage.getLastReviewText()).isEqualTo(expectedText);
        softly.assertAll();
    }
}
