package locatorsfile;

public class Books {
    LoginPage loginPage;

    public void addingReviewMain() {
        loginPage.clickBooks();
        loginPage.click_Computing_and_Internet();
        loginPage.addReview();

    }

}
