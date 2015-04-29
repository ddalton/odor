import org.junit.Test;

import apg.Ast;
import apg.Parser;
import apg.Parser.Result;
import apg.Trace;

public class TopTest {

    public static final String START_RULE_NAME = "odataUri";
    public static final String EXAMPLE1 = "http://services.odata.org/OData/OData.svc/Category(1)/Products?$top=201&$orderby=name";

    private static class InvalidRuleName extends IllegalArgumentException {

        private static final long serialVersionUID = 1L;

        public InvalidRuleName(String ruleName) {
            super(ruleName);
        }
    }

    private static int ruleID(String ruleName) {
        try {
            return ODataParser.RuleNames.valueOf(
                ruleName.toUpperCase().replace('-', '_')).ruleID();
        } catch (IllegalArgumentException e) {
            throw new InvalidRuleName("unknown rule " + ruleName);
        }
    }

    public interface Value<V> {
        public V getValue();
        public void setValue(V value);
    }

    public static class Top<Integer> implements Value<Integer>
    {
        private Integer value;

        @Override public Integer getValue ()
        {
            return this.value;
        }

        @Override public void setValue (Integer value)
        {
            this.value = value;
        }
    }

    public static class Tracker {

        public void enter(String name) {
            System.out.println("Enter: " + name);
        }

        public void leave(String name) {
            System.out.println("Leave: " + name);
        }
    }

    public static class AST_callback extends Ast.AstCallback {

        public AST_callback (Ast ast)
        {
            super(ast);
        }

        @Override public boolean preBranch(int offset, int length)
        {
            System.out.println("AST preBranch");
            ((Tracker)callbackData.myData).enter(extract(callbackData.inputString, offset));
            return super.preBranch(offset, length);
        }

        @Override public void postBranch (int offset, int length)
        {
            System.out.println("AST postBranch");
            ((Tracker)callbackData.myData).leave(extract(callbackData.inputString, offset, length));
        }
    }

    public static class TOP_callback extends Parser.RuleCallback {

        public TOP_callback (Parser parser)
        {
            super(parser);
        }

        @Override public int preBranch(int offset) throws Exception
        {
            System.out.println("preBranch");
            ((Tracker)callbackData.myData).enter(extract(callbackData.inputString, offset));
            return super.preBranch(offset);
        }

        @Override public int postBranch (int offset, int length) throws Exception
        {
            System.out.println("postBranch");
            ((Tracker)callbackData.myData).leave(extract(callbackData.inputString, offset, length));

            return super.postBranch(offset, length);
        }
    }

    private static String extract(char[] input, int offset) {
        String inputStr = new String(input);
        return inputStr.substring(offset);
    }

    private static String extract(char[] input, int offset, int length) {
        String inputStr = new String(input);
        return inputStr.substring(offset, offset+length);
    }

    private static String highlight(String input, int pos) {
        return input.substring(0, pos) + "[" + input.substring(pos) + "]";
    }

    @Test
    public void testTop() throws Exception {

        Parser p = new Parser(ODataParser.getInstance());
        p.setStartRule(ruleID(START_RULE_NAME));
        p.setInputString(EXAMPLE1);
        p.setMyData(new Tracker());
        p.setRuleCallback(ODataParser.RuleNames.TOP.ruleID(), new TOP_callback(p));

        // AST
        Ast ast = p.enableAst(true);
        ast.setMyData(new Tracker());
        ast.enableRuleNode(ODataParser.RuleNames.TOP.ruleID(), true);
        ast.enableRuleNode(ODataParser.RuleNames.EQ.ruleID(), true);
        ast.enableRuleNode(ODataParser.RuleNames.DIGIT.ruleID(), true);
        ast.setRuleCallback(ODataParser.RuleNames.TOP.ruleID(), new AST_callback(ast));
        ast.setRuleCallback(ODataParser.RuleNames.EQ.ruleID(), new AST_callback(ast));
        ast.setRuleCallback(ODataParser.RuleNames.DIGIT.ruleID(), new AST_callback(ast));
        Result r = p.parse();

        ast.translateAst();


        if( r.success() ) {
            System.out.println("Success: " + EXAMPLE1);
        } else if (!r.success() )
        {
            System.out.println(" fails at " + r.getMaxMatchedPhraseLength());
            r.displayResult(System.out);
            System.out.println("Trace **********************");


            // parse again with trace enabled
            Trace t = p.enableTrace(true);
            t.setOut(System.out);
            /*t.enableRule(
                false,
                ODataParser.RuleNames.ODATAURI.ruleID());
            t.enableRule(
                false,
                ODataParser.RuleNames.SERVICEROOT.ruleID());
            t.enableRule(false,
                ODataParser.RuleNames.ODATARELATIVEURI.ruleID());
            t.enableRule(
                false,
                ODataParser.RuleNames.QUERYOPTIONS.ruleID());
            t.enableRule(false,
                ODataParser.RuleNames.QUERYOPTION.ruleID());
            t.enableRule(
                false,
                ODataParser.RuleNames.RESOURCEPATH.ruleID());
*/
            p.parse();
            System.out.println();
            System.out.flush();
        }


    }
}
