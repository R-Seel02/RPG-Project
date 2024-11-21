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


public class WinnerScreen extends Screen {

    protected SpriteFont returnToGame;
    protected Sprite background;
    protected Sprite shopkeeper;
    protected SpriteSheet shopkeeperSheet;
    protected Sprite[] frame = new Sprite[149];
    protected int timer = 0;
    protected int checker = 20;
    protected int index;


    protected KeyLocker keyLocker = new KeyLocker();
   // protected PlayLevelScreen playLevelScreen;
   

   //To try and play the anim, attempt to create an array of sprites and traverse the array to play the anim. increase and decrease the scale of the different array indexes to play the anim.
  
    public  WinnerScreen(int indexx) {
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
        frame[1] = new Sprite(ImageLoader.load("frame2.png"));
        frame[2] = new Sprite(ImageLoader.load("frame3.png"));
        frame[3] = new Sprite(ImageLoader.load("frame4.png"));
        frame[4] = new Sprite(ImageLoader.load("frame5.png"));
        frame[5] = new Sprite(ImageLoader.load("frame6.png"));
        frame[6] = new Sprite(ImageLoader.load("frame7.png"));
        frame[7] = new Sprite(ImageLoader.load("frame8.png"));
        frame[8] = new Sprite(ImageLoader.load("frame9.png"));
        frame[9] = new Sprite(ImageLoader.load("frame10.png"));
        frame[10] = new Sprite(ImageLoader.load("frame11.png"));
        frame[11] = new Sprite(ImageLoader.load("frame12.png"));
        frame[12] = new Sprite(ImageLoader.load("frame13.png"));
        frame[13] = new Sprite(ImageLoader.load("frame14.png"));
        frame[14] = new Sprite(ImageLoader.load("frame15.png"));
        frame[15] = new Sprite(ImageLoader.load("frame16.png"));
        frame[16] = new Sprite(ImageLoader.load("frame17.png"));
        frame[17] = new Sprite(ImageLoader.load("frame18.png"));
        frame[18] = new Sprite(ImageLoader.load("frame19.png"));
        frame[19] = new Sprite(ImageLoader.load("frame20.png"));
        frame[20] = new Sprite(ImageLoader.load("frame21.png"));
        frame[21] = new Sprite(ImageLoader.load("frame22.png"));
        frame[22] = new Sprite(ImageLoader.load("frame23.png"));
        frame[23] = new Sprite(ImageLoader.load("frame24.png"));
        frame[24] = new Sprite(ImageLoader.load("frame25.png"));
        frame[25] = new Sprite(ImageLoader.load("frame26.png"));
        frame[26] = new Sprite(ImageLoader.load("frame27.png"));
        frame[27] = new Sprite(ImageLoader.load("frame28.png"));
        frame[28] = new Sprite(ImageLoader.load("frame29.png"));
        frame[29] = new Sprite(ImageLoader.load("frame30.png"));
        frame[30] = new Sprite(ImageLoader.load("frame31.png"));
        frame[31] = new Sprite(ImageLoader.load("frame32.png"));
        frame[32] = new Sprite(ImageLoader.load("frame33.png"));
        frame[33] = new Sprite(ImageLoader.load("frame34.png"));
        frame[34] = new Sprite(ImageLoader.load("frame35.png"));
        frame[35] = new Sprite(ImageLoader.load("frame36.png"));
        frame[36] = new Sprite(ImageLoader.load("frame37.png"));
        frame[37] = new Sprite(ImageLoader.load("frame38.png"));
        frame[38] = new Sprite(ImageLoader.load("frame39.png"));
        frame[39] = new Sprite(ImageLoader.load("frame40.png"));
        frame[40] = new Sprite(ImageLoader.load("frame41.png"));
        frame[41] = new Sprite(ImageLoader.load("frame42.png"));
        frame[42] = new Sprite(ImageLoader.load("frame43.png"));
        frame[43] = new Sprite(ImageLoader.load("frame44.png"));
        frame[44] = new Sprite(ImageLoader.load("frame45.png"));
        frame[45] = new Sprite(ImageLoader.load("frame46.png"));
        frame[46] = new Sprite(ImageLoader.load("frame47.png"));
        frame[47] = new Sprite(ImageLoader.load("frame48.png"));
        frame[48] = new Sprite(ImageLoader.load("frame49.png"));
        frame[49] = new Sprite(ImageLoader.load("frame50.png"));
        frame[50] = new Sprite(ImageLoader.load("frame51.png"));
        frame[51] = new Sprite(ImageLoader.load("frame52.png"));
        frame[52] = new Sprite(ImageLoader.load("frame53.png"));
        frame[53] = new Sprite(ImageLoader.load("frame54.png"));
        frame[54] = new Sprite(ImageLoader.load("frame55.png"));
        frame[55] = new Sprite(ImageLoader.load("frame56.png"));
        frame[56] = new Sprite(ImageLoader.load("frame57.png"));
        frame[57] = new Sprite(ImageLoader.load("frame58.png"));
        frame[58] = new Sprite(ImageLoader.load("frame59.png"));
        frame[59] = new Sprite(ImageLoader.load("frame60.png"));
        frame[60] = new Sprite(ImageLoader.load("frame61.png"));
        frame[61] = new Sprite(ImageLoader.load("frame62.png"));
        frame[62] = new Sprite(ImageLoader.load("frame63.png"));
        frame[63] = new Sprite(ImageLoader.load("frame64.png"));
        frame[64] = new Sprite(ImageLoader.load("frame65.png"));
        frame[65] = new Sprite(ImageLoader.load("frame66.png"));
        frame[66] = new Sprite(ImageLoader.load("frame67.png"));
        frame[67] = new Sprite(ImageLoader.load("frame68.png"));
        frame[68] = new Sprite(ImageLoader.load("frame69.png"));
        frame[69] = new Sprite(ImageLoader.load("frame70.png"));
        frame[70] = new Sprite(ImageLoader.load("frame71.png"));
        frame[71] = new Sprite(ImageLoader.load("frame72.png"));
        frame[72] = new Sprite(ImageLoader.load("frame73.png"));
        frame[73] = new Sprite(ImageLoader.load("frame74.png"));
        frame[74] = new Sprite(ImageLoader.load("frame75.png"));
        frame[75] = new Sprite(ImageLoader.load("frame76.png"));
        frame[76] = new Sprite(ImageLoader.load("frame77.png"));
        frame[77] = new Sprite(ImageLoader.load("frame78.png"));
        frame[78] = new Sprite(ImageLoader.load("frame79.png"));
        frame[79] = new Sprite(ImageLoader.load("frame80.png"));
        frame[80] = new Sprite(ImageLoader.load("frame81.png"));
        frame[81] = new Sprite(ImageLoader.load("frame82.png"));
        frame[82] = new Sprite(ImageLoader.load("frame83.png"));
        frame[83] = new Sprite(ImageLoader.load("frame84.png"));
        frame[84] = new Sprite(ImageLoader.load("frame85.png"));
        frame[85] = new Sprite(ImageLoader.load("frame86.png"));
        frame[86] = new Sprite(ImageLoader.load("frame87.png"));
        frame[87] = new Sprite(ImageLoader.load("frame88.png"));
        frame[88] = new Sprite(ImageLoader.load("frame89.png"));
        frame[89] = new Sprite(ImageLoader.load("frame90.png"));
        frame[90] = new Sprite(ImageLoader.load("frame91.png"));
        frame[91] = new Sprite(ImageLoader.load("frame92.png"));
        frame[92] = new Sprite(ImageLoader.load("frame93.png"));
        frame[93] = new Sprite(ImageLoader.load("frame94.png"));
        frame[94] = new Sprite(ImageLoader.load("frame95.png"));
        frame[95] = new Sprite(ImageLoader.load("frame96.png"));
        frame[96] = new Sprite(ImageLoader.load("frame97.png"));
        frame[97] = new Sprite(ImageLoader.load("frame98.png"));
        frame[98] = new Sprite(ImageLoader.load("frame99.png"));
        frame[99] = new Sprite(ImageLoader.load("frame100.png"));
        frame[100] = new Sprite(ImageLoader.load("frame101.png"));
        frame[101] = new Sprite(ImageLoader.load("frame102.png"));
        frame[102] = new Sprite(ImageLoader.load("frame103.png"));
        frame[103] = new Sprite(ImageLoader.load("frame104.png"));
        frame[104] = new Sprite(ImageLoader.load("frame105.png"));
        frame[105] = new Sprite(ImageLoader.load("frame106.png"));
        frame[106] = new Sprite(ImageLoader.load("frame107.png"));
        frame[107] = new Sprite(ImageLoader.load("frame108.png"));
        frame[108] = new Sprite(ImageLoader.load("frame109.png"));
        frame[109] = new Sprite(ImageLoader.load("frame110.png"));
        frame[110] = new Sprite(ImageLoader.load("frame111.png"));
        frame[111] = new Sprite(ImageLoader.load("frame112.png"));
        frame[112] = new Sprite(ImageLoader.load("frame113.png"));
        frame[113] = new Sprite(ImageLoader.load("frame114.png"));
        frame[114] = new Sprite(ImageLoader.load("frame115.png"));
        frame[115] = new Sprite(ImageLoader.load("frame116.png"));
        frame[116] = new Sprite(ImageLoader.load("frame117.png"));
        frame[117] = new Sprite(ImageLoader.load("frame118.png"));
        frame[118] = new Sprite(ImageLoader.load("frame119.png"));
        frame[119] = new Sprite(ImageLoader.load("frame120.png"));
        frame[120] = new Sprite(ImageLoader.load("frame121.png"));
        frame[121] = new Sprite(ImageLoader.load("frame122.png"));
        frame[122] = new Sprite(ImageLoader.load("frame123.png"));
        frame[123] = new Sprite(ImageLoader.load("frame124.png"));
        frame[124] = new Sprite(ImageLoader.load("frame125.png"));
        frame[125] = new Sprite(ImageLoader.load("frame126.png"));
        frame[126] = new Sprite(ImageLoader.load("frame127.png"));
        frame[127] = new Sprite(ImageLoader.load("frame128.png"));
        frame[128] = new Sprite(ImageLoader.load("frame129.png"));
        frame[129] = new Sprite(ImageLoader.load("frame130.png"));
        frame[130] = new Sprite(ImageLoader.load("frame131.png"));
        frame[131] = new Sprite(ImageLoader.load("frame132.png"));
        frame[132] = new Sprite(ImageLoader.load("frame133.png"));
        frame[133] = new Sprite(ImageLoader.load("frame134.png"));
        frame[134] = new Sprite(ImageLoader.load("frame135.png"));
        frame[135] = new Sprite(ImageLoader.load("frame136.png"));
        frame[136] = new Sprite(ImageLoader.load("frame137.png"));
        frame[137] = new Sprite(ImageLoader.load("frame138.png"));
        frame[138] = new Sprite(ImageLoader.load("frame139.png"));
        frame[139] = new Sprite(ImageLoader.load("frame140.png"));
        frame[140] = new Sprite(ImageLoader.load("frame141.png"));
        frame[141] = new Sprite(ImageLoader.load("frame142.png"));
        frame[142] = new Sprite(ImageLoader.load("frame143.png"));
        frame[143] = new Sprite(ImageLoader.load("frame144.png"));
        frame[144] = new Sprite(ImageLoader.load("frame145.png"));
        frame[145] = new Sprite(ImageLoader.load("frame146.png"));
        frame[146] = new Sprite(ImageLoader.load("frame147.png"));
        frame[147] = new Sprite(ImageLoader.load("frame148.png"));
        frame[148] = new Sprite(ImageLoader.load("frame149.png"));
        frame[149] = new Sprite(ImageLoader.load("frame150.png"));

    }
 

    @Override
    public void update() {

        timer++;
        System.out.println(timer);

        if(timer > checker && index < 60){
        frame[index].setScale(0);
        index++;
        }

        checker = checker + 20;
       



        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }
        if (Keyboard.isKeyUp(Key.M)) {
            keyLocker.unlockKey(Key.M);
        }

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

        frame[149].draw(graphicsHandler);
        frame[148].draw(graphicsHandler);
        frame[147].draw(graphicsHandler);
        frame[146].draw(graphicsHandler);
        frame[145].draw(graphicsHandler);
        frame[144].draw(graphicsHandler);
        frame[143].draw(graphicsHandler);
        frame[142].draw(graphicsHandler);
        frame[141].draw(graphicsHandler);
        frame[140].draw(graphicsHandler);
        frame[139].draw(graphicsHandler);
        frame[138].draw(graphicsHandler);
        frame[137].draw(graphicsHandler);
        frame[136].draw(graphicsHandler);
        frame[135].draw(graphicsHandler);
        frame[134].draw(graphicsHandler);
        frame[133].draw(graphicsHandler);
        frame[132].draw(graphicsHandler);
        frame[131].draw(graphicsHandler);
        frame[130].draw(graphicsHandler);
        frame[129].draw(graphicsHandler);
        frame[128].draw(graphicsHandler);
        frame[127].draw(graphicsHandler);
        frame[126].draw(graphicsHandler);
        frame[125].draw(graphicsHandler);
        frame[124].draw(graphicsHandler);
        frame[123].draw(graphicsHandler);
        frame[122].draw(graphicsHandler);
        frame[121].draw(graphicsHandler);
        frame[120].draw(graphicsHandler);
        frame[119].draw(graphicsHandler);
        frame[118].draw(graphicsHandler);
        frame[117].draw(graphicsHandler);
        frame[116].draw(graphicsHandler);
        frame[115].draw(graphicsHandler);
        frame[114].draw(graphicsHandler);
        frame[113].draw(graphicsHandler);
        frame[112].draw(graphicsHandler);
        frame[111].draw(graphicsHandler);
        frame[110].draw(graphicsHandler);
        frame[109].draw(graphicsHandler);
        frame[108].draw(graphicsHandler);
        frame[107].draw(graphicsHandler);
        frame[106].draw(graphicsHandler);
        frame[105].draw(graphicsHandler);
        frame[104].draw(graphicsHandler);
        frame[103].draw(graphicsHandler);
        frame[102].draw(graphicsHandler);
        frame[101].draw(graphicsHandler);
        frame[100].draw(graphicsHandler);
        frame[99].draw(graphicsHandler);
        frame[98].draw(graphicsHandler);
        frame[97].draw(graphicsHandler);
        frame[96].draw(graphicsHandler);
        frame[95].draw(graphicsHandler);
        frame[94].draw(graphicsHandler);
        frame[93].draw(graphicsHandler);
        frame[92].draw(graphicsHandler);
        frame[91].draw(graphicsHandler);
        frame[90].draw(graphicsHandler);
        frame[89].draw(graphicsHandler);
        frame[88].draw(graphicsHandler);
        frame[87].draw(graphicsHandler);
        frame[86].draw(graphicsHandler);
        frame[85].draw(graphicsHandler);
        frame[84].draw(graphicsHandler);
        frame[83].draw(graphicsHandler);
        frame[82].draw(graphicsHandler);
        frame[81].draw(graphicsHandler);
        frame[80].draw(graphicsHandler);
        frame[79].draw(graphicsHandler);
        frame[78].draw(graphicsHandler);
        frame[77].draw(graphicsHandler);
        frame[76].draw(graphicsHandler);
        frame[75].draw(graphicsHandler);
        frame[74].draw(graphicsHandler);
        frame[73].draw(graphicsHandler);
        frame[72].draw(graphicsHandler);
        frame[71].draw(graphicsHandler);
        frame[70].draw(graphicsHandler);
        frame[69].draw(graphicsHandler);
        frame[68].draw(graphicsHandler);
        frame[67].draw(graphicsHandler);
        frame[66].draw(graphicsHandler);
        frame[65].draw(graphicsHandler);
        frame[64].draw(graphicsHandler);
        frame[63].draw(graphicsHandler);
        frame[62].draw(graphicsHandler);
        frame[61].draw(graphicsHandler);
        frame[60].draw(graphicsHandler);
        frame[59].draw(graphicsHandler);
        frame[58].draw(graphicsHandler);
        frame[57].draw(graphicsHandler);
        frame[56].draw(graphicsHandler);
        frame[55].draw(graphicsHandler);
        frame[54].draw(graphicsHandler);
        frame[53].draw(graphicsHandler);
        frame[52].draw(graphicsHandler);
        frame[51].draw(graphicsHandler);
        frame[50].draw(graphicsHandler);
        frame[49].draw(graphicsHandler);
        frame[48].draw(graphicsHandler);
        frame[47].draw(graphicsHandler);
        frame[46].draw(graphicsHandler);
        frame[45].draw(graphicsHandler);
        frame[44].draw(graphicsHandler);
        frame[43].draw(graphicsHandler);
        frame[42].draw(graphicsHandler);
        frame[41].draw(graphicsHandler);
        frame[40].draw(graphicsHandler);
        frame[39].draw(graphicsHandler);
        frame[38].draw(graphicsHandler);
        frame[37].draw(graphicsHandler);
        frame[36].draw(graphicsHandler);
        frame[35].draw(graphicsHandler);
        frame[34].draw(graphicsHandler);
        frame[33].draw(graphicsHandler);
        frame[32].draw(graphicsHandler);
        frame[31].draw(graphicsHandler);
        frame[30].draw(graphicsHandler);
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
    }

}
