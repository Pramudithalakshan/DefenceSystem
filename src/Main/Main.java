/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import controller.Controller;
import view.MainController;

/**
 *
 * @author pramuditha-lakshan
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        FlatCarbonIJTheme.setup();
        new MainController(controller).setVisible(true);
    }
    
}
