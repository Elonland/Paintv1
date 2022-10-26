import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


/**
 *  Main part of the program it tracks everything
 *  that happens on screen
 *  {@link Selection.java Selection}
 */
public class FxCanvas extends Application {
    
    @Override
    public void start(Stage stage) 
    {
        //Change State
        ChangeState changeState = new ChangeState();
        //State Machine
        //StateMachine state = StateMachine.ZeroClicks; 
        //Alert
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Program Info:");
        alert.setContentText("Name: Painful Paint\n" +
                             "Usage: This program was meant to draw figures\n" +
                             "Author: Tobiasz Jędrzejek");

        //Information how to use
        Alert howToUse = new Alert(AlertType.INFORMATION);
        howToUse.setTitle("Instruction");
        howToUse.setHeaderText("How to use this amazing program:");
        howToUse.setContentText("You have to pick a figure and then click " +
                             "on the empty space (don't change figure " +
                             "while painting diffrent one!!)");

        //Selected figure
        Selection select = new Selection(); //1 rect, 2 circle, 3 triangle
        //Rectangle
        Figure rectangle = new Rectangle_New();
        //Circle
        Figure circle = new CircleFx();
        //Triangle
        Figure triangle = new TriangleFx();
        //Visual Stuff
        Group root = new Group();
        Scene scene = new Scene(root,800,800);

        Menu menu = new Menu("Figures");
        Menu info = new Menu("Info");
        MenuItem m1 = new MenuItem("Circle");
        MenuItem m2 = new MenuItem("Rectangle");
        MenuItem m3 = new MenuItem("Triangle");
        MenuItem infoAboutProgram = new MenuItem("About Program");
        MenuItem instruction = new MenuItem("How do I use this ****");

        menu.getItems().addAll(m1,m2,m3);
        info.getItems().addAll(infoAboutProgram, instruction);

        MenuBar menuBar = new MenuBar();

        menuBar.getMenus().add(menu);
        menuBar.getMenus().add(info);
        /**
         * @brief When clicked it will pass a number to object select from Selection class
         * @see Selection
         */
        m1.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void  handle(ActionEvent event)
            {   
                select.figureNumber(2);
                changeState.resetState();
                System.console().printf("Thats Circle\n");
            }
        });
        /**
         * @brief When clicked it will pass a number to object select from Selection class
         * @see Selection.java
         */
        m2.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event)
            {
                select.figureNumber(1);
                changeState.resetState();
                rectangle.resetFigure();
                System.console().printf("Selected Rectangle\n");
            }
        });
        /**
         * @brief When clicked it will pass a number to object select from Selection class
         * @see Selection.java
         */
        m3.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void  handle(ActionEvent event)
            {
                select.figureNumber(3);
                changeState.resetState();
                System.console().printf("Thats Triangle\n");
            }
        });
        /**
         * @brief When clicked it will show basic information
         * 
         */
        infoAboutProgram.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event)
            {
                alert.showAndWait();
            }
        });
        /**
         * @brief When clicked it will show info about usage of program
         * 
         */
        instruction.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event)
            {
                howToUse.showAndWait();
            }
        });

        root.getChildren().add(menuBar);
        
        //Mouse

        /**
         * @brief Main part of this program it will track every mouse click.
         */
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() 
        { 
            @Override 
            public void handle(MouseEvent e) { 
            
                if(!menuBar.isPressed())    //We don't wont to track menu presses.
                {
                    final double x = e.getSceneX();
                    final double y = e.getSceneY();
                    if(select.figureSelection() == 1)   //Rectangle 
                    {
                        rectangle.Coordinates(x, y);    //It sends x and y to rectangle object.
                        changeState.changeState(root,
                                            select.figureSelection(),
                                            rectangle); //It changes state in State Machine.
                    }  
                    else if(select.figureSelection() == 2)  //Circle
                    {
                        circle.Coordinates(x, y);
                        changeState.changeState(root,
                                            select.figureSelection(),
                                            circle); 
                    }
                    else if(select.figureSelection() == 3)  //Triangle
                    {
                        //System.console().printf("Detected triangle\n");
                        triangle.Coordinates(x, y);
                        changeState.changeState(root,
                                            select.figureSelection(),
                                            triangle); 
                    }
                    else
                    {
                        System.console().printf("Nothing selected\n");
                    }
                        
                    
                    //state.Handle(root, select.figureSelection());
                    System.console().printf("X: " + x + "Y: " + y + "\n"); 
                }
                else
                    System.console().printf("Menu pressed\n");
            } 
        };       

        stage.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);    
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}