package com.crisp;

 /*
 * Natural order of Raddish is defined by 'size' '
 * 'size' is called the sort key
 *
 */

public class Raddish implements Comparable<Raddish> {
    private String color;
    private double size;
    private double tailLength;
    private int guysOnTop;


    //constructor

    public Raddish (String color, double size, double tailLength, int guysOnTop){
        setColor(color);
        setSize(size);
        setTailLength(tailLength);
        setGuysOnTop(guysOnTop);
    }

    //accessor methods

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public int getGuysOnTop() {
        return guysOnTop;
    }

    public void setGuysOnTop(int guysOnTop) {
        this.guysOnTop = guysOnTop;
    }

    /*
    * Size is the sort key. Size is a double.
    * Page 56 on the book
    * Direct subtraction cannot be done.
    * */
    @Override
    public int compareTo(Raddish other) {
        return Double.compare(this.getSize(), other.getSize());
    }
    //toString
    @Override
    public String toString() {
        return String.format("%s, %.2f, %.2f, %s", getColor(), getSize(), getTailLength(), getGuysOnTop());

    }
}
