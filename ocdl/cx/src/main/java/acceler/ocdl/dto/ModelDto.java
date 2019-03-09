package acceler.ocdl.dto;

import acceler.ocdl.model.Model;

import java.io.Serializable;

public class ModelDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long modelId;
    private String modelName;
    private String modelType;
    private String project;
    private String url;
    private String status;
    private int isbigVersion;

    public Long getModelId() { return modelId; }

    public void setModelId(Long modelId) { this.modelId = modelId; }

    public String getModelName() { return modelName; }

    public void setModelName(String modelName) { this.modelName = modelName; }

    public String getModelType() { return modelType; }

    public void setModelType(String modelType) { this.modelType = modelType; }

    public String getProject() { return project; }

    public void setProject(String project) { this.project = project; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public int getIsbigVersion() { return isbigVersion; }

    public void setIsbigVersion(int isbigVersion) { this.isbigVersion = isbigVersion; }

    public Model convert2Model() {

        Model model = new Model();

        model.setModelId(this.modelId);
        model.setModelName(this.getModelName());
        model.setModelType(this.getModelType());
        model.setUrl(this.url);
        model.setStatus(Model.Status.getStatus(this.status));
        model.setProject(this.getProject());

        return model;
    }
}
