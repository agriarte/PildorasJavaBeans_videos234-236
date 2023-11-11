/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misBeansCreados;

import java.awt.Dimension;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Pedro
 */
public class InclusionImagen extends JLabel {

    private File laImagen = null;

    public InclusionImagen() {
        setBorder(BorderFactory.createEtchedBorder());
    }

    public String getLaImagen() {
        // si la ruta es nula devuelve null y si no devuelve la ruta de la imagen
        // cuidado con los getters automaticos del IDE. Como "laImagen" es de tipo File, el IDE devuelve un 
        //objeto de tipo File pero queremos que devuelva un String. Se ha de cambiar.
        if (laImagen == null) {
            return null;
        } else {
            return laImagen.getPath();
        }
    }

    // este método sobreescrito no me aparece en el menú Generate, tuve que ponerlo manualmente
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    public void setLaImagen(String rutaImagen) {

        try {
            //laImagen es un objeto que contiene una imagen en la ruta "rutaimagen"
            laImagen = new File(rutaImagen);

            //Explicacion de la siguiente línea que contiene varias acciones anidadas:
            //ImageIO.read(laImagen)
            //lee una imagen y la carga en memoria como un objeto de tipo BufferedImage.
            //new ImageIcon(...)
            //Se crea un objeto ImageIcon que es una clase de Swing que se utiliza para representar imágenes y proporciona 
            //funcionalidad para mostrar esas imágenes en componentes Swing.
            //Finalmente, se llama al método setIcon en un componente Swing, como un JLabel, para establecer el icono (imagen) 
            //que se creó en el paso anterior como el contenido visual del componente. Esto significa que la imagen se mostrará 
            //en lugar del texto u otro contenido del componente.
            setIcon(new ImageIcon(ImageIO.read(laImagen)));
        } catch (Exception IO) {
            // en caso de error no hacer nada, valores a null.
            laImagen = null;
            setIcon(null);
        }
    }

}
