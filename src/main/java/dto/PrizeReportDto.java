package dto;

import java.util.Objects;

public class PrizeReportDto implements Comparable<PrizeReportDto> {
	int matchCount;
	int money;
	long result;

	public int getMatchCount() {
		return matchCount;
	}

	public int getMoney() {
		return money;
	}

	public long getResult() {
		return result;
	}

	public PrizeReportDto(int matchCount, int money, long result) {
		this.matchCount = matchCount;
		this.money = money;
		this.result = result;
	}

	@Override
	public int compareTo(PrizeReportDto o) {
		return Integer.compare(matchCount, o.matchCount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PrizeReportDto that = (PrizeReportDto)o;
		return matchCount == that.matchCount && money == that.money && result == that.result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matchCount, money, result);
	}
}
