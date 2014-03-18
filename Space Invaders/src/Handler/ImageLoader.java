/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author pearl
 */
public class ImageLoader {

    public static BufferedImage playerI = load("/Object/space1.png");
    public static BufferedImage bg = load("/Background/Background.jpg");
    public static BufferedImage BulletI = load("/Object/fireball.gif");
    public static BufferedImage healthI = load("/Object/health.png");
    public static BufferedImage scoreI = load("/Object/coin.png");
    public static BufferedImage enemyI = load("/Object/player_detailed_raw.png");
    public static BufferedImage text_r_14 = load("/Object/text-14.png");
    public static BufferedImage text_w_14 = load("/Object/text-w-14.png");
    public static BufferedImage logo = load("/Object/batman-logo-white.png");
    
    private static BufferedImage load(String s) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(ImageLoader.class.getResourceAsStream(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
