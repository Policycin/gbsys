package com.manage.gb.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;


public class VerifyCodeUtil {
    private static final String BASE_CODE = "0123456789";

    public VerifyCodeUtil() {
    }

    public static String getImgBase64(String verifyCode, String ImgWidth, String ImgHeight, String fontSize) throws IOException {
        int width = StringUtils.isBlank(ImgWidth) ? 90 : Integer.parseInt(ImgWidth);
        int height = StringUtils.isBlank(ImgHeight) ? 35 : Integer.parseInt(ImgHeight);
        int font = StringUtils.isBlank(fontSize) ? 24 : Integer.parseInt(fontSize);
        BufferedImage image = new BufferedImage(width, height, 1);
        Random random = RandomUtils.JVM_RANDOM;
        Graphics graphics = image.getGraphics();
        graphics.setFont(new Font("黑体", 1, font));
        graphics.setColor(getRandColor(200, 250));
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.BLACK);
        graphics.drawString(verifyCode, 15, 25);
        int max = random.nextInt(10);

        int i;
        for(i = 0; i < max; ++i) {
            graphics.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            graphics.drawLine(random.nextInt(100), random.nextInt(50), random.nextInt(100), random.nextInt(50));
        }

        for(i = 0; i < max; ++i) {
            graphics.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            graphics.drawOval(random.nextInt(80), random.nextInt(40), random.nextInt(5), random.nextInt(10));
        }

        Encoder encoder = Base64.getEncoder();
        String imgString = null;
        ByteArrayOutputStream bs = null;

        try {
            bs = new ByteArrayOutputStream();
            ImageIO.write(image, "JPG", bs);
            imgString = encoder.encodeToString(bs.toByteArray());
        } catch (IOException var18) {
            var18.getStackTrace();
        } finally {
            if (bs != null) {
                bs.close();
            }

        }

        return imgString;
    }

    public static String getVerifyCode(String length) {
        int codeSize = StringUtils.isNotBlank(length) ? Integer.parseInt(length) : 4;
        int size = BASE_CODE.length();
        StringBuffer verifyCode = new StringBuffer();

        for(int i = 1; i <= codeSize; ++i) {
            int index = (new SecureRandom()).nextInt(size);
            char ch = BASE_CODE.charAt(index);
            verifyCode.append(ch);
        }

        return verifyCode.toString();
    }

    private static Color getRandColor(int fc, int bc) {
        Random random = RandomUtils.JVM_RANDOM;
        if (fc > 255) {
            fc = 255;
        }

        if (bc > 255) {
            bc = 255;
        }

        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    public static void main(String[] args) throws IOException {
        System.out.print("data:image/png;base64," + getImgBase64(getVerifyCode("4"), (String)null, (String)null, (String)null));
    }
}
