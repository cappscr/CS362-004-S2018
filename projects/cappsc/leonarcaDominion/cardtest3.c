/** cardtest3.c
 * Author: Christopher Capps
 * Date: April 22, 2018
 * Description: Unit tests for the Council Room Card
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

int main() {

    printf("\n\nTESTING Council Room Card ...\n\n");

    //gameState
    struct gameState* G = newGame();
    int k[10] = {adventurer, gardens, embargo, village, minion, mine, cutpurse,
           sea_hag, tribute, council_room};
    initializeGame(4, k, 10, G);

    // simulate drawing the council room card
    G->hand[G->whoseTurn][G->handCount[G->whoseTurn]] = 8;
    G->handCount[G->whoseTurn]++;

    // capture pre values
    int preCouncilHandSize[4];
    preCouncilHandSize[G->whoseTurn] = G->handCount[G->whoseTurn];
    int preCouncilDeckSize[4]; 
    preCouncilDeckSize[G->whoseTurn] = G->deckCount[G->whoseTurn];
    int preCouncilPlayedSize = G->playedCardCount;
    int preCouncilBuys = G->numBuys;

    for (int i = 0; i < 4; i++)
    {
        if (i != G->whoseTurn)
        {
            // capture pre values
            preCouncilHandSize[i] = G->handCount[i];
            preCouncilDeckSize[i] = G->deckCount[i];
        }
    }

    // call the council room
    cardEffect(8, 0, 0, 0, G, G->handCount[G->whoseTurn], NULL);

    // capture the post values
    int postCouncilHandSize[4];
    postCouncilHandSize[G->whoseTurn] = G->handCount[G->whoseTurn];
    int postCouncilDeckSize[4];
    postCouncilDeckSize[G->whoseTurn] = G->deckCount[G->whoseTurn];
    int postCouncilPlayedSize = G->playedCardCount;
    int postCouncilBuys = G->numBuys;

    printf("TESTING that hand size has increased by 4. ");
    if (!asserttrue(preCouncilHandSize[G->whoseTurn] + 3 == postCouncilHandSize[G->whoseTurn]))
    {
        printf("Pre Council card hand Size was %d.\n", preCouncilHandSize[G->whoseTurn]);
        printf("Post Council card hand size is %d.\n", postCouncilHandSize[G->whoseTurn]);
    }

    printf("TESTING that Council Room card was played. ");
    if (!asserttrue(preCouncilPlayedSize + 1 == postCouncilPlayedSize))
    {
        printf("Pre Council played card size was %d.\n", preCouncilPlayedSize);
        printf("Post Council played card size is %d.\n", postCouncilPlayedSize);
    }

    printf("TESTING that 4 cards were drawn from current player's pile. ");
    if(!asserttrue(preCouncilDeckSize[G->whoseTurn] - 4 == postCouncilDeckSize[G->whoseTurn]))
    {
        printf("Pre Council deck size was %d.\n", preCouncilDeckSize[G->whoseTurn]);
        printf("Post Council deck size is %d.\n", postCouncilDeckSize[G->whoseTurn]);
    }

    printf("TESTING that Council Room card added a buy for the current player. ");
    if (!asserttrue(preCouncilBuys + 1 == postCouncilBuys))
    {
        printf("Pre Council played card size was %d.\n", preCouncilBuys);
        printf("Post Council played card size is %d.\n", postCouncilBuys);
    }

    printf("TESTING that Council Room card appropriately changed other player's states. ");

    for (int i = 0; i < 4; i++)
    {
        if (i != G->whoseTurn)
        {
            // capture the post values
            postCouncilHandSize[i] = G->handCount[i];
            postCouncilDeckSize[i] = G->deckCount[i];

            printf("TESTING that player%d's hand size was increased by 1. ", i);
            if (!asserttrue(preCouncilHandSize[i] + 1 == postCouncilHandSize[i]))
            {
                printf("Pre Council card hand Size was %d.\n", preCouncilHandSize[i]);
                printf("Post Council card hand size is %d.\n", postCouncilHandSize[i]);
            }

            printf("TESTING that the card was drawn from player%d's pile. ", i);
            if (!asserttrue(preCouncilDeckSize[i] - 1 == postCouncilDeckSize[i]))
            {
                printf("Pre Council deck size was %d.\n", preCouncilDeckSize[i]);
                printf("Post Council deck size is %d.\n", postCouncilDeckSize[i]);
            }
        }
    }
}