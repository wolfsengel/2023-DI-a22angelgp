/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JButtonColorChallenger;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

public class JButtonCPropertyEditorSupport extends PropertyEditorSupport {

    private final JButtonFondoPanel buttonColon = new JButtonFondoPanel();

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return buttonColon;
    }

    @Override
    public String getJavaInitializationString() {
        JButtonColorado imaxeFondo = buttonColon.getSelectedValue();
        return "new JButtonColorChallenger.JButtonColorado(new java.awt.Color("
                + imaxeFondo.getFondo().getGreen() + "," + imaxeFondo.getFondo().getBlue() + "," + imaxeFondo.getFondo().getRed()
                + "),new java.awt.Color("
                + imaxeFondo.getLetra().getGreen() + "," + imaxeFondo.getLetra().getBlue() + "," + imaxeFondo.getLetra().getRed()
                + "))";
    }

    @Override
    public Object getValue() {
        return buttonColon.getSelectedValue();
    }
}
