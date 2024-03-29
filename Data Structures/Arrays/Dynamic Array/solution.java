import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */
     //static ArrayList<ArrayList <Integer>> lists = new ArrayList<>();
     
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
    ArrayList<ArrayList <Integer>> lists = new ArrayList<>();
    ArrayList<Integer> result = new ArrayList<>();
    int lastAnswer = 0;
    List<Integer> q;
    //lists.addAll(queries);
    for (int i = 0; i < n; i++) 
    {
      lists.add(new ArrayList<>());
    }

    for(int i = 0; i < queries.size(); i++)
    {
        q = queries.get(i);
        if(q.get(0) == 1)
        {
            lists.get((q.get(1) ^ lastAnswer) % n).add(q.get(2));
        } 
        else 
        {
        List<Integer> seq = lists.get((q.get(1) ^ lastAnswer) % n);
        lastAnswer = seq.get(q.get(2) % seq.size());
        result.add(lastAnswer);
        }
        }
        return result;
    }
    
    }

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
//
