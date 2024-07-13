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

void displayReverse(struct node* p)
{
    if(p==NULL)
        return;
    else
    {
        displayReverse(p->next);
        printf("%d  ",p->data);
    }
}


void display(struct node* p)
{
    if(p==NULL)
        return;
    else
    {
        printf("%d  ",p->data);
        display(p->next);
    }
}

void mid1(struct node* p)
{
    struct node* slow=p;
    struct node* fast=p;
    if(p!=NULL)
    {
        while(fast!=NULL&&fast->next!=NULL)
        {
            fast=fast->next->next;
            slow=slow->next;
        }
        printf("Mid1 = %d\n",slow->data);
    }
}

void mid2(struct node* p)
{
    int count=0;
    struct node* mid=p;
    while(p!=NULL)
    {
        if(count&1)
            mid=mid->next;
        count++;
        p=p->next;
    }
    if(mid!=NULL)
        printf("Mid2 = %d\n",mid->data);
}

int main(void)
{
    int i,ch,x;

    do
    {
        printf("\n1-Insert\n2-Reverse\n3-Display\n4-Exit\n5-Mid\n");
        ch=getch()-48;
        switch(ch)
        {
            case 1:
                printf("Enter element\n");
                scanf("%d",&x);
                insert(x);
                break;
            case 2:
                displayReverse(head);
                break;
            case 3:
                display(head);
                break;
            case 5:
                mid1(head);
                mid2(head);
                break;
            default:
                if(ch!=4)
                    printf("Wrong Choice\n");
        }
    }while(ch!=4);
}
