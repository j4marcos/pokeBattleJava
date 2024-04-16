import java.io.File;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class DefinirFonte {
    public static Font fonte() {
        Font Fonte;
        try {
            Fonte = Font.createFont(Font.TRUETYPE_FONT, new File("assets/font/pokemon_fire_red.ttf"));
            return Fonte;
        
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return Fonte = new Font("Arial", Font.PLAIN, 16);
        }
    }
}
