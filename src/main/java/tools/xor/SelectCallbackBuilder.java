package tools.xor;

import java.util.LinkedList;
import java.util.List;

import tools.xor.ODataParser.RuleNames;
import apg.Parser;

public class SelectCallbackBuilder extends CallbackBuilder {

	private List<String> clauses = new LinkedList<String>(); 
	
	public SelectCallbackBuilder(Parser parser, RuleNames ruleName) {
		super(parser, ruleName);
	}
	
	@Override
	protected void process(String fragment, CallbackBuilder parent) {
		for(String oi: clauses) 
			System.out.println(oi.toString());
	}

	public List<String> getClauses() {
		return clauses;
	}

	public void setClauses(List<String> clauses) {
		this.clauses = clauses;
	}	

}