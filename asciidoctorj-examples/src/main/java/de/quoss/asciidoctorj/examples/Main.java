package de.quoss.asciidoctorj.examples;

import java.io.File;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.ast.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private void run() {
        final File f = new File("asciidoctorj-examples", "example.adoc");
        final Asciidoctor doctor = org.asciidoctor.Asciidoctor.Factory.create();
        final Options options = Options.builder().build();
        final Document document = doctor.loadFile(f, options);
        LOGGER.info("main/run [document.title={}]", document.getTitle());
    }

    public static void main(String...args) {
        new Main().run();
    }
    
}
