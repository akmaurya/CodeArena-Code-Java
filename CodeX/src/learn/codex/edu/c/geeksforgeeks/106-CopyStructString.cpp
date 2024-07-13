# include <iostream>
# include <string.h>
 
using namespace std;
 
struct test
{
  char *str;
};
 
int main()
{
  struct test st1, st2;
 
  st1.str = new char[20];
  strcpy(st1.str, "GeeksforGeeks");
 
  st2 = st1;
 
  st1.str[0] = 'X';
  st1.str[1] = 'Y';
 
  /* Since copy was shallow, both strings are same */
  cout << "st1's str = " << st1.str << endl;
  cout << "st2's str = " << st2.str << endl;
 
  return 0;
}
/*
Output:
st1’s str = XYeksforGeeks
st2’s str = XYeksforGeeks
*/
