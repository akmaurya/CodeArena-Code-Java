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

void reverseList(struct node* p)
{
    if(p->next==NULL)
    {
        head=p;
        return;
    }

        reverseList(p->next);
        p->next->next=p;
        p->next=NULL;

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
                reverseList(head);
                break;
            case 3:
                display(head);
                break;
            default:
                if(ch!=4)
                    printf("Wrong Choice\n");
        }
    }while(ch!=4);
}
