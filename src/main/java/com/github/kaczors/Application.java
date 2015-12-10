package com.github.kaczors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static java.util.stream.Collectors.toList;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner loadCompanies(CompanyRepository repository) {
        return (args) -> {
            repository.deleteAll();

            Document doc = Jsoup.connect("http://www.gpw.pl/wskazniki_spolek_full").get();
            List<Company> companies = doc.select("tr")
                    .stream()
                    .map(companyTableRow -> companyTableRow.select("td"))
                    .filter(companyTableColumns -> companyTableColumns.size() == 13)
                    .map(this::createCompany)
                    .collect(toList());

            repository.save(companies);
        };
    }

    private Company createCompany(Elements companyTableColumns) {
        return CompanyFactory.createCompany(
                companyTableColumns
                        .stream()
                        .map(Element::text)
                        .collect(toList()));
    }

}
