import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
/**
 *  {@brief This class is used for Triangle drawing, I use polygons in this case.}
 *  {@link Figure#drawFigure(Group root) Figure}
 *  @see Figure#drawFigure(Group root)
 */
public class TriangleFx implements Figure
{
    Point2D point1, point2, point3;
    boolean coordinatesSet = false;
    boolean point1Set = false;
    boolean point2Set = false;
    boolean point3Set = false;
    Polygon triangle;
    /**
     *  {@brief It will read x,y at the first time to point1 second point2 third point3
     *     then it enables to draw this figure}
     */
    public void Coordinates(double x, double y)
    {
        if(point1Set == false)
        {
            point1 = new Point2D(x, y);
            point1Set = true;
        }
        else if(point2Set == false)
        {
            point2 = new Point2D(x, y);
            point2Set = true;
        }
        else if(point3Set == false)
        {
            point3 = new Point2D(x, y);
            coordinatesSet = true;
            point1Set = false;
            point2Set = false;
        }
        
    }
    /**
     *  {@brief It creates polygon and adds it to group.}
     */
    public void drawFigure(Group root) // Srodek moze byc w zlym miejcu 
    {
        if(coordinatesSet == true)
        {
            triangle = new Polygon();
            triangle.getPoints().addAll(new Double[]
            {
                point1.getX(), point1.getY(),
                point2.getX(), point2.getY(),
                point3.getX(), point3.getY()

            });
            System.console().printf("I drew it\n");
            root.getChildren().add(triangle);  
        }
        else
        {
            System.console().printf("Coordinates not given\n");
        }
    }
    /**
     *  {@brief It resets points so It won't remember old points.}
     */
    @Override
    public void resetFigure()
    {
        point1Set = false;
        point2Set = false;
    }
}
