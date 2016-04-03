package org.mb.lanterna.tests;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.Ignore;
import org.junit.Test;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.io.IOException;

public class TextBoxPasswordTest {
    @Ignore @Test
    public void testTextBoxPassword() throws IOException {
        // Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();

        if (terminal instanceof JFrame) {
            ((JFrame)terminal).setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }

        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        // Create panel to hold components
        Panel panel = new Panel();
        TextBox box = new TextBox(new TerminalSize(20, 1));
        box.setMask('*');
        panel.addComponent(box);

        // Create window to hold the panel
        BasicWindow window = new BasicWindow();
        window.setComponent(panel);

        // Create gui and start gui
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(window);
    }
}
