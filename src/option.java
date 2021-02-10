public class option
{
    week week;
    boolean isAvailable;
    public option()
    {
        week = new week();
        isAvailable = true;
    }
    public void addLessonToWeek(String lessonCode,time[] timeCodes)
    {
        for (time i : timeCodes)
        {
            for (int i1 :i.timeCode){

                    if (!week.days[i.dayCode].times[i1].equals("")) {
                        isAvailable = false;
                    } else {
                        week.days[i.dayCode].times[i1] = lessonCode;
                    }

        }
        }
    }
}
