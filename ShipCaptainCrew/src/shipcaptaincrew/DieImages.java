package shipcaptaincrew;

import javafx.scene.image.Image;

/**
 *
 * @author erichoppe
 */
public class DieImages
{
    final Image die1 = new Image("die1.png");
    final Image die2 = new Image("die2.png");
    final Image die3 = new Image("die3.png");
    final Image die4 = new Image("die4.png");
    final Image die5 = new Image("die5.png");
    final Image die6 = new Image("die6.png");

    final Image[] images = new Image[6];

    /**
     * This class simply creates an array of Images which can used in
     * conjunction with the Die class.
     */
    public DieImages()
    {
        images[0] = die1;
        images[1] = die2;
        images[2] = die3;
        images[3] = die4;
        images[4] = die5;
        images[5] = die6;
    }

    public Image[] getImages()
    {
        return images;
    }
}
