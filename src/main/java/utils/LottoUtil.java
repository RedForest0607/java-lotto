package utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class LottoUtil {

	private static final int RANGE_MIN = 1;
	private static final int RANGE_MAX = 45;
	private static final int NUMBER_OF_LOTTO_NUMS = 6;

	private static List<Integer> lottos = IntStream.range(RANGE_MIN, RANGE_MAX)
													.boxed()
													.collect(Collectors.toList());

	public static List<Integer> getRandInts() {

		Collections.shuffle(lottos);
		return lottos.subList(0, NUMBER_OF_LOTTO_NUMS);
	}

	public static boolean isValidSizeOfNumbers(List<Integer> lottoNumbers) {
		return lottoNumbers.size() == NUMBER_OF_LOTTO_NUMS;
	}

	public static boolean isValidRangeOfNumbers(List<Integer> lottoNumbers) {
		return lottoNumbers.stream().allMatch(lottoNumber ->
			lottoNumber >= RANGE_MIN && lottoNumber <= RANGE_MAX
		);
	}

	public static boolean isNumbersUnique(List<Integer> lottoNumbers) {
		return lottoNumbers.stream().distinct().count() == NUMBER_OF_LOTTO_NUMS;
	}

	public static boolean isNumericList(List<String> lottoNumbers) {
		for (String str : lottoNumbers) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
				return false;
            }
        }
        return true;
	}
}
