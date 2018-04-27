Feature: Post a comment on a bbc blog

  As a bbc blog user
  I want to be able to post a comment
  So that I can give feedback on the bbc blog page

  Scenario: Sign in and post a valid comment
    Given a signed in user is on the bbc blog page
    When the user adds a unique comment
    Then the comment is displayed

  Scenario: Sign in and post an empty comment
    Given a signed in user is on the bbc blog page
    When the user adds an invalid comment ""
    Then the comment message is displayed "You need to write your comment before you post it."

#   @manual
#  Scenario: Sign in and post non alphabetical characters
#    Given a signed in user is on the bbc blog page
#    When the user adds a valid comment "¬!£%^&*()_+}{~@:?><|\,./;'#[]=-"
#    Then the comment is displayed

#  @manual
#  Scenario: Register and then leave a comment
#    Given a user has registered on the bbc blog page
#    When the user adds a unique comment
#    Then the comment confirmation should be displayed

#  @manual
#  Scenario: Comment field  signed out
#  Given a signed out user is on the bbc blog page
#  Then the comment field is not available


