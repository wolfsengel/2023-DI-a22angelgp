/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JButtonColorChallenger;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

public class JButtonCPropertyEditorSupport extends PropertyEditorSupport {

    private final JButtonFondoPanel buttonColoreado = new JButtonFondoPanel();

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return buttonColoreado;
    }

    @Override
    public String getJavaInitializationString() {
        JButtonColorado imaxeFondo = buttonColoreado.getSelectedValue();
        return "new JButtonColorChallenger.JButtonColorado(" + "new java.awt.Color(\""
                + imaxeFondo.getFondo() + "\"), new java.awt.Color(" + imaxeFondo.getLetra()
                + "))";
    }

    @Override
    public Object getValue() {
        return buttonColoreado.getSelectedValue();
    }
}
