package com.adaiadai.contentflow.repository.sis;

import com.adaiadai.contentflow.domain.model.sis.identity.Marker;
import com.adaiadai.contentflow.domain.model.sis.product.Product;
import com.adaiadai.contentflow.domain.model.sis.tag.ProductTag;
import com.adaiadai.contentflow.domain.model.sis.tag.ProductTagRepository;
import com.adaiadai.contentflow.domain.model.sis.tag.TagId;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author adai
 */
@Component
public class HibernateProductTagRepository implements ProductTagRepository {

    private final ProductTagJpaRepository productTagJpaRepository;

    public HibernateProductTagRepository(ProductTagJpaRepository productTagJpaRepository) {
        this.productTagJpaRepository = productTagJpaRepository;
    }

    @Override
    public ProductTag productTagOfProductAndTagIdAndMarker(Product product, TagId tagId, Marker marker) {
        return productTagJpaRepository.findByProductAndTagIdAndMarker(product, tagId, marker);
    }

    @Override
    public Collection<ProductTag> productTagsOfProduct(Product product) {
        return productTagJpaRepository.findAllByProduct(product);
    }

    @Override
    public Collection<ProductTag> productTagsOfTagId(TagId tagId) {
        return productTagJpaRepository.findAllByTagId(tagId);
    }

    @Override
    public void add(ProductTag productTag) {
        productTagJpaRepository.save(productTag);
    }

    @Override
    public void addAll(Collection<ProductTag> productTags) {
        productTagJpaRepository.saveAll(productTags);
    }

    @Override
    public void remove(ProductTag productTag) {
        productTagJpaRepository.delete(productTag);
    }

    @Override
    public void removeAll(Collection<ProductTag> productTags) {
        productTagJpaRepository.deleteAll(productTags);
    }

}
