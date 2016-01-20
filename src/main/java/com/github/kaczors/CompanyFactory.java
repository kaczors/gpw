package com.github.kaczors;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.github.kaczors.Company.Builder.company;

public class CompanyFactory {
    static DateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    public static Company createCompany(List<String> params) {
        return company()
                .no(Integer.valueOf(params.get(0)))
                .code(params.get(1))
                .segment(params.get(2))
                .sector(params.get(3))
                .name(params.get(4))
                .emittedStocksNumber(Long.valueOf(params.get(5).replaceAll("\\D", "")))
                .marketValue(parseToNumber(params.get(6)))
                .bookValue(parseToNumber(params.get(7)))
                .financialReportDate(parseDate(params.get(8)))
                .type(params.get(9))
                .c_wk(parseToNumber(params.get(10)))
                .c_z(getC_Z(params.get(11)))
                .dividendRate(getDividendRate(params.get(12)))
                .build();
    }

    static BigDecimal getDividendRate(String value) {
        if ("---".equals(value)) {
            return BigDecimal.ZERO;
        } else {
            return parseToNumber(value);
        }
    }

    static BigDecimal getC_Z(String value) {
        if ("x".equals(value)) {
            return BigDecimal.ZERO;
        } else {
            return parseToNumber(value);
        }
    }

    static BigDecimal parseToNumber(String value) {
        return new BigDecimal(value.replaceAll("[^\\d|,]", "").replace(",", "."));
    }

    static Date parseDate(String value) {
        try {
            return DATE_FORMATTER.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
