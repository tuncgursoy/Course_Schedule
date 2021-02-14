import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GUI {
    private JButton newProgramButton;
    private JButton addLessonButton;
    private JButton addSectionButton;
    private JComboBox comboBox1;
     JPanel panel;
    private JTextField m0;
    private JTextField m1;
    private JTextField m2;
    private JTextField m3;
    private JTextField m4;
    private JTextField m5;
    private JTextField m6;
    private JTextField m7;
    private JTextField m8;
    private JTextField m9;
    private JTextField m10;
    private JTextField m11;
    private JTextField Tu0;
    private JTextField Tu1;
    private JTextField Tu2;
    private JTextField Tu3;
    private JTextField Tu4;
    private JTextField Tu5;
    private JTextField Tu6;
    private JTextField Tu7;
    private JTextField Tu8;
    private JTextField Tu9;
    private JTextField Tu10;
    private JTextField Tu11;
    private JTextField w0;
    private JTextField w1;
    private JTextField w2;
    private JTextField w3;
    private JTextField w4;
    private JTextField w5;
    private JTextField w6;
    private JTextField w7;
    private JTextField w8;
    private JTextField w9;
    private JTextField w10;
    private JTextField w11;
    private JTextField Th0;
    private JTextField Th1;
    private JTextField Th2;
    private JTextField Th3;
    private JTextField Th4;
    private JTextField Th5;
    private JTextField Th6;
    private JTextField Th7;
    private JTextField Th8;
    private JTextField Th9;
    private JTextField Th10;
    private JTextField Th11;
    private JTextField f0;
    private JTextField f1;
    private JTextField f2;
    private JTextField f3;
    private JTextField f4;
    private JTextField f5;
    private JTextField f6;
    private JTextField f7;
    private JTextField f8;
    private JTextField f9;
    private JTextField f10;
    private JTextField f11;
    private JButton calculateButton;
    private JButton deleteSectionButton;
    private JButton deleteLessonButton;
    private JButton saveButton;
    private JButton openProgramButton;
    private JButton getInfoButton;
    private JButton csvReadButton;
    static JFrame addSection;
    static JFrame addLesson;
    static JFrame deleteLesson;
    static JFrame GetInfo;
    static JButton tempAddLesson;
    static JButton tempDeleteSectionButton;
    static JButton tempAddSection;
    static JButton tempDeleteLesson;
    static JFrame deleteSection;

    GUI()
    {

        addLessonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                addLesson = new JFrame();
                addLesson.setContentPane(new AddLesson().panel);
                addLesson.setTitle("Add Lesson");
                addLesson.setVisible(true);
                addLesson.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                int w = addLesson.getSize().width;
                int h = addLesson.getSize().height;
                int x = (dim.width-w)/2;
                int y = (dim.height-h)/2;
                addLesson.setLocation(x, y);
                addLesson.setResizable(false);
                tempAddLesson = addLessonButton;
                addLesson.pack();

            }
        });
        addSectionButton.addActionListener(e -> {
            addSection = new JFrame();
            addSection.setContentPane(new AddSection().panel1);
            addSection.setTitle("Add Section");
            addSection.setVisible(true);
            addSection.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            addSection.setFocusable(true);
            int w = addSection.getSize().width;
            int h = addSection.getSize().height;
            int x = (dim.width-w)/2;
            int y = (dim.height-h)/2;
            addSection.setLocation(x, y);
            addSection.setResizable(false);
            tempAddSection = addSectionButton;
            addSection.pack();
        });
        newProgramButton.addActionListener(e -> {
            staticVar.lessons = new lessons();
            comboBox1.removeAllItems();
            getInfoButton.setEnabled(false);

        });
        calculateButton.addActionListener(e -> {
            staticVar.options = null;
            staticVar.options = new ArrayList[staticVar.lessons.lessons.size()];
           for (int i = 0 ; i<staticVar.lessons.lessons.size();i++)
           {
               staticVar.options[i]= new ArrayList<>();
           }
           int i = 0 ;
           for (lesson lesson : staticVar.lessons.lessons)
           {
               for (section section:lesson.sections) {
                   option tempOption;
                   if (i == 0) {
                       tempOption = new option();
                        tempOption.addLessonToWeek(lesson.code+"_"+section.number,section.times);
                       staticVar.options[i].add(tempOption);
                   }else
                       {
                           for (option option : staticVar.options[i-1])
                           {
                               if (option.isAvailable) {

                                   tempOption = new option();
                                   tempOption.isAvailable = option.isAvailable;
                                   int tempcount = 0;
                                   for (day day:option.week.days)
                                   {
                                       int count = 0 ;
                                       for (String string : day.times)
                                       {
                                           tempOption.week.days[tempcount].times[count]=day.times[count];
                                           count++;
                                       }
                                        tempcount++;
                                   }
                                   tempOption.addLessonToWeek(lesson.code + "_" + section.number, section.times);
                                   staticVar.options[i].add(tempOption);
                               }
                           }
                       }
               }
               i++;
           }
           comboBox1.removeAllItems();
           if (staticVar.options.length!=0) {
               for (option option : staticVar.options[staticVar.lessons.lessons.size() - 1]) {
                   if (option.isAvailable) {
                       comboBox1.addItem(option);
                   }
               }
           }
        });
        comboBox1.addActionListener(e -> {
            try {
                getInfoButton.setEnabled(true);
                for (option option : staticVar.options[staticVar.lessons.lessons.size() - 1]) {
                    if (comboBox1.getSelectedItem() == option) {
                        int daycount = 0;
                        for (day day : option.week.days) {
                            if (day != null) {
                                int timeCount = 0;
                                for (String codes : day.times) {
                                    switch (daycount) {
                                        case 0:
                                            switch (timeCount) {
                                                case 0 -> m0.setText(codes);
                                                case 1 -> m1.setText(codes);
                                                case 2 -> m2.setText(codes);
                                                case 3 -> m3.setText(codes);
                                                case 4 -> m4.setText(codes);
                                                case 5 -> m5.setText(codes);
                                                case 6 -> m6.setText(codes);
                                                case 7 -> m7.setText(codes);
                                                case 8 -> m8.setText(codes);
                                                case 9 -> m9.setText(codes);
                                                case 10 -> m10.setText(codes);
                                                case 11 -> m11.setText(codes);
                                            }
                                            break;
                                        case 1:
                                            switch (timeCount) {
                                                case 0 -> Tu0.setText(codes);
                                                case 1 -> Tu1.setText(codes);
                                                case 2 -> Tu2.setText(codes);
                                                case 3 -> Tu3.setText(codes);
                                                case 4 -> Tu4.setText(codes);
                                                case 5 -> Tu5.setText(codes);
                                                case 6 -> Tu6.setText(codes);
                                                case 7 -> Tu7.setText(codes);
                                                case 8 -> Tu8.setText(codes);
                                                case 9 -> Tu9.setText(codes);
                                                case 10 -> Tu10.setText(codes);
                                                case 11 -> Tu11.setText(codes);
                                            }
                                            break;
                                        case 2:
                                            switch (timeCount) {
                                                case 0 -> w0.setText(codes);
                                                case 1 -> w1.setText(codes);
                                                case 2 -> w2.setText(codes);
                                                case 3 -> w3.setText(codes);
                                                case 4 -> w4.setText(codes);
                                                case 5 -> w5.setText(codes);
                                                case 6 -> w6.setText(codes);
                                                case 7 -> w7.setText(codes);
                                                case 8 -> w8.setText(codes);
                                                case 9 -> w9.setText(codes);
                                                case 10 -> w10.setText(codes);
                                                case 11 -> w11.setText(codes);
                                            }
                                            break;
                                        case 3:
                                            switch (timeCount) {
                                                case 0 -> Th0.setText(codes);
                                                case 1 -> Th1.setText(codes);
                                                case 2 -> Th2.setText(codes);
                                                case 3 -> Th3.setText(codes);
                                                case 4 -> Th4.setText(codes);
                                                case 5 -> Th5.setText(codes);
                                                case 6 -> Th6.setText(codes);
                                                case 7 -> Th7.setText(codes);
                                                case 8 -> Th8.setText(codes);
                                                case 9 -> Th9.setText(codes);
                                                case 10 -> Th10.setText(codes);
                                                case 11 -> Th11.setText(codes);
                                            }
                                            break;

                                        case 4:
                                            switch (timeCount) {
                                                case 0 -> f0.setText(codes);
                                                case 1 -> f1.setText(codes);
                                                case 2 -> f2.setText(codes);
                                                case 3 -> f3.setText(codes);
                                                case 4 -> f4.setText(codes);
                                                case 5 -> f5.setText(codes);
                                                case 6 -> f6.setText(codes);
                                                case 7 -> f7.setText(codes);
                                                case 8 -> f8.setText(codes);
                                                case 9 -> f9.setText(codes);
                                                case 10 -> f10.setText(codes);
                                                case 11 -> f11.setText(codes);
                                            }
                                            break;
                                    }
                                    timeCount++;
                                }
                            }
                            daycount++;
                        }
                    }
                }
            }catch (Exception ss)
            {

            }
        });

        deleteSectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSection = new JFrame();
                deleteSection.setContentPane(new DeleteSection().panel);
                deleteSection.setVisible(true);
                deleteSection.setTitle("Delete Section");
                deleteSection.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                int w = deleteSection.getSize().width;
                int h = deleteSection.getSize().height;
                int x = (dim.width-w)/2;
                int y = (dim.height-h)/2;
                deleteSection.setLocation(x, y);
                deleteSection.setResizable(false);
                tempDeleteSectionButton = deleteSectionButton;
                deleteSection.pack();
            }
        });
        deleteLessonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteLesson = new JFrame();
                deleteLesson.setContentPane(new DeleteLesson().panel);
                deleteLesson.setVisible(true);
                deleteLesson.setTitle("Delete Lesson");
                deleteLesson.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                int w = deleteLesson.getSize().width;
                int h = deleteLesson.getSize().height;
                int x = (dim.width-w)/2;
                int y = (dim.height-h)/2;
                deleteLesson.setLocation(x, y);
                deleteLesson.setResizable(false);
                tempDeleteLesson = deleteLessonButton;
                deleteLesson.pack();
            }
        });
        saveButton.addActionListener(e -> {
            String current = "";
            try {
                 current = new File( "." ).getCanonicalPath();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            File directory = new File(current+"\\Plans");
            String fileName = JOptionPane.showInputDialog("Enter File Name");
            if (fileName.equals(""))
            {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm-dd-ss");
                LocalDateTime now = LocalDateTime.now();
                fileName = dtf.format(now);
            }
            File txt = new File(current+"\\Plans\\"+fileName+".cs");
            try {
                txt.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            FileWriter  out = null;
            try {
                out = new FileWriter(current+"\\Plans\\"+fileName+".cs");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            for (lesson i : staticVar.lessons.lessons)
            {
                for (section t : i.sections) {
                    try {
                        out.write(i.code+"~"+i.credit+"~"+Convert(t)+"\n");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
            try {
                out.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            JOptionPane.showMessageDialog(new JFrame(), "Saved to "+ current+"\\Plans\\"+fileName+".cs");



        });
        openProgramButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            File f = null;
            try {
                 f = new File(new File(".").getCanonicalPath()+"\\Plans");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            fileChooser.setCurrentDirectory(f);
            fileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Course Schedule", "cs");
            fileChooser.addChoosableFileFilter(filter);
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
                staticVar.lessons = new lessons();

            while(scanner.hasNextLine())
            {
                String data = scanner.nextLine();
                String[] arr = data.split("~");
                boolean isExist = false ;
                int location = 0 ;
                for (lesson lesson : staticVar.lessons.lessons)
                {
                    location++;
                    if (lesson.code.equalsIgnoreCase(arr[0]))
                    {
                        isExist = true;
                        break;
                    }
                }
                if (isExist)
                {
                    staticVar.lessons.lessons.get(location-1).addSection(arr[2]);
                }else
                    {
                        lesson templesson = new lesson(arr[0],Integer.parseInt(arr[1]));
                        templesson.addSection(arr[2]);
                        staticVar.lessons.addLesson(templesson);
                    }
            }
            } catch (Exception exception) {
            }
        });
        getInfoButton.addActionListener(e -> {
            GetInfo = new JFrame();
            GetInfo.setContentPane(new GetInfo((option) Objects.requireNonNull(comboBox1.getSelectedItem()),staticVar.lessons.totalCredit).panel);
            GetInfo.setVisible(true);
            GetInfo.setTitle("Info");
            GetInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int w = GetInfo.getSize().width;
            int h = GetInfo.getSize().height;
            int x = (dim.width-w)/2;
            int y = (dim.height-h)/2;
            GetInfo.setLocation(x, y);
            GetInfo.setResizable(false);
            GetInfo.pack();
        });
    }
    public String ArrOfTime(int time1,int time2)
    {
        String startCode= findTimeCode(time1),finishCode= (Integer.parseInt(findTimeCode(time2))+1)+"";

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
    private String FindDay(int temp)
    {
        String Day = switch (temp) {
            case 0 -> "Mo";
            case 1 -> "Tu";
            case 2 -> "We";
            case 3 -> "Th";
            case 4 -> "Fr";
            default -> throw new IllegalStateException("Unexpected value: " + temp);
        };
        return Day;
    }
    private String Convert(section section)
    {
        String result = "";
        for (int i = 0 ; i<section.numberOfDay; i++)
        {
            result += FindDay(section.times[i].dayCode)+" "+ArrOfTime(section.times[i].timeCode[0],section.times[i].timeCode[section.times[i].timeCode.length-1])+" ";
        }
        return result;
    }

}
