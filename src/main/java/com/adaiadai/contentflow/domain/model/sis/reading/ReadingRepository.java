package com.adaiadai.contentflow.domain.model.sis.reading;

import com.adaiadai.contentflow.domain.model.sis.identity.Reader;
import com.adaiadai.contentflow.domain.model.sis.product.Product;

import java.util.Collection;

/**
 * @author adai
 */
public interface ReadingRepository {

    Reading readingOfReaderAndProduct(Reader reader, Product product);

    Collection<Reading> readingOfProduct(Product product);

    void add(Reading reading);
}
