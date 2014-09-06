package Vista;

import Controlador.Clases.IControladorProductos;
import Controlador.DataTypes.DataCategoria;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

class RegistrarCategoriaForm extends JInternalFrame {

    private final JPanel contenedor;
    private final JLabel nombre;
    private final JTextField nombreText;
    private final JButton guardarBtn;
    private final JButton cancelarBtn;
    private final IControladorProductos controladorProducto;
    private JDialog dialog;
    private final ElegirCategoriaComponente treePane;

    public RegistrarCategoriaForm(IControladorProductos ICP) {

        setBounds(50, 50, 700, 400);
        setVisible(true);
        setLayout(null);
        contenedor = new JPanel();
        contenedor.setLayout(null);
        contenedor.setSize(700, 400);
        contenedor.setLocation(10, 0);
        add(contenedor);

        controladorProducto = ICP;

        treePane = new ElegirCategoriaComponente(controladorProducto, true);
        JButton padre = new JButton("Elegir Categoria Padre");
        padre.setSize(100, 40);
        padre.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openDialog();
            }
        });
        padre.setBounds(150, 50, 300, 30);
        contenedor.add(padre);

        nombre = new JLabel("Nombre");
        nombre.setVisible(true);
        nombre.setBounds(0, 90, 150, 10);
        contenedor.add(nombre);

        nombreText = new JTextField();
        nombreText.setBounds(150, 80, 300, 30);
        contenedor.add(nombreText);

        guardarBtn = new JButton("Guardar");
        cancelarBtn = new JButton("Cancelar");

        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCategoria(e);
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
        contenedor.add(guardarBtn);
        contenedor.add(cancelarBtn);
    }

    private void openDialog() {
        dialog = new JDialog();
        dialog.setTitle("Elegir Categoria");

        JButton aceptarButton = new JButton("Listo!!");
        aceptarButton.setSize(80, 30);
        aceptarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();

            }
        });
        dialog.getContentPane().setSize(400, 400);
        dialog.getContentPane().add(treePane, BorderLayout.CENTER);
        dialog.getContentPane().add(aceptarButton, BorderLayout.SOUTH);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(new Dimension(400, 400));
        dialog.setLocationRelativeTo(this);
        dialog.setModal(true);
        dialog.setVisible(true);

    }

    private void guardarCategoria(ActionEvent evt) {
        String padre = null;
        Iterator<String> it = (Iterator<String>)treePane.getSelectedCategories().iterator();
        if (it.hasNext()) {

            padre = (String) it.next();
        }

        String nombre = nombreText.getText();
        if (controladorProducto.categoryAlreadyExist(nombre)) {
            JOptionPane.showMessageDialog(this, "La categoria '"+nombre+"' ya existe ", "Validacion", JOptionPane.ERROR_MESSAGE);

            return;
        }
        DataCategoria categoria;
        if (padre == null) {
            categoria = new DataCategoria(nombre, null);
        } else {
            DataCategoria dataPadre = controladorProducto.elegirCategoriaPadre(padre);
            categoria = new DataCategoria(nombre, dataPadre);
        }

        controladorProducto.ingresarDatosCategoria(categoria);
        controladorProducto.guardarCategoria();

        setVisible(false);
        nombreText.setText("");
    }

    private void cancelar(ActionEvent evt) {
        dispose();
    }

}
