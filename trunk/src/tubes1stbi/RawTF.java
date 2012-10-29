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
        int freq;
        
        public RawTF(String t, int f)
        {
            term = t; freq = f;
        }
                
        @Override
        public boolean equals(Object in)
        {
            if(in == null){
                return false;
            }else if(in instanceof RawTF){
                RawTF r = (RawTF) in;
                return term == r.term && freq == r.freq;
            }
            else if(in instanceof String){
                String r = (String) in;
                return term.equals(r);
            }
            else{return false;}
        }
        
}
