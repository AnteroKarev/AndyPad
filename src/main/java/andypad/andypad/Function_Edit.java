package andypad.andypad;



public class Function_Edit {
    AndyPad gui;
    
    public Function_Edit(AndyPad gui){
        this.gui = gui;
    }
    public void undo(){
        gui.um.undo();
    }
    public void redo(){
         gui.um.redo();       
    }
}
