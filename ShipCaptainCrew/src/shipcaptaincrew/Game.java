package shipcaptaincrew;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author erichoppe
 */
public class Game
{
    Image image;
    ImageView imageView;
    
    Main body;
    
    private boolean ship, captain, mate; //used for testing for conditions
    private String current;
    
    public Game(Main m)
    {
        body = m; //builds a bridge between this class and the Main class        
    }
    
    public void setCurrent(String aPlayer)
    {
        current = aPlayer;
    }
    
    public String getCurrent()
    {
        return current;
    }
    
    /**
     * This method's functionality is based on the values of the ship, captain,
     * and mate booleans; If ship is false, it tests the dieArray for ship; If
     * ship is true, but captain is false, it tests the dieArray for captain; If
     * ship is true, captain is true, but mate is false, then it searches for
     * mate; If ship, captain, and mate are all true, then it searches the
     * dieArray for crew and booty.
     * @param dieArray - the integer array of dice face values populated and 
     * passed from the Main class
     */
    public void testEm(int... dieArray)
    {
        if (!ship)
        {
            testForShip(dieArray);
        }
        if (ship && !captain)
        {
            testForCaptain(dieArray);
        }
        if (ship && captain && !mate)
        {
            testForMate(dieArray);
        }
        if (ship && captain && mate)
        {
            testForCrew();
            testForBooty();
        }

    }
    
    /**
     * This method searches the dieArray for a 6; If a 6 is discovered, then
     * the ship boolean is set to true, and the corresponding underDie HBox
     * is populated with the 'Ship' image. 
     * @param dieArray - the array of die face values passed down from the
     * testEm() method, which is populated from the Main class 
     */
    private void testForShip(int[] dieArray)
    {
        for (int i = 0; i < dieArray.length; i++)
        {
            if (dieArray[i] == 6)
            {
                ship = true;
                switch (i + 1)
                {
                    case 1:
                        image = new Image("ship.png");
                        imageView = new ImageView(image);
                        body.underDie1.getChildren().add(imageView);
                        body.die1.setRollable(false);
                        break;
                    case 2:
                        image = new Image("ship.png");
                        imageView = new ImageView(image);
                        body.underDie2.getChildren().add(imageView);
                        body.die2.setRollable(false);
                        break;
                    case 3:
                        image = new Image("ship.png");
                        imageView = new ImageView(image);
                        body.underDie3.getChildren().add(imageView);
                        body.die3.setRollable(false);
                        break;
                    case 4:
                        image = new Image("ship.png");
                        imageView = new ImageView(image);
                        body.underDie4.getChildren().add(imageView);
                        body.die4.setRollable(false);
                        break;
                    case 5:
                        image = new Image("ship.png");
                        imageView = new ImageView(image);
                        body.underDie5.getChildren().add(imageView);
                        body.die5.setRollable(false);
                        break;
                } //end switch
                break;
            } //end if
        } //end for-loop
    }
    
    /**
     * This method searches the dieArray for a 5; If a 5 is discovered, then
     * the captain boolean is set to true, and the corresponding underDie HBox
     * is populated with the 'Captain' image. 
     * @param dieArray - the array of die face values passed down from the
     * testEm() method, which is populated from the Main class
     */
    private void testForCaptain(int[] dieArray)
    {
        for (int i = 0; i < dieArray.length; i++)
        {
            if (dieArray[i] == 5)
            {
                captain = true;
                switch (i + 1)
                {
                    case 1:
                        image = new Image("captain.jpg");
                        imageView = new ImageView(image);
                        body.underDie1.getChildren().add(imageView);
                        body.die1.setRollable(false);
                        break;
                    case 2:
                        image = new Image("captain.jpg");
                        imageView = new ImageView(image);
                        body.underDie2.getChildren().add(imageView);
                        body.die2.setRollable(false);
                        break;
                    case 3:
                        image = new Image("captain.jpg");
                        imageView = new ImageView(image);
                        body.underDie3.getChildren().add(imageView);
                        body.die3.setRollable(false);
                        break;
                    case 4:
                        image = new Image("captain.jpg");
                        imageView = new ImageView(image);
                        body.underDie4.getChildren().add(imageView);
                        body.die4.setRollable(false);
                        break;
                    case 5:
                        image = new Image("captain.jpg");
                        imageView = new ImageView(image);
                        body.underDie5.getChildren().add(imageView);
                        body.die5.setRollable(false);
                        break;
                } //end switch
                break;
            } //end if
        } //end for-loop
    }
    
    /**
     * This method searches the dieArray for a 4; If a 4 is discovered, then
     * the mate boolean is set to true, and the corresponding underDie HBox
     * is populated with the 'Mate' image.
     * @param dieArray - the array of die face values passed down from the
     * testEm() method, which is populated from the Main class
     */
    private void testForMate(int[] dieArray)
    {
        for (int i = 0; i < dieArray.length; i++)
        {
            if (dieArray[i] == 4)
            {
                mate = true;
                switch (i + 1)
                {
                    case 1:
                        image = new Image("mate.jpeg");
                        imageView = new ImageView(image);
                        body.underDie1.getChildren().add(imageView);
                        body.die1.setRollable(false);
                        break;
                    case 2:
                        image = new Image("mate.jpeg");
                        imageView = new ImageView(image);
                        body.underDie2.getChildren().add(imageView);
                        body.die2.setRollable(false);
                        break;
                    case 3:
                        image = new Image("mate.jpeg");
                        imageView = new ImageView(image);
                        body.underDie3.getChildren().add(imageView);
                        body.die3.setRollable(false);
                        break;
                    case 4:
                        image = new Image("mate.jpeg");
                        imageView = new ImageView(image);
                        body.underDie4.getChildren().add(imageView);
                        body.die4.setRollable(false);
                        break;
                    case 5:
                        image = new Image("mate.jpeg");
                        imageView = new ImageView(image);
                        body.underDie5.getChildren().add(imageView);
                        body.die5.setRollable(false);
                        break;
                } //end switch
                break;
            } //end if
        } //end for-loop
    }
    
    /**
     * This method shows the crew pictures which is the second to last picture
     * to be shown; Since crew can be either of the last two slots, this method
     * checks each underDie HBox for the first empty one; Once an empty HBox has
     * been discovered, the method assigns that slot and the crew image and
     * calls return to end the method.
     */
    private void testForCrew()
    {
        image = new Image("crew.jpeg");
        imageView = new ImageView(image);

        if (body.underDie1.getChildren().isEmpty())
        {
            body.underDie1.getChildren().add(imageView);
            return;
        }
        if (body.underDie2.getChildren().isEmpty())
        {
            body.underDie2.getChildren().add(imageView);
            return;
        }
        if (body.underDie3.getChildren().isEmpty())
        {
            body.underDie3.getChildren().add(imageView);
            return;
        }
        if (body.underDie4.getChildren().isEmpty())
        {
            body.underDie4.getChildren().add(imageView);
            return;
        }
        if (body.underDie5.getChildren().isEmpty())
        {
            body.underDie5.getChildren().add(imageView);
        }

    }

    /**
     * This method shows the booty picture, which is the last to be achieved; To
     * make sure that the booty image is assigned to correct die, the method
     * checks each underDie HBox to see if it's empty; There should only be one
     * empty slot, so as soon as the correct HBox is found, return is called to
     * end the method.
     */
    private void testForBooty()
    {
        image = new Image("treasure.jpeg");
        imageView = new ImageView(image);

        if (body.underDie1.getChildren().isEmpty())
        {
            body.underDie1.getChildren().add(imageView);
            return;
        }
        if (body.underDie2.getChildren().isEmpty())
        {
            body.underDie2.getChildren().add(imageView);
            return;
        }
        if (body.underDie3.getChildren().isEmpty())
        {
            body.underDie3.getChildren().add(imageView);
            return;
        }
        if (body.underDie4.getChildren().isEmpty())
        {
            body.underDie4.getChildren().add(imageView);
            return;
        }
        if (body.underDie5.getChildren().isEmpty())
        {
            body.underDie5.getChildren().add(imageView);
        }
    }

    /**
     * 
     * @return the status of the mate boolean.
     */
    public boolean getMate()
    {
        return mate;
    }
    
    /**
     * This method adds the current score to the current player's score label,
     * updates the turn label to the next player, and finally sets the current
     * placeholder to the opposite player; It also sets the ship, captain, and
     * mate back to false for the next player.
     * @param cTemp //used to track the current player
     */
    public void switchEm(String cTemp)
    {
        int score;
        
        if (cTemp.equals("human"))
        {
            score = Integer.parseInt(body.humanScore.getText());
            score += body.getScore();
            body.humanScore.setText("" + score);
            body.turnLabel.setText("Turn: Computer");
            current = "computer";
        } else if(cTemp.equals("computer"))
        {
            score = Integer.parseInt(body.computerScore.getText());
            score += body.getScore();
            body.computerScore.setText("" + score);
            body.turnLabel.setText("Turn: Human");
            current = "human";
        }
        
        ship = false;
        captain = false;
        mate = false;
    }
    
}
