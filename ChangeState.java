import javafx.scene.Group;

/**
 *  {@brief This class contains function that changes states of StateMachine.java
 *   also when figure is created it automaticly changes state to ZeroClicks}
 *  {@link StateMachine.java StateMachine}
 *  {@link FxCanvas.java FxCanvas}
 *  @see StateMachine
 */
public class ChangeState 
{
    StateMachine state = StateMachine.ZeroClicks;
    /**
     * 
     * @param root It's the group where figures are created.
     * @param select It stores the number of selected figure.
     * @param figure It is a copy of an object created in FxCanvas.java
     * @see FxCanvas
     */
    public void changeState(Group root, int select, Figure figure)
    {
        state = state.nextState();
        System.console().printf("Changing state\n");
        if(state.Handle(root, select, figure) != -1)
        {
            state = StateMachine.ZeroClicks;
        }
    }  
    public void resetState()
    {
        state = StateMachine.ZeroClicks;
    }  
}
