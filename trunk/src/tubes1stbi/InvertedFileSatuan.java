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
    public int RTF;
    public int DF;
    public double IDF;
    public double Weight;
    
    public InvertedFileSatuan(String t, int n, int r, int d, double i, double w) {
        Term = t;
        NoDokumen = n;
        RTF = r;
        DF = d;
        IDF = i;
        Weight = w;
    }
    
    // nanti pengisi weight dan DF di InvertedFile.Java
}
