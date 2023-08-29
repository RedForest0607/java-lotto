package utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoUtilTest {

	private static final int RANGE_MIN = 1;
	private static final int RANGE_MAX = 45;
	private static final int NUMBER_OF_LOTTO_NUMS = 6;

	@Test
	void 랜덤번호를_생성했을_때_중복되는_숫자_없이_6개의_숫자가_생성되어야_한다() {
		assertThat(LottoUtil.getRandInts()).hasSize(6);
	}

	@Test
	@DisplayName("로또 번호 갯수 검증")
	void 로또번호가_6개의_숫자가_맞으면_true를_반환하고_아니면_false를_반환해야_한다() {
		List<Integer> testList = IntStream.range(RANGE_MIN, RANGE_MAX).boxed()
			.collect(Collectors.toList())
			.subList(0, NUMBER_OF_LOTTO_NUMS);
		List<Integer> falseTestList = IntStream.range(RANGE_MIN, RANGE_MAX).boxed()
			.collect(Collectors.toList())
			.subList(0, NUMBER_OF_LOTTO_NUMS + 1);
		assertAll(
			() -> assertThat(LottoUtil.isValidSizeOfNumbers(testList)).isTrue(),
			() -> assertThat(LottoUtil.isValidSizeOfNumbers(falseTestList)).isFalse()
		);
	}

	@Test
	@DisplayName("로또 번호 자료형 검증")
	void 로또_번호가_숫자로_입력되었는지_검증한다() {

		List<String> testList = IntStream.range(RANGE_MIN, RANGE_MAX)
			.boxed()
			.map(num -> num.toString())
			.collect(Collectors.toList())
			.subList(0, NUMBER_OF_LOTTO_NUMS);
		List<String> modifiedList = new ArrayList<>(testList);
		Collections.replaceAll(modifiedList, modifiedList.get(2), "test");

		assertAll(
			() -> assertThat(LottoUtil.isNumericList(testList)).isTrue(),
			() -> assertThat(LottoUtil.isNumericList(modifiedList)).isFalse()
		);

	}

	@Test
	@DisplayName("로또 번호의 입력 범위가 1~45까지가 맞는지 검증")
	void 로또_번호의_입력_범위가_1_에서_45_까지가_맞는지_검증한다 () {
		List<Integer> testList = IntStream.range(RANGE_MIN, RANGE_MAX).boxed()
			.collect(Collectors.toList())
			.subList(0, NUMBER_OF_LOTTO_NUMS);
		List<Integer> modifiedList = new ArrayList<>(testList);
		Collections.replaceAll(modifiedList, modifiedList.get(2), RANGE_MAX + 1);

		assertAll(
			() -> assertThat(LottoUtil.isValidRangeOfNumbers(testList)).isTrue(),
			() -> assertThat(LottoUtil.isValidRangeOfNumbers(modifiedList)).isFalse()
		);
	}

	@Test
	@DisplayName("로또 번호들이 서로 중복된 번호는 없는지 검증한다.")
	void 로또_번호가_중복된_번호가_들어온_것은_없는지_확인한다() {
		List<Integer> falseTestList = new ArrayList<>(List.of(1,1,1,1,1,1));
		assertAll(
			() -> assertThat(LottoUtil.isNumbersUnique(falseTestList)).isFalse()
		);
	}
}