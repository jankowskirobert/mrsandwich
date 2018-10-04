package com.jvmless.mrsandwich.client;

import com.jvmless.mrsandwich.client.exceptions.CorrelationDeactivateException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
class Correlation {
    private String correlationId;
    private CorrelationStatus correlationStatus;
    private LocalDateTime correlationStart;
    private LocalDateTime correlationEnd;

    public static Correlation of(String correlationId) {
        return new Correlation(correlationId, CorrelationStatus.ACTIVE, LocalDateTime.now(), null);
    }

    public void active() {
        if(this.correlationStart != null) {
            throw new CorrelationDeactivateException("Correlation already started");
        }
        this.correlationEnd = null;
        this.correlationStatus = CorrelationStatus.ACTIVE;
        this.correlationStart = LocalDateTime.now();
    }

    public void deactivate() {
        if(this.correlationStart == null) {
            throw new CorrelationDeactivateException("Correlation never started");
        }
        this.correlationEnd = LocalDateTime.now();
        this.correlationStatus = CorrelationStatus.DEACTIVATED;
    }
}
