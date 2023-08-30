package domains;

import java.util.ArrayList;
import java.util.List;

import utils.LottoUtil;

public class LottoShop {
	public static final int LOTTO_PRICE = 1_000;

	public static List<Lotto> buyLotto(int price) {
		int count = price / LOTTO_PRICE;
		List<Lotto> lottos = new ArrayList<>();

		for(int i = 0; i < count; i += 1) {
			lottos.add(new Lotto(LottoUtil.getRandInts()));
		}

		return lottos;
	}
}
