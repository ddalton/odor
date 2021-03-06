package tools.xor;

import org.junit.Test;

import apg.Parser;
import apg.Parser.Result;
import apg.Trace;

/**
 * This helps us to understand that we need to always use relative path.
 * The absolute path needs to be used only if the service root is known.
 * 
 * @author Dilip Dalton
 *
 */
public class OdorTest {

	// Use odataRelativeUri if not processing a complete URI
    public static final String FULL_URI = "odataUri";
    public static final String RELATIVE_URI = "odataRelativeUri";

    private static void processFailure(Result r, Parser p) throws Exception {
    	System.out.println(" fails at " + r.getMaxMatchedPhraseLength());
    	r.displayResult(System.out);
    	System.out.println("Trace **********************");


    	// parse again with trace enabled
    	Trace t = p.enableTrace(true);
    	t.setOut(System.out);

    	p.parse();
    	System.out.println();
    	System.out.flush();
    }
    
    /*
    public static class AST_callback extends Ast.AstCallback {
    	private String ruleName;

        public AST_callback (Ast ast, RuleNames ruleName)
        {
            super(ast);
            this.ruleName = ruleName.name();
        }

        @Override public boolean preBranch(int offset, int length)
        {
            System.out.println("AST preBranch");
            ((Tracker)callbackData.myData).enter(extract(callbackData.inputString, offset), ruleName);
            return super.preBranch(offset, length);
        }

        @Override public void postBranch (int offset, int length)
        {
            System.out.println("AST postBranch");
            ((Tracker)callbackData.myData).leave(extract(callbackData.inputString, offset, length), ruleName);
        }
    }

    private static String extract(char[] input, int offset) {
        String inputStr = new String(input);
        return inputStr.substring(offset);
    }

    private static String extract(char[] input, int offset, int length) {
        String inputStr = new String(input);
        //System.out.println("extract: input: " + String.valueOf(input) + ", offset: " + offset + ", length: " + length);
        return inputStr.substring(offset, offset+length);
    }
    */

    @Test
    public void testTopFull() throws Exception {
        final String FULL_TOP = "http://services.odata.org/OData/OData.svc/Category(1)/Products?$top=201&$orderby=name";
        
        Parser p = new Parser(ODataParser.getInstance());
        p.setStartRule(CallbackBuilder.ruleID(FULL_URI));
        p.setInputString(FULL_TOP);
        p.setMyData(new CallbackBuilder.Tracker());
        p.setRuleCallback(ODataParser.RuleNames.TOP.ruleID(), new TopCallbackBuilder(p, ODataParser.RuleNames.TOP));
        p.setRuleCallback(ODataParser.RuleNames.ORDERBYITEM.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.ORDERBYITEM));
        p.setRuleCallback(ODataParser.RuleNames.ENTITYSETNAME.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.ENTITYSETNAME));
        p.setRuleCallback(ODataParser.RuleNames.KEYPROPERTYVALUE.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.KEYPROPERTYVALUE));
        p.setRuleCallback(ODataParser.RuleNames.SEGMENT_NZ.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.SEGMENT_NZ));
        p.setRuleCallback(ODataParser.RuleNames.RESOURCEPATH.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.RESOURCEPATH));        

        /*
        // AST
        Ast ast = p.enableAst(true);
        ast.setMyData(new Tracker());
        ast.enableRuleNode(ODataParser.RuleNames.TOP.ruleID(), true);
        ast.enableRuleNode(ODataParser.RuleNames.EQ.ruleID(), true);
        ast.enableRuleNode(ODataParser.RuleNames.DIGIT.ruleID(), true);
        ast.setRuleCallback(ODataParser.RuleNames.TOP.ruleID(), new AST_callback(ast, ODataParser.RuleNames.TOP));
        ast.setRuleCallback(ODataParser.RuleNames.EQ.ruleID(), new AST_callback(ast, ODataParser.RuleNames.EQ));
        ast.setRuleCallback(ODataParser.RuleNames.DIGIT.ruleID(), new AST_callback(ast, ODataParser.RuleNames.DIGIT));
        Result r = p.parse();
        ast.translateAst();
        */
        Result r = p.parse();

        if( r.success() ) {
            System.out.println("Success: " + FULL_TOP);
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
    
    @Test
    public void testTopRelative() throws Exception {
        /*
         * In this example
         * 
         * ENTITYSETNAME - Category
         */
        final String RELATIVE_TOP = "Category(1)/Products?$top=201&$orderby=name";
        
        Parser p = new Parser(ODataParser.getInstance());
        p.setStartRule(CallbackBuilder.ruleID(RELATIVE_URI));
        p.setInputString(RELATIVE_TOP);
        p.setMyData(new CallbackBuilder.Tracker());
        p.setRuleCallback(ODataParser.RuleNames.TOP.ruleID(), new TopCallbackBuilder(p, ODataParser.RuleNames.TOP));
        p.setRuleCallback(ODataParser.RuleNames.ORDERBYITEM.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.ORDERBYITEM));
        p.setRuleCallback(ODataParser.RuleNames.ENTITYSETNAME.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.ENTITYSETNAME));
        p.setRuleCallback(ODataParser.RuleNames.KEYPROPERTYVALUE.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.KEYPROPERTYVALUE));
        p.setRuleCallback(ODataParser.RuleNames.RESOURCEPATH.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.RESOURCEPATH));
        
        Result r = p.parse();

        if( r.success() ) {
            System.out.println("Success: " + RELATIVE_TOP);
        } else if (!r.success() )
        {
            processFailure(r, p);
        }
    }
    
    @Test
    public void testTopRelativeClassName() throws Exception {
    	final String RELATIVE_TOP = "tools_xor_odor_Category(1)/Products?$top=201&$skip=10&$orderby=name";
    	
        Parser p = new Parser(ODataParser.getInstance());
        p.setStartRule(CallbackBuilder.ruleID(RELATIVE_URI));
        p.setInputString(RELATIVE_TOP);
        p.setMyData(new CallbackBuilder.Tracker());
        p.setRuleCallback(ODataParser.RuleNames.TOP.ruleID(), new TopCallbackBuilder(p, ODataParser.RuleNames.TOP));
        p.setRuleCallback(ODataParser.RuleNames.SKIP.ruleID(), new SkipCallbackBuilder(p, ODataParser.RuleNames.SKIP));        
        p.setRuleCallback(ODataParser.RuleNames.ORDERBYITEM.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.ORDERBYITEM));
        p.setRuleCallback(ODataParser.RuleNames.ENTITYSETNAME.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.ENTITYSETNAME));
        p.setRuleCallback(ODataParser.RuleNames.KEYPROPERTYVALUE.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.KEYPROPERTYVALUE));
        p.setRuleCallback(ODataParser.RuleNames.RESOURCEPATH.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.RESOURCEPATH));
        
        Result r = p.parse();

        if( r.success() ) {
            System.out.println("Success: " + RELATIVE_TOP);
        } else if (!r.success() )
        {
            processFailure(r, p);
        }
    }
       
    
    @Test
    public void testSkiptoken() throws Exception {
    	final String RELATIVE_TOP = "tools_xor_odor_Category(1)/Products?$top=201&$skiptoken=13S35K&$orderby=name";
    	
        Parser p = new Parser(ODataParser.getInstance());
        p.setStartRule(CallbackBuilder.ruleID(RELATIVE_URI));
        p.setInputString(RELATIVE_TOP);
        p.setMyData(new CallbackBuilder.Tracker());
        p.setRuleCallback(ODataParser.RuleNames.TOP.ruleID(), new TopCallbackBuilder(p, ODataParser.RuleNames.TOP));
        p.setRuleCallback(ODataParser.RuleNames.SKIPTOKEN.ruleID(), new SkiptokenCallbackBuilder(p, ODataParser.RuleNames.SKIPTOKEN));        
        p.setRuleCallback(ODataParser.RuleNames.ORDERBYITEM.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.ORDERBYITEM));
        p.setRuleCallback(ODataParser.RuleNames.ENTITYSETNAME.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.ENTITYSETNAME));
        p.setRuleCallback(ODataParser.RuleNames.KEYPROPERTYVALUE.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.KEYPROPERTYVALUE));
        p.setRuleCallback(ODataParser.RuleNames.RESOURCEPATH.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.RESOURCEPATH));
        
        Result r = p.parse();

        if( r.success() ) {
            System.out.println("Success: " + RELATIVE_TOP);
        } else if (!r.success() )
        {
            processFailure(r, p);
        }
    }    
    
    @Test
    public void testView() throws Exception {
    	final String RELATIVE_TOP = "tools_xor_odor_Category(1)/Products?$top=201&view=BASICINFO&$orderby=name";
    	
        Parser p = new Parser(ODataParser.getInstance());
        p.setStartRule(CallbackBuilder.ruleID(RELATIVE_URI));
        p.setInputString(RELATIVE_TOP);
        p.setMyData(new CallbackBuilder.Tracker());
        p.setRuleCallback(ODataParser.RuleNames.TOP.ruleID(), new TopCallbackBuilder(p, ODataParser.RuleNames.TOP));
        p.setRuleCallback(ODataParser.RuleNames.CUSTOMQUERYOPTION.ruleID(), new CustomCallbackBuilder(p, ODataParser.RuleNames.CUSTOMQUERYOPTION));        
        p.setRuleCallback(ODataParser.RuleNames.ORDERBYITEM.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.ORDERBYITEM));
        p.setRuleCallback(ODataParser.RuleNames.ENTITYSETNAME.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.ENTITYSETNAME));
        p.setRuleCallback(ODataParser.RuleNames.KEYPROPERTYVALUE.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.KEYPROPERTYVALUE));
        p.setRuleCallback(ODataParser.RuleNames.RESOURCEPATH.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.RESOURCEPATH));
        
        Result r = p.parse();

        if( r.success() ) {
            System.out.println("Success: " + RELATIVE_TOP);
        } else if (!r.success() )
        {
            processFailure(r, p);
        }
    }     
    
    @Test
    public void testMultipleOrderBy() throws Exception {
    	final String RELATIVE_TOP = "tools_xor_odor_Category(1)/Products?$top=201&$orderby=ModificationDate desc,Category,Name";
    	
        Parser p = new Parser(ODataParser.getInstance());
        p.setStartRule(CallbackBuilder.ruleID(RELATIVE_URI));
        p.setInputString(RELATIVE_TOP);
        p.setMyData(new CallbackBuilder.Tracker());  
        p.setRuleCallback(ODataParser.RuleNames.ORDERBY.ruleID(), new OrderbyCallbackBuilder(p, ODataParser.RuleNames.ORDERBY));        
        p.setRuleCallback(ODataParser.RuleNames.ORDERBYITEM.ruleID(), new OrderbyItemCallbackBuilder(p, ODataParser.RuleNames.ORDERBYITEM));
        p.setRuleCallback(ODataParser.RuleNames.ENTITYSETNAME.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.ENTITYSETNAME));
        p.setRuleCallback(ODataParser.RuleNames.KEYPROPERTYVALUE.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.KEYPROPERTYVALUE));
        p.setRuleCallback(ODataParser.RuleNames.RESOURCEPATH.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.RESOURCEPATH));
        
        Result r = p.parse();

        if( r.success() ) {
            System.out.println("Success: " + RELATIVE_TOP);
        } else if (!r.success() )
        {
            processFailure(r, p);
        }
    }     
    
    @Test
    public void testId() throws Exception {
    	final String RELATIVE_TOP = "$entity?$id=People('russellwhyte')";
    	
        Parser p = new Parser(ODataParser.getInstance());
        p.setStartRule(CallbackBuilder.ruleID(RELATIVE_URI));
        p.setInputString(RELATIVE_TOP);
        p.setMyData(new CallbackBuilder.Tracker());  
        p.setRuleCallback(ODataParser.RuleNames.ID.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.ID));        
        p.setRuleCallback(ODataParser.RuleNames.IRI_IN_QUERY.ruleID(), new CallbackBuilder(p, ODataParser.RuleNames.IRI_IN_QUERY));
        
        Result r = p.parse();

        if( r.success() ) {
            System.out.println("Success: " + RELATIVE_TOP);
        } else if (!r.success() )
        {
        	processFailure(r, p);
        }
    }      
    
    @Test
    public void testSimpleSelect() throws Exception {
    	final String ABSOLUTE_SELECT = "http://host/service/Products?$select=Rating,ReleaseDate";
    	
        Parser p = new Parser(ODataParser.getInstance());
        p.setStartRule(CallbackBuilder.ruleID(FULL_URI));
        p.setInputString(ABSOLUTE_SELECT);
        p.setMyData(new CallbackBuilder.Tracker());
        p.setRuleCallback(ODataParser.RuleNames.SELECT.ruleID(), new SelectCallbackBuilder(p, ODataParser.RuleNames.SELECT));
        p.setRuleCallback(ODataParser.RuleNames.SELECTITEM.ruleID(), new SelectItemCallbackBuilder(p, ODataParser.RuleNames.SELECTITEM)); 
        
        Result r = p.parse();
        
        if( r.success() ) {
            System.out.println("Success: " + ABSOLUTE_SELECT);
        } else if (!r.success() )
        {
        	processFailure(r, p);
        }
    }
}
