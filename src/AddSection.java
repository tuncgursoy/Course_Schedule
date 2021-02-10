import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AddSection {
    JPanel panel1;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton ADDButton;
    AddSection()
    {
        try {

            for (lesson lesson :staticVar.lessons.lessons)
            {
                comboBox1.addItem(lesson.code);
            }


        textField2.setText(staticVar.lessons.lessons.get(0).sections.size()+1+"");
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(),"No Lesson Added");
        }
        comboBox1.addActionListener(e -> {
            String temp = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
            for (lesson lesson :staticVar.lessons.lessons)
            {
               if (lesson.code.equalsIgnoreCase(temp))
               {
                   textField2.setText(lesson.sections.size()+1+"");
               }
            }

        });
        ADDButton.addActionListener(e -> {


                String temp = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
                for (lesson lesson : staticVar.lessons.lessons) {
                    if (lesson.code.equalsIgnoreCase(temp)) {
                        lesson.addSection(textField1.getText());
                        GUI.addSection.dispose();
                        JOptionPane.showMessageDialog(new JFrame(), "Section Added");
                        GUI.tempAddSection.doClick();
                    }
                }
            });

    }
}
