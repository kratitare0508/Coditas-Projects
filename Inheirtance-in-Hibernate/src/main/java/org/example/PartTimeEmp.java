package org.example;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="part_time")
public class PartTimeEmp extends Employee {
    private int hrs_sal,no_of_hrs;
   public PartTimeEmp(int id, String name, int i, int i1)
   {
       super(id,name);
       this.hrs_sal=hrs_sal;
       this.no_of_hrs=no_of_hrs;
   }

}
