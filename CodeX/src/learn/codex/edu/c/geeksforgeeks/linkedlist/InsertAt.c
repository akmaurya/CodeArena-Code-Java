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

void display()
{
    struct node* temp=head;
    if(temp==NULL)
        printf("List is Empty");
    else
    {
        while(temp!=NULL)
        {
            printf("%d  ",temp->data);
            temp=temp->next;
        }
    }
}

void insertAt(int n,int x)
{
    int i;
    struct node* temp1=(struct node*)malloc(sizeof(struct node));
    temp1->data=x;
    if(n==1)
    {
        temp1->next=head;
        head=temp1;
    }
    else
    {
        struct node* temp2=head;
        for(i=0;i<n-2;i++)
        temp2=temp2->next;
        temp1->next=temp2->next;
        temp2->next=temp1;
    }
}


int main(void)
{
    int i,ch,x,n;

    do
    {
        printf("\n1-Insert\n2-Insert At\n3-Display\n4-Exit\n");
        ch=getch()-48;
        switch(ch)
        {
            case 1:
                printf("Enter element\n");
                scanf("%d",&x);
                insert(x);
                break;
            case 2:
                printf("Enter element\n");
                scanf("%d",&x);
                printf("Enter place\n");
                scanf("%d",&n);
                insertAt(n,x);
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
