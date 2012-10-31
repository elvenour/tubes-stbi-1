/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

/**
 *
 * @author d_frEak
 */
public class Setting {

    
    public static int stopwordNo=0;
    public static int stopwordYes=1;
    
    public static int stemmingNo=0;
    public static int stemmingYes=1;
    
    public static int queryTfBinary=0;
    public static int queryTfLogaritmik=1;
    public static int queryTfAugmented=2;
    
    public static int queryIdfNo=0;
    public static int queryIdfYes=1;
    
    public static int queryNormalisasiNo=0;
    public static int queryNormalisasiYes=1;
    
    public static int documentTfBinary=0;
    public static int documentTfLogaritmik=1;
    public static int documentTfAugmented=2;
    
    public static int documentIdfNo=0;
    public static int documentIdfYes=1;
    
    public static int documentNormalisasiNo=0;
    public static int documentNormalisasiYes=1;
    
    public int Stopword;
    public int Stemming;
    public int QueryTf;
    public int QueryIdf;
    public int QueryNormalisasi;
    public int DocumentTf;
    public int DocumentIdf;
    public int DocumentNormalisasi;
    
    static Setting set=null;
   
    Setting()
    {
        Stopword=stopwordNo;
        Stemming=stemmingNo;
        QueryTf=queryTfBinary;
        QueryIdf=queryIdfNo;
        QueryNormalisasi=queryNormalisasiNo;
        DocumentTf=documentTfBinary;
        DocumentIdf=documentIdfNo;
        DocumentNormalisasi=documentNormalisasiNo;
    }
    
    //singleton
    public static Setting Singleton()
    {
        if(set == null)
        {
            set = new Setting();
        }
        return set;
    }
    
    
}
