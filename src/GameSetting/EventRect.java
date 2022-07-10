/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameSetting;

import java.awt.Rectangle;

/**
 *
 * @author HOANG XUAN BACH
 */
public class EventRect extends Rectangle{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -1268981586957030979L;
	
	
	int eventRectDeufaultX, eventRectDeufaultY;
    boolean eventDone = false;

    public EventRect(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    
}
