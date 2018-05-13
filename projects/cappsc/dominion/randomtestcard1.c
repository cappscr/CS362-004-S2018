/** randomtestcard1.c
 * Author: Christopher Capps
 * Date: May 13, 2018
 * Description: Random tester for the Smithy card function in dominion.c
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

int testSmithyCard(struct gameState *post, int cP)
{
    struct gameState pre;
    memcpy(&pre, post, sizeof(struct gameState));

    int r, a;
    int flag = 0;

    r = cardEffect(smithy, 0, 0, 0, post, (post->handCount[cP] - 1), NULL);
    a = asserttrue(0, r, "Function return value was incorrect.");
    if (a == 0)
        flag = 1;


    /* post smithy card
     * handSize should be +3
     * Nothing else in gameState should be changed
    */

    int handSizeDiff = post->handCount[cP] - pre.handCount[cP];
    a = asserttrue(2, handSizeDiff, "The current player's hand is not 2 cards larger.");
    if (a == 0)
        flag = 1;

    // Check the rest of the game state to make sure it is unchanged
    for (int j = 0; j < post->numPlayers; j++)
    {
        if (j == cP)
            break;
        else
        {
            a = asserttrue(pre.handCount[j], post->handCount[j], "Another player's handCount has been modified.");
            if (a == 0)
                flag = 1;
            else 
            {
                for (int i = 0; i < pre.handCount[j]; i++)
                {
                    a = asserttrue(pre.hand[j][i], post->hand[j][i], "A card in another player's hand was modified.");
                    if (a == 0)
                        flag = 1;
                }
            }
            a = asserttrue(pre.deckCount[j], post->deckCount[j], "Another player's deckCount has been modified.");
            if (a == 0)
                flag = 1;
            else 
            {
                for (int i = 0; i < pre.deckCount[j]; i++)
                {
                    a = asserttrue(pre.deck[j][i], post->deck[j][i], "A card in another player's deck was modified.");
                    if (a == 0)
                        flag = 1;
                }
            }
            a = asserttrue(pre.discardCount[j], post->discardCount[j], "Another player's handCount has been modified.");
            if (a == 0)
                flag = 1;
            else 
            {
                for (int i = 0; i < pre.discardCount[j]; i++)
                {
                    a = asserttrue(pre.discard[j][i], post->discard[j][i], "A card in another player's discard was modified.");
                    if (a == 0)
                        flag = 1;
                }
            }
        }
    }
    
    return flag;
}

int main() {

    // perform necessary setup
    struct gameState G;
    int currentPlayer;
    int t, k;
    int didATestFail = 0;

    // seed the random number generator
    SelectStream(2);
    PutSeed(3);

    // call function in a loop with randomly generated inputs
    for (int n = 0; n < 2000; n++) {
        printf("TEST ITERATION %d\n", n+1);

        // Fill each byte of gameState with a random ASCII character
        for (int i = 0; i < sizeof(struct gameState); i++)
        {
            ((char *)&G)[i] = floor(Random() * 256);
        }

        // consider pre-conditions to ensure array indices are valid memory locations
        int numPlayers = G.numPlayers = floor(Random() * (MAX_PLAYERS + 1));
        //printf("The value of numPlayers is: %d\n", numPlayers);
        if (numPlayers == 0)
            numPlayers++;
        currentPlayer = floor(Random() * numPlayers);
        G.whoseTurn = currentPlayer;
        //printf("Value of currentPlayer is: %d\n", currentPlayer);
        G.playedCardCount = floor(Random() * MAX_HAND);
        //printf("Value of playedCardCount is: %d\n", G.playedCardCount);
        
        for (k = 0; k < numPlayers; k++) 
        {
            //printf("Value of k is: %d\n", k);
            G.deckCount[k] = floor(Random() * MAX_DECK);
            //printf("Value of player %d's deckCount is: %d\n", k, G.deckCount[k]);
            G.discardCount[k] = floor(Random() * MAX_DECK);
            //printf("Value of player %d's discardCount is: %d\n", k, G.discardCount[k]);
            G.handCount[k] = floor(Random() * MAX_HAND);
            //printf("Value of player %d's handCount is: %d\n", k, G.handCount[k]);

        }
        
        G.hand[currentPlayer][G.handCount[currentPlayer] - 1] = smithy;

        t = testSmithyCard(&G, currentPlayer);
        if (t == 1)
            didATestFail = 1;
    }
    if (didATestFail == 0) 
        printf("ALL TESTS PASSED SUCCESSFULLY\n");
    return 0;
}