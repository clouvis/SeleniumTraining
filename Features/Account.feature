Feature: Account feature

  Scenario: Create an Personal Account
    Given I login to PolicyCenter as username "aapplegate" and password "gw"
    When I create a personal account with the following details:
        | firstName     | Jig               		|
        | lastName      | Denosta           		|
        | email         | jimdenosta@yahoo.com 	|
        | address1      | 3571 Burnside Court 	|
        | city          | Phoenix             	|
        | state         | AZ                  	|
        | zip           | 85001               	|
        | addressType   | home                	|
    Then a previously created account should be displayed upon searching