package com.adaiadai.contentflow.domain.model.sis.comment;

import com.adaiadai.contentflow.domain.model.sis.identity.Commenter;
import com.adaiadai.contentflow.domain.model.sis.product.Product;

import java.util.Collection;

/**
 * @author adai
 */
public interface CommentRepository {

    CommentId nextIdentity();

    Comment commentOfCommentId(CommentId commentId);

    Collection<Comment> commentsOfCommenter(Commenter commenter);

    Collection<Comment> commentsOfProduction(Product product);

    void addComment(Comment comment);

    void removeComment(Comment comment);
}
