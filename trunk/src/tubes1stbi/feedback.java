/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes1stbi;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author d_frEak
 */
public class feedback extends JFrame{
    
    int dist=20;
    int position;
    int first=10;
    int tab=30;
    ArrayList<JCheckBox> check=new ArrayList<JCheckBox>();
    JCheckBox temp=new JCheckBox();
    
    feedback(ArrayList<String> str)
    {
        position=first;
        JTextArea area=new JTextArea();
        area.setEnabled(false);
        area.setBounds(position, tab, 600, 10);
        position+=dist;
        String tampil="File :\n";
        for(int i=0;i<str.size();i++)
        {
            tampil+=str.get(i)+"\n";
            
            temp=new JCheckBox();
            position+=dist;
            temp.setText(str.get(i));
            temp.setBounds(position, tab, 600, 10);
            
            check.add(temp);
        }
        area.setText(tampil);
        
        
        JButton but=new JButton("OK");
        position+=dist;
        but.setBounds(position, tab, 10, 10);
        but.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("masuk");
                ok();
                
            }
        });
        
        JPanel panel=new JPanel();
        panel.add(area);
        for(int i=0;i<check.size();i++)
        {
            panel.add(check.get(i));
        }
        panel.add(but);
        
        
        this.add(panel);
//        this.setLocationRelativeTo(null);
        this.setSize(600, 100+str.size()*50);
        this.setTitle("Feedback");
    }
    
    public void ok()
    {
        Setting.Singleton().fb=new ArrayList<String>();
        for(int i=0;i<check.size();i++)
        {
            if(check.get(i).isSelected())
            {
                Setting.Singleton().fb.add(check.get(i).getText());
            }
        }
        
        for(int i=0;i<Setting.Singleton().fb.size();i++)
        {
            System.out.println(Setting.Singleton().fb.get(i));
        }
        this.dispose();
    }
    
}
