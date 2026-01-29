Feature: Login to Tricentis Demo Web Shop

  Scenario Outline: Successful login with valid credentials and review submission
    Given the user is on the login page
    When click on books and add review
    And user adds the details review title "<reviewTitle>" and review text "<reviewText>"
    Then validation of title and text "<reviewTitle>" and review text "<reviewText>"

    Examples:
      | reviewTitle | reviewText           |
      | best book   | one of best book     |
      | great read  | loved the storyline  |
      | average     | could be better      |


