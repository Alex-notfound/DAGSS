package converterapp;

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
		String s;
		writer.write(transformer.getHeader());
		while ((s = reader.read()) != null) {
			writer.write(transformer.transform(s));
		}
		writer.write(transformer.getFooter());
		writer.write(null);
	}
}
