/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataTypes;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ethan
 */
public class User {
    private String name;
    private String textSize;
    private String color;
    private String bgColor;

    public User() {
        this.name = null;
        this.textSize = null;
        this.color = null;
        this.bgColor = null;
    }    

    public User(String name) {
        this.name = name;
        this.textSize = null;
        this.color = null;
        this.bgColor = null;
    }
    
    @Override
    public boolean equals(Object userObj) {
        if(userObj.getClass() == this.getClass()) {
            User user = (User) userObj;
            if( user.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
        return hash;
    }

    public synchronized void update(HttpServletRequest request) {
        textSize =  request.getParameter("formTextSize") != null ? request.getParameter("formTextSize") : textSize;
        color =  request.getParameter("formColor") != null ? request.getParameter("formColor") : color;        
        bgColor =  request.getParameter("formBgColor") != null ? request.getParameter("formBgColor") : bgColor;
    }

    public String getName() {
        return name;
    }

    public String getTextSize() {
        return textSize;
    }

    public String getColor() {
        return color;
    }

    public String getBgColor() {
        return bgColor;
    }
    
    
}
