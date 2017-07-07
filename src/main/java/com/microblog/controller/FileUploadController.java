package com.microblog.controller;

import com.google.gson.Gson;
import com.microblog.model.media.MediaFileNotFoundException;
import com.microblog.service.MediaService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {
	private final MediaService mediaService;

	public FileUploadController(@Qualifier("mediaServiceImpl") MediaService mediaService) {
		this.mediaService = mediaService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String getUploadedFiles() throws IOException {
		List fileList = mediaService.loadAll()
			.map(path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
				.build().toString()).collect(Collectors.toList());
		return new Gson().toJson(fileList);
	}

	@RequestMapping(value = "/{filename:.+}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = mediaService.loadAsResource(filename);
		return ResponseEntity
			.ok()
			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
			.body(file);
	}

	@PostMapping("/")
	public void handleFileUpload(MultipartFile file, RedirectAttributes redirectAttributes) {

		mediaService.store(file);
		redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
	}

	@ExceptionHandler(MediaFileNotFoundException.class)
	public ResponseEntity handleMediaFileNotFound(MediaFileNotFoundException ex) {
		return ResponseEntity.notFound().build();
	}
}
