/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.util.EventListener;

/**
 *
 * @author rodro
 */
public interface NotifyEventListener extends EventListener{
    public void notifyEvent(NotifyEvent evt);
}
