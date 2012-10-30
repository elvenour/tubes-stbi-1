/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class InvertedFile {
    public ArrayList<TextData> ListOfDocument;
    public ArrayList<InvertedFileSatuan> Inverted;
    
    public InvertedFile() {
        ListOfDocument = new ArrayList<TextData>();
        Inverted = new ArrayList<InvertedFileSatuan>();
    }
    
    public void convert() {
        for (int i = 0; i < ListOfDocument.size(); i++) {
            int no = ListOfDocument.get(i).docnum;
            for (int j = 0; j < ListOfDocument.get(i).weight.size(); j++) {
                
            }
        }
        
        // sort
        
    }
}
