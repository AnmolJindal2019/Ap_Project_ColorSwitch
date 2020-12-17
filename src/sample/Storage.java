package sample;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.*;

class Storage extends Main implements Serializable
{
    private long starCounter;
    private double arcCoordinate, bigStarCoordinate, octagonCoordinate, rhombusCoordinate, squareCoordinate, dotSquareCoordinate, colorLineCoordinate, crossLineCoordinateL, crossLineCoordinateR ,star1, star2, star3, star4, star5, star6, star7, star8, colorSwitcher1, colorSwitcher2, colorSwitcher3, colorSwitcher4, ballCoordinate;
    private double csText , Hand;
    private String time;
    private int ballColor;

    public String getTime() {
        return time;
    }

    public int getColor() {
        return ballColor;
    }

    public long getStarCounter() {
        return starCounter;
    }

    public double getArcCoordinate() {
        return arcCoordinate;
    }

    public double getBigStarCoordinate() {
        return bigStarCoordinate;
    }

    public double getOctagonCoordinate() {
        return octagonCoordinate;
    }

    public double getRhombusCoordinate() {
        return rhombusCoordinate;
    }

    public double getSquareCoordinate() {
        return squareCoordinate;
    }

    public double getDotSquareCoordinate() {
        return dotSquareCoordinate;
    }

    public double getColorLineCoordinate() {
        return colorLineCoordinate;
    }

    public double getCrossLineCoordinateL() {
        return crossLineCoordinateL;
    }
    public double getCrossLineCoordinateR() {
        return crossLineCoordinateR;
    }

    public double getBallCoordinate() {
        return ballCoordinate;
    }

    public double getColorSwitcher1() {
        return colorSwitcher1;
    }

    public double getColorSwitcher2() {
        return colorSwitcher2;
    }

    public double getColorSwitcher3() {
        return colorSwitcher3;
    }

    public double getColorSwitcher4() {
        return colorSwitcher4;
    }

    public double getStar1() {
        return star1;
    }

    public double getStar2() {
        return star2;
    }

    public double getStar3() {
        return star3;
    }

    public double getStar4() {
        return star4;
    }

    public double getStar5() {
        return star5;
    }

    public double getStar6() {
        return star6;
    }

    public double getStar7() {
        return star7;
    }

    public double getStar8() {
        return star8;
    }

    public double getCsText(){
        return csText;
    }

    public double getHand(){
        return Hand;
    }

    public void setTime(String time){this.time =time;}

    public void setStarCounter(long starCounter) {
        this.starCounter = starCounter;
    }

    public void setArcCoordinate(double arcCoordinate) {
        this.arcCoordinate = arcCoordinate;
    }

    public void setBigStarCoordinate(double bigStarCoordinate) {
        this.bigStarCoordinate = bigStarCoordinate;
    }

    public void setOctagonCoordinate(double octagonCoordinate) {
        this.octagonCoordinate = octagonCoordinate;
    }

    public void setRhombusCoordinate(double rhombusCoordinate) {
        this.rhombusCoordinate = rhombusCoordinate;
    }

    public void setSquareCoordinate(double squareCoordinate) {
        this.squareCoordinate = squareCoordinate;
    }

    public void setDotSquareCoordinate(double dotSquareCoordinate) {
        this.dotSquareCoordinate = dotSquareCoordinate;
    }

    public void setColorLineCoordinate(double colorLineCoordinate) {
        this.colorLineCoordinate = colorLineCoordinate;
    }

    public void setCrossLineCoordinateL(double crossLineCoordinateL) {
        this.crossLineCoordinateL = crossLineCoordinateL;
    }
    public void setCrossLineCoordinateR(double crossLineCoordinateR) {
        this.crossLineCoordinateR = crossLineCoordinateR;
    }

    public void setBallCoordinate(double ballCoordinate) {
        this.ballCoordinate = ballCoordinate;
    }

    public void setColorSwitcher1(double colorSwitcher1) {
        this.colorSwitcher1 = colorSwitcher1;
    }

    public void setColorSwitcher2(double colorSwitcher2) {
        this.colorSwitcher2 = colorSwitcher2;
    }

    public void setColorSwitcher3(double colorSwitcher3) {
        this.colorSwitcher3 = colorSwitcher3;
    }

    public void setColorSwitcher4(double colorSwitcher4) {
        this.colorSwitcher4 = colorSwitcher4;
    }

    public void setStar1(double star1) {
        this.star1 = star1;
    }

    public void setStar2(double star2) {
        this.star2 = star2;
    }

    public void setStar3(double star3) {
        this.star3 = star3;
    }

    public void setStar4(double star4) {
        this.star4 = star4;
    }

    public void setStar5(double star5) {
        this.star5 = star5;
    }

    public void setStar6(double star6) {
        this.star6 = star6;
    }

    public void setStar7(double star7) {
        this.star7 = star7;
    }

    public void setStar8(double star8) {
        this.star8 = star8;
    }

    public void setCsText(double y) {
        this.csText = y;
    }

    public void setHand(double y) {
        this.Hand = y;
    }

    public void setBallColor(int c) {this.ballColor = c;}

    public void setStar(double st1 ,double st2 ,double st3 ,double st4 ,double st5 ,double st6 ,double st7 ,double st8)
    {
        setStar1(st1);
        setStar2(st2);
        setStar3(st3);
        setStar4(st4);
        setStar5(st5);
        setStar6(st6);
        setStar7(st7);
        setStar8(st8);
    }
    public void setColorSwitcher(double cs1 ,double cs2 ,double cs3 ,double cs4 )
    {
        setColorSwitcher1(cs1);
        setColorSwitcher2(cs2);
        setColorSwitcher3(cs3);
        setColorSwitcher4(cs4);
    }

    public void setObs(double o1 ,double o2 ,double o3 ,double o4 ,double o5 ,double o6 ,double o7 ,double o8 ,double o9)
    {
        setArcCoordinate(o1);
        setBigStarCoordinate(o2);
        setOctagonCoordinate(o3);
        setRhombusCoordinate(o4);
        setSquareCoordinate(o5);
        setDotSquareCoordinate(o6);
        setColorLineCoordinate(o7);
        setCrossLineCoordinateL(o8);
        setCrossLineCoordinateR(o9);
    }
}

class Score extends Main implements Serializable {
    private long score = 0;

    public long getScore() {
        return this.score;
    }

    public void setScore(long value) {
        this.score = value;
    }

    public void serialize(long val) throws IOException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Score.txt"));
            out.writeObject(val);
            out.close();
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    public long deserialize() throws IOException, ClassNotFoundException {

        long val = 0;
        try {
            ObjectInputStream in = new ObjectInputStream((new FileInputStream("Score.txt")));
            val = (long) in.readObject();
            in.close();
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        return val;
    }
}

class highScore extends Main implements Serializable {
    private long highscore = 0;

    public long getHighScore() {
        return this.highscore;
    }

    public void setHighScore(long value) {
        this.highscore = value;
    }

    public void serialize(long val) throws IOException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("HighScore.txt"));
            out.writeObject(val);
            out.close();
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    public long deserialize() throws IOException, ClassNotFoundException {

        long val = 0;
        try {
            ObjectInputStream in = new ObjectInputStream((new FileInputStream("HighScore.txt")));
            val = (long) in.readObject();
            in.close();
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        return val;
    }
}

