$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("GetPost.feature");
formatter.feature({
  "line": 1,
  "name": "Drawing from Deck of cards",
  "description": "",
  "id": "drawing-from-deck-of-cards",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Remaining cards correctly updated after drawing",
  "description": "",
  "id": "drawing-from-deck-of-cards;remaining-cards-correctly-updated-after-drawing",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "a new deck starts with shuffling of cards",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "Draw cards from the deck five times between 1 and 5",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "Verify the remaining cards in the deck is equal to 47",
  "keyword": "Then "
});
formatter.match({
  "location": "GetPostStep.aNewDeckStartsWithShufflingOfCards()"
});
formatter.result({
  "duration": 11791543912,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 44
    },
    {
      "val": "5",
      "offset": 50
    }
  ],
  "location": "GetPostStep.drawCardsFromTheDeckFiveTimesBetweenAnd(int,int)"
});
formatter.result({
  "duration": 2636279427,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "47",
      "offset": 51
    }
  ],
  "location": "GetPostStep.verifyTheRemainingCardsInTheDeckIsEqualTo(int)"
});
formatter.result({
  "duration": 21733376,
  "status": "passed"
});
});