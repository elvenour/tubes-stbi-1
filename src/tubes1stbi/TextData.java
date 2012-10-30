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
        ArrayList<Bobot> weight;
        
        public TextData(int d, String t, String a)
        {
            docnum = d;
            title = t;
            author = a;
            weight = new ArrayList<Bobot>();
        }
        
        
        /*public void addTerm(String t)
        {
            //perbandingan tipe RawTF hanya melihat string, tanpa frekuensi
            
//            System.out.println("compared string : "+t+", forecast : "+weight.contains(new RawTF(t,1)));
           if(weight.contains(new Bobot(t,1)) == false) {
//               System.out.println("new term, "+t);  
               weight.add(new Bobot(t, 1));
           }
           else {
               int i = weight.lastIndexOf(new Bobot(t,1));
//               System.out.println("old term, "+t+". index  :"+weight.get(i).freq);
//               System.out.println("old frequency : "+weight.get(weight.lastIndexOf(t)).freq);
               weight.get(i).freq++;
//                System.out.println("new frequency : "+weight.get(i).freq);
           }
        }
        
        public void printData()
        {
            System.out.println("Doc Number \t : "+docnum);
            System.out.println("Title \t\t : "+title);
            System.out.println("Author \t\t : "+author);
            System.out.println("Term \t\t\t Weight");
            System.out.println("---- \t\t\t ------");
            for(Bobot r : weight)
            {
                System.out.println(r.term+" \t\t\t "+r.freq);
            }
            
        }*/
}
