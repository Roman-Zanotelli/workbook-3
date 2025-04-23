package com.pluralsight;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        Date date = new Date(record.getMillis());
        DateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return String.format("%s %s\n", simple.format(date), record.getMessage());
    }
}
