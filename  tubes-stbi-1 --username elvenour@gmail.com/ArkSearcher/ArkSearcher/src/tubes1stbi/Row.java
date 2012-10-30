/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Row {
    public String Name;
    public ArrayList<Double> Tab;
    
    public Row(String n, ArrayList<Double> arr) {
        Tab = new ArrayList<Double>();
        Name = n;
        for (int i = 0; i < arr.size(); i++) {
            Tab.add(arr.get(i));
        }
    }
    
    public static void main(String args[]) {
        /*ArrayList<Float> b = new ArrayList<Float>();
        float f = (float) 0.5;
        b.add(f);
        f = (float) 0.7;
        b.add(f);
        f = (float) 0.99;
        b.add(f);
        Row a = new Row("Q", b);
        
        System.out.println("Nama : " + a.Name);
        for (int i = 0; i < a.Tab.size(); i++) {
            System.out.println(a.Tab.get(i));
        }*/
    }
}
