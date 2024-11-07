package Level;

import GameObject.Frame;

public class Items {

    protected int damage;
    protected Frame frame;


        public Items(int damage, Frame frame ){
            this.damage = damage;
            this.frame = frame;
            
          }

          public Frame getFrame(){
            return this.frame;
          }








    
}
