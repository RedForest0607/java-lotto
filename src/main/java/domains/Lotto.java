package domains;

import java.util.List;

import utils.LottoUtil;

public class Lotto {

	public List<Integer> lottoNumbers;

	private Numbers numbers;

	public Lotto(List<Integer> lottoNumbers) {
		this.numbers = new Numbers(lottoNumbers);
	}

	public WinningPrize getWinningPrize(Lotto comparison) {
		return WinningPrize.matchPrizeResult(this.numbers.match(comparison.numbers));
	}
}
