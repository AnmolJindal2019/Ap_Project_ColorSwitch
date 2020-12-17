package sample;

import javafx.animation.*;
import javafx.application.Application;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application implements Variables{

//obstacles ============================================
    static CircleUsingArc bigcircle = new CircleUsingArc();
    static Octagon octagon = new Octagon();
    static bigStar bigstar = new bigStar();
    static square square = new square();
    static squareWithDash squared = new squareWithDash();
    static colorLine colorline = new colorLine();
    static colorDoubleLine diagonals = new colorDoubleLine();
    static rhombus rhombus = new rhombus();

//miscelleneous=============================================
    static Stage primaryStage =new Stage();
    static Stage pauseStage = new Stage();
    static Stage confirmStage =new Stage();
    static Stage cantconfirmStage = new Stage();
    static Stage gameoverStage = new Stage();
    static Stage followStage;
    static EventHandler<MouseEvent> eventHandler ;
    static EventHandler<MouseEvent> eventHandler1;
    static ball b;
    static long star_counter = 0;
    static Text text;
    static Text finalScore;
    static Text highScore;
    static Text stext;
    static Score score =new Score();
    static highScore highscore =new highScore();
    static Node csText;
    static Node hand;
    static AtomicInteger flag = new AtomicInteger();
    static AtomicBoolean flag1 = new AtomicBoolean();

    static MediaPlayer musicPlayer;
    static MediaPlayer mediaPlayer;

    static Storage data;

//stars==========================================================
    static Star st1;
    static Star st2;
    static Star st3;
    static Star st4;
    static Star st5;
    static Star st6;
    static Star st7;
    static Star st8;

//color switcher============================================================
    static colorSwitcher cs1;
    static colorSwitcher cs2;
    static colorSwitcher cs3;
    static colorSwitcher cs4;

//timelines===================================================================
    static Timeline rotateTimeline;          //rotate image
    static Timeline obsRotateTimeline;       //rotate obstacle
    static Timeline obsLateralTimeline;      //lateral move obstacle
    static Timeline obsDiagonalTimelineR;    //diagonal Timeline
    static Timeline obsDiagonalTimelineL;    //diagonal Timeline
    static Timeline obsMoveTimeline;         //move obstacle
    static Timeline obsShiftTimeline;        //change coordinate obstacle
    static Timeline ballUpTimeline;          // ball up
    static Timeline ballDownTimeline;        //ball down
    static Timeline collideTimeline;         //collision



// METHODS==============================================================================

    public static void serializeList(ArrayList<Storage> dataB) throws IOException {
        try{
            ObjectOutputStream out =new ObjectOutputStream(new FileOutputStream("database.txt"));
            out.writeObject(dataB);
            out.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
    }

    public static ArrayList<Storage> deserializeList() throws IOException, ClassNotFoundException
    {

        ArrayList<Storage> data = new ArrayList<>();
        try
        {
            ObjectInputStream in = new ObjectInputStream((new FileInputStream("database.txt")));
            data = (ArrayList) in.readObject();
            in.close();
        }
        catch(IOException ex)
        {
//            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        return data;
    }

    private void setRotate(ImageView iv, int angle)
    {
        Duration rotateDuration = Duration.millis(8000);

        KeyValue kv1 = new KeyValue(iv.rotateProperty(), 0);
        KeyValue kv2 = new KeyValue(iv.rotateProperty(), angle);

        KeyFrame kf1 = new KeyFrame(Duration.ZERO, kv1);
        KeyFrame kf2 = new KeyFrame(rotateDuration, kv2);

        rotateTimeline = new Timeline(kf1,kf2);

        rotateTimeline.setCycleCount(Animation.INDEFINITE);

        rotateTimeline.play();
    }

    private void rotateObstacle(Group gp1 , Group gp2 , Group gp3 ,Group gp4 ,Group gp5 ,Group gp6)
    {
        Duration rotateDuration = Duration.millis(7000);
        obsRotateTimeline= new Timeline(
                new KeyFrame(rotateDuration,new KeyValue(gp1.rotateProperty() ,-360) // end value of rotate
                ) ,
                new KeyFrame(rotateDuration,new KeyValue(gp2.rotateProperty() ,-360) // end value of rotate
                ) ,
                new KeyFrame(rotateDuration,new KeyValue(gp3.rotateProperty() ,-360) // end value of rotate
                ) ,
                new KeyFrame(rotateDuration,new KeyValue(gp4.rotateProperty() ,-360) // end value of rotate
                ) ,
                new KeyFrame(rotateDuration,new KeyValue(gp5.rotateProperty() ,-360) // end value of rotate
                ) ,
                new KeyFrame(rotateDuration,new KeyValue(gp6.rotateProperty() ,-360) // end value of rotate
                ));

        obsRotateTimeline.setCycleCount(Animation.INDEFINITE);
        obsRotateTimeline.play();
    }

    private void lateralObstacle(Group gp)
    {
        AtomicInteger dx= new AtomicInteger(1);
        Duration rotateDuration = Duration.millis(10);
        obsLateralTimeline= new Timeline(
                new KeyFrame(rotateDuration,
                        (evt)-> {
                            if (gp.getTranslateX() >= 600) {
                                    dx.set(-1);
                            }
                            if(gp.getTranslateX()<= -500)
                            {
                                dx.set(1);
                            }
                            gp.setTranslateX(gp.getTranslateX() + dx.get());
                        }));

        obsLateralTimeline.setCycleCount(Animation.INDEFINITE);
        obsLateralTimeline.play();
    }

    private void diagonalObstacleR(Group gp )
    {
        AtomicInteger dx =new AtomicInteger(1);
        AtomicInteger dy =new AtomicInteger(1);
        Duration rotateDuration = Duration.millis(10);
        obsDiagonalTimelineR= new Timeline(
                new KeyFrame(rotateDuration,
                        (evt)-> {
                            if (gp.getTranslateX() >= 600 && gp.getTranslateY() >= 600) {
                                dx.set(-1);
                                dy.set(-1);

                            }
                            if(gp.getTranslateX()<= -600 && gp.getTranslateY()<= -600)
                            {
                                dx.set(1);
                                dy.set(1);
                            }
                            gp.setTranslateX(gp.getTranslateX() + dx.get());
                            gp.setTranslateY(gp.getTranslateY() + dy.get());
                        }));

        obsDiagonalTimelineR.setCycleCount(Animation.INDEFINITE);
        obsDiagonalTimelineR.play();
    }
    private void diagonalObstacleL(Group gp )
    {
        AtomicInteger dx =new AtomicInteger(-1);
        AtomicInteger dy =new AtomicInteger(1);
        Duration rotateDuration = Duration.millis(10);
        obsDiagonalTimelineL= new Timeline(
                new KeyFrame(rotateDuration,
                        (evt)-> {
                            if (gp.getTranslateX() <= -600 && gp.getTranslateY() >= 600) {
                                dx.set(1);
                                dy.set(-1);

                            }
                            if(gp.getTranslateX()>= 600 && gp.getTranslateY()<= -600)
                            {
                                dx.set(-1);
                                dy.set(1);
                            }
                            gp.setTranslateX(gp.getTranslateX() + dx.get());
                            gp.setTranslateY(gp.getTranslateY() + dy.get());
                        }));

        obsDiagonalTimelineL.setCycleCount(Animation.INDEFINITE);
        obsDiagonalTimelineL.play();
    }

    private void moveBallUp(ball ball ,  Text text)
    {
        ballUpTimeline= new Timeline(new KeyFrame(Duration.millis(1.5) ,
                (evt)->{
                    ball.b.setCenterY((ball.b.getCenterY() - 1));
                    flag1.set(true);

                    if(st1.isCollide(st1 , b))
                    {
                        star_counter++;
                        text.setText(Long.toString(star_counter));
                        st1.gp.setLayoutX(1000);
                        score.setScore(score.getScore() + 1);
                    }
                    if(st2.isCollide(st2 , b))
                    {
                        star_counter++;
                        text.setText(Long.toString(star_counter));
                        st2.gp.setLayoutX(1000);
                        score.setScore(score.getScore() + 1);
                    }
                    if(st3.isCollide(st3 , b))
                    {
                        star_counter++;
                        text.setText(Long.toString(star_counter));
                        st3.gp.setLayoutX(1000);
                        score.setScore(score.getScore() + 1);
                    }
                    if(st4.isCollide(st4 , b))
                    {
                        star_counter++;
                        text.setText(Long.toString(star_counter));
                        st4.gp.setLayoutX(1000);
                        score.setScore(score.getScore() + 1);
                    }
                    if(st5.isCollide(st5 , b))
                    {
                        star_counter++;
                        text.setText(Long.toString(star_counter));
                        st5.gp.setLayoutX(1000);
                        score.setScore(score.getScore() + 1);
                    }
                    if(st6.isCollide(st6 , b))
                    {
                        star_counter++;
                        text.setText(Long.toString(star_counter));
                        st6.gp.setLayoutX(1000);
                        score.setScore(score.getScore() + 1);
                    }
                    if(st7.isCollide(st7 , b))
                    {
                        star_counter++;
                        text.setText(Long.toString(star_counter));
                        st7.gp.setLayoutX(1000);
                        score.setScore(score.getScore() + 1);
                    }
                    if(st8.isCollide(st8 , b))
                    {
                        star_counter++;
                        text.setText(Long.toString(star_counter));
                        st8.gp.setLayoutX(1000);
                        score.setScore(score.getScore() + 1);
                    }

                    if(cs1.isCollide(cs1 , b) )
                    {
                        System.out.println("color changed");
                        ball.changeColor(pallete);
                        cs1.cs.setLayoutX(1000);
                    }
                    if( cs2.isCollide(cs2 , b))
                    {
                        System.out.println("color changed");
                        ball.changeColor(pallete);
                        cs2.cs.setLayoutX(1000);
                    }
                    if( cs3.isCollide(cs3 , b))
                    {
                        System.out.println("color changed");
                        ball.changeColor(pallete);
                        cs3.cs.setLayoutX(1000);
                    }
                    if(cs4.isCollide(cs4 , b))
                    {
                        System.out.println("color changed");
                        ball.changeColor(pallete);
                        cs4.cs.setLayoutX(1000);
                    }
                }));

        ballUpTimeline.setCycleCount(100);
    }

    private void moveBallDown(ball ball)
    {
        ballDownTimeline = new Timeline(new KeyFrame(Duration.millis(2.5) ,
                (evt)-> {
            ball.b.setCenterY((ball.b.getCenterY() + 0.5));
            flag1.set(false);
        }));
        ballDownTimeline.setCycleCount(Animation.INDEFINITE);
    }

    public static void pauseTimelines(Stage gamescreen)
    {
        rotateTimeline.pause();          //rotate image
        obsRotateTimeline.pause();       //rotate obstacle
        obsLateralTimeline.pause();      //lateral move obstacle
        obsDiagonalTimelineR.pause();    //diagonal Timeline
        obsDiagonalTimelineL.pause();    //diagonal Timeline
        obsMoveTimeline.pause();         //move obstacle
        obsShiftTimeline.pause();        //change coordinate obstacle
        collideTimeline.pause();         //collision

        ballDownTimeline.pause();
        ballUpTimeline.pause();
        gamescreen.removeEventFilter(MouseEvent.MOUSE_PRESSED, eventHandler);
        gamescreen.removeEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler1);
        flag1.set(false);
    }

    public static void playTimelines(Stage gamescreen)
    {
        flag1.set(false);
        rotateTimeline.play();          //rotate image
        obsRotateTimeline.play();       //rotate obstacle
        obsLateralTimeline.play();      //lateral move obstacle
        obsDiagonalTimelineR.play();    //diagonal Timeline
        obsDiagonalTimelineL.play();    //diagonal Timeline
        obsMoveTimeline.play();         //move obstacle
        collideTimeline.play();         //collision
        gamescreen.addEventFilter(MouseEvent.MOUSE_PRESSED, eventHandler);
        gamescreen.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler1);
    }

    private void loadGameOverScreen() throws Exception {
        score.serialize(score.getScore());
        Pane root1 = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
        gameoverStage.setTitle("Game Over");

        if(highscore.getHighScore() < star_counter)
        {
            highscore.setHighScore(star_counter);
            highscore.serialize(star_counter);
        }

        stext = new Text();
        stext.setTranslateX(30);
        stext.setTranslateY(190);
        stext.setFontSmoothingType(FontSmoothingType.LCD);
        stext.setFill(Color.web("#FFD700"));
        stext.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));
        stext.setText(Long.toString(score.getScore()));

        Text stext1 = new Text();
        stext1.setTranslateX(180);
        stext1.setTranslateY(-110);
        stext1.setFontSmoothingType(FontSmoothingType.LCD);
        stext1.setFill(Color.WHITE);
        stext1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        stext1.setText(Long.toString(star_counter));

        Text stext2 = new Text();
        stext2.setTranslateX(180);
        stext2.setTranslateY(30);
        stext2.setFontSmoothingType(FontSmoothingType.LCD);
        stext2.setFill(Color.WHITE);
        stext2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        stext2.setText(Long.toString(highscore.getHighScore()));

        root1.getChildren().addAll(stext , stext1 ,stext2);
        gameoverStage.setScene(new Scene(root1 , 400, 800));

        pauseTimelines(primaryStage);
        primaryStage.hide();
        gameoverStage.show();
    }

    public void setStars(double y_st1 , double y_st2 ,double y_st3 ,double y_st4 ,double y_st5 ,double y_st6 ,double y_st7 ,double y_st8)
    {
        //stars===================================================
        st1 =new Star(200 , y_st1 , 40);
        st2 =new Star(200 , y_st2 , 40);
        st3 =new Star(200 , y_st3 , 40);
        st4 =new Star(200 , y_st4 , 40);
        st5 =new Star(200 , y_st5 , 40);
        st6 =new Star(200 , y_st6 , 40);
        st7 =new Star(200 , y_st7 , 40);
        st8 =new Star(200 , y_st8 , 40);
    }
    public void setStarsLayout(double y_st1 , double y_st2 ,double y_st3 ,double y_st4 ,double y_st5 ,double y_st6 ,double y_st7 ,double y_st8)
    {
        //stars===================================================
        st1.gp.setLayoutY(y_st1);
        st2.gp.setLayoutY(y_st2);
        st3.gp.setLayoutY(y_st3);
        st4.gp.setLayoutY(y_st4);
        st5.gp.setLayoutY(y_st5);
        st6.gp.setLayoutY(y_st6);
        st7.gp.setLayoutY(y_st7);
        st8.gp.setLayoutY(y_st8);
    }

    public void setCs(double y_cs1 , double y_cs2 ,double y_cs3 ,double y_cs4 ) throws IOException {
        //color switcher=========================================
        cs1 = new colorSwitcher();
        cs1.set(180,y_cs1,46,46);
        cs2 = new colorSwitcher();
        cs2.set(180,y_cs2,46,46);
        cs3 = new colorSwitcher();
        cs3.set(180,y_cs3,46,46);
        cs4 = new colorSwitcher();
        cs4.set(180,y_cs4,46,46);
    }

    public void setCsLayout(double y_cs1 , double y_cs2 ,double y_cs3 ,double y_cs4 ) throws IOException {
        //color switcher=========================================
        cs1.cs.setLayoutY(y_cs1);
        cs2.cs.setLayoutY(y_cs2);
        cs3.cs.setLayoutY(y_cs3);
        cs4.cs.setLayoutY(y_cs4);

    }

    public void setObstacles(double y_obs1 , double y_obs2 ,double y_obs3 ,double y_obs4 ,double y_obs5 ,double y_obs6 ,double y_obs7 ,double y_obs8 )
    {
        //obstacles========================================
        bigcircle.create(200,y_obs1,120,105);
        bigstar.create(150,y_obs2);
        octagon.create(200,y_obs3,120);
        rhombus.create(200 , y_obs4 , 200);
        square.create(200,y_obs5,200);
        squared.create(200 , y_obs6  ,200);
        colorline.create(200,y_obs7 , 400);
        diagonals.create(200 , y_obs8 , 565);
    }

    public void setObstaclesLayout(double y_obs1 , double y_obs2 ,double y_obs3 ,double y_obs4 ,double y_obs5 ,double y_obs6 ,double y_obs7 ,double y_obs8 )
    {
        //obstacles========================================
        bigcircle.gp.setLayoutY(y_obs1);
        bigstar.bigS.setLayoutY(y_obs2);
        octagon.gp.setLayoutY(y_obs3);
        rhombus.gp.setLayoutY(y_obs4);
        square.gp.setLayoutY(y_obs5);
        squared.gp.setLayoutY(y_obs6);
        colorline.gp.setLayoutY(y_obs8);
        diagonals.rgp.setLayoutY(y_obs8);
        diagonals.lgp.setLayoutY(y_obs8);
    }

    public void setBall(double y_b  )
    {
        b = new ball(y_b);
    }

    public void gameCode(Stage gamescreen) throws IOException
    {
        text = new Text();
        text.setLayoutX(10);
        text.setLayoutY(63);
        text.setFontSmoothingType(FontSmoothingType.LCD);
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 65));
        text.setText(Long.toString(star_counter));

        // moving obstacles============================================
        rotateObstacle(bigcircle.gp , bigstar.bigS,  octagon.gp,  rhombus.gp , square.gp, squared.gp);
        lateralObstacle(colorline.gp);
        diagonalObstacleR(diagonals.rgp);
        diagonalObstacleL(diagonals.lgp);

        //moving ball==================================================
        moveBallUp(b,text);
        moveBallDown(b);

       eventHandler = e -> ballUpTimeline.play();
       eventHandler1 = e -> ballDownTimeline.play();
       gamescreen.addEventFilter(MouseEvent.MOUSE_PRESSED, eventHandler);
       gamescreen.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler1);
    }

    public void collide()
    {
        collideTimeline = new Timeline(new KeyFrame(Duration.millis(100) ,
                (evt)-> {
                        if(bigcircle.isCollide(bigcircle, b) || octagon.isCollide(octagon, b) || bigstar.isCollide(bigstar, b) || rhombus.isCollide(rhombus, b) ||
                            colorline.isCollide(colorline, b) || diagonals.isCollide(diagonals, b) || square.isCollide(square, b) || squared.isCollide(squared, b)
                            || b.b.getCenterY()>=800)
                        {
                            pauseTimelines(primaryStage);

                            System.out.println("gameover");
                            try {
                                loadGameOverScreen();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                }));

        collideTimeline.setCycleCount(Animation.INDEFINITE);
        collideTimeline.play();
    }

    public void moveObstacle()
    {
        obsShiftTimeline = new Timeline(new KeyFrame(Duration.millis(4) ,
                (evt)-> {
                    //obstacles================================================
                        bigcircle.gp.setLayoutY(bigcircle.gp.getLayoutY() + 1);
                        bigstar.bigS.setLayoutY(bigstar.bigS.getLayoutY() + 1);
                        octagon.gp.setLayoutY(octagon.gp.getLayoutY() + 1);
                        rhombus.gp.setLayoutY(rhombus.gp.getLayoutY() + 1);
                        square.gp.setLayoutY(square.gp.getLayoutY() + 1);
                        squared.gp.setLayoutY(squared.gp.getLayoutY() + 1);
                        colorline.gp.setLayoutY(colorline.gp.getLayoutY() + 1);
                        diagonals.lgp.setLayoutY(diagonals.lgp.getLayoutY() + 1);
                        diagonals.rgp.setLayoutY(diagonals.rgp.getLayoutY() + 1);

                    //stars====================================================
                        st1.gp.setLayoutY(st1.gp.getLayoutY() + 1);
                        st2.gp.setLayoutY(st2.gp.getLayoutY() + 1);
                        st3.gp.setLayoutY(st3.gp.getLayoutY() + 1);
                        st4.gp.setLayoutY(st4.gp.getLayoutY() + 1);
                        st5.gp.setLayoutY(st5.gp.getLayoutY() + 1);
                        st6.gp.setLayoutY(st6.gp.getLayoutY() + 1);
                        st7.gp.setLayoutY(st7.gp.getLayoutY() + 1);
                        st8.gp.setLayoutY(st8.gp.getLayoutY() + 1);

                    //color switcher============================================
                        cs1.cs.setLayoutY(cs1.cs.getLayoutY() + 1);
                        cs2.cs.setLayoutY(cs2.cs.getLayoutY() + 1);
                        cs3.cs.setLayoutY(cs3.cs.getLayoutY() + 1);
                        cs4.cs.setLayoutY(cs4.cs.getLayoutY() + 1);

                    //misc ===================================================
                        csText.setLayoutY(csText.getLayoutY() + 1);
                        hand.setLayoutY(hand.getLayoutY() + 1);

                }));

        obsShiftTimeline.setCycleCount(50);

        obsMoveTimeline = new Timeline(new KeyFrame(Duration.millis(1) ,
                (evt)->{

                    if(flag1.get() && 400 - b.b.getCenterY() > 0)
                    {
                        obsShiftTimeline.play();

                        if(bigcircle.gp.getLayoutY() >= 3500)
                        {
                            bigcircle.gp.setLayoutY(-500);
                            st1.gp.setLayoutY(-500);
                            st1.gp.setLayoutX(0);
                            cs1.cs.setLayoutY(-400);
                            cs1.cs.setLayoutX(0);
                        }
                        if(bigstar.bigS.getLayoutY()>=4000 )
                        {
                            bigstar.bigS.setLayoutY(0);
                            st2.gp.setLayoutY(0);
                            st2.gp.setLayoutX(0);
                        }
                        if(octagon.gp.getLayoutY()>=4500)
                        {
                            octagon.gp.setLayoutY(500);
                            st3.gp.setLayoutY(500);
                            st3.gp.setLayoutX(0);

                        }
                        if(rhombus.gp.getLayoutY()>=5000)
                        {
                            rhombus.gp.setLayoutY(1000);
                            st4.gp.setLayoutY(1000);
                            st4.gp.setLayoutX(0);
                            cs3.cs.setLayoutY(980);
                            cs3.cs.setLayoutX(0);
                        }
                        if(square.gp.getLayoutY()>=5500)
                        {
                            square.gp.setLayoutY(1500);
                            st5.gp.setLayoutY(1500);
                            st5.gp.setLayoutX(0);

                        }
                        if(squared.gp.getLayoutY()>=6000)
                        {
                            squared.gp.setLayoutY(2000);
                            st6.gp.setLayoutY(2000);
                            st6.gp.setLayoutX(0);
                            cs4.cs.setLayoutY(1900);
                            cs4.cs.setLayoutX(0);

                        }
                        if(colorline.gp.getLayoutY()>=6500)
                        {
                            colorline.gp.setLayoutY(2500);
                            st7.gp.setLayoutY(2500);
                            st7.gp.setLayoutX(0);
                            cs2.cs.setLayoutY(2400);
                            cs2.cs.setLayoutX(0);
                        }
                        if(diagonals.lgp.getLayoutY()>=7000)
                        {
                            diagonals.lgp.setLayoutY(3000);
                            st8.gp.setLayoutY(3000);
                            st8.gp.setLayoutX(0);
                        }
                        if(diagonals.rgp.getLayoutY()>=7000)
                        {
                            diagonals.rgp.setLayoutY(3000);
                        }
                    }
                }));
        obsMoveTimeline.setCycleCount(Animation.INDEFINITE);
        obsMoveTimeline.play();
    }

    private void playMusic()
    {
        String mainSoundPath = "D:\\Ap Project\\src\\sample\\sounds\\mainsong.mp3";
        Media mainSound = new Media(new File(mainSoundPath).toURI().toString());
        mediaPlayer = new MediaPlayer(mainSound);
//        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.1);
        mediaPlayer.setOnReady(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.play();
            }
        });
    }

@Override
    public void start(Stage stage) throws Exception
    {
        playMusic();
        long val = score.deserialize();
        score.setScore(val);

        long hval = highscore.deserialize();
        highscore.setHighScore(hval);

        Pane root = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
        primaryStage.setTitle("Color Switch Game");

        //Creating an image
        Image img1 = new Image(new FileInputStream("D:\\Ap Project\\src\\sample\\images\\circle (2).png"));
        Image img2 = new Image(new FileInputStream("D:\\Ap Project\\src\\sample\\images\\bigcircle.png"));
        Image img3 = new Image(new FileInputStream("D:\\Ap Project\\src\\sample\\images\\bigcircle.png"));
        Image img4 = new Image(new FileInputStream("D:\\Ap Project\\src\\sample\\images\\bigcircle.png"));

        //Setting the image view
        ImageView c1 = new ImageView(img1);
        ImageView c2 = new ImageView(img1);
        ImageView c3 = new ImageView(img2);
        ImageView c4 = new ImageView(img3);
        ImageView c5 = new ImageView(img4);

        //Setting the position of the image
        c1.setX(127); c1.setY(26);
        c2.setX(222); c2.setY(26);
        c3.setX(9);   c3.setY(180);
        c4.setX(54);  c4.setY(226);
        c5.setX(92);  c5.setY(265);

        //setting the fit height and width of the image view
        c1.setFitHeight(52);
        c1.setFitWidth(61);
        c2.setFitHeight(52);
        c2.setFitWidth(61);
        c3.setFitHeight(387);
        c3.setFitWidth(393);
        c4.setFitHeight(298);
        c4.setFitWidth(290);
        c5.setFitHeight(220);
        c5.setFitWidth(219);

        //Setting the preserve ratio of the image view
        c1.setPreserveRatio(true);
        c2.setPreserveRatio(true);
        c3.setPreserveRatio(true);
        c4.setPreserveRatio(true);
        c5.setPreserveRatio(true);

        setRotate(c1 , -720);
        setRotate(c2 , 720);
        setRotate(c3 , 720);
        setRotate(c4 , -720);
        setRotate(c5 , 720);

        root.getChildren().addAll(c1,c2,c3,c4,c5);

        primaryStage.setScene(new Scene(root , 400, 800));
        primaryStage.show();

    }
    public static void main(String[] args){launch(args);}
}



