/** cardtest1.c
 * Author: Christopher Capps
 * Date: April 22, 2018
 * Description: Unit tests for the Smithy Card
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

    printf("TESTING Smithy Card ...\n\n");

    //gameState
    struct gameState* G = newGame();
    int k[10] = {adventurer, gardens, embargo, village, minion, mine, cutpurse,
           sea_hag, tribute, smithy};
    initializeGame(4, k, 10, G);

    // simulate drawing the smithy card
    G->hand[G->whoseTurn][G->handCount[G->whoseTurn]] = 13;
    G->handCount[G->whoseTurn]++;

    // capture pre values
    int preSmithyHandSize[4] = {0,0,0,0};
    preSmithyHandSize[G->whoseTurn] = G->handCount[G->whoseTurn];
    int preSmithyDeckSize[4] = {0,0,0,0}; 
    preSmithyDeckSize[G->whoseTurn] = G->deckCount[G->whoseTurn];
    int preSmithyPlayedSize = G->playedCardCount;

    for (int i = 0; i < 4; i++)
    {
        if (i != G->whoseTurn)
        {
            // capture pre values
            preSmithyHandSize[i] = G->handCount[i];
            preSmithyDeckSize[i] = G->deckCount[i];
        }
    }

    // call the smithy
    smithyCard(G, &G->handCount[G->whoseTurn], &G->whoseTurn);

    // capture the post values
    int postSmithyHandSize[4];
    postSmithyHandSize[G->whoseTurn] = G->handCount[G->whoseTurn];
    int postSmithyDeckSize[4];
    postSmithyDeckSize[G->whoseTurn] = G->deckCount[G->whoseTurn];
    int postSmithyPlayedSize = G->playedCardCount;

    printf("TESTING that hand size has increased by 3. ");
    if (!asserttrue(preSmithyHandSize[G->whoseTurn] + 2 == postSmithyHandSize[G->whoseTurn]))
    {
        printf("Pre Smithy card hand Size was %d.\n", preSmithyHandSize[G->whoseTurn]);
        printf("Post Smithy card hand size is %d.\n", postSmithyHandSize[G->whoseTurn]);
    }

    printf("TESTING that smithy card was played. ");
    if (!asserttrue(preSmithyPlayedSize + 1 == postSmithyPlayedSize))
    {
        printf("Pre Smithy played card size was %d.\n", preSmithyPlayedSize);
        printf("Post Smithy played card size is %d.\n", postSmithyPlayedSize);
    }

    printf("TESTING that smithy cards were drawn from current player's pile. ");
    if(!asserttrue(preSmithyDeckSize[G->whoseTurn] - 3 == postSmithyDeckSize[G->whoseTurn]))
    {
        printf("Pre Smithy deck size was %d.\n", preSmithyDeckSize[G->whoseTurn]);
        printf("Post Smithy deck size is %d.\n", postSmithyDeckSize[G->whoseTurn]);
    }

    printf("TESTING that smithy card DID NOT change other player's states. ");

    for (int i = 0; i < 4; i++)
    {
        if (i != G->whoseTurn)
        {
            // capture the post values
            postSmithyHandSize[i] = G->handCount[i];
            postSmithyDeckSize[i] = G->deckCount[i];

            printf("TESTING that player%d's hand size has NOT increased. ", i);
            if (!asserttrue(preSmithyHandSize[i] == postSmithyHandSize[i]))
            {
                printf("Pre Smithy card hand Size was %d.\n", preSmithyHandSize[i]);
                printf("Post Smithy card hand size is %d.\n", postSmithyHandSize[i]);
            }

            printf("TESTING that smithy cards were NOT drawn from player%d's pile. ", i);
            if (!asserttrue(preSmithyDeckSize[i] == postSmithyDeckSize[i]))
            {
                printf("Pre Smithy deck size was %d.\n", preSmithyDeckSize[i]);
                printf("Post Smithy deck size is %d.\n", postSmithyDeckSize[i]);
            }
        }
    }
}