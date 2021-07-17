package datastructure.treeset;

import java.util.Scanner;

/** Class TreeSetTest **/

public class TreeSetTest

{

    public static void main(String[] args)

    {                 

        Scanner scan = new Scanner(System.in);

 

        /** Creating object of TreeSetTest **/

        TreeSet ts = new TreeSet(); 

 

        System.out.println("Tree Set Test\n");          

        char ch;

        /**  Perform set operations  **/

        do    

        {

            System.out.println("\nTree Set Operations\n");

            System.out.println("1. add ");

            System.out.println("2. delete");

            System.out.println("3. contains");

            System.out.println("4. count ");

            System.out.println("5. check empty"); 

            System.out.println("6. clear"); 

 

            int choice = scan.nextInt();            

            switch (choice)

            {

            case 1 : 

                System.out.println("Enter element to insert");

                ts.add( scan.next() );                     

                break;                          

            case 2 : 

                System.out.println("Enter element to delete");

                ts.delete( scan.next() );                     

                break;                         

            case 3 : 

                System.out.println("Enter integer element to search");

                System.out.println("Search result : "+ ts.contains( scan.next() ));

                System.out.println();

                break;                                          

            case 4 : 

                System.out.println("Count = "+ ts.countNodes());

                break;     

            case 5 :  

                System.out.println("Empty status = "+ ts.isEmpty());

                break;   

            case 6 :  

                System.out.println("Tree set cleared");

                ts.clear();

                break;         

            default : 

                System.out.println("Wrong Entry \n ");

                break;   

            }

            /**  Display tree set  **/ 

            System.out.print("\nTree Set : "+ ts);

            System.out.println();

 

            System.out.println("\nDo you want to continue (Type y or n) \n");

            ch = scan.next().charAt(0);                        

        } while (ch == 'Y'|| ch == 'y');               

    }

}