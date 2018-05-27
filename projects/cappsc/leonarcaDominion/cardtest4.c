/** cardtest4.c
 * Author: Christopher Capps
 * Date: April 22, 2018
 * Description: Unit tests for the Village Card
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

    printf("\n\nTESTING Village Card ...\n\n");

    //gameState
    struct gameState* G = newGame();
    int k[10] = {adventurer, gardens, embargo, village, minion, mine, cutpurse,
           sea_hag, tribute, smithy};
    initializeGame(4, k, 10, G);

    // simulate drawing the Village room card
    G->hand[G->whoseTurn][G->handCount[G->whoseTurn]] = 14;
    G->handCount[G->whoseTurn]++;

    // capture pre values
    int preVillageHandSize[4];
    preVillageHandSize[G->whoseTurn] = G->handCount[G->whoseTurn];
    int preVillageDeckSize[4]; 
    preVillageDeckSize[G->whoseTurn] = G->deckCount[G->whoseTurn];
    int preVillagePlayedSize = G->playedCardCount;
    int preVillageActions = G->numActions;

    for (int i = 0; i < 4; i++)
    {
        if (i != G->whoseTurn)
        {
            // capture pre values
            preVillageHandSize[i] = G->handCount[i];
            preVillageDeckSize[i] = G->deckCount[i];
        }
    }

    // call the Village room
    villageCard(G, &G->handCount[G->whoseTurn], &G->whoseTurn);

    // capture the post values
    int postVillageHandSize[4];
    postVillageHandSize[G->whoseTurn] = G->handCount[G->whoseTurn];
    int postVillageDeckSize[4];
    postVillageDeckSize[G->whoseTurn] = G->deckCount[G->whoseTurn];
    int postVillagePlayedSize = G->playedCardCount;
    int postVillageActions = G->numActions;

    printf("TESTING that hand size has increased by 1. ");
    if (!asserttrue(preVillageHandSize[G->whoseTurn] == postVillageHandSize[G->whoseTurn]))
    {
        printf("Pre Village card hand Size was %d.\n", preVillageHandSize[G->whoseTurn]);
        printf("Post Village card hand size is %d.\n", postVillageHandSize[G->whoseTurn]);
    }

    printf("TESTING that Village Room card was played. ");
    if (!asserttrue(preVillagePlayedSize + 1 == postVillagePlayedSize))
    {
        printf("Pre Village played card size was %d.\n", preVillagePlayedSize);
        printf("Post Village played card size is %d.\n", postVillagePlayedSize);
    }

    printf("TESTING that 1 card was drawn from current player's pile. ");
    if(!asserttrue(preVillageDeckSize[G->whoseTurn] - 1 == postVillageDeckSize[G->whoseTurn]))
    {
        printf("Pre Village deck size was %d.\n", preVillageDeckSize[G->whoseTurn]);
        printf("Post Village deck size is %d.\n", postVillageDeckSize[G->whoseTurn]);
    }

    printf("TESTING that Village card added two actions for the current player. ");
    if (!asserttrue(preVillageActions + 2 == postVillageActions))
    {
        printf("Pre Village number of actions was %d.\n", preVillageActions);
        printf("Post Village number of actions is %d.\n", postVillageActions);
    }

    printf("TESTING that Village Room DID NOT change other player's states. ");

    for (int i = 0; i < 4; i++)
    {
        if (i != G->whoseTurn)
        {
            // capture the post values
            postVillageHandSize[i] = G->handCount[i];
            postVillageDeckSize[i] = G->deckCount[i];

            printf("TESTING that player%d's hand size was not changed. ", i);
            if (!asserttrue(preVillageHandSize[i] == postVillageHandSize[i]))
            {
                printf("Pre Village card hand Size was %d.\n", preVillageHandSize[i]);
                printf("Post Village card hand size is %d.\n", postVillageHandSize[i]);
            }

            printf("TESTING that the card were NOT drawn from player%d's pile. ", i);
            if (!asserttrue(preVillageDeckSize[i] == postVillageDeckSize[i]))
            {
                printf("Pre Village deck size was %d.\n", preVillageDeckSize[i]);
                printf("Post Village deck size is %d.\n", postVillageDeckSize[i]);
            }
        }
    }
}