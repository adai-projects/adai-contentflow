package com.adaiadai.contentflow.service.sis;

import com.adaiadai.contentflow.domain.model.sis.comment.Comment;
import com.adaiadai.contentflow.domain.model.sis.comment.CommentId;
import com.adaiadai.contentflow.domain.model.sis.comment.CommentRepository;
import com.adaiadai.contentflow.domain.model.sis.identity.Commenter;
import com.adaiadai.contentflow.domain.model.sis.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author adai
 */
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment getByCommentId(CommentId commentId) {
        return commentRepository.commentOfCommentId(commentId);
    }

    public List<Comment> listAllByCommenter(Commenter commenter) {
        return (List<Comment>) commentRepository.commentsOfCommenter(commenter);
    }

    public List<Comment> listAllByProduction(Product product) {
        return (List<Comment>) commentRepository.commentsOfProduction(product);
    }

    public void add(Comment comment) {
        commentRepository.addComment(comment);
    }

    public void remove(Comment comment) {
        commentRepository.removeComment(comment);
    }
}
