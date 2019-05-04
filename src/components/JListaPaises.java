package components;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;

/**
 * JListaPaises
 */
public class JListaPaises extends JComboBox {

    public static class paisesEditor implements ComboBoxEditor {

        @Override
        public Component getEditorComponent() {
            return null;
        }

        @Override
        public void setItem(Object anObject) {

        }

        @Override
        public Object getItem() {
            return null;
        }

        @Override
        public void selectAll() {

        }

        @Override
        public void addActionListener(ActionListener l) {

        }

        @Override
        public void removeActionListener(ActionListener l) {

        }

    }
}