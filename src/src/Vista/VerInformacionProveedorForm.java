package Vista;

import Controlador.Clases.IControladorUsuarios;
import Controlador.Clases.ManejadorUsuarios;
import Controlador.Clases.Utils;
import Controlador.DataTypes.DataProveedor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class VerInformacionProveedorForm extends JInternalFrame {

    private final JPanel contenedor;
    private final JList<String> userList;
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
    private final JButton cerrarBtn;
    private final IControladorUsuarios controlarUsuario;

    private Object imagen;

    public VerInformacionProveedorForm(IControladorUsuarios ICU) {

        controlarUsuario = ICU;

        setBounds(50, 50, 700, 400);
        setVisible(true);
        setLayout(null);
        contenedor = new JPanel();
        contenedor.setLayout(null);
        contenedor.setSize(700, 400);
        contenedor.setLocation(10, 0);
        add(contenedor);

        JLabel elegirUsuarioLabel = new JLabel("Elegir Proveedor:");
        elegirUsuarioLabel.setVisible(true);
        elegirUsuarioLabel.setBounds(0, 10, 150, 20);
        contenedor.add(elegirUsuarioLabel);

        DefaultListModel<String> tes = new DefaultListModel<String>();
        ArrayList<DataProveedor> clientes = ICU.listarProveedores();
        clientes.stream().forEach((proveedor) -> {
            tes.addElement(proveedor.getNickname() + " - "+ proveedor.getNombre() + " " + proveedor.getApellido());
        });
        userList = new JList<String>(tes);
        userList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        userList.setBounds(0, 50, 200, 300);
        userList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                DataProveedor aux = new DataProveedor(ManejadorUsuarios.getInstance().obtenerProveedores().get(userList.getSelectedValue().split("-")[0].trim()));
                nicknameText.setText(aux.getNickname());
                emailText.setText(aux.getEmail());
                fNacText.setText(Utils.formatDate(aux.getFechaNacimiento()));

                apellidoText.setText(aux.getApellido());
                nombreText.setText(aux.getNombre());
                nombreCompaniaText.setText(aux.getNombreCompania());
                linkSitioText.setText(aux.getLinkSitio());
                imagen = aux.getImagenes();

            }
        });

        JButton verimagen = new JButton("Ver Imagen");
        verimagen.setSize(100, 40);
        verimagen.setLocation(370, 0);
        verimagen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ver(e);
            }

        });

        contenedor.add(verimagen);
        contenedor.add(userList);

        nickname = new JLabel("Nickname");
        nickname.setVisible(true);
        nickname.setBounds(220, 60, 150, 10);
        contenedor.add(nickname);

        nicknameText = new JTextField();
        nicknameText.setBounds(370, 50, 300, 30);
        contenedor.add(nicknameText);

        nombre = new JLabel("Nombre");
        nombre.setVisible(true);
        nombre.setBounds(220, 90, 150, 10);
        contenedor.add(nombre);

        nombreText = new JTextField();
        nombreText.setBounds(370, 80, 300, 30);
        contenedor.add(nombreText);

        apellido = new JLabel("Apellido");
        apellido.setVisible(true);
        apellido.setBounds(220, 120, 150, 10);
        contenedor.add(apellido);

        apellidoText = new JTextField();
        apellidoText.setBounds(370, 110, 300, 30);
        contenedor.add(apellidoText);

        fNac = new JLabel("Fecha de nacimiento");
        fNac.setVisible(true);
        fNac.setBounds(220, 150, 150, 10);
        contenedor.add(fNac);

        fNacText = new JTextField();

        fNacText.setBounds(370, 140, 300, 30);
        contenedor.add(fNacText);

        email = new JLabel("Correo electronico");
        email.setVisible(true);
        email.setBounds(220, 180, 150, 10);
        contenedor.add(email);

        emailText = new JTextField();
        emailText.setBounds(370, 170, 300, 30);
        contenedor.add(emailText);

        nombreCompania = new JLabel("Nombre Compania");
        nombreCompania.setVisible(true);
        nombreCompania.setBounds(220, 205, 150, 15);
        contenedor.add(nombreCompania);

        nombreCompaniaText = new JTextField();
        nombreCompaniaText.setBounds(370, 200, 300, 30);
        nombreCompaniaText.setVisible(true);
        contenedor.add(nombreCompaniaText);

        linkSitio = new JLabel("Link Sitio");
        linkSitio.setVisible(true);
        linkSitio.setBounds(220, 240, 150, 10);
        contenedor.add(linkSitio);

        linkSitioText = new JTextField();
        linkSitioText.setBounds(370, 230, 300, 30);
        linkSitioText.setVisible(true);
        contenedor.add(linkSitioText);

        cerrarBtn = new JButton("Cerrar");

        cerrarBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrar(e);
            }
        });

        cerrarBtn.setBounds(320, 260, 100, 40);
        contenedor.add(cerrarBtn);
        nicknameText.setEnabled(false);
        emailText.setEnabled(false);
        fNacText.setEnabled(false);
        apellidoText.setEnabled(false);
        nombreText.setEnabled(false);
        nombreCompaniaText.setEnabled(false);
        linkSitioText.setEnabled(false);
    }

    private void ver(ActionEvent e) {
        JDialog dialog = new JDialog();
        if (imagen != null) {
            File f = new File((String) imagen);

            dialog.setTitle("Visor Imagenes" + f.getName());

            ImagePanel p = new ImagePanel(f.getAbsolutePath());
            p.setSize(400, 400);
            dialog.getContentPane().setSize(400, 400);
            dialog.getContentPane().add(p, BorderLayout.CENTER);
            dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            dialog.setSize(new Dimension(400, 400));
            dialog.setLocationRelativeTo(getParent().getParent().getParent());
            dialog.setModal(true);
            dialog.setVisible(true);

            dialog.setSize(new Dimension(500, 500));
        }
    }

    private void cerrar(ActionEvent evt) {
        setVisible(false);
        nicknameText.setText("");
        emailText.setText("");
        fNacText.setText(Utils.formatDate(new Date()));
        apellidoText.setText("");
        nombreText.setText("");
        nombreCompaniaText.setText("");
        linkSitioText.setText("");
    }

}
