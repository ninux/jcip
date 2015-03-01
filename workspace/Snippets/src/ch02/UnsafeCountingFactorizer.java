package ch02;

// not thread safe
public class UnsafeCountingFactorizer implements Servlet {
	private long count = 0;
	
	public long getCount() {
		return count;
	}
	
	public void service(ServletRequest req, SerletResponse resp) {
		BigInterger i = extractFromRequest(req);
		BigInterger[] factors = factor(i);
		++count;
		encodeIntoResponse(resp, factors);
	}
}