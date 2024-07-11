
Feature: login feature

  Scenario Outline: login feature
 
  Given user is on login page
  When user enters valid username"<username>"
  And user enters valid password"<password>"
  And clicks on submit
  Then user should be on home page
  
  Examples: 
      | username  | password |
      | test1 | 13p67 |
      | test2 |2344s |
      
     
    
