/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class RC {
    public ArrayList<Pairx> ArrRelevanceJudgement = new ArrayList<Pairx>();
    public ArrayList<Pairx> ArrRetrievalResult = new ArrayList<Pairx>();
    
    public void printArray(ArrayList<Pairx> arr) {
        int i = arr.size();
        for (int x = 1; x <= i; x++) {
            System.out.println("Nomor Query : " + arr.get(x-1).noquery);
            System.out.println("Nomor Document : " + arr.get(x-1).nodocument);
        }
    }
    
    public void read(int doc, String path) throws FileNotFoundException {
        FileInputStream fstream;
        if (doc == 0) { // baca RelevanceJudgement.txt
            fstream = new FileInputStream(path);
        }
        else { // baca RetrievalResult.txt
            fstream = new FileInputStream(path);
        }
        
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(fstream));
        String strLine = new String();
        try {
            strLine = br.readLine();
            while (strLine != null) {
                Pairx temppair = new Pairx();
                String temp = "";
                
                // membaca nomor query
                while (strLine.charAt(0) != ' ') {
                    temp = temp + strLine.charAt(0);
                    strLine = strLine.substring(1);
                }
                strLine = strLine.substring(1);
                temppair.noquery = Integer.parseInt(temp);
                
                // membaca nomor document
                temp = "";
                while (!strLine.isEmpty()) {
                    temp = temp + strLine.charAt(0);
                    strLine = strLine.substring(1);
                }
                temppair.nodocument = Integer.parseInt(temp);
                
                // simpan ke dalam array
                if (doc == 0) { // simpan ke dalam ArrRelevanceJudgement
                    ArrRelevanceJudgement.add(temppair);
                }
                else { // simpan ke dalam ArrRelevanceJudgement
                    ArrRetrievalResult.add(temppair);
                }
                
                // baca kembali
                strLine = br.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public float countRecall(int query) {
        int penyebut;
        int pembilang;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        int sum = 0;
        // cari penyebut
        for (int i = 0; i <= ArrRelevanceJudgement.size()-1; i++) {
            if (ArrRelevanceJudgement.get(i).noquery == query) {
                sum++;
                temp.add(ArrRelevanceJudgement.get(i).nodocument);
            }
        }
        penyebut = sum;
        
        sum = 0;
        // cari pembilang
        for (int i = 0; i <= ArrRetrievalResult.size()-1; i++) {
            if (ArrRetrievalResult.get(i).noquery == query) {
                if (temp.contains(ArrRetrievalResult.get(i).nodocument)) {
                    sum++;
                }
            }
        }
        pembilang = sum;
        
        return (pembilang / (float)penyebut);
    }
    
    public float countPrecision(int query) {
        int penyebut;
        int pembilang;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        int sum = 0;
        // cari penyebut
        for (int i = 0; i <= ArrRetrievalResult.size()-1; i++) {
            if (ArrRetrievalResult.get(i).noquery == query) {
                sum++;
            }
        }
        penyebut = sum;
        
        // cari banyaknya dokumen pada RelevanceJudgement
        for (int i = 0; i <= ArrRelevanceJudgement.size()-1; i++) {
            if (ArrRelevanceJudgement.get(i).noquery == query) {
                temp.add(ArrRelevanceJudgement.get(i).nodocument);
            }
        }
        
        sum = 0;
        // cari pembilang
        for (int i = 0; i <= ArrRetrievalResult.size()-1; i++) {
            if (ArrRetrievalResult.get(i).noquery == query) {
                if (temp.contains(ArrRetrievalResult.get(i).nodocument)) {
                    sum++;
                }
            }
        }
        pembilang = sum;
        
        return (pembilang / (float)penyebut);
    }
    
    public float countNIAP(int query) {
        int penyebut;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        int sum = 0;
        // cari penyebut
        for (int i = 0; i <= ArrRelevanceJudgement.size()-1; i++) {
            if (ArrRelevanceJudgement.get(i).noquery == query) {
                temp.add(ArrRelevanceJudgement.get(i).nodocument);
                sum++;
            }
        }
        penyebut = sum;
        
        // cari pembilang
        int retrieve = 0;
        int relevan = 0;
        float pembilang = 0f;
        for (int i = 0; i <= ArrRetrievalResult.size()-1; i++) {
            if (ArrRetrievalResult.get(i).noquery == query) {
                retrieve++;
                if (temp.contains(ArrRetrievalResult.get(i).nodocument)) {
                    relevan++;
                    pembilang = pembilang + (relevan / (float)retrieve);
                }
            }
        }
        
        return (pembilang / (float)penyebut);
    }
    
    public void printOutput() {
        ArrayList<Integer> ListQuery = new ArrayList<Integer>();
        for (int i = 0; i < ArrRetrievalResult.size(); i++) {
            if (!ListQuery.contains(ArrRetrievalResult.get(i).noquery)) {
                ListQuery.add(ArrRetrievalResult.get(i).noquery);
            }
        }
        
        // bikin tabel
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("| Nomor Query | Recall   | Precision | Non Interpolated Average Precision |");
        System.out.println("---------------------------------------------------------------------------");
        while (!ListQuery.isEmpty()) {
            // print Nomor Query
            System.out.print("| " + ListQuery.get(0));
            int panjang = Integer.toString(ListQuery.get(0)).length();
            int selisih = 11 - panjang;
            for (int j = 1; j <= selisih; j++) {
                System.out.print(" ");
            }
            System.out.print(" | ");
            
            // print Recall
            System.out.format("%f", countRecall(ListQuery.get(0)));
            System.out.print(" | ");
            
            // print Precision
            System.out.format("%f", countPrecision(ListQuery.get(0)));
            System.out.print("  | ");
            
            // print NIAP
            System.out.format("%f", countNIAP(ListQuery.get(0)));
            System.out.print("                           |");
            
            // Lanjut ke ListQuery berikutnya
            ListQuery.remove(0);
            System.out.println("");
        }
    }
    
    public static void main(String args[]) throws FileNotFoundException {
        RC a = new RC();
        a.read(0,"");
        a.read(1,"");
        a.printOutput();
    }
}
