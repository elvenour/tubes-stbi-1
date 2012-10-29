/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

/**
 *
 * @author Dell
 */
public class RawTF {
            
        String term;
        Integer freq;
        
        public RawTF(String t, int f)
        {
            term = t; freq = f;
        }
                
        @Override
        public boolean equals(Object in) //kalau freq > 0, akan dibandingkan beserta frekuensinya, kalau <= 0, hanya membandingkan isi string
        {
            if(in == null){
                return false;
            }else if(in instanceof RawTF){                
                RawTF r = (RawTF) in;
/*                if(term.equals(r.term)){
                    System.out.println("got a same string! It's a "+r.term);
                }
                */
                  return term.equals(r.term);
            }
            else{return false;}
        }
        
}
