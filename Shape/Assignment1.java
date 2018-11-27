/*
Tuyen Pham
Tuid 915591991
Assignment 1 - CIS2168 - Section 08
This assignment is intended to test your ability to apply concepts from object oriented programming and lists.
 */
package assignment1;


public class Assignment1 {

    public static void main(String[] args) {
 //       String ShapeList[] = {"square","rhombus","gyrational square","rectangle","kite","parallelogram","isosceles trapezoid","irregular"};
        
        ShapeList obj = new ShapeList();
        Square Square = new Square (1);
        obj.add(Square);
        Rectangle rectangle = new Rectangle (1,2);
        obj.add(rectangle);
        Rectangle rhombus = new Rectangle (6,6);
        obj.add(rhombus);
        Rectangle gyrationalSquare = new Rectangle (3,3);
        obj.add(gyrationalSquare);
        Rectangle kite = new Rectangle (5,9);
        obj.add(kite);
        Rectangle parallelogram = new Rectangle (4,6);
        obj.add(parallelogram);
        Rectangle isoseclesTrapezoid = new Rectangle (3,6);
        obj.add(isoseclesTrapezoid);
        Rectangle irregular = new Rectangle (3,2);
        obj.add(irregular);
        Rectangle rhombus1 = new Rectangle (2,1);
        obj.add(rhombus1);
        
        System.out.println (obj.largestShapes());
        System.out.println (obj.hasDistinctAreas());
 
    }
}
