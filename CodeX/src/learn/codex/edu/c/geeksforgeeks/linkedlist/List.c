#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node* next;
};

struct node* head;

void insert(int x)
{
    struct node* temp=(struct node*)malloc(sizeof(struct node));
    temp->data=x;
    temp->next=head;
    head=temp;
}

void print()
{
    struct node* temp=head;
    printf("Elements are\n");
    while(temp!=NULL)
    {
        printf("%d  ",temp->data);
        temp=temp->next;
    }
    printf("\n");
}

int main(void)
{
    int i,n,x;
    printf("Enter the no. of elements\n");
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        printf("Enter the value\n");
        scanf("%d",&x);
        insert(x);
        print();
    }
}
