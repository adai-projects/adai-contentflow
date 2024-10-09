package com.adaiadai.contentflow.service.sis;

import com.adaiadai.contentflow.domain.model.sis.identity.Reader;
import com.adaiadai.contentflow.domain.model.sis.product.Product;
import com.adaiadai.contentflow.domain.model.sis.reading.Reading;
import com.adaiadai.contentflow.domain.model.sis.reading.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author adai
 */
@Service
public class ReadingService {

    @Autowired
    private ReadingRepository readingRepository;

    public Reading getByReaderAndProduct(Reader reader, Product product) {
        return readingRepository.readingOfReaderAndProduct(reader, product);
    }

    public List<Reading> listByProduct(Product product) {
        return (List<Reading>) readingRepository.readingOfProduct(product);
    }

    public void add(Reading reading) {
        readingRepository.add(reading);
    }

    public void update(Reading reading) {
        readingRepository.add(reading);
    }
}
