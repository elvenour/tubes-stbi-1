/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class TextData {
        int docnum;
        String title;
        String author;
        ArrayList<RawTF> weight;
        
        public TextData(int d, String t, String a)
        {
            docnum = d;
            title = t;
            author = a;
            weight = new ArrayList<RawTF>();
        }
        
        
        
        public void addTerm(String t)
        {
           if(!weight.contains(t)) {
               System.out.println("new term, "+t);
               weight.add(new RawTF(t, 1));
           }
           else {
               System.out.println("old term, "+t+". total weight "+(weight.get(weight.lastIndexOf(t)).freq));
               weight.get(weight.lastIndexOf(t)).freq++;
           }
        }
        
        public void printData()
        {
            System.out.println("Doc Number \t : "+docnum);
            System.out.println("Title \t\t : "+title);
            System.out.println("Author \t\t : "+author);
            System.out.println("Term \t\t\t Weight");
            System.out.println("---- \t\t\t ------");
            for(RawTF r : weight)
            {
                System.out.println(r.term+" \t\t\t "+r.freq);
            }
            
        }
}
