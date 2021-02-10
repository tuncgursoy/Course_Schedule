import java.util.ArrayList;

public class lessons
{
    ArrayList<lesson> lessons;
    int totalCredit;
    public lessons()
    {
        lessons = new ArrayList<>();
        totalCredit = 0 ;
    }
    public void addLesson(lesson lesson){
        lessons.add(lesson);
        totalCredit+=lesson.credit;
    }

}
