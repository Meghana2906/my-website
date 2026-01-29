package locatorsfile;

public class BookReviewDetails {

    LoginPage loginPage;

    public void addingReviewDetails(String reviewTitle, String reviewText) {
        loginPage.AddProductReview_Title(reviewTitle);
        loginPage.AddProductReview_ReviewText(reviewText);
        loginPage.rating_of_book();
        loginPage.submit_review();
    }
}
