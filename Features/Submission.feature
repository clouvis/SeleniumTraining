#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Submission feature
  
  Background:
  	Given I login to PC as username "aapplegate" and password "gw"
  	And I create an account with the following details:
        | firstName     | Jig               		|
        | lastName      | Denosta           		|
        | email         | jimdenosta@yahoo.com 	|
        | address1      | 3571 Burnside Court 	|
        | city          | Phoenix             	|
        | state         | AZ                  	|
        | zip           | 85001               	|
        | addressType   | home                	|
  	
	Scenario: Create a policy and verify the status
		When I create a "Homeowners" submission with the following details:
				| policyType     					| Dwelling               		|
        | coverageForm      			| HO2           						|
        | occupant         				| Myself										|
        | occupyFullTime      		| Yes 											|
        | fireProtection          | Standard             			|
        | inputYearBuilt         	| 2015                  		|
        | construction           	| Concrete               		|
        | numOfStories   					| 2                					|
        | garage     							| Attached Garage - 1 Car   |
        | roof      							| Composite           			|
        | foundation         			| Slab											|
        | primaryHeating      		| Electricity 							|
        | secondaryHeating        | Gas             					|
        | plumbing         				| PVC                  			|
        | wiring           				| Copper               			|
        | electricalSystem   			| Circuit Breaker           |
        | coinsurance         		| 50%                  			|
        | lossRental           		| No               					|
        | prohibitedUse   				| 45 Days         					|
		And I search for the previously created policy
		Then the status of the policy should be "In Force"
		
  