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
    struct node *current, *next, *prev=NULL;
    current=head;
    while(current!=NULL)
    {
        next=current->next;
        current->next=prev;
        prev=current;
        current=next;
    }
    head=prev;
}

void display()
{
    struct node* temp=head;
    if(temp==NULL)
        printf("List is empty\n");
    else
    {
        while(temp!=NULL)
        {
            printf("%d  ",temp->data);
            temp=temp->next;
        }
    }
}

int main(void)
{
    int i,ch,x;

    do
    {
        printf("\n1-Insert\n2-Reverse\n3-Display\n4-Exit\n");
        ch=getch()-48;
        switch(ch)
        {
            case 1:
                printf("Enter element\n");
                scanf("%d",&x);
                insert(x);
                break;
            case 2:
                reverse();
                break;
            case 3:
                display();
                break;
            default:
                if(ch!=4)
                    printf("Wrong Choice\n");
        }
    }while(ch!=4);
}
