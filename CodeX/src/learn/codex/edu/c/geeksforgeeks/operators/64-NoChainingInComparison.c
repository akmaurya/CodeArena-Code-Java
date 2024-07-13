#include <stdio.h>
int main()
{
  int a = 10, b = 20, c = 30;

  // (c > b > a) is treated as ((c > b) > a), associativity of '>' 
  // is left to right. Therefore the value becomes ((30 > 20) > 10) 
  // which becomes (1 > 20)
  if (c > b > a)  
   printf("TRUE");
  else
    printf("FALSE");
  return 0;
}
