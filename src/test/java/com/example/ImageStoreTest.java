package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.image.store.ImageStore;
import com.example.repository.ImageStoreRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageStoreTest {

	@Autowired
	private ImageStoreRepository imageStoreRepository;
	private FileInputStream fis;

	@Test
	public void contextLoads() {
	}

	@Test
	public void saveImage() throws IOException {

		ImageStore i = new ImageStore();
		i.setName("MyImage.jpg");

		File f = new File("C:\\Users\\Harshad\\Desktop\\Harshad_photo.jpg");
		byte[] fileContent = new byte[(int) f.length()];
		fis = new FileInputStream(f);
		fis.read(fileContent);

		i.setImageData(fileContent);

		imageStoreRepository.save(i);

		fis.close();

	}

	@Test
	public void getImage() throws IOException {

		Optional<ImageStore> i = imageStoreRepository.findById(428l);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Harshad\\Desktop\\Coy_Harshad_photo.jpg");
		fos.write(i.get().getImageData());
		fos.close();
	}

}
