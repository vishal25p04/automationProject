Feature: Validating Place API's

Scenario: Adding Place API and valiate it
   Given Add Place payload
   When user calls "AddPlaceAPI" with Post http method
   Then the API call got success with status 200
   And "status" in response body is "ok"
   And "scope" in response body is "APP"