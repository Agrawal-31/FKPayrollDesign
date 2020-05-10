package payRoll;

import java.time.LocalDate;

public class Constants{
	public static enum SalType {
		DAILY,
		MONTHLY
	}

	public static interface Dates{
		LocalDate beginningDate = LocalDate.of(2010, 5, 10);

	}
}

