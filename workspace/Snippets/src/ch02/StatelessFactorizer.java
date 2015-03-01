package ch02;

// thread safe
public class StatelessFactorizer implements Servlet {
	public void service(ServletRequest req, ServletRespnse resp) {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);
		encodeIntoResponse(resp, factors);
	}
}