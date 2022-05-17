@TestingwithCucumber
Feature: verify movie details
@TestScenario1
Scenario: Asserting movie details from IMDB and Wikipedia
	Given Open Chrome browser with imdb URL
	And Open Chrome browser with wiki URL
	When Search for movie details in IMDB
	And Search for movie details in Wikipedia
	Then Validate movie details displayed