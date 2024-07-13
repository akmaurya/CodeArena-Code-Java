
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

void deleteAt(int n)
{
    int i;
    struct node* temp=head;
    if(n==1)
    {
        head=head->next;
        free(temp);
    }
    else
    {
        for(i=0;i<n-2;i++)
            temp=temp->next;
            struct node* temp2=temp->next;
            temp->next=temp2->next;
            free(temp2);
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
                printf("Enter place\n");
                scanf("%d",&n);
                deleteAt(n);
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
