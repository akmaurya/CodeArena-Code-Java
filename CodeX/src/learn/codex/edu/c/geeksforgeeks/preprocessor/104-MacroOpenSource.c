#ifndef __cplusplus
 
typedef enum BoolenTag
{
   false,
   true
} bool;
 
#endif
 
#define CRASH() do { \
      ((void(*)())0)(); \
   } while(false)
 
int main()
{
   CRASH();
   return 0;
}
