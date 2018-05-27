/** cardtest2.c
 * Author: Christopher Capps
 * Date: April 22, 2018
 * Description: Unit tests for the Adventurer Card
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

    printf("\n\nTESTING Adventurer Card ...\n\n");

    //gameState
    struct gameState* G = newGame();
    int k[10] = {adventurer, gardens, embargo, village, minion, mine, cutpurse,
           sea_hag, tribute, smithy};
    initializeGame(4, k, 10, G);

    // simulate drawing the adventurer card
    G->hand[G->whoseTurn][G->handCount[G->whoseTurn]] = 7;
    G->handCount[G->whoseTurn]++;

    // capture pre values
    int preAdvHandSize[4] = {0,0,0,0};
    preAdvHandSize[G->whoseTurn] = G->handCount[G->whoseTurn];
    int preAdvDeckSize[4] = {0,0,0,0}; 
    preAdvDeckSize[G->whoseTurn] = G->deckCount[G->whoseTurn];
    int preAdvPlayedSize = G->playedCardCount;

    for (int i = 0; i < 4; i++)
    {
        if (i != G->whoseTurn)
        {
            // capture pre values
            preAdvHandSize[i] = G->handCount[i];
            preAdvDeckSize[i] = G->deckCount[i];
        }
    }

    // call the adventurer
    int treasure = 0;
    int temphand[500];
    int z = 0;
    adventurerImplementation(treasure, G, G->whoseTurn, temphand, z);

    // capture the post values
    int postAdvHandSize[4];
    postAdvHandSize[G->whoseTurn] = G->handCount[G->whoseTurn];
    int postAdvDeckSize[4];
    postAdvDeckSize[G->whoseTurn] = G->deckCount[G->whoseTurn];
    int postAdvPlayedSize = G->playedCardCount;

    printf("TESTING that hand size has increased by 2. ");
    if (!asserttrue(preAdvHandSize[G->whoseTurn] + 1 == postAdvHandSize[G->whoseTurn]))
    {
        printf("Pre Adv card hand Size was %d.\n", preAdvHandSize[G->whoseTurn]);
        printf("Post Adv card hand size is %d.\n", postAdvHandSize[G->whoseTurn]);
    }

    printf("TESTING that Adventurer card was played. ");
    if (!asserttrue(preAdvPlayedSize + 1 == postAdvPlayedSize))
    {
        printf("Pre Adv played card size was %d.\n", preAdvPlayedSize);
        printf("Post Adv played card size is %d.\n", postAdvPlayedSize);
    }

    printf("TESTING that cards were drawn from current player's pile. ");
    if(!asserttrue(preAdvDeckSize[G->whoseTurn] != postAdvDeckSize[G->whoseTurn]))
    {
        printf("Pre Adv deck size was %d.\n", preAdvDeckSize[G->whoseTurn]);
        printf("Post Adv deck size is %d.\n", postAdvDeckSize[G->whoseTurn]);
    }

    printf("TESTING that Adventurer card DID NOT change other player's states. ");

    for (int i = 0; i < 4; i++)
    {
        if (i != G->whoseTurn)
        {
            // capture the post values
            postAdvHandSize[i] = G->handCount[i];
            postAdvDeckSize[i] = G->deckCount[i];

            printf("TESTING that player%d's hand size has NOT increased. ", i);
            if (!asserttrue(preAdvHandSize[i] == postAdvHandSize[i]))
            {
                printf("Pre Adv card hand Size was %d.\n", preAdvHandSize[i]);
                printf("Post Adv card hand size is %d.\n", postAdvHandSize[i]);
            }

            printf("TESTING that Adv cards were NOT drawn from player%d's pile. ", i);
            if (!asserttrue(preAdvDeckSize[i] == postAdvDeckSize[i]))
            {
                printf("Pre Adv deck size was %d.\n", preAdvDeckSize[i]);
                printf("Post Adv deck size is %d.\n", postAdvDeckSize[i]);
            }
        }
    }
}