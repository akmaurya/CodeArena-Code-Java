#include<stdio.h>
void fun(int arr[]) 
{
  int i;  
 
  /* sizeof should not be used here to get number
    of elements in array*/
  int arr_size = sizeof(arr); /* incorrect use of siseof*/
  printf("%d\n",arr_size);
  for (i = 0; i < arr_size; i++)
  { 
    arr[i] = i;  /*executed only once */
  }
}
 
int main()
{
  int i; 
  int arr[9];
  //fun(arr);
   
  /* use of sizeof is fine here*/
  for(i = 0; i < sizeof(arr)/sizeof(arr[0]); i++)
    printf(" %d " ,arr[i]);
 
  getchar(); 
  return 0;
}
