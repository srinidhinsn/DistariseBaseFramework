package com.distarise.credaegis.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.service.UserService;
import com.distarise.credaegis.constants.CibilConstants;
import com.distarise.credaegis.dao.PersonDao;
import com.distarise.credaegis.dao.WorkDao;
import com.distarise.credaegis.enumerations.WorkStatus;
import com.distarise.credaegis.model.CorefactorRequest;
import com.distarise.credaegis.model.CorefactorResponse;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.model.PersonDto;
import com.distarise.credaegis.model.WorkDto;
import com.google.gson.Gson;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SendAgreementAction extends AbstractBaseAction implements BaseAction {

    private static final Logger logger = LoggerFactory.getLogger(SendAgreementAction.class);
    @Autowired
    private PersonDao personDao;

    @Autowired
    private WorkDao workDao;
    @Autowired
    private LoadLeadsAction loadLeadsAction;

    @Autowired
    private LoadAnalysisReportAction loadAnalysisReportAction;

    @Override
    public void executeAction(){
        PersonDto personDto = personDao.findByPid(loadAnalysisReportAction.getPidFromRequest(request));
        UserDetailsDto user = (UserDetailsDto) request.getSession().getAttribute(UserService.USER);
        CorefactorRequest corefactorRequest = new CorefactorRequest(personDto.getContact(),
                personDto.getFirstName(), personDto.getIdentityList().get(0).getId(), personDto.getEmail(),
                personDto.getCreditScore().toString(), user.getUserId());
        String url = "https://teleduce.corefactors.in/lead/apiwebhook/2093217d-05b7-4460-8140-2dd4dd27313e/testposting/";
        Gson gson = new Gson();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(corefactorRequest)))
                    .build();

            HttpResponse<String> response = client.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
            CorefactorResponse corefactorResponse = gson.fromJson(response.body(), CorefactorResponse.class);
            System.out.println(response.body());

            personDto.setCorefactorId(corefactorResponse.getUnique_id());
            personDao.save(personDto);

            List<WorkDto> workDtoList = workDao.getWorkByPid(personDto.getPid());
            workDtoList.forEach(workDto -> workDto.setStatus(WorkStatus.CONVERTED.name()));
            workDao.save(workDtoList);

            loadLeadsAction.executeAction(request);
            loadLeadsAction.executeAction();
        } catch (IOException e) {
            logger.error("Agreement template reader error - "+e);
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
