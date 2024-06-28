package pertemuan11;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author LAB F
 * TGL: 2024-06-28
 */
public class loadIMG {
    
    public static BufferedImage loadImage(String img){
        BufferedImage bimg = null;
        try{
            bimg = ImageIO.read(new File(img));
        }catch(IOException e){
        }
        return bimg;
    }
    
}
