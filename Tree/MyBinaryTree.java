import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;

        }
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root==null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root==null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node cur=q.remove();
            if(cur==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(cur.data+" ");
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
        }
    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }

    public static void main(String[] args){

        Node root=new Node(5);
        root.left=new Node(4);
        root.right=new Node(6);
        root.left.left=new Node(3);
        root.left.right=new Node(2);
        root.right.left=new Node(7);
        root.right.right=new Node(8);
        root.left.right.left=new Node(1);

/*
                            5
                         /     \
                       4         6
                     /  \       /  \
                   3      2    7    8
                         /
                        1
*/
        System.out.print("PreOrder Traversal : ");
        preOrder(root);
        System.out.println();
        System.out.print("InOrder Traversal : ");
        inOrder(root);
        System.out.println();
        System.out.print("PostOrder Traversal : ");
        postOrder(root);
        System.out.println();
        System.out.println("Level Order Traversal : ");
        levelOrder(root);

        System.out.println();
        System.out.println("Height of BT : "+height(root));


    }
}
