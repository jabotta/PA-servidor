/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.Predicate;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author rodro
 */
public class SelectorDeImagenes extends JPanel {

    private List<ImagenComponent> imagenes;
    private final JPanel pane;
    private final JPanel paneWrapper;
    private Boolean justOne;
    private Boolean firstSelected;
    private JButton addIMG;
    private Boolean editable;

    public SelectorDeImagenes(Boolean justOne) {

        editable = true;
        this.firstSelected = false;
        this.justOne = justOne;
        setLayout(new BorderLayout());
        paneWrapper = new JPanel();
        paneWrapper.setLayout(new BorderLayout());

        add(paneWrapper, BorderLayout.CENTER);

        pane = new JPanel();
        pane.setLayout(new SpringLayout());

        pane.setLocation(0, 40);
        paneWrapper.add(pane, BorderLayout.NORTH);

        imagenes = new ArrayList<ImagenComponent>();

        if (!justOne) {
            addIMG = new JButton("Agregar Imagen");
        } else {
            addIMG = new JButton("Elegir Imagen");
        }
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

    public void setReadOnly(Boolean s) {
        addIMG.setVisible(s);
        this.editable = s;
    }

    public SelectorDeImagenes() {
        editable = true;
        this.firstSelected = false;
        this.justOne = false;
        setLayout(new BorderLayout());
        paneWrapper = new JPanel();
        paneWrapper.setLayout(new BorderLayout());

        add(paneWrapper, BorderLayout.CENTER);

        pane = new JPanel();
        pane.setLayout(new SpringLayout());

        pane.setLocation(0, 40);
        paneWrapper.add(pane, BorderLayout.NORTH);

        imagenes = new ArrayList<ImagenComponent>();
        addIMG = new JButton("Agregar Imagen");
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

        if (this.justOne && !this.firstSelected || !this.justOne) {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes", "jpg", "gif", "png");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Eliga una imagen para su producto");
            int returnVal = chooser.showOpenDialog(this.getParent());
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                if (this.justOne) {
                    addIMG.setEnabled(false);
                }
                this.firstSelected = true;
                addImagenComponent(chooser.getSelectedFile());

            }
        }
    }

    private void addImagenComponent(File f) {

        ImagenComponent ic = new ImagenComponent(f, editable);

        ic.setAllowDelete(!this.justOne);
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
        if (getParent() != null) {
            getParent().repaint();
        }

    }

    public HashSet<String> getListaDeImagenes() {
        HashSet<String> imgPaths = new HashSet<String>();
        Iterator<ImagenComponent> it = imagenes.iterator();
        while (it.hasNext()) {
            ImagenComponent ic = it.next();
            if (!ic.isDeleted()) {
                imgPaths.add(ic.getPath());
            }
        }
        return imgPaths;
    }

    private void imagenBorrada(NotifyEvent evt) {
        Predicate<ImagenComponent> p = new Predicate<ImagenComponent>() {

            @Override
            public boolean test(ImagenComponent t) {
                return t.isDeleted();
            }
        };
        imagenes.removeIf(p);
        pane.removeAll();
        Iterator<ImagenComponent> it = imagenes.iterator();
        while (it.hasNext()) {
            ImagenComponent ic = it.next();
            ic.setLocation(10, imagenes.size() * 40);
            pane.add(ic);
            revalidate();
            repaint();
            getParent().repaint();
        }

        SpringUtilities.makeCompactGrid(pane, imagenes.size(), 1, 0, 0, 6, 6);
    }

    void load(List<String> imagenesPreload) {
        imagenesPreload.forEach((str) -> {
            System.out.println("str "+str );
            addImagenComponent(new File(str));
        });
    }
}
