package br.com.fatec.modulo2_1.logging;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.UUID;

@Component
public class CorrelationIdFilter implements Filter {

    public static final String TRACE_ID = "traceId";
    public static final String HEADER = "X-Correlation-Id";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {
            String correlationId = null;

            if (request instanceof HttpServletRequest req) {
                correlationId = req.getHeader(HEADER);
            }

            if (!StringUtils.hasText(correlationId)) {
                correlationId = UUID.randomUUID().toString();
            }

            MDC.put(TRACE_ID, correlationId);
            chain.doFilter(request, response);

        } finally {
            MDC.remove(TRACE_ID);
        }
    }
}
