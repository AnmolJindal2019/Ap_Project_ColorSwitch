package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import java.io.FileInputStream;
import java.io.IOException;

class Octagon{
    double width = 18;
    Line line1;
    Line line2;
    Line line3;
    Line line4;
    Line line5;
    Line line6;
    Line line7;
    Line line8;

    Group gp;


    public void create(double a, double b, double s){
        double len = s/(Math.sqrt(2));
        double xA,yA,xB,yB,xC,yC,xD,yD,xE,yE,xF,yF,xG,yG,xH,yH;
        double x = a-(s/2);
        double y = b+(s/2)+len;
        xA = x;
        yA = y;
        xB = x+s;
        yB = y;
        xC = x+s+len;
        yC = y-len;
        xD = x+s+len;
        yD = y-s-len;
        xE = x+s;
        yE = y-s-2*len;
        xF = x;
        yF = y-s-2*len;
        xG = x-len;
        yG = y-s-len;
        xH = x-len;
        yH = y-len;

        line1 = new Line();
        line1.setStartX(xA);
        line1.setStartY(yA);
        line1.setEndX(xB);
        line1.setEndY(yB);
        line1.setStroke(Color.web("#FF0181"));
        line1.setFill(Color.web("#FF0181"));
        line1.strokeWidthProperty().set(width);
        line1.setStrokeLineCap(StrokeLineCap.ROUND);

        line2 = new Line();
        line2.setStartX(xB);
        line2.setStartY(yB);
        line2.setEndX(xC);
        line2.setEndY(yC);
        line2.setStroke(Color.web("#900DFF"));
        line2.setFill(Color.web("#900DFF"));
        line2.strokeWidthProperty().set(width);
        line2.setStrokeLineCap(StrokeLineCap.ROUND);

        line3 = new Line();
        line3.setStartX(xC);
        line3.setStartY(yC);
        line3.setEndX(xD);
        line3.setEndY(yD);
        line3.setStroke(Color.web("#32DBF0"));
        line3.setFill(Color.web("#32DBF0"));
        line3.strokeWidthProperty().set(width);
        line3.setStrokeLineCap(StrokeLineCap.ROUND);

        line4 = new Line();
        line4.setStartX(xD);
        line4.setStartY(yD);
        line4.setEndX(xE);
        line4.setEndY(yE);
        line4.setStroke(Color.web("#FAE100"));
        line4.setFill(Color.web("#FAE100"));
        line4.strokeWidthProperty().set(width);
        line4.setStrokeLineCap(StrokeLineCap.ROUND);

        line5 = new Line();
        line5.setStartX(xE);
        line5.setStartY(yE);
        line5.setEndX(xF);
        line5.setEndY(yF);
        line5.setStroke(Color.web("#FF0181"));
        line5.setFill(Color.web("#FF0181"));
        line5.strokeWidthProperty().set(width);
        line5.setStrokeLineCap(StrokeLineCap.ROUND);

        line6 = new Line();
        line6.setStartX(xF);
        line6.setStartY(yF);
        line6.setEndX(xG);
        line6.setEndY(yG);
        line6.setStroke(Color.web("#900DFF"));
        line6.setFill(Color.web("#900DFF"));
        line6.strokeWidthProperty().set(width);
        line6.setStrokeLineCap(StrokeLineCap.ROUND);

        line7 = new Line();
        line7.setStartX(xG);
        line7.setStartY(yG);
        line7.setEndX(xH);
        line7.setEndY(yH);
        line7.setStroke(Color.web("#32DBF0"));
        line7.setFill(Color.web("#32DBF0"));
        line7.strokeWidthProperty().set(width);
        line7.setStrokeLineCap(StrokeLineCap.ROUND);

        line8 = new Line();
        line8.setStartX(xH);
        line8.setStartY(yH);
        line8.setEndX(xA);
        line8.setEndY(yA);
        line8.setStroke(Color.web("#FAE100"));
        line8.setFill(Color.web("#FAE100"));
        line8.strokeWidthProperty().set(width);
        line8.setStrokeLineCap(StrokeLineCap.ROUND);

        gp = new Group(line1,line2,line3,line4,line5,line6,line7,line8);
    }

    public boolean isCollide(Octagon oct , ball b)
    {
        Shape shape1 = Shape.intersect(oct.line1 , b.b);
        Shape shape2 = Shape.intersect(oct.line2 , b.b);
        Shape shape3 = Shape.intersect(oct.line3 , b.b);
        Shape shape4 = Shape.intersect(oct.line4 , b.b);
        Shape shape5 = Shape.intersect(oct.line5 , b.b);
        Shape shape6 = Shape.intersect(oct.line6 , b.b);
        Shape shape7 = Shape.intersect(oct.line7 , b.b);
        Shape shape8 = Shape.intersect(oct.line8 , b.b);


        if(shape1.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(oct.line1.getFill())) {
                return true;
            }
        }

        if(shape2.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(oct.line2.getFill())) {
                return true;
            }
        }

        if(shape3.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(oct.line3.getFill())) {
                return true;

            }
        }

        if(shape4.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(oct.line4.getFill())) {
                return true;

            }
        }
        if(shape5.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(oct.line5.getFill())) { ;
                return true;
            }
        }
        if(shape6.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(oct.line6.getFill())) {
                return true;

            }
        }
        if(shape7.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(oct.line7.getFill())) {
                return true;

            }
        }
        if(shape8.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(oct.line8.getFill())) {
                return true;
            }
        }
        return false;
    }
}

class CircleUsingArc implements Variables{
    double centerX;
    double centerY;
    double innerRadius;
    double radius;
    Shape s1;
    Shape s2;
    Shape s3;
    Shape s4;
    Group gp;


    public void create(double X, double Y, double r, double ir){
        centerX = X;
        centerY = Y;
        radius = r;
        innerRadius = ir;
        gp = new Group();

        Arc yellowArc = new Arc();
        yellowArc.setCenterX(centerX);
        yellowArc.setCenterY(centerY);
        yellowArc.setRadiusX(radius);
        yellowArc.setRadiusY(radius);
        yellowArc.setStartAngle(0);
        yellowArc.setLength(90);
        yellowArc.setType(ArcType.ROUND);
        yellowArc.setLayoutY(0);
        yellowArc.setLayoutX(0);


        Arc purpleArc = new Arc();
        purpleArc.setCenterX(centerX);
        purpleArc.setCenterY(centerY);
        purpleArc.setRadiusX(radius);
        purpleArc.setRadiusY(radius);
        purpleArc.setStartAngle(90);
        purpleArc.setLength(90);
        purpleArc.setType(ArcType.ROUND);


        Arc redArc = new Arc();
        redArc.setCenterX(centerX);
        redArc.setCenterY(centerY);
        redArc.setRadiusX(radius);
        redArc.setRadiusY(radius);
        redArc.setStartAngle(180);
        redArc.setLength(90);
        redArc.setType(ArcType.ROUND);


        Arc blueArc = new Arc();
        blueArc.setCenterX(centerX);
        blueArc.setCenterY(centerY);
        blueArc.setRadiusX(radius);
        blueArc.setRadiusY(radius);
        blueArc.setStartAngle(270);
        blueArc.setLength(90);
        blueArc.setType(ArcType.ROUND);

        Arc smallYellowArc = new Arc();
        smallYellowArc.setCenterX(centerX);
        smallYellowArc.setCenterY(centerY);
        smallYellowArc.setRadiusX(innerRadius);
        smallYellowArc.setRadiusY(innerRadius);
        smallYellowArc.setStartAngle(0);
        smallYellowArc.setLength(90);
        smallYellowArc.setType(ArcType.ROUND);

        Arc smallPurpleArc = new Arc();
        smallPurpleArc.setCenterX(centerX);
        smallPurpleArc.setCenterY(centerY);
        smallPurpleArc.setRadiusX(innerRadius);
        smallPurpleArc.setRadiusY(innerRadius);
        smallPurpleArc.setStartAngle(90);
        smallPurpleArc.setLength(90);
        smallPurpleArc.setType(ArcType.ROUND);

        Arc smallRedArc = new Arc();
        smallRedArc.setCenterX(centerX);
        smallRedArc.setCenterY(centerY);
        smallRedArc.setRadiusX(innerRadius);
        smallRedArc.setRadiusY(innerRadius);
        smallRedArc.setStartAngle(180);
        smallRedArc.setLength(90);
        smallRedArc.setType(ArcType.ROUND);

        Arc smallBlueArc = new Arc();
        smallBlueArc.setCenterX(centerX);
        smallBlueArc.setCenterY(centerY);
        smallBlueArc.setRadiusX(innerRadius);
        smallBlueArc.setRadiusY(innerRadius);
        smallBlueArc.setStartAngle(270);
        smallBlueArc.setLength(90);
        smallBlueArc.setType(ArcType.ROUND);

        s1 = Shape.subtract(yellowArc,smallYellowArc);
        s1.setStroke(Color.web(pallete[0]));
        s1.setFill(Color.web(pallete[0]));

        s2 = Shape.subtract(purpleArc,smallPurpleArc);
        s2.setStroke(Color.web(pallete[1]));
        s2.setFill(Color.web(pallete[1]));

        s3 = Shape.subtract(redArc,smallRedArc);
        s3.setStroke(Color.web(pallete[2]));
        s3.setFill(Color.web(pallete[2]));

        s4 = Shape.subtract(blueArc,smallBlueArc);
        s4.setStroke(Color.web(pallete[3]));
        s4.setFill(Color.web(pallete[3]));

        gp.getChildren().addAll(s1 ,s2 ,s3 ,s4);
    }

    public boolean isCollide(CircleUsingArc arc , ball b)
    {
        Shape shape1 = Shape.intersect(arc.s1, b.b);
        Shape shape2 = Shape.intersect(arc.s2 , b.b);
        Shape shape3 = Shape.intersect(arc.s3 , b.b);
        Shape shape4 = Shape.intersect(arc.s4 , b.b);

        if(shape1.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(arc.s1.getFill())) {
                return true;
            }
        }

        if(shape2.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(arc.s2.getFill())) {
                return true;
            }
        }

        if(shape3.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(arc.s3.getFill())) {
                return true;
            }
        }

        if(shape4.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(arc.s4.getFill())) {
                return true;
            }
        }
        return false;
    }
}


class bigStar implements Variables
{
    Line l1;
    Line l2;
    Line l3;
    Line l4;

    Group bigS;

    public void create(double x , double y)
    {
        l1 = new Line();
        l1.setStartX(x); l1.setEndX(x+100);
        l1.setStartY(y); l1.setEndY(y);
        l1.setStrokeWidth(20);
        l1.setStroke(Color.web(pallete[0]));
        l1.setFill(Color.web(pallete[0]));
        l1.setStrokeLineCap(StrokeLineCap.ROUND);

        l2 = new Line();
        l2.setStartX(x); l2.setEndX(x);
        l2.setStartY(y); l2.setEndY(y+100);
        l2.setStrokeWidth(20);
        l2.setStroke(Color.web(pallete[1]));
        l2.setFill(Color.web(pallete[1]));
        l2.setStrokeLineCap(StrokeLineCap.ROUND);

        l3 = new Line();
        l3.setStartX(x); l3.setEndX(x-100);
        l3.setStartY(y); l3.setEndY(y);
        l3.setStrokeWidth(20);
        l3.setStroke(Color.web(pallete[2]));
        l3.setFill(Color.web(pallete[2]));
        l3.setStrokeLineCap(StrokeLineCap.ROUND);

        l4 = new Line();
        l4.setStartX(x); l4.setEndX(x);
        l4.setStartY(y); l4.setEndY(y-100);
        l4.setStrokeWidth(20);
        l4.setStroke(Color.web(pallete[3]));
        l4.setFill(Color.web(pallete[3]));
        l4.setStrokeLineCap(StrokeLineCap.ROUND);

        bigS = new Group(l1,l2,l3,l4);
    }

    public boolean isCollide(bigStar bs , ball b)
    {
        Shape shape1 = Shape.intersect(bs.l1, b.b);
        Shape shape2 = Shape.intersect(bs.l2, b.b);
        Shape shape3 = Shape.intersect(bs.l3 , b.b);
        Shape shape4 = Shape.intersect(bs.l4 , b.b);

        if(shape1.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(bs.l1.getFill())) {
                return true;
            }
        }

        if(shape2.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(bs.l2.getFill())) {
                return true;
            }
        }

        if(shape3.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(bs.l3.getFill())) {
                return true;

            }
        }

        if(shape4.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(bs.l4.getFill())) {
                return true;
            }
        }
        return false;
    }
}

class colorLine implements Variables{
    Line line1;
    Line line2;
    Line line3;
    Line line4;
    Group gp;
    int width = 18;
    public void create(double x, double y, double len){

        double xa, xb, xc, xd, xe;
        xc  = x;
        xb = x-len;
        xa = x-2*len;
        xd = x+len;
        xe = x+2*len;

        line1 = new Line();
        line1.setStartX(xa);
        line1.setStartY(y);
        line1.setEndX(xb);
        line1.setEndY(y);
        line1.setStroke(Color.web("#FF0181"));
        line1.setFill(Color.web("#FF0181"));
        line1.strokeWidthProperty().set(width);

        line2 = new Line();
        line2.setStartX(xb);
        line2.setStartY(y);
        line2.setEndX(xc);
        line2.setEndY(y);
        line2.setStroke(Color.web("#900DFF"));
        line2.setFill(Color.web("#900DFF"));
        line2.strokeWidthProperty().set(width);

        line3 = new Line();
        line3.setStartX(xc);
        line3.setStartY(y);
        line3.setEndX(xd);
        line3.setEndY(y);
        line3.setStroke(Color.web("#32DBF0"));
        line3.setFill(Color.web("#32DBF0"));
        line3.strokeWidthProperty().set(width);

        line4 = new Line();
        line4.setStartX(xd);
        line4.setStartY(y);
        line4.setEndX(xe);
        line4.setEndY(y);
        line4.setStroke(Color.web("#FAE100"));
        line4.setFill(Color.web("#FAE100"));
        line4.strokeWidthProperty().set(width);

        gp = new Group(line1 , line2 , line3 , line4);
    }

    public boolean isCollide(colorLine cl , ball b)
    {
        Shape shape1 = Shape.intersect(cl.line1, b.b);
        Shape shape2 = Shape.intersect(cl.line2, b.b);
        Shape shape3 = Shape.intersect(cl.line3 , b.b);
        Shape shape4 = Shape.intersect(cl.line4 , b.b);

        if(shape1.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(cl.line1.getFill())) {
                return true;
            }
        }

        if(shape2.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(cl.line2.getFill())) {
                return true;
            }
        }

        if(shape3.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(cl.line3.getFill())) {
                return true;

            }
        }

        if(shape4.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(cl.line4.getFill())) {
                return true;
            }
        }
        return false;
    }

}

class colorDoubleLine implements Variables {
    Group gp , rgp , lgp;
    int width = 18;
    Line line1, line2, line3, line4, line5, line6, line7, line8 ;

    public void create(double x, double y, double len){
        double t =  (len/Math.sqrt(2));
        double t1 = width/(2*Math.sqrt(2));

        line1 = new Line();
        line1.setStartX(x+t1);
        line1.setStartY(y+t1);
        line1.setEndX(x+t+t1);
        line1.setEndY(y+t+t1);
        line1.setStroke(Color.web("#FF0181"));
        line1.setFill(Color.web("#FF0181"));
        line1.strokeWidthProperty().set(width);

        line2 = new Line();
        line2.setStartX(x+t+t1);
        line2.setStartY(y+t+t1);
        line2.setEndX(x+2*(t+t1));
        line2.setEndY(y+2*(t+t1));
        line2.setStroke(Color.web("#900DFF"));
        line2.setFill(Color.web("#900DFF"));
        line2.strokeWidthProperty().set(width);

        line3 = new Line();
        line3.setStartX(x-t1);
        line3.setStartY(y-t1);
        line3.setEndX(x-(t+t1));
        line3.setEndY(y-(t+t1));
        line3.setStroke(Color.web("#32DBF0"));
        line3.setFill(Color.web("#32DBF0"));
        line3.strokeWidthProperty().set(width);

        line4 = new Line();
        line4.setStartX(x-(t+t1));
        line4.setStartY(y-(t+t1));
        line4.setEndX(x-2*(t+t1));
        line4.setEndY(y-2*(t+t1));
        line4.setStroke(Color.web("#FAE100"));
        line4.setFill(Color.web("#FAE100"));
        line4.strokeWidthProperty().set(width);

        line5 = new Line();
        line5.setStartY(y+t1);
        line5.setStartX(x-t1);
        line5.setEndY(y+(t+t1));
        line5.setEndX(x-(t+t1));
        line5.setStroke(Color.web("#FF0181"));
        line5.setFill(Color.web("#FF0181"));
        line5.strokeWidthProperty().set(width);

        line6 = new Line();
        line6.setStartY(y+(t+t1));
        line6.setStartX(x-(t+t1));
        line6.setEndY(y+2*(t+t1));
        line6.setEndX(x-2*(t+t1));
        line6.setStroke(Color.web("#900DFF"));
        line6.setFill(Color.web("#900DFF"));
        line6.strokeWidthProperty().set(width);

        line7 = new Line();
        line7.setStartY(y-t1);
        line7.setStartX(x+t1);
        line7.setEndY(y-(t+t1));
        line7.setEndX(x+(t+t1));
        line7.setStroke(Color.web("#32DBF0"));
        line7.setFill(Color.web("#32DBF0"));
        line7.strokeWidthProperty().set(width);

        line8 = new Line();
        line8.setStartY(y-(t+t1));
        line8.setStartX(x+(t+t1));
        line8.setEndY(y-2*(t+t1));
        line8.setEndX(x+2*(t+t1));
        line8.setStroke(Color.web("#FAE100"));
        line8.setFill(Color.web("#FAE100"));
        line8.strokeWidthProperty().set(width);

        gp = new Group(line1,line2,line3,line4,line5, line6, line7, line8);
        rgp = new Group(line1,line2,line3,line4);
        lgp = new Group(line5, line6, line7, line8);
    }

    public boolean isCollide(colorDoubleLine cl , ball b)
    {
        Shape shape1 = Shape.intersect(cl.line1, b.b);
        Shape shape2 = Shape.intersect(cl.line2, b.b);
        Shape shape3 = Shape.intersect(cl.line3 , b.b);
        Shape shape4 = Shape.intersect(cl.line4 , b.b);
        Shape shape5 = Shape.intersect(cl.line5, b.b);
        Shape shape6 = Shape.intersect(cl.line6, b.b);
        Shape shape7 = Shape.intersect(cl.line7 , b.b);
        Shape shape8 = Shape.intersect(cl.line8 , b.b);

        if(shape1.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(cl.line1.getFill())) {
                return true;
            }
        }

        if(shape2.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(cl.line2.getFill())) {
                return true;
            }
        }

        if(shape3.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(cl.line3.getFill())) {
                return true;

            }
        }

        if(shape4.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(cl.line4.getFill())) {
                return true;
            }
        }

        if(shape5.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(cl.line5.getFill())) {
                return true;
            }
        }

        if(shape6.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(cl.line6.getFill())) {
                return true;
            }
        }

        if(shape7.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(cl.line7.getFill())) {
                return true;

            }
        }

        if(shape8.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(cl.line8.getFill())) {
                return true;
            }
        }

        return false;
    }
}


class square {
    double width = 18;
    Line line1;
    Line line2;
    Line line3;
    Line line4;
    Group gp;

    public void create(double x, double y, double len) {


        double p = len/2;
        double xa, xb, xc, xd;
        double ya, yb, yc, yd;

        xa = x-p;
        ya = y+p;
        xb = x+p;
        yb = y+p;
        xc = x+p;
        yc = y-p;
        xd = x-p;
        yd = y-p;


        line1 = new Line();
        line1.setStartX(xa);
        line1.setStartY(ya);
        line1.setEndX(xb);
        line1.setEndY(yb);
        line1.setStroke(Color.web("#FF0181"));
        line1.setFill(Color.web("#FF0181"));
        line1.strokeWidthProperty().set(width);
        line1.setStrokeLineCap(StrokeLineCap.ROUND);

        line2 = new Line();
        line2.setStartX(xb);
        line2.setStartY(yb);
        line2.setEndX(xc);
        line2.setEndY(yc);
        line2.setStroke(Color.web("#900DFF"));
        line2.setFill(Color.web("#900DFF"));
        line2.strokeWidthProperty().set(width);
        line2.setStrokeLineCap(StrokeLineCap.ROUND);

        line3 = new Line();
        line3.setStartX(xc);
        line3.setStartY(yc);
        line3.setEndX(xd);
        line3.setEndY(yd);
        line3.setStroke(Color.web("#32DBF0"));
        line3.setFill(Color.web("#32DBF0"));
        line3.strokeWidthProperty().set(width);
        line3.setStrokeLineCap(StrokeLineCap.ROUND);

        line4 = new Line();
        line4.setStartX(xd);
        line4.setStartY(yd);
        line4.setEndX(xa);
        line4.setEndY(ya);
        line4.setStroke(Color.web("#FAE100"));
        line4.setFill(Color.web("#FAE100"));
        line4.strokeWidthProperty().set(width);
        line4.setStrokeLineCap(StrokeLineCap.ROUND);

        gp = new Group(line1 , line2 , line3 , line4);
    }

    public boolean isCollide(square sq , ball b)
    {
        Shape shape1 = Shape.intersect(sq.line1, b.b);
        Shape shape2 = Shape.intersect(sq.line2, b.b);
        Shape shape3 = Shape.intersect(sq.line3 , b.b);
        Shape shape4 = Shape.intersect(sq.line4 , b.b);

        if(shape1.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(sq.line1.getFill())) {
                return true;
            }
        }

        if(shape2.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(sq.line2.getFill())) {
                return true;
            }
        }

        if(shape3.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(sq.line3.getFill())) {
                return true;

            }
        }

        if(shape4.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(sq.line4.getFill())) {
                return true;
            }
        }
        return false;
    }
}

class squareWithDash implements Variables {
    double width = 18;
    Line line1;
    Line line2;
    Line line3;
    Line line4;
    Group gp;

    public void create(double x, double y, double len) {

        gp = new Group();
        double p = len / 2;
        double xa, xb, xc, xd;
        double ya, yb, yc, yd;

        xa = x - p;
        ya = y + p;
        xb = x + p;
        yb = y + p;
        xc = x + p;
        yc = y - p;
        xd = x - p;
        yd = y - p;


        line1 = new Line();
        line1.setStartX(xa);
        line1.setStartY(ya);
        line1.setEndX(xb);
        line1.setEndY(yb);
        line1.setStroke(Color.web("#FF0181"));
        line1.setFill(Color.web("#FF0181"));
        line1.strokeWidthProperty().set(width);
        line1.setStrokeLineCap(StrokeLineCap.ROUND);
        line1.getStrokeDashArray().addAll(3d, 20d);


        line2 = new Line();
        line2.setStartX(xb);
        line2.setStartY(yb);
        line2.setEndX(xc);
        line2.setEndY(yc);
        line2.setStroke(Color.web("#900DFF"));
        line2.setFill(Color.web("#900DFF"));
        line2.strokeWidthProperty().set(width);
        line2.setStrokeLineCap(StrokeLineCap.ROUND);
        line2.getStrokeDashArray().addAll(3d, 20d);


        line3 = new Line();
        line3.setStartX(xc);
        line3.setStartY(yc);
        line3.setEndX(xd);
        line3.setEndY(yd);
        line3.setStroke(Color.web("#32DBF0"));
        line3.setFill(Color.web("#32DBF0"));
        line3.strokeWidthProperty().set(width);
        line3.setStrokeLineCap(StrokeLineCap.ROUND);
        line3.getStrokeDashArray().addAll(3d, 20d);


        line4 = new Line();
        line4.setStartX(xd);
        line4.setStartY(yd);
        line4.setEndX(xa);
        line4.setEndY(ya);
        line4.setStroke(Color.web("#FAE100"));
        line4.setFill(Color.web("#FAE100"));
        line4.strokeWidthProperty().set(width);
        line4.setStrokeLineCap(StrokeLineCap.ROUND);
        line4.getStrokeDashArray().addAll(3d, 20d);

        gp = new Group(line1, line2, line3, line4);
    }
    public boolean isCollide(squareWithDash sd , ball b)
    {
        Shape shape1 = Shape.intersect(sd.line1, b.b);
        Shape shape2 = Shape.intersect(sd.line2, b.b);
        Shape shape3 = Shape.intersect(sd.line3 , b.b);
        Shape shape4 = Shape.intersect(sd.line4 , b.b);

        if(shape1.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(sd.line1.getFill())) {
                return true;
            }
        }

        if(shape2.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(sd.line2.getFill())) {
                return true;
            }
        }

        if(shape3.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(sd.line3.getFill())) {
                return true;

            }
        }

        if(shape4.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(sd.line4.getFill())) {
                return true;
            }
        }
        return false;
    }
}

class rhombus implements Variables{
    double width = 18;
    Group gp;
    Line line1,line2,line3,line4;

    public void create(double x, double y, double len) {

        int val = 50;
        double p = len/2;
        double xa, xb, xc, xd;
        double ya, yb, yc, yd;

        xa = x-p-val;
        ya = y+p;
        xb = x+p-val;
        yb = y+p;
        xc = x+p+val;
        yc = y-p;
        xd = x-p+val;
        yd = y-p;


        line1 = new Line();
        line1.setStartX(xa);
        line1.setStartY(ya);
        line1.setEndX(xb);
        line1.setEndY(yb);
        line1.setStroke(Color.web("#FF0181"));
        line1.setFill(Color.web("#FF0181"));
        line1.strokeWidthProperty().set(width);
        line1.setStrokeLineCap(StrokeLineCap.ROUND);

        line2 = new Line();
        line2.setStartX(xb);
        line2.setStartY(yb);
        line2.setEndX(xc);
        line2.setEndY(yc);
        line2.setStroke(Color.web("#900DFF"));
        line2.setFill(Color.web("#900DFF"));
        line2.strokeWidthProperty().set(width);
        line2.setStrokeLineCap(StrokeLineCap.ROUND);

        line3 = new Line();
        line3.setStartX(xc);
        line3.setStartY(yc);
        line3.setEndX(xd);
        line3.setEndY(yd);
        line3.setStroke(Color.web("#32DBF0"));
        line3.setFill(Color.web("#32DBF0"));
        line3.strokeWidthProperty().set(width);
        line3.setStrokeLineCap(StrokeLineCap.ROUND);

        line4 = new Line();
        line4.setStartX(xd);
        line4.setStartY(yd);
        line4.setEndX(xa);
        line4.setEndY(ya);
        line4.setStroke(Color.web("#FAE100"));
        line4.setFill(Color.web("#FAE100"));
        line4.strokeWidthProperty().set(width);
        line4.setStrokeLineCap(StrokeLineCap.ROUND);

        gp = new Group(line1,line2,line3,line4);

    }

    public boolean isCollide(rhombus sq , ball b)
    {
        Shape shape1 = Shape.intersect(sq.line1, b.b);
        Shape shape2 = Shape.intersect(sq.line2, b.b);
        Shape shape3 = Shape.intersect(sq.line3 , b.b);
        Shape shape4 = Shape.intersect(sq.line4 , b.b);

        if(shape1.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(sq.line1.getFill())) {
                return true;
            }
        }

        if(shape2.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(sq.line2.getFill())) {
                return true;
            }
        }

        if(shape3.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(sq.line3.getFill())) {
                return true;

            }
        }

        if(shape4.getBoundsInLocal().getWidth() != -1)
        {
            if(!b.b.getFill().equals(sq.line4.getFill())) {
                return true;
            }
        }
        return false;
    }
}

class ball extends Shape implements Variables
{
    Circle b ;

    public ball(double y){

        b= new Circle();
        b.setCenterX(200);
        b.setCenterY(y);
        b.setRadius(20);
        b.setFill(Color.web(pallete[0]));
    }


    public void changeColor(String[] pallete)
    {
        while(true)
        {
            int ran = rand.nextInt(4);
            Color c = Color.web(pallete[ran]);

            if(!c.equals(b.getFill()))
            {
                b.setFill(c);
                break;
            }
        }
    }

    public int getColor()
    {
        String c = this.b.getFill().toString();
        String hex = c.substring(2 ,8);

        for(int i=0 ; i<4 ; i++)
        {
            if(hex.equals(pallete[i]))
            {
                return i;
            }
        }
        return -1;
    }

}

class colorSwitcher{
    Image img = new Image(new FileInputStream("D:\\Ap Project\\src\\sample\\images\\colorchanger.png"));
    ImageView cs = new ImageView(img);
    int x;

    public colorSwitcher() throws IOException {
    }
    public void set(double x , double y , double w , double h)
    {
        cs.setX(x);
        cs.setY(y);
        cs.setFitHeight(w);
        cs.setFitWidth(h);
    }

    public boolean isCollide(colorSwitcher cs  , ball b)
    {
        if(cs.cs.getBoundsInParent().intersects(b.b.getBoundsInParent()))
        {
            return true;
        }
        return false;
    }
}

class Star{
    Group gp;
    public Star(double x, double y, double s){
        gp = new Group();
        double xa,xb,xc,ya,yb,yc;
        double xa1,xb1,xc1,ya1,yb1,yc1;
        double p = (Math.sqrt(3)/2)*s;
        double p1 = s/(2*Math.sqrt(3));
        xa = x;
        ya = y +(p-p1);
        xb = x-(s/2);
        yb = y - p1;
        xc = x+(s/2);
        yc = y-p1;

        xa1 = x;
        ya1 = y -(p-p1);
        xb1 = x-(s/2);
        yb1 = y+p1;
        xc1 = x+(s/2);
        yc1 = y+p1;

        Polygon triangle1 = new Polygon();
        triangle1.getPoints().addAll(xa,ya,xb,yb,xc,yc);
        triangle1.setFill(Color.WHITE);

        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(xa1,ya1,xb1,yb1,xc1,yc1);
        triangle2.setFill(Color.WHITE);

        gp.getChildren().add(triangle1);
        gp.getChildren().add(triangle2);
    }

    public boolean isCollide(Star st ,ball b)
    {
        if(b.b.getBoundsInParent().intersects(st.gp.getBoundsInParent()))
        {
            return true;
        }
        return false;
    }
}

