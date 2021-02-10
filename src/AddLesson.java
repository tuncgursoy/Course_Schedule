import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLesson {
    private JButton ADDButton;
    private JTextField textField1;
    private JTextField textField2;
    JPanel panel;

    public AddLesson() {
        ADDButton.addActionListener(e -> {
            boolean isExist = false ;
            String Code = textField1.getText();
            int Credit = Integer.parseInt(textField2.getText());
            for(lesson lesson: staticVar.lessons.lessons)
            {
                if (lesson.code.equalsIgnoreCase(Code))
                {
                    isExist= true;
                }
            }
            if (!isExist)
            {
                staticVar.lessons.addLesson(new lesson(Code,Credit));
                GUI.addLesson.dispose();
                JOptionPane.showMessageDialog(new Frame(),"Lesson added");
                GUI.tempAddLesson.doClick();
            }else
                {
                 JOptionPane.showMessageDialog(new Frame(),"Already Exists");
                }
        });
    }
}
