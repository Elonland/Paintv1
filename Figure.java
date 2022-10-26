import javafx.scene.Group;

/**
 *   {@brief Interface for all the figures.}
*/
public interface Figure
{
    void drawFigure(Group root);
    void Coordinates(double x, double y);
    void resetFigure();
}
