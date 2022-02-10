import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.stream.Collectors.joining;

class Result3 {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        SimpleDateFormat formatAMPM = new SimpleDateFormat("hh:mm:ssa");
        SimpleDateFormat militaryFormat = new SimpleDateFormat("HH:mm:ss");
        Date timeString;
        try {
            timeString = formatAMPM.parse(s);
        } catch (ParseException e) {
            timeString = new Date();
        }
        return militaryFormat.format(timeString);
    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result3.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}