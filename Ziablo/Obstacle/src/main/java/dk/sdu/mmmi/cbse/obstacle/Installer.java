/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.obstacle;

import org.openide.modules.ModuleInstall;

/**
 *
 * @author Sadik
 */
public class Installer extends ModuleInstall{
    @Override
    public void restored(){
        System.out.println("HELLOOOO FROM OBSTACLE INSTALLER");
    }
    
    @Override
    public void uninstalled(){
        
    }
}