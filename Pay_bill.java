import java.util.Scanner;

public class Pay_bill {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Price of Pencil : ");
        float pcl=sc.nextFloat();
        System.out.print("Enter Price of Pen : ");
        float pen=sc.nextFloat();
        System.out.print("Enter Price of Eraser : ");
        float er=sc.nextFloat();
        float tAmt=pcl+pen+er;
        //after 18% GST tAmt will be
        tAmt=tAmt*118/100;
        System.out.println("Total Amount (+18% GST included) : "+tAmt);
        int $=24;
    }
}
