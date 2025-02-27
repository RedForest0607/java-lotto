package dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import domains.Number;

public class LottoNumber {
	private List<Integer> numbers;

	public LottoNumber(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public static LottoNumber convertTo(Set<Number> numbers) {
		return new LottoNumber(numbers.stream()
						.map(Number::getNumber)
						.collect(Collectors.toList()));
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
