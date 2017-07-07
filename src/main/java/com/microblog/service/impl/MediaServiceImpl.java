package com.microblog.service.impl;

import com.microblog.model.media.Media;
import com.microblog.model.media.MediaException;
import com.microblog.model.media.MediaFileNotFoundException;
import com.microblog.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component(value = "mediaServiceImpl")
public class MediaServiceImpl implements MediaService {

	private final Path rootLocation;

	@Autowired
	public MediaServiceImpl(Media media) {
		this.rootLocation = Paths.get(media.getLocation());
	}

	@Override
	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException ex) {
			throw new MediaException("Could not initialize media", ex);
		}
	}

	@Override
	public void store(MultipartFile file) {
		try {
			if (file.isEmpty()) {
				throw new MediaException("Failed to store empty file " + file.getOriginalFilename());
			}
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (IOException ex) {
			throw new MediaException("Failed to store file " + file.getOriginalFilename(), ex);
		}
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.rootLocation, 1)
				.filter(path -> !path.equals(this.rootLocation))
				.map(this.rootLocation::relativize);
		} catch (IOException ex) {
			throw new MediaException("Failed to read stored files", ex);
		}
	}

	@Override
	public Path load(String fileName) {
		return this.rootLocation.resolve(fileName);
	}

	@Override
	public Resource loadAsResource(String fileName) {
		try {
			Path file = load(fileName);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new MediaFileNotFoundException("Could not read file " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new MediaFileNotFoundException("Could not read file " + fileName, ex);
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}
}
