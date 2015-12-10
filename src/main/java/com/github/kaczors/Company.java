package com.github.kaczors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Integer no;

    private String code;

    private String segment;

    private String sector;

    private String name;

    private long emittedStocksNumber;

    private BigDecimal marketValue;

    private BigDecimal bookValue;

    private Date financialReportDate;

    private String type;

    private BigDecimal c_wk;

    private BigDecimal c_z;

    private BigDecimal dividendRate;

    public static class Builder {
        private Integer no;
        private String code;
        private String segment;
        private String sector;
        private String name;
        private long emittedStocksNumber;
        private BigDecimal marketValue;
        private BigDecimal bookValue;
        private Date financialReportDate;
        private String type;
        private BigDecimal c_wk;
        private BigDecimal c_z;
        private BigDecimal dividendRate;

        private Builder() {
        }

        public static Builder company() {
            return new Builder();
        }

        public Builder no(Integer no) {
            this.no = no;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder segment(String segment) {
            this.segment = segment;
            return this;
        }

        public Builder sector(String sector) {
            this.sector = sector;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder emittedStocksNumber(long emittedStocksNumber) {
            this.emittedStocksNumber = emittedStocksNumber;
            return this;
        }

        public Builder marketValue(BigDecimal marketValue) {
            this.marketValue = marketValue;
            return this;
        }

        public Builder bookValue(BigDecimal bookValue) {
            this.bookValue = bookValue;
            return this;
        }

        public Builder financialReportDate(Date financialReportDate) {
            this.financialReportDate = financialReportDate;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder c_wk(BigDecimal c_wk) {
            this.c_wk = c_wk;
            return this;
        }

        public Builder c_z(BigDecimal c_z) {
            this.c_z = c_z;
            return this;
        }

        public Builder dividendRate(BigDecimal dividendRate) {
            this.dividendRate = dividendRate;
            return this;
        }

        public Company build() {
            Company company = new Company();
            company.no = no;
            company.code = code;
            company.segment = segment;
            company.sector = sector;
            company.name = name;
            company.emittedStocksNumber = emittedStocksNumber;
            company.marketValue = marketValue;
            company.bookValue = bookValue;
            company.financialReportDate = financialReportDate;
            company.type = type;
            company.c_wk = c_wk;
            company.c_z = c_z;
            company.dividendRate = dividendRate;
            return company;
        }
    }
}

