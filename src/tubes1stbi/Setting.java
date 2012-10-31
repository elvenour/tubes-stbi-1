/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

import java.util.ArrayList;

/**
 *
 * @author d_frEak
 */
public class Setting {

    public ArrayList<String> fb=null;
    
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
    public double alpha;
    public double beta;
    public double ganma;
    
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
        alpha=0;
        beta=0;
        ganma=0;
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
    
    public String getCodeQuery()
    {
        String retval="";
        
        if(QueryTf==queryTfBinary)
        {
            retval+="b";
        }
        else if(QueryTf==queryTfLogaritmik)
        {
            retval+="l";
        }
        else
        {
            retval+="a";
        }
        
        if(QueryIdf==queryIdfYes)
        {
            retval+="t";
        }
        else
        {
            retval+="n";
        }
        
        if(QueryNormalisasi==queryNormalisasiYes)
        {
            retval+="c";
        }
        else
        {
            retval+="n";
        }
                
        return retval;
    }
    
    public boolean getStopword()
    {
        if(Stopword==stopwordYes)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean getStemming()
    {
        if(Stemming==stemmingYes)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    public String getCodeDocument()
    {
        String retval="";
        
        if(DocumentTf==documentTfBinary)
        {
            retval+="b";
        }
        else if(DocumentTf==documentTfLogaritmik)
        {
            retval+="l";
        }
        else
        {
            retval+="a";
        }
        
        if(DocumentIdf==documentIdfYes)
        {
            retval+="t";
        }
        else
        {
            retval+="n";
        }
        
        if(DocumentNormalisasi==documentNormalisasiYes)
        {
            retval+="c";
        }
        else
        {
            retval+="n";
        }
                
        return retval;
    }
    
}
