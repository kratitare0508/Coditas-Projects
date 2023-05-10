package JavaPractise;
//Multilevel ineheritance
class Grandparent
{
    void property()
    {
        System.out.println("Grandparent's property");
    }
}
class Parent extends Grandparent
{
    void newproperty()
    {
        System.out.println("Got parents property");
    }
}
class Child extends Parent{
    void childproperty()
    {
        System.out.println("This is child's property");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Grandparent g=new Grandparent();
      //  g.property();
        Parent p=new Parent();
        Child c=new Child();

       c.property();
        c.newproperty();
        c.childproperty();

    }
}
