package com.adaiadai.contentflow.repository.sis;

import com.adaiadai.contentflow.domain.model.sis.comment.Comment;
import com.adaiadai.contentflow.domain.model.sis.comment.CommentId;
import com.adaiadai.contentflow.domain.model.sis.identity.Commenter;
import com.adaiadai.contentflow.domain.model.sis.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author adai
 */
@Repository
public interface CommentJpaRepository extends JpaRepository<Comment, Long> {

    Comment findByCommentId(CommentId commentId);

    List<Comment> findAllByCommenter(Commenter commenter);

    List<Comment> findAllByProduct(Product product);

}
