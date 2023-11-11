package kz.demo.halykoiy.services;

import jakarta.servlet.http.HttpServletResponse;
import kz.demo.halykoiy.entities.Item;
import kz.demo.halykoiy.repos.ItemRepository;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Alisher
 * @since 11/12/2023
 */
@Service
@AllArgsConstructor
public class FileService {
    private final ItemRepository itemRepository;

    public void loadImagePNG(Long itemId, HttpServletResponse response) {
        try {
            Item item = itemRepository.findById(itemId).orElseThrow(()->new RuntimeException("Item not found"));
            InputStream image = FileService.class.getClassLoader().getResourceAsStream(item.getImageUrl());
            response.setHeader("Content-Disposition", "attachment;filename=" + "image.png");
            response.setContentType("image/png");
            OutputStream os = response.getOutputStream();
            image.transferTo(os);

        } catch (FileNotFoundException e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
