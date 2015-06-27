package tools.xor;

import java.util.Stack;

import tools.xor.ODataParser.RuleNames;
import apg.Parser;

public class CallbackBuilder extends Parser.RuleCallback {
	private String ruleName;

	public static class Tracker {
		
		Stack<CallbackBuilder> builders = new Stack<CallbackBuilder>();

		public void enter(CallbackBuilder builder, String name, String ruleName) {
			System.out.println("Enter [" + ruleName + "] " + name);
			builders.push(builder);
		}

		public void leave(CallbackBuilder builder, String name, String ruleName) {
			System.out.println("Leave [" + ruleName + "] " + name);
			builders.pop();
		}
	}
	
    private static class InvalidRuleName extends IllegalArgumentException {

        private static final long serialVersionUID = 1L;

        public InvalidRuleName(String ruleName) {
            super(ruleName);
        }
    }	
	
    public static int ruleID(String ruleName) {
        try {
            return ODataParser.RuleNames.valueOf(
                ruleName.toUpperCase().replace('-', '_')).ruleID();
        } catch (IllegalArgumentException e) {
            throw new InvalidRuleName("unknown rule " + ruleName);
        }
    }	

	private String extract(char[] input, int offset) {
		String inputStr = new String(input);
		return inputStr.substring(offset);
	}

	private String extract(char[] input, int offset, int length) {
		String inputStr = new String(input);
		// System.out.println("extract: input: " + String.valueOf(input) +
		// ", offset: " + offset + ", length: " + length);
		return inputStr.substring(offset, offset + length);
	}

	public CallbackBuilder(Parser parser, RuleNames ruleName) {
		super(parser);
		this.ruleName = ruleName.name();
	}

	@Override
	public int preBranch(int offset) throws Exception {
		System.out.println("preBranch");
		((Tracker) callbackData.myData).enter(
				this,
				extract(callbackData.inputString, offset), 
				ruleName);
		return super.preBranch(offset);
	}

	@Override
	public int postBranch(int offset, int length) throws Exception {
		System.out.println("postBranch");
		((Tracker) callbackData.myData).leave(
				this,
				extract(callbackData.inputString, offset, length), 
				ruleName);

		return super.postBranch(offset, length);
	}
}