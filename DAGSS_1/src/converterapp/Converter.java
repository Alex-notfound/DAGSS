package converterapp;

import converterapp.Reader.Reader;
import converterapp.Transformer.Transformer;
import converterapp.Writer.Writer;

public class Converter {

	Reader reader;
	Transformer transformer;
	Writer writer;

	public Converter(Reader r, Transformer t, Writer w) {
		this.reader = r;
		this.transformer = t;
		this.writer = w;
	}

	public void convert() {
		writer.write(transformer.getHeader());
		
		String s;
		while ((s = reader.read()) != null) {
			writer.write(transformer.transform(s));
		}
		
		writer.write(transformer.getFooter());
		writer.close();
	}
}
