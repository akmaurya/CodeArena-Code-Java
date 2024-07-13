#include<stdio.h>
#define PRINT(x) (#x)
int main()
{
  printf("%s",PRINT(x));
  return 0;
}
