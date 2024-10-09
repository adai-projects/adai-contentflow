package com.adaiadai.contentflow.domain.model.pmc.axis;

import com.adaiadai.contentflow.domain.model.pmc.product.Product;
import com.adaiadai.contentflow.domain.model.pmc.project.ProjectId;
import com.adaiadai.contentflow.domain.model.pmc.project.section.SectionId;
import com.adaiadai.contentflow.domain.model.pmc.project.version.VersionId;
import com.adaiadai.contentflow.domain.model.pmc.project.subject.SubjectId;

import java.util.Collection;

/**
 * @author adai
 */
public interface AxisRepository {

    Axis axisOfProductAndProjectId(Product product, ProjectId projectId);

    Collection<Axis> axesOfProduct(Product product);

    Collection<Axis> axesOfVersionIdAndSubjectIdAndSectionId(VersionId versionId, SubjectId subjectId, SectionId sectionId);

    Collection<Axis> axesOfProjectId(ProjectId projectId);

    Collection<Axis> axesOfVersionId(VersionId versionId);

    Collection<Axis> axesOfSubjectId(SubjectId subjectId);

    Collection<Axis> axesOfSectionId(SectionId sectionId);

    void add(Axis axis);

    void addAll(Collection<Axis> axes);

    void remove(Axis axis);

    void removeAll(Collection<Axis> axes);

}
