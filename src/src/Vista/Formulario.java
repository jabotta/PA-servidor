/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Clases.Utils;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.demo.DateChooserPanel;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import org.eclipse.persistence.internal.core.helper.CoreClassConstants;

/**
 *
 * @author rodro
 */
public class Formulario extends JPanel {

    private HashMap<String, JComponent> campos;
    private Integer currentHeight;
    private boolean isEnabled;

    public Formulario() {
        isEnabled = true;
        campos = new HashMap();
        setLayout(null);
        setVisible(true);
        setSize(500, 900);
        JScrollPane scroll = new JScrollPane(this);
        currentHeight = 20;
    }

    public Formulario(boolean b) {

        isEnabled = b;
        campos = new HashMap();
        setLayout(null);
        setVisible(true);
        setSize(500, 700);
        JScrollPane scroll = new JScrollPane(this);
        currentHeight = 20;
    }

    public void addField(String fieldName, String fieldType) {
        this.addField(fieldName, fieldType, null, null);
    }

    public void addIMGField(String fieldName,   ArrayList<String> s,Boolean editable) {
        JComponent componente;
        JLabel label = new JLabel();
        label.setText(fieldName);
        label.setSize(fieldName.length() * 10, 30);
        Dimension componentSize = new Dimension(180, 500);
        componente = new SelectorDeImagenes();

        ((SelectorDeImagenes) componente).setReadOnly(editable);
        ((SelectorDeImagenes) componente).load(s);
        componente.setEnabled(isEnabled);
        componente.setSize(componentSize);
        campos.put(fieldName, componente);

        Integer currentSize = campos.values().size();
        label.setLocation(10, currentHeight);
        componente.setLocation(150, currentHeight);
        currentHeight += componentSize.height;
        label.setLabelFor(componente);
        //  System.out.println(componente.getClass());
        add(label);
        add(componente);
        repaint();

    }

    public void addField(String fieldName, String fieldType, Object[] toArray, String value) {
        JComponent componente;
        JLabel label = new JLabel();
        label.setText(fieldName);
        label.setSize(fieldName.length() * 10, 30);
        Dimension componentSize = new Dimension(180, 30);

        switch (fieldType) {

            case "textarea":
                componente = new JTextArea(value);
                componentSize.setSize(180, 200);
                break;
            case "list":
                componente = new JList();
                componentSize.setSize(180, 200);
                break;
            case "combo":
                componente = new JComboBox(toArray);

                break;
            case "checkbox":
                componente = new JCheckBox(value);
                break;

            case "Date":
                componente = new DateChooserPanel();

                ((DateChooserPanel) componente).setDate(Utils.getDateFromString(value));
                break;
            case "text":
            default:
                componente = new JTextField(value);
                break;
        }
        componente.setEnabled(isEnabled);
        componente.setSize(componentSize);
        campos.put(fieldName, componente);

        Integer currentSize = campos.values().size();
        label.setLocation(10, currentHeight);
        componente.setLocation(150, currentHeight);
        currentHeight += componentSize.height;
        label.setLabelFor(componente);
        //  System.out.println(componente.getClass());
        add(label);
        add(componente);
    }

    @Deprecated
    private void format() {
        int size = campos.values().size();
        //  SpringUtilities.makeGrid(this,size,2,0,0,6,6);
    }

    public JComponent getComponentByName(String name) {

        if (campos.containsKey(name)) {

            return campos.get(name);
        }
        return null;
    }

}
