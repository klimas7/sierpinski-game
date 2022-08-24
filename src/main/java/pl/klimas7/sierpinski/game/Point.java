package pl.klimas7.sierpinski.game;

import lombok.Getter;

@Getter
public class Point {
    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public static Point createFromIndex(final int index, final int factor) {
        var y = index / factor;
        var x = index - (y * factor);
        return new Point(x, y);
    }

    public int convertToIndex(final int factor) {
        return (factor * y + x);
    }

    public Point calculateCenter(final Vertex vertex, final int factor) {
        int x = (this.x + vertex.x_divide_factor(factor)) >> 1;
        int y = (this.y + vertex.y_divide_factor(factor)) >> 1;
        return new Point(x, y);
    }
}
