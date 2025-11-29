package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.handler.response;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;

import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class ErrorResponse {

    @Setter(AccessLevel.NONE)
    private final HttpStatusCode httpStatus;
    @Setter(AccessLevel.NONE)
    private final String title;
    @Setter(AccessLevel.NONE)
    private final ProblemDetail detail;

    public ErrorResponse(final HttpServletRequest request,
                         final Throwable throwable,
                         final HttpStatusCode httpStatus,
                         final String title) {
        this.httpStatus = httpStatus;
        this.title = title;
        this.detail = getBody(request, throwable, httpStatus, title);
    }

    private ProblemDetail getBody(HttpServletRequest request,
                                  Throwable throwable,
                                  HttpStatusCode statusCode,
                                  String title) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(statusCode);
        problemDetail.setTitle(title);
        problemDetail.setDetail(throwable.getMessage());
        problemDetail.setType(URI.create(request.getRequestURI()));
        problemDetail.setInstance(URI.create(request.getRequestURI()));
        problemDetail.setProperties(properties());
        return problemDetail;
    }

    private Map<String, Object> properties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("timestamp", Instant.now());
        return properties;
    }
}
