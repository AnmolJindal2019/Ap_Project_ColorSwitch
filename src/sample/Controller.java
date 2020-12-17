package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller extends loadFXML implements Variables{


    public void playButton() throws IOException
    {
        flag.set(-1);
        loadGamescreen();
        primaryStage.show();
    }

    public void homeButton() throws Exception
    {
        loadConfirmationscreen();
        primaryStage.show();

    }
    public void yesButton() throws Exception
    {
        loadHomescreen();
        pauseStage.close();
        gameoverStage.close();
        primaryStage.show();
    }

    public void exitButton() throws IOException {
        primaryStage.close();
    }

    public void helpButton() throws Exception
    {
        loadHelpscreen();
        primaryStage.show();
    }

    public void pauseButton() throws Exception
    {
        loadPausescreen();
        pauseStage.show();
    }

    public void continueButton() throws Exception
    {
        pauseStage.close();
        playTimelines(primaryStage);
    }

    public void settingButton() throws Exception
    {
        loadSettingscreen();
        primaryStage.show();
    }
    public void settingButtonP() throws Exception
    {
        loadSettingscreen2();
        pauseStage.show();
    }

    public void statButton() throws Exception
    {
        loadStatscreen();
        primaryStage.show();
    }

    public void saveButton() throws IOException, ClassNotFoundException
    {
        score.serialize(score.getScore());
        flag1.set(false);
        data = new Storage();

        //saving star ==============================
        data.setStar(st1.gp.getLayoutY() ,st2.gp.getLayoutY() ,st3.gp.getLayoutY() ,st4.gp.getLayoutY() ,st5.gp.getLayoutY() ,st6.gp.getLayoutY() ,st7.gp.getLayoutY() ,st8.gp.getLayoutY());

        //saving color switcher=========================
        data.setColorSwitcher(cs1.cs.getLayoutY() , cs2.cs.getLayoutY() , cs3.cs.getLayoutY() , cs4.cs.getLayoutY());

        //saving obstacle====================================
        data.setObs(bigcircle.gp.getLayoutY() , bigstar.bigS.getLayoutY() , octagon.gp.getLayoutY() ,rhombus.gp.getLayoutY() , square.gp.getLayoutY() ,squared.gp.getLayoutY() ,colorline.gp.getLayoutY() ,diagonals.lgp.getLayoutY() ,diagonals.rgp.getLayoutY());

        //saving ball=======================================
        data.setBallCoordinate(b.b.getCenterY());

        //saving score===================================
        data.setStarCounter(star_counter);

        //saving hand and text============================
        data.setCsText(csText.getLayoutY());
        data.setHand(hand.getLayoutY());

        //save ball color=================================
        data.setBallColor(b.getColor());

        //saving time====================================
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy\nHH:mm:ss");
        String formattedString = now.format(formatter);
        data.setTime(formattedString);

        ArrayList<Storage> list1 = new ArrayList<>();
        list1 = deserializeList();

        if(flag.get() < 0) {
            list1.add(data);
        }
        else{
            list1.set(flag.get() , data);
        }

        serializeList(list1);
    }

    public void resumeButton1() throws IOException, ClassNotFoundException
    {
        ArrayList<Storage> list = new ArrayList<>();
        list = deserializeList();
        double NUM_BUTTON_LINES = list.size();

        final double BUTTON_PADDING = 10;

        Pane root = FXMLLoader.load(getClass().getResource("resumeWindow.fxml"));
        primaryStage.setTitle("resume Window");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(BUTTON_PADDING));
        grid.setVgap(BUTTON_PADDING);
        grid.setStyle("-fx-background: #E48222");

        for (int r = 0; r < NUM_BUTTON_LINES; r++)
        {
            Button button = new Button();
            button.setPrefSize(180,80);
            button.setText(list.get(r).getTime());
            button.setFont(Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD,20));
            button.setStyle("-fx-background-color: #E48222;-fx-border-color:white; -fx-border-width: 5px;-fx-text-fill: white;" );
            grid.add(button, 1, r);

            AtomicInteger x = new AtomicInteger();
            x.set(r);

            ArrayList<Storage> l = list;

            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    flag.set(x.get());
                    try
                    {
                        loadContinueGameScreen(l.get(x.get()));
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            });
        }

        ScrollPane scrollPane = (ScrollPane) root.lookup("#scrollpaneforresume");
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: #272727");
        scrollPane.setContent(grid);
        primaryStage.setScene(new Scene(root, 400, 800));
        primaryStage.show();
    }

    public void overContinueButton() throws IOException {
        if(score.getScore() >= 10)
        {
            loadConfirmContinueScreen();
            confirmStage.show();
        }
        else
        {
            loadCantConfirmContinueScreen();
            cantconfirmStage.show();;
        }
    }

    public void confirmTickButton() throws IOException {
        score.setScore(score.getScore() - 10);
        score.serialize(score.getScore());
        stext.setText(Long.toString(score.getScore()));
        confirmStage.close();
        gameoverStage.close();
        b.b.setCenterY(b.b.getCenterY() + 90);
        playTimelines(primaryStage);
        primaryStage.show();
    }

    public void confirmCrossButton()
    {
        confirmStage.close();
    }

    public void confirmCantBackButton() throws IOException
    {
        cantconfirmStage.close();
    }

    public void shareButton() throws IOException
    {
        primaryStage.setOpacity(0.25);
        loadfollowScreen();
        followStage.show();
    }

    public void shareBackButton()
    {
        followStage.close();
        primaryStage.setOpacity(1);
    }

    public void facebookButton(){
        getHostServices().showDocument("https://www.facebook.com");
    }
    public void youtubeButton(){
        getHostServices().showDocument("http://www.youtube.com");
    }
    public void twitterButton(){
        getHostServices().showDocument("https://twitter.com/?lang=en");
    }
    public void instagramButton(){
        getHostServices().showDocument("https://www.instagram.com");
    }

    public void videoButton() throws IOException {

        getHostServices().showDocument("http://www.youtube.com");
        score.setScore(score.getScore() + 30);
        score.serialize(score.getScore());
        stext.setText(Long.toString(score.getScore()));
    }

    public void playMusicButton()
    {
        mFlag = !mFlag;
        if(mFlag) {
            playMusic();
            playMusicimg.setVisible(true);
            playMusicicon.setVisible(false);
            setVol.setVisible(true);
        }
        else{
            musicPlayer.setVolume(0);
            musicPlayer.stop();
            playMusicimg.setVisible(false);
            playMusicicon.setVisible(true);
            setVol.setVisible(false);
        }
    }
    public void playMusicButtonP()
    {
        mFlag = !mFlag;
        if(mFlag) {
            playMusic();
            playMusicimg.setVisible(true);
            playMusicicon.setVisible(false);
        }
        else{
            musicPlayer.setVolume(0);
            musicPlayer.stop();
            playMusicimg.setVisible(false);
            playMusicicon.setVisible(true);
        }
    }

    public void playSoundButton()
    {
        sFlag = !sFlag;
        if(sFlag)
        {
            playSoundimg.setVisible(true);
            playSoundicon.setVisible(false);
        }
        else
        {
            playSoundimg.setVisible(false);
            playSoundicon.setVisible(true);
        }

    }

    public void volumeButton() throws IOException {
        loadVolumescreen();
        primaryStage.show();
    }
}
