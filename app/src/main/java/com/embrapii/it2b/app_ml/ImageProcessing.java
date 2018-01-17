package com.embrapii.it2b.app_ml;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Created by rubens on 17/01/18.
 */

public class ImageProcessing {

    // Método que deixa a image em escala de cinza
    public static Bitmap doGrayscale(Bitmap src) {
        // constant factors
        final double GS_RED = 0.299;
        final double GS_GREEN = 0.587;
        final double GS_BLUE = 0.114;

        // create output bitmap
        Bitmap imageGray = Bitmap.createBitmap(src.getWidth(), src.getHeight(), src.getConfig());
        // Informações dos pixels
        int A, R, G, B;
        int pixel;

        // Pega o tamanho da imagem
        int width = src.getWidth();
        int height = src.getHeight();

        // Varre cada pixel da imagem
        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                // Consegue o valor do pixel
                pixel = src.getPixel(x, y);
                // retrieve color of all channels
                A = Color.alpha(pixel);
                R = Color.red(pixel);
                G = Color.green(pixel);
                B = Color.blue(pixel);
                // take conversion up to one single value
                R = G = B = (int)(GS_RED * R + GS_GREEN * G + GS_BLUE * B);
                // set new pixel color to output bitmap
                imageGray.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }

        // Retorna a imagem em escala de cinza
        return imageGray;
    }

}
