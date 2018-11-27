/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

public abstract class Shape implements Comparable {

    static Shape get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public abstract double computeArea();
    
    public int compareTo (Shape otherShape){
        final double EPSILON = 1.0e-15;
        Shape a = (Shape)otherShape;
        double diff = computeArea() - a.computeArea();
        if (Math.abs(diff) <= EPSILON*Math.abs(computeArea())){
            return 0;
        } else if (diff < 0){
            return -1;
        } else
            return 1;
    }
    
    @Override
    public abstract String toString();
    
}
