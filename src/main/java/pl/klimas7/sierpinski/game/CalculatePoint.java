package pl.klimas7.sierpinski.game;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CalculatePoint {
    public int calculateNewIndex(int index, Vertex vertex, final int factor) {
        var point = Point.createFromIndex(index, factor);
        var center = point.calculateCenter(vertex, factor);
        return center.convertToIndex(factor);
    }
}
