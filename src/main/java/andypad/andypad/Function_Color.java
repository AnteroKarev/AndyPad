package andypad.andypad;



import java.awt.Color;



public class Function_Color {
    
    AndyPad gui;
    Color sepia_background = new Color(230, 210, 170);
    Color sepia_foreground = new Color(69, 63, 51);
    Color black_background = new Color(43, 43, 43);
    Color black_foreground = new Color(143, 159, 171);
    public Function_Color(AndyPad gui){
        
        this.gui = gui;
        
    }
    public void changeColor(String color){
        switch(color){
            case "White":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.white);
                gui.textArea.setForeground(Color.black); 
                break;
            case "Black":
                gui.window.getContentPane().setBackground(Color.black);
                gui.textArea.setBackground(black_background);
                gui.textArea.setForeground(black_foreground); 
                break;
            case "Sepia":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(sepia_background);
                gui.textArea.setForeground(sepia_foreground); 
                break;
        }
    }
}
