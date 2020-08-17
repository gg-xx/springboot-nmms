package com.itany.nmms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
@RequestMapping("/code")
public class CodeController {


    @RequestMapping("/show")
    public void show(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Random random = new Random();
        BufferedImage image = new BufferedImage(50,25,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.fillRect(0,0,50,25);
        graphics.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
        graphics.setFont(new Font("宋体",Font.BOLD+Font.ITALIC,18));
        String s = "0123456789qwertyuiopasdfghjklzxcvbnm";
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < 4; i++){
            buffer.append(s.charAt(random.nextInt(s.length())));
        }
        System.out.println("验证码:"+buffer.toString());
        graphics.drawString(buffer.toString(),5,18);
        request.getSession().setAttribute("code",buffer.toString());
        ImageIO.write(image,"JPEG",response.getOutputStream());
    }

}
