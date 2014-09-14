/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.sun.media.sound.EmergencySoundbank;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author rodro
 */
public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    public ImagePanel() {

    }

    public void cleanIMG() {
        image = null;
    }

    public void loadImg(String path) {

        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            System.out.println(getWidth() + " " + getHeight());

            g.drawImage(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT), 0, 0, null); // see javadoc for more info on the parameters            
        }
    }

}
