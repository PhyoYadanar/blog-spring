package demo.example.blogspring;

import demo.example.blogspring.model.Author;
import demo.example.blogspring.model.Gender;
import demo.example.blogspring.model.Post;
import demo.example.blogspring.repository.AuthorRepository;
import demo.example.blogspring.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@SpringBootApplication
public class BlogSpringApplication {
    private static Logger logger= LoggerFactory.getLogger(BlogSpringApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(BlogSpringApplication.class, args);
    }
    @Bean @Profile("dev")
    public CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository){
        return args -> {
            Author author1=new Author("Thaw", LocalDate.of(1996,1,17),"Horror", Gender.FEMALE);
            Post p1=new Post("aaaa","ssssss",LocalDate.now());
            Post p2=new Post("aaaa","ssssss",LocalDate.now());
            Post p3=new Post("aaaa","ssssss",LocalDate.now());

            p1.setAuthor(author1);
            p2.setAuthor(author1);
            p3.setAuthor(author1);

            authorRepository.save(author1);
            postRepository.save(p1);
            postRepository.save(p2);
            postRepository.save(p3);

            logger.info("sucessfully create.");


        };
    }

}
