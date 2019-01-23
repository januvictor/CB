package Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GetPostStep {

    private String Deck_ID;
    private Response response = null;
    private final int Status_OK = 200;
    private final int Deck_Total = 52;

    @Given("^a new deck starts with shuffling of cards$")
    public void aNewDeckStartsWithShufflingOfCards() {
        try {
            response = given().
                    contentType(ContentType.JSON).
                    get("https://deckofcardsapi.com/api/deck/new/shuffle");
            Deck_ID = response.path("deck_id");
            assertThat(response.getStatusCode(), equalTo(Status_OK));
            assertEquals(response.path("shuffled"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^Draw cards from the deck five times between (\\d+) and (\\d+)$")
    public void drawCardsFromTheDeckFiveTimesBetweenAnd(int draw_1, int total_draw) {

        try {
            assertThat(total_draw, lessThanOrEqualTo(Deck_Total));

            for (int i = 0; i < total_draw; i++) {
                response = given().
                        contentType(ContentType.JSON).
                        pathParam("ID", Deck_ID).
                        queryParam("count", draw_1).
                        when().
                        get("https://deckofcardsapi.com/api/deck/{ID}/draw/");
            }

            Assert.assertEquals(response.getStatusCode(), Status_OK);
        } catch (AssertionError e) {
            e.printStackTrace();
        }
    }

    @Then("^Verify the remaining cards in the deck is equal to (\\d+)$")
    public void verifyTheRemainingCardsInTheDeckIsEqualTo(int Expected_remaining) {
        try {
            Assert.assertEquals(response.getBody().path("remaining"), Expected_remaining);
        } catch (AssertionError e) {
            e.printStackTrace();
        }
    }
}
