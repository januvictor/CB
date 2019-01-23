Feature: Drawing from Deck of cards
  Scenario: Remaining cards correctly updated after drawing
    Given  a new deck starts with shuffling of cards
    When Draw cards from the deck five times between 1 and 5
    Then Verify the remaining cards in the deck is equal to 47