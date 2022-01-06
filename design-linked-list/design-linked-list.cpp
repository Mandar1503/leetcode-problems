struct Node{
    int val;
    Node* next;
    // Node(int val)
    // {
    //     this->val = val;
    //     next = NULL;
    // }
    Node(int x): val(x), next(NULL){}
};

class MyLinkedList {
public:
    int size;
    Node *head;
    
    MyLinkedList() 
    {
        size = 0;
        head = NULL;
    }
    
    
    int get(int index) 
    {
        
        if(index < 0 || index>=size)
            return -1;
        
        Node* curr = head;
        while(index>0)
        {
            curr=curr->next;
            index--;
        }
        return curr->val;
    }
    
    
    void addAtHead(int val) 
    {
        Node* newnode = new Node(val);
        if(head==NULL)
        {
            head = newnode;
        }
        else
        {
            newnode->next = head;
            head=newnode;
        }
        size++;
    }
    
    void addAtTail(int val) 
    {    
        Node* newnode = new Node(val);
        
        if(head==NULL)
        {
            head = newnode;
        }
        else
        {
            Node* curr = head;
            while(curr->next!=NULL)
                curr=curr->next;
            curr->next = newnode;
        }
        size++;
    }
    
    void addAtIndex(int index, int val) 
    {
        if(index<0 || index>size)
            return;
        
        if(index==0)
            addAtHead(val);
        
        else if(index==size)
            addAtTail(val);
        
        else
        {
            Node* newnode = new Node(val);
            Node* curr = head;
            while(index>1)
            {
                curr=curr->next;
                index--;
            }
            newnode->next = curr->next;
            curr->next = newnode;
            size++;
        }
    }
    
    void deleteAtIndex(int index) {
        
        if(index<0 || index>=size)
            return;
        
        if(index==0)
        {
            head=head->next;
            size--;
            return;
        }
        
        Node* curr = head;
        while(index>1)
        {
            curr=curr->next;
            index--;
        }
        curr->next=curr->next->next;
        size--;
    }
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */