/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

public class Rectangle extends Shape {
    private final double width, height;
    
    public Rectangle (double width, double height){
        this.width = width;
        this.height = height;
    }
    
    public double computeArea(){
        return width*height;
    }
    
    public boolean equals (Object obj){
        if (obj == this){
            return true;
        } if (obj == null){
            return false;
        }
        return false;
    }
    
    public String toString(){
        return ("width" + "" + width + "" + "height" + "" + height);
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
