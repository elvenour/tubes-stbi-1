/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 *
 * @author User
 */
public class rf {
    public ArrayList<Row> WeightTable;
    public ArrayList<String> ListTermInQuery;
    
    public rf() {
        WeightTable = new ArrayList<Row>();
        ListTermInQuery = new ArrayList<String>();
    }
    
    /*public void createWeightTable(ArrayList<TextData> InvFile) {
        for (int i = 0; i < InvFile.size(); i++) {
            String nodoc = Integer.toString(InvFile.get(i).docnum);
            ArrayList<Double> ListTerm = new ArrayList<Double>();
            
            for (int j = 0; j < ListTermInQuery.size(); j++) {
                int k = 0;
                boolean cek = false;
                while ((k < InvFile.get(i).weight.size()) && (cek == false)) {
                    if (ListTermInQuery.get(j).equals(InvFile.get(i).weight.get(k).term)) {
                        cek = true;
                        ListTerm.add(InvFile.get(i).weight.get(k).weight);
                    }
                    ++k;
                }
                
                if (cek == false) {
                    ListTerm.add(0.0);
                }
            }
            
            Row r = new Row (nodoc, ListTerm);
            WeightTable.add(r);
        }
    }*/
    
    public void createWeightTable(InvertedFile InvFile) {
        // mendaftarkan semua dokumen yang ada
        for (int i = 0; i < InvFile.ListOfDocument.size(); i++) {
            ArrayList<Double> arr = new ArrayList<Double>();
            Row r = new Row(Integer.toString(InvFile.ListOfDocument.get(i).docnum), arr);
            WeightTable.add(r);
        }
        
        // Memasukkan weight dari tiap term
        for (int i = 1; i < WeightTable.size(); i++) {
            ArrayList<Double> arr = new ArrayList<Double>();
            for (int j = 0; j < ListTermInQuery.size(); j++) {
                int k = 0;
                boolean ketemu = false;
                while ((ketemu == false) && (k < InvFile.Inverted.size())) {
                    if ((Integer.toString(InvFile.Inverted.get(k).NoDokumen).equals(WeightTable.get(i).Name)) && (InvFile.Inverted.get(k).Term.equals(ListTermInQuery.get(j)))) {
                        ketemu = true;
                        arr.add(InvFile.Inverted.get(k).Weight);
                    }
                    ++k;
                }
                
                if (ketemu == false) {
                    arr.add(0.0);
                }
            }
            Row r = new Row (WeightTable.get(i).Name, arr);
            WeightTable.remove(i);
            WeightTable.add(i, r);
        }
    }
    
    public void printWeightTable() {
        for (int i = 0; i < WeightTable.size(); i++) {
            System.out.print(WeightTable.get(i).Name);
            for (int j = 0; j < WeightTable.get(i).Tab.size(); j++) {
                System.out.print(" " + WeightTable.get(i).Tab.get(j));
            }
            System.out.println("");
        }
    }
    
    public double countNormQuery() {
        double penyebut = 0.0;
        
        for (int i = 0; i < WeightTable.get(0).Tab.size(); i++) {
            penyebut = penyebut + WeightTable.get(0).Tab.get(i) * WeightTable.get(0).Tab.get(i);
        }
        
        return Math.sqrt(penyebut);
    }
    
    public double countNormDocument(String DocName) {
        double penyebut = 0.0;
        
        int idx = 0;
        boolean ketemu = false;
        while((idx < WeightTable.size()) && (ketemu == false)) {
            if (WeightTable.get(idx).Name.equals(DocName)) {
                ketemu = true;
            }
            else {
                ++idx;
            }
        }
        
        for (int i = 0; i < WeightTable.get(idx).Tab.size(); i++) {
            penyebut = penyebut + WeightTable.get(idx).Tab.get(i) * WeightTable.get(idx).Tab.get(i);
        }
        
        return Math.sqrt(penyebut);
    }
    
    public ArrayList<String> firstPhaseRetrieval(String kodequery, String kodedokumen) {
        ArrayList<Double> Similarity = new ArrayList<Double>();
        ArrayList<String> DocName = new ArrayList<String>();
        
        // parsing kodequery
        char c1 = kodequery.charAt(2);
        
        // parsing kodedokumen
        char c2 = kodedokumen.charAt(2);
        
        for (int i = 1; i < WeightTable.size(); i++) {
            double Hasil = 0.0;
            for (int j = 0; j < WeightTable.get(0).Tab.size(); j++) {
                Hasil = Hasil + (WeightTable.get(0).Tab.get(j) * WeightTable.get(i).Tab.get(j));
            }
            
            if (c1 == 'c') {
                Hasil = Hasil / countNormQuery();
            }
            
            if (c2 == 'c') {
                Hasil = Hasil / countNormDocument(WeightTable.get(i).Name);
            }
            
            Similarity.add(Hasil);
            DocName.add(WeightTable.get(i).Name);
        }
        
        // kembalikan ArrayList of String
        ArrayList<String> Ret = new ArrayList<String>();
        while (Similarity.isEmpty() == false) {
            // Ambil elemen terbesar
            int max = 0;
            double pembanding = 0.0;
            for (int i = 0; i < Similarity.size(); i++) {
                if (Similarity.get(i) > pembanding) {
                    pembanding = Similarity.get(i);
                    max = i;
                }
            }
            
            // Masukan ke dalam Ret
            Ret.add(DocName.get(max));
            
            // Hapus index pada Similarity dan DocName
            Similarity.remove(max);
            DocName.remove(max);
        }
        
        return Ret;
    }
    
    public ArrayList<String> secondPhaseRetrieval(ArrayList<String> Feedback, double alfa, double beta, double gamma, String kodequery, String kodedokumen) {
        // Terapkan Rocchio Method
        for (int i = 0; i < WeightTable.get(0).Tab.size(); i++) {
            //System.out.println(i);
            double QueryNew = alfa * WeightTable.get(0).Tab.get(i);
            
            // hitung yg relevan
            double temp = 0.0;
            for (int j = 1; j < WeightTable.size(); j++) {
                if (Feedback.contains(WeightTable.get(j).Name)) {
                    temp = temp + WeightTable.get(j).Tab.get(i);
                }
            }
            temp = temp * beta / Feedback.size();
            QueryNew = QueryNew + temp;
            
            // hitung yang tidak relevan
            temp = 0.0;
            for (int j = 1; j < WeightTable.size(); j++) {
                if (Feedback.contains(WeightTable.get(j).Name) == false) {
                    temp = temp + WeightTable.get(j).Tab.get(i);
                }
            }
            temp = temp * gamma / (WeightTable.size() - 1.0 - Feedback.size());
            QueryNew = QueryNew - temp;
            
            // ubah nilai pada WeightTable
            WeightTable.get(0).Tab.remove(i);
            WeightTable.get(0).Tab.add(i, QueryNew);
        }
        
        return (firstPhaseRetrieval(kodequery, kodedokumen));
    }
    
    public ArrayList<Pair> countIDF(int jenis, ArrayList<Pair> query, InvertedFile inv) {
        ArrayList<Pair> Hasil = new ArrayList<Pair>();
        
        for (int i = 0; i < query.size(); i++) {
            String name = query.get(i).Name;
            double idf = 0.0;
            
            if (jenis == 1) { // pakai IDF
                int j = 0;
                boolean cek = false;
                while ((j < inv.Inverted.size()) && (cek == false)) {
                    if (inv.Inverted.get(j).Term.equals(name)) {
                        cek = true;
                        idf = inv.Inverted.get(j).IDF;
                    }
                    ++j;
                }
            }
            else { // nggak pake IDF
                idf = 1.0;
            }
            
            Pair p = new Pair(name, idf);
            Hasil.add(p);
        }
        
        return Hasil;
    }
    
    public ArrayList<Pair> countTF(int jenis, ArrayList<String> query) {
        ArrayList<Pair> Hasil = new ArrayList<Pair>();
        
        // Hilangkan redundansi, hitung
        for (int i = 0; i < query.size(); i++) {
            String temp = query.get(i);
            if (Hasil.isEmpty()) {
                Pair p = new Pair(temp, 1.0);
                Hasil.add(p);
            }
            else {
                boolean cek = true;
                int j = 0;
                while ((cek == true) && (j < Hasil.size())) {
                    if (Hasil.get(j).Name.equals(temp)) {
                        cek = false;
                    }
                    ++j;
                }
                
                if (cek == true) {
                    Pair p = new Pair(temp, 1.0);
                    Hasil.add(p);
                }
                else {
                    for (int k = 0; k < Hasil.size(); k++) {
                        if (Hasil.get(k).Name.equals(temp)) {
                            Hasil.get(k).tf = Hasil.get(k).tf + 1.0;
                        }
                    }
                }
            }
        }
        
        if (jenis == 0) { // Logarithmic TF
            for (int i = 0; i < Hasil.size(); i++) {
                double x = Hasil.get(i).tf;
                Hasil.get(i).tf = 1.0 + Math.log10(x);
            }
        }
        else if (jenis == 1) { // Augmented TF
            double max = 1.0;
            for (int i = 0; i < Hasil.size(); i++) {
                if (Hasil.get(i).tf > max) {
                    max = Hasil.get(i).tf;
                }
            }
            
            for (int i = 0; i < Hasil.size(); i++) {
                double x = Hasil.get(i).tf;
                Hasil.get(i).tf = 0.5 + 0.5 * (x / max);
            }
        }
        
        return Hasil;
    }
    
    public ArrayList<String> removeStopword(ArrayList<String> input, String stopword) throws FileNotFoundException, IOException {
        BufferedReader r;
        String text;
        ArrayList<String> stops;
        ArrayList<String> Hasil = new ArrayList<String>();
        
        r = new BufferedReader(new FileReader(new File(stopword)));
        stops = new ArrayList<String>();
        //bentuk arraylist stopwords
        while((text = r.readLine()) != null){
            stops.add(text);
        }
        
        for(int i = 0; i < input.size(); i++) { //untuk tiap dokumen yang ada
            if (stops.contains(input.get(i)) == false) {
                Hasil.add(input.get(i));
            }
        }
        
        return Hasil;
    }
    
    public void hitungQuery(String query, String kode, InvertedFile inv, boolean stopword, boolean stem, String StopwordFile) throws FileNotFoundException, IOException {
        // Tokenization
        StringTokenizer st = new StringTokenizer(query);
        while (st.hasMoreTokens()) {
            ListTermInQuery.add(st.nextToken());
        }
        
        // Hilangkan stopword
        if (stopword == true) {
            ListTermInQuery = removeStopword(ListTermInQuery, StopwordFile);
        }
        
        // Stemming
        if (stem == true) {
            Stemmer s = new Stemmer();
            for (int i = 0; i < ListTermInQuery.size(); i++) {
                s.add(ListTermInQuery.get(i).toCharArray(), ListTermInQuery.get(i).length());
                s.stem();
                ListTermInQuery.remove(i);
                ListTermInQuery.add(i, s.toString());
            }
        }
        
        // Hitung bobot
        // Hitung TF
        ArrayList<Pair> ArrayTF = new ArrayList<Pair>();
        char tf = kode.charAt(0);
        if (tf == 'l') { // hitung menggunakan logarithmic tf
            ArrayTF = countTF(0, ListTermInQuery);
        }
        else if (tf == 'a') { // hitung menggunakan augmented tf
            ArrayTF = countTF(1, ListTermInQuery);
        }
        else if (tf == 'r') { // hitung menggunakan raw tf
            ArrayTF = countTF(2, ListTermInQuery);
        }
        
        // Hitung IDF
        ArrayList<Pair> ArrayIDF = new ArrayList<Pair>();
        char idf = kode.charAt(1);
        if (idf == 't') { // menggunakan idf
            ArrayIDF = countIDF(1, ArrayTF, inv);
        }
        else { // tidak menggunakan idf
            ArrayIDF = countIDF(0, ArrayTF, inv);
        }
        
        // Tambahkan bobot query pada elemen pertama WeightTable
        ArrayList<Double> BobotQuery = new ArrayList<Double>();
        
        for (int i = 0; i < ArrayTF.size(); i++) {
            BobotQuery.add(ArrayTF.get(i).tf * ArrayIDF.get(i).tf);
        }
        
        Row r = new Row("Q", BobotQuery);
        WeightTable.add(0, r);
    }
    
    public static void main(String args[]) throws FileNotFoundException, IOException {
        rf a = new rf();
        
        ArrayList<TextData> zenki = Parser.parseFile("testcase/adi/adi.all","testcase/stopwords/english",true);
        InvertedFile chaos = new InvertedFile(zenki);
        chaos.countInvertedFile(1,1);
        
        a.hitungQuery("ibm maintain too", "ltn", chaos, true, true, "testcase/stopwords/english");
        a.createWeightTable(chaos);
        a.printWeightTable();
        
        System.out.println("===============");
        
        ArrayList<String> OutputFirstRetrieval = a.firstPhaseRetrieval("ltc", "ltc");
        for (int i = 0; i < OutputFirstRetrieval.size(); i++) {
            System.out.println(OutputFirstRetrieval.get(i));
        }
        
        System.out.println("===============");
        
        ArrayList<String> Feedback = new ArrayList<String>();
        Feedback.add("1");
        Feedback.add("37");
        Feedback.add("48");
        Feedback.add("69");
        ArrayList<String> OutputSecondRetrieval = a.secondPhaseRetrieval(Feedback, 1.0, 1.0, 1.0, "ltn", "ltn");
        for (int i = 0; i < OutputSecondRetrieval.size(); i++) {
            System.out.println(OutputSecondRetrieval.get(i));
        }
        
        System.out.println("===============");
        a.printWeightTable();

        //a.hitungQuery("sleeping eating drinking faithful beautiful", "xxx.yyy");
        
        /*ArrayList<Double> d = new ArrayList<Double>();
        d.add(0.5);
        d.add(0.5);
        Row r = new Row("Q", d);
        a.WeightTable.add(r);
        
        d.clear();
        d.add(0.3);
        d.add(0.7);
        r = new Row("D1", d);
        a.WeightTable.add(r);
        
        d.clear();
        d.add(0.35);
        d.add(0.65);
        r = new Row("D2", d);
        a.WeightTable.add(r);
        
        d.clear();
        d.add(0.4);
        d.add(0.6);
        r = new Row("D3", d);
        a.WeightTable.add(r);
        
        d.clear();
        d.add(0.6);
        d.add(0.4);
        r = new Row("D4", d);
        a.WeightTable.add(r);
        
        d.clear();
        d.add(0.7);
        d.add(0.3);
        r = new Row("D5", d);
        a.WeightTable.add(r);
        
        ArrayList<String> test = a.firstPhaseRetrieval();
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }
        
        ArrayList<String> feedback = new ArrayList<String>();
        feedback.add("D1");
        feedback.add("D2");
        feedback.add("D3");
        test = a.secondPhaseRetrieval(feedback, 1.0, 1.0, 1.0);
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }*/
        
        /*ArrayList<String> haha = new ArrayList<String>();
        haha.add("haha");
        haha.add("hihi");
        haha.add("hehe");
        haha.add("wkwk");
        haha.add("hehe");
        haha.add("wkwk");
        haha.add("wkwk");
        ArrayList<Pair> wew = a.countTF(1, haha);
        
        // print
        for (int i = 0; i < wew.size(); i++) {
            System.out.println("Kata: " + wew.get(i).Name + ", TF: " + wew.get(i).tf);
        }*/
        
        
        /*Stemmer s = new Stemmer();
        String tes = "sleeping";
        s.add(tes.toCharArray(), tes.length());
        s.stem();
        System.out.println("Hasil: " + s.toString());*/
    }
}
