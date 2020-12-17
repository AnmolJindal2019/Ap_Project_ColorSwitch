package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class loadFXML extends Main{
    public void loadGamescreen() throws IOException {
        Pane root1 = FXMLLoader.load(getClass().getResource("gamescreen.fxml"));
        primaryStage.setTitle("Color Switch Game");
        primaryStage.setScene(new Scene(root1 , 400, 800));

        csText = root1.lookup("#switchText");
        hand = root1.lookup("#hand");
        //creating ball====================================================
        setBall(603);

        //creating stars=====================================================
        setStars(200  ,-350  ,-800  , -1300 ,-1800 ,-2300 ,-2850 ,-3380);

        //creating color switcher=====================================================
        setCs(360 , -2600 , -1080 , -2000);

        //creating obstacles=====================================================
        setObstacles(200 , -300 , -800 , -1300 , -1800  , -2300 , -2800 , -3300);

        //resetting score====================================================
        star_counter = 0;

        gameCode(primaryStage);

        root1.getChildren().addAll(b.b , text , octagon.gp , bigcircle.gp , bigstar.bigS , rhombus.gp , colorline.gp , square.gp , squared.gp ,diagonals.rgp ,  diagonals.lgp);
        root1.getChildren().addAll(st1.gp , st2.gp ,st3.gp ,st4.gp ,st5.gp ,st6.gp ,st7.gp ,st8.gp);
        root1.getChildren().addAll(cs1.cs ,cs2.cs ,cs3.cs ,cs4.cs );

        collide();
        moveObstacle();
    }

    public void loadContinueGameScreen(Storage st) throws IOException {
        Pane root1 = FXMLLoader.load(getClass().getResource("gamescreen.fxml"));
        primaryStage.setTitle("Color Switch Game");
        primaryStage.setScene(new Scene(root1 , 400, 800));
        //creating stars=====================================================
        setStars(200  ,-350  ,-800  , -1300 ,-1800 ,-2300 ,-2850 ,-3380);

        //creating color switcher=====================================================
        setCs(360 , -2600 , -1080 , -2000);

        //creating obstacles=====================================================
        setObstacles(200 , -300 , -800 , -1300 , -1800  , -2300 , -2800 , -3300);

        setBall(st.getBallCoordinate());
        b.b.setFill(Color.web(pallete[st.getColor()]));

        setStarsLayout(st.getStar1(), st.getStar2(),st.getStar3(),st.getStar4(),st.getStar5(),st.getStar6(),st.getStar7(),st.getStar8());
        setCsLayout(st.getColorSwitcher1(),st.getColorSwitcher2(),st.getColorSwitcher3(),st.getColorSwitcher4());
        setObstaclesLayout(st.getArcCoordinate() ,st.getBigStarCoordinate() , st.getOctagonCoordinate() , st.getRhombusCoordinate()  ,st.getSquareCoordinate() , st.getDotSquareCoordinate() ,st.getColorLineCoordinate() , st.getCrossLineCoordinateL());

        csText = root1.lookup("#switchText");
        hand = root1.lookup("#hand");
        hand.setLayoutY(st.getHand());
        csText.setLayoutY(st.getCsText());

        star_counter = st.getStarCounter();

        flag1.set(false);
        gameCode(primaryStage);

        root1.getChildren().addAll(b.b , text , octagon.gp , bigcircle.gp , bigstar.bigS , rhombus.gp , colorline.gp , square.gp , squared.gp ,diagonals.rgp ,  diagonals.lgp);
        root1.getChildren().addAll(st1.gp , st2.gp ,st3.gp ,st4.gp ,st5.gp ,st6.gp ,st7.gp ,st8.gp);
        root1.getChildren().addAll(cs1.cs ,cs2.cs ,cs3.cs ,cs4.cs );

        collide();
        moveObstacle();
    }

    public void loadHomescreen() throws Exception {
        start(primaryStage);
    }

    public void loadHelpscreen() throws Exception {
        Pane root1 = FXMLLoader.load(getClass().getResource("HelpWindow.fxml"));
        primaryStage.setTitle("Help Window");
        primaryStage.setScene(new Scene(root1 , 400, 800));
    }

    public void loadPausescreen() throws Exception {
        pauseTimelines(primaryStage);
        Pane root1 = FXMLLoader.load(getClass().getResource("pauseWindow.fxml"));
        pauseStage.setTitle("Pause Window");
        pauseStage.setOpacity(0.96);
        pauseStage.setScene(new Scene(root1 , 400, 800));
    }

    public void loadSettingscreen() throws Exception {
        Pane root1 = FXMLLoader.load(getClass().getResource("setting.fxml"));
        primaryStage.setTitle("setting Window");

        playSoundimg = root1.lookup("#img");
        playMusicimg = root1.lookup("#img1");
        playSoundicon = root1.lookup("#stopIcon1");
        playMusicicon = root1.lookup("#stopIcon");
        setVol = root1.lookup("#img2");
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
        if(mFlag)
        {
            playMusicimg.setVisible(true);
            playMusicicon.setVisible(false);
            setVol.setVisible(true);
        }
        else
        {
            playMusicimg.setVisible(false);
            playMusicicon.setVisible(true);
            setVol.setVisible(true);
        }


        primaryStage.setScene(new Scene(root1 , 400, 800));
    }

    public void loadSettingscreen2() throws Exception {
        Pane root1 = FXMLLoader.load(getClass().getResource("setting_pause.fxml"));
        pauseStage.setTitle("setting Window");
        playSoundimg = root1.lookup("#img");
        playMusicimg = root1.lookup("#img1");
        playSoundicon = root1.lookup("#stopIcon1");
        playMusicicon = root1.lookup("#stopIcon");
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
        if(mFlag)
        {
            playMusicimg.setVisible(true);
            playMusicicon.setVisible(false);
        }
        else
        {
            playMusicimg.setVisible(false);
            playMusicicon.setVisible(true);
        }
        pauseStage.setScene(new Scene(root1 , 400, 800));
    }

    public void loadConfirmationscreen() throws Exception {
        Pane root1 = FXMLLoader.load(getClass().getResource("confirmationWindow.fxml"));
        pauseStage.setTitle("setting Window");
        pauseStage.setScene(new Scene(root1 , 400, 500));
    }

    public void loadStatscreen() throws Exception {
        Pane root1 = FXMLLoader.load(getClass().getResource("Stats.fxml"));


        finalScore= new Text();
        finalScore.setTranslateX(277);
        finalScore.setTranslateY(64);
        finalScore.setFontSmoothingType(FontSmoothingType.LCD);
        finalScore.setFill(Color.web("#FFD700"));
        finalScore.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        finalScore.setText(Long.toString(score.getScore()));

        highScore= new Text();
        highScore.setTranslateX(277);
        highScore.setTranslateY(2);
        highScore.setFontSmoothingType(FontSmoothingType.LCD);
        highScore.setFill(Color.web("#FFD700"));
        highScore.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        highScore.setText(Long.toString(highscore.getHighScore()));

        root1.getChildren().addAll(finalScore ,highScore);

        primaryStage.setTitle("Stats Window");
        primaryStage.setScene(new Scene(root1 , 400, 800));
    }

    public void loadConfirmContinueScreen() throws IOException {
        Pane root1 = FXMLLoader.load(getClass().getResource("confirmationContinueWindow.fxml"));
        confirmStage.setTitle("Confirmation Window");
        confirmStage.setScene(new Scene(root1 , 400, 500));
    }

    public void loadCantConfirmContinueScreen() throws IOException {
        Pane root1 = FXMLLoader.load(getClass().getResource("can'tcontinue.fxml"));
        cantconfirmStage.setTitle("Confirmation Window");
        cantconfirmStage.setScene(new Scene(root1 , 400, 500));
    }

    public void loadfollowScreen() throws IOException {
        Pane root1 = FXMLLoader.load(getClass().getResource("followUs.fxml"));
        followStage = new Stage();
        followStage.initStyle(StageStyle.TRANSPARENT);
        followStage.setTitle("Confirmation Window");
        followStage.setScene(new Scene(root1 , 320, 400));
    }
    public void loadVolumescreen() throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("VolumeWindow.fxml"));
        primaryStage.setTitle("Hello World");

        Text txt = (Text) root.lookup("#txt");
        txt.setFill(Color.web("#FFD700"));


        Slider slider = (Slider) root.lookup("#sliderForVolume");

        slider.setValue(musicPlayer.getVolume() *100);
        txt.setText(Integer.toString((int) Math.round((musicPlayer.getVolume() *100))));

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                                Number oldValue, Number newValue) {

                System.out.println((int)Math.round((Double) newValue));
                musicPlayer.setVolume((double) newValue/100);
                txt.setText(Integer.toString((int)Math.round((Double) newValue)));
            }
        });
        primaryStage.setScene(new Scene(root, 400, 800));
    }
}
