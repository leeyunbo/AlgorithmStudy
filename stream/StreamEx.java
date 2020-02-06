package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArr = {"ccc","bbb","aaa"};
		List<String> strList = Arrays.asList(strArr);
		
		Stream<String> strStream1  = strList.stream();
		Stream<String> strStream2  = Arrays.stream(strArr);
		
		strStream2.sorted().forEach(System.out::print);
		System.out.println();
		List<String> strList2 = strStream1.sorted().collect(Collectors.toList());
		
		for(String str : strList2) {
			System.out.print(str);
		}

	}

}
