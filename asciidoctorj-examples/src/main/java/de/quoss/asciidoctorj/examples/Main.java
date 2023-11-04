package de.quoss.asciidoctorj.examples;

import java.io.File;
import java.util.List;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.ast.Document;
import org.asciidoctor.ast.StructuralNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private void run() {
        final File f = new File("index.adoc");
        try (final Asciidoctor doctor = Asciidoctor.Factory.create()) {
            final Options options = Options.builder().build();
            final Document document = doctor.loadFile(f, options);
            LOGGER.info("main/run Document [blocks={},context={},level={},role={},title={}]", formatNodes(document.getBlocks()), document.getContext(), document.getLevel(),
                    document.getRole(), document.getTitle());
        }
    }

    private String formatNodes(final List<StructuralNode> nodes) {
    	final StringBuilder builder = new StringBuilder("[");
    	boolean addComma = false;
        for (final StructuralNode node : nodes) {
        	if (addComma) {
        		builder.append(", ");
        	}
        	if (!addComma) {
        		addComma = true;
        	}
            builder.append(String.format("StructuralNode [attributes=%s,blocks=%s,content=%s,content.class.name=%s,context=%s,document=%s,id=%s,level=%s,role=%s,title=%s]",
                    node.getAttributes(), formatNodes(node.getBlocks()), node.getContent(), node.getContent().getClass().getName(), node.getContext(), node.getDocument(),
                    node.getId(), node.getLevel(), node.getRole(), node.getTitle()));
        }
        return builder.append("]").toString();
    }
    
    public static void main(String...args) {
        new Main().run();
    }

}
