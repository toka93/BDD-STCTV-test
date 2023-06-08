

Feature: Validate Packages Type & Price and Currency for all Countries
  I want to use this template for my feature file
@firstScenario
  Scenario: Validate Packages,Type,Price and Currency for Country
    Given User Navigate to "https://subscribe.stctv.com/"
    And  User Navigate to English Version
    When User Select Country "<country>"
    Then  Package Types are :
    | LITE | 
    | CLASSIC | 
    |PREMIUM |
    Then Prices are:
    |lite   |"<lite>"|
    |classic|"<classic>"|
    |premium|"<premium>"| 
    
    
    Examples: 
    |country|lite|classic|premium|
    | ae    |5.4 |10.9   |16.3   | 
    | tn    |1.7 |3.4    |5.8    |
    | ps    |2.4 |4.8    |7.2    |
          