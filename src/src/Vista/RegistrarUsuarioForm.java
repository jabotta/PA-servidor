package Vista;

import Controlador.Clases.IControladorUsuarios;
import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataProveedor;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class RegistrarUsuarioForm extends JPanel {

    private final JLabel nickname;
    private final JLabel nombre;
    private final JLabel apellido;
    private final JLabel fNac;
    private final JLabel email;
    private final JLabel nombreCompania;
    private final JLabel linkSitio;
    private final JTextField nicknameText;
    private final JTextField emailText;
    private final JTextField fNacText;
    private final JTextField apellidoText;
    private final JTextField nombreText;
    private final JTextField nombreCompaniaText;
    private final JTextField linkSitioText;
    private final JButton guardarBtn;
    private final JButton cancelarBtn;
    private final JCheckBox esProveedor;
    private final IControladorUsuarios controlarUsuario;

    public RegistrarUsuarioForm(IControladorUsuarios ICU) {
        
        controlarUsuario = ICU;
                
        setLayout(null);
        
        JLabel proveedorlabel = new JLabel("Es proovedor?:");
        proveedorlabel.setVisible(true);
        proveedorlabel.setBounds(0, 10, 150, 20);
        add(proveedorlabel);
        
        esProveedor = new JCheckBox();
        esProveedor.setName("Elegir si el usuario es provedor");
        esProveedor.setLocation(100, 5);
        esProveedor.setSize(30, 30);
        esProveedor.setVisible(true);
        add(esProveedor);
        
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

        email = new JLabel("Correo electronico");
        email.setVisible(true);
        email.setBounds(0, 180, 150, 10);
        add(email);
        
        emailText = new JTextField();
        emailText.setBounds(150, 170, 300, 30);
        add(emailText);
        
        nombreCompania = new JLabel("Nombre Compania");
        nombreCompania.setVisible(true);
        nombreCompania.setBounds(0, 205, 150, 15);
        add(nombreCompania);
        
        nombreCompaniaText = new JTextField();
        nombreCompaniaText.setBounds(150, 200, 300, 30);
        add(nombreCompaniaText);
        
        linkSitio = new JLabel("Link Sitio");
        linkSitio.setVisible(true);
        linkSitio.setBounds(0, 240, 150, 10);
        add(linkSitio);
        
        linkSitioText = new JTextField();
        linkSitioText.setBounds(150, 230, 300, 30);
        add(linkSitioText);

        guardarBtn = new JButton("Guardar");
        cancelarBtn = new JButton("Cancelar");

        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 guardarUsuario(e);
            }
        });
        
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 cancelar(e);
            }
        });
        
        guardarBtn.setBounds(200, 260, 100, 40);
        cancelarBtn.setBounds(320, 260, 100, 40);
        add(guardarBtn);
        add(cancelarBtn);
    }

    private void guardarUsuario(ActionEvent evt) {
        String nickname = nicknameText.getText();
        String email = emailText.getText();
        String fnac = fNacText.getText();
        String apellido = apellidoText.getText();
        String nombre = nombreText.getText();
        String nombreCompania = nombreCompaniaText.getText();
        String linkSitio = linkSitioText.getText();
        
        if (!esProveedor.isSelected()) {
            DataCliente cliente = new DataCliente(nickname, nombre, apellido, email, null);
            controlarUsuario.ingresarDatosCliente(cliente);
        } else {
            DataProveedor proveedor = new DataProveedor(nickname, nombre, apellido, email, null, nombreCompania, linkSitio);
            controlarUsuario.ingresarDatosProveedor(proveedor);
        }
        
        if(controlarUsuario.validarDatosUsuario()){
            System.out.println("Ya existe el usuario");
        }else{
            setVisible(false);
            controlarUsuario.guardarUsuario();
            nicknameText.setText("");
            emailText.setText("");
            fNacText.setText("");
            apellidoText.setText("");
            nombreText.setText("");
            nombreCompaniaText.setText("");
            linkSitioText.setText("");
        }
    }

    private void cancelar(ActionEvent evt) {
        setVisible(false);
        nicknameText.setText("");
        emailText.setText("");
        fNacText.setText("");
        apellidoText.setText("");
        nombreText.setText("");
        nombreCompaniaText.setText("");
        linkSitioText.setText("");
    }

}
