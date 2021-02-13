import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteLesson {
    JPanel panel;
    private JButton deleteButton;
    private JComboBox comboBox1;
    lesson temp ;
    public DeleteLesson() {
        for(lesson i : staticVar.lessons.lessons)
        {
            comboBox1.addItem(i.code);
        }
        comboBox1.addActionListener(e -> {
            deleteButton.setEnabled(true);

        });


        deleteButton.addActionListener(e -> {
            ArrayList<lesson> lessons = new ArrayList<>();
            for (int i = 0; i<staticVar.lessons.lessons.size();i++)
            {
                if (!staticVar.lessons.lessons.get(i).code.equals(comboBox1.getSelectedItem().toString()))
                {
                    lessons.add(staticVar.lessons.lessons.get(i));
                }else
                    {
                        temp = staticVar.lessons.lessons.get(i);
                    }
            }
            staticVar.lessons.lessons = lessons;
            GUI.deleteLesson.dispose();
            JOptionPane.showMessageDialog(new JFrame(), "Lesson Deleted From DB: "+temp.code);
        });
    }
}
