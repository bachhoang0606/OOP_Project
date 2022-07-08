/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameSetting;

import java.util.Comparator;

import Graphics.DrawVatThe;
/**
 *
 * @author HOANG XUAN BACH
 */
public class EntityComparator implements Comparator<DrawVatThe> {

    @Override
    public int compare(DrawVatThe sv1, DrawVatThe sv2) {
                
        int result = Integer.compare(sv1.getWorldY(), sv2.getWorldY());
        return result;
    }
    
}
