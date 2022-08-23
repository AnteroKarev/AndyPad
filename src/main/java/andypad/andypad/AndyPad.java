package andypad.andypad;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.UndoManager;

public class AndyPad implements ActionListener{
    
    JFrame window;
    ImageIcon andyPadImage = new ImageIcon("C:/Users/user/Documents/NetBeansProjects/AndyPad/AndyPadIcon.png");
    //TEXT AREA
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    //TOP MENU BAR
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    //MENU BAR
    JMenuItem iNew, iNewWindow, iOpen, iSave, iSaveAs, iExit;
    //FORMAT MENU
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    JMenu menuFont, menuFontSize;
    //EDIT MENU
    JMenuItem iUndo, iRedo;
    //COLOR MENU
    JMenuItem iColor1, iColor2, iColor3;
    
    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    Function_Color color = new Function_Color(this);
    Function_Edit edit = new Function_Edit(this);
    KeyHandler handler = new KeyHandler(this);
    
    UndoManager um = new UndoManager();
    
    public static void main(String[] args) {
        new AndyPad();
    }
    
    public AndyPad(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createColorMenu();
        createEditMenu();
        
        format.selectedFont = "Arial";
        format.createFont(16);
        format.wordWrap();
        
        window.setIconImage(andyPadImage.getImage());
        window.setVisible(true);
    }
    
    public void createWindow(){
        
        window = new JFrame("AndyPad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void createTextArea(){
        textArea = new JTextArea();
        textArea.setMargin(new Insets(10, 15, 0, 0));
        textArea.getDocument().addUndoableEditListener((UndoableEditEvent e) -> {
            um.addEdit(e.getEdit());
        });
        textArea.addKeyListener(handler);
        
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }
    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
        
        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);
        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);
        menuColor = new JMenu("Color");
        menuBar.add(menuColor);        
    }
    public void createFileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);
        iNewWindow = new JMenuItem("New Window");
        iNewWindow.addActionListener(this);
        iNewWindow.setActionCommand("New Window");
        menuFile.add(iNewWindow);
        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);
        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);
        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        menuFile.add(iSaveAs);
        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }
    public void createFormatMenu(){
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);
        
        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);
        
        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);
        
        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);
        
        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);
        
        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);
        
        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);
        
        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);
        
        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);
        
        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);
        
        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);
        
        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size28");
        menuFontSize.add(iFontSize28);
    }
    public void createColorMenu(){
        
        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);
        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);
        iColor3 = new JMenuItem("Sepia");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Sepia");
        menuColor.add(iColor3);
    }
    
    public void createEditMenu(){
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);
        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        
        switch(command){
            case "New" : file.newFile(); break;
            case "Open" : file.open(); break;
            case "Save" : file.save(); break;
            case "Save As" : file.saveAs(); break;
            case "Exit" : file.exit(); break;
            case "Arial" : format.setFont(command); break;
            case "Comic Sans MS" : format.setFont(command); break;
            case "Times New Roman" : format.setFont(command); break;            
            case "Word Wrap" : format.wordWrap(); break;
            case "size8" : format.createFont(8); break;
            case "size12" : format.createFont(12); break;
            case "size16" : format.createFont(16); break;
            case "size20" : format.createFont(20); break;
            case "size24" : format.createFont(24); break;
            case "size28" : format.createFont(28); break;
            case "White" : color.changeColor(command); break;
            case "Black" : color.changeColor(command); break;
            case "Sepia" : color.changeColor(command); break;
            case "Undo" : edit.undo(); break;
            case "Redo" : edit.redo(); break;
            case "New Window" : file.newWindow(); break;
        }
    }
    
}
