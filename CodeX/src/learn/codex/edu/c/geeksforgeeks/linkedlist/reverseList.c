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

void reverse()
{
    struct node* current, *next, *prev;
    current=head;
    prev=NULL;
    while(current!=NULL)
    {
        next=current->next;
        current->next=prev;
        prev=current;
        current=next;
    }
    head=prev;
}

void deleteAt(int n)
{
    int i=2;
    struct node* temp=head;
    if(n==1)
    {
        head=head->next;
        free(temp);
    }
    else
    {
        while(temp!=NULL)
        {
            if(i==n)
                break;
            else
            {
                temp=temp->next;
                i++;
            }
        }
        struct node* temp1=temp->next;
        temp->next=temp1->next;
        free(temp1);
    }
}

void display()
{
    struct node* temp=head;
    printf("List is\n\t\t");
    while(temp!=NULL)
    {
        printf("%d  ",temp->data);
        temp=temp->next;
    }
}

int main(void)
{
    int i,n,x;
    printf("Enter the list size\n");
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        printf("\nEnter element\n");
        scanf("%d",&x);
        insert(x);
        display();

    }
    display();
    deleteAt(3);
    display();
}
