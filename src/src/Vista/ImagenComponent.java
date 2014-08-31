/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author rodro
 */
public class ImagenComponent extends JPanel{

    private final JLabel nombre;
    private final JButton editBtn;
    private final JButton deleteBtn;
    private File f;
    private boolean isDeleted; 
    public ImagenComponent(File f) {

        this.f = f;
        this.setSize(400, 100);
        nombre = new JLabel(f.getName());
        System.out.println(f.getName());
        editBtn = new JButton("editar");
        deleteBtn = new JButton("Borrar");
        nombre.setVerticalAlignment(0);
        nombre.setBounds(10, 0, 100, 30);
        editBtn.setBounds(90, 10, 80, 20);
        deleteBtn.setBounds(180, 10, 80, 20);
        this.add(nombre);
        this.add(editBtn);
        this.add(deleteBtn);
        repaint();

        editBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editarImagen(e);
            }
        });
        deleteBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                delete(e);
            }

        });
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + (this.isDeleted ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ImagenComponent other = (ImagenComponent) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (this.isDeleted != other.isDeleted) {
            return false;
        }
        return true;
    }

    private void delete(ActionEvent e) {
        
        this.setVisible(false);
        this.isDeleted = true;
        this.disableEvents(WIDTH);
        fireNotifyEvent(new NotifyEvent(this));
    }

    private void editarImagen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarImgBtnActionPerformed

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes", "jpg", "gif", "png");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Eliga una imagen para su producto");
        int returnVal = chooser.showOpenDialog(this.getParent());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            cambiarArchivo(chooser.getSelectedFile());

        }

    }

    private void cambiarArchivo(File selectedFile) {
        
        this.f = selectedFile;
        this.nombre.setText(f.getName());
        repaint();
                
    }

    public boolean isDeleted() {
        return isDeleted;
    }
     protected EventListenerList listenerList = new EventListenerList();

    public void addNotifyEventListener(NotifyEventListener listener) {
      listenerList.add(NotifyEventListener.class, listener);
    }
    public void removeNotifyEventLListener(NotifyEventListener listener) {
      listenerList.remove(NotifyEventListener.class, listener);
    }
    void fireNotifyEvent(NotifyEvent evt) {
      Object[] listeners = listenerList.getListenerList();
      for (int i = 0; i < listeners.length; i = i+2) {
        if (listeners[i] == NotifyEventListener.class) {
          ((NotifyEventListener) listeners[i+1]).notifyEvent(evt);
        }
      }
    }

    public String getPath() {
        return f.getAbsolutePath();
     }
}
