package mx.gob.economia.inadem.util;

import java.io.Serializable;
import javax.faces.context.FacesContext;

import mx.gob.economia.inadem.ui.PageBase;
import mx.gob.economia.inadem.ui.solicitud.SolicitudPageBean;

import org.icefaces.ace.component.fileentry.FileEntry;
import org.icefaces.ace.component.fileentry.FileEntryEvent;
import org.icefaces.ace.component.fileentry.FileEntryResults;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploaderPageBean extends PageBase implements Serializable {


	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(SolicitudPageBean.class);

	private String fileData; 

	public synchronized void listener(FileEntryEvent event){ 
		try { 
			FileEntry fileEntry = (FileEntry) event.getSource(); 
			FileEntryResults results = fileEntry.getResults(); 
			for(FileEntryResults.FileInfo fileInfo : results.getFiles()) { 
				log.info(fileInfo.getStatus().toString());
				if(fileInfo.isSaved()) {
					log.info("Uploaded new file! "+fileInfo.getFile().getAbsolutePath().toString());
				}else{
					log.info("File was not saved because: ");
					log.info("Docto no fue guardado! "+
							fileInfo.getStatus().getFacesMessage(FacesContext.getCurrentInstance(),fileEntry, fileInfo).getSummary()); 
				}
			}
		}catch(Exception ex) { 
			System.out.println("Could not build uploaded resource: " + ex.getMessage()); 
		} 
	}

	public String getFileData() {
		return fileData;
	}
}
