package com.adaiadai.contentflow.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import com.adaiadai.contentflow.application.ccp.BlogApplicationService;
import com.adaiadai.contentflow.domain.model.ccp.product.ProductType;
import com.adaiadai.contentflow.domain.model.ccp.product.blog.Blog;
import com.adaiadai.contentflow.domain.model.iaa.User;
import com.adaiadai.contentflow.domain.model.sis.identity.Reader;
import com.adaiadai.contentflow.domain.model.sis.product.Product;
import com.adaiadai.contentflow.domain.model.sis.reading.Reading;
import com.adaiadai.contentflow.service.iaa.UserService;
import com.adaiadai.contentflow.service.sis.ReadingService;
import com.adaiadai.contentflow.util.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * ReaderAspect: 阅读切面
 *
 * @author adai
 * @date 2019-10-17
 */
@Component
@Aspect
public class ReaderAspect {
    private final static Logger logger = LoggerFactory.getLogger(ReaderAspect.class);

    @Autowired
    private BlogApplicationService blogApplicationService;
    private final HttpServletRequest request;
    private final ReadingService readingService;
    private final UserService userService;

    public ReaderAspect(HttpServletRequest request, ReadingService readingService, UserService userService) {
        this.request = request;
        this.readingService = readingService;
        this.userService = userService;
    }

    @Pointcut("execution(public * com.adaiadai.contentflow.controller.ccp.BlogController.getDetail(..))")
    public void getDetail() {
    }

    @Around("getDetail()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("阅读切面Start=======================================");
        // uri: /blog/{id\\d++}
        String uri = request.getRequestURI();
        String blogId = uri.split("/")[2];
        Blog blog = blogApplicationService.getByBlogId(blogId);
        User principal = SecurityUtil.getPrincipal();
        Reading reading;
        if (principal != null) {
            // 如果当前读者不是该博客的博主
            if (!blog.blogger().identify().equals(principal.username())) {
                // 判断读者是否已经阅读
                reading = readingService.getByReaderAndProduct(new Reader(userService.identity())
                        , new Product(blogId, ProductType.PRODUCT_BLOG.toString().toUpperCase()));
                if (reading != null) {
                    Integer counter = reading.counter();
                    counter += 1;
                    reading.setCounter(counter);
                } else {
                    reading = new Reading(new Product(blogId, ProductType.PRODUCT_BLOG.toString().toUpperCase()), new Reader(userService.identity()));
                }
                readingService.update(reading);
            }
        } else {
            reading = readingService.getByReaderAndProduct(null, new Product(blogId, ProductType.PRODUCT_BLOG.toString().toUpperCase()));
            if (reading == null) {
                reading = new Reading(new Product(blogId, ProductType.PRODUCT_BLOG.toString().toUpperCase()), null);
            }
            Integer counter = reading.counter();
            counter += 1;
            reading.setCounter(counter);
            readingService.update(reading);
        }
        logger.info("阅读切面End=======================================");
        return pjp.proceed();
    }
}
