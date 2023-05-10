package JavaPractise;
//astractc lass-(0=100%)abstractn is achieved

 interface Demo{
void start();
 }
 class Democlass implements Demo{

  @Override
  public void start() {
   System.out.println("Hello");
  }

  public static void main(String[] args) {
   Democlass d=new Democlass();
   d.start();
  }
 }