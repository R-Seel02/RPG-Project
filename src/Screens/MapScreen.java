package Screens;

import Engine.*;
import GameObject.Sprite;
import GameObject.SpriteSheet;
import SpriteFont.SpriteFont;
import java.awt.*;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import GameObject.Sprite;
import GameObject.SpriteSheet;
import Level.Player;
import SpriteFont.SpriteFont;

import java.awt.Color;


public class MapScreen extends Screen {

    protected SpriteFont returnToGame;
    protected Sprite background;
    protected Sprite shopkeeper;
    protected SpriteSheet shopkeeperSheet;
    protected Sprite[] frame = new Sprite[30];
    // protected Sprite frame1;
    // protected Sprite frame2;
    // protected Sprite frame3;
    // protected Sprite frame4;
    // protected Sprite frame5;
    // protected Sprite frame6;
    // protected Sprite frame7;
    // protected Sprite frame8;
    // protected Sprite frame9;
    // protected Sprite frame10;
    // protected Sprite frame11;
    // protected Sprite frame12;
    // protected Sprite frame13;
    // protected Sprite frame14;
    // protected Sprite frame15;
    // protected Sprite frame16;
    // protected Sprite frame17;
    // protected Sprite frame18;
    // protected Sprite frame19;
    // protected Sprite frame20;
    // protected Sprite frame21;
    // protected Sprite frame22;
    // protected Sprite frame23;
    // protected Sprite frame24;
    // protected Sprite frame25;
    // protected Sprite frame26;
    // protected Sprite frame27;
    // protected Sprite frame28;
    // protected Sprite frame29;
    // protected Sprite frame30;
    // protected Sprite frame31;
    // protected Sprite frame32;
    // protected Sprite frame33;
    // protected Sprite frame34;
    // protected Sprite frame35;
    // protected Sprite frame36;
    // protected Sprite frame37;
    // protected Sprite frame38;
    // protected Sprite frame39;
    // protected Sprite frame40;
    // protected Sprite frame41;
    // protected Sprite frame42;
    // protected Sprite frame43;
    // protected Sprite frame44;
    // protected Sprite frame45;
    // protected Sprite frame46;
    // protected Sprite frame47;
    // protected Sprite frame48;
    // protected Sprite frame49;
    // protected Sprite frame50;
    // protected Sprite frame51;
    // protected Sprite frame52;
    // protected Sprite frame53;
    // protected Sprite frame54;
    // protected Sprite frame55;
    // protected Sprite frame56;
    // protected Sprite frame57;
    // protected Sprite frame58;
    // protected Sprite frame59;
    // protected Sprite frame60;

    protected int timer = 0;
    protected int checker = 10;
    protected int index;
    protected int num = 0;


    protected KeyLocker keyLocker = new KeyLocker();
   // protected PlayLevelScreen playLevelScreen;
   

   //To try and play the anim, attempt to create an array of sprites and traverse the array to play the anim. increase and decrease the scale of the different array indexes to play the anim.
  
    public  MapScreen(int indexx) {
        //this.playLevelScreen = playLevelScreen;
       // this.player = player;
       index = indexx;
        initialize();
    }

    @Override
    public void initialize() {
        
        //background = new Sprite(ImageLoader.load("NewInventoryScreen.png"));
        // shopkeeperSheet = new SpriteSheet(ImageLoader.load("Bug.png"), 24, 15);
        frame[0] = new Sprite(ImageLoader.load("frame1.png"));
         //frame[1] = new Sprite(ImageLoader.load("frame2.png"));
         frame[1] = new Sprite(ImageLoader.load("frame3.png"));
         //frame[3] = new Sprite(ImageLoader.load("frame4.png"));
         frame[2] = new Sprite(ImageLoader.load("frame5.png"));
         //frame[5] = new Sprite(ImageLoader.load("frame6.png"));
        frame[3] = new Sprite(ImageLoader.load("frame7.png"));
        // frame[7] = new Sprite(ImageLoader.load("frame8.png"));
        frame[4] = new Sprite(ImageLoader.load("frame9.png"));
        // frame[9] = new Sprite(ImageLoader.load("frame10.png"));
        frame[5] = new Sprite(ImageLoader.load("frame11.png"));
        // frame[11] = new Sprite(ImageLoader.load("frame12.png"));
        frame[6] = new Sprite(ImageLoader.load("frame13.png"));
        // frame[13] = new Sprite(ImageLoader.load("frame14.png"));
        frame[7] = new Sprite(ImageLoader.load("frame15.png"));
        // frame[15] = new Sprite(ImageLoader.load("frame16.png"));
        frame[8] = new Sprite(ImageLoader.load("frame17.png"));
        // frame[17] = new Sprite(ImageLoader.load("frame18.png"));
        frame[9] = new Sprite(ImageLoader.load("frame19.png"));
        // frame[19] = new Sprite(ImageLoader.load("frame20.png"));
        frame[10] = new Sprite(ImageLoader.load("frame21.png"));
        // frame[21] = new Sprite(ImageLoader.load("frame22.png"));
        frame[11] = new Sprite(ImageLoader.load("frame23.png"));
        // frame[23] = new Sprite(ImageLoader.load("frame24.png"));
        frame[12] = new Sprite(ImageLoader.load("frame25.png"));
        // frame[25] = new Sprite(ImageLoader.load("frame26.png"));
        frame[13] = new Sprite(ImageLoader.load("frame27.png"));
        // frame[27] = new Sprite(ImageLoader.load("frame28.png"));
        frame[14] = new Sprite(ImageLoader.load("frame29.png"));
        // frame[29] = new Sprite(ImageLoader.load("frame30.png"));
        frame[15] = new Sprite(ImageLoader.load("frame31.png"));
        // frame[31] = new Sprite(ImageLoader.load("frame32.png"));
        frame[16] = new Sprite(ImageLoader.load("frame33.png"));
        // frame[33] = new Sprite(ImageLoader.load("frame34.png"));
        frame[17] = new Sprite(ImageLoader.load("frame35.png"));
        // frame[35] = new Sprite(ImageLoader.load("frame36.png"));
        frame[18] = new Sprite(ImageLoader.load("frame37.png"));
        // frame[37] = new Sprite(ImageLoader.load("frame38.png"));
        frame[19] = new Sprite(ImageLoader.load("frame39.png"));
        // frame[39] = new Sprite(ImageLoader.load("frame40.png"));
        frame[20] = new Sprite(ImageLoader.load("frame41.png"));
        // frame[41] = new Sprite(ImageLoader.load("frame42.png"));
        frame[21] = new Sprite(ImageLoader.load("frame43.png"));
        // frame[43] = new Sprite(ImageLoader.load("frame44.png"));
        frame[22] = new Sprite(ImageLoader.load("frame45.png"));
        // frame[45] = new Sprite(ImageLoader.load("frame46.png"));
        frame[23] = new Sprite(ImageLoader.load("frame47.png"));
        // frame[47] = new Sprite(ImageLoader.load("frame48.png"));
        frame[24] = new Sprite(ImageLoader.load("frame49.png"));
        // frame[49] = new Sprite(ImageLoader.load("frame50.png"));
        frame[25] = new Sprite(ImageLoader.load("frame51.png"));
        // frame[51] = new Sprite(ImageLoader.load("frame52.png"));
        frame[26] = new Sprite(ImageLoader.load("frame53.png"));
        // frame[53] = new Sprite(ImageLoader.load("frame54.png"));
        frame[27] = new Sprite(ImageLoader.load("frame55.png"));
        // frame[55] = new Sprite(ImageLoader.load("frame56.png"));
        frame[28] = new Sprite(ImageLoader.load("frame57.png"));
        // frame[57] = new Sprite(ImageLoader.load("frame58.png"));
        frame[29] = new Sprite(ImageLoader.load("frame59.png"));
        //  frame[59] = new Sprite(ImageLoader.load("frame60.png"));

        //  frame1 = new Sprite(ImageLoader.load("frame1.png"));
        //  frame2 = new Sprite(ImageLoader.load("frame2.png"));
        //  frame3 = new Sprite(ImageLoader.load("frame3.png"));
        //  frame4 = new Sprite(ImageLoader.load("frame4.png"));
        //  frame5 = new Sprite(ImageLoader.load("frame5.png"));
        //  frame6 = new Sprite(ImageLoader.load("frame6.png"));
        //  frame7 = new Sprite(ImageLoader.load("frame7.png"));
        //  frame8 = new Sprite(ImageLoader.load("frame8.png"));
        //  frame9 = new Sprite(ImageLoader.load("frame9.png"));
        //  frame10 = new Sprite(ImageLoader.load("frame10.png"));
        //  frame11 = new Sprite(ImageLoader.load("frame11.png"));
        //  frame12 = new Sprite(ImageLoader.load("frame12.png"));
        //  frame13 = new Sprite(ImageLoader.load("frame13.png"));
        //  frame14 = new Sprite(ImageLoader.load("frame14.png"));
        //  frame15 = new Sprite(ImageLoader.load("frame15.png"));
        //  frame16 = new Sprite(ImageLoader.load("frame16.png"));
        //  frame17 = new Sprite(ImageLoader.load("frame17.png"));
        //  frame18 = new Sprite(ImageLoader.load("frame18.png"));
        //  frame19 = new Sprite(ImageLoader.load("frame19.png"));
        //  frame20 = new Sprite(ImageLoader.load("frame20.png"));
        //  frame21 = new Sprite(ImageLoader.load("frame21.png"));
        //  frame22 = new Sprite(ImageLoader.load("frame22.png"));
        //  frame23 = new Sprite(ImageLoader.load("frame23.png"));
        //  frame24 = new Sprite(ImageLoader.load("frame24.png"));
        //  frame25 = new Sprite(ImageLoader.load("frame25.png"));
        //  frame26 = new Sprite(ImageLoader.load("frame26.png"));
        //  frame27 = new Sprite(ImageLoader.load("frame27.png"));
        //  frame28 = new Sprite(ImageLoader.load("frame28.png"));
        //  frame29 = new Sprite(ImageLoader.load("frame29.png"));
        //  frame30 = new Sprite(ImageLoader.load("frame30.png"));
        //  frame31 = new Sprite(ImageLoader.load("frame31.png"));
        //  frame32 = new Sprite(ImageLoader.load("frame32.png"));
        //  frame33 = new Sprite(ImageLoader.load("frame33.png"));
        //  frame34 = new Sprite(ImageLoader.load("frame34.png"));
        //  frame35 = new Sprite(ImageLoader.load("frame35.png"));
        //  frame36 = new Sprite(ImageLoader.load("frame36.png"));
        //  frame37 = new Sprite(ImageLoader.load("frame37.png"));
        //  frame38 = new Sprite(ImageLoader.load("frame38.png"));
        //  frame39 = new Sprite(ImageLoader.load("frame39.png"));
        //  frame40 = new Sprite(ImageLoader.load("frame40.png"));
        //  frame41 = new Sprite(ImageLoader.load("frame41.png"));
        //  frame42 = new Sprite(ImageLoader.load("frame42.png"));
        //  frame43 = new Sprite(ImageLoader.load("frame43.png"));
        //  frame44 = new Sprite(ImageLoader.load("frame44.png"));
        //  frame45 = new Sprite(ImageLoader.load("frame45.png"));
        //  frame46 = new Sprite(ImageLoader.load("frame46.png"));
        //  frame47 = new Sprite(ImageLoader.load("frame47.png"));
        //  frame48 = new Sprite(ImageLoader.load("frame48.png"));
        //  frame49 = new Sprite(ImageLoader.load("frame49.png"));
        //  frame50 = new Sprite(ImageLoader.load("frame50.png"));
        //  frame51 = new Sprite(ImageLoader.load("frame51.png"));
        //  frame52 = new Sprite(ImageLoader.load("frame52.png"));
        //  frame53 = new Sprite(ImageLoader.load("frame53.png"));
        //  frame54 = new Sprite(ImageLoader.load("frame54.png"));
        //  frame55 = new Sprite(ImageLoader.load("frame55.png"));
        //  frame56 = new Sprite(ImageLoader.load("frame56.png"));
        //  frame57 = new Sprite(ImageLoader.load("frame57.png"));
        //  frame58 = new Sprite(ImageLoader.load("frame58.png"));
        //  frame59 = new Sprite(ImageLoader.load("frame59.png"));
        //  frame60 = new Sprite(ImageLoader.load("frame60.png"));
        

    }

    
    public void reset(){
        frame[0].setScale(1);
        frame[1].setScale(1);
        frame[2].setScale(1);
        frame[3].setScale(1);
        frame[4].setScale(1);
        frame[5].setScale(1);
        frame[6].setScale(1);
        frame[7].setScale(1);
        frame[8].setScale(1);
        frame[9].setScale(1);
        frame[10].setScale(1);
        frame[11].setScale(1);
        frame[12].setScale(1);
        frame[13].setScale(1);
        frame[14].setScale(1);
        frame[15].setScale(1);
        frame[16].setScale(1);
        frame[17].setScale(1);
        frame[18].setScale(1);
        frame[19].setScale(1);
        frame[20].setScale(1);
        frame[21].setScale(1);
        frame[22].setScale(1);
        frame[23].setScale(1);
        frame[24].setScale(1);
        frame[25].setScale(1);
        frame[26].setScale(1);
        frame[27].setScale(1);
        frame[28].setScale(1);
        frame[29].setScale(1);

    }
 

    @Override
    public void update() {
        if(timer== 0){

            frame[29].setScale(1);
            frame[28].setScale(1);
            frame[27].setScale(1);
            frame[26].setScale(1);
            frame[25].setScale(1);
            frame[24].setScale(1);
            frame[23].setScale(1);
            frame[22].setScale(1);
            frame[21].setScale(1);
            frame[20].setScale(1);
            frame[19].setScale(1);
            frame[18].setScale(1);
            frame[17].setScale(1);
            frame[16].setScale(1);
            frame[15].setScale(1);
            frame[14].setScale(1);
            frame[13].setScale(1);
            frame[12].setScale(1);
            frame[11].setScale(1);
            frame[10].setScale(1);
            frame[9].setScale(1);
            frame[8].setScale(1);
            frame[7].setScale(1);
            frame[6].setScale(1);
            frame[5].setScale(1);
            frame[4].setScale(1);
            frame[3].setScale(1);
            frame[2].setScale(1);
            frame[1].setScale(1);
            frame[0].setScale(1);
   
 
        
        }

        // System.out.println(timer);
        // frame[index].setScale(0);
        if(timer > checker && index < 29){
        frame[index].setScale(0);
        checker = checker + 10;
        index++;
        }
        if(index == 29){
            num=0;
        }

        //checker = checker + 20;
        // timer++;


        //  if(timer > 5){
        //  frame1.setScale(0);
        //  }
        //  if(timer > 10){
        // frame2.setScale(0);
        // }
        // if(timer > 15){
        // frame3.setScale(0);
        // }
        // if(timer > 20){
        //  frame4.setScale(0);
        //  }
        //  if(timer > 25){
        //  frame5.setScale(0);
        //  }
        //  if(timer > 30){
        //  frame6.setScale(0);
        //  }
        //  if(timer > 35){
        //  frame7.setScale(0);
        //  }
        //  if(timer > 40){
        //  frame8.setScale(0);
        //  }
        //  if(timer > 45){
        //  frame9.setScale(0);
        //  }if(timer > 50){
        //  frame10.setScale(0);
        //  }
        //  if(timer > 5){
        //  frame1.setScale(0);
        //  }
        //  if(timer > 10){
        // frame2.setScale(0);
        // }
        // if(timer > 15){
        // frame3.setScale(0);
        // }
        // if(timer > 20){
        //  frame4.setScale(0);
        //  }
        //  if(timer > 25){
        //  frame5.setScale(0);
        //  }
        //  if(timer > 30){
        //  frame6.setScale(0);
        //  }
        //  if(timer > 35){
        //  frame7.setScale(0);
        //  }
        //  if(timer > 40){
        //  frame8.setScale(0);
        //  }
        //  if(timer > 45){
        //  frame9.setScale(0);
        //  }if(timer > 50){
        //  frame10.setScale(0);
        //  }if(timer > 55){
        //     frame11.setScale(0);
        //     }
        //     if(timer > 60){
        //    frame12.setScale(0);
        //    }
        //    if(timer > 65){
        //    frame13.setScale(0);
        //    }
        //    if(timer > 70){
        //     frame14.setScale(0);
        //     }
        //     if(timer > 75){
        //     frame15.setScale(0);
        //     }
        //     if(timer > 80){
        //     frame16.setScale(0);
        //     }
        //     if(timer > 85){
        //     frame17.setScale(0);
        //     }
        //     if(timer > 90){
        //     frame18.setScale(0);
        //     }
        //     if(timer > 95){
        //     frame19.setScale(0);
        //     }if(timer > 100){
        //     frame20.setScale(0);
        //     }
        //     if(timer > 105){
        //         frame21.setScale(0);
        //         }
        //         if(timer > 110){
        //        frame22.setScale(0);
        //        }
        //        if(timer > 115){
        //        frame23.setScale(0);
        //        }
        //        if(timer > 120){
        //         frame24.setScale(0);
        //         }
        //         if(timer > 125){
        //         frame25.setScale(0);
        //         }
        //         if(timer > 130){
        //         frame26.setScale(0);
        //         }
        //         if(timer > 135){
        //         frame27.setScale(0);
        //         }
        //         if(timer > 140){
        //         frame28.setScale(0);
        //         }
        //         if(timer > 145){
        //         frame29.setScale(0);
        //         }if(timer > 150){
        //         frame30.setScale(0);
        //         }
        //         if(timer > 155){
        //             frame31.setScale(0);
        //             }
        //             if(timer > 160){
        //            frame32.setScale(0);
        //            }
        //            if(timer > 165){
        //            frame33.setScale(0);
        //            }
        //            if(timer > 170){
        //             frame34.setScale(0);
        //             }
        //             if(timer > 175){
        //             frame35.setScale(0);
        //             }
        //             if(timer > 180){
        //             frame36.setScale(0);
        //             }
        //             if(timer > 185){
        //             frame37.setScale(0);
        //             }
        //             if(timer > 190){
        //             frame38.setScale(0);
        //             }
        //             if(timer > 195){
        //             frame39.setScale(0);
        //             }if(timer > 200){
        //             frame40.setScale(0);
        //             }
        //             if(timer > 205){
        //                 frame41.setScale(0);
        //                 }
        //                 if(timer > 210){
        //                frame42.setScale(0);
        //                }
        //                if(timer > 215){
        //                frame43.setScale(0);
        //                }
        //                if(timer > 220){
        //                 frame44.setScale(0);
        //                 }
        //                 if(timer > 225){
        //                 frame45.setScale(0);
        //                 }
        //                 if(timer > 230){
        //                 frame46.setScale(0);
        //                 }
        //                 if(timer > 235){
        //                 frame47.setScale(0);
        //                 }
        //                 if(timer > 240){
        //                 frame48.setScale(0);
        //                 }
        //                 if(timer > 245){
        //                 frame49.setScale(0);
        //                 }if(timer > 250){
        //                 frame50.setScale(0);
        //                 }
        //                 if(timer > 255){
        //                     frame51.setScale(0);
        //                     }
        //                     if(timer > 260){
        //                    frame52.setScale(0);
        //                    }
        //                    if(timer > 265){
        //                    frame53.setScale(0);
        //                    }
        //                    if(timer > 270){
        //                     frame54.setScale(0);
        //                     }
        //                     if(timer > 275){
        //                     frame55.setScale(0);
        //                     }
        //                     if(timer > 280){
        //                     frame56.setScale(0);
        //                     }
        //                     if(timer > 285){
        //                     frame57.setScale(0);
        //                     }
        //                     if(timer > 290){
        //                     frame58.setScale(0);
        //                     }
        //                     if(timer > 295){
        //                     frame59.setScale(0);
        //                     }if(timer > 300){
        //                     frame60.setScale(0);
        //                     }


         timer++;



        // if (Keyboard.isKeyUp(Key.SPACE)) {
        //     keyLocker.unlockKey(Key.SPACE);
        // }
        // if (Keyboard.isKeyUp(Key.ESC)) {
        //     keyLocker.unlockKey(Key.ESC);
        // }
        // if (Keyboard.isKeyUp(Key.M)) {
        //     keyLocker.unlockKey(Key.M);
        // }

    }


    @Override
    public void draw(GraphicsHandler graphicsHandler) {

        //background.draw(graphicsHandler);
        // frame[0].draw(graphicsHandler);
        // frame[1].draw(graphicsHandler);
        // frame[2].draw(graphicsHandler);
        // frame[3].draw(graphicsHandler);
        // frame[4].draw(graphicsHandler);
        // frame[5].draw(graphicsHandler);
        // frame[6].draw(graphicsHandler);
        // frame[7].draw(graphicsHandler);
        // frame[8].draw(graphicsHandler);
        // frame[9].draw(graphicsHandler);
        // frame[10].draw(graphicsHandler);
        // frame[11].draw(graphicsHandler);
        // frame[12].draw(graphicsHandler);
        // frame[13].draw(graphicsHandler);
        // frame[14].draw(graphicsHandler);
        // frame[15].draw(graphicsHandler);
        // frame[16].draw(graphicsHandler);
        // frame[17].draw(graphicsHandler);
        // frame[18].draw(graphicsHandler);
        // frame[19].draw(graphicsHandler);
        // frame[20].draw(graphicsHandler);
        // frame[21].draw(graphicsHandler);
        // frame[22].draw(graphicsHandler);
        // frame[23].draw(graphicsHandler);
        // frame[24].draw(graphicsHandler);
        // frame[25].draw(graphicsHandler);
        // frame[26].draw(graphicsHandler);
        // frame[27].draw(graphicsHandler);
        // frame[28].draw(graphicsHandler);
        // frame[29].draw(graphicsHandler);
        // frame[30].draw(graphicsHandler);
        // frame[31].draw(graphicsHandler);
        // frame[32].draw(graphicsHandler);
        // frame[33].draw(graphicsHandler);
        // frame[34].draw(graphicsHandler);
        // frame[35].draw(graphicsHandler);
        // frame[36].draw(graphicsHandler);
        // frame[37].draw(graphicsHandler);
        // frame[38].draw(graphicsHandler);
        // frame[39].draw(graphicsHandler);
        // frame[40].draw(graphicsHandler);
        // frame[41].draw(graphicsHandler);
        // frame[42].draw(graphicsHandler);
        // frame[43].draw(graphicsHandler);
        // frame[44].draw(graphicsHandler);
        // frame[45].draw(graphicsHandler);
        // frame[46].draw(graphicsHandler);
        // frame[47].draw(graphicsHandler);
        // frame[48].draw(graphicsHandler);
        // frame[49].draw(graphicsHandler);
        // frame[50].draw(graphicsHandler);
        // frame[51].draw(graphicsHandler);
        // frame[52].draw(graphicsHandler);
        // frame[53].draw(graphicsHandler);
        // frame[54].draw(graphicsHandler);
        // frame[55].draw(graphicsHandler);
        // frame[56].draw(graphicsHandler);
        // frame[57].draw(graphicsHandler);
        // frame[58].draw(graphicsHandler);
        // frame[59].draw(graphicsHandler);

        //  frame[59].draw(graphicsHandler);
        // frame[58].draw(graphicsHandler);
        // frame[57].draw(graphicsHandler);
        // frame[56].draw(graphicsHandler);
        // frame[55].draw(graphicsHandler);
        // frame[54].draw(graphicsHandler);
        // frame[53].draw(graphicsHandler);
        // frame[52].draw(graphicsHandler);
        // frame[51].draw(graphicsHandler);
        // frame[50].draw(graphicsHandler);
        // frame[49].draw(graphicsHandler);
        // frame[48].draw(graphicsHandler);
        // frame[47].draw(graphicsHandler);
        // frame[46].draw(graphicsHandler);
        // frame[45].draw(graphicsHandler);
        // frame[44].draw(graphicsHandler);
        // frame[43].draw(graphicsHandler);
        // frame[42].draw(graphicsHandler);
        // frame[41].draw(graphicsHandler);
        // frame[40].draw(graphicsHandler);
        // frame[39].draw(graphicsHandler);
        // frame[38].draw(graphicsHandler);
        // frame[37].draw(graphicsHandler);
        // frame[36].draw(graphicsHandler);
        // frame[35].draw(graphicsHandler);
        // frame[34].draw(graphicsHandler);
        // frame[33].draw(graphicsHandler);
        // frame[32].draw(graphicsHandler);
        // frame[31].draw(graphicsHandler);
        //frame[30].draw(graphicsHandler);
        frame[29].draw(graphicsHandler);
        frame[28].draw(graphicsHandler);
        frame[27].draw(graphicsHandler);
        frame[26].draw(graphicsHandler);
        frame[25].draw(graphicsHandler);
        frame[24].draw(graphicsHandler);
        frame[23].draw(graphicsHandler);
        frame[22].draw(graphicsHandler);
        frame[21].draw(graphicsHandler);
        frame[20].draw(graphicsHandler);
        frame[19].draw(graphicsHandler);
        frame[18].draw(graphicsHandler);
        frame[17].draw(graphicsHandler);
        frame[16].draw(graphicsHandler);
        frame[15].draw(graphicsHandler);
        frame[14].draw(graphicsHandler);
        frame[13].draw(graphicsHandler);
        frame[12].draw(graphicsHandler);
        frame[11].draw(graphicsHandler);
        frame[10].draw(graphicsHandler);
        frame[9].draw(graphicsHandler);
        frame[8].draw(graphicsHandler);
        frame[7].draw(graphicsHandler);
        frame[6].draw(graphicsHandler);
         frame[5].draw(graphicsHandler);
         frame[4].draw(graphicsHandler);
         frame[3].draw(graphicsHandler);
         frame[2].draw(graphicsHandler);
         frame[1].draw(graphicsHandler);
        frame[0].draw(graphicsHandler);


        // frame60.draw(graphicsHandler);
        // frame59.draw(graphicsHandler);
        // frame58.draw(graphicsHandler);
        // frame57.draw(graphicsHandler);
        // frame56.draw(graphicsHandler);
        //  frame55.draw(graphicsHandler);
        //  frame54.draw(graphicsHandler);
        //  frame53.draw(graphicsHandler);
        //  frame52.draw(graphicsHandler);
        //  frame51.draw(graphicsHandler);
        // frame50.draw(graphicsHandler);
        // frame49.draw(graphicsHandler);
        // frame48.draw(graphicsHandler);
        // frame47.draw(graphicsHandler);
        // frame46.draw(graphicsHandler);
        //  frame45.draw(graphicsHandler);
        //  frame44.draw(graphicsHandler);
        //  frame43.draw(graphicsHandler);
        //  frame42.draw(graphicsHandler);
        //  frame41.draw(graphicsHandler);
        // frame40.draw(graphicsHandler);
        // frame39.draw(graphicsHandler);
        // frame38.draw(graphicsHandler);
        // frame37.draw(graphicsHandler);
        // frame36.draw(graphicsHandler);
        //  frame35.draw(graphicsHandler);
        //  frame34.draw(graphicsHandler);
        //  frame33.draw(graphicsHandler);
        //  frame32.draw(graphicsHandler);
        //  frame31.draw(graphicsHandler);
        // frame30.draw(graphicsHandler);
        // frame29.draw(graphicsHandler);
        // frame28.draw(graphicsHandler);
        // frame27.draw(graphicsHandler);
        // frame26.draw(graphicsHandler);
        //  frame25.draw(graphicsHandler);
        //  frame24.draw(graphicsHandler);
        //  frame23.draw(graphicsHandler);
        //  frame22.draw(graphicsHandler);
        //  frame21.draw(graphicsHandler);
        // frame20.draw(graphicsHandler);
        // frame19.draw(graphicsHandler);
        // frame18.draw(graphicsHandler);
        // frame17.draw(graphicsHandler);
        // frame16.draw(graphicsHandler);
        //  frame15.draw(graphicsHandler);
        //  frame14.draw(graphicsHandler);
        //  frame13.draw(graphicsHandler);
        //  frame12.draw(graphicsHandler);
        //  frame11.draw(graphicsHandler);
        // frame10.draw(graphicsHandler);
        // frame9.draw(graphicsHandler);
        // frame8.draw(graphicsHandler);
        // frame7.draw(graphicsHandler);
        // frame6.draw(graphicsHandler);
        //  frame5.draw(graphicsHandler);
        //  frame4.draw(graphicsHandler);
        //  frame3.draw(graphicsHandler);
        //  frame2.draw(graphicsHandler);
        //  frame1.draw(graphicsHandler);
    }

}