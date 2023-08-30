package domains;

import java.util.Objects;

import exceptions.LottoWrongInputException;

public class Number {
	public static final int RANGE_MIN = 1;
	public static final int RANGE_MAX = 45;

	private int number;

	public Number(int number) {
		validRange(number);

		this.number = number;
	}

	private void validRange(int number) {
		if(RANGE_MIN > number || RANGE_MAX < number) {
			throw new LottoWrongInputException("Test");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Number number1 = (Number)o;
		return number == number1.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
