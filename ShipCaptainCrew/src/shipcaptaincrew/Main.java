package shipcaptaincrew;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author erichoppe
 */
public class Main extends Application
{

    BorderPane root;

    HBox rowOfDice, shipRow, die1Box, die2Box, die3Box, die4Box, die5Box,
            underDie1, underDie2, underDie3, underDie4, underDie5;

    VBox topColumn, leftColumn, rightColumn, buttonColumn, labelColumn;

    Label turnLabel, currentScore, humanLabel, humanScore, computerLabel,
            computerScore, winner;

    Button rollButton, endButton;

    Game theGame;

    DieImages dieImages;
    Die die1, die2, die3, die4, die5;

    private int firstDie, secondDie, thirdDie, fourthDie, fifthDie, turn,
            tempRandom, round;

    boolean firstClick;

    public Main()
    {
        root = new BorderPane();
        topColumn = new VBox();
        leftColumn = new VBox();
        rightColumn = new VBox();
        buttonColumn = new VBox();
        labelColumn = new VBox();

        rowOfDice = new HBox();
        shipRow = new HBox();
        die1Box = new HBox();
        die2Box = new HBox();
        die3Box = new HBox();
        die4Box = new HBox();
        die5Box = new HBox();
        underDie1 = new HBox();
        underDie2 = new HBox();
        underDie3 = new HBox();
        underDie4 = new HBox();
        underDie5 = new HBox();

        rollButton = new Button("Roll Dice");
        endButton = new Button("End Turn");

        turnLabel = new Label("Turn: Human");
        currentScore = new Label("Current Score: 0");
        humanLabel = new Label("Human Score: ");
        humanScore = new Label("0");
        computerLabel = new Label("Computer Score: ");
        computerScore = new Label("0");

        theGame = new Game(this);

        round = 1; //round index
        turn = 0; //turn index (3 turns per player per round)

        dieImages = new DieImages();
        die1 = new Die(dieImages.getImages());
        die2 = new Die(dieImages.getImages());
        die3 = new Die(dieImages.getImages());
        die4 = new Die(dieImages.getImages());
        die5 = new Die(dieImages.getImages());
    }

    @Override
    public void start(Stage primaryStage)
    {

        root.setTop(topColumn);
        root.setLeft(leftColumn);
        root.setRight(rightColumn);
        root.setCenter(buttonColumn);
        root.setBottom(labelColumn);

        leftColumn.setMinWidth(100);
        leftColumn.getChildren().addAll(humanLabel, humanScore);

        rightColumn.setMinWidth(100);
        rightColumn.getChildren().addAll(computerLabel, computerScore);

        buttonColumn.getChildren().addAll(rollButton, endButton);
        buttonColumn.setSpacing(10);

        labelColumn.getChildren().addAll(turnLabel, currentScore);

        rowOfDice.setId("rowOfDice");

        shipRow.setSpacing(25);

        topColumn.getChildren().addAll(rowOfDice, shipRow);

        rowOfDice.getChildren().addAll(
                die1Box, die2Box, die3Box, die4Box, die5Box);

        die1Box.getChildren().add(die1.getdieFace());
        die2Box.getChildren().add(die2.getdieFace());
        die3Box.getChildren().add(die3.getdieFace());
        die4Box.getChildren().add(die4.getdieFace());
        die5Box.getChildren().add(die5.getdieFace());

        shipRow.getChildren().addAll(
                underDie1, underDie2, underDie3, underDie4, underDie5);

        underDie1.setMinWidth(60);
        underDie2.setMinWidth(60);
        underDie3.setMinWidth(60);
        underDie4.setMinWidth(60);
        underDie5.setMinWidth(60);

        humanLabel.setId("score");
        humanScore.setId("score");
        computerLabel.setId("score");
        computerScore.setId("score");

        rollButton.setOnAction(event ->
        {
            if (!rollButton.getText().equals("End Game")) //if not gameover
            {
                rollButton.setText("Roll Again"); //set the text to roll again
                
                if (firstClick) //if first click during 2nd or 3rd round
                {
                    rollButton.setText("Roll Again"); //change the button text
                    theGame.switchEm("computer"); //get total computer score
                    resetForNextPlayer(); //clear pics & set rollable to true
                    endButton.setVisible(true); //reveal the end turn button
                    firstClick = false;
                }
                play(); //human play
            } else // game over
            {
                theGame.switchEm(theGame.getCurrent());//current computer score
                announceWinner();
            }
            
        });

        endButton.setOnAction(event ->
        {
            turn = 0; //resets turn index
            resetForNextPlayer(); //clear pictures & set rollable to true 
            theGame.switchEm(theGame.getCurrent()); //get current human score
            playComputer();//play computer
        });

        Scene scene = new Scene(root, 600, 600);

        scene.getStylesheets().add(getClass()
                .getResource("Style.css")
                .toExternalForm());

        primaryStage.setTitle("Ship, Captain, Crew");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * This method is called when the user clicks the roll dice button; It sets
     * the current player to human, calls rollCup(), increases the turn index,
     * and if the turn index increases to 3, sets the rollButton to invisible
     * so that it can't be clicked again.
     */
    public void play()
    {
        theGame.setCurrent("human");
        rollCup();
        turn++;

        if (turn == 3)
        {
            rollButton.setVisible(false);
        }
    }

    /**
     * This method creates a new TimeLine object that is used to allow for the
     * animation of the dice; During each cycle, each Die object is passed a
     * random number which will change the image view of the die, thus creating
     * the animation of rolling Die; The animation stops after 8 cycles; When
     * the animation is finished, the current die face values are recorded to
     * be tested for ship, captain, mate, and the current score is updated.
     */
    private void rollCup()
    {
        Random random = new Random();

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(.2), (actionEvent) ->
        {
            if (die1.getRollable())
            {
                tempRandom = random.nextInt(6) + 1;
                die1.setDieFace(tempRandom);
            }

            if (die2.getRollable())
            {
                tempRandom = random.nextInt(6) + 1;
                die2.setDieFace(tempRandom);
            }

            if (die3.getRollable())
            {
                tempRandom = random.nextInt(6) + 1;
                die3.setDieFace(tempRandom);
            }

            if (die4.getRollable())
            {
                tempRandom = random.nextInt(6) + 1;
                die4.setDieFace(tempRandom);
            }

            if (die5.getRollable())
            {
                tempRandom = random.nextInt(6) + 1;
                die5.setDieFace(tempRandom);
            }
        }));
        timeline.setCycleCount(8);
        timeline.play();
        timeline.setOnFinished(event ->
        {
            getDiceValues();
            currentScore.setText("Current Score: " + getScore());
        });
    }
    
    /**
     * This method records the dice face values to be passed through the Game
     * object to be tested for Ship, Captain, and Mate.
     */
    private void getDiceValues()
    {
        firstDie = die1.getDieValue();
        secondDie = die2.getDieValue();
        thirdDie = die3.getDieValue();
        fourthDie = die4.getDieValue();
        fifthDie = die5.getDieValue();

        theGame.testEm(firstDie, secondDie, thirdDie, fourthDie, fifthDie);
    }
    
    /**
     * This method checks with the Game object to see if Mate has been achieved;
     * If it has been achieved, the score equals the sum of all the dice face
     * values; Fifteen is then subtracted from the sum for the Ship(6),
     * Captain(5), and Mate(4).
     * @return - The numerical value of the two dice that represent the 'crew'
     * and the 'booty'
     */
    public int getScore()
    {
        int score = 0;

        if (theGame.getMate())
        {
            score = firstDie + secondDie + thirdDie + fourthDie + fifthDie - 15;
        }

        return score;
    }
    
    /**
     * This method clears the Ship, Captain, Mate, Crew, and Booty pictures for
     * the next player; It also resets the 'rollable' boolean for each Die
     * object.
     */
    private void resetForNextPlayer()
    {
        underDie1.getChildren().clear();
        underDie2.getChildren().clear();
        underDie3.getChildren().clear();
        underDie4.getChildren().clear();
        underDie5.getChildren().clear();

        die1.setRollable(true);
        die2.setRollable(true);
        die3.setRollable(true);
        die4.setRollable(true);
        die5.setRollable(true);

        currentScore.setText("Current Score: 0");
    }
    
    /**
     * This method plays the computer opponent; It calls rollCup() three times
     * and then increases the round index; It then sets the text of the
     * rollButton to the respective round, hides the end button, and sets
     * firstClick to true for the next round.
     */
    public void playComputer()
    {
        rollCup();
        rollCup();
        rollCup();

        round++;
        switch (round)
        {
            case 2:
                rollButton.setText("Round II");
                endButton.setVisible(false);
                break;
            case 3:
                rollButton.setText("Round III");
                endButton.setVisible(false);
                break;
            case 4:
                rollButton.setText("End Game");
                endButton.setVisible(false);
        }

        rollButton.setVisible(true);
        firstClick = true;
    }
    
    /**
     * This method is used at the end of the three rounds; It calculates both
     * players' total scores and shows a response for the user based on the
     * outcome.
     */
    public void announceWinner()
    {
        int human = Integer.parseInt(humanScore.getText());
        int computer = Integer.parseInt(computerScore.getText());

        if (human > computer)
        {
            winner = new Label("Congrats Matey! You Won!");
        } else
        {
            winner = new Label("Arrr Matey! You lost!");
        }
        labelColumn.getChildren().clear();
        labelColumn.getChildren().add(winner);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
