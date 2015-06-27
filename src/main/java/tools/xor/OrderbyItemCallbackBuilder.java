package tools.xor;

import tools.xor.ODataParser.RuleNames;
import tools.xor.OrderbyItem.Ordering;
import apg.Parser;

public class OrderbyItemCallbackBuilder extends CallbackBuilder {

	public OrderbyItemCallbackBuilder(Parser parser, RuleNames ruleName) {
		super(parser, ruleName);
	}
	
	@Override
	protected void process(String fragment, CallbackBuilder parent) {
		String[] tokens = fragment.split("\\s+");
		OrderbyItem oi = new OrderbyItem();
		oi.setName(tokens[0]);
		oi.setOrdering(Ordering.ASC);
		if(tokens.length == 2) {
			if("asc".equals(tokens[1].trim())) {
				oi.setOrdering(Ordering.ASC);
			} else if ("desc".equals(tokens[1].trim())) {
				oi.setOrdering(Ordering.DESC);
			} else {
				System.out.println("Unsupported ordering clause, valid choices are 'asc' and 'desc': " + tokens[1]);
			}
		}
		
		((OrderbyCallbackBuilder)parent).getClauses().add(oi);
	}	

}