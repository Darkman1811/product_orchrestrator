package com.guestu.springbootcamel;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Arrays;

@SpringBootApplication
public class SpringbootcamelApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootcamelApplication.class, args);
    }

    /*
    @Override
    public void configure() throws Exception {
        //Move Data from one file to another file
        System.out.println("Started...");
       // moveAllFile();
       // moveSpecificFile();
       // filterByContent();
      //  fileProcessing();

        from("file:/C:/Users/Abdoulaye Diaw/Desktop/FICHIERS/Projet Santé/springbootcamel/src/main/resources/b?noop=true")
                .unmarshal().csv()
               // .marshal().csv()
                .split(
                                         body().tokenize(";"))
                .choice()
                                        .when(body().contains("closed")).to("file:/C:/Users/Abdoulaye Diaw/Desktop/FICHIERS/Projet Santé/springbootcamel/src/main/resources/b?fileName=closed.csv")
                                        .when(body().contains("pending")).to("file:/C:/Users/Abdoulaye Diaw/Desktop/FICHIERS/Projet Santé/springbootcamel/src/main/resources/b?fileName=pending.csv")
                                        .when(body().contains("inprogress")).to("file:/C:/Users/Abdoulaye Diaw/Desktop/FICHIERS/Projet Santé/springbootcamel/src/main/resources/b?fileName=inprogress.csv")
                ;
    }

    private void fileProcessing() {

        from("file:/C:/Users/Abdoulaye Diaw/Desktop/FICHIERS/Projet Santé/springbootcamel/src/main/resources/a?noop=true")
                .process(p->{
                    String body=p.getIn().getBody(String.class);
                    StringBuilder sb=new StringBuilder();
                    Arrays.stream(body.split(" ")).forEach(s->{
                       sb.append(s+";");
                    });
                    p.getIn().setBody(sb);
                 //   System.out.println(p.getIn().getHeader(Exchange.FILE_NAME).toString());
                    String filename=p.getIn().getHeader(Exchange.FILE_NAME).toString();
                    filename=filename.replace(".txt",".csv");
                    p.getIn().setHeader(Exchange.FILE_NAME,filename);
                })
                .to("file:/C:/Users/Abdoulaye Diaw/Desktop/FICHIERS/Projet Santé/springbootcamel/src/main/resources/b");
    }

    private void filterByContent() {
        from("file:/C:/Users/Abdoulaye Diaw/Desktop/FICHIERS/Projet Santé/springbootcamel/src/main/resources/a?noop=true")
                .filter(body().startsWith("Java"))
                .to("file:/C:/Users/Abdoulaye Diaw/Desktop/FICHIERS/Projet Santé/springbootcamel/src/main/resources/b");
        System.out.println("End...");
    }

    private void moveSpecificFile() {
        from("file:/C:/Users/Abdoulaye Diaw/Desktop/FICHIERS/Projet Santé/springbootcamel/src/main/resources/a?noop=true")
                .filter(header(Exchange.FILE_NAME).startsWith("file1"))
                .to("file:/C:/Users/Abdoulaye Diaw/Desktop/FICHIERS/Projet Santé/springbootcamel/src/main/resources/b");
    }

    private void moveAllFile() {
        from("file:/C:/Users/Abdoulaye Diaw/Desktop/FICHIERS/Projet Santé/springbootcamel/src/main/resources/a?noop=true").to("file:/C:/Users/Abdoulaye Diaw/Desktop/FICHIERS/Projet Santé/springbootcamel/src/main/resources/b");
    }
    */
}
