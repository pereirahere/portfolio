package streetFighter.inputs;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Inputs implements KeyboardHandler {

/**


    Ao usar inputs usar sempre i setInput Screen() antes do que queremos



*/


    public static ToDo inputScreen;

    private Keyboard keyboard = new Keyboard(this);
    private KeyboardEvent upPressed = new KeyboardEvent();
    private KeyboardEvent downPressed = new KeyboardEvent();
    private KeyboardEvent rightPressedP1 = new KeyboardEvent();
    private KeyboardEvent leftPressedP1 = new KeyboardEvent();
    private KeyboardEvent spacePressed = new KeyboardEvent();
    private KeyboardEvent rightPressedP2 = new KeyboardEvent();
    private KeyboardEvent leftPressedP2 = new KeyboardEvent();
    private KeyboardEvent spacePressedP2 = new KeyboardEvent();
    private KeyboardEvent pPressed = new KeyboardEvent();
    private KeyboardEvent onePressed = new KeyboardEvent();


    public Inputs(){


        upPressed.setKey(KeyboardEvent.KEY_UP);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        rightPressedP1.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressedP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        leftPressedP1.setKey(KeyboardEvent.KEY_LEFT);
        leftPressedP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        rightPressedP2.setKey(KeyboardEvent.KEY_D);
        rightPressedP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        leftPressedP2.setKey(KeyboardEvent.KEY_A);
        leftPressedP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        spacePressedP2.setKey(KeyboardEvent.KEY_W);
        spacePressedP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        pPressed.setKey(KeyboardEvent.KEY_P);
        pPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        onePressed.setKey(KeyboardEvent.KEY_1);
        onePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);





        KeyboardEvent spaceDepressed = new KeyboardEvent();
        spaceDepressed.setKey(KeyboardEvent.KEY_SPACE);
        spaceDepressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent oneDepressed = new KeyboardEvent();
        oneDepressed.setKey(KeyboardEvent.KEY_1);
        oneDepressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);




        keyboard.addEventListener(upPressed);
        keyboard.addEventListener(downPressed);
        keyboard.addEventListener(spacePressed);
        keyboard.addEventListener(rightPressedP1);
        keyboard.addEventListener(leftPressedP1);
        keyboard.addEventListener(rightPressedP2);
        keyboard.addEventListener(leftPressedP2);
        keyboard.addEventListener(spacePressedP2);
        keyboard.addEventListener(pPressed);
        keyboard.addEventListener(onePressed);


        keyboard.addEventListener(spaceDepressed);
        keyboard.addEventListener(oneDepressed);


    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        inputScreen.actionPressed(keyboardEvent.getKey());
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) { inputScreen.actionReleased(keyboardEvent.getKey());

    }

    public static void setInputScreen(ToDo inputScreen2) {
        inputScreen = inputScreen2;
    }



    //    InputsTypes inputTypes;
////    Object obj;
////    MainMenu mainMenu = (MainMenu) obj;

   /* public Inputs(InputsTypes inputTypes, Object obj){
        this.inputTypes = inputTypes;
        this.obj = obj;
        init();

    }*/

    /*public void init(){
        Keyboard keyboard = new Keyboard(this);


        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_UP);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(upPressed);
        keyboard.addEventListener(downPressed);
        keyboard.addEventListener(spacePressed);

        //TODO: adicionar o resto das teclas


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (inputTypes){
            case MAIN_MENU:
                switch (keyboardEvent.getKey()){

                    case KeyboardEvent.KEY_DOWN:
                        switch (mainMenu.getCurrentlyPressedPosition()) {

                            case 1:
                                mainMenu.getRectangle().delete();
                                mainMenu.getRectangle2().draw();
                                mainMenu.incrementCurrentlyPressedPosition();

                                break;

                            case 2:
                                mainMenu.getRectangle2().delete();
                                mainMenu.getRectangle3().draw();
                                mainMenu.incrementCurrentlyPressedPosition();
                                break;

                            case 3:
                                mainMenu.getRectangle3().delete();
                                mainMenu.getRectangle().draw();
                                mainMenu.setCurrentlyPressedPosition(1);
                                break;
                        }
                        break;

                    case KeyboardEvent.KEY_UP:
                        switch (mainMenu.getCurrentlyPressedPosition()) {

                            case 1:
                                mainMenu.getRectangle().delete();
                                mainMenu.getRectangle3().draw();
                                mainMenu.setCurrentlyPressedPosition(3);
                                break;

                            case 2:
                                mainMenu.getRectangle2().delete();
                                mainMenu.getRectangle().draw();
                                mainMenu.decrementCurrentlyPressedPosition();
                                break;

                            case 3:
                                mainMenu.getRectangle3().delete();
                                mainMenu.getRectangle2().draw();
                                mainMenu.decrementCurrentlyPressedPosition();
                                break;
                        }
                        break;

                    case KeyboardEvent.KEY_SPACE:
                        switch (mainMenu.getCurrentlyPressedPosition()) {

                            case 1:
                                System.out.println("1");
                                mainMenu.startGame();

                                break;

                            case 2:
                                System.out.println("2");
                                mainMenu.instructions();
                                break;

                            case 3:
                                // Exit clause (DONE)
                                System.out.println("3");
                                Runtime.getRuntime().exit(0);
                                break;
                            default:
                                System.out.println("DEFAULT");
                        }
                        break;
                }




                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}*/







}
