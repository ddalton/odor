package tools.xor;

import java.util.LinkedList;
import java.util.List;

import tools.xor.ODataParser.RuleNames;
import apg.Parser;

public class OrderbyCallbackBuilder extends CallbackBuilder {

	private List<OrderbyItem> clauses = new LinkedList<OrderbyItem>(); 
	
	public OrderbyCallbackBuilder(Parser parser, RuleNames ruleName) {
		super(parser, ruleName);
	}
	
	@Override
	protected void process(String fragment, CallbackBuilder parent) {
		for(OrderbyItem oi: clauses) 
			System.out.println(oi.toString());
	}

	public List<OrderbyItem> getClauses() {
		return clauses;
	}

	public void setClauses(List<OrderbyItem> clauses) {
		this.clauses = clauses;
	}	

}