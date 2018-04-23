/** unittest3.c
 * Author: Christopher Capps
 * Date: April 22, 2018
 * Description: Unit tests for the function in dominion.c fullDeckCount
 * */

#include "dominion.h"
#include "dominion_helpers.h"
#include "rngs.h"
#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int asserttrue(int expression)
{
    if (expression == 0)
    {
        printf("TEST FAILED\n");
        return 0;
    }
    else
    {
        printf("TEST SUCCESSFULLY COMPLETED\n");
        return 1;
    }
}

int generateRandCard()
{
    return floor(Random() * 28);
}

int main() 
{
    printf("\n\nTESTING fullDeckCount ...\n\n");
    
    SelectStream(2);
    PutSeed(3);

    //player
    int playerNum = 1;
    //gameState
    struct gameState* G = newGame();
    int k[10] = {adventurer, gardens, embargo, village, minion, mine, cutpurse,
           sea_hag, tribute, smithy};
    initializeGame(4, k, 10, G);
    int maxDeck = 500;
    int maxHand = 500;

    // seed hand, deck, and discard
    int cardCounts[27];     // each entry is the count of the respective card
    int i;
    for (i = 0; i < 28; i++)
    {
        cardCounts[i] = 0;
    }

    printf("Testing that after initialization each deck has 3 estate cards. ");
    asserttrue(fullDeckCount(playerNum, 1, G) == 3);

    printf("Testing that after initialization each deck has 7 copper cards. ");
    asserttrue(fullDeckCount(playerNum, 4, G) == 7);
    

    printf("Testing that after initialization the desk has 0 of all other cards. ");
    for (int j = 0; j < 28; j++)
    {
        if (j != 1 && j != 4)
            asserttrue(fullDeckCount(playerNum, j, G) == 0);
    }

    cardCounts[1] = 3;
    cardCounts[4] = 7;

    printf("Setting up random tests.\n");
    // Fill the deck
    for (i=10; i < maxDeck; i++)
    {
        int card = generateRandCard();
        G->deck[playerNum][i] = card;
        cardCounts[card]++;
        G->deckCount[playerNum]++;
    }

    // Fill the hand
    for (i=0; i < maxHand; i++)
    {
        int card = generateRandCard();
        G->hand[playerNum][i] = card;
        cardCounts[card]++;
        G->handCount[playerNum]++;
    }

    // Put 10 cards in discard
    for (i=0; i < 10; i++)
    {
        int card = generateRandCard();
        G->discard[playerNum][i] = card;
        cardCounts[card]++;
        G->discardCount[playerNum]++;
    }

    printf("Checking the results of random tests.\n");
    for (i=0; i < 28; i++)
    {
        printf("Card %d contains the correct number. ", i);
        if (asserttrue(fullDeckCount(playerNum, i, G) == cardCounts[i]) == 0) 
        {
            printf("fullDeckCount[i] is %d\n", fullDeckCount(playerNum, i, G));
            printf("CardCount[i] is %d\n", cardCounts[i]);
        }
    }
}