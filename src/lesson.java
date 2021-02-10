import java.util.ArrayList;

public class lesson {
    String code;
    ArrayList<section> sections;
    int credit ;

    public lesson(String code, int credit)
    {
        this.code = code;
        this.credit = credit;
        sections = new ArrayList<>();
    }
    public void addSection(String temp)
    {
        String[] arr = temp.split(" ");
        int times =(arr.length+1)/4;
        time[] arrt = new time[times];
        for (int i = 0 ; i<times;i++)
        {
            arrt[i] = new time(0,new int[]{});
        }
        for (int i = 0;i<=times-1;i++)
        {
            arrt[i].dayCode = findDayCode(arr[i * 4]);
            arrt[i].timeCode = ArrOfTime(arr[1+i*4],arr[3+i*4]);
        }

        sections.add(new section(sections.size()+1,times,arrt));
    }
    public int findDayCode(String tt)
    {
        return switch (tt) {
            case "Mo" -> 0;
            case "Tu" -> 1;
            case "We" -> 2;
            case "Th" -> 3;
            case "Fr" -> 4;
            default -> -1;
        };
    }
    public int[] ArrOfTime(String time1,String time2)
    {
        int startCode= findTimeCode(time1),finishCode= findTimeCode(time2);
       int[] arr = new int[finishCode-startCode];

       for (int i = 0 ; i<finishCode-startCode;i++)
       {
           arr[i]=startCode+i;
       }
       return arr;
    }
    private int findTimeCode(String temp)
    {

        return switch (temp) {
            case "09" -> 0;
            case "10" -> 1;
            case "11" -> 2;
            case "12" -> 3;
            case "13" -> 4;
            case "14" -> 5;
            case "15" -> 6;
            case "16" -> 7;
            case "17" -> 8;
            case "18" -> 9;
            case "19" -> 10;
            case "20" -> 11;
            case "21" -> 12;
            default -> -1;
        };
    }
}
