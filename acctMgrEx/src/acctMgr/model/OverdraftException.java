package acctMgr.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OverdraftException extends Exception {

	OverdraftException(BigDecimal amountOver){
		super("Overdrafted account by: " + amountOver);
	}

}
