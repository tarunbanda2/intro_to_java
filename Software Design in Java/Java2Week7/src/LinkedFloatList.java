// Demo of java.util Linkedlist of floats (c.f custom FloatList)
import java.util.*;
import java.text.*;

public class LinkedFloatList
{
   static void showList(LinkedList<Float> myList)
   {
      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
      tidy.setMaximumFractionDigits(2);
      ListIterator<Float> iter;
      
      System.out.println( "\n\n_____Here's the List_______\n" );
      for (iter = myList.listIterator(); iter.hasNext(); )
         System.out.print("[" + tidy.format(iter.next()) + "] ");
      System.out.println( "\n\n_____That's all!_______\n" );
   }
   
   static void insert(LinkedList<Float> myList, float x)
   {
      ListIterator<Float> iter;
      float listX;

      for (iter = myList.listIterator(); iter.hasNext(); )
      {
        listX = iter.next();
        if (x <= listX)
        {
           iter.previous(); // back up one
           break;
        }
      }
      iter.add(x);
   }
   
   static boolean remove(LinkedList<Float> myList, float x)
   {
      ListIterator<Float> iter;

      for (iter = myList.listIterator(); iter.hasNext(); )
         if (iter.next() == x)
         {
            iter.remove();
            return true;   // we found, we removed, we return
         }
      return false;
   }
   
   public static void main (String[] args)
   {
      LinkedList<Float> myList = new LinkedList<Float>();
      int k;
      float x;

      // build list of 10 floats, 2 at a time (1 random and 1 k*100)
      for (k = 0; k < 5; k++)
      {
         x = 1000 * (float)Math.random(); // float bet 0 and 1000
         insert(myList, x);
         insert(myList, k*100);
         insert(myList, k*100);
      }

      // should be sorted
      showList(myList);

      // remove 5 nodes (and delete them!)
      for (k = 0; k < 5; k++)
      {
         x = k*100;
         if (remove(myList, x))
            System.out.println(x + " removed");
         else 
            System.out.println(x + " not found");
     }
     showList(myList);

      if (!remove (myList, -10))  // should have no effect
         System.out.println("-10 not in list as expected. \n");;
      showList(myList);
   }
 }

/* -------------- Run of Above ------------------

_____Here's the List_______

[0] [0] [31.74] [100] [100] [174.84] [200] [200] [300] [300] [400] [400] [514.41
] [658.16] [694.21] 

_____That's all!_______

0.0 removed
100.0 removed
200.0 removed
300.0 removed
400.0 removed


_____Here's the List_______

[0] [31.74] [100] [174.84] [200] [300] [400] [514.41] [658.16] [694.21] 

_____That's all!_______

-10 not in list as expected. 



_____Here's the List_______

[0] [31.74] [100] [174.84] [200] [300] [400] [514.41] [658.16] [694.21] 

_____That's all!_______

--------------------- End Run ---------------------- */