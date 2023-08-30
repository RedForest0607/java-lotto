package domains;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	@DisplayName("로또의 번호가 당첨번호와 일치하는지 확인한다")
	void 로또의_번호가_당첨번호와_일치하는지의_여부의_결과값을_반환한다() {

		List<Integer> lottoNums = List.of(1, 2, 3, 4, 5, 6);
		List<Integer> compareNums = List.of(1, 2, 3, 15, 20, 30);

		Lotto lotto = new Lotto(lottoNums);

		Assertions.assertThat(lotto.isWinning(lottoNums)).isTrue();
	}
}
