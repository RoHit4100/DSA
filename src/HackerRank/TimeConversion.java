package HackerRank;

public class TimeConversion {
    public static String timeConversion(String s) {
        // first get the period
        int n = s.length();
        String period = s.substring(n - 2); // this will give the periods, AM OR PM
        // now get the time
        String time = s.substring(0, n - 2);

        // now split the time from :
        String[] timeParts = time.split(":");
        // now get the hour, min and seconds
        String hour = timeParts[0];
        String minute = timeParts[1];
        String seconds = timeParts[2];

        // now check if the period is AM or not
        if(period.equals("AM")){
            if(hour.equals("12")){
                hour = "00";
            }
        }else{ // if pm then add 12 to it
            int h = Integer.parseInt(hour);
            if(h != 12){
                h += 12;
            }
            hour = String.valueOf(h);
        }

        return hour + ":" + minute + ":" + seconds;
    }
}
