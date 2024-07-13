#include<iostream>
#include<stack>
#include<stdio.h>
#include<string.h>
using namespace std;

bool isBalanced(char *ch, int len)
{
    int i;
    stack<char> s;

    for(i=0;i<len;i++)
    {
        if(ch[i]=='(' || ch[i]=='{' || ch[i]=='[')
        s.push(ch[i]);
        else if(ch[i]==')'&&'('==s.top())
        s.pop();
        else if(ch[i]=='}'&&'{'==s.top())
        s.pop();
        else if(ch[i]==']'&&'['==s.top())
        s.pop();
    }
    if(s.empty())
    return (true);
    else
    return (false);

}

int main(void)
{
    char ch[40];
    int len;
    bool res;
    printf("Enter any expression\n");
    gets(ch);
    len=strlen(ch);
    res=isBalanced(ch,len);
    if(res==1)
    printf("\nExpression has balanced parenthesis");
    else
        printf("\nExpression has not balanced parenthesis");
}
