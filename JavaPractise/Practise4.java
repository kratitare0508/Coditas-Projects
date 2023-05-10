package JavaPractise;
import java.util.*;
import java.util.HashSet;

public class Practise4 {
    public static void main(String[] args) {
        {
            int[] values=new int[]{2,45,67,67,89,2,34};
          /*  for(int i=0;i< values.length;i++)
            {
                for(int j=i+1;j<values.length;j++)
                {
                    if(values[i]==values[j] )
                    {
                        System.out.println("Duplicate element is::"+values[i]);
                    }
                }
            }*/
            System.out.println("duplicate elmnts are::");
            Set<Integer> set=new HashSet<>();
            for(int num:values)
            {
                boolean b=set.add(num);
                if(b==false)
                {
                    System.out.println(num+" ");
                }
            }

        }
    }
}
