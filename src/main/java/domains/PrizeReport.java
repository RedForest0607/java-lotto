package domains;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dto.PrizeReportDto;

public class PrizeReport {

	private final static long ZERO = 0L;
	private Map<WinningPrize, Long> winningPrizeMap;

	//비용계산

	public PrizeReport(List<WinningPrize> winningPrizeList) {
		winningPrizeMap = winningPrizeList.stream().collect(Collectors.groupingBy(WinningPrize::getWinningPrize, Collectors.counting()));
	}


	//수익률 계산
	// 전체상금 / 비용 * 100
	public double getBenefit (int cost) {

		long wholePrize = winningPrizeMap.entrySet().stream().mapToLong(pair -> pair.getKey().getPrize() * pair.getValue()).sum();
		return Math.floor(wholePrize / (double)cost * 100) / 100;
	}

	public List<PrizeReportDto> getReport() {

		return List.of(
			new PrizeReportDto(WinningPrize.FIRST.getPrize(), WinningPrize.FIRST.getWinningCount(),winningPrizeMap.getOrDefault(WinningPrize.FIRST, ZERO)),
			new PrizeReportDto(WinningPrize.SECOND.getPrize(), WinningPrize.SECOND.getWinningCount(),winningPrizeMap.getOrDefault(WinningPrize.SECOND, ZERO)),
			new PrizeReportDto(WinningPrize.THIRD.getPrize(), WinningPrize.THIRD.getWinningCount(),winningPrizeMap.getOrDefault(WinningPrize.THIRD, ZERO)),
			new PrizeReportDto(WinningPrize.FOURTH.getPrize(), WinningPrize.FOURTH.getWinningCount(),winningPrizeMap.getOrDefault(WinningPrize.FOURTH, ZERO))
		);
	}
}
