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
    head->next=temp;
}

void print(struct node* p)
{
    if(p==NULL)
        return;
    printf("%d  ",p->data);
    print(p->next);
}

int reverse(struct node* p)
{
    if(p==NULL)
    {
        printf("\n");
        return;
    }

    reverse(p->next);
    printf("%d  ",p->data);
    return;
}

int main(void)
{
    int i,n,x;
    printf("Enter no. of elements\n");
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        printf("Enter element\n");
        scanf("%d",&x);
        insert(x);


    }
    print(head);
    printf("\n");
    reverse(head);
}
