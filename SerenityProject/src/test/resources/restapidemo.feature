Feature: Rest Assured demo

  Scenario: Example of GET , PUT , POST , DELETE
    Given the user is navigating to base url
    When Adding place and extracting respones
    And Extract place_id from response
    And Update the place with a new address
    And Get place details to verify the address
    Then Delete api
