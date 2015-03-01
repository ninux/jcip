package ch02;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

// not thread safe
public class UnsafeCachingFactorizerBigIntegers Servlet {
	private final AtomicReference<BigInteger> lastNumber
		= new AtomicReference<BigInteger>();
	private final AtomicReference<BigInteger[]> lastFactors
		= new AtomicReference<BigInteger[]>();
		
	public void service(ServletRequest req, ServletResponse resp) {
		BigInterger i = extractFromRequest(req);
		if (i.equals(lastNumber.get())) {
			encodeIntoResponse(resp, lastFactors.get());
		} else {
			BigInteger[] factors = factor(i);
			lastNumber.set(i);
			lastFactors.set(factors);
			encodeIntoResponse(resp, factors);
		}
	}
}