package domains;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exceptions.LottoWrongInputException;

public class NumbersTest {

	@Test
	@DisplayName("로또 번호들이 서로 중복된 번호는 없는지 검증한다.")
	void 로또_번호가_중복된_번호가_들어온_것은_없는지_확인한다() {
		List<Integer> falseTestList = new ArrayList<>(List.of(1,1,1,1,1,1));

		assertThatThrownBy(() -> new Numbers(falseTestList))
			.isInstanceOf(LottoWrongInputException.class);
	}

	@Test
	@DisplayName("로또의 번호가 당첨번호와 일치하는지 확인한다")
	void 로또의_번호가_당첨번호와_일치하는지의_여부의_결과값을_반환한다() {

		List<Integer> lottoNums = List.of(1, 2, 3, 4, 5, 6);
		List<Integer> compareNums = List.of(1, 2, 3, 15, 20, 30);

		Numbers numbers = new Numbers(lottoNums);
		Numbers compareNumbers = new Numbers(compareNums);

		assertThat(numbers.match(compareNumbers)).isEqualTo(3);
	}
}
