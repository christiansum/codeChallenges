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

class Result2 {

	/*
	 * Complete the 'miniMaxSum' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void miniMaxSum(List<Integer> arr) {
		List<BigInteger> ordered = arr.stream()
				.sorted()
				.map(BigInteger::valueOf)
				.collect(toList());

		boolean isAllEquals = ordered.stream().allMatch(ordered.get(0)::equals);
		BigInteger firstSumArr;
		BigInteger lastSumArr;

		if (!isAllEquals) {
			firstSumArr = sumArr(ordered,ordered.get(arr.size()-1));
			lastSumArr = sumArr(ordered,ordered.get(0));
		}else{
			firstSumArr = lastSumArr = (ordered.get(0).multiply(BigInteger.valueOf((arr.size()-1))));
		}

		System.out.println(firstSumArr + " "+ lastSumArr);
	}

	public static BigInteger sumArr(List<BigInteger> ordered, BigInteger value){
		return ordered.stream()
				.filter(val -> !val.equals(value))
				.reduce(BigInteger.ZERO, BigInteger::add);
	}

}

public class Solution2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		Result2.miniMaxSum(arr);

		bufferedReader.close();
	}
}
