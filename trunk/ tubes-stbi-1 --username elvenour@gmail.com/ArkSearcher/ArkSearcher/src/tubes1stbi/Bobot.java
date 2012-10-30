/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

/**
 *
 * @author Dell
 */
public class Bobot {
            
        String term;
        double tf;
        double idf;
        double norm;
        double weight;
        
        public Bobot(String t, double w)
        {
            term = t;
            weight = w;
        }
        
        public void convertFromDocument() {
            // baca kode dokumen yg xxx itu
            
            // sesuai kode, hitung tf
            
            // sesuai kode, hitung idf
            
            // sesuai kode, hitung norm
            
            // sesuai kode, hitung weight keseluruhan, masukkan ke dlm atribut weight
        }
        
        public double countTF() {
            // silakan diisi kode
            return (double)1; 
        }
        
        public double countIDF() {
            // silakan diisi kode
            return (double)1; 
        }
        
        public double countNorm() {
            // silakan diisi kode
            return (double)1; 
        }
                
        @Override
        public boolean equals(Object in) //kalau freq > 0, akan dibandingkan beserta frekuensinya, kalau <= 0, hanya membandingkan isi string
        {
            if(in == null){
                return false;
            }else if(in instanceof Bobot){                
                Bobot r = (Bobot) in;
/*                if(term.equals(r.term)){
                    System.out.println("got a same string! It's a "+r.term);
                }
                */
                  return term.equals(r.term);
            }
            else{return false;}
        }
        
}
