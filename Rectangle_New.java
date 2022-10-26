import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.geometry.Point2D;


/**
 *  {@brief This class is used for Rectangle drawing.}
 *  {@link Figure#drawFigure(Group root) Figure}
 *  @see Figure#drawFigure(Group root)
 */
public class Rectangle_New implements Figure
{
    private Point2D point1, point2;
    private double width;
    private double height;
    private boolean Coordinates_Set = false;
    private boolean first_Coordinate_not_Written = true; 
    private double lowestX;
    private double lowestY;
    Rectangle rectangle;
    /**
     *  {@brief It will read x,y at the first time to point1 second point2
     *     then it enables to draw this figure}
     */
    @Override
    public void Coordinates(double x, double y)
    {
        if(first_Coordinate_not_Written == true)
        {
            point1 = new Point2D(x, y);
            
            first_Coordinate_not_Written = false;
            Coordinates_Set = false;
            
        }
        else
        {
            point2 = new Point2D(x, y);
            first_Coordinate_not_Written = true;

            height =  java.lang.Math.abs(point1.getY() - point2.getY());
            width =  java.lang.Math.abs(point1.getX() - point2.getX());
            Coordinates_Set = true;  
        }


    }
    /**
     *  {@brief it selects which x, y from points to use when drawing figure
     *   then it creates object Rectangle and adds it to group.}
     */
    @Override
    public void drawFigure(Group root)
    {
        if(Coordinates_Set == true)
        {
            System.console().printf("Creating rectangle\n");
            if(point1.getX() <= point2.getX())
            {
                lowestX = point1.getX();
            }
            else
            {
                lowestX = point2.getX();
            }
            if(point1.getY() <= point2.getY())
            {
                lowestY = point1.getY();
            }
            else
            {
                lowestY = point2.getY();
            }
            rectangle = new Rectangle(lowestX,lowestY,width,height);
            System.console().printf("I drew it\n");
            root.getChildren().add(rectangle);
        }
        else
        {
            System.console().printf("No coordinates given\n");
        }
        
    }
    /**
     *  {@brief It resets points so It won't remember old points.}
     */
    @Override
    public void resetFigure()
    {
        first_Coordinate_not_Written = true;
    }
    /*
    //If is selected
    public boolean isHit(double x, double y) { 
        return rectangle.getBoundsInLocal().contains(x,y);
    }

    // Change X
    public void addX(double x) {  
        rectangle.setX(rectangle.getX()+x);
    }

    // Change Y
    public void addY(double y) {  
        rectangle.setY(rectangle.getY()+y);
    }

    class FXRectangleEventHandler implements EventHandler<MouseEvent>
    {
        Rectangle_New rec;
        private double x;
        private double y;
      
        private void doMove(MouseEvent event) {
                  
          double dx = event.getX() - x;
          double dy = event.getY() - y;
      
            if (rec.isHit(x, y)) 
            {
                rec.addX(dx);
                rec.addY(dy);
            }
          x += dx;
          y += dy;            
        }
      
      
        @Override
        public void handle(MouseEvent event) {
      
         rec = (Rectangle_New) event.getSource();
         if (event.getEventType()==MouseEvent.MOUSE_PRESSED){
            x = event.getX();
            y = event.getY();
          }
          if (event.getEventType()==MouseEvent.MOUSE_DRAGGED){
            doMove(event);
          }
      
        }
      }
      */
}
