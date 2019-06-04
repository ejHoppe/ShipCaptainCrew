package shipcaptaincrew;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author erichoppe
 */

public class Die
{

    ImageView dieFace;
    Image[] images;
    int dieValue;
    boolean rollable; //used to stop the die from rolling if S,C, or M is found
    
    
    /**
     * This method sets the dieFace to default image
     * @param images - the Image array created in the DieImages class 
     */
    public Die(Image[] images)
    {
        this.images = images;
        dieFace = new ImageView(this.images[0]);//set default to image 0
        rollable = true;
    }
    
    /**
     * This method sets the dieFace to a specific die image
     * @param images - the Image array created in the DieImages class
     * @param dieFaceValue - the specific value which is to be shown on the die
     */
    public Die(Image[] images, int dieFaceValue)
    {
        this.images = images;
        
        //index starts at 0
        dieFace = new ImageView(this.images[dieFaceValue - 1]);
        rollable = true;
    }

    public ImageView getdieFace()
    {
        return dieFace;
    }

    public void setDieFace(int dieFaceValue)
    {
        dieFace.setImage(this.images[dieFaceValue - 1]); //index starts at 0
        this.dieValue = dieFaceValue;
    }
    
    public int getDieValue()
    {
        return dieValue;
    }
    
    public boolean getRollable()
    {
        return rollable;
    }
    
    public void setRollable(boolean aBool)
    {
        rollable = aBool;
    }
}
