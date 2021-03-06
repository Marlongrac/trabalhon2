package edu.fae.trabalho.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Serviço que gerencia arquivos da aplicação
 */
@Service
public class FilesService {
	@Value("${upload.dir}")
	private String path;
	
	/**
	 * Salva um arquivo no diretorio de upload 
	 */
	public String saveFile(MultipartFile file) {
		try{
			FileOutputStream fout = new FileOutputStream(path + file.getOriginalFilename());
			IOUtils.copy(file.getInputStream(), fout);
			fout.close();
			return file.getOriginalFilename();
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Responsavel por enviar arquivos de upload para o navegador do usuario 
	 */
	public void showFile(String file, HttpServletRequest request, HttpServletResponse response) {
		try{ 
			String fullFile = path + file;
			if(!new File(fullFile).exists()) {
				response.sendError(404);
			}else{
				response.setContentType(request.getSession().getServletContext().getMimeType(fullFile));
				FileInputStream fin = new FileInputStream(fullFile);
				IOUtils.copy(fin, response.getOutputStream());
			}
		}catch(Exception ex) {
			try {
				response.sendError(404);
			} catch (IOException e) {
			}
		}
	}
}