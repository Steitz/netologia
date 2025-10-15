package ru.netology.graphics.image;

import org.w3c.dom.ls.LSOutput;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class MyConverter implements TextGraphicsConverter {
    protected int width;
    protected int height;
    protected int newWidth;
    protected int newHeight;
    protected int imgWidth;
    protected int imgHeight;
    protected double maxRatio;
    protected TextColorSchema schema;

    @Override
    public String convert(String url) throws IOException, BadImageSizeException {
        BufferedImage img = ImageIO.read(new URL(url));
        imgWidth = img.getWidth();
        imgHeight = img.getHeight();
        double ratio = (double) imgWidth / imgHeight;
        if (ratio > maxRatio) {
            throw new BadImageSizeException(ratio, maxRatio);
        }
        //проверим ширину
        changeSize(imgWidth, imgHeight, setScale(imgWidth, width));
        //проверим высоту после масштабирования по ширине
        changeSize(newWidth, newHeight, setScale(newHeight, height));
        Image scaledImage = img.getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_SMOOTH);

        BufferedImage bwImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D graphics = bwImg.createGraphics();
        graphics.drawImage(scaledImage, 0, 0, null);

        WritableRaster bwRaster = bwImg.getRaster();

        int[] gray = new int[3];
        String str = "";
        for (int h = 0; h < newHeight; h++) {
            for (int w = 0; w < newWidth; w++) {

                int col = bwRaster.getPixel(w, h, gray)[0];
                char c = schema.convert(col);
                str = str + c + c;
            }
            str += '\n';
        }

        return str;
    }

    public void changeSize(int width, int height, double scale) {
        newWidth = (int) Math.ceil(width / scale);
        newHeight = (int) Math.ceil(height / scale);
    }

    public double setScale(int value, int maxValue) {
        double scale = (double) value / maxValue;
        if (value > maxValue) {
            return scale;
        }
        return 1;
    }

    /**
     * Устанавливает максимальную ширину результирующего изображения в "текстовых пикселях".
     * Если исходное изображение имеет характеристики, превышающие максимальные, оно сжимается
     * с сохранением пропорций.
     *
     * @param width максимальная ширина текстовых картинок
     */
    @Override
    public void setMaxWidth(int width) {
        this.width = width;
    }

    /**
     * 0
     * Устанавливает максимальную высоту результирующего изображения в "текстовых пикселях".
     * Если исходное изображение имеет характеристики, превышающие максимальные, оно сжимается
     * с сохранением пропорций.
     *
     * @param height максимальная высоту текстовых картинок
     */
    @Override
    public void setMaxHeight(int height) {
        this.height = height;
    }

    /**
     * Устанавливает максимально допустимое соотношение сторон исходного изображения.
     * Если исходное изображение имеет характеристики, превышающие максимальные,
     * при конвертации выбрасывается исключение.
     *
     * @param maxRatio
     */
    @Override
    public void setMaxRatio(double maxRatio) {
        this.maxRatio = maxRatio;
    }

    public void setTextColorSchema(TextColorSchema schema) {
        this.schema = schema;
    }
}
