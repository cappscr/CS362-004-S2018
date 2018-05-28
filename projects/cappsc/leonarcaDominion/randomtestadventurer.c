/** randomtestadventurer.c
 * Author: Christopher Capps
 * Date: May 11, 2018
 * Description: Random tester for the adventurer card function in dominion.c
 * */

#include "dominion.h"
#include "dominion_helpers.h"
#include "rngs.h"
#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>

int asserttrue(int expected, int actual, char* message)
{
    if (actual != expected)
    {
        if (message != NULL)
            printf("TEST FAILED: %s\nExpected value: %d\nActual value: %d\n\n", message, expected, actual);
        else
            printf("TEST FAILED: Expected value: %d\nActual value: %d\n\n", expected, actual);
        return 0;
    }
    else
    {
        //printf("TEST SUCCESSFULLY COMPLETED\n");
        return 1;
    }
}

int checkForTreasure(int cardToCheck) 
{
    // return 0 if card is not a treasure
    switch (cardToCheck) {
        case copper:
            return 1;
        case silver:
            return 1;
        case gold:
            return 1;
        default:
            return 0;
    }
}

int testAdventurerCard(struct gameState *post, int cP)
{
    struct gameState pre;
    memcpy(&pre, post, sizeof(struct gameState));

    int r, a;
    int flag = 0;

    //printf("Statement prior to adventurer card call\n");
    r = cardEffect(adventurer, 0, 0, 0, post, (post->handCount[cP] - 1), NULL);
    //printf("OUTSIDE cardEffect\n");
    // r should return 0
   // printf("Value of r: %d\n", r);
    a = asserttrue(0, r, "Function return value was incorrect.");
    if (a == 0)
        flag = 1;


    /* post adventurer card
     * hand[handSize - 1] & hand[handSize - 2] should be treasure cards
     * post deckCount should be at least 2 less than pre deckCount
    */

    //printf("TESTING that top 2 cards in hand are treasures\n");
    int treasureCheck = checkForTreasure(post->hand[cP][post->handCount[cP] - 1]);
    a = asserttrue(1, treasureCheck, "The last card in the hand was not a treasure card.");
    if (a == 0)
        flag = 1;
    treasureCheck = checkForTreasure(post->hand[cP][post->handCount[cP] - 2]);
    a = asserttrue(1, treasureCheck, "The second to last card in the hand was not a treasure card.");
    if (a == 0)
        flag = 1;

    return flag;
}

int main() {

    // perform necessary setup
    struct gameState G;
    int currentPlayer;
    int t;
    int didATestFail = 0;
    int treasureCount = 0;

    // seed the random number generator
    SelectStream(2);
    PutSeed(3);

    // generate inputs randomly
    /* struct gameState *state, 
       int* drawntreasure, 
       int* currentPlayer, 
       int temphand[MAX_HAND], 
       int* z
    */

    // call function in a loop with randomly generated inputs
    for (int n = 0; n < 388; n++) {
        treasureCount = 0;
        printf("TEST ITERATION %d\n", n+1);
        for (int i = 0; i < sizeof(struct gameState); i++)
        {
            ((char *)&G)[i] = floor(Random() * 256);
        }
        // consider pre-conditions
        currentPlayer = floor(Random() * (MAX_PLAYERS - 1));
        G.whoseTurn = currentPlayer;
        //printf("Value of currentPlayer is: %d\n", currentPlayer);
        G.deckCount[currentPlayer] = floor(Random() * MAX_DECK);
        //printf("Value of deckCount is: %d\n", G.deckCount[currentPlayer]);
        G.discardCount[currentPlayer] = floor(Random() * MAX_DECK);
        //printf("Value of discardCount is: %d\n", G.discardCount[currentPlayer]);
        G.handCount[currentPlayer] = floor(Random() * MAX_HAND);
        //printf("Value of handCount is: %d\n", G.handCount[currentPlayer]);

        for (int j = 0; j < G.deckCount[currentPlayer]; j++)
        {
            G.deck[currentPlayer][j] = floor(Random() * treasure_map);
            if (checkForTreasure(G.deck[currentPlayer][j]))
                treasureCount++;
        }

        for (int k = 0; k < *(G.handCount); k++)
        {
            G.hand[currentPlayer][k] = floor(Random() * treasure_map);
        }
        G.hand[currentPlayer][G.handCount[currentPlayer] - 1] = adventurer;
        
        for (int q = 0; q < *(G.discardCount); q++)
        {
            G.discard[currentPlayer][q] = floor(Random() * treasure_map);
            if (checkForTreasure(G.discard[currentPlayer][q]))
                treasureCount++;
        }

        //printf("Total treasure in discard and deck is: %d\n", treasureCount);
        
        t = testAdventurerCard(&G, currentPlayer);
        if (t == 1)
            didATestFail = 1;
    }
    if (didATestFail == 0) 
        printf("ALL TESTS PASSED SUCCESSFULLY\n");
    return 0;
}