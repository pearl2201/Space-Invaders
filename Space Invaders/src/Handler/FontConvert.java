/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author pearl
 */
public class FontConvert {

    public static final String default_text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static BufferedImage[] default_text_image = new BufferedImage[default_text.length()];
    public static final BufferedImage text_r_14 = ImageLoader.text_r_14;
    public static final BufferedImage text_w_14 = ImageLoader.text_w_14;
    public static final int default_font_width = 12;
    public static final int default_font_height = 17;
    public static boolean red = true;

    public static BufferedImage convertString2Image(String s, boolean r) {
        s = s.toUpperCase();
        BufferedImage default_image = text_r_14;
        
        if (!r) {
            default_image = text_w_14;
        }

        BufferedImage image = new BufferedImage(s.length() * default_font_width, default_font_height, BufferedImage.TYPE_INT_ARGB);;
        Graphics2D g = (Graphics2D) image.getGraphics();
        for (int i = 0; i < s.length(); i++) {
            // Qua luoi de them dau cach vao anh =)) // I am so lazy to add " " to image :))   
            if (" ".equalsIgnoreCase(Character.toString(s.charAt(i)))) {
                g.drawImage(null, i * default_font_width, 0, default_font_width, default_font_height, null);

            } else if (g.drawImage(default_image.getSubimage(default_text.indexOf(s.charAt(i)) * default_font_width, 0, default_font_width, default_font_height), i * default_font_width, 0, default_font_width, default_font_height, null)) {
            }
        }

        g.dispose();
        return image;
    }

}
