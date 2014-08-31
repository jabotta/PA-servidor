/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Clases;

import java.util.Date;

/**
 *
 * @author rodro
 */
public class Utils {

    public static void generarProveedoresDePrueba() {
        ManejadorUsuarios.getInstance().agregarUsuario(new Proveedor("prov1", "Proveedor 1", "", "prov1@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));
        ManejadorUsuarios.getInstance().agregarUsuario(new Proveedor("prov2", "Proveedor 2", "", "prov2@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));
        ManejadorUsuarios.getInstance().agregarUsuario(new Proveedor("prov3", "Proveedor 3", "", "prov3@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));

    }

    public static void generarCategoriasDePrueba() {
        Categoria c = new Categoria("cat1", null);
        Categoria c2 = new Categoria("cat2", null);
        Categoria ultimopaenganchar = null;
        ManejadorCategorias.getInstance().agregarCategoria(c);

        ManejadorCategorias.getInstance().agregarCategoria(c2);
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("cat3", null));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("cat4", null));

        for (int i = 0; i < 1; i++) {
            ultimopaenganchar = new Categoria("a" + (i + 10), c);
            ManejadorCategorias.getInstance().agregarCategoria(ultimopaenganchar);

        }
        for (int i = 0; i < 4; i++) {
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("ab" + (i + 10), c2));

        }
        Categoria ultimop2 = null;
        for (int i = 0; i < 1; i++) {
            ultimop2 = new Categoria("b" + (i + 10), ultimopaenganchar);
            ManejadorCategorias.getInstance().agregarCategoria(ultimop2);

        }
        for (int i = 0; i < 1; i++) {
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("c" + (i + 10), ultimop2));

        }
    }

    public static String formatString(String s) {

        if (s != null) {

            return s.trim();
        }
        return "";
    }
    /**
     * *
     *
     * DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); Date
     * date = new Date();
     */
}
