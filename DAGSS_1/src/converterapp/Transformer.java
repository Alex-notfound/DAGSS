package converterapp;

public interface Transformer {
	
	public String transform(String s);

	public String getHeader();

	public String getFooter();
}
