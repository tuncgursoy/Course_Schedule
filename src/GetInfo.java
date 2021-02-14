import javax.swing.*;
import java.util.ArrayList;

public class GetInfo {
    JPanel panel;
    private JList list1;

    GetInfo(option option,int totalCredit)
    {
        DefaultListModel model = new DefaultListModel();
        ArrayList<String> lesson = new ArrayList<>();
        for (day day : option.week.days)
        {
            for (String time : day.times)
            {
                if (!time.equals("")&&!lesson.contains(time))
                {
                    lesson.add(time);
                }
            }
        }
        for(String string : lesson)
        {
          String[] arr =  string.split("_");
          String code = arr[0];
          String section = arr[1];
          model.addElement(code+"-"+"Section :"+section);
        }
        model.addElement("Total Credit: "+totalCredit);
        list1.setModel(model);
    }
}
