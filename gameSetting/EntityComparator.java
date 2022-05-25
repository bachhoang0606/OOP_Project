/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameSetting;

import java.util.Comparator;
import object.OriginObject;

/**
 *
 * @author HOANG XUAN BACH
 */
public class EntityComparator implements Comparator<OriginObject> {

    @Override
    public int compare(OriginObject sv1, OriginObject sv2) {
                
        int result = Integer.compare(sv1.getWorldY(), sv2.getWorldY());
        return result;
    }
    
}
