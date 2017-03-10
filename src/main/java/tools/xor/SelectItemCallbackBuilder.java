package tools.xor;

import tools.xor.ODataParser.RuleNames;
import apg.Parser;

public class SelectItemCallbackBuilder extends CallbackBuilder {

	public SelectItemCallbackBuilder(Parser parser, RuleNames ruleName) {
		super(parser, ruleName);
	}
	
	@Override
	protected void process(String fragment, CallbackBuilder parent) {
		System.out.println("FRAGEMENT: " + fragment);
		((SelectCallbackBuilder)parent).getClauses().add(fragment);
	}	

}