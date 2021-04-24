/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        
package mypharma;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author bansa
 */
public class Welcome {
    
    public static void main(final String[] args) {
        final fframe f1 = new fframe();
        f1.setVisible(true);
        int i;
        int x = 1;
        for (i = 2; i <= 600; i += 4, x += 1) {
            f1.setLocation(800 - ((i + x) / 2), 500 - (i / 2));
            f1.setSize(i + x, i);
            try {
              Thread.sleep(10);
            } catch (final Exception e) {
            }
        }
    }
}

class fframe extends JFrame implements Runnable {
   
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Thread t1;

    fframe() {
        super("MYPHARMA:A PHARMACY FOR ALL YOUR NEEDS");
        setLayout(new FlowLayout());
        final ImageIcon imag1 = new ImageIcon(ClassLoader.getSystemResource("mypharma/Images/Welcome.jpg"));
        final Image img = imag1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        final ImageIcon imag1_edit = new ImageIcon(img);

        final JLabel l1 = new JLabel(imag1_edit);
        add(l1);
        t1 = new Thread(this);
        t1.start();
    }

    public void run() {
        try {
          Thread.sleep(4000);
            this.setVisible(false);
           new Front();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    
}
