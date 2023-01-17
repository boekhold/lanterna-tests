package org.mb.lanterna.tests;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.ListSelectDialogBuilder;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.Ignore;
import org.junit.Test;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.io.IOException;

public class ListSelectDialogTest {
    @Ignore @Test
    public void testListSelectDialog() throws IOException {
        // Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();

        if (terminal instanceof JFrame) {
            ((JFrame)terminal).setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }

        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        final MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));

        // Create panel to hold components
        Panel panel = new Panel();
        Button button = new Button("Click for ListSelectDialog", new Runnable() {
            @Override public void run() {
                ListSelectDialogBuilder<String> builder = new ListSelectDialogBuilder<>();
                builder.addListItems("Item 1", "Item 2", "Item 3");
                String res = builder.build().showDialog(gui);
                System.out.println(res);
            }
        });

        panel.addComponent(button);

        // Create window to hold the panel
        BasicWindow window = new BasicWindow();
        window.setComponent(panel);

        // Create gui and start gui
        gui.addWindowAndWait(window);
    }
}
