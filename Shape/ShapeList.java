/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;
import java.util.ArrayList;

public class ShapeList extends ArrayList<Shape> {
 
    public ShapeList(){
        super();
    }
    
    public ShapeList largestShapes(){
        ShapeList largestList = new ShapeList();
        double largestArea = 0;
        for(Shape temp :this){
            double area = temp.computeArea();
            if(area > largestArea){
                largestArea = area;
                largestList.clear();
                largestList.add(temp);
            } else if (area == largestArea){
                largestList.add(temp);
            }
        }  
        return largestList;
    }
    
    public boolean hasDistinctAreas(){
        for (int i=0; i < this.size(); i++){
            for (int j=i+1;j< this.size(); j++){
                if ((this.get(i)).compareTo(this.get(j)) == 0 && !(this.get(i)).equals(this.get(j))){
                    return false;
                } 
            }
        }
        return true; 
    }
}
       