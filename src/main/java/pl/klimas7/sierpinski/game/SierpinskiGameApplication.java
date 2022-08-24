package pl.klimas7.sierpinski.game;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SierpinskiGameApplication implements CommandLineRunner {

    private final TriangleGenerator triangleGenerator;
    private final ImageGenerator imageGenerator;

    public SierpinskiGameApplication(TriangleGenerator triangleGenerator, ImageGenerator imageGenerator) {
        this.triangleGenerator = triangleGenerator;
        this.imageGenerator = imageGenerator;
    }

    public static void main(String[] args) {
        SpringApplication.run(SierpinskiGameApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var steps = 5_000_000;
        var factor = 6_000;
        var area = triangleGenerator.generate(steps, factor);
        imageGenerator.generate(area, factor);
    }
}
