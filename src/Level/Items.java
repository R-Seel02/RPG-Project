package Level;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import GameObject.Frame;

public class Items {

    protected int damage;
    protected Frame frame;
    protected int uniformWidth = 24;
    protected int uniformHeight = 24;


        public Items(int damage, Frame frame ){
            this.damage = damage;
            this.frame = frame;
            
          }

          public Frame getFrame(){
            return this.frame;
          }

        //   private Frame resizeFrame(Frame originalFrame, int width, int height) {
        //     if (originalFrame != null) {
        //         BufferedImage originalImage = (BufferedImage) originalFrame.getImage();
        //         BufferedImage resizedImage = resizeBufferedImage(originalImage, width, height);
        //         return new Frame(resizedImage); // Assuming Frame has a constructor that takes BufferedImage
        //     }
        //     return originalFrame;
        // }
        // private BufferedImage resizeBufferedImage(BufferedImage originalImage, int width, int height) {
        //     BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
        //     Graphics2D g2d = resizedImage.createGraphics();
        //     g2d.drawImage(originalImage, 24, 24, width, height, null);
        //     g2d.dispose();
        //     return resizedImage;
        // }
    }










    

