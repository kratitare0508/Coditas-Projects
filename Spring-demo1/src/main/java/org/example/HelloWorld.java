package org.example;

public class HelloWorld {
  private  String name;


  HelloWorld()
  {

  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHello()
  {
      System.out.println("Spring 3::Hello-"+name);
  }

  public HelloWorld(String name)
  {
      this.name=name;
  }

}