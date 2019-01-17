import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TripTest
{
    public static void main(String[] args){
        MyTrips trips = new MyTrips();
        trips.addTrip("kaan", "Istanbul");
        System.out.println(trips.findTrip("kaan", "Istanbul"));
    }

}