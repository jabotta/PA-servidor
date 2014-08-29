/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.PopupMenu;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author rodro
 */
class RegistrarUsuarioForm extends JPanel {

    private final JLabel nickname;
    private final JLabel nombre;
    private final JLabel apellido;
    private final JLabel fNac;
    private final JLabel email;
    private final JTextField nicknameText;
    private final JTextField emailText;
    private final JTextField fNacText;
    private final JTextField apellidoText;
    private final JTextField nombreText;
    private final JButton guardarBtn;
    private final JButton cancelarBtn;

    public RegistrarUsuarioForm() {

        setLayout(null);

        nickname = new JLabel("Nickname");
        nickname.setVisible(true);
        nickname.setBounds(0, 60, 150, 10);
        add(nickname);

        nicknameText = new JTextField();
        nicknameText.setBounds(150, 50, 300, 30);
        add(nicknameText);
        
        nombre = new JLabel("Nombre");
        nombre.setVisible(true);
        nombre.setBounds(0, 90, 150, 10);
        add(nombre);
        
        nombreText = new JTextField();
        nombreText.setBounds(150, 80, 300, 30);
        add(nombreText);

        apellido = new JLabel("Apellido");
        apellido.setVisible(true);
        apellido.setBounds(0, 120, 150, 10);
        add(apellido);
        
        apellidoText = new JTextField();
        apellidoText.setBounds(150, 110, 300, 30);
        add(apellidoText);

        fNac = new JLabel("Fecha de nacimiento");
        fNac.setVisible(true);
        fNac.setBounds(0, 150, 150, 10);
        add(fNac);
        
        fNacText = new JTextField();
        fNacText.setBounds(150, 140, 300, 30);
        add(fNacText);

        email = new JLabel("correo electronico");
        email.setVisible(true);
        email.setBounds(0, 180, 150, 10);
        add(email);
        
        emailText = new JTextField();
        emailText.setBounds(150, 170, 300, 30);
        add(emailText);
        
        guardarBtn = new JButton("Guardar");
        cancelarBtn = new JButton("Cancelar");
        
        guardarBtn.setBounds(200, 200, 100, 40);
        cancelarBtn.setBounds(320, 200, 100, 40);
        add(guardarBtn);
        add(cancelarBtn);
    }

}
