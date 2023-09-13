package controller;

import java.util.List;
import java.util.stream.Collectors;

import domains.Lotto;
import domains.LottoShop;
import domains.Lottos;
import domains.PrizeReport;
import view.InputView;
import view.OutputView;

public class LottoController {
	public void start() {
		int cost = InputView.inputMoney();

		Lottos lottoTickets = LottoShop.buyLotto(cost);
		List<String> winningNumbers = InputView.inputWinningNumbers();

		Lotto winningLotto = new Lotto(winningNumbers.stream().map(Integer::parseInt).collect(Collectors.toList()));
		PrizeReport prizeReport = new PrizeReport(lottoTickets.getResult(winningLotto));

		OutputView.printPrizeResult(prizeReport.getReport());
		OutputView.printRate(prizeReport.getBenefit(cost));
	}
}
