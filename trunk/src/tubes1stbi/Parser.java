/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Dell
 */
public class Parser {
       
    
    public static ArrayList<TextData> parseFile(String addr,Boolean stem)
    {
       ArrayList<TextData> tdata = new ArrayList<TextData>();
       TextData td = new TextData(0, "dummy", "dummy");
       BufferedReader r;
       Stemmer stm = new Stemmer();
       String text = "";
       int docnum = -1;
       String title = " ";
       String author = " ";
       String buffer = " ";
       int mode = 0;
       
       try{
           r = new BufferedReader(new FileReader(new File(addr)));
       
           /*daftar mode :
            * 0 : baca nomor .. ?
            * 1 : baca title
            * 2 : baca author
            * 3 : baca isi
           */
           while((text = r.readLine()) != null){
               String[] coba = text.split(" "); 
               
                if(coba[0].equals(".I"))
               {

//                  System.out.println("Text Number : "+coba[1]); 
                   if (docnum > 0) {
                       tdata.add(td); 
                   }
                   mode = 0;
                   docnum = Integer.parseInt(coba[1]);
                   buffer = "";
               }
               else if(coba[0].equals(".T"))
               {
//                   System.out.println("mode 1");
//                   System.out.println("Title : ");
                   mode = 1;
               }
               else if(coba[0].equals(".A"))
               {
//                   System.out.println("mode 2");
//                   System.out.println("Author : ");
                 // title disimpan terlebih dahulu, lalu dikosongkan untuk menampung author
                   title = buffer;
                   buffer = "";
                   mode = 2;
               }
               else if(coba[0].equals(".W"))
               {  
//                   System.out.println("mode 3");
//                   System.out.println("Text : ");
                  author = buffer;
                  buffer = "";
                  //sebelum membaca isi teks, masukkan dahulu data tersebut
//                   System.out.println("docnum : "+docnum+", title : "+title+", author : "+author);
                  td = new TextData(docnum, title, author);                  
                  mode = 3;
               }
               else
               {
//                   System.out.println("buffering");
//                   System.out.println("banyak kata : "+coba.length);
                   if(mode == 3) //bila dalam mode memasukkan weight, selamatkan dulu isi dokumennya.
                           {
                                td.doctext.add(text);
                           }
                   for(String s : coba)
                   {
                       
                       s = s.replaceAll("\\s", "");//delete whitespaces
                       s = s.replaceAll("\\.", "");//delete periods
                       s = s.replaceAll(",", "");//delete commas
                       s = s.replaceAll(";", "");//delete semicolons
                       s = s.replaceAll(":", "");//delete colons
                        s = s.replaceAll("\\(", "");//delete (
                         s = s.replaceAll("\\)", "");//delete )
                       if (!s.isEmpty())
                       {
                            if(stem){
                             stm.add(s.toCharArray(),s.length());
                             stm.stem();
                             s = stm.toString();
                            }
                            
                           if(mode == 3) //bila dalam mode memasukkan weight
                           {
                                td.addTerm(s);
                           }

                                buffer+=" "+s;                       
                       }
                       
                   }
               }

              
           }
           
       }
       catch(Exception e){
       
       }
//        System.out.println("size tdata : "+tdata.size());
       return tdata;
    }
    
    public static ArrayList<TextData> parseFile(String addr, String stopwords, Boolean stem)
    {
        BufferedReader r;
        String text;
        ArrayList<String> stops;
        ArrayList<TextData> tdata = parseFile(addr,stem);

        try{
            r = new BufferedReader(new FileReader(new File(stopwords)));
            stops = new ArrayList<String>();
            //bentuk arraylist stopwords
            while((text = r.readLine()) != null){
                stops.add(text);
            }
            
            //lakukan stopword removal      
            for(TextData td : tdata) //untuk tiap dokumen yang ada
            {
//                System.out.println("doc : "+td.docnum);
                Iterator<RawTF> itx = td.weight.iterator();
                while(itx.hasNext())
                {
                    RawTF rtf = itx.next();
                    if(stops.contains(rtf.term))
                    {
//                        System.out.println("stopword term found : "+rtf.term);
                        itx.remove();
                    }
                }
            }
        }
        catch(Exception e){
        
        }
        
        
        return tdata;
    }
    public static void main (String[] args){
        ArrayList<TextData> zenki = Parser.parseFile("testcase/adi/adi.all","testcase/stopwords/english",true);
        zenki.get(0).printData();
        zenki.get(0).printDocText();
        //System.out.println(zenki.get(0).weight.indexOf(new RawTF("aquila",1)));
    }
}
