/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.EventListenerList;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author rodro
 */
public class SelectorImgUsuario extends JPanel {

    private String imagePath;
    private boolean isDeleted;
    private File f;
    private JButton editBtn;
 
    private JLabel nombre;
    private ImagePanel image;

    public SelectorImgUsuario() {

        init();
    }

    public SelectorImgUsuario(String img) {

        this.imagePath = img;
        init();
    }

    private void init() {

        if (imagePath != null && !imagePath.isEmpty()) {

            f = new File(imagePath);
            image = new ImagePanel(imagePath);
            nombre = new JLabel(f.getName());
  
        } else {

            image = new ImagePanel();
            nombre = new JLabel();
        }
        setBounds(0, 0, 300, 500);
        setVisible(true);
        setLayout(new BorderLayout());

        JPanel buttonContainer = new JPanel();
        buttonContainer.setBounds(0, 0, 200, 200);
        editBtn = new JButton("Elegir imagen");

        nombre.setBounds(10, 0, 100, 30);
        editBtn.setBounds(0, 0, 80, 20);

        editBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editarImagen(e);
            }
        });

        buttonContainer.add(editBtn);
        image.setBounds(0, 0, 300, 300);
        this.add(image, BorderLayout.CENTER);
        this.add(nombre, BorderLayout.NORTH);
        this.add(buttonContainer, BorderLayout.SOUTH);

    }

    private void delete(ActionEvent e) {

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
        this.imagePath = f.getAbsolutePath();

        this.image.loadImg(imagePath);
        this.image.repaint();

        revalidate();
        repaint();
        if (getParent() != null) {
            getParent().repaint();
        }

    }

    public String getSelectedIMG() {

        return this.f != null ? this.f.getAbsolutePath() : null;
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
        for (int i = 0; i < listeners.length; i = i + 2) {
            if (listeners[i] == NotifyEventListener.class) {
                ((NotifyEventListener) listeners[i + 1]).notifyEvent(evt);
            }
        }
    }

    void clean() {
        this.imagePath = "";

        this.image.cleanIMG();
        this.image.repaint();
        this.nombre.setText("");
        revalidate();
        repaint();
        if (getParent() != null) {
            getParent().repaint();
        }
    }

}
