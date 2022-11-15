package com.distarise.credaegis.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.FileUploadDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.service.FileStorageService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.encryption.StandardDecryptionMaterial;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class UploadCibilPostHandlerAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    FileStorageService fileStorageService;

    @Override
    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        if (!targetPageDetailsDto.getFileUploads().isEmpty()){
            FileUploadDto file = targetPageDetailsDto.getFileUploads().get(0);
            Resource resource = fileStorageService.loadFileAsResource(file.getFileName());
            try (PDDocument document = PDDocument.load(resource.getFile(),"srin9651")) {
                document.setAllSecurityToBeRemoved(true);
                document.getClass();
                    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                    stripper.setSortByPosition(true);

                    PDFTextStripper tStripper = new PDFTextStripper();

                    String pdfFileInText = tStripper.getText(document);
                    //System.out.println("Text:" + st);

                    // split by whitespace
                    String lines[] = pdfFileInText.split("\\r?\\n");
                    for (String line : lines) {
                        //System.out.println(line);
                    }

                PDDocumentOutline outline =  document.getDocumentCatalog().getDocumentOutline();
                printBookmark(outline, "");
                System.out.println(outline);

            } catch (InvalidPasswordException e) {
                System.out.println("Invalid password");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }  catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void printBookmark(PDOutlineNode bookmark, String indentation) throws IOException
    {
        PDOutlineItem current = bookmark.getFirstChild();
        System.out.println("Printing bookmark ------>");
        while (current != null)
        {
            System.out.println(indentation + current.getTitle());
            printBookmark(current, indentation + "    ");
            current = current.getNextSibling();
        }
    }
}
