public class NegativePositive {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int data){
            this.val=data;
            this.next=null;
        }
    }

    public ListNode head=null;
    public int size=0;
    public void addFirst(int data){
        ListNode newNode=new ListNode(data);
        size++;
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void show(){
        ListNode cur=head;
        System.out.print("[");
        while(cur!=null){
            System.out.print(cur.val+",");
            cur=cur.next;
        }
        System.out.print("\b]\n");
    }
    public void negPos(){
        ListNode negEnd=null,prev=null;
        ListNode cur=head;
        if(head.val<0){
            prev=cur;
            negEnd=cur;
            cur=cur.next;
        }
        while(cur!=null){
            if(cur.val<0){
                if(negEnd==null){
                    prev.next=cur.next;
                    cur.next=head;

                    negEnd=cur;
                    head=cur;
                    cur=prev;

                }
                else {
                    prev.next=cur.next;
                    cur.next=negEnd.next;
                    negEnd.next=cur;

                    negEnd=cur;
                    cur=prev;
                }
            }
            prev=cur;
            cur=cur.next;
        }
    }
    public static void main(String args[]){
        NegativePositive list=new NegativePositive();
        list.addFirst(-10);
        list.addFirst(20);
        list.addFirst(-30);
        list.addFirst(40);
        list.addFirst(-50);
        System.out.print("Before : ");
        list.show();

        list.negPos();
        System.out.print("After : ");
        list.show();
    }

}
