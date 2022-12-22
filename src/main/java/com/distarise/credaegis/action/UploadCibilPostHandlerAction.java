package com.distarise.credaegis.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.FileUploadDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.FileStorageService;
import com.distarise.credaegis.model.PersonDto;
import com.distarise.credaegis.service.CreditAnalysisCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

@Service
public class UploadCibilPostHandlerAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    CreditAnalysisCommonService creditAnalysisCommonService;

    @Autowired
    LoadLeadsAction loadLeadsAction;
    @Override
    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        WidgetDto widgetDto = super.executeAction(new WidgetDto());
        Optional<ComponentDto> reportType = ComponentDto.filterComponentDtoById(widgetDto.getComponentDtos(), "reporttype");
        PersonDto personDto = new PersonDto();
        personDto.setReportType(reportType.get().getValue());
        if (!targetPageDetailsDto.getFileUploads().isEmpty()){
            FileUploadDto file = targetPageDetailsDto.getFileUploads().get(0);
            Resource resource = fileStorageService.loadFileAsResource(file.getFileName());
            personDto.setFileName(file.getFileName());
            try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));) {
                StringBuffer pdf = new StringBuffer();
                String line = "";
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                    pdf.append(line);
                }
                creditAnalysisCommonService.processCreditReport(request, personDto, pdf.toString());
                loadLeadsAction.executeAction(request);
                loadLeadsAction.executeAction();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }  catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
