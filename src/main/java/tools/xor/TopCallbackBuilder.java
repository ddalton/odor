package tools.xor;

import tools.xor.ODataParser.RuleNames;
import apg.Parser;

public class TopCallbackBuilder extends CallbackBuilder {

	// Top specific processing is handled here

	public TopCallbackBuilder(Parser parser, RuleNames ruleName) {
		super(parser, ruleName);
	}

}