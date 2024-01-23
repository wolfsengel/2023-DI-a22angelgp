package reloxo.dixital;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author a22ivancp
 */
public class JReloxo extends JLabel {

    private boolean formato24h = true; // Por defecto, formato de 24 horas

    public JReloxo() {
// Establecer propiedades del JLabel
        setHorizontalAlignment(JLabel.CENTER);
        setFont(new Font("Arial", Font.PLAIN, 20));

// Iniciar el hilo de actualización
        iniciarReloj();
    }

    private void iniciarReloj() {
        Thread hiloReloj = new Thread(() -> {
            while (true) {
// Obtener la hora actual en el formato especificado
                SimpleDateFormat formatoHora = new SimpleDateFormat(formato24h
                        ? "HH:mm:ss" : "hh:mm:ss a");
                String horaActual = formatoHora.format(new Date());

// Actualizar el texto del JLabel
                setText(horaActual);

// Esperar un segundo antes de la próxima actualización
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        hiloReloj.start();
    }

    public boolean isFormato24h() {
        return formato24h;
    }

    public void setFormato24h(boolean formato24h) {
        this.formato24h = formato24h;
    }
}
