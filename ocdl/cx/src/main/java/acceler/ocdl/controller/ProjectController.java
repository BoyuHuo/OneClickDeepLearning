package acceler.ocdl.controller;

import acceler.ocdl.dto.ProjectConfigurationDto;
import acceler.ocdl.dto.Response;
import acceler.ocdl.model.Algorithm;
import acceler.ocdl.model.Project;
import acceler.ocdl.service.AlgorithmService;
import acceler.ocdl.service.ProjectService;
import io.netty.util.internal.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static acceler.ocdl.dto.Response.getBuilder;

@Controller
@RequestMapping(path = "/rest/project")
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectService projectService;
    @Autowired
    private AlgorithmService algorithmService;

    @ResponseBody
    @RequestMapping(path = "/algorithm", method = RequestMethod.GET)
    public final Response getAlgorithm() {

        Response.Builder responseBuilder = getBuilder();

        List<String> algorithmNames = new ArrayList<>();
        algorithmService.getAllAlgorithm().forEach(algorithm -> {
            algorithmNames.add(algorithm.getAlgorithmName());
        });
        responseBuilder.setCode(Response.Code.SUCCESS)
                .setData(algorithmNames);

        return responseBuilder.build();
    }


    @ResponseBody
    @RequestMapping(path = "/latest/{algorithm}", method = RequestMethod.GET)
    public final Response getLatestModelName(@PathVariable String algorithm) {

        Response.Builder responseBuilder = getBuilder();

        String latestModelName = algorithmService.getLatestModelName(algorithm);

        responseBuilder.setCode(Response.Code.SUCCESS)
                .setData(latestModelName);
        return responseBuilder.build();
    }


    @ResponseBody
    @RequestMapping(path = "/config", method = RequestMethod.GET)
    public final Response getProjectConfig() {

        Response.Builder responseBuilder = Response.getBuilder();

        Project project = projectService.getProjectConfiguration();
        List<Algorithm> algorithms = algorithmService.getAllAlgorithm();

        ProjectConfigurationDto projectDto = project.convert2ProjectDto(algorithms);

        responseBuilder.setCode(Response.Code.SUCCESS)
                .setData(projectDto);

        return responseBuilder.build();
    }


    @RequestMapping(path = "/config", method = RequestMethod.PUT)
    @ResponseBody
    public Response updateProject(@RequestBody ProjectConfigurationDto updatedProjectConfig) {

        Response.Builder responseBuilder = Response.getBuilder();
        projectService.updateProjectConfiguration(updatedProjectConfig.convert2Project());
        algorithmService.updateAlgorithmList(updatedProjectConfig.getAlgorithmStrList(), updatedProjectConfig.getForceRemoved());

        return responseBuilder.setCode(Response.Code.SUCCESS).build();
    }


    @RequestMapping(path = "/config/name", method = RequestMethod.PUT)
    @ResponseBody
    public Response updateProjectNames(@RequestBody Map<String, String> projectName) {

        Response.Builder responseBuilder = Response.getBuilder();
        String name = projectName.get("name");

        if (!StringUtil.isNullOrEmpty(name)) {
            Project project = new Project();
            project.setProjectName(projectName.get("name"));
            projectService.updateProjectConfiguration(project);
            responseBuilder.setCode(Response.Code.SUCCESS)
                    .setData(projectName);
        } else {
            responseBuilder.setCode(Response.Code.ERROR).setMessage("ProjectName can not be empty");
        }
        return responseBuilder.build();
    }

}
