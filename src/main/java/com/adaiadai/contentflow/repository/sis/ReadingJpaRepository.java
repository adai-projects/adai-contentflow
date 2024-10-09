package com.adaiadai.contentflow.repository.sis;

import com.adaiadai.contentflow.domain.model.sis.identity.Reader;
import com.adaiadai.contentflow.domain.model.sis.product.Product;
import com.adaiadai.contentflow.domain.model.sis.reading.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author adai
 */
@Repository
public interface ReadingJpaRepository extends JpaRepository<Reading, Long> {

    List<Reading> findAllByProduct(Product product);

    Reading findByReaderAndProduct(Reader reader, Product product);
}
