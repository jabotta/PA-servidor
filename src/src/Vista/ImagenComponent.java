/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.io.File;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author rodro
 */
public class ImagenComponent extends JPanel{
    private final JLabel nombre;
    private final JButton editBtn;
    private final JButton deleteBtn;
    private File f;

    public ImagenComponent(File f) {
       
        this.f = f;
        
        nombre = new JLabel(f.getName());
        editBtn = new JButton("editar");
        deleteBtn = new JButton("Borrar");
        
        this.setLayout(null);
        this.setBounds(0, 0, 300, 50);
        this.add(nombre);
        this.add(editBtn);
        this.add(deleteBtn);
    }
    
    
    
    
}
