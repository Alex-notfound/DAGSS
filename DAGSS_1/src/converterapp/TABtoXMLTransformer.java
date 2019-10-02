package converterapp;

public class TABtoXMLTransformer implements Transformer {

	public String transform(String s) {
		String[] tokens = s.split("\t");
		if (tokens.length != 2) {
			throw new IllegalArgumentException("the line does not contain 3 tokens");
		}

		return "<product>\n\t<name>" + tokens[0] + "</name>\n\t<price>" + tokens[1] + "</price>\n</product>";
	}

	public String getHeader() {
		return "<products>";
	}

	public String getFooter() {
		return "</products>";
	}

}
