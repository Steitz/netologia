package ru.netology.graphics.image;

import java.util.ArrayList;
import java.util.List;

public class MyColorShema implements TextColorSchema {
    final int MAX_COLOR = 255;
    final char[] symbol = {'#', '$', '@', '%', '*', '+', '-', ' '};

    public char convert(int color) {
        int i = color * symbol.length / (MAX_COLOR + 1);
        return symbol[i];
    }
}
