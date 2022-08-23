package andypad.andypad;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    AndyPad gui;
    public KeyHandler(AndyPad gui){
        this.gui = gui;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        boolean shiftDown = e.isShiftDown();
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){
            gui.file.save();
        }
        if(e.isShiftDown() && e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){
            gui.file.saveAs();
        }
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z){
            if(e.isShiftDown()){
                gui.edit.redo();
            }
            else{
                gui.edit.undo();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
