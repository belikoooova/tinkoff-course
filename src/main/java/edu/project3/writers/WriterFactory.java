package edu.project3.writers;

import edu.project3.LogReport;
import edu.project3.UserInputRecord;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WriterFactory {
    public static Writer getWriter(UserInputRecord request, LogReport logReport) {
        switch (request.format()) {
            case ADOC -> {
                return new ADOCWriter(logReport);
            }
            case MARKDOWN -> {
                return new MDWriter(logReport);
            }
            default -> {
                return new TXTWriter(logReport);
            }
        }
    }
}
