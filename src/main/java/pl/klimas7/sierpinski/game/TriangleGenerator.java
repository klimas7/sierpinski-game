package pl.klimas7.sierpinski.game;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Random;

@Slf4j
@Component
public class TriangleGenerator {
    private final Random random = new Random();
    private final CalculatePoint calculatePoint;

    public TriangleGenerator(CalculatePoint calculatePoint) {
        this.calculatePoint = calculatePoint;
    }

    public BitSet generate(int steps, int factor) {
        log.info("Start generate");
        var area = new BitSet(factor * factor);

        var index = random.nextInt(factor * factor) - 1;

        area.set(index);
        for (int i = 0; i < steps; i++) {
           var vertex = Vertex.getRandom();
           index = calculatePoint.calculateNewIndex(index, vertex, factor);
           area.set(index);
        }
        log.info("Stop generate");
        return area;
    }
}
