package com.adaiadai.contentflow.repository.sis;

import com.adaiadai.contentflow.domain.model.sis.comment.Comment;
import com.adaiadai.contentflow.domain.model.sis.comment.CommentId;
import com.adaiadai.contentflow.domain.model.sis.comment.CommentRepository;
import com.adaiadai.contentflow.domain.model.sis.identity.Commenter;
import com.adaiadai.contentflow.domain.model.sis.product.Product;
import com.adaiadai.contentflow.util.UUIDUtil;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author adai
 */
@Component
public class HibernateCommentRepository implements CommentRepository {

    private final static String COMMENT_ID_PREFIX = "sis-comment-";

    private final CommentJpaRepository commentJpaRepository;

    public HibernateCommentRepository(CommentJpaRepository commentJpaRepository) {
        this.commentJpaRepository = commentJpaRepository;
    }

    @Override
    public CommentId nextIdentity() {
        return new CommentId(COMMENT_ID_PREFIX + UUIDUtil.getUuidPartOne());
    }

    @Override
    public Comment commentOfCommentId(CommentId commentId) {
        return commentJpaRepository.findByCommentId(commentId);
    }

    @Override
    public Collection<Comment> commentsOfCommenter(Commenter commenter) {
        return commentJpaRepository.findAllByCommenter(commenter);
    }

    @Override
    public Collection<Comment> commentsOfProduction(Product product) {
        return commentJpaRepository.findAllByProduct(product);
    }

    @Override
    public void addComment(Comment comment) {
        commentJpaRepository.save(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        commentJpaRepository.delete(comment);
    }
}
