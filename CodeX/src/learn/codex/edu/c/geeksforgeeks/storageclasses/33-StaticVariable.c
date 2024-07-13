#include<stdio.h>
int g;  //g = 0, global objects have static storage duration
static int gs; //gs = 0, global static objects have static storage duration
int main()
{
  static int s; //s = 0, static objects have static storage duration
  printf("Value of g = %d", g);
  printf("\nValue of gs = %d", gs);
  printf("\nValue of s = %d", s);

  getchar();
  return 0;
}
