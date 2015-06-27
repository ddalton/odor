package tools.xor;

import tools.xor.ODataParser.RuleNames;
import apg.Parser;

public class SkiptokenCallbackBuilder extends CallbackBuilder {

	private String value; 

	public SkiptokenCallbackBuilder(Parser parser, RuleNames ruleName) {
		super(parser, ruleName);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	protected void process(String fragment, CallbackBuilder parent) {
		if(fragment.contains("=")) {
			String token = fragment.substring(fragment.indexOf('=')+1);
			System.out.println("Skiptoken### " + token);
		}
	}	

}