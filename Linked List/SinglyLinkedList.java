public class SinglyLinkedList {
    public static class Node{
        int data;
        Node link;

        public Node(int data){
            this.data=data;
            this.link=null;
        }
    }

    public static Node first;

    public void addFirst(int data){
        Node newNode=new Node(data);
        if(first==null){
            first=newNode;
            return;
        }
        newNode.link=first;
        first=newNode;
    }
    public void display(){
        Node cur=first;
        if(cur==null){
            System.out.print("Linked List is Empty...");
            return;
        }
        System.out.print("[");
        while(cur!=null){
            System.out.print(cur.data+",");
            cur=cur.link;
        }
        System.out.print("\b]");

    }

    public boolean isEmpty(){
        if(first==null){
            return true;
        }
        else{
            return false;
        }
    }

    public int getSize(){
        Node cur=first;
        int count=0;
        if(isEmpty()){
            return count;
        }
        while(cur!=null){
            count++;
            cur=cur.link;
        }
        return count;
    }
    public void insert(int data,int index){
        Node newNode=new Node(data);
        if(isEmpty() && index==0){
            first=newNode;
        }
        else if(index==0){
            newNode.link=first;
            first=newNode;
        }
        else{
            int i=1;
            Node pre=first;
            while(i<index){
                pre=pre.link;
                i++;
            }
            newNode.link=pre.link;
            pre.link=newNode;
        }

    }
    public void del(int index){
        if(getSize()==0){
            System.out.println("Linked List is empty...");
            return;
        }
        if(index<0 || index>getSize()){
            System.out.println("Invalid index...");
            return;
        }
        if(index==0){
            int x=first.data;
            first=first.link;
        }
    }


    public static void main(String args[]){
        SinglyLinkedList ll=new SinglyLinkedList();
        ll.addFirst(20);
        ll.addFirst(30);
        ll.addFirst(70);
        ll.addFirst(50);
        ll.insert(10,0);
        ll.insert(40,2);
        ll.display();
        System.out.println("\nSize : "+ll.getSize());
    }

}
