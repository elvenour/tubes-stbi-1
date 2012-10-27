/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

/**
 *
 * @author d_frEak
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Stemmer s = new Stemmer();
        String tes;
        tes="sleeping";
        s.add(tes.toCharArray(), tes.length());
        s.stem();
        System.out.println("hasil: "+s.toString());
    }
}
