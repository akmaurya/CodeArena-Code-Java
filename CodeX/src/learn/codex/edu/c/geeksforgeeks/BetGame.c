#include<stdio.h>
#include<stdlib.h>
int cash =100;
void play(int bet)
{
   char *c=(char*)malloc(3*sizeof(char));
   c[0]='J';c[1]='Q';c[2]='K';
   printf("Suffing\n");
   srand(time(NULL));
   int i;
   for(i=0;i<5;i++)
   {
      int x=rand()%3;
      int y=rand()%3;
      char temp=c[x];
      c[x]=c[y];
      c[y]=temp;
   }
   int playersGuess;
   printf("What is the Position of Queen-1,  2,  3 ?");
   scanf("%d",&playersGuess);
   if(c[playersGuess-1]=='Q')
   {
      cash=cash+(3*bet);
      printf("You WIN! Result= \"%c  %c  %c\" Total Cash= %d\n",c[0],c[1],c[2],cash);
   }
   else
   {
      cash=cash-bet;
      printf("You LOOSE! Result=%c  %c  %c Total Cash= %d\n",c[0],c[1],c[2],cash);
   }
}
int main(void)
{
   int bet;
   printf("Welcome to the Virtual Casino\n");
   printf("Total cash= $%d\n",cash);
   while(cash>0)
   {
      printf("What is your bet? $");
      scanf("%d",&bet);
      if(bet==0||bet>cash)
      break;
      play(bet);
   }
}

