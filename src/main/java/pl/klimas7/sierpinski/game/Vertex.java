package pl.klimas7.sierpinski.game;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
public enum Vertex {
    ZERO(0, 1),
    ONE(2, 0),
    TWO(1, 1);

    private final int x_divide_factor;
    private final int y_divide_factor;

    public static Vertex getRandom() {
        return values()[new Random().nextInt(3)];
    }

    public int x_divide_factor(int factor) {
        return x_divide_factor == 0 ? 0 : factor / x_divide_factor ;
    }

    public int y_divide_factor(int factor) {
        return y_divide_factor == 0 ? 0 : factor / y_divide_factor ;
    }
}
