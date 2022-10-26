import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
/**
 *  {@brief This class is used for Triangle drawing, I use polygons in this case.}
 *  {@link Figure#drawFigure(Group root) Figure}
 *   @see Figure#drawFigure(Group root)
 */
public class CircleFx implements Figure
{
    private Point2D point1;
    Circle circle;
    boolean coordinatesSet = false;
    /**
     *  {@brief It creates object Circle and adds it to group.}
     */
    public void drawFigure(Group root)
    {
        if(coordinatesSet == true)
        {
            circle = new Circle(point1.getX(),point1.getY(),100);
            System.console().printf("I drew it\n");
            root.getChildren().add(circle);  
            coordinatesSet = false;
        }
        else
        {
            System.console().printf("Coordinates not given\n");
        }
        
        
    }
    /**
     *  {@brief It will read x,y at the first time to point1
     *     then it enables to draw this figure}
     */
    public void Coordinates(double x, double y)
    {
        point1 = new Point2D(x, y);
        coordinatesSet = true;
    }
    /**
     *  {@brief It resets points so It won't remember old points.}
     */
    @Override
    public void resetFigure()
    {

    }
}
