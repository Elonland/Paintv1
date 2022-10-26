/**
 *  @brief This class helps to track selected figures
 */
public class Selection 
{
    private int number;
    /**
     * 
     * @brief number will save the given representation of figure
     */
    public void figureNumber(int numberOfFigure)
    {
        number = numberOfFigure;
    }   
    /**
     * 
     * @brief It will return the given number.
     */
    public int figureSelection()
    {
        return number;
    } 
}
