/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package samuraiboardgame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**********************************
  This is the main class of a Java program to play a game based on hexagonal tiles.
  The mechanism of handling hexes is in the file hexmech.java.

  Written by: M.H.
  Date: December 2012

 ***********************************/

public class SamuraiBoardGame
{
  private SamuraiBoardGame() {
		initGame();
		createAndShowGUI();
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				new SamuraiBoardGame();
				}
				});
	}

      
	//constants and global variables
        static Color Lblue = new Color(109,197,232);
	
        boolean first = true;
        
        static Image Background;
        static Image City;
        
	final static Color COLOURGRID =  Color.BLACK;	 
	final static Color COLOURONE = new Color(255,255,255,200);
	final static Color COLOURONETXT = Color.BLUE;
	final static Color COLOURTWO = new Color(0,0,0,200);
	final static Color COLOURTWOTXT = new Color(255,100,255);
	
	final static int BWIDTH = 25;//30; //board size.
        final static int BHEIGHT = 24;//25;
	final static int HEXSIZE = 40;//25;	//hex size in pixels
	final static int BORDERS = 10;//-10;  
	final static int SCRSIZE = HEXSIZE * (BHEIGHT + 1) + BORDERS*3; //screen size (vertical dimension).
        int numPlayers = 2;

	Hex[][] board = new Hex[BWIDTH][BHEIGHT];
        
        void reset()
        {
            if (first)
            {
                Background = Toolkit.getDefaultToolkit().getImage("./water_texture.jpg");
                City = Toolkit.getDefaultToolkit().getImage("./cityhex.GIF");
            }
            for (int i=0;i<BWIDTH;i++){
                   for (int j=0;j<BHEIGHT;j++) 
                   {
                           board[i][j]=new Hex(Hex.hexType.none);
                   }}
            Island();
        }
        void Island()
        {
            int x = 0;
            
                if(numPlayers >= 2)
                {
                board[7][17].setType(Hex.hexType.land);
                board[7][18].setType(Hex.hexType.city);
                board[8][18].setType(Hex.hexType.land);
                board[8][17] .setType(Hex.hexType.city);
                board[9][17].setType(Hex.hexType.land);
                board[9][16].setType(Hex.hexType.land);
                board[10][16].setType(Hex.hexType.land);
                board[10][17] .setType(Hex.hexType.city);
                board[11][16].setType(Hex.hexType.land);
                board[11][15] .setType(Hex.hexType.city);
                board[12][16].setType(Hex.hexType.land);
                board[12][17].setType(Hex.hexType.land);
                board[12][18] .setType(Hex.hexType.city);
                board[13][17].setType(Hex.hexType.land);
                board[13][16] .setType(Hex.hexType.city);
                board[13][15].setType(Hex.hexType.land);
                board[13][14] .setType(Hex.hexType.city);
                board[13][13].setType(Hex.hexType.land);
                board[14][16].setType(Hex.hexType.land);
                board[14][15].setType(Hex.hexType.land);
                board[14][14].setType(Hex.hexType.land);
                board[14][13] .setType(Hex.hexType.city);
                board[15][15] .setType(Hex.hexType.city);
                board[15][14].setType(Hex.hexType.land);
                board[15][13].setType(Hex.hexType.land);
                board[15][12].setType(Hex.hexType.land);
                board[16][15].setType(Hex.hexType.land);
                board[16][14].setType(Hex.hexType.land);
                board[16][13].setType(Hex.hexType.land);
                board[16][12] .setType(Hex.hexType.city);
                board[16][11].setType(Hex.hexType.land);
                board[16][10] .setType(Hex.hexType.city);
                board[16][9].setType(Hex.hexType.land);
                board[16][8] .setType(Hex.hexType.city);
                board[17][14].setType(Hex.hexType.land);
                board[17][13].setType(Hex.hexType.land);
                board[17][12].setType(Hex.hexType.land);
                board[17][11].setType(Hex.hexType.land);
                board[17][10].setType(Hex.hexType.land);
                board[17][9].setType(Hex.hexType.land);
                board[17][8].setType(Hex.hexType.land);
                board[18][15] .setType(Hex.hexType.city);
                board[18][14].setType(Hex.hexType.land);
                board[18][13] .setType(Hex.hexType.city);
                board[18][11] .setType(Hex.hexType.city);
                board[18][10].setType(Hex.hexType.land);
                board[18][9] .setType(Hex.hexType.city);
                }
                //Top Island
                if(numPlayers == 4)
                {
                board[15][6] .setType(Hex.hexType.city);
                board[15][5].setType(Hex.hexType.land);
                board[15][4] .setType(Hex.hexType.city);
                board[16][6].setType(Hex.hexType.land);
                board[16][5].setType(Hex.hexType.land);
                board[16][4].setType(Hex.hexType.land);
                board[16][3].setType(Hex.hexType.land);
                board[16][2] .setType(Hex.hexType.city);
                board[17][6].setType(Hex.hexType.land);
                board[17][5] .setType(Hex.hexType.city);
                board[17][4].setType(Hex.hexType.land);
                board[17][3] .setType(Hex.hexType.city);
                board[17][2].setType(Hex.hexType.land);
                board[18][7] .setType(Hex.hexType.city);
                board[18][6].setType(Hex.hexType.land);
                board[18][5].setType(Hex.hexType.land);
                board[18][4].setType(Hex.hexType.land);
                board[19][4] .setType(Hex.hexType.city);
                board[19][3].setType(Hex.hexType.land);
                board[20][4].setType(Hex.hexType.land);
                board[20][3] .setType(Hex.hexType.city);
                }
                //Bottom Islands
                if(numPlayers == 3 ||numPlayers == 4)
                {
                board[3][20] .setType(Hex.hexType.city);
                board[4][22] .setType(Hex.hexType.city);
                board[4][21].setType(Hex.hexType.land);
                board[4][20].setType(Hex.hexType.land);
                board[5][22].setType(Hex.hexType.land);
                board[5][21].setType(Hex.hexType.land);
                board[5][20].setType(Hex.hexType.land);
                board[5][19] .setType(Hex.hexType.city);
                board[6][23] .setType(Hex.hexType.city);
                board[6][22].setType(Hex.hexType.land);
                board[6][21] .setType(Hex.hexType.city);
                board[6][20].setType(Hex.hexType.land);
                board[8][20] .setType(Hex.hexType.city);
                board[8][21].setType(Hex.hexType.land);
                board[9][19].setType(Hex.hexType.land);
                board[9][20].setType(Hex.hexType.land);
                board[9][21] .setType(Hex.hexType.city);
                board[10][19] .setType(Hex.hexType.city);
                board[10][20].setType(Hex.hexType.land);
                board[10][21].setType(Hex.hexType.land);
                board[11][20] .setType(Hex.hexType.city);
                board[11][19].setType(Hex.hexType.land);
                }
        }

	void initGame(){

		hexmech.setXYasVertex(false); //RECOMMENDED: leave this as FALSE.

		hexmech.setHeight(HEXSIZE); //Either setHeight or setSize must be run to initialize the hex
		hexmech.setBorders(BORDERS);

		reset();

		
		
	}

	private void createAndShowGUI()
	{
		DrawingPanel panel = new DrawingPanel();


		//JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Samurai");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Container content = frame.getContentPane();
		content.add(panel);
		//this.add(panel);  -- cannot be done in a static context
		//for hexes in the FLAT orientation, the height of a 10x10 grid is 1.1764 * the width. (from h / (s+t))
		frame.setSize( (int)(SCRSIZE/1.23), SCRSIZE);
		frame.setResizable(false);
		frame.setLocationRelativeTo( null );
		frame.setVisible(true);
	}


	class DrawingPanel extends JPanel
	{		
		//mouse variables here
		//Point mPt = new Point(0,0);

		public DrawingPanel()
		{	
			setBackground(Hex.none);

                        
//                        
//                        drawImage(Background,1,1,
//                         getWidth(),getHeight());
                        
			MyMouseListener ml = new MyMouseListener();            
			addMouseListener(ml);
		}

		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			super.paintComponent(g2);
                        
                        
                         //g.drawImage(Background,1,1,
                         //getWidth(),getHeight(),this);
                 // BAANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANANAN
                        
			//draw grid
			for (int i=0;i<BWIDTH;i++) {
				for (int j=0;j<BHEIGHT;j++) {
					hexmech.drawHex(i,j,g2);
				}
			}
			//fill in hexes
			for (int i=0;i<BWIDTH;i++) {
				for (int j=0;j<BHEIGHT;j++) {					
					//if (board[i][j] < 0) hexmech.fillHex(i,j,COLOURONE,-board[i][j],g2);
					//if (board[i][j] > 0) hexmech.fillHex(i,j,COLOURTWO, board[i][j],g2);
                                    if(board[i][j].getType() != Hex.hexType.city)
					hexmech.fillHex(i,j,g2,board[i][j].getColor(),board[i][j].getType() );
                                    else
                                        hexmech.fillHexImage(i, j, g2, City, Hex.hexType.city);
				}
			}

			//g.setColor(Color.RED);
			//g.drawLine(mPt.x,mPt.y, mPt.x,mPt.y);
		}

		class MyMouseListener extends MouseAdapter	{	//inner class inside DrawingPanel 
			public void mouseClicked(MouseEvent e) { 
				int x = e.getX(); 
				int y = e.getY(); 
				//mPt.x = x;
				//mPt.y = y;
				Point p = new Point( hexmech.pxtoHex(e.getX(),e.getY()) );
				if (p.x < 0 || p.y < 0 || p.x >= BWIDTH || p.y >= BHEIGHT) return;

				//DEBUG: colour in the hex which is supposedly the one clicked on
				//clear the whole screen first.
				/* for (int i=0;i<BSIZE;i++) {
					for (int j=0;j<BSIZE;j++) {
						board[i][j]=EMPTY;
					}
				} */

				//What do you want to do when a hexagon is clicked?
			           System.out.println(x+ " " + y);
                                  if(x > 50 && x< 300 && y < 500 && y > 100 )
                                   System.out.println(x+ " FART");
                                   
                                   
                                board[p.x][p.y]=new Hex(Hex.hexType.city);
				repaint();
			}
                    
		}
             
                //end of MyMouseListener class 
	} // end of DrawingPanel class
}