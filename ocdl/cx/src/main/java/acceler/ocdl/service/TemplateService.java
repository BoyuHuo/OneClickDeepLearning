package acceler.ocdl.service;

import acceler.ocdl.entity.Project;
import acceler.ocdl.entity.Template;
import acceler.ocdl.entity.TemplateCategory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface TemplateService {

//    Map<String,List<String>> getTemplatesList();
//
//    List<String> getCode(String name,String type);

    @Transactional
    Template uploadTemplate();

    Page<Template> getTemplate(Template template, int page, int size);

    boolean batchDeleteTemplate(List<Template> templates);

    TemplateCategory saveCategory(TemplateCategory category);

    boolean deleteCategory(TemplateCategory category);

    TemplateCategory getProjectCategory(Project project);

    List<String> downloadTemplate(String refId);

}
