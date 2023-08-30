package domains;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShopTest {

	@Test
	@DisplayName("입력한 가격에 맞춰서 로또를 갯수대로 생성")
	void 입력한_가격에_맞춰서_로또를_갯수대로_생성() {
		List<Lotto> lottos = LottoShop.buyLotto(5_000);

		assertThat(lottos.size()).isEqualTo(5);
	}
}
