package org.example;

public class Shape {
    private Circle c;
    private Triangle t;


    public Circle getC() {
        return c;
    }

    public void setC(Circle c) {
        this.c = c;
    }

    public Triangle getT() {
        return t;
    }

    public void setT(Triangle t) {
        this.t = t;
    }

    public void display()
    {
        System.out.println("Triangle");
        System.out.println(getT().getPointA().getX()+ "  " + getT().getPointA().getY());
        System.out.println(getT().getPointB().getX()+ "  " + getT().getPointB().getY());
        System.out.println(getT().getPointC().getX()+ "  " + getT().getPointC().getY());
        System.out.println("");
        System.out.println("Circle");
       System.out.println(c.getCentre().getX()+"  "+c.getCentre().getY());
       System.out.println(c.getRadius());
    }
}
