/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Clases.Categoria;
import Controlador.Clases.ManejadorCategorias;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author rodro
 */
class ElegirCategoriaComponente extends JPanel {

    private final DefaultMutableTreeNode node;

    public ElegirCategoriaComponente() {

        node = new DefaultMutableTreeNode("Categorias");
        JTree tree = new JTree(node);
        buildTree();
        add(tree);
        setSize(400, 400);
    }
    /**
     * 
     * @TODO: Este algoritmo es una caca
     * 
     **/
    private void buildTree() {
               
        ArrayList<NodoCategoria> categoriasAgregadas = new ArrayList();

        ManejadorCategorias.getInstance().obtenerCategorias().entrySet().forEach((categoria) -> {

            Categoria cat = categoria.getValue();
            if (!cat.tienePadre()) { 
                
                categoriasAgregadas.add(new NodoCategoria(cat.getNombre()));
            
            } else {
                Boolean found = false;
                NodoCategoria encontrado = null;
                for (Iterator<NodoCategoria> it = categoriasAgregadas.iterator(); it.hasNext() && found;) {
                    NodoCategoria current = it.next();
                    encontrado = current.find(cat.getPadre().getNombre());
                    found = encontrado != null;
                }
                if (found) {

                    encontrado.addHijo(new NodoCategoria(cat.getNombre()));
                }
            }
        });
        
        for (Iterator<NodoCategoria> it = categoriasAgregadas.iterator(); it.hasNext();) {
                    NodoCategoria current = it.next();
                    node.add(current.getSubTree());
        }
    }

    public class NodoCategoria {

        public ArrayList<NodoCategoria> hijos;
        public String nombre;

        public NodoCategoria(String nombre) {

            this.nombre = nombre;
        }

        public void addHijo(NodoCategoria h) {

            if (this.hijos == null) {
                this.hijos = new ArrayList();

            }
            this.hijos.add(h);
        }

        public NodoCategoria find(String nombre) {

            if (this.nombre.equals(nombre)) {
                return this;

            } else {
                for (Iterator<NodoCategoria> it = hijos.iterator(); it.hasNext();) {
                    NodoCategoria current = it.next();
                    return current.find(nombre);
                }
            }
            return null;
        }
        
        public DefaultMutableTreeNode getSubTree(){
            DefaultMutableTreeNode firstNode = new DefaultMutableTreeNode(this.nombre);
            for (Iterator<NodoCategoria> it = hijos.iterator(); it.hasNext();) {
                    NodoCategoria current = it.next();
                    firstNode.add(current.getSubTree());
            }
            return firstNode;
        }
    }
}
