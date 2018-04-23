/** unittest4.c
 * Author: Christopher Capps
 * Date: April 22, 2018
 * Description: Unit tests for the function in dominion.c whoseTurn
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

    printf("\n\nTESTING whoseTurn ...\n\n");

    //gameState
    struct gameState* G = newGame();
    int k[10] = {adventurer, gardens, embargo, village, minion, mine, cutpurse,
           sea_hag, tribute, smithy};
    initializeGame(4, k, 10, G);

    printf("Testing that it is player 0s turn. ");
    asserttrue(whoseTurn(G) == 0);

    G->whoseTurn = 1;
    printf("Testing that it is player 1s turn. ");
    asserttrue(whoseTurn(G) == 1);

    G->whoseTurn = 2;
    printf("Testing that it is player 2s turn. ");
    asserttrue(whoseTurn(G) == 2);

    G->whoseTurn = 3;
    printf("Testing that it is player 3s turn. ");
    asserttrue(whoseTurn(G) == 3);
}