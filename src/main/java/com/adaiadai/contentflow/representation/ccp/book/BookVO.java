package com.adaiadai.contentflow.representation.ccp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.adaiadai.contentflow.domain.model.ccp.product.blog.Blog;
import com.adaiadai.contentflow.domain.model.sis.tag.Tag;
import com.adaiadai.contentflow.domain.model.pmc.project.Project;
import com.adaiadai.contentflow.domain.model.iaa.User;

import java.io.Serializable;
import java.util.List;

/**
 * BookVO: 图书[VO]
 *
 * @author adai
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Project project;
    private Blog blog;
    private List<Tag> tagList;
    private List<User> userList;
}
