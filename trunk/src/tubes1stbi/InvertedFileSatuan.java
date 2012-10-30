/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

/**
 *
 * @author User
 */
public class InvertedFileSatuan {
    public String Term;
    public int NoDokumen;
    public int DF;
    public double Weight;
    
    public InvertedFileSatuan(String t, int n, int d, double w) {
        Term = t;
        NoDokumen = n;
        DF = d;
        Weight = w;
    }
    
    // nanti pengisi weight dan DF di InvertedFile.Java
}
