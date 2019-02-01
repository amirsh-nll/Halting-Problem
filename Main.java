import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        long endTime;
        long totalTime = 0;

        Map<String, Integer> map = new HashMap<>();

        map.put("a", 0);
        map.put("b", 0);
        map.put("c", 0);
        map.put("d", 0);
        map.put("e", 0);
        map.put("f", 0);
        map.put("g", 0);
        map.put("h", 0);
        map.put("i", 0);
        map.put("j", 0);
        map.put("k", 0);
        map.put("l", 0);
        map.put("m", 0);
        map.put("n", 0);
        map.put("o", 0);
        map.put("p", 0);
        map.put("q", 0);
        map.put("r", 0);
        map.put("s", 0);
        map.put("t", 0);
        map.put("u", 0);
        map.put("v", 0);
        map.put("w", 0);
        map.put("x", 0);
        map.put("y", 0);
        map.put("z", 0);

        int tempgoto=0;
        int linego[] = new int[100001];
        int linegocounter = 0;
        int ll = 0;
        ll = Integer.parseInt(sc.nextLine());
        String []arr = new String[ll + 1];
        int ii = 0;
        for(int jj = ll; jj>0 ; jj--)
        {
            arr[ii] = sc.nextLine();
            ii++;
        }

        int run = 1;
        String result ="";
        int tempnum1 = 0, tempnum2 =0, tempnum3 = 0;
        while(run>0 && run <= ll)
        {
            endTime   = System.currentTimeMillis();
            totalTime = endTime - startTime;
            if(totalTime > 1900)
            {
                result = "-1";
                break;
            }

            String []temp = arr[run - 1].split(" ");

            if(temp[0].equals("assign"))
            {
                tempnum1 = 0;
                tempnum2 = 0;
                try
                {
                    tempnum1 = Integer.parseInt(temp[3]);
                }
                catch (NumberFormatException err)
                {
                    tempnum1 = map.get(temp[3]);
                }

                try
                {
                    tempnum2 = Integer.parseInt(temp[5]);
                }
                catch (NumberFormatException err)
                {
                    tempnum2 = map.get(temp[5]);
                }

                if(temp[4].equals("+"))
                    tempnum3 = tempnum1 + tempnum2;
                else if(temp[4].equals("-"))
                    tempnum3 = tempnum1 - tempnum2;
                else if(temp[4].equals("*"))
                    tempnum3 = tempnum1 * tempnum2;
                else if(temp[4].equals("/"))
                    tempnum3 = tempnum1 / tempnum2;

                map.put(temp[1], tempnum3);
            }
            else if(temp[0].equals("goto"))
            {
                tempnum3 = 0;
                try
                {
                    tempnum3 = Integer.parseInt(temp[1]);
                }
                catch (NumberFormatException err)
                {
                    tempnum3 = map.get(temp[1]);
                }
                run = tempnum3;
                if(run < 1)
                    run = 1;
                else if(run > ll)
                    break;

                if(linegocounter > 100000 )
                {
                    result = "-1";
                    break;
                }
                tempgoto = 0;
                for(int mm=0; mm<=linegocounter; mm++)
                {
                    if(run == linego[mm])
                        tempgoto++;

                    if(tempgoto>5)
                    {
                        result = "-1";
                        break;
                    }
                }
                linego[linegocounter] = run;
                linegocounter++;
                run--;
            }
            else if(temp[0].equals("cout"))
            {
                if(!result.equals(""))
                    result += "\n";

                try
                {
                    Integer.parseInt(temp[1]);
                }
                catch (NumberFormatException err)
                {
                    temp[1] = String.valueOf(map.get(temp[1]));
                }
                result += temp[1];
            }

            run++;
        }

        System.out.print(result);

    }
}