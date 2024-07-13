// filename: file2.c
// When this file is linked with file1.c, functions of this file can access a
extern int a;
int myfun()
{
   a = 2;
}
