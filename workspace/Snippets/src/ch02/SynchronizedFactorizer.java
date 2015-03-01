package ch02;

import java.math.BigInteger;

// thread safe but very poor concurrency
public class SynchronizedFactorizer implements Servlet {
	private BigInteger lastNumber;
	private BigInteger[] lastFactors;
	
	public synchronized void service(ServletRequest req, ServletResponse resp) {
		BigInteger i = extractFromRequest(req);
		if (i.equals(lastNumber)) {
			encodeIntoResponse(resp, lastFactors);
		} else {
			BigInteger[] factors = factor(i);
			lastNumber = i;
			lastFactors = factors;
			encodeIntoResponse(resp, factors);
		}
	}
}