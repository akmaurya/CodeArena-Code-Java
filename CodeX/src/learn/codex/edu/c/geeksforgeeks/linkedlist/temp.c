#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node* next;
};

struct node* head;

void push(int x)
{
    struct node* temp=(struct node*)malloc(sizeof(struct node));
    temp->data=x;
    temp->next=head;
    head=temp;
}

int pop(struct node **s)
{
    //int x=head->data;
    struct node* temp=*s;
    int t;
    if(temp!=NULL)
    {
        t=temp->data;
        *s=s->next;
        free(temp);
        return t;
    }

}

int main(void)
{
    int i,x,ch,t,n,temp=NULL;
    do
    {
        printf("1-Push\n2-Pop\n3-Display\n4-Exit\n\n");
        ch=getch()-48;
        switch(ch)
        {
        case 1:
            printf("Enter element\n");
            scanf("%d",&x);
            push(x);
            break;
        case 2:
            n=pop(&temp);
            break;
        case 3:
            //display();
            break;
        default:
            if(ch!=4)
            printf("Invalid Choice\n");

        }
    }while(ch!=4);

}
