package pl.klimas7.sierpinski.game;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.BitSet;

@Slf4j
@Component
public class ImageGenerator {
    public void generate(BitSet area, int factor) throws IOException {
        log.info("Start generate image");
        BufferedImage img = new BufferedImage(factor, factor, BufferedImage.TYPE_BYTE_BINARY);

        for (int x = 0; x < factor; x++) {
            for (int y = 0; y < factor; y++) {
                var index = y * factor + x;
                var isSet = area.get(index);
                img.setRGB(x, y, isSet ? 0 : 0xffffff);
            }
        }

        ImageIO.write(img, "bmp", new File("test.bmp"));
        log.info("Stop generate image");
    }
}
