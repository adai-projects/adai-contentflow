package com.adaiadai.contentflow.repository.sis;

import com.adaiadai.contentflow.domain.model.sis.identity.Reader;
import com.adaiadai.contentflow.domain.model.sis.product.Product;
import com.adaiadai.contentflow.domain.model.sis.reading.Reading;
import com.adaiadai.contentflow.domain.model.sis.reading.ReadingRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author adai
 */
@Component
public class HibernateReadingRepository implements ReadingRepository {

    private final ReadingJpaRepository readingJpaRepository;

    public HibernateReadingRepository(ReadingJpaRepository readingJpaRepository) {
        this.readingJpaRepository = readingJpaRepository;
    }

    @Override
    public Reading readingOfReaderAndProduct(Reader reader, Product product) {
        return readingJpaRepository.findByReaderAndProduct(reader, product);
    }

    @Override
    public Collection<Reading> readingOfProduct(Product product) {
        return readingJpaRepository.findAllByProduct(product);
    }

    @Override
    public void add(Reading reading) {
        readingJpaRepository.save(reading);
    }
}
