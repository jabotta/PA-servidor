package Vista;

import Controlador.Clases.IControladorUsuarios;
import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataProveedor;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.datatype.DatatypeConstants;

class RegistrarUsuarioForm extends JInternalFrame {

    private final JPanel contenedor;
    private final JLabel nickname;
    private final JLabel nombre;
    private final JLabel apellido;
    private final JLabel fNac;
    private final JLabel email;
    private final JLabel nombreCompania;
    private final JLabel linkSitio;
    private final JTextField nicknameText;
    private final JTextField emailText;
    private final JCalendar fNacText;
    private final JTextField apellidoText;
    private final JTextField nombreText;
    private final JTextField nombreCompaniaText;
    private final JTextField linkSitioText;
    private final JButton guardarBtn;
    private final JButton cancelarBtn;
    private final JCheckBox esProveedor;
    private final IControladorUsuarios controlarUsuario;
    private final JDayChooser as;
    private final SelectorDeImagenes sdi;

    public RegistrarUsuarioForm(IControladorUsuarios ICU) {

        controlarUsuario = ICU;

        setBounds(50, 50, 900, 400);
        setVisible(true);
        setLayout(null);
        contenedor = new JPanel();
        contenedor.setLayout(null);
        contenedor.setSize(1200, 400);
        contenedor.setLocation(10, 0);
        add(contenedor);

        JLabel proveedorlabel = new JLabel("Es proovedor?:");
        proveedorlabel.setVisible(true);
        proveedorlabel.setBounds(0, 10, 150, 20);
        contenedor.add(proveedorlabel);

        esProveedor = new JCheckBox();
        esProveedor.setName("Elegir si el usuario es provedor");
        esProveedor.setLocation(100, 5);
        esProveedor.setSize(30, 30);
        esProveedor.setVisible(true);
        esProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cambiarTipoFormulario(evt);
            }

        });
        contenedor.add(esProveedor);

        nickname = new JLabel("Nickname");
        nickname.setVisible(true);
        nickname.setBounds(0, 60, 150, 10);
        contenedor.add(nickname);

        nicknameText = new JTextField();
        nicknameText.setBounds(150, 50, 300, 30);
        contenedor.add(nicknameText);

        nombre = new JLabel("Nombre");
        nombre.setVisible(true);
        nombre.setBounds(0, 90, 150, 10);
        contenedor.add(nombre);

        nombreText = new JTextField();
        nombreText.setBounds(150, 80, 300, 30);
        contenedor.add(nombreText);

        apellido = new JLabel("Apellido");
        apellido.setVisible(true);
        apellido.setBounds(0, 120, 150, 10);
        contenedor.add(apellido);

        apellidoText = new JTextField();
        apellidoText.setBounds(150, 110, 300, 30);
        contenedor.add(apellidoText);

        fNac = new JLabel("Fecha de nacimiento");
        fNac.setVisible(true);
        fNac.setBounds(0, 150, 150, 10);
        contenedor.add(fNac);
        as = new JDayChooser();

        fNacText = new JCalendar();

        fNacText.setBounds(150, 140, 300, 30);
        contenedor.add(fNacText);

        email = new JLabel("Correo electronico");
        email.setVisible(true);
        email.setBounds(0, 180, 150, 10);
        contenedor.add(email);

        emailText = new JTextField();
        emailText.setBounds(150, 170, 300, 30);
        contenedor.add(emailText);

        nombreCompania = new JLabel("Nombre Compania");
        nombreCompania.setVisible(false);
        nombreCompania.setBounds(0, 205, 150, 15);
        contenedor.add(nombreCompania);

        nombreCompaniaText = new JTextField();
        nombreCompaniaText.setBounds(150, 200, 300, 30);
        nombreCompaniaText.setVisible(false);
        contenedor.add(nombreCompaniaText);

        linkSitio = new JLabel("Link Sitio");
        linkSitio.setVisible(false);
        linkSitio.setBounds(0, 240, 150, 10);
        contenedor.add(linkSitio);

        linkSitioText = new JTextField();
        linkSitioText.setBounds(150, 230, 300, 30);
        linkSitioText.setVisible(false);
        contenedor.add(linkSitioText);

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

        sdi = new SelectorDeImagenes(true);
        sdi.setLocation(450, 0);
        contenedor.add(sdi);
        contenedor.add(guardarBtn);
        contenedor.add(cancelarBtn);
    }

    private void guardarUsuario(ActionEvent evt) {
        String nickname = nicknameText.getText();
        String email = emailText.getText();
        Date fnac = fNacText.getDate();
        String apellido = apellidoText.getText();
        String nombre = nombreText.getText();
        String nombreCompania = nombreCompaniaText.getText();
        String linkSitio = linkSitioText.getText();
        String imagen = "";
        HashSet<String> imagenes = this.sdi.getListaDeImagenes();
        Iterator it = imagenes.iterator();
        if (it.hasNext()) {
            imagen = (String) it.next();
        }
        if(nickname==null || nickname.isEmpty()){
            
            JOptionPane.showMessageDialog(this, "Nickname es requerido", "Validacion", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(email==null || email.isEmpty()){
        
            JOptionPane.showMessageDialog(this, "Email es requerido", "Validacion", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!esProveedor.isSelected()) {
            DataCliente cliente = new DataCliente(nickname, nombre, apellido, email, fnac);
            cliente.setImagenes(imagen);
            controlarUsuario.ingresarDatosCliente(cliente);
        } else {
            DataProveedor proveedor = new DataProveedor(nickname, nombre, apellido, email, fnac, nombreCompania, linkSitio);
            proveedor.setImagenes(imagen);
            controlarUsuario.ingresarDatosProveedor(proveedor);
        }

        if (controlarUsuario.validarDatosUsuario()) {
            JOptionPane.showMessageDialog(this, "Usiario con " + controlarUsuario.getErrors() + " ya existe", "Validacion", JOptionPane.ERROR_MESSAGE);

        } else {

            JOptionPane.showMessageDialog(this, "Su Usuario se creo correctamente", "Validacion", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            controlarUsuario.guardarUsuario();
            nicknameText.setText("");
            emailText.setText("");

            fNacText.setDate(new Date());
            apellidoText.setText("");
            nombreText.setText("");
            nombreCompaniaText.setText("");
            linkSitioText.setText("");

        };

    }

    private void cancelar(ActionEvent evt) {
        setVisible(false);
        nicknameText.setText("");
        emailText.setText("");
        fNacText.setDate(new Date());
        apellidoText.setText("");
        nombreText.setText("");
        nombreCompaniaText.setText("");
        linkSitioText.setText("");
    }

    private void cambiarTipoFormulario(ActionEvent evt) {

        Boolean display = esProveedor.isSelected();
        nombreCompania.setVisible(display);
        nombreCompaniaText.setVisible(display);
        linkSitio.setVisible(display);
        linkSitioText.setVisible(display);

    }

}
