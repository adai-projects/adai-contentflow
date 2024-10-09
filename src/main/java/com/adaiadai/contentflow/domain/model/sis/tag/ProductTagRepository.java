package com.adaiadai.contentflow.domain.model.sis.tag;

import com.adaiadai.contentflow.domain.model.sis.identity.Marker;
import com.adaiadai.contentflow.domain.model.sis.product.Product;

import java.util.Collection;

/**
 * @author adai
 */
public interface ProductTagRepository {

    ProductTag productTagOfProductAndTagIdAndMarker(Product product, TagId tagId, Marker marker);

    Collection<ProductTag> productTagsOfProduct(Product product);

    Collection<ProductTag> productTagsOfTagId(TagId tagId);

    void add(ProductTag productTag);

    void addAll(Collection<ProductTag> productTags);

    void remove(ProductTag productTag);

    void removeAll(Collection<ProductTag> productTags);

}
