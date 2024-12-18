

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ComboBox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Item 1");
        map.put(2, "Item 2");
        map.put(3, "Item 3");
        
        JComboBox<String> comboBox = new JComboBox<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            comboBox.addItem(entry.getValue());
        }
        
        frame.setLayout(new FlowLayout());
        frame.add(comboBox);
        frame.setVisible(true);
    }
}
