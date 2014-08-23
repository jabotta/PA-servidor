/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.Clases;

import java.time.Clock;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author rodro
 */
public class Main {
    
    
        public static void main(String args[]) {
                Map<Integer,String> s =Collections.synchronizedMap(new HashMap());
                s.put(1, "s");
                s.put(1, "t");
                s.put(2, "s");
                s.put(3, "s");
                System.out.println(s);
                
        }
}
