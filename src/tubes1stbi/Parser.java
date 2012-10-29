/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Parser {
       
    
    public static ArrayList<TextData> parseFile(String addr)
    {
       ArrayList<TextData> tdata = new ArrayList<TextData>();
       TextData td = new TextData(0, "dummy", "dummy");
       BufferedReader r;
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
//                   System.out.println("mode 0");
//                  System.out.println("Text Number : "+coba[1]); 
                   if (docnum > 0) {
//                       System.out.println("roar!");
                       tdata.add(td); 
//                       td.printData();
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
//                 // title disimpan terlebih dahulu, lalu dikosongkan untuk menampung author
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
                   for(String s : coba)
                   {
                       if(mode == 3) //bila dalam mode memasukkan weight
                       {
//                           System.out.println("adding term : "+s);
                           td.addTerm(s);
                       }
                           buffer+=" "+s;                       
                      
                   }
                   //System.out.println(buffer);
               }

              
           }
           
       }
       catch(Exception e){
       
       }
//        System.out.println("size tdata : "+tdata.size());
       return tdata;
    }
    public static void main (String[] args){
        ArrayList<TextData> zenki = Parser.parseFile("testcase/adi/adi.all");
        zenki.get(0).printData();
    }
}
