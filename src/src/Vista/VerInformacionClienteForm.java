package Vista;

import Controlador.Clases.Cliente;
import Controlador.Clases.IControladorUsuarios;
import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataProveedor;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class VerInformacionClienteForm extends JInternalFrame {
    
    private final JPanel contenedor ;
    private final JList userList;
    private final JLabel nickname;
    private final JLabel nombre;
    private final JLabel apellido;
    private final JLabel fNac;
    private final JLabel email;
    private final JTextField nicknameText;
    private final JTextField emailText;
    private final JCalendar fNacText;
    private final JTextField apellidoText;
    private final JTextField nombreText;
    private final JButton cerrarBtn;
    private final IControladorUsuarios controlarUsuario;
    private final JDayChooser as;
    
    public VerInformacionClienteForm(IControladorUsuarios ICU) {
        
        controlarUsuario = ICU;
        
        setBounds(50, 50, 700, 400);
        setVisible(true);
        setLayout(null);
        contenedor = new JPanel();
        contenedor.setLayout(null);
        contenedor.setSize(700, 400);
        contenedor.setLocation(10, 0);
        add(contenedor);
        
        JLabel elegirUsuarioLabel = new JLabel("Elegir Cliente:");
        elegirUsuarioLabel.setVisible(true);
        elegirUsuarioLabel.setBounds(0, 10, 150, 20);
        contenedor.add(elegirUsuarioLabel);

        DefaultListModel tes = new DefaultListModel();
        ArrayList<DataCliente> clientes = ICU.listarClientes();
        clientes.stream().forEach((cliente) -> {
            tes.addElement(cliente);
        });
        userList = new JList(tes);
        userList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        userList.setBounds(0, 50, 200, 300);
        userList.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent evt){
                if(evt.getValueIsAdjusting())
                    return;
                DataCliente aux = (DataCliente)userList.getSelectedValue();
                nicknameText.setText(aux.getNickname());
                emailText.setText(aux.getEmail());
                fNacText.setDate(aux.getFechaNacimiento());
                apellidoText.setText(aux.getApellido());
                nombreText.setText(aux.getNombre());
                
            }
        });
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
        as = new JDayChooser();
                
        fNacText = new JCalendar();
         
        fNacText.setBounds(370, 140, 300, 30);
        contenedor.add(fNacText);

        email = new JLabel("Correo electronico");
        email.setVisible(true);
        email.setBounds(220, 180, 150, 10);
        contenedor.add(email);

        emailText = new JTextField();
        emailText.setBounds(370, 170, 300, 30);
        contenedor.add(emailText);

        cerrarBtn = new JButton("Cerrar");


        cerrarBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrar(e);
            }
        });

        cerrarBtn.setBounds(320, 260, 100, 40);
        contenedor.add(cerrarBtn);
    }

    private void cerrar(ActionEvent evt) {
        setVisible(false);
        nicknameText.setText("");
        emailText.setText("");
        fNacText.setDate(new Date());
        apellidoText.setText("");
        nombreText.setText("");
    }
    

}
