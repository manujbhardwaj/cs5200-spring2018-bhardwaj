package edu.northeastern.cs5200.controllers.hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HelloController {
    
    @Autowired
    HelloRepository helloRepository;
    
    @RequestMapping("/api/hello/sendemail")
    public void sendEmail() {
    	Mailer.send("bhardwaj.ma@husky.neu.edu","Manuj@90","themanujbhardwaj@gmail.com","hello javatpoint","How r u?");
    }
    
    @RequestMapping("/api/hello/insert")
    public HelloObject insertHelloObject() {
        HelloObject obj = new HelloObject("Hello Manuj Bhardwaj!");
        helloRepository.save(obj);
        return obj;
    }
    
    @RequestMapping("/api/hello/insert/{msg}")
    public HelloObject insertMessage(@PathVariable("msg") String message) {
        HelloObject obj = new HelloObject(message);
        helloRepository.save(obj);
        return obj;
    }
    
    @RequestMapping("/api/hello/select/all")
    public List<HelloObject> selectAllHelloObjects() {
        List<HelloObject> hellos =
            (List<HelloObject>)helloRepository.findAll();
        return hellos;
    }
    
    @RequestMapping("/api/hello/string")
    public String sayHello() {
        return "Hello Manuj Bhardwaj!";
    }
  
    @RequestMapping("/api/hello/object")
    public HelloObject sayHelloObject() {
        HelloObject obj = new HelloObject("Hello Manuj Bhardwaj!");
        return obj;
    }
}
