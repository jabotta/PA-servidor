package Vista;

import Controlador.Clases.IControladorProductos;
import Controlador.DataTypes.DataCategoria;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class RegistrarCategoriaForm extends JPanel {

    private final JLabel padre;
    private final JLabel nombre;
    private final JTextField padreText;
    private final JTextField nombreText;
    private final JButton guardarBtn;
    private final JButton cancelarBtn;
    private final IControladorProductos controladorProducto;

    public RegistrarCategoriaForm(IControladorProductos ICP) {
        
        controladorProducto = ICP;
        
        setLayout(null);
        
        padre = new JLabel("Padre");
        padre.setVisible(true);
        padre.setBounds(0, 60, 150, 10);
        add(padre);

        padreText = new JTextField();
        padreText.setBounds(150, 50, 300, 30);
        add(padreText);

        nombre = new JLabel("Nombre");
        nombre.setVisible(true);
        nombre.setBounds(0, 90, 150, 10);
        add(nombre);

        nombreText = new JTextField();
        nombreText.setBounds(150, 80, 300, 30);
        add(nombreText);

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
        add(guardarBtn);
        add(cancelarBtn);
    }

    private void guardarCategoria(ActionEvent evt) {
        String padre = padreText.getText();
        String nombre = nombreText.getText();
        
        DataCategoria categoria;
        if(padre.equals("")){
            categoria = new DataCategoria(nombre, null);
        }else{
            DataCategoria dataPadre = controladorProducto.elegirCategoriaPadre(padre);
            categoria = new DataCategoria(nombre, dataPadre);
        }
        
        controladorProducto.ingresarDatosCategoria(categoria);
        
        controladorProducto.guardarCategoria();
        setVisible(false);
        padreText.setText("");
        nombreText.setText("");
    }

    private void cancelar(ActionEvent evt) {
        setVisible(false);
        padreText.setText("");
        nombreText.setText("");
    }

}
