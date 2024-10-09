package com.adaiadai.contentflow.repository.sis;

import com.adaiadai.contentflow.domain.model.sis.product.Product;
import com.adaiadai.contentflow.domain.model.sis.identity.Marker;
import com.adaiadai.contentflow.domain.model.sis.tag.ProductTag;
import com.adaiadai.contentflow.domain.model.sis.tag.TagId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author adai
 */
@Repository
public interface ProductTagJpaRepository extends JpaRepository<ProductTag, Long> {

    ProductTag findByProductAndTagIdAndMarker(Product product, TagId tagId, Marker marker);

    List<ProductTag> findAllByTagIdAndProduct_Type(TagId tagId, String contentType);

    List<ProductTag> findAllByTagId(TagId tagId);

    List<ProductTag> findAllByProduct(Product product);

}
