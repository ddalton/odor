package tools.xor;

import tools.xor.ODataParser.RuleNames;
import apg.Parser;

public class SkipCallbackBuilder extends CallbackBuilder {

	private int value; 

	public SkipCallbackBuilder(Parser parser, RuleNames ruleName) {
		super(parser, ruleName);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	protected void process(String fragment) {
		if(fragment.contains("=")) {
			String digits = fragment.substring(fragment.indexOf('=')+1);
			value = Integer.parseInt(digits.trim());
			System.out.println("Skip### " + value);
		}
	}	

}