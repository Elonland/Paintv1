import javafx.scene.Group;
/**
 * @brief This StateMachine keeps track of number of clicks
 * {@link Figure#drawFigure(Group root) Figure}
 * {@link Rectangle_New#drawFigure(Group root) Rectangle}
 * {@link CircleFx#drawFigure(Group root) Circle}
 * {@link TriangleFx#drawFigure(Group root) Triangle}
 */
public enum StateMachine 
{ 
    ZeroClicks
    {
        @Override
        /**
         *  @brief it changes to nextState OneClick
         */
        public StateMachine nextState()
        {
            return OneClick;
        }
        /**
         *  @brief This method is used when we click certain number of times
         *  @param root Group where figures are located.
         *  @param SelectedFigure As name suggests is stores number of a selected figure.
         *  @param nothing In this case it is useless but it stores copied version of figures 
         */
        public int Handle(Group root, int SelectedFigure, Figure nothing)
        {
            System.console().printf("State: Zero Click\n"); 
            return -1;
        }
    },
    OneClick
    {
        /**
         *  {@brief When we have selected circle it will call funtion and return number of that figure
         *          if it isn't selected it return -1}
         *  @param root Group where figures are located.
         *  @param SelectedFigure As name suggests is stores number of a selected figure.
         *  @param circle object circle is used to call function drawFigure().
         *  @see CircleFx#drawFigure(Group root)
         *  @see Figure#drawFigure(Group root) 
         */
        public int Handle(Group root, int SelectedFigure, Figure circle)
        {
            System.console().printf("State: One Click\n"); 
            if(SelectedFigure == 2)
            {
                circle.drawFigure(root);
                return 2;
            }
            return -1;
        }
        @Override
        public StateMachine nextState()
        {
            return TwoClicks;
        }
        
    },
    TwoClicks
    {
        boolean drawn = false;
        /**
         *  {@brief When we have selected rectangle it will call funtion and return number of that figure
         *          if it isn't selected it return -1}
         *  @param root Group where figures are located.
         *  @param SelectedFigure As name suggests is stores number of a selected figure.
         *  @param rectangle object rectangle is used to call function drawFigure().
         *  @see Figure#drawFigure(Group root) 
         *  @see Rectangle_New#drawFigure(Group root)
         */
        public int Handle(Group root, int SelectedFigure, Figure rectangle)
        {
            System.console().printf("State: Two Clicks\n"); 
            if(SelectedFigure == 1)
            {
                rectangle.drawFigure(root);
                drawn = true;
                return 1;
            }
            drawn = false;
            return -1;  
        }
        @Override
        public StateMachine nextState()
        {
            System.console().printf(drawn + "\n"); 
            if(drawn)
            {
                return ZeroClicks;
            } 
            else
            {
                //System.console().printf(drawn + "  returning ThreeClicks\n"); 
                return ThreeClicks;
            }  
        } 
    },
    ThreeClicks
    {
        /**
         *  {@brief When we have selected triangle it will call funtion and return number of that figure
         *          if it isn't selected it return -1}
         *  @param root Group where figures are located.
         *  @param SelectedFigure As name suggests is stores number of a selected figure.
         *  @param triangle object triangle is used to call function drawFigure().
         *  @see Figure#drawFigure(Group root) 
         *  @see TriangleFx#drawFigure(Group root)
         */
        public int Handle(Group root, int SelectedFigure, Figure triangle)
        {
            System.console().printf("State: Three Clicks\n"); 
            if(SelectedFigure == 3)
            {
                triangle.drawFigure(root);
                return 3;
            }
            return -1;
        }
        @Override
        public StateMachine nextState()
        {
            //System.console().printf("I'am in ThreeClicks\n");
            return ZeroClicks;
        }
    };
    public abstract StateMachine nextState();
    public abstract int Handle(Group root, int SelectedFigure, Figure figure);
}
