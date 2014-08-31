/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.util.EventObject;

/**
 *
 * @author rodro
 */
public class NotifyEvent extends EventObject{
    private final Object target;
    
    public NotifyEvent(Object source) {
        super(source);
        this.target = source;
    }
    public Object getTarget(){
        return this.target;
    }
}
