import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteSection {
    private JButton deleteButton;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JComboBox comboBox2;
    JPanel panel;
    private section sectionTemp;
    private lesson temp ;
    public DeleteSection() {

        for(lesson i : staticVar.lessons.lessons)
        {
            if (!i.sections.isEmpty()) {
                comboBox1.addItem(i.code);
            }
        }
        comboBox1.addActionListener(e -> {
            comboBox2.removeAllItems();
            comboBox2.setEnabled(true);
            for (lesson i : staticVar.lessons.lessons)
            {
                if (comboBox1.getSelectedItem().equals(i.code))
                {
                    temp = i;
                    for (section t : i.sections )
                    {
                        comboBox2.addItem(t.number);
                    }
                    break;
                }
            }
        });
        comboBox2.addActionListener(e -> {
            textField1.setText("");
            for (section i : temp.sections)
            {
                if (comboBox2.getSelectedItem().equals(i.number))
                {
                    sectionTemp = i;
                    StringBuilder tempString = new StringBuilder();
                    for (int t=0;t<i.numberOfDay;t++)
                    {
                        String Day ;
                        switch (i.times[t].dayCode)
                        {
                            case 0:
                                Day="Mo";
                                break;
                            case 1:
                                Day="Tu";
                                break;
                            case 2:
                                Day="We";
                                break;
                            case 3:
                                Day="Th";
                                break;
                            case 4:
                                Day="Fr";
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + i.times[t].dayCode);
                        }
                       tempString.append(" ").append(Day).append(" ").append(ArrOfTime(i.times[t].timeCode[0], i.times[t].timeCode[i.times[t].timeCode.length - 1]));
                    }
                    textField1.setText(tempString.toString());
                    deleteButton.setEnabled(true);
                }
            }
        });
        deleteButton.addActionListener(e -> {
            ArrayList<section> sections = new ArrayList<>();
            for (int i = 0 ; i<staticVar.lessons.lessons.size();i++)
            {
                if (staticVar.lessons.lessons.get(i).equals(temp))
                {
                    for (int t = 0 ; t<staticVar.lessons.lessons.get(i).sections.size();t++)
                    {
                        if (!staticVar.lessons.lessons.get(i).sections.get(t).equals(sectionTemp))
                        {
                            sections.add(staticVar.lessons.lessons.get(i).sections.get(t));
                        }
                    }
                    staticVar.lessons.lessons.get(i).sections = sections;
                    GUI.deleteSection.dispose();
                    JOptionPane.showMessageDialog(new JFrame(), "Section Deleted From"+staticVar.lessons.lessons.get(i).code);
                    break;
                }
            }
        });
    }
    public String ArrOfTime(int time1,int time2)
    {
        String startCode= findTimeCode(time1),finishCode= findTimeCode(time2);

        return startCode+" - "+finishCode;
    }
    private String findTimeCode(int temp)
    {

        return switch (temp) {
            case  0 -> "09";
            case  1 -> "10";
            case  2 -> "11";
            case  3 -> "12";
            case  4 -> "13";
            case  5 -> "14";
            case  6 -> "15";
            case  7 -> "16";
            case  8 -> "17";
            case  9 -> "18";
            case 10 -> "19";
            case 11 -> "20";
            case 12 -> "21";
            default -> throw new IllegalStateException("Unexpected value: " + temp);
        };
    }
}
