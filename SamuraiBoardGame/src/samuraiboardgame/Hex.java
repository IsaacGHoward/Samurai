
package samuraiboardgame;

import java.awt.Color;
import java.awt.Graphics2D;

public class Hex{
    
enum hexType{land , none , sea, city, rice , buddah , helmet, samurai , ronin, ship, tileExchange, figureExchange }
enum cityType1{none, rice, buddah, helmet}
enum cityType2{none, rice, buddah, helmet}
enum cityType3{none, rice, buddah, helmet}

hexType type;
cityType1 type1;
cityType2 type2;
cityType3 type3;

static final Color land = new Color(204, 153, 0);
static final Color none = new Color(0, 0, 153);
static final Color city = new Color( 127, 127, 127);
     




Hex( hexType _type)
{
    type = _type;
       
}
Hex( hexType _type, cityType1 _type1, cityType2 _type2, cityType3 _type3)
{
    type = _type;
           
}
  public void setType(hexType _type)
  {
      type = _type;
  }
  public hexType getType()
  {
      return(type);
  }
 public Color getColor()
 {
    
     if (type == hexType.none)
                 return(none);
     if (type == hexType.land)
                 return(land);
     if (type == hexType.city)
                 return(city);
             
     return(Color.WHITE);
 }
  
  
  
  
  
  
  
  
  
}
