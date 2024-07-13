#include<stdio.h>
inline int square(int x) { return x*x; }
int main()
{
  int x = 36/square(6);
  printf("%d", x);
  return 0;
}
// Output: 1
