package com.adaiadai.contentflow.domain.model.sis.reading;

import com.adaiadai.contentflow.domain.model.AbstractValueObject;
import com.adaiadai.contentflow.domain.model.sis.product.Product;

/**
 * @author adai
 */
public class ReadingQuality extends AbstractValueObject {

    private Product product;
    private Integer counterSum;
    private String likePercent;

    public ReadingQuality(Product product, Integer counterSum, String likePercent) {
        this.setProduct(product);
        this.setCounterSum(counterSum);
        this.setLikePercent(likePercent);
    }

    public Product product() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer counterSum() {
        return this.counterSum;
    }

    public void setCounterSum(Integer counterSum) {
        this.counterSum = counterSum;
    }

    public String likePercent() {
        return this.likePercent;
    }

    public void setLikePercent(String likePercent) {
        this.likePercent = likePercent;
    }
}
