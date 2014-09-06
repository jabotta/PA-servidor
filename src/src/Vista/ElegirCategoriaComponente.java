/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Clases.Constantes;
import Controlador.Clases.IControladorProductos;
import Controlador.DataTypes.DataCategoria;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

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
    private final ArrayList<String> selectedCategorias;
    private final IControladorProductos cotrolador;
    private final JTree tree;

    public ElegirCategoriaComponente(IControladorProductos controlador, Boolean ultimaCategoria) {
        this.cotrolador = controlador;
        selectedCategorias = new ArrayList();
        node = new DefaultMutableTreeNode(Constantes.CATEGORIA_ROOT);
         tree = new JTree(node);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
        TreeSelectionListener myTreeListener;
        myTreeListener = new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                for (int i = 0; i < e.getPaths().length; i++) {
//                    System.out.println(e.getPaths()[i]);
                    if (e.isAddedPath(e.getPaths()[i])) {

                        if (ultimaCategoria) {

                            selectedCategorias.add(e.getPath().getLastPathComponent().toString().trim());
                        } else {
                            for (int j = 0; j < e.getPaths()[i].getPathCount(); j++) {
                                //if(!selectedCategorias.contains((e.getPaths()[i]).getPathComponent(j).toString()))
                                selectedCategorias.add((e.getPaths()[i]).getPathComponent(j).toString().trim());
                            }
                        }
                    } else {
                        for (int j = 0; j < e.getPaths()[i].getPathCount(); j++) {
                            selectedCategorias.remove((e.getPaths()[i]).getPathComponent(j).toString().trim());
                        }
                    }
                }
                // System.out.println("--"+getSelectedCategories());
            }

        };
        tree.addTreeSelectionListener(myTreeListener);

        buildTree();
        add(tree);
        setSize(400, 400);
    }

    public HashSet<String> getSelectedCategories() {
        HashSet<String> r = new HashSet();
        r.addAll(selectedCategorias);
        r.remove(Constantes.CATEGORIA_ROOT);
        return r;
    }

    /**
     *
     * @TODO: Este algoritmo es una caca
     *
     *
     */
    private void buildTree() {

        categoriasAgregadas = new ArrayList();

        cotrolador.listarCategorias().forEach((categoria) -> {

            DataCategoria auxDeBusqueda = categoria;
            NodoCategoria auxHuerfana = null;
            Boolean padresAgregados = false;

            while (!padresAgregados) {

                if (!auxDeBusqueda.tienePadre()) {

                    NodoCategoria nodoRaiz = new NodoCategoria(auxDeBusqueda.getNombre());
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

                    if (encontrado != null) {
                        padresAgregados = true;
                        NodoCategoria newNodo = new NodoCategoria(auxDeBusqueda.getNombre());
                        if (encontrado.find(auxDeBusqueda.getNombre()) == null) {
                            encontrado.addHijo(newNodo);
                        }

                    } else {

                        NodoCategoria padre = new NodoCategoria(auxDeBusqueda.getPadre().getNombre());
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
        for (Iterator<NodoCategoria> it = (Iterator<NodoCategoria>)categoriasAgregadas.iterator(); it.hasNext();) {
            NodoCategoria current = it.next();
            node.add(current.getSubTree());
        }
   
    }
   
    public NodoCategoria getPadre(String padre) {
        Boolean found = false;
        NodoCategoria encontrado = null;
        for (Iterator<NodoCategoria> it = (Iterator<NodoCategoria>)categoriasAgregadas.iterator(); it.hasNext() && !found;) {
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
            this.hijos = new ArrayList<ElegirCategoriaComponente.NodoCategoria>();
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
            hijos.sort(ElegirCategoriaComponente.comp);
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
