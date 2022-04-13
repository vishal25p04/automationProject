Feature: Validating Place API's

@AddPlace
Scenario Outline: Adding Place API and validate it
   Given Add Place payload with "<name>" "<address>" "<language>"
   When user calls "add PlaceAPI" with "POST" http method
   Then the API call got success with status 200
   And "status" in response body is "OK"
   And "scope" in response body is "APP"
   
   Examples:
   		| name 		 | address 			| language |
   		| PizzaHut | Times Square | English  |
   #		| Dominos  | 1st main St  | French   |