/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class InvertedFile {
    public ArrayList<TextData> ListOfDocument;
    public ArrayList<InvertedFileSatuan> Inverted;
    
    public InvertedFile() {
        ListOfDocument = new ArrayList<TextData>();
        Inverted = new ArrayList<InvertedFileSatuan>();
    }
    
    public InvertedFile(ArrayList<TextData> lod){
      ListOfDocument = lod; //ambil list of document
    }
    
    public void countInvertedFile(int tfmode, int idfmode){
        /*
         * tfmode : 0 - binary, 1 - log, 2 - augmented
         * idfmode : 0 - no, 1 - yes
         * normmode : 0 - no, 1 -yes
         */
        
        Inverted = new ArrayList<InvertedFileSatuan>();
        ArrayList<String> termlist = new ArrayList<String>();
        
        //buat daftar kata
        for(TextData td : ListOfDocument)
        {
            for(RawTF r : td.weight)
            {
                if(!termlist.contains(r.term)) termlist.add(r.term);
            }
        }
        
        //buat InvertedFile
        for(String s : termlist)
        {
            int df = 0;
            //hitung nilai DF
            
            for(TextData td : ListOfDocument)
            {
                if(td.weight.contains(new RawTF(s,0))) //kalau ada
                {
                    df++;                    
                }
            }
            
            //cari lagi, kali ini untuk membentuk InvertedFileSatuan
            for(TextData td : ListOfDocument)
            {
                int i = td.weight.indexOf(new RawTF(s,0));
                if( i > -1) //kalau ada
                {
                   double weight = 0.0;
                   
                   if(tfmode == 0) // mode binary tf
                   {
                       weight = td.countBinTF(i);
                   }
                   else if(tfmode == 1) // mode log tf
                   {
                       weight = td.countLogTF(i);
                   }
                   else if(tfmode == 2) // mode aug tf
                   {
                       weight = td.countAugTF(i);
                   }
                   
                   if(idfmode == 1) //idf dihitung
                   {
                       weight = weight * Math.log10(ListOfDocument.size()/df);
                   }
                   
                   //buat InvertedFileSatuannya
                   Inverted.add(new InvertedFileSatuan(s, td.docnum,td.weight.get(i).freq ,df, Math.log10(ListOfDocument.size()/df), weight));
                }
            }
        }
    }
    
    public void printInvertedFile()
    {
          DecimalFormat df = new DecimalFormat("#.##");
          System.out.println("Kata \t\t\t Dok. \t\t Raw-TF \t DF \t\t Bobot");
          System.out.println("---- \t\t\t ---- \t\t ------ \t -- \t\t -----");
          
        for(InvertedFileSatuan ifs : Inverted)
        {
            System.out.println(ifs.Term+" \t\t\t "+ifs.NoDokumen+" \t\t "+ifs.RTF+" \t\t "+ifs.DF+" \t\t "+df.format(ifs.Weight));            
        }
    }
    
    public void convert() {
        for (int i = 0; i < ListOfDocument.size(); i++) {
            int no = ListOfDocument.get(i).docnum;
            for (int j = 0; j < ListOfDocument.get(i).weight.size(); j++) {
                
            }
        }
        
        // sort       
    }
    
    public static void main (String[] Args){
        ArrayList<TextData> zenki = Parser.parseFile("testcase/adi/adi.all","testcase/stopwords/english",true);
        InvertedFile chaos = new InvertedFile(zenki);
        chaos.countInvertedFile(1,0);
        chaos.printInvertedFile();
    }
}
