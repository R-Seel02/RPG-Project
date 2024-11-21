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

       
    }










    

