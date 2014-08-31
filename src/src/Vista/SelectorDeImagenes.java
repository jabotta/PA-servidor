/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.function.Predicate;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author rodro
 */
public class SelectorDeImagenes extends JPanel {

    private ArrayList<ImagenComponent> imagenes;
    private final JPanel pane;
    private final JPanel paneWrapper;

    public SelectorDeImagenes() {

        setLayout(new BorderLayout());
        paneWrapper = new JPanel();
        paneWrapper.setLayout(new BorderLayout());

        add(paneWrapper, BorderLayout.CENTER);

        pane = new JPanel();
        pane.setLayout(new SpringLayout());
        JScrollPane sp = new JScrollPane(pane);
        sp.setSize(400,400);
        sp.setPreferredSize(new Dimension(400, 110));
        pane.setLocation(0, 40);
        paneWrapper.add(sp, BorderLayout.NORTH);

        imagenes = new ArrayList();
        JButton addIMG = new JButton("Agregar Imagen");
        addIMG.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                agregarImgBtnActionPerformed(e);
            }

        });

        setSize(400, 1200);
        addIMG.setBounds(100, 20, 0, 0);
        add(addIMG, BorderLayout.NORTH);

    }

    private void agregarImgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarImgBtnActionPerformed

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes", "jpg", "gif", "png");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Eliga una imagen para su producto");
        int returnVal = chooser.showOpenDialog(this.getParent());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            addImagenComponent(chooser.getSelectedFile());

        }

    }

    private void addImagenComponent(File f) {

        ImagenComponent ic = new ImagenComponent(f);
        imagenes.add(ic);
        pane.setSize(500, imagenes.size() * 50);
        pane.repaint();
        ic.setLocation(10, imagenes.size() * 40);
        pane.add(ic);
        SpringUtilities.makeCompactGrid(pane, imagenes.size(), 1, 0, 0, 6, 6);

        ic.addNotifyEventListener(new NotifyEventListener() {

            @Override
            public void notifyEvent(NotifyEvent evt) {

                imagenBorrada(evt);

            }

        });
        revalidate();
        repaint();
        getParent().repaint();

    }

    private void imagenBorrada(NotifyEvent evt) { 
        Predicate<ImagenComponent> p =  new Predicate<ImagenComponent>() {

            @Override
            public boolean test(ImagenComponent t) {
                return t.isDeleted();
            }
        };
        imagenes.removeIf(p);
        System.out.println(imagenes.size());
        pane.removeAll();
        Iterator it = imagenes.iterator();
        while(it.hasNext()){
            ImagenComponent ic = (ImagenComponent)it.next();
            ic.setLocation(10, imagenes.size() * 40);
            pane.add(ic);
            revalidate();
            repaint();
            getParent().repaint();
        }
                
            SpringUtilities.makeCompactGrid(pane, imagenes.size(), 1, 0, 0, 6, 6);
     }
}
