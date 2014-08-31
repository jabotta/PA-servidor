/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Clases.Categoria;
import Controlador.Clases.ManejadorCategorias;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author rodro
 */
class ElegirCategoriaComponente extends JPanel {

    private final DefaultMutableTreeNode node;
    private ArrayList categoriasAgregadas;
    private static Comparator<NodoCategoria> comp = new Comparator<NodoCategoria>() {

        @Override
        public int compare(NodoCategoria o1, NodoCategoria o2) {

            return o1.nombre.compareTo(o2.nombre);

        }
    };

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
     *
     */
    private void buildTree() {

        categoriasAgregadas = new ArrayList();

        ManejadorCategorias.getInstance().obtenerCategorias().entrySet().forEach((categoria) -> {

            Categoria auxDeBusqueda = categoria.getValue();
            NodoCategoria auxHuerfana = null;
            Boolean padresAgregados = false;

            while (!padresAgregados) {
                System.out.println("cname " + auxDeBusqueda.getNombre());
                if (!auxDeBusqueda.tienePadre()) {
                    System.out.println("es padre ");
                    NodoCategoria nodoRaiz = new NodoCategoria(auxDeBusqueda.getNombre());
                    System.out.println("es huefano " + String.valueOf(auxHuerfana != null));
                    if (auxHuerfana != null) {
                        nodoRaiz.addHijo(auxHuerfana);
                    }

                    if (!categoriasAgregadas.contains(nodoRaiz)) {

                        categoriasAgregadas.add(nodoRaiz);

                    }
                    auxHuerfana = null;
                    padresAgregados = true;

                } else {
                    NodoCategoria encontrado = getPadre(auxDeBusqueda.getPadre().getNombre());

                    System.out.println(" encontrado " + String.valueOf(encontrado != null));
                    if (encontrado != null) {
                        padresAgregados = true;
                        NodoCategoria newNodo = new NodoCategoria(auxDeBusqueda.getNombre());
                        if (encontrado.find(auxDeBusqueda.getNombre()) == null) {
                            encontrado.addHijo(newNodo);
                        }

                    } else {

                        NodoCategoria padre = new NodoCategoria(auxDeBusqueda.getPadre().getNombre());
                        System.out.println("  " + auxDeBusqueda.getPadre().getNombre());
                        padre.addHijo(new NodoCategoria(auxDeBusqueda.getNombre()));
                        if (auxDeBusqueda.getPadre().tienePadre()) {
                            auxDeBusqueda = auxDeBusqueda.getPadre().getPadre();
                            auxHuerfana = padre;
                        } else {
                            categoriasAgregadas.add(padre);
                            padresAgregados = true;
                        }
                    }
                }
            }

        });

        categoriasAgregadas.sort(ElegirCategoriaComponente.comp);
        for (Iterator<NodoCategoria> it = categoriasAgregadas.iterator(); it.hasNext();) {
            NodoCategoria current = it.next();
            node.add(current.getSubTree());
        }
    }

    public NodoCategoria getPadre(String padre) {
        Boolean found = false;
        NodoCategoria encontrado = null;
        for (Iterator<NodoCategoria> it = categoriasAgregadas.iterator(); it.hasNext() && !found;) {
            NodoCategoria current = it.next();

            encontrado = current.find(padre);

            found = encontrado != null;
        }
        return encontrado;
    }

    public class NodoCategoria {

        public ArrayList<NodoCategoria> hijos;
        public String nombre;

        public NodoCategoria(String nombre) {
            this.hijos = new ArrayList();
            this.nombre = nombre;

        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 71 * hash + Objects.hashCode(this.nombre);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final NodoCategoria other = (NodoCategoria) obj;
            if (!Objects.equals(this.nombre, other.nombre)) {
                return false;
            }
            return true;
        }

        public void addHijo(NodoCategoria h) {

            this.hijos.add(h);
            //   hijos.sort(ElegirCategoriaComponente.comp);
        }

        public NodoCategoria find(String nombre) {
            NodoCategoria encontrado = null;
            if (this.nombre.equals(nombre)) {
                return this;

            } else {
                for (Iterator<NodoCategoria> it = hijos.iterator(); it.hasNext() && encontrado == null;) {
                    NodoCategoria current = it.next();
                    encontrado = current.find(nombre);
                }
            }
            return encontrado;
        }

        public DefaultMutableTreeNode getSubTree() {
            DefaultMutableTreeNode firstNode = new DefaultMutableTreeNode(this.nombre);
            for (Iterator<NodoCategoria> it = hijos.iterator(); it.hasNext();) {
                NodoCategoria current = it.next();
                firstNode.add(current.getSubTree());
            }
            return firstNode;
        }

    }
}
