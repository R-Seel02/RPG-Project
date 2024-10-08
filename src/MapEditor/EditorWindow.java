package MapEditor;

import MapEditor.MenuBar;
import java.awt.*;
import javax.swing.*;

public class EditorWindow {
    private JFrame editorWindow;
    private EditorMainPanel editorMainPanel;

    public EditorWindow() {
        editorWindow = new JFrame("Map Editor");
        editorMainPanel = new EditorMainPanel(editorWindow);
        editorWindow.setContentPane(editorMainPanel);
        editorWindow.setResizable(true);
        editorWindow.setSize(800, 600);
        editorWindow.setMinimumSize(new Dimension(1600, 1000));
        editorWindow.setLocationRelativeTo(null);
        editorWindow.setVisible(true);
        editorWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // it'd be nice if this actually worked more than 1/3rd of the time
        editorWindow.setJMenuBar(new MenuBar(editorMainPanel.getMapBuilder().getTileBuilder()));
        editorWindow.validate();
        editorMainPanel.getMapBuilder().scrollToMaxY();
    }

}
