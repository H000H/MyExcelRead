package myexcel.image.util;

import myexcel.file.FileCreateUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Random;

public class ImageFactory {
    public static String FILEPATH="image\\";
    public static int width=100;
    public static int height=100;
    public static Image getNewImage(String str){
        Image result=null;
        String filePath=FILEPATH+System.currentTimeMillis()+".jpg";
        File file=FileCreateUtil.getFile("Myfile",filePath);

        BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2=(Graphics2D)bufferedImage.getGraphics();
        g2.setBackground(Color.YELLOW);
        g2.clearRect(0, 0, width, height);
        g2.setPaint(Color.BLACK);

        String s=getString();
        Font font = new Font("Serif", Font.BOLD, 10);

        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(s, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = -bounds.getY();
        double baseY = y + ascent;

        g2.drawString(s, (int)x, (int)baseY);

        try {
            ImageIO.write(bufferedImage, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String getString(){
        Random random=new Random(26);
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<4;i++){
            int b=random.nextInt(10)+64;
            System.out.println(b);
            char a=(char)b;
            builder.append(a);
        }
        System.out.println(builder.toString());
        return builder.toString();
    }
}
