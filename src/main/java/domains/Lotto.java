package domains;

import java.util.List;

import utils.LottoUtil;

public class Lotto {

	public List<Integer> lottoNumbers;

	private Numbers numbers;

	public Lotto(List<Integer> lottoNumbers) {
		this.numbers = new Numbers(lottoNumbers);
	}

	//몇개인지
	public boolean isWinning(List<Integer> winningNumbers) {
		return false;
	}
}
