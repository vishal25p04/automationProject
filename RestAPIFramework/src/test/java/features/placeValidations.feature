Feature: Validating Place API's

@AddPlace
Scenario Outline: Adding Place API and validate it
   Given Add Place payload with "<name>" "<address>" "<language>"
   When user calls "addPlaceAPI" with "POST" http method
   Then the API call got success with status 200
   And "status" in response body is "OK"
   And "scope" in response body is "APP"
   And verify place_Id created maps to "<name>" using "getPlaceAPI"
   
   Examples:
   		| name 		 | address 			| language |
   		| PizzaHut | Times Square | English  |
   #		| Dominos  | 1st main St  | French   |