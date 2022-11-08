package xm.cryptorecommendation.domain;

import java.util.List;

public class ErrorResponse {


    private final String message;
    private final List<String> details;

    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }
}