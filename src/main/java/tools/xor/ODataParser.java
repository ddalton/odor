import apg.Grammar;
import java.io.PrintStream;

public class ODataParser extends Grammar{

    // public API
    public static Grammar getInstance(){
        if(factoryInstance == null){
            factoryInstance = new ODataParser(getRules(), getUdts(), getOpcodes());
        }
        return factoryInstance;
    }

    // rule name enum
    public static int ruleCount = 395;
    public enum RuleNames{
        A_TO_F("A-to-F", 390, 2736, 7),
        ABSTRACTSPATIALTYPENAME("abstractSpatialTypeName", 213, 1602, 3),
        ACTION("action", 225, 1627, 1),
        ACTIONIMPORT("actionImport", 226, 1628, 1),
        ACTIONIMPORTCALL("actionImportCall", 22, 211, 1),
        ADDEXPR("addExpr", 156, 1255, 5),
        ALIASANDVALUE("aliasAndValue", 79, 597, 4),
        ALLEXPR("allExpr", 111, 915, 11),
        ALLOPERATIONSINSCHEMA("allOperationsInSchema", 74, 569, 4),
        ALLOWENTITYREFERENCESPREFERENCE("allowEntityReferencesPreference", 324, 2235, 1),
        ALPHA("ALPHA", 387, 2729, 3),
        ANDEXPR("andExpr", 147, 1210, 5),
        ANNOTATIONIDENTIFIER("annotationIdentifier", 329, 2263, 11),
        ANNOTATIONINURI("annotationInUri", 171, 1378, 12),
        ANNOTATIONSLIST("annotationsList", 328, 2257, 6),
        ANYEXPR("anyExpr", 110, 902, 13),
        ARRAYOROBJECT("arrayOrObject", 165, 1314, 5),
        AT("AT", 340, 2314, 3),
        AUTHORITY("authority", 353, 2371, 10),
        BASE64B16("base64b16", 245, 1719, 22),
        BASE64B8("base64b8", 246, 1741, 9),
        BASE64CHAR("base64char", 247, 1750, 5),
        BEGIN_ARRAY("begin-array", 179, 1433, 6),
        BEGIN_OBJECT("begin-object", 177, 1421, 6),
        BINARY("binary", 243, 1706, 5),
        BINARYVALUE("binaryValue", 244, 1711, 8),
        BOOLCOMMONEXPR("boolCommonExpr", 93, 737, 21),
        BOOLEANVALUE("booleanValue", 248, 1755, 3),
        BOOLMETHODCALLEXPR("boolMethodCallExpr", 114, 954, 5),
        BOOLPARENEXPR("boolParenExpr", 145, 1198, 6),
        BOUNDACTIONCALL("boundActionCall", 23, 212, 4),
        BOUNDCOMPLEXCOLFUNCCALL("boundComplexColFuncCall", 27, 231, 5),
        BOUNDCOMPLEXFUNCCALL("boundComplexFuncCall", 26, 226, 5),
        BOUNDENTITYCOLFUNCCALL("boundEntityColFuncCall", 25, 221, 5),
        BOUNDENTITYFUNCCALL("boundEntityFuncCall", 24, 216, 5),
        BOUNDFUNCTIONEXPR("boundFunctionExpr", 106, 851, 1),
        BOUNDOPERATION("boundOperation", 21, 183, 28),
        BOUNDPRIMITIVECOLFUNCCALL("boundPrimitiveColFuncCall", 29, 241, 5),
        BOUNDPRIMITIVEFUNCCALL("boundPrimitiveFuncCall", 28, 236, 5),
        BWS("BWS", 339, 2313, 1),
        BYTEVALUE("byteValue", 254, 1799, 2),
        CALLBACKPREFERENCE("callbackPreference", 325, 2236, 12),
        CASTEXPR("castExpr", 164, 1301, 13),
        CEILINGMETHODCALLEXPR("ceilingMethodCallExpr", 141, 1162, 7),
        CHARINJSON("charInJSON", 186, 1467, 20),
        CLOSE("CLOSE", 349, 2340, 3),
        COLLECTIONLITERAL("collectionLiteral", 281, 2005, 8),
        COLLECTIONNAVIGATION("collectionNavigation", 5, 85, 7),
        COLLECTIONNAVIGATIONEXPR("collectionNavigationExpr", 101, 814, 11),
        COLLECTIONNAVPATH("collectionNavPath", 6, 92, 7),
        COLLECTIONNAVPROPINJSON("collectionNavPropInJSON", 175, 1405, 6),
        COLLECTIONPATH("collectionPath", 15, 164, 3),
        COLLECTIONPATHEXPR("collectionPathExpr", 103, 828, 11),
        COLLECTIONPROPERTYINURI("collectionPropertyInUri", 168, 1349, 13),
        COLON("COLON", 341, 2317, 3),
        COMMA("COMMA", 342, 2320, 3),
        COMMONEXPR("commonExpr", 92, 718, 19),
        COMPLEXCOLFUNCTION("complexColFunction", 231, 1639, 1),
        COMPLEXCOLFUNCTIONIMPORT("complexColFunctionImport", 237, 1645, 1),
        COMPLEXCOLFUNCTIONIMPORTCALL("complexColFunctionImportCall", 33, 255, 3),
        COMPLEXCOLINURI("complexColInUri", 166, 1319, 10),
        COMPLEXCOLPROPERTY("complexColProperty", 220, 1620, 1),
        COMPLEXFUNCTION("complexFunction", 230, 1638, 1),
        COMPLEXFUNCTIONIMPORT("complexFunctionImport", 236, 1644, 1),
        COMPLEXFUNCTIONIMPORTCALL("complexFunctionImportCall", 32, 252, 3),
        COMPLEXINURI("complexInUri", 167, 1329, 20),
        COMPLEXPATH("complexPath", 17, 170, 10),
        COMPLEXPATHEXPR("complexPathExpr", 104, 839, 9),
        COMPLEXPROPERTY("complexProperty", 219, 1619, 1),
        COMPLEXPROPERTYINURI("complexPropertyInUri", 170, 1372, 6),
        COMPLEXTYPENAME("complexTypeName", 204, 1562, 1),
        COMPOUNDKEY("compoundKey", 9, 106, 8),
        CONCATMETHODCALLEXPR("concatMethodCallExpr", 124, 1048, 11),
        CONCRETESPATIALTYPENAME("concreteSpatialTypeName", 214, 1605, 8),
        CONTAINMENTNAVIGATION("containmentNavigation", 87, 653, 16),
        CONTAINSMETHODCALLEXPR("containsMethodCallExpr", 115, 959, 11),
        CONTENT_ID("content-id", 317, 2190, 6),
        CONTEXT("context", 84, 616, 3),
        CONTEXTFRAGMENT("contextFragment", 85, 619, 26),
        CONTEXTPROPERTYPATH("contextPropertyPath", 91, 704, 14),
        CONTINUEONERRORPREFERENCE("continueOnErrorPreference", 326, 2248, 1),
        COUNT("count", 18, 180, 1),
        CROSSJOIN("crossjoin", 40, 284, 9),
        CUSTOMNAME("customName", 82, 610, 4),
        CUSTOMQUERYOPTION("customQueryOption", 81, 604, 6),
        CUSTOMVALUE("customValue", 83, 614, 2),
        DATEMETHODCALLEXPR("dateMethodCallExpr", 133, 1115, 7),
        DATETIMEOFFSETVALUE("dateTimeOffsetValue", 262, 1837, 25),
        DATEVALUE("dateValue", 261, 1831, 6),
        DAY("day", 270, 1952, 14),
        DAYMETHODCALLEXPR("dayMethodCallExpr", 127, 1073, 7),
        DEC_OCTET("dec-octet", 363, 2517, 16),
        DECIMALVALUE("decimalValue", 249, 1758, 10),
        DIGIT("DIGIT", 388, 2732, 1),
        DISTANCEMETHODCALLEXPR("distanceMethodCallExpr", 142, 1169, 11),
        DIVEXPR("divExpr", 159, 1270, 5),
        DOUBLEVALUE("doubleValue", 250, 1768, 11),
        DQUOTE("DQUOTE", 391, 2743, 1),
        DUMMYSTARTRULE("dummyStartRule", 0, 0, 4),
        DURATION("duration", 263, 1862, 5),
        DURATIONVALUE("durationValue", 264, 1867, 32),
        END_ARRAY("end-array", 180, 1439, 6),
        END_OBJECT("end-object", 178, 1427, 6),
        ENDSWITHMETHODCALLEXPR("endsWithMethodCallExpr", 117, 981, 11),
        ENTITYCASTOPTION("entityCastOption", 46, 326, 4),
        ENTITYCASTOPTIONS("entityCastOptions", 45, 316, 10),
        ENTITYCOLFUNCTION("entityColFunction", 229, 1637, 1),
        ENTITYCOLFUNCTIONIMPORT("entityColFunctionImport", 235, 1643, 1),
        ENTITYCOLFUNCTIONIMPORTCALL("entityColFunctionImportCall", 31, 249, 3),
        ENTITYCOLNAVIGATIONPROPERTY("entityColNavigationProperty", 224, 1626, 1),
        ENTITYFUNCTION("entityFunction", 228, 1636, 1),
        ENTITYFUNCTIONIMPORT("entityFunctionImport", 234, 1642, 1),
        ENTITYFUNCTIONIMPORTCALL("entityFunctionImportCall", 30, 246, 3),
        ENTITYIDOPTION("entityIdOption", 44, 313, 3),
        ENTITYNAVIGATIONPROPERTY("entityNavigationProperty", 223, 1625, 1),
        ENTITYOPTIONS("entityOptions", 43, 303, 10),
        ENTITYSET("entitySet", 86, 645, 8),
        ENTITYSETNAME("entitySetName", 201, 1559, 1),
        ENTITYTYPENAME("entityTypeName", 203, 1561, 1),
        ENUM("enum", 275, 1982, 5),
        ENUMERATIONMEMBER("enumerationMember", 207, 1565, 1),
        ENUMERATIONTYPENAME("enumerationTypeName", 206, 1564, 1),
        ENUMMEMBERVALUE("enumMemberValue", 278, 1996, 1),
        ENUMVALUE("enumValue", 276, 1987, 6),
        EQ("EQ", 343, 2323, 1),
        EQEXPR("eqExpr", 149, 1220, 5),
        ESCAPE("escape", 188, 1494, 3),
        EXCLUDEOPERATOR("excludeOperator", 330, 2274, 1),
        EXP("exp", 192, 1515, 8),
        EXPAND("expand", 49, 346, 8),
        EXPANDCOUNTOPTION("expandCountOption", 52, 418, 3),
        EXPANDITEM("expandItem", 50, 354, 44),
        EXPANDOPTION("expandOption", 54, 427, 5),
        EXPANDPATH("expandPath", 51, 398, 20),
        EXPANDREFOPTION("expandRefOption", 53, 421, 6),
        FILTER("filter", 56, 439, 4),
        FIRSTMEMBEREXPR("firstMemberExpr", 95, 767, 8),
        FLOORMETHODCALLEXPR("floorMethodCallExpr", 140, 1155, 7),
        FORMAT("format", 61, 469, 13),
        FRAC("frac", 191, 1511, 4),
        FRACTIONALSECONDS("fractionalSeconds", 274, 1980, 2),
        FRACTIONALSECONDSMETHODCALLEXPR("fractionalsecondsMethodCallExpr", 131, 1101, 7),
        FRAGMENT("fragment", 372, 2572, 5),
        FULLCOLLECTIONLITERAL("fullCollectionLiteral", 280, 2002, 3),
        FULLLINESTRINGLITERAL("fullLineStringLiteral", 284, 2026, 3),
        FULLMULTILINESTRINGLITERAL("fullMultiLineStringLiteral", 288, 2045, 3),
        FULLMULTIPOINTLITERAL("fullMultiPointLiteral", 291, 2063, 3),
        FULLMULTIPOLYGONLITERAL("fullMultiPolygonLiteral", 294, 2081, 3),
        FULLPOINTLITERAL("fullPointLiteral", 297, 2099, 3),
        FULLPOLYGONLITERAL("fullPolygonLiteral", 303, 2124, 3),
        FUNCTION("function", 227, 1629, 7),
        FUNCTIONEXPR("functionExpr", 107, 852, 34),
        FUNCTIONEXPRPARAMETER("functionExprParameter", 109, 896, 6),
        FUNCTIONEXPRPARAMETERS("functionExprParameters", 108, 886, 10),
        FUNCTIONPARAMETER("functionParameter", 37, 274, 6),
        FUNCTIONPARAMETERS("functionParameters", 36, 264, 10),
        GEEXPR("geExpr", 154, 1245, 5),
        GEOGRAPHYCOLLECTION("geographyCollection", 279, 1997, 5),
        GEOGRAPHYLINESTRING("geographyLineString", 283, 2021, 5),
        GEOGRAPHYMULTILINESTRING("geographyMultiLineString", 287, 2040, 5),
        GEOGRAPHYMULTIPOINT("geographyMultiPoint", 290, 2058, 5),
        GEOGRAPHYMULTIPOLYGON("geographyMultiPolygon", 293, 2076, 5),
        GEOGRAPHYPOINT("geographyPoint", 296, 2094, 5),
        GEOGRAPHYPOLYGON("geographyPolygon", 302, 2119, 5),
        GEOGRAPHYPREFIX("geographyPrefix", 314, 2181, 1),
        GEOLENGTHMETHODCALLEXPR("geoLengthMethodCallExpr", 143, 1180, 7),
        GEOLITERAL("geoLiteral", 282, 2013, 8),
        GEOMETRYCOLLECTION("geometryCollection", 307, 2146, 5),
        GEOMETRYLINESTRING("geometryLineString", 308, 2151, 5),
        GEOMETRYMULTILINESTRING("geometryMultiLineString", 309, 2156, 5),
        GEOMETRYMULTIPOINT("geometryMultiPoint", 310, 2161, 5),
        GEOMETRYMULTIPOLYGON("geometryMultiPolygon", 311, 2166, 5),
        GEOMETRYPOINT("geometryPoint", 312, 2171, 5),
        GEOMETRYPOLYGON("geometryPolygon", 313, 2176, 5),
        GEOMETRYPREFIX("geometryPrefix", 315, 2182, 1),
        GTEXPR("gtExpr", 153, 1240, 5),
        GUIDVALUE("guidValue", 253, 1784, 15),
        H16("h16", 360, 2501, 2),
        HASEXPR("hasExpr", 155, 1250, 5),
        HEADER("header", 316, 2183, 7),
        HEXDIG("HEXDIG", 389, 2733, 3),
        HIER_PART("hier-part", 351, 2355, 7),
        HOST("host", 355, 2387, 4),
        HOUR("hour", 271, 1966, 12),
        HOURMETHODCALLEXPR("hourMethodCallExpr", 128, 1080, 7),
        HTAB("HTAB", 393, 2745, 1),
        ID("id", 47, 330, 4),
        IDENTIFIERCHARACTER("identifierCharacter", 211, 1574, 4),
        IDENTIFIERLEADINGCHARACTER("identifierLeadingCharacter", 210, 1571, 3),
        IMPLICITVARIABLEEXPR("implicitVariableExpr", 99, 812, 1),
        INCLUDEANNOTATIONSPREFERENCE("includeAnnotationsPreference", 327, 2249, 8),
        INDEXOFMETHODCALLEXPR("indexOfMethodCallExpr", 119, 999, 11),
        INLINECOUNT("inlinecount", 62, 482, 4),
        INSCOPEVARIABLEEXPR("inscopeVariableExpr", 98, 809, 3),
        INT("int", 190, 1505, 6),
        INT16VALUE("int16Value", 256, 1806, 5),
        INT32VALUE("int32Value", 257, 1811, 5),
        INT64VALUE("int64Value", 258, 1816, 5),
        INTERSECTSMETHODCALLEXPR("intersectsMethodCallExpr", 144, 1187, 11),
        IP_LITERAL("IP-literal", 357, 2393, 6),
        IPV4ADDRESS("IPv4address", 362, 2509, 8),
        IPV6ADDRESS("IPv6address", 359, 2409, 92),
        IPVFUTURE("IPvFuture", 358, 2399, 10),
        IRI_IN_HEADER("IRI-in-header", 385, 2723, 4),
        IRI_IN_QUERY("IRI-in-query", 386, 2727, 2),
        ISOFEXPR("isofExpr", 163, 1288, 13),
        KEYPREDICATE("keyPredicate", 7, 99, 3),
        KEYPROPERTYALIAS("keyPropertyAlias", 12, 121, 1),
        KEYPROPERTYVALUE("keyPropertyValue", 11, 120, 1),
        KEYVALUEPAIR("keyValuePair", 10, 114, 6),
        LAMBDAPREDICATEEXPR("lambdaPredicateExpr", 112, 926, 1),
        LAMBDAVARIABLEEXPR("lambdaVariableExpr", 100, 813, 1),
        LEEXPR("leExpr", 152, 1235, 5),
        LENGTHMETHODCALLEXPR("lengthMethodCallExpr", 118, 992, 7),
        LEVELS("levels", 55, 432, 7),
        LINESTRINGDATA("lineStringData", 286, 2032, 8),
        LINESTRINGLITERAL("lineStringLiteral", 285, 2029, 3),
        LS32("ls32", 361, 2503, 6),
        LTEXPR("ltExpr", 151, 1230, 5),
        MAXDATETIMEMETHODCALLEXPR("maxDateTimeMethodCallExpr", 137, 1140, 4),
        MAXPAGESIZEPREFERENCE("maxpagesizePreference", 331, 2275, 8),
        MEMBEREXPR("memberExpr", 96, 775, 8),
        METHODCALLEXPR("methodCallExpr", 113, 927, 27),
        MINDATETIMEMETHODCALLEXPR("minDateTimeMethodCallExpr", 136, 1136, 4),
        MINUTE("minute", 272, 1978, 1),
        MINUTEMETHODCALLEXPR("minuteMethodCallExpr", 129, 1087, 7),
        MODEXPR("modExpr", 160, 1275, 5),
        MONTH("month", 269, 1942, 10),
        MONTHMETHODCALLEXPR("monthMethodCallExpr", 126, 1066, 7),
        MULEXPR("mulExpr", 158, 1265, 5),
        MULTILINESTRINGLITERAL("multiLineStringLiteral", 289, 2048, 10),
        MULTIPOINTLITERAL("multiPointLiteral", 292, 2066, 10),
        MULTIPOLYGONLITERAL("multiPolygonLiteral", 295, 2084, 10),
        NAME_SEPARATOR("name-separator", 182, 1448, 4),
        NAMESPACE("namespace", 199, 1552, 6),
        NAMESPACEPART("namespacePart", 200, 1558, 1),
        NANINFINITY("nanInfinity", 252, 1780, 4),
        NAVIGATIONPROPERTY("navigationProperty", 222, 1622, 3),
        NAVIGATIONPROPERTYINURI("navigationPropertyInUri", 173, 1396, 3),
        NEEXPR("neExpr", 150, 1225, 5),
        NEGATEEXPR("negateExpr", 161, 1280, 4),
        NOTEXPR("notExpr", 162, 1284, 4),
        NOWMETHODCALLEXPR("nowMethodCallExpr", 138, 1144, 4),
        NULLVALUE("nullValue", 242, 1705, 1),
        NUMBERINJSON("numberInJSON", 189, 1497, 8),
        OBS_TEXT("obs-text", 336, 2300, 1),
        ODATA_ENTITYID("odata-entityid", 318, 2196, 5),
        ODATA_ISOLATION("odata-isolation", 319, 2201, 5),
        ODATA_MAXVERSION("odata-maxversion", 320, 2206, 5),
        ODATA_VERSION("odata-version", 321, 2211, 5),
        ODATAIDENTIFIER("odataIdentifier", 209, 1567, 4),
        ODATARELATIVEURI("odataRelativeUri", 3, 23, 26),
        ODATAURI("odataUri", 1, 4, 4),
        ONETONINE("oneToNine", 266, 1911, 10),
        OPEN("OPEN", 348, 2337, 3),
        ORDERBY("orderby", 57, 443, 8),
        ORDERBYITEM("orderbyItem", 58, 451, 8),
        OREXPR("orExpr", 148, 1215, 5),
        OTHER_DELIMS("other-delims", 376, 2594, 8),
        OWS("OWS", 337, 2301, 6),
        PARAMETERALIAS("parameterAlias", 39, 281, 3),
        PARAMETERNAME("parameterName", 38, 280, 1),
        PARAMETERNAMES("parameterNames", 77, 586, 6),
        PARAMETERVALUE("parameterValue", 80, 601, 3),
        PARENEXPR("parenExpr", 146, 1204, 6),
        PATH_ABEMPTY("path-abempty", 365, 2538, 4),
        PATH_ABSOLUTE("path-absolute", 366, 2542, 9),
        PATH_ROOTLESS("path-rootless", 367, 2551, 6),
        PCHAR("pchar", 370, 2561, 6),
        PCHAR_NO_SQUOTE("pchar-no-SQUOTE", 377, 2602, 9),
        PCT_ENCODED("pct-encoded", 373, 2577, 4),
        PCT_ENCODED_NO_SQUOTE("pct-encoded-no-SQUOTE", 378, 2611, 28),
        PCT_ENCODED_UNESCAPED("pct-encoded-unescaped", 383, 2679, 37),
        POINTDATA("pointData", 300, 2111, 4),
        POINTLITERAL("pointLiteral", 299, 2108, 3),
        POLYGONDATA("polygonData", 305, 2130, 8),
        POLYGONLITERAL("polygonLiteral", 304, 2127, 3),
        PORT("port", 356, 2391, 2),
        POSITIONLITERAL("positionLiteral", 301, 2115, 4),
        PREFER("prefer", 322, 2216, 9),
        PREFERENCE("preference", 323, 2225, 10),
        PRIMITIVECOLFUNCTION("primitiveColFunction", 233, 1641, 1),
        PRIMITIVECOLFUNCTIONIMPORT("primitiveColFunctionImport", 239, 1647, 1),
        PRIMITIVECOLFUNCTIONIMPORTCALL("primitiveColFunctionImportCall", 35, 261, 3),
        PRIMITIVECOLINURI("primitiveColInUri", 169, 1362, 10),
        PRIMITIVECOLPROPERTY("primitiveColProperty", 218, 1618, 1),
        PRIMITIVEFUNCTION("primitiveFunction", 232, 1640, 1),
        PRIMITIVEFUNCTIONIMPORT("primitiveFunctionImport", 238, 1646, 1),
        PRIMITIVEFUNCTIONIMPORTCALL("primitiveFunctionImportCall", 34, 258, 3),
        PRIMITIVEKEYPROPERTY("primitiveKeyProperty", 216, 1616, 1),
        PRIMITIVELITERAL("primitiveLiteral", 240, 1648, 33),
        PRIMITIVELITERALINJSON("primitiveLiteralInJSON", 184, 1456, 6),
        PRIMITIVENONKEYPROPERTY("primitiveNonKeyProperty", 217, 1617, 1),
        PRIMITIVEPROPERTY("primitiveProperty", 215, 1613, 3),
        PRIMITIVEPROPERTYINURI("primitivePropertyInUri", 172, 1390, 6),
        PRIMITIVETYPENAME("primitiveTypeName", 212, 1578, 24),
        PRIMITIVEVALUE("primitiveValue", 241, 1681, 24),
        PROPERTYPATH("propertyPath", 14, 135, 29),
        PROPERTYPATHEXPR("propertyPathExpr", 97, 783, 26),
        QCHAR_JSON_SPECIAL("qchar-JSON-special", 187, 1487, 7),
        QCHAR_NO_AMP("qchar-no-AMP", 379, 2639, 11),
        QCHAR_NO_AMP_DQUOTE("qchar-no-AMP-DQUOTE", 384, 2716, 7),
        QCHAR_NO_AMP_EQ("qchar-no-AMP-EQ", 380, 2650, 10),
        QCHAR_NO_AMP_EQ_AT_DOLLAR("qchar-no-AMP-EQ-AT-DOLLAR", 381, 2660, 8),
        QCHAR_UNESCAPED("qchar-unescaped", 382, 2668, 11),
        QUALIFIEDACTIONNAME("qualifiedActionName", 75, 573, 4),
        QUALIFIEDCOMPLEXTYPENAME("qualifiedComplexTypeName", 196, 1540, 4),
        QUALIFIEDENTITYTYPENAME("qualifiedEntityTypeName", 195, 1536, 4),
        QUALIFIEDENUMTYPENAME("qualifiedEnumTypeName", 198, 1548, 4),
        QUALIFIEDFUNCTIONNAME("qualifiedFunctionName", 76, 577, 9),
        QUALIFIEDTYPEDEFINITIONNAME("qualifiedTypeDefinitionName", 197, 1544, 4),
        QUALIFIEDTYPENAME("qualifiedTypeName", 194, 1529, 7),
        QUERY("query", 371, 2567, 5),
        QUERYOPTION("queryOption", 42, 299, 4),
        QUERYOPTIONS("queryOptions", 41, 293, 6),
        QUOTATION_MARK("quotation-mark", 181, 1445, 3),
        REF("ref", 19, 181, 1),
        REG_NAME("reg-name", 364, 2533, 5),
        RESOURCEPATH("resourcePath", 4, 49, 36),
        RESPONDASYNCPREFERENCE("respondAsyncPreference", 332, 2283, 1),
        RETURNPREFERENCE("returnPreference", 333, 2284, 8),
        RINGLITERAL("ringLiteral", 306, 2138, 8),
        ROOTEXPR("rootExpr", 94, 758, 9),
        ROOTEXPRCOL("rootExprCol", 176, 1411, 10),
        ROUNDMETHODCALLEXPR("roundMethodCallExpr", 139, 1148, 7),
        RWS("RWS", 338, 2307, 6),
        SBYTEVALUE("sbyteValue", 255, 1801, 5),
        SCHEME("scheme", 352, 2362, 9),
        SEARCH("search", 63, 486, 5),
        SEARCHANDEXPR("searchAndExpr", 66, 509, 7),
        SEARCHEXPR("searchExpr", 64, 491, 13),
        SEARCHOREXPR("searchOrExpr", 65, 504, 5),
        SEARCHPHRASE("searchPhrase", 68, 524, 5),
        SEARCHTERM("searchTerm", 67, 516, 8),
        SEARCHWORD("searchWord", 69, 529, 2),
        SECOND("second", 273, 1979, 1),
        SECONDMETHODCALLEXPR("secondMethodCallExpr", 130, 1094, 7),
        SEGMENT("segment", 368, 2557, 2),
        SEGMENT_NZ("segment-nz", 369, 2559, 2),
        SELECT("select", 70, 531, 8),
        SELECTITEM("selectItem", 71, 539, 12),
        SELECTLIST("selectList", 88, 669, 8),
        SELECTLISTITEM("selectListItem", 89, 677, 12),
        SELECTLISTPROPERTY("selectListProperty", 90, 689, 15),
        SELECTPATH("selectPath", 73, 561, 8),
        SELECTPROPERTY("selectProperty", 72, 551, 10),
        SEMI("SEMI", 345, 2328, 3),
        SERVICEROOT("serviceRoot", 2, 8, 15),
        SIGN("SIGN", 344, 2324, 4),
        SIMPLEKEY("simpleKey", 8, 102, 4),
        SINGLEENUMVALUE("singleEnumValue", 277, 1993, 3),
        SINGLENAVIGATION("singleNavigation", 13, 122, 13),
        SINGLENAVIGATIONEXPR("singleNavigationExpr", 102, 825, 3),
        SINGLENAVPROPINJSON("singleNavPropInJSON", 174, 1399, 6),
        SINGLEPATH("singlePath", 16, 167, 3),
        SINGLEPATHEXPR("singlePathExpr", 105, 848, 3),
        SINGLEQUALIFIEDTYPENAME("singleQualifiedTypeName", 193, 1523, 6),
        SINGLETONENTITY("singletonEntity", 202, 1560, 1),
        SINGLEVALUE("singleValue", 251, 1779, 1),
        SKIP("skip", 59, 459, 5),
        SKIPTOKEN("skiptoken", 78, 592, 5),
        SP("SP", 392, 2744, 1),
        SQUOTE("SQUOTE", 347, 2334, 3),
        SQUOTE_IN_STRING("SQUOTE-in-string", 260, 1828, 3),
        SRIDLITERAL("sridLiteral", 298, 2102, 6),
        STAR("STAR", 346, 2331, 3),
        STARTSWITHMETHODCALLEXPR("startsWithMethodCallExpr", 116, 970, 11),
        STREAMPROPERTY("streamProperty", 221, 1621, 1),
        STRING("string", 259, 1821, 7),
        STRINGINJSON("stringInJSON", 185, 1462, 5),
        SUB_DELIMS("sub-delims", 375, 2588, 6),
        SUBEXPR("subExpr", 157, 1260, 5),
        SUBSTRINGMETHODCALLEXPR("substringMethodCallExpr", 120, 1010, 17),
        SYSTEMQUERYOPTION("systemQueryOption", 48, 334, 12),
        TERMNAME("termName", 208, 1566, 1),
        TIMEMETHODCALLEXPR("timeMethodCallExpr", 134, 1122, 7),
        TIMEOFDAYVALUE("timeOfDayValue", 265, 1899, 12),
        TOLOWERMETHODCALLEXPR("toLowerMethodCallExpr", 121, 1027, 7),
        TOP("top", 60, 464, 5),
        TOTALOFFSETMINUTESMETHODCALLEXPR("totalOffsetMinutesMethodCallExpr", 135, 1129, 7),
        TOTALSECONDSMETHODCALLEXPR("totalsecondsMethodCallExpr", 132, 1108, 7),
        TOUPPERMETHODCALLEXPR("toUpperMethodCallExpr", 122, 1034, 7),
        TRACKCHANGESPREFERENCE("trackChangesPreference", 334, 2292, 1),
        TRIMMETHODCALLEXPR("trimMethodCallExpr", 123, 1041, 7),
        TYPEDEFINITIONNAME("typeDefinitionName", 205, 1563, 1),
        UNRESERVED("unreserved", 374, 2581, 7),
        URI("URI", 350, 2343, 12),
        USERINFO("userinfo", 354, 2381, 6),
        VALUE("value", 20, 182, 1),
        VALUE_SEPARATOR("value-separator", 183, 1452, 4),
        VCHAR("VCHAR", 394, 2746, 1),
        WAITPREFERENCE("waitPreference", 335, 2293, 7),
        YEAR("year", 268, 1930, 12),
        YEARMETHODCALLEXPR("yearMethodCallExpr", 125, 1059, 7),
        ZEROTOFIFTYNINE("zeroToFiftyNine", 267, 1921, 9);
        private String name;
        private int id;
        private int offset;
        private int count;
        RuleNames(String string, int id, int offset, int count){
            this.name = string;
            this.id = id;
            this.offset = offset;
            this.count = count;
        }
        public  String ruleName(){return name;}
        public  int    ruleID(){return id;}
        private int    opcodeOffset(){return offset;}
        private int    opcodeCount(){return count;}
    }

    // UDT name enum
    public static int udtCount = 0;
    public enum UdtNames{
    }

    // private
    private static ODataParser factoryInstance = null;
    private ODataParser(Rule[] rules, Udt[] udts, Opcode[] opcodes){
        super(rules, udts, opcodes);
    }

    private static Rule[] getRules(){
    	Rule[] rules = new Rule[395];
        for(RuleNames r : RuleNames.values()){
            rules[r.ruleID()] = getRule(r.ruleID(), r.ruleName(), r.opcodeOffset(), r.opcodeCount());
        }
        return rules;
    }

    private static Udt[] getUdts(){
    	Udt[] udts = new Udt[0];
        return udts;
    }

        // opcodes
    private static Opcode[] getOpcodes(){
    	Opcode[] op = new Opcode[2747];
        {int[] a = {1,2,3}; op[0] = getOpcodeAlt(a);}
        op[1] = getOpcodeRnm(1, 4); // odataUri
        op[2] = getOpcodeRnm(316, 2183); // header
        op[3] = getOpcodeRnm(241, 1681); // primitiveValue
        {int[] a = {5,6}; op[4] = getOpcodeCat(a);}
        op[5] = getOpcodeRnm(2, 8); // serviceRoot
        op[6] = getOpcodeRep((char)0, (char)1, 7);
        op[7] = getOpcodeRnm(3, 23); // odataRelativeUri
        {int[] a = {9,12,13,14,18,19}; op[8] = getOpcodeCat(a);}
        {int[] a = {10,11}; op[9] = getOpcodeAlt(a);}
        {char[] a = {104,116,116,112,115}; op[10] = getOpcodeTls(a);}
        {char[] a = {104,116,116,112}; op[11] = getOpcodeTls(a);}
        {char[] a = {58,47,47}; op[12] = getOpcodeTls(a);}
        op[13] = getOpcodeRnm(355, 2387); // host
        op[14] = getOpcodeRep((char)0, (char)1, 15);
        {int[] a = {16,17}; op[15] = getOpcodeCat(a);}
        {char[] a = {58}; op[16] = getOpcodeTls(a);}
        op[17] = getOpcodeRnm(356, 2391); // port
        {char[] a = {47}; op[18] = getOpcodeTls(a);}
        op[19] = getOpcodeRep((char)0, Character.MAX_VALUE, 20);
        {int[] a = {21,22}; op[20] = getOpcodeCat(a);}
        op[21] = getOpcodeRnm(369, 2559); // segment-nz
        {char[] a = {47}; op[22] = getOpcodeTls(a);}
        {int[] a = {24,25,29,35,43}; op[23] = getOpcodeAlt(a);}
        {char[] a = {36,98,97,116,99,104}; op[24] = getOpcodeTbs(a);}
        {int[] a = {26,27,28}; op[25] = getOpcodeCat(a);}
        {char[] a = {36,101,110,116,105,116,121}; op[26] = getOpcodeTbs(a);}
        {char[] a = {63}; op[27] = getOpcodeTls(a);}
        op[28] = getOpcodeRnm(43, 303); // entityOptions
        {int[] a = {30,31,32,33,34}; op[29] = getOpcodeCat(a);}
        {char[] a = {36,101,110,116,105,116,121}; op[30] = getOpcodeTbs(a);}
        {char[] a = {47}; op[31] = getOpcodeTls(a);}
        op[32] = getOpcodeRnm(195, 1536); // qualifiedEntityTypeName
        {char[] a = {63}; op[33] = getOpcodeTls(a);}
        op[34] = getOpcodeRnm(45, 316); // entityCastOptions
        {int[] a = {36,37,41}; op[35] = getOpcodeCat(a);}
        {char[] a = {36,109,101,116,97,100,97,116,97}; op[36] = getOpcodeTbs(a);}
        op[37] = getOpcodeRep((char)0, (char)1, 38);
        {int[] a = {39,40}; op[38] = getOpcodeCat(a);}
        {char[] a = {63}; op[39] = getOpcodeTls(a);}
        op[40] = getOpcodeRnm(61, 469); // format
        op[41] = getOpcodeRep((char)0, (char)1, 42);
        op[42] = getOpcodeRnm(84, 616); // context
        {int[] a = {44,45}; op[43] = getOpcodeCat(a);}
        op[44] = getOpcodeRnm(4, 49); // resourcePath
        op[45] = getOpcodeRep((char)0, (char)1, 46);
        {int[] a = {47,48}; op[46] = getOpcodeCat(a);}
        {char[] a = {63}; op[47] = getOpcodeTls(a);}
        op[48] = getOpcodeRnm(41, 293); // queryOptions
        {int[] a = {50,54,58,59,63,67,71,75,79,83,84}; op[49] = getOpcodeAlt(a);}
        {int[] a = {51,52}; op[50] = getOpcodeCat(a);}
        op[51] = getOpcodeRnm(201, 1559); // entitySetName
        op[52] = getOpcodeRep((char)0, (char)1, 53);
        op[53] = getOpcodeRnm(5, 85); // collectionNavigation
        {int[] a = {55,56}; op[54] = getOpcodeCat(a);}
        op[55] = getOpcodeRnm(202, 1560); // singletonEntity
        op[56] = getOpcodeRep((char)0, (char)1, 57);
        op[57] = getOpcodeRnm(13, 122); // singleNavigation
        op[58] = getOpcodeRnm(22, 211); // actionImportCall
        {int[] a = {60,61}; op[59] = getOpcodeCat(a);}
        op[60] = getOpcodeRnm(31, 249); // entityColFunctionImportCall
        op[61] = getOpcodeRep((char)0, (char)1, 62);
        op[62] = getOpcodeRnm(5, 85); // collectionNavigation
        {int[] a = {64,65}; op[63] = getOpcodeCat(a);}
        op[64] = getOpcodeRnm(30, 246); // entityFunctionImportCall
        op[65] = getOpcodeRep((char)0, (char)1, 66);
        op[66] = getOpcodeRnm(13, 122); // singleNavigation
        {int[] a = {68,69}; op[67] = getOpcodeCat(a);}
        op[68] = getOpcodeRnm(33, 255); // complexColFunctionImportCall
        op[69] = getOpcodeRep((char)0, (char)1, 70);
        op[70] = getOpcodeRnm(15, 164); // collectionPath
        {int[] a = {72,73}; op[71] = getOpcodeCat(a);}
        op[72] = getOpcodeRnm(32, 252); // complexFunctionImportCall
        op[73] = getOpcodeRep((char)0, (char)1, 74);
        op[74] = getOpcodeRnm(17, 170); // complexPath
        {int[] a = {76,77}; op[75] = getOpcodeCat(a);}
        op[76] = getOpcodeRnm(35, 261); // primitiveColFunctionImportCall
        op[77] = getOpcodeRep((char)0, (char)1, 78);
        op[78] = getOpcodeRnm(15, 164); // collectionPath
        {int[] a = {80,81}; op[79] = getOpcodeCat(a);}
        op[80] = getOpcodeRnm(34, 258); // primitiveFunctionImportCall
        op[81] = getOpcodeRep((char)0, (char)1, 82);
        op[82] = getOpcodeRnm(16, 167); // singlePath
        op[83] = getOpcodeRnm(40, 284); // crossjoin
        {char[] a = {36,97,108,108}; op[84] = getOpcodeTbs(a);}
        {int[] a = {86,90}; op[85] = getOpcodeCat(a);}
        op[86] = getOpcodeRep((char)0, (char)1, 87);
        {int[] a = {88,89}; op[87] = getOpcodeCat(a);}
        {char[] a = {47}; op[88] = getOpcodeTls(a);}
        op[89] = getOpcodeRnm(195, 1536); // qualifiedEntityTypeName
        op[90] = getOpcodeRep((char)0, (char)1, 91);
        op[91] = getOpcodeRnm(6, 92); // collectionNavPath
        {int[] a = {93,97,98}; op[92] = getOpcodeAlt(a);}
        {int[] a = {94,95}; op[93] = getOpcodeCat(a);}
        op[94] = getOpcodeRnm(7, 99); // keyPredicate
        op[95] = getOpcodeRep((char)0, (char)1, 96);
        op[96] = getOpcodeRnm(13, 122); // singleNavigation
        op[97] = getOpcodeRnm(15, 164); // collectionPath
        op[98] = getOpcodeRnm(19, 181); // ref
        {int[] a = {100,101}; op[99] = getOpcodeAlt(a);}
        op[100] = getOpcodeRnm(8, 102); // simpleKey
        op[101] = getOpcodeRnm(9, 106); // compoundKey
        {int[] a = {103,104,105}; op[102] = getOpcodeCat(a);}
        op[103] = getOpcodeRnm(348, 2337); // OPEN
        op[104] = getOpcodeRnm(11, 120); // keyPropertyValue
        op[105] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {107,108,109,113}; op[106] = getOpcodeCat(a);}
        op[107] = getOpcodeRnm(348, 2337); // OPEN
        op[108] = getOpcodeRnm(10, 114); // keyValuePair
        op[109] = getOpcodeRep((char)0, Character.MAX_VALUE, 110);
        {int[] a = {111,112}; op[110] = getOpcodeCat(a);}
        op[111] = getOpcodeRnm(342, 2320); // COMMA
        op[112] = getOpcodeRnm(10, 114); // keyValuePair
        op[113] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {115,118,119}; op[114] = getOpcodeCat(a);}
        {int[] a = {116,117}; op[115] = getOpcodeAlt(a);}
        op[116] = getOpcodeRnm(216, 1616); // primitiveKeyProperty
        op[117] = getOpcodeRnm(12, 121); // keyPropertyAlias
        op[118] = getOpcodeRnm(343, 2323); // EQ
        op[119] = getOpcodeRnm(11, 120); // keyPropertyValue
        op[120] = getOpcodeRnm(240, 1648); // primitiveLiteral
        op[121] = getOpcodeRnm(209, 1567); // odataIdentifier
        {int[] a = {123,127}; op[122] = getOpcodeCat(a);}
        op[123] = getOpcodeRep((char)0, (char)1, 124);
        {int[] a = {125,126}; op[124] = getOpcodeCat(a);}
        {char[] a = {47}; op[125] = getOpcodeTls(a);}
        op[126] = getOpcodeRnm(195, 1536); // qualifiedEntityTypeName
        op[127] = getOpcodeRep((char)0, (char)1, 128);
        {int[] a = {129,132,133,134}; op[128] = getOpcodeAlt(a);}
        {int[] a = {130,131}; op[129] = getOpcodeCat(a);}
        {char[] a = {47}; op[130] = getOpcodeTls(a);}
        op[131] = getOpcodeRnm(14, 135); // propertyPath
        op[132] = getOpcodeRnm(21, 183); // boundOperation
        op[133] = getOpcodeRnm(19, 181); // ref
        op[134] = getOpcodeRnm(20, 182); // value
        {int[] a = {136,140,144,148,152,156,160}; op[135] = getOpcodeAlt(a);}
        {int[] a = {137,138}; op[136] = getOpcodeCat(a);}
        op[137] = getOpcodeRnm(224, 1626); // entityColNavigationProperty
        op[138] = getOpcodeRep((char)0, (char)1, 139);
        op[139] = getOpcodeRnm(5, 85); // collectionNavigation
        {int[] a = {141,142}; op[140] = getOpcodeCat(a);}
        op[141] = getOpcodeRnm(223, 1625); // entityNavigationProperty
        op[142] = getOpcodeRep((char)0, (char)1, 143);
        op[143] = getOpcodeRnm(13, 122); // singleNavigation
        {int[] a = {145,146}; op[144] = getOpcodeCat(a);}
        op[145] = getOpcodeRnm(220, 1620); // complexColProperty
        op[146] = getOpcodeRep((char)0, (char)1, 147);
        op[147] = getOpcodeRnm(15, 164); // collectionPath
        {int[] a = {149,150}; op[148] = getOpcodeCat(a);}
        op[149] = getOpcodeRnm(219, 1619); // complexProperty
        op[150] = getOpcodeRep((char)0, (char)1, 151);
        op[151] = getOpcodeRnm(17, 170); // complexPath
        {int[] a = {153,154}; op[152] = getOpcodeCat(a);}
        op[153] = getOpcodeRnm(218, 1618); // primitiveColProperty
        op[154] = getOpcodeRep((char)0, (char)1, 155);
        op[155] = getOpcodeRnm(15, 164); // collectionPath
        {int[] a = {157,158}; op[156] = getOpcodeCat(a);}
        op[157] = getOpcodeRnm(215, 1613); // primitiveProperty
        op[158] = getOpcodeRep((char)0, (char)1, 159);
        op[159] = getOpcodeRnm(16, 167); // singlePath
        {int[] a = {161,162}; op[160] = getOpcodeCat(a);}
        op[161] = getOpcodeRnm(221, 1621); // streamProperty
        op[162] = getOpcodeRep((char)0, (char)1, 163);
        op[163] = getOpcodeRnm(21, 183); // boundOperation
        {int[] a = {165,166}; op[164] = getOpcodeAlt(a);}
        op[165] = getOpcodeRnm(18, 180); // count
        op[166] = getOpcodeRnm(21, 183); // boundOperation
        {int[] a = {168,169}; op[167] = getOpcodeAlt(a);}
        op[168] = getOpcodeRnm(20, 182); // value
        op[169] = getOpcodeRnm(21, 183); // boundOperation
        {int[] a = {171,175}; op[170] = getOpcodeCat(a);}
        op[171] = getOpcodeRep((char)0, (char)1, 172);
        {int[] a = {173,174}; op[172] = getOpcodeCat(a);}
        {char[] a = {47}; op[173] = getOpcodeTls(a);}
        op[174] = getOpcodeRnm(196, 1540); // qualifiedComplexTypeName
        {int[] a = {176,179}; op[175] = getOpcodeAlt(a);}
        {int[] a = {177,178}; op[176] = getOpcodeCat(a);}
        {char[] a = {47}; op[177] = getOpcodeTls(a);}
        op[178] = getOpcodeRnm(14, 135); // propertyPath
        op[179] = getOpcodeRnm(21, 183); // boundOperation
        {char[] a = {47,36,99,111,117,110,116}; op[180] = getOpcodeTbs(a);}
        {char[] a = {47,36,114,101,102}; op[181] = getOpcodeTbs(a);}
        {char[] a = {47,36,118,97,108,117,101}; op[182] = getOpcodeTbs(a);}
        {int[] a = {184,185}; op[183] = getOpcodeCat(a);}
        {char[] a = {47}; op[184] = getOpcodeTls(a);}
        {int[] a = {186,187,191,195,199,203,207}; op[185] = getOpcodeAlt(a);}
        op[186] = getOpcodeRnm(23, 212); // boundActionCall
        {int[] a = {188,189}; op[187] = getOpcodeCat(a);}
        op[188] = getOpcodeRnm(25, 221); // boundEntityColFuncCall
        op[189] = getOpcodeRep((char)0, (char)1, 190);
        op[190] = getOpcodeRnm(5, 85); // collectionNavigation
        {int[] a = {192,193}; op[191] = getOpcodeCat(a);}
        op[192] = getOpcodeRnm(24, 216); // boundEntityFuncCall
        op[193] = getOpcodeRep((char)0, (char)1, 194);
        op[194] = getOpcodeRnm(13, 122); // singleNavigation
        {int[] a = {196,197}; op[195] = getOpcodeCat(a);}
        op[196] = getOpcodeRnm(27, 231); // boundComplexColFuncCall
        op[197] = getOpcodeRep((char)0, (char)1, 198);
        op[198] = getOpcodeRnm(15, 164); // collectionPath
        {int[] a = {200,201}; op[199] = getOpcodeCat(a);}
        op[200] = getOpcodeRnm(26, 226); // boundComplexFuncCall
        op[201] = getOpcodeRep((char)0, (char)1, 202);
        op[202] = getOpcodeRnm(17, 170); // complexPath
        {int[] a = {204,205}; op[203] = getOpcodeCat(a);}
        op[204] = getOpcodeRnm(29, 241); // boundPrimitiveColFuncCall
        op[205] = getOpcodeRep((char)0, (char)1, 206);
        op[206] = getOpcodeRnm(15, 164); // collectionPath
        {int[] a = {208,209}; op[207] = getOpcodeCat(a);}
        op[208] = getOpcodeRnm(28, 236); // boundPrimitiveFuncCall
        op[209] = getOpcodeRep((char)0, (char)1, 210);
        op[210] = getOpcodeRnm(16, 167); // singlePath
        op[211] = getOpcodeRnm(226, 1628); // actionImport
        {int[] a = {213,214,215}; op[212] = getOpcodeCat(a);}
        op[213] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[214] = getOpcodeTls(a);}
        op[215] = getOpcodeRnm(225, 1627); // action
        {int[] a = {217,218,219,220}; op[216] = getOpcodeCat(a);}
        op[217] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[218] = getOpcodeTls(a);}
        op[219] = getOpcodeRnm(228, 1636); // entityFunction
        op[220] = getOpcodeRnm(36, 264); // functionParameters
        {int[] a = {222,223,224,225}; op[221] = getOpcodeCat(a);}
        op[222] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[223] = getOpcodeTls(a);}
        op[224] = getOpcodeRnm(229, 1637); // entityColFunction
        op[225] = getOpcodeRnm(36, 264); // functionParameters
        {int[] a = {227,228,229,230}; op[226] = getOpcodeCat(a);}
        op[227] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[228] = getOpcodeTls(a);}
        op[229] = getOpcodeRnm(230, 1638); // complexFunction
        op[230] = getOpcodeRnm(36, 264); // functionParameters
        {int[] a = {232,233,234,235}; op[231] = getOpcodeCat(a);}
        op[232] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[233] = getOpcodeTls(a);}
        op[234] = getOpcodeRnm(231, 1639); // complexColFunction
        op[235] = getOpcodeRnm(36, 264); // functionParameters
        {int[] a = {237,238,239,240}; op[236] = getOpcodeCat(a);}
        op[237] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[238] = getOpcodeTls(a);}
        op[239] = getOpcodeRnm(232, 1640); // primitiveFunction
        op[240] = getOpcodeRnm(36, 264); // functionParameters
        {int[] a = {242,243,244,245}; op[241] = getOpcodeCat(a);}
        op[242] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[243] = getOpcodeTls(a);}
        op[244] = getOpcodeRnm(233, 1641); // primitiveColFunction
        op[245] = getOpcodeRnm(36, 264); // functionParameters
        {int[] a = {247,248}; op[246] = getOpcodeCat(a);}
        op[247] = getOpcodeRnm(234, 1642); // entityFunctionImport
        op[248] = getOpcodeRnm(36, 264); // functionParameters
        {int[] a = {250,251}; op[249] = getOpcodeCat(a);}
        op[250] = getOpcodeRnm(235, 1643); // entityColFunctionImport
        op[251] = getOpcodeRnm(36, 264); // functionParameters
        {int[] a = {253,254}; op[252] = getOpcodeCat(a);}
        op[253] = getOpcodeRnm(236, 1644); // complexFunctionImport
        op[254] = getOpcodeRnm(36, 264); // functionParameters
        {int[] a = {256,257}; op[255] = getOpcodeCat(a);}
        op[256] = getOpcodeRnm(237, 1645); // complexColFunctionImport
        op[257] = getOpcodeRnm(36, 264); // functionParameters
        {int[] a = {259,260}; op[258] = getOpcodeCat(a);}
        op[259] = getOpcodeRnm(238, 1646); // primitiveFunctionImport
        op[260] = getOpcodeRnm(36, 264); // functionParameters
        {int[] a = {262,263}; op[261] = getOpcodeCat(a);}
        op[262] = getOpcodeRnm(239, 1647); // primitiveColFunctionImport
        op[263] = getOpcodeRnm(36, 264); // functionParameters
        {int[] a = {265,266,273}; op[264] = getOpcodeCat(a);}
        op[265] = getOpcodeRnm(348, 2337); // OPEN
        op[266] = getOpcodeRep((char)0, (char)1, 267);
        {int[] a = {268,269}; op[267] = getOpcodeCat(a);}
        op[268] = getOpcodeRnm(37, 274); // functionParameter
        op[269] = getOpcodeRep((char)0, Character.MAX_VALUE, 270);
        {int[] a = {271,272}; op[270] = getOpcodeCat(a);}
        op[271] = getOpcodeRnm(342, 2320); // COMMA
        op[272] = getOpcodeRnm(37, 274); // functionParameter
        op[273] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {275,276,277}; op[274] = getOpcodeCat(a);}
        op[275] = getOpcodeRnm(38, 280); // parameterName
        op[276] = getOpcodeRnm(343, 2323); // EQ
        {int[] a = {278,279}; op[277] = getOpcodeAlt(a);}
        op[278] = getOpcodeRnm(39, 281); // parameterAlias
        op[279] = getOpcodeRnm(240, 1648); // primitiveLiteral
        op[280] = getOpcodeRnm(209, 1567); // odataIdentifier
        {int[] a = {282,283}; op[281] = getOpcodeCat(a);}
        op[282] = getOpcodeRnm(340, 2314); // AT
        op[283] = getOpcodeRnm(209, 1567); // odataIdentifier
        {int[] a = {285,286,287,288,292}; op[284] = getOpcodeCat(a);}
        {char[] a = {36,99,114,111,115,115,106,111,105,110}; op[285] = getOpcodeTbs(a);}
        op[286] = getOpcodeRnm(348, 2337); // OPEN
        op[287] = getOpcodeRnm(201, 1559); // entitySetName
        op[288] = getOpcodeRep((char)0, Character.MAX_VALUE, 289);
        {int[] a = {290,291}; op[289] = getOpcodeCat(a);}
        op[290] = getOpcodeRnm(342, 2320); // COMMA
        op[291] = getOpcodeRnm(201, 1559); // entitySetName
        op[292] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {294,295}; op[293] = getOpcodeCat(a);}
        op[294] = getOpcodeRnm(42, 299); // queryOption
        op[295] = getOpcodeRep((char)0, Character.MAX_VALUE, 296);
        {int[] a = {297,298}; op[296] = getOpcodeCat(a);}
        {char[] a = {38}; op[297] = getOpcodeTls(a);}
        op[298] = getOpcodeRnm(42, 299); // queryOption
        {int[] a = {300,301,302}; op[299] = getOpcodeAlt(a);}
        op[300] = getOpcodeRnm(48, 334); // systemQueryOption
        op[301] = getOpcodeRnm(79, 597); // aliasAndValue
        op[302] = getOpcodeRnm(81, 604); // customQueryOption
        {int[] a = {304,308,309}; op[303] = getOpcodeCat(a);}
        op[304] = getOpcodeRep((char)0, Character.MAX_VALUE, 305);
        {int[] a = {306,307}; op[305] = getOpcodeCat(a);}
        op[306] = getOpcodeRnm(44, 313); // entityIdOption
        {char[] a = {38}; op[307] = getOpcodeTls(a);}
        op[308] = getOpcodeRnm(47, 330); // id
        op[309] = getOpcodeRep((char)0, Character.MAX_VALUE, 310);
        {int[] a = {311,312}; op[310] = getOpcodeCat(a);}
        {char[] a = {38}; op[311] = getOpcodeTls(a);}
        op[312] = getOpcodeRnm(44, 313); // entityIdOption
        {int[] a = {314,315}; op[313] = getOpcodeAlt(a);}
        op[314] = getOpcodeRnm(61, 469); // format
        op[315] = getOpcodeRnm(81, 604); // customQueryOption
        {int[] a = {317,321,322}; op[316] = getOpcodeCat(a);}
        op[317] = getOpcodeRep((char)0, Character.MAX_VALUE, 318);
        {int[] a = {319,320}; op[318] = getOpcodeCat(a);}
        op[319] = getOpcodeRnm(46, 326); // entityCastOption
        {char[] a = {38}; op[320] = getOpcodeTls(a);}
        op[321] = getOpcodeRnm(47, 330); // id
        op[322] = getOpcodeRep((char)0, Character.MAX_VALUE, 323);
        {int[] a = {324,325}; op[323] = getOpcodeCat(a);}
        {char[] a = {38}; op[324] = getOpcodeTls(a);}
        op[325] = getOpcodeRnm(46, 326); // entityCastOption
        {int[] a = {327,328,329}; op[326] = getOpcodeAlt(a);}
        op[327] = getOpcodeRnm(44, 313); // entityIdOption
        op[328] = getOpcodeRnm(49, 346); // expand
        op[329] = getOpcodeRnm(70, 531); // select
        {int[] a = {331,332,333}; op[330] = getOpcodeCat(a);}
        {char[] a = {36,105,100}; op[331] = getOpcodeTbs(a);}
        op[332] = getOpcodeRnm(343, 2323); // EQ
        op[333] = getOpcodeRnm(386, 2727); // IRI-in-query
        {int[] a = {335,336,337,338,339,340,341,342,343,344,345}; op[334] = getOpcodeAlt(a);}
        op[335] = getOpcodeRnm(49, 346); // expand
        op[336] = getOpcodeRnm(56, 439); // filter
        op[337] = getOpcodeRnm(61, 469); // format
        op[338] = getOpcodeRnm(47, 330); // id
        op[339] = getOpcodeRnm(62, 482); // inlinecount
        op[340] = getOpcodeRnm(57, 443); // orderby
        op[341] = getOpcodeRnm(63, 486); // search
        op[342] = getOpcodeRnm(70, 531); // select
        op[343] = getOpcodeRnm(59, 459); // skip
        op[344] = getOpcodeRnm(78, 592); // skiptoken
        op[345] = getOpcodeRnm(60, 464); // top
        {int[] a = {347,348,349,350}; op[346] = getOpcodeCat(a);}
        {char[] a = {36,101,120,112,97,110,100}; op[347] = getOpcodeTbs(a);}
        op[348] = getOpcodeRnm(343, 2323); // EQ
        op[349] = getOpcodeRnm(50, 354); // expandItem
        op[350] = getOpcodeRep((char)0, Character.MAX_VALUE, 351);
        {int[] a = {352,353}; op[351] = getOpcodeCat(a);}
        op[352] = getOpcodeRnm(342, 2320); // COMMA
        op[353] = getOpcodeRnm(50, 354); // expandItem
        {int[] a = {355,364}; op[354] = getOpcodeAlt(a);}
        {int[] a = {356,357}; op[355] = getOpcodeCat(a);}
        op[356] = getOpcodeRnm(346, 2331); // STAR
        op[357] = getOpcodeRep((char)0, (char)1, 358);
        {int[] a = {359,360}; op[358] = getOpcodeAlt(a);}
        op[359] = getOpcodeRnm(19, 181); // ref
        {int[] a = {361,362,363}; op[360] = getOpcodeCat(a);}
        op[361] = getOpcodeRnm(348, 2337); // OPEN
        op[362] = getOpcodeRnm(55, 432); // levels
        op[363] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {365,366}; op[364] = getOpcodeCat(a);}
        op[365] = getOpcodeRnm(51, 398); // expandPath
        op[366] = getOpcodeRep((char)0, (char)1, 367);
        {int[] a = {368,379,390}; op[367] = getOpcodeAlt(a);}
        {int[] a = {369,370}; op[368] = getOpcodeCat(a);}
        op[369] = getOpcodeRnm(19, 181); // ref
        op[370] = getOpcodeRep((char)0, (char)1, 371);
        {int[] a = {372,373,374,378}; op[371] = getOpcodeCat(a);}
        op[372] = getOpcodeRnm(348, 2337); // OPEN
        op[373] = getOpcodeRnm(53, 421); // expandRefOption
        op[374] = getOpcodeRep((char)0, Character.MAX_VALUE, 375);
        {int[] a = {376,377}; op[375] = getOpcodeCat(a);}
        op[376] = getOpcodeRnm(345, 2328); // SEMI
        op[377] = getOpcodeRnm(53, 421); // expandRefOption
        op[378] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {380,381}; op[379] = getOpcodeCat(a);}
        op[380] = getOpcodeRnm(18, 180); // count
        op[381] = getOpcodeRep((char)0, (char)1, 382);
        {int[] a = {383,384,385,389}; op[382] = getOpcodeCat(a);}
        op[383] = getOpcodeRnm(348, 2337); // OPEN
        op[384] = getOpcodeRnm(52, 418); // expandCountOption
        op[385] = getOpcodeRep((char)0, Character.MAX_VALUE, 386);
        {int[] a = {387,388}; op[386] = getOpcodeCat(a);}
        op[387] = getOpcodeRnm(345, 2328); // SEMI
        op[388] = getOpcodeRnm(52, 418); // expandCountOption
        op[389] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {391,392,393,397}; op[390] = getOpcodeCat(a);}
        op[391] = getOpcodeRnm(348, 2337); // OPEN
        op[392] = getOpcodeRnm(54, 427); // expandOption
        op[393] = getOpcodeRep((char)0, Character.MAX_VALUE, 394);
        {int[] a = {395,396}; op[394] = getOpcodeCat(a);}
        op[395] = getOpcodeRnm(345, 2328); // SEMI
        op[396] = getOpcodeRnm(54, 427); // expandOption
        op[397] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {399,403,413,414}; op[398] = getOpcodeCat(a);}
        op[399] = getOpcodeRep((char)0, (char)1, 400);
        {int[] a = {401,402}; op[400] = getOpcodeCat(a);}
        op[401] = getOpcodeRnm(195, 1536); // qualifiedEntityTypeName
        {char[] a = {47}; op[402] = getOpcodeTls(a);}
        op[403] = getOpcodeRep((char)0, Character.MAX_VALUE, 404);
        {int[] a = {405,408,409}; op[404] = getOpcodeCat(a);}
        {int[] a = {406,407}; op[405] = getOpcodeAlt(a);}
        op[406] = getOpcodeRnm(219, 1619); // complexProperty
        op[407] = getOpcodeRnm(220, 1620); // complexColProperty
        {char[] a = {47}; op[408] = getOpcodeTls(a);}
        op[409] = getOpcodeRep((char)0, (char)1, 410);
        {int[] a = {411,412}; op[410] = getOpcodeCat(a);}
        op[411] = getOpcodeRnm(196, 1540); // qualifiedComplexTypeName
        {char[] a = {47}; op[412] = getOpcodeTls(a);}
        op[413] = getOpcodeRnm(222, 1622); // navigationProperty
        op[414] = getOpcodeRep((char)0, (char)1, 415);
        {int[] a = {416,417}; op[415] = getOpcodeCat(a);}
        {char[] a = {47}; op[416] = getOpcodeTls(a);}
        op[417] = getOpcodeRnm(195, 1536); // qualifiedEntityTypeName
        {int[] a = {419,420}; op[418] = getOpcodeAlt(a);}
        op[419] = getOpcodeRnm(56, 439); // filter
        op[420] = getOpcodeRnm(63, 486); // search
        {int[] a = {422,423,424,425,426}; op[421] = getOpcodeAlt(a);}
        op[422] = getOpcodeRnm(52, 418); // expandCountOption
        op[423] = getOpcodeRnm(57, 443); // orderby
        op[424] = getOpcodeRnm(59, 459); // skip
        op[425] = getOpcodeRnm(60, 464); // top
        op[426] = getOpcodeRnm(62, 482); // inlinecount
        {int[] a = {428,429,430,431}; op[427] = getOpcodeAlt(a);}
        op[428] = getOpcodeRnm(53, 421); // expandRefOption
        op[429] = getOpcodeRnm(70, 531); // select
        op[430] = getOpcodeRnm(49, 346); // expand
        op[431] = getOpcodeRnm(55, 432); // levels
        {int[] a = {433,434,435}; op[432] = getOpcodeCat(a);}
        {char[] a = {36,108,101,118,101,108,115}; op[433] = getOpcodeTbs(a);}
        op[434] = getOpcodeRnm(343, 2323); // EQ
        {int[] a = {436,438}; op[435] = getOpcodeAlt(a);}
        op[436] = getOpcodeRep((char)1, Character.MAX_VALUE, 437);
        op[437] = getOpcodeRnm(388, 2732); // DIGIT
        {char[] a = {109,97,120}; op[438] = getOpcodeTbs(a);}
        {int[] a = {440,441,442}; op[439] = getOpcodeCat(a);}
        {char[] a = {36,102,105,108,116,101,114}; op[440] = getOpcodeTbs(a);}
        op[441] = getOpcodeRnm(343, 2323); // EQ
        op[442] = getOpcodeRnm(93, 737); // boolCommonExpr
        {int[] a = {444,445,446,447}; op[443] = getOpcodeCat(a);}
        {char[] a = {36,111,114,100,101,114,98,121}; op[444] = getOpcodeTbs(a);}
        op[445] = getOpcodeRnm(343, 2323); // EQ
        op[446] = getOpcodeRnm(58, 451); // orderbyItem
        op[447] = getOpcodeRep((char)0, Character.MAX_VALUE, 448);
        {int[] a = {449,450}; op[448] = getOpcodeCat(a);}
        op[449] = getOpcodeRnm(342, 2320); // COMMA
        op[450] = getOpcodeRnm(58, 451); // orderbyItem
        {int[] a = {452,453}; op[451] = getOpcodeCat(a);}
        op[452] = getOpcodeRnm(92, 718); // commonExpr
        op[453] = getOpcodeRep((char)0, (char)1, 454);
        {int[] a = {455,456}; op[454] = getOpcodeCat(a);}
        op[455] = getOpcodeRnm(338, 2307); // RWS
        {int[] a = {457,458}; op[456] = getOpcodeAlt(a);}
        {char[] a = {97,115,99}; op[457] = getOpcodeTbs(a);}
        {char[] a = {100,101,115,99}; op[458] = getOpcodeTbs(a);}
        {int[] a = {460,461,462}; op[459] = getOpcodeCat(a);}
        {char[] a = {36,115,107,105,112}; op[460] = getOpcodeTbs(a);}
        op[461] = getOpcodeRnm(343, 2323); // EQ
        op[462] = getOpcodeRep((char)1, Character.MAX_VALUE, 463);
        op[463] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {465,466,467}; op[464] = getOpcodeCat(a);}
        {char[] a = {36,116,111,112}; op[465] = getOpcodeTbs(a);}
        op[466] = getOpcodeRnm(343, 2323); // EQ
        op[467] = getOpcodeRep((char)1, Character.MAX_VALUE, 468);
        op[468] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {470,471,472}; op[469] = getOpcodeCat(a);}
        {char[] a = {36,102,111,114,109,97,116}; op[470] = getOpcodeTbs(a);}
        op[471] = getOpcodeRnm(343, 2323); // EQ
        {int[] a = {473,474,475,476}; op[472] = getOpcodeAlt(a);}
        {char[] a = {97,116,111,109}; op[473] = getOpcodeTls(a);}
        {char[] a = {106,115,111,110}; op[474] = getOpcodeTls(a);}
        {char[] a = {120,109,108}; op[475] = getOpcodeTls(a);}
        {int[] a = {477,479,480}; op[476] = getOpcodeCat(a);}
        op[477] = getOpcodeRep((char)1, Character.MAX_VALUE, 478);
        op[478] = getOpcodeRnm(370, 2561); // pchar
        {char[] a = {47}; op[479] = getOpcodeTls(a);}
        op[480] = getOpcodeRep((char)1, Character.MAX_VALUE, 481);
        op[481] = getOpcodeRnm(370, 2561); // pchar
        {int[] a = {483,484,485}; op[482] = getOpcodeCat(a);}
        {char[] a = {36,99,111,117,110,116}; op[483] = getOpcodeTbs(a);}
        op[484] = getOpcodeRnm(343, 2323); // EQ
        op[485] = getOpcodeRnm(248, 1755); // booleanValue
        {int[] a = {487,488,489,490}; op[486] = getOpcodeCat(a);}
        {char[] a = {36,115,101,97,114,99,104}; op[487] = getOpcodeTbs(a);}
        op[488] = getOpcodeRnm(343, 2323); // EQ
        op[489] = getOpcodeRnm(339, 2313); // BWS
        op[490] = getOpcodeRnm(64, 491); // searchExpr
        {int[] a = {492,500}; op[491] = getOpcodeCat(a);}
        {int[] a = {493,499}; op[492] = getOpcodeAlt(a);}
        {int[] a = {494,495,496,497,498}; op[493] = getOpcodeCat(a);}
        op[494] = getOpcodeRnm(348, 2337); // OPEN
        op[495] = getOpcodeRnm(339, 2313); // BWS
        op[496] = getOpcodeRnm(64, 491); // searchExpr
        op[497] = getOpcodeRnm(339, 2313); // BWS
        op[498] = getOpcodeRnm(349, 2340); // CLOSE
        op[499] = getOpcodeRnm(67, 516); // searchTerm
        op[500] = getOpcodeRep((char)0, (char)1, 501);
        {int[] a = {502,503}; op[501] = getOpcodeAlt(a);}
        op[502] = getOpcodeRnm(65, 504); // searchOrExpr
        op[503] = getOpcodeRnm(66, 509); // searchAndExpr
        {int[] a = {505,506,507,508}; op[504] = getOpcodeCat(a);}
        op[505] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {79,82}; op[506] = getOpcodeTbs(a);}
        op[507] = getOpcodeRnm(338, 2307); // RWS
        op[508] = getOpcodeRnm(64, 491); // searchExpr
        {int[] a = {510,511,515}; op[509] = getOpcodeCat(a);}
        op[510] = getOpcodeRnm(338, 2307); // RWS
        op[511] = getOpcodeRep((char)0, (char)1, 512);
        {int[] a = {513,514}; op[512] = getOpcodeCat(a);}
        {char[] a = {65,78,68}; op[513] = getOpcodeTbs(a);}
        op[514] = getOpcodeRnm(338, 2307); // RWS
        op[515] = getOpcodeRnm(64, 491); // searchExpr
        {int[] a = {517,521}; op[516] = getOpcodeCat(a);}
        op[517] = getOpcodeRep((char)0, (char)1, 518);
        {int[] a = {519,520}; op[518] = getOpcodeCat(a);}
        {char[] a = {78,79,84}; op[519] = getOpcodeTbs(a);}
        op[520] = getOpcodeRnm(338, 2307); // RWS
        {int[] a = {522,523}; op[521] = getOpcodeAlt(a);}
        op[522] = getOpcodeRnm(68, 524); // searchPhrase
        op[523] = getOpcodeRnm(69, 529); // searchWord
        {int[] a = {525,526,528}; op[524] = getOpcodeCat(a);}
        op[525] = getOpcodeRnm(181, 1445); // quotation-mark
        op[526] = getOpcodeRep((char)1, Character.MAX_VALUE, 527);
        op[527] = getOpcodeRnm(384, 2716); // qchar-no-AMP-DQUOTE
        op[528] = getOpcodeRnm(181, 1445); // quotation-mark
        op[529] = getOpcodeRep((char)1, Character.MAX_VALUE, 530);
        op[530] = getOpcodeRnm(387, 2729); // ALPHA
        {int[] a = {532,533,534,535}; op[531] = getOpcodeCat(a);}
        {char[] a = {36,115,101,108,101,99,116}; op[532] = getOpcodeTbs(a);}
        op[533] = getOpcodeRnm(343, 2323); // EQ
        op[534] = getOpcodeRnm(71, 539); // selectItem
        op[535] = getOpcodeRep((char)0, Character.MAX_VALUE, 536);
        {int[] a = {537,538}; op[536] = getOpcodeCat(a);}
        op[537] = getOpcodeRnm(342, 2320); // COMMA
        op[538] = getOpcodeRnm(71, 539); // selectItem
        {int[] a = {540,541,542}; op[539] = getOpcodeAlt(a);}
        op[540] = getOpcodeRnm(346, 2331); // STAR
        op[541] = getOpcodeRnm(74, 569); // allOperationsInSchema
        {int[] a = {543,547}; op[542] = getOpcodeCat(a);}
        op[543] = getOpcodeRep((char)0, (char)1, 544);
        {int[] a = {545,546}; op[544] = getOpcodeCat(a);}
        op[545] = getOpcodeRnm(195, 1536); // qualifiedEntityTypeName
        {char[] a = {47}; op[546] = getOpcodeTls(a);}
        {int[] a = {548,549,550}; op[547] = getOpcodeAlt(a);}
        op[548] = getOpcodeRnm(72, 551); // selectProperty
        op[549] = getOpcodeRnm(75, 573); // qualifiedActionName
        op[550] = getOpcodeRnm(76, 577); // qualifiedFunctionName
        {int[] a = {552,553,554,555}; op[551] = getOpcodeAlt(a);}
        op[552] = getOpcodeRnm(215, 1613); // primitiveProperty
        op[553] = getOpcodeRnm(218, 1618); // primitiveColProperty
        op[554] = getOpcodeRnm(222, 1622); // navigationProperty
        {int[] a = {556,557}; op[555] = getOpcodeCat(a);}
        op[556] = getOpcodeRnm(73, 561); // selectPath
        op[557] = getOpcodeRep((char)0, (char)1, 558);
        {int[] a = {559,560}; op[558] = getOpcodeCat(a);}
        {char[] a = {47}; op[559] = getOpcodeTls(a);}
        op[560] = getOpcodeRnm(72, 551); // selectProperty
        {int[] a = {562,565}; op[561] = getOpcodeCat(a);}
        {int[] a = {563,564}; op[562] = getOpcodeAlt(a);}
        op[563] = getOpcodeRnm(219, 1619); // complexProperty
        op[564] = getOpcodeRnm(220, 1620); // complexColProperty
        op[565] = getOpcodeRep((char)0, (char)1, 566);
        {int[] a = {567,568}; op[566] = getOpcodeCat(a);}
        {char[] a = {47}; op[567] = getOpcodeTls(a);}
        op[568] = getOpcodeRnm(196, 1540); // qualifiedComplexTypeName
        {int[] a = {570,571,572}; op[569] = getOpcodeCat(a);}
        op[570] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[571] = getOpcodeTls(a);}
        op[572] = getOpcodeRnm(346, 2331); // STAR
        {int[] a = {574,575,576}; op[573] = getOpcodeCat(a);}
        op[574] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[575] = getOpcodeTls(a);}
        op[576] = getOpcodeRnm(225, 1627); // action
        {int[] a = {578,579,580,581}; op[577] = getOpcodeCat(a);}
        op[578] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[579] = getOpcodeTls(a);}
        op[580] = getOpcodeRnm(227, 1629); // function
        op[581] = getOpcodeRep((char)0, (char)1, 582);
        {int[] a = {583,584,585}; op[582] = getOpcodeCat(a);}
        op[583] = getOpcodeRnm(348, 2337); // OPEN
        op[584] = getOpcodeRnm(77, 586); // parameterNames
        op[585] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {587,588}; op[586] = getOpcodeCat(a);}
        op[587] = getOpcodeRnm(38, 280); // parameterName
        op[588] = getOpcodeRep((char)0, Character.MAX_VALUE, 589);
        {int[] a = {590,591}; op[589] = getOpcodeCat(a);}
        op[590] = getOpcodeRnm(342, 2320); // COMMA
        op[591] = getOpcodeRnm(38, 280); // parameterName
        {int[] a = {593,594,595}; op[592] = getOpcodeCat(a);}
        {char[] a = {36,115,107,105,112,116,111,107,101,110}; op[593] = getOpcodeTbs(a);}
        op[594] = getOpcodeRnm(343, 2323); // EQ
        op[595] = getOpcodeRep((char)1, Character.MAX_VALUE, 596);
        op[596] = getOpcodeRnm(379, 2639); // qchar-no-AMP
        {int[] a = {598,599,600}; op[597] = getOpcodeCat(a);}
        op[598] = getOpcodeRnm(39, 281); // parameterAlias
        op[599] = getOpcodeRnm(343, 2323); // EQ
        op[600] = getOpcodeRnm(80, 601); // parameterValue
        {int[] a = {602,603}; op[601] = getOpcodeAlt(a);}
        op[602] = getOpcodeRnm(165, 1314); // arrayOrObject
        op[603] = getOpcodeRnm(92, 718); // commonExpr
        {int[] a = {605,606}; op[604] = getOpcodeCat(a);}
        op[605] = getOpcodeRnm(82, 610); // customName
        op[606] = getOpcodeRep((char)0, (char)1, 607);
        {int[] a = {608,609}; op[607] = getOpcodeCat(a);}
        op[608] = getOpcodeRnm(343, 2323); // EQ
        op[609] = getOpcodeRnm(83, 614); // customValue
        {int[] a = {611,612}; op[610] = getOpcodeCat(a);}
        op[611] = getOpcodeRnm(381, 2660); // qchar-no-AMP-EQ-AT-DOLLAR
        op[612] = getOpcodeRep((char)0, Character.MAX_VALUE, 613);
        op[613] = getOpcodeRnm(380, 2650); // qchar-no-AMP-EQ
        op[614] = getOpcodeRep((char)0, Character.MAX_VALUE, 615);
        op[615] = getOpcodeRnm(379, 2639); // qchar-no-AMP
        {int[] a = {617,618}; op[616] = getOpcodeCat(a);}
        {char[] a = {35}; op[617] = getOpcodeTls(a);}
        op[618] = getOpcodeRnm(85, 619); // contextFragment
        {int[] a = {620,621,622,623,624,625,626,632,637}; op[619] = getOpcodeAlt(a);}
        {char[] a = {67,111,108,108,101,99,116,105,111,110,40,36,114,101,102,41}; op[620] = getOpcodeTbs(a);}
        {char[] a = {36,114,101,102}; op[621] = getOpcodeTbs(a);}
        {char[] a = {67,111,108,108,101,99,116,105,111,110,40,69,100,109,46,69,110,116,105,116,121,84,121,112,101,41}; op[622] = getOpcodeTbs(a);}
        {char[] a = {67,111,108,108,101,99,116,105,111,110,40,69,100,109,46,67,111,109,112,108,101,120,84,121,112,101,41}; op[623] = getOpcodeTbs(a);}
        op[624] = getOpcodeRnm(202, 1560); // singletonEntity
        op[625] = getOpcodeRnm(194, 1529); // qualifiedTypeName
        {int[] a = {627,628}; op[626] = getOpcodeCat(a);}
        op[627] = getOpcodeRnm(86, 645); // entitySet
        {int[] a = {629,630,631}; op[628] = getOpcodeAlt(a);}
        {char[] a = {47,36,100,101,108,101,116,101,100,69,110,116,105,116,121}; op[629] = getOpcodeTbs(a);}
        {char[] a = {47,36,108,105,110,107}; op[630] = getOpcodeTbs(a);}
        {char[] a = {47,36,100,101,108,101,116,101,100,76,105,110,107}; op[631] = getOpcodeTbs(a);}
        {int[] a = {633,634,635,636}; op[632] = getOpcodeCat(a);}
        op[633] = getOpcodeRnm(86, 645); // entitySet
        op[634] = getOpcodeRnm(7, 99); // keyPredicate
        {char[] a = {47}; op[635] = getOpcodeTls(a);}
        op[636] = getOpcodeRnm(91, 704); // contextPropertyPath
        {int[] a = {638,639,641}; op[637] = getOpcodeCat(a);}
        op[638] = getOpcodeRnm(86, 645); // entitySet
        op[639] = getOpcodeRep((char)0, (char)1, 640);
        op[640] = getOpcodeRnm(88, 669); // selectList
        op[641] = getOpcodeRep((char)0, (char)1, 642);
        {int[] a = {643,644}; op[642] = getOpcodeAlt(a);}
        {char[] a = {47,36,101,110,116,105,116,121}; op[643] = getOpcodeTbs(a);}
        {char[] a = {47,36,100,101,108,116,97}; op[644] = getOpcodeTbs(a);}
        {int[] a = {646,647,649}; op[645] = getOpcodeCat(a);}
        op[646] = getOpcodeRnm(201, 1559); // entitySetName
        op[647] = getOpcodeRep((char)0, Character.MAX_VALUE, 648);
        op[648] = getOpcodeRnm(87, 653); // containmentNavigation
        op[649] = getOpcodeRep((char)0, (char)1, 650);
        {int[] a = {651,652}; op[650] = getOpcodeCat(a);}
        {char[] a = {47}; op[651] = getOpcodeTls(a);}
        op[652] = getOpcodeRnm(195, 1536); // qualifiedEntityTypeName
        {int[] a = {654,655,659,667,668}; op[653] = getOpcodeCat(a);}
        op[654] = getOpcodeRnm(7, 99); // keyPredicate
        op[655] = getOpcodeRep((char)0, (char)1, 656);
        {int[] a = {657,658}; op[656] = getOpcodeCat(a);}
        {char[] a = {47}; op[657] = getOpcodeTls(a);}
        op[658] = getOpcodeRnm(195, 1536); // qualifiedEntityTypeName
        op[659] = getOpcodeRep((char)0, Character.MAX_VALUE, 660);
        {int[] a = {661,662,663}; op[660] = getOpcodeCat(a);}
        {char[] a = {47}; op[661] = getOpcodeTls(a);}
        op[662] = getOpcodeRnm(219, 1619); // complexProperty
        op[663] = getOpcodeRep((char)0, (char)1, 664);
        {int[] a = {665,666}; op[664] = getOpcodeCat(a);}
        {char[] a = {47}; op[665] = getOpcodeTls(a);}
        op[666] = getOpcodeRnm(196, 1540); // qualifiedComplexTypeName
        {char[] a = {47}; op[667] = getOpcodeTls(a);}
        op[668] = getOpcodeRnm(222, 1622); // navigationProperty
        {int[] a = {670,671,672,676}; op[669] = getOpcodeCat(a);}
        op[670] = getOpcodeRnm(348, 2337); // OPEN
        op[671] = getOpcodeRnm(89, 677); // selectListItem
        op[672] = getOpcodeRep((char)0, Character.MAX_VALUE, 673);
        {int[] a = {674,675}; op[673] = getOpcodeCat(a);}
        op[674] = getOpcodeRnm(342, 2320); // COMMA
        op[675] = getOpcodeRnm(89, 677); // selectListItem
        op[676] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {678,679,680}; op[677] = getOpcodeAlt(a);}
        op[678] = getOpcodeRnm(346, 2331); // STAR
        op[679] = getOpcodeRnm(74, 569); // allOperationsInSchema
        {int[] a = {681,685}; op[680] = getOpcodeCat(a);}
        op[681] = getOpcodeRep((char)0, (char)1, 682);
        {int[] a = {683,684}; op[682] = getOpcodeCat(a);}
        op[683] = getOpcodeRnm(195, 1536); // qualifiedEntityTypeName
        {char[] a = {47}; op[684] = getOpcodeTls(a);}
        {int[] a = {686,687,688}; op[685] = getOpcodeAlt(a);}
        op[686] = getOpcodeRnm(75, 573); // qualifiedActionName
        op[687] = getOpcodeRnm(76, 577); // qualifiedFunctionName
        op[688] = getOpcodeRnm(90, 689); // selectListProperty
        {int[] a = {690,691,692,698}; op[689] = getOpcodeAlt(a);}
        op[690] = getOpcodeRnm(215, 1613); // primitiveProperty
        op[691] = getOpcodeRnm(218, 1618); // primitiveColProperty
        {int[] a = {693,694,696}; op[692] = getOpcodeCat(a);}
        op[693] = getOpcodeRnm(222, 1622); // navigationProperty
        op[694] = getOpcodeRep((char)0, (char)1, 695);
        {char[] a = {43}; op[695] = getOpcodeTbs(a);}
        op[696] = getOpcodeRep((char)0, (char)1, 697);
        op[697] = getOpcodeRnm(88, 669); // selectList
        {int[] a = {699,700}; op[698] = getOpcodeCat(a);}
        op[699] = getOpcodeRnm(73, 561); // selectPath
        op[700] = getOpcodeRep((char)0, (char)1, 701);
        {int[] a = {702,703}; op[701] = getOpcodeCat(a);}
        {char[] a = {47}; op[702] = getOpcodeTls(a);}
        op[703] = getOpcodeRnm(90, 689); // selectListProperty
        {int[] a = {705,706,707,708}; op[704] = getOpcodeAlt(a);}
        op[705] = getOpcodeRnm(215, 1613); // primitiveProperty
        op[706] = getOpcodeRnm(218, 1618); // primitiveColProperty
        op[707] = getOpcodeRnm(220, 1620); // complexColProperty
        {int[] a = {709,710}; op[708] = getOpcodeCat(a);}
        op[709] = getOpcodeRnm(219, 1619); // complexProperty
        op[710] = getOpcodeRep((char)0, (char)1, 711);
        {int[] a = {712,716,717}; op[711] = getOpcodeCat(a);}
        op[712] = getOpcodeRep((char)0, (char)1, 713);
        {int[] a = {714,715}; op[713] = getOpcodeCat(a);}
        {char[] a = {47}; op[714] = getOpcodeTls(a);}
        op[715] = getOpcodeRnm(196, 1540); // qualifiedComplexTypeName
        {char[] a = {47}; op[716] = getOpcodeTls(a);}
        op[717] = getOpcodeRnm(91, 704); // contextPropertyPath
        {int[] a = {719,730}; op[718] = getOpcodeCat(a);}
        {int[] a = {720,721,722,723,724,725,726,727,728,729}; op[719] = getOpcodeAlt(a);}
        op[720] = getOpcodeRnm(240, 1648); // primitiveLiteral
        op[721] = getOpcodeRnm(39, 281); // parameterAlias
        op[722] = getOpcodeRnm(165, 1314); // arrayOrObject
        op[723] = getOpcodeRnm(94, 758); // rootExpr
        op[724] = getOpcodeRnm(95, 767); // firstMemberExpr
        op[725] = getOpcodeRnm(107, 852); // functionExpr
        op[726] = getOpcodeRnm(161, 1280); // negateExpr
        op[727] = getOpcodeRnm(113, 927); // methodCallExpr
        op[728] = getOpcodeRnm(146, 1204); // parenExpr
        op[729] = getOpcodeRnm(164, 1301); // castExpr
        op[730] = getOpcodeRep((char)0, (char)1, 731);
        {int[] a = {732,733,734,735,736}; op[731] = getOpcodeAlt(a);}
        op[732] = getOpcodeRnm(156, 1255); // addExpr
        op[733] = getOpcodeRnm(157, 1260); // subExpr
        op[734] = getOpcodeRnm(158, 1265); // mulExpr
        op[735] = getOpcodeRnm(159, 1270); // divExpr
        op[736] = getOpcodeRnm(160, 1275); // modExpr
        {int[] a = {738,754}; op[737] = getOpcodeCat(a);}
        {int[] a = {739,740,741,742,753}; op[738] = getOpcodeAlt(a);}
        op[739] = getOpcodeRnm(163, 1288); // isofExpr
        op[740] = getOpcodeRnm(114, 954); // boolMethodCallExpr
        op[741] = getOpcodeRnm(162, 1284); // notExpr
        {int[] a = {743,744}; op[742] = getOpcodeCat(a);}
        op[743] = getOpcodeRnm(92, 718); // commonExpr
        op[744] = getOpcodeRep((char)0, (char)1, 745);
        {int[] a = {746,747,748,749,750,751,752}; op[745] = getOpcodeAlt(a);}
        op[746] = getOpcodeRnm(149, 1220); // eqExpr
        op[747] = getOpcodeRnm(150, 1225); // neExpr
        op[748] = getOpcodeRnm(151, 1230); // ltExpr
        op[749] = getOpcodeRnm(152, 1235); // leExpr
        op[750] = getOpcodeRnm(153, 1240); // gtExpr
        op[751] = getOpcodeRnm(154, 1245); // geExpr
        op[752] = getOpcodeRnm(155, 1250); // hasExpr
        op[753] = getOpcodeRnm(145, 1198); // boolParenExpr
        op[754] = getOpcodeRep((char)0, (char)1, 755);
        {int[] a = {756,757}; op[755] = getOpcodeAlt(a);}
        op[756] = getOpcodeRnm(147, 1210); // andExpr
        op[757] = getOpcodeRnm(148, 1215); // orExpr
        {int[] a = {759,760,765}; op[758] = getOpcodeCat(a);}
        {char[] a = {36,114,111,111,116,47}; op[759] = getOpcodeTbs(a);}
        {int[] a = {761,764}; op[760] = getOpcodeAlt(a);}
        {int[] a = {762,763}; op[761] = getOpcodeCat(a);}
        op[762] = getOpcodeRnm(201, 1559); // entitySetName
        op[763] = getOpcodeRnm(7, 99); // keyPredicate
        op[764] = getOpcodeRnm(202, 1560); // singletonEntity
        op[765] = getOpcodeRep((char)0, (char)1, 766);
        op[766] = getOpcodeRnm(102, 825); // singleNavigationExpr
        {int[] a = {768,769}; op[767] = getOpcodeAlt(a);}
        op[768] = getOpcodeRnm(96, 775); // memberExpr
        {int[] a = {770,771}; op[769] = getOpcodeCat(a);}
        op[770] = getOpcodeRnm(98, 809); // inscopeVariableExpr
        op[771] = getOpcodeRep((char)0, (char)1, 772);
        {int[] a = {773,774}; op[772] = getOpcodeCat(a);}
        {char[] a = {47}; op[773] = getOpcodeTls(a);}
        op[774] = getOpcodeRnm(96, 775); // memberExpr
        {int[] a = {776,780}; op[775] = getOpcodeCat(a);}
        op[776] = getOpcodeRep((char)0, (char)1, 777);
        {int[] a = {778,779}; op[777] = getOpcodeCat(a);}
        op[778] = getOpcodeRnm(195, 1536); // qualifiedEntityTypeName
        {char[] a = {47}; op[779] = getOpcodeTls(a);}
        {int[] a = {781,782}; op[780] = getOpcodeAlt(a);}
        op[781] = getOpcodeRnm(97, 783); // propertyPathExpr
        op[782] = getOpcodeRnm(106, 851); // boundFunctionExpr
        {int[] a = {784,788,792,796,800,804,808}; op[783] = getOpcodeAlt(a);}
        {int[] a = {785,786}; op[784] = getOpcodeCat(a);}
        op[785] = getOpcodeRnm(224, 1626); // entityColNavigationProperty
        op[786] = getOpcodeRep((char)0, (char)1, 787);
        op[787] = getOpcodeRnm(101, 814); // collectionNavigationExpr
        {int[] a = {789,790}; op[788] = getOpcodeCat(a);}
        op[789] = getOpcodeRnm(223, 1625); // entityNavigationProperty
        op[790] = getOpcodeRep((char)0, (char)1, 791);
        op[791] = getOpcodeRnm(102, 825); // singleNavigationExpr
        {int[] a = {793,794}; op[792] = getOpcodeCat(a);}
        op[793] = getOpcodeRnm(220, 1620); // complexColProperty
        op[794] = getOpcodeRep((char)0, (char)1, 795);
        op[795] = getOpcodeRnm(103, 828); // collectionPathExpr
        {int[] a = {797,798}; op[796] = getOpcodeCat(a);}
        op[797] = getOpcodeRnm(219, 1619); // complexProperty
        op[798] = getOpcodeRep((char)0, (char)1, 799);
        op[799] = getOpcodeRnm(104, 839); // complexPathExpr
        {int[] a = {801,802}; op[800] = getOpcodeCat(a);}
        op[801] = getOpcodeRnm(218, 1618); // primitiveColProperty
        op[802] = getOpcodeRep((char)0, (char)1, 803);
        op[803] = getOpcodeRnm(103, 828); // collectionPathExpr
        {int[] a = {805,806}; op[804] = getOpcodeCat(a);}
        op[805] = getOpcodeRnm(215, 1613); // primitiveProperty
        op[806] = getOpcodeRep((char)0, (char)1, 807);
        op[807] = getOpcodeRnm(105, 848); // singlePathExpr
        op[808] = getOpcodeRnm(221, 1621); // streamProperty
        {int[] a = {810,811}; op[809] = getOpcodeAlt(a);}
        op[810] = getOpcodeRnm(99, 812); // implicitVariableExpr
        op[811] = getOpcodeRnm(100, 813); // lambdaVariableExpr
        {char[] a = {36,105,116}; op[812] = getOpcodeTbs(a);}
        op[813] = getOpcodeRnm(209, 1567); // odataIdentifier
        {int[] a = {815,819}; op[814] = getOpcodeCat(a);}
        op[815] = getOpcodeRep((char)0, (char)1, 816);
        {int[] a = {817,818}; op[816] = getOpcodeCat(a);}
        {char[] a = {47}; op[817] = getOpcodeTls(a);}
        op[818] = getOpcodeRnm(195, 1536); // qualifiedEntityTypeName
        {int[] a = {820,824}; op[819] = getOpcodeAlt(a);}
        {int[] a = {821,822}; op[820] = getOpcodeCat(a);}
        op[821] = getOpcodeRnm(7, 99); // keyPredicate
        op[822] = getOpcodeRep((char)0, (char)1, 823);
        op[823] = getOpcodeRnm(102, 825); // singleNavigationExpr
        op[824] = getOpcodeRnm(103, 828); // collectionPathExpr
        {int[] a = {826,827}; op[825] = getOpcodeCat(a);}
        {char[] a = {47}; op[826] = getOpcodeTls(a);}
        op[827] = getOpcodeRnm(96, 775); // memberExpr
        {int[] a = {829,830,833,836}; op[828] = getOpcodeAlt(a);}
        op[829] = getOpcodeRnm(18, 180); // count
        {int[] a = {831,832}; op[830] = getOpcodeCat(a);}
        {char[] a = {47}; op[831] = getOpcodeTls(a);}
        op[832] = getOpcodeRnm(106, 851); // boundFunctionExpr
        {int[] a = {834,835}; op[833] = getOpcodeCat(a);}
        {char[] a = {47}; op[834] = getOpcodeTls(a);}
        op[835] = getOpcodeRnm(110, 902); // anyExpr
        {int[] a = {837,838}; op[836] = getOpcodeCat(a);}
        {char[] a = {47}; op[837] = getOpcodeTls(a);}
        op[838] = getOpcodeRnm(111, 915); // allExpr
        {int[] a = {840,841,845}; op[839] = getOpcodeCat(a);}
        {char[] a = {47}; op[840] = getOpcodeTls(a);}
        op[841] = getOpcodeRep((char)0, (char)1, 842);
        {int[] a = {843,844}; op[842] = getOpcodeCat(a);}
        op[843] = getOpcodeRnm(196, 1540); // qualifiedComplexTypeName
        {char[] a = {47}; op[844] = getOpcodeTls(a);}
        {int[] a = {846,847}; op[845] = getOpcodeAlt(a);}
        op[846] = getOpcodeRnm(97, 783); // propertyPathExpr
        op[847] = getOpcodeRnm(106, 851); // boundFunctionExpr
        {int[] a = {849,850}; op[848] = getOpcodeCat(a);}
        {char[] a = {47}; op[849] = getOpcodeTls(a);}
        op[850] = getOpcodeRnm(106, 851); // boundFunctionExpr
        op[851] = getOpcodeRnm(107, 852); // functionExpr
        {int[] a = {853,854,855}; op[852] = getOpcodeCat(a);}
        op[853] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[854] = getOpcodeTls(a);}
        {int[] a = {856,861,866,871,876,881}; op[855] = getOpcodeAlt(a);}
        {int[] a = {857,858,859}; op[856] = getOpcodeCat(a);}
        op[857] = getOpcodeRnm(229, 1637); // entityColFunction
        op[858] = getOpcodeRnm(108, 886); // functionExprParameters
        op[859] = getOpcodeRep((char)0, (char)1, 860);
        op[860] = getOpcodeRnm(101, 814); // collectionNavigationExpr
        {int[] a = {862,863,864}; op[861] = getOpcodeCat(a);}
        op[862] = getOpcodeRnm(228, 1636); // entityFunction
        op[863] = getOpcodeRnm(108, 886); // functionExprParameters
        op[864] = getOpcodeRep((char)0, (char)1, 865);
        op[865] = getOpcodeRnm(102, 825); // singleNavigationExpr
        {int[] a = {867,868,869}; op[866] = getOpcodeCat(a);}
        op[867] = getOpcodeRnm(231, 1639); // complexColFunction
        op[868] = getOpcodeRnm(108, 886); // functionExprParameters
        op[869] = getOpcodeRep((char)0, (char)1, 870);
        op[870] = getOpcodeRnm(103, 828); // collectionPathExpr
        {int[] a = {872,873,874}; op[871] = getOpcodeCat(a);}
        op[872] = getOpcodeRnm(230, 1638); // complexFunction
        op[873] = getOpcodeRnm(108, 886); // functionExprParameters
        op[874] = getOpcodeRep((char)0, (char)1, 875);
        op[875] = getOpcodeRnm(104, 839); // complexPathExpr
        {int[] a = {877,878,879}; op[876] = getOpcodeCat(a);}
        op[877] = getOpcodeRnm(233, 1641); // primitiveColFunction
        op[878] = getOpcodeRnm(108, 886); // functionExprParameters
        op[879] = getOpcodeRep((char)0, (char)1, 880);
        op[880] = getOpcodeRnm(103, 828); // collectionPathExpr
        {int[] a = {882,883,884}; op[881] = getOpcodeCat(a);}
        op[882] = getOpcodeRnm(232, 1640); // primitiveFunction
        op[883] = getOpcodeRnm(108, 886); // functionExprParameters
        op[884] = getOpcodeRep((char)0, (char)1, 885);
        op[885] = getOpcodeRnm(105, 848); // singlePathExpr
        {int[] a = {887,888,895}; op[886] = getOpcodeCat(a);}
        op[887] = getOpcodeRnm(348, 2337); // OPEN
        op[888] = getOpcodeRep((char)0, (char)1, 889);
        {int[] a = {890,891}; op[889] = getOpcodeCat(a);}
        op[890] = getOpcodeRnm(109, 896); // functionExprParameter
        op[891] = getOpcodeRep((char)0, Character.MAX_VALUE, 892);
        {int[] a = {893,894}; op[892] = getOpcodeCat(a);}
        op[893] = getOpcodeRnm(342, 2320); // COMMA
        op[894] = getOpcodeRnm(109, 896); // functionExprParameter
        op[895] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {897,898,899}; op[896] = getOpcodeCat(a);}
        op[897] = getOpcodeRnm(38, 280); // parameterName
        op[898] = getOpcodeRnm(343, 2323); // EQ
        {int[] a = {900,901}; op[899] = getOpcodeAlt(a);}
        op[900] = getOpcodeRnm(39, 281); // parameterAlias
        op[901] = getOpcodeRnm(80, 601); // parameterValue
        {int[] a = {903,904,905,906,913,914}; op[902] = getOpcodeCat(a);}
        {char[] a = {97,110,121}; op[903] = getOpcodeTbs(a);}
        op[904] = getOpcodeRnm(348, 2337); // OPEN
        op[905] = getOpcodeRnm(339, 2313); // BWS
        op[906] = getOpcodeRep((char)0, (char)1, 907);
        {int[] a = {908,909,910,911,912}; op[907] = getOpcodeCat(a);}
        op[908] = getOpcodeRnm(100, 813); // lambdaVariableExpr
        op[909] = getOpcodeRnm(339, 2313); // BWS
        op[910] = getOpcodeRnm(341, 2317); // COLON
        op[911] = getOpcodeRnm(339, 2313); // BWS
        op[912] = getOpcodeRnm(112, 926); // lambdaPredicateExpr
        op[913] = getOpcodeRnm(339, 2313); // BWS
        op[914] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {916,917,918,919,920,921,922,923,924,925}; op[915] = getOpcodeCat(a);}
        {char[] a = {97,108,108}; op[916] = getOpcodeTbs(a);}
        op[917] = getOpcodeRnm(348, 2337); // OPEN
        op[918] = getOpcodeRnm(339, 2313); // BWS
        op[919] = getOpcodeRnm(100, 813); // lambdaVariableExpr
        op[920] = getOpcodeRnm(339, 2313); // BWS
        op[921] = getOpcodeRnm(341, 2317); // COLON
        op[922] = getOpcodeRnm(339, 2313); // BWS
        op[923] = getOpcodeRnm(112, 926); // lambdaPredicateExpr
        op[924] = getOpcodeRnm(339, 2313); // BWS
        op[925] = getOpcodeRnm(349, 2340); // CLOSE
        op[926] = getOpcodeRnm(93, 737); // boolCommonExpr
        {int[] a = {928,929,930,931,932,933,934,935,936,937,938,939,940,941,942,943,944,945,946,947,948,949,950,951,952,953}; op[927] = getOpcodeAlt(a);}
        op[928] = getOpcodeRnm(119, 999); // indexOfMethodCallExpr
        op[929] = getOpcodeRnm(121, 1027); // toLowerMethodCallExpr
        op[930] = getOpcodeRnm(122, 1034); // toUpperMethodCallExpr
        op[931] = getOpcodeRnm(123, 1041); // trimMethodCallExpr
        op[932] = getOpcodeRnm(120, 1010); // substringMethodCallExpr
        op[933] = getOpcodeRnm(124, 1048); // concatMethodCallExpr
        op[934] = getOpcodeRnm(118, 992); // lengthMethodCallExpr
        op[935] = getOpcodeRnm(125, 1059); // yearMethodCallExpr
        op[936] = getOpcodeRnm(126, 1066); // monthMethodCallExpr
        op[937] = getOpcodeRnm(127, 1073); // dayMethodCallExpr
        op[938] = getOpcodeRnm(128, 1080); // hourMethodCallExpr
        op[939] = getOpcodeRnm(129, 1087); // minuteMethodCallExpr
        op[940] = getOpcodeRnm(130, 1094); // secondMethodCallExpr
        op[941] = getOpcodeRnm(131, 1101); // fractionalsecondsMethodCallExpr
        op[942] = getOpcodeRnm(132, 1108); // totalsecondsMethodCallExpr
        op[943] = getOpcodeRnm(133, 1115); // dateMethodCallExpr
        op[944] = getOpcodeRnm(134, 1122); // timeMethodCallExpr
        op[945] = getOpcodeRnm(139, 1148); // roundMethodCallExpr
        op[946] = getOpcodeRnm(140, 1155); // floorMethodCallExpr
        op[947] = getOpcodeRnm(141, 1162); // ceilingMethodCallExpr
        op[948] = getOpcodeRnm(142, 1169); // distanceMethodCallExpr
        op[949] = getOpcodeRnm(143, 1180); // geoLengthMethodCallExpr
        op[950] = getOpcodeRnm(135, 1129); // totalOffsetMinutesMethodCallExpr
        op[951] = getOpcodeRnm(136, 1136); // minDateTimeMethodCallExpr
        op[952] = getOpcodeRnm(137, 1140); // maxDateTimeMethodCallExpr
        op[953] = getOpcodeRnm(138, 1144); // nowMethodCallExpr
        {int[] a = {955,956,957,958}; op[954] = getOpcodeAlt(a);}
        op[955] = getOpcodeRnm(117, 981); // endsWithMethodCallExpr
        op[956] = getOpcodeRnm(116, 970); // startsWithMethodCallExpr
        op[957] = getOpcodeRnm(115, 959); // containsMethodCallExpr
        op[958] = getOpcodeRnm(144, 1187); // intersectsMethodCallExpr
        {int[] a = {960,961,962,963,964,965,966,967,968,969}; op[959] = getOpcodeCat(a);}
        {char[] a = {99,111,110,116,97,105,110,115}; op[960] = getOpcodeTbs(a);}
        op[961] = getOpcodeRnm(348, 2337); // OPEN
        op[962] = getOpcodeRnm(339, 2313); // BWS
        op[963] = getOpcodeRnm(92, 718); // commonExpr
        op[964] = getOpcodeRnm(339, 2313); // BWS
        op[965] = getOpcodeRnm(342, 2320); // COMMA
        op[966] = getOpcodeRnm(339, 2313); // BWS
        op[967] = getOpcodeRnm(92, 718); // commonExpr
        op[968] = getOpcodeRnm(339, 2313); // BWS
        op[969] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {971,972,973,974,975,976,977,978,979,980}; op[970] = getOpcodeCat(a);}
        {char[] a = {115,116,97,114,116,115,119,105,116,104}; op[971] = getOpcodeTbs(a);}
        op[972] = getOpcodeRnm(348, 2337); // OPEN
        op[973] = getOpcodeRnm(339, 2313); // BWS
        op[974] = getOpcodeRnm(92, 718); // commonExpr
        op[975] = getOpcodeRnm(339, 2313); // BWS
        op[976] = getOpcodeRnm(342, 2320); // COMMA
        op[977] = getOpcodeRnm(339, 2313); // BWS
        op[978] = getOpcodeRnm(92, 718); // commonExpr
        op[979] = getOpcodeRnm(339, 2313); // BWS
        op[980] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {982,983,984,985,986,987,988,989,990,991}; op[981] = getOpcodeCat(a);}
        {char[] a = {101,110,100,115,119,105,116,104}; op[982] = getOpcodeTbs(a);}
        op[983] = getOpcodeRnm(348, 2337); // OPEN
        op[984] = getOpcodeRnm(339, 2313); // BWS
        op[985] = getOpcodeRnm(92, 718); // commonExpr
        op[986] = getOpcodeRnm(339, 2313); // BWS
        op[987] = getOpcodeRnm(342, 2320); // COMMA
        op[988] = getOpcodeRnm(339, 2313); // BWS
        op[989] = getOpcodeRnm(92, 718); // commonExpr
        op[990] = getOpcodeRnm(339, 2313); // BWS
        op[991] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {993,994,995,996,997,998}; op[992] = getOpcodeCat(a);}
        {char[] a = {108,101,110,103,116,104}; op[993] = getOpcodeTbs(a);}
        op[994] = getOpcodeRnm(348, 2337); // OPEN
        op[995] = getOpcodeRnm(339, 2313); // BWS
        op[996] = getOpcodeRnm(92, 718); // commonExpr
        op[997] = getOpcodeRnm(339, 2313); // BWS
        op[998] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1000,1001,1002,1003,1004,1005,1006,1007,1008,1009}; op[999] = getOpcodeCat(a);}
        {char[] a = {105,110,100,101,120,111,102}; op[1000] = getOpcodeTbs(a);}
        op[1001] = getOpcodeRnm(348, 2337); // OPEN
        op[1002] = getOpcodeRnm(339, 2313); // BWS
        op[1003] = getOpcodeRnm(92, 718); // commonExpr
        op[1004] = getOpcodeRnm(339, 2313); // BWS
        op[1005] = getOpcodeRnm(342, 2320); // COMMA
        op[1006] = getOpcodeRnm(339, 2313); // BWS
        op[1007] = getOpcodeRnm(92, 718); // commonExpr
        op[1008] = getOpcodeRnm(339, 2313); // BWS
        op[1009] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1011,1012,1013,1014,1015,1016,1017,1018,1019,1020,1026}; op[1010] = getOpcodeCat(a);}
        {char[] a = {115,117,98,115,116,114,105,110,103}; op[1011] = getOpcodeTbs(a);}
        op[1012] = getOpcodeRnm(348, 2337); // OPEN
        op[1013] = getOpcodeRnm(339, 2313); // BWS
        op[1014] = getOpcodeRnm(92, 718); // commonExpr
        op[1015] = getOpcodeRnm(339, 2313); // BWS
        op[1016] = getOpcodeRnm(342, 2320); // COMMA
        op[1017] = getOpcodeRnm(339, 2313); // BWS
        op[1018] = getOpcodeRnm(92, 718); // commonExpr
        op[1019] = getOpcodeRnm(339, 2313); // BWS
        op[1020] = getOpcodeRep((char)0, (char)1, 1021);
        {int[] a = {1022,1023,1024,1025}; op[1021] = getOpcodeCat(a);}
        op[1022] = getOpcodeRnm(342, 2320); // COMMA
        op[1023] = getOpcodeRnm(339, 2313); // BWS
        op[1024] = getOpcodeRnm(92, 718); // commonExpr
        op[1025] = getOpcodeRnm(339, 2313); // BWS
        op[1026] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1028,1029,1030,1031,1032,1033}; op[1027] = getOpcodeCat(a);}
        {char[] a = {116,111,108,111,119,101,114}; op[1028] = getOpcodeTbs(a);}
        op[1029] = getOpcodeRnm(348, 2337); // OPEN
        op[1030] = getOpcodeRnm(339, 2313); // BWS
        op[1031] = getOpcodeRnm(92, 718); // commonExpr
        op[1032] = getOpcodeRnm(339, 2313); // BWS
        op[1033] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1035,1036,1037,1038,1039,1040}; op[1034] = getOpcodeCat(a);}
        {char[] a = {116,111,117,112,112,101,114}; op[1035] = getOpcodeTbs(a);}
        op[1036] = getOpcodeRnm(348, 2337); // OPEN
        op[1037] = getOpcodeRnm(339, 2313); // BWS
        op[1038] = getOpcodeRnm(92, 718); // commonExpr
        op[1039] = getOpcodeRnm(339, 2313); // BWS
        op[1040] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1042,1043,1044,1045,1046,1047}; op[1041] = getOpcodeCat(a);}
        {char[] a = {116,114,105,109}; op[1042] = getOpcodeTbs(a);}
        op[1043] = getOpcodeRnm(348, 2337); // OPEN
        op[1044] = getOpcodeRnm(339, 2313); // BWS
        op[1045] = getOpcodeRnm(92, 718); // commonExpr
        op[1046] = getOpcodeRnm(339, 2313); // BWS
        op[1047] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1049,1050,1051,1052,1053,1054,1055,1056,1057,1058}; op[1048] = getOpcodeCat(a);}
        {char[] a = {99,111,110,99,97,116}; op[1049] = getOpcodeTbs(a);}
        op[1050] = getOpcodeRnm(348, 2337); // OPEN
        op[1051] = getOpcodeRnm(339, 2313); // BWS
        op[1052] = getOpcodeRnm(92, 718); // commonExpr
        op[1053] = getOpcodeRnm(339, 2313); // BWS
        op[1054] = getOpcodeRnm(342, 2320); // COMMA
        op[1055] = getOpcodeRnm(339, 2313); // BWS
        op[1056] = getOpcodeRnm(92, 718); // commonExpr
        op[1057] = getOpcodeRnm(339, 2313); // BWS
        op[1058] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1060,1061,1062,1063,1064,1065}; op[1059] = getOpcodeCat(a);}
        {char[] a = {121,101,97,114}; op[1060] = getOpcodeTbs(a);}
        op[1061] = getOpcodeRnm(348, 2337); // OPEN
        op[1062] = getOpcodeRnm(339, 2313); // BWS
        op[1063] = getOpcodeRnm(92, 718); // commonExpr
        op[1064] = getOpcodeRnm(339, 2313); // BWS
        op[1065] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1067,1068,1069,1070,1071,1072}; op[1066] = getOpcodeCat(a);}
        {char[] a = {109,111,110,116,104}; op[1067] = getOpcodeTbs(a);}
        op[1068] = getOpcodeRnm(348, 2337); // OPEN
        op[1069] = getOpcodeRnm(339, 2313); // BWS
        op[1070] = getOpcodeRnm(92, 718); // commonExpr
        op[1071] = getOpcodeRnm(339, 2313); // BWS
        op[1072] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1074,1075,1076,1077,1078,1079}; op[1073] = getOpcodeCat(a);}
        {char[] a = {100,97,121}; op[1074] = getOpcodeTbs(a);}
        op[1075] = getOpcodeRnm(348, 2337); // OPEN
        op[1076] = getOpcodeRnm(339, 2313); // BWS
        op[1077] = getOpcodeRnm(92, 718); // commonExpr
        op[1078] = getOpcodeRnm(339, 2313); // BWS
        op[1079] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1081,1082,1083,1084,1085,1086}; op[1080] = getOpcodeCat(a);}
        {char[] a = {104,111,117,114}; op[1081] = getOpcodeTbs(a);}
        op[1082] = getOpcodeRnm(348, 2337); // OPEN
        op[1083] = getOpcodeRnm(339, 2313); // BWS
        op[1084] = getOpcodeRnm(92, 718); // commonExpr
        op[1085] = getOpcodeRnm(339, 2313); // BWS
        op[1086] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1088,1089,1090,1091,1092,1093}; op[1087] = getOpcodeCat(a);}
        {char[] a = {109,105,110,117,116,101}; op[1088] = getOpcodeTbs(a);}
        op[1089] = getOpcodeRnm(348, 2337); // OPEN
        op[1090] = getOpcodeRnm(339, 2313); // BWS
        op[1091] = getOpcodeRnm(92, 718); // commonExpr
        op[1092] = getOpcodeRnm(339, 2313); // BWS
        op[1093] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1095,1096,1097,1098,1099,1100}; op[1094] = getOpcodeCat(a);}
        {char[] a = {115,101,99,111,110,100}; op[1095] = getOpcodeTbs(a);}
        op[1096] = getOpcodeRnm(348, 2337); // OPEN
        op[1097] = getOpcodeRnm(339, 2313); // BWS
        op[1098] = getOpcodeRnm(92, 718); // commonExpr
        op[1099] = getOpcodeRnm(339, 2313); // BWS
        op[1100] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1102,1103,1104,1105,1106,1107}; op[1101] = getOpcodeCat(a);}
        {char[] a = {102,114,97,99,116,105,111,110,97,108,115,101,99,111,110,100,115}; op[1102] = getOpcodeTbs(a);}
        op[1103] = getOpcodeRnm(348, 2337); // OPEN
        op[1104] = getOpcodeRnm(339, 2313); // BWS
        op[1105] = getOpcodeRnm(92, 718); // commonExpr
        op[1106] = getOpcodeRnm(339, 2313); // BWS
        op[1107] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1109,1110,1111,1112,1113,1114}; op[1108] = getOpcodeCat(a);}
        {char[] a = {116,111,116,97,108,115,101,99,111,110,100,115}; op[1109] = getOpcodeTbs(a);}
        op[1110] = getOpcodeRnm(348, 2337); // OPEN
        op[1111] = getOpcodeRnm(339, 2313); // BWS
        op[1112] = getOpcodeRnm(92, 718); // commonExpr
        op[1113] = getOpcodeRnm(339, 2313); // BWS
        op[1114] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1116,1117,1118,1119,1120,1121}; op[1115] = getOpcodeCat(a);}
        {char[] a = {100,97,116,101}; op[1116] = getOpcodeTbs(a);}
        op[1117] = getOpcodeRnm(348, 2337); // OPEN
        op[1118] = getOpcodeRnm(339, 2313); // BWS
        op[1119] = getOpcodeRnm(92, 718); // commonExpr
        op[1120] = getOpcodeRnm(339, 2313); // BWS
        op[1121] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1123,1124,1125,1126,1127,1128}; op[1122] = getOpcodeCat(a);}
        {char[] a = {116,105,109,101}; op[1123] = getOpcodeTbs(a);}
        op[1124] = getOpcodeRnm(348, 2337); // OPEN
        op[1125] = getOpcodeRnm(339, 2313); // BWS
        op[1126] = getOpcodeRnm(92, 718); // commonExpr
        op[1127] = getOpcodeRnm(339, 2313); // BWS
        op[1128] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1130,1131,1132,1133,1134,1135}; op[1129] = getOpcodeCat(a);}
        {char[] a = {116,111,116,97,108,111,102,102,115,101,116,109,105,110,117,116,101,115}; op[1130] = getOpcodeTbs(a);}
        op[1131] = getOpcodeRnm(348, 2337); // OPEN
        op[1132] = getOpcodeRnm(339, 2313); // BWS
        op[1133] = getOpcodeRnm(92, 718); // commonExpr
        op[1134] = getOpcodeRnm(339, 2313); // BWS
        op[1135] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1137,1138,1139}; op[1136] = getOpcodeCat(a);}
        {char[] a = {109,105,110,100,97,116,101,116,105,109,101,40}; op[1137] = getOpcodeTbs(a);}
        op[1138] = getOpcodeRnm(339, 2313); // BWS
        {char[] a = {41}; op[1139] = getOpcodeTbs(a);}
        {int[] a = {1141,1142,1143}; op[1140] = getOpcodeCat(a);}
        {char[] a = {109,97,120,100,97,116,101,116,105,109,101,40}; op[1141] = getOpcodeTbs(a);}
        op[1142] = getOpcodeRnm(339, 2313); // BWS
        {char[] a = {41}; op[1143] = getOpcodeTbs(a);}
        {int[] a = {1145,1146,1147}; op[1144] = getOpcodeCat(a);}
        {char[] a = {110,111,119,40}; op[1145] = getOpcodeTbs(a);}
        op[1146] = getOpcodeRnm(339, 2313); // BWS
        {char[] a = {41}; op[1147] = getOpcodeTbs(a);}
        {int[] a = {1149,1150,1151,1152,1153,1154}; op[1148] = getOpcodeCat(a);}
        {char[] a = {114,111,117,110,100}; op[1149] = getOpcodeTbs(a);}
        op[1150] = getOpcodeRnm(348, 2337); // OPEN
        op[1151] = getOpcodeRnm(339, 2313); // BWS
        op[1152] = getOpcodeRnm(92, 718); // commonExpr
        op[1153] = getOpcodeRnm(339, 2313); // BWS
        op[1154] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1156,1157,1158,1159,1160,1161}; op[1155] = getOpcodeCat(a);}
        {char[] a = {102,108,111,111,114}; op[1156] = getOpcodeTbs(a);}
        op[1157] = getOpcodeRnm(348, 2337); // OPEN
        op[1158] = getOpcodeRnm(339, 2313); // BWS
        op[1159] = getOpcodeRnm(92, 718); // commonExpr
        op[1160] = getOpcodeRnm(339, 2313); // BWS
        op[1161] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1163,1164,1165,1166,1167,1168}; op[1162] = getOpcodeCat(a);}
        {char[] a = {99,101,105,108,105,110,103}; op[1163] = getOpcodeTbs(a);}
        op[1164] = getOpcodeRnm(348, 2337); // OPEN
        op[1165] = getOpcodeRnm(339, 2313); // BWS
        op[1166] = getOpcodeRnm(92, 718); // commonExpr
        op[1167] = getOpcodeRnm(339, 2313); // BWS
        op[1168] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1170,1171,1172,1173,1174,1175,1176,1177,1178,1179}; op[1169] = getOpcodeCat(a);}
        {char[] a = {103,101,111,46,100,105,115,116,97,110,99,101}; op[1170] = getOpcodeTbs(a);}
        op[1171] = getOpcodeRnm(348, 2337); // OPEN
        op[1172] = getOpcodeRnm(339, 2313); // BWS
        op[1173] = getOpcodeRnm(92, 718); // commonExpr
        op[1174] = getOpcodeRnm(339, 2313); // BWS
        op[1175] = getOpcodeRnm(342, 2320); // COMMA
        op[1176] = getOpcodeRnm(339, 2313); // BWS
        op[1177] = getOpcodeRnm(92, 718); // commonExpr
        op[1178] = getOpcodeRnm(339, 2313); // BWS
        op[1179] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1181,1182,1183,1184,1185,1186}; op[1180] = getOpcodeCat(a);}
        {char[] a = {103,101,111,46,108,101,110,103,116,104}; op[1181] = getOpcodeTbs(a);}
        op[1182] = getOpcodeRnm(348, 2337); // OPEN
        op[1183] = getOpcodeRnm(339, 2313); // BWS
        op[1184] = getOpcodeRnm(92, 718); // commonExpr
        op[1185] = getOpcodeRnm(339, 2313); // BWS
        op[1186] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1188,1189,1190,1191,1192,1193,1194,1195,1196,1197}; op[1187] = getOpcodeCat(a);}
        {char[] a = {103,101,111,46,105,110,116,101,114,115,101,99,116,115}; op[1188] = getOpcodeTbs(a);}
        op[1189] = getOpcodeRnm(348, 2337); // OPEN
        op[1190] = getOpcodeRnm(339, 2313); // BWS
        op[1191] = getOpcodeRnm(92, 718); // commonExpr
        op[1192] = getOpcodeRnm(339, 2313); // BWS
        op[1193] = getOpcodeRnm(342, 2320); // COMMA
        op[1194] = getOpcodeRnm(339, 2313); // BWS
        op[1195] = getOpcodeRnm(92, 718); // commonExpr
        op[1196] = getOpcodeRnm(339, 2313); // BWS
        op[1197] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1199,1200,1201,1202,1203}; op[1198] = getOpcodeCat(a);}
        op[1199] = getOpcodeRnm(348, 2337); // OPEN
        op[1200] = getOpcodeRnm(339, 2313); // BWS
        op[1201] = getOpcodeRnm(93, 737); // boolCommonExpr
        op[1202] = getOpcodeRnm(339, 2313); // BWS
        op[1203] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1205,1206,1207,1208,1209}; op[1204] = getOpcodeCat(a);}
        op[1205] = getOpcodeRnm(348, 2337); // OPEN
        op[1206] = getOpcodeRnm(339, 2313); // BWS
        op[1207] = getOpcodeRnm(92, 718); // commonExpr
        op[1208] = getOpcodeRnm(339, 2313); // BWS
        op[1209] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1211,1212,1213,1214}; op[1210] = getOpcodeCat(a);}
        op[1211] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {97,110,100}; op[1212] = getOpcodeTbs(a);}
        op[1213] = getOpcodeRnm(338, 2307); // RWS
        op[1214] = getOpcodeRnm(93, 737); // boolCommonExpr
        {int[] a = {1216,1217,1218,1219}; op[1215] = getOpcodeCat(a);}
        op[1216] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {111,114}; op[1217] = getOpcodeTbs(a);}
        op[1218] = getOpcodeRnm(338, 2307); // RWS
        op[1219] = getOpcodeRnm(93, 737); // boolCommonExpr
        {int[] a = {1221,1222,1223,1224}; op[1220] = getOpcodeCat(a);}
        op[1221] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {101,113}; op[1222] = getOpcodeTbs(a);}
        op[1223] = getOpcodeRnm(338, 2307); // RWS
        op[1224] = getOpcodeRnm(92, 718); // commonExpr
        {int[] a = {1226,1227,1228,1229}; op[1225] = getOpcodeCat(a);}
        op[1226] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {110,101}; op[1227] = getOpcodeTbs(a);}
        op[1228] = getOpcodeRnm(338, 2307); // RWS
        op[1229] = getOpcodeRnm(92, 718); // commonExpr
        {int[] a = {1231,1232,1233,1234}; op[1230] = getOpcodeCat(a);}
        op[1231] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {108,116}; op[1232] = getOpcodeTbs(a);}
        op[1233] = getOpcodeRnm(338, 2307); // RWS
        op[1234] = getOpcodeRnm(92, 718); // commonExpr
        {int[] a = {1236,1237,1238,1239}; op[1235] = getOpcodeCat(a);}
        op[1236] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {108,101}; op[1237] = getOpcodeTbs(a);}
        op[1238] = getOpcodeRnm(338, 2307); // RWS
        op[1239] = getOpcodeRnm(92, 718); // commonExpr
        {int[] a = {1241,1242,1243,1244}; op[1240] = getOpcodeCat(a);}
        op[1241] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {103,116}; op[1242] = getOpcodeTbs(a);}
        op[1243] = getOpcodeRnm(338, 2307); // RWS
        op[1244] = getOpcodeRnm(92, 718); // commonExpr
        {int[] a = {1246,1247,1248,1249}; op[1245] = getOpcodeCat(a);}
        op[1246] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {103,101}; op[1247] = getOpcodeTbs(a);}
        op[1248] = getOpcodeRnm(338, 2307); // RWS
        op[1249] = getOpcodeRnm(92, 718); // commonExpr
        {int[] a = {1251,1252,1253,1254}; op[1250] = getOpcodeCat(a);}
        op[1251] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {104,97,115}; op[1252] = getOpcodeTbs(a);}
        op[1253] = getOpcodeRnm(338, 2307); // RWS
        op[1254] = getOpcodeRnm(92, 718); // commonExpr
        {int[] a = {1256,1257,1258,1259}; op[1255] = getOpcodeCat(a);}
        op[1256] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {97,100,100}; op[1257] = getOpcodeTbs(a);}
        op[1258] = getOpcodeRnm(338, 2307); // RWS
        op[1259] = getOpcodeRnm(92, 718); // commonExpr
        {int[] a = {1261,1262,1263,1264}; op[1260] = getOpcodeCat(a);}
        op[1261] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {115,117,98}; op[1262] = getOpcodeTbs(a);}
        op[1263] = getOpcodeRnm(338, 2307); // RWS
        op[1264] = getOpcodeRnm(92, 718); // commonExpr
        {int[] a = {1266,1267,1268,1269}; op[1265] = getOpcodeCat(a);}
        op[1266] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {109,117,108}; op[1267] = getOpcodeTbs(a);}
        op[1268] = getOpcodeRnm(338, 2307); // RWS
        op[1269] = getOpcodeRnm(92, 718); // commonExpr
        {int[] a = {1271,1272,1273,1274}; op[1270] = getOpcodeCat(a);}
        op[1271] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {100,105,118}; op[1272] = getOpcodeTbs(a);}
        op[1273] = getOpcodeRnm(338, 2307); // RWS
        op[1274] = getOpcodeRnm(92, 718); // commonExpr
        {int[] a = {1276,1277,1278,1279}; op[1275] = getOpcodeCat(a);}
        op[1276] = getOpcodeRnm(338, 2307); // RWS
        {char[] a = {109,111,100}; op[1277] = getOpcodeTbs(a);}
        op[1278] = getOpcodeRnm(338, 2307); // RWS
        op[1279] = getOpcodeRnm(92, 718); // commonExpr
        {int[] a = {1281,1282,1283}; op[1280] = getOpcodeCat(a);}
        {char[] a = {45}; op[1281] = getOpcodeTls(a);}
        op[1282] = getOpcodeRnm(339, 2313); // BWS
        op[1283] = getOpcodeRnm(92, 718); // commonExpr
        {int[] a = {1285,1286,1287}; op[1284] = getOpcodeCat(a);}
        {char[] a = {110,111,116}; op[1285] = getOpcodeTbs(a);}
        op[1286] = getOpcodeRnm(338, 2307); // RWS
        op[1287] = getOpcodeRnm(93, 737); // boolCommonExpr
        {int[] a = {1289,1290,1291,1292,1298,1299,1300}; op[1288] = getOpcodeCat(a);}
        {char[] a = {105,115,111,102}; op[1289] = getOpcodeTbs(a);}
        op[1290] = getOpcodeRnm(348, 2337); // OPEN
        op[1291] = getOpcodeRnm(339, 2313); // BWS
        op[1292] = getOpcodeRep((char)0, (char)1, 1293);
        {int[] a = {1294,1295,1296,1297}; op[1293] = getOpcodeCat(a);}
        op[1294] = getOpcodeRnm(92, 718); // commonExpr
        op[1295] = getOpcodeRnm(339, 2313); // BWS
        op[1296] = getOpcodeRnm(342, 2320); // COMMA
        op[1297] = getOpcodeRnm(339, 2313); // BWS
        op[1298] = getOpcodeRnm(194, 1529); // qualifiedTypeName
        op[1299] = getOpcodeRnm(339, 2313); // BWS
        op[1300] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1302,1303,1304,1305,1311,1312,1313}; op[1301] = getOpcodeCat(a);}
        {char[] a = {99,97,115,116}; op[1302] = getOpcodeTbs(a);}
        op[1303] = getOpcodeRnm(348, 2337); // OPEN
        op[1304] = getOpcodeRnm(339, 2313); // BWS
        op[1305] = getOpcodeRep((char)0, (char)1, 1306);
        {int[] a = {1307,1308,1309,1310}; op[1306] = getOpcodeCat(a);}
        op[1307] = getOpcodeRnm(92, 718); // commonExpr
        op[1308] = getOpcodeRnm(339, 2313); // BWS
        op[1309] = getOpcodeRnm(342, 2320); // COMMA
        op[1310] = getOpcodeRnm(339, 2313); // BWS
        op[1311] = getOpcodeRnm(194, 1529); // qualifiedTypeName
        op[1312] = getOpcodeRnm(339, 2313); // BWS
        op[1313] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1315,1316,1317,1318}; op[1314] = getOpcodeAlt(a);}
        op[1315] = getOpcodeRnm(166, 1319); // complexColInUri
        op[1316] = getOpcodeRnm(167, 1329); // complexInUri
        op[1317] = getOpcodeRnm(176, 1411); // rootExprCol
        op[1318] = getOpcodeRnm(169, 1362); // primitiveColInUri
        {int[] a = {1320,1321,1328}; op[1319] = getOpcodeCat(a);}
        op[1320] = getOpcodeRnm(179, 1433); // begin-array
        op[1321] = getOpcodeRep((char)0, (char)1, 1322);
        {int[] a = {1323,1324}; op[1322] = getOpcodeCat(a);}
        op[1323] = getOpcodeRnm(167, 1329); // complexInUri
        op[1324] = getOpcodeRep((char)0, Character.MAX_VALUE, 1325);
        {int[] a = {1326,1327}; op[1325] = getOpcodeCat(a);}
        op[1326] = getOpcodeRnm(183, 1452); // value-separator
        op[1327] = getOpcodeRnm(167, 1329); // complexInUri
        op[1328] = getOpcodeRnm(180, 1439); // end-array
        {int[] a = {1330,1331,1348}; op[1329] = getOpcodeCat(a);}
        op[1330] = getOpcodeRnm(177, 1421); // begin-object
        op[1331] = getOpcodeRep((char)0, (char)1, 1332);
        {int[] a = {1333,1339}; op[1332] = getOpcodeCat(a);}
        {int[] a = {1334,1335,1336,1337,1338}; op[1333] = getOpcodeAlt(a);}
        op[1334] = getOpcodeRnm(171, 1378); // annotationInUri
        op[1335] = getOpcodeRnm(172, 1390); // primitivePropertyInUri
        op[1336] = getOpcodeRnm(170, 1372); // complexPropertyInUri
        op[1337] = getOpcodeRnm(168, 1349); // collectionPropertyInUri
        op[1338] = getOpcodeRnm(173, 1396); // navigationPropertyInUri
        op[1339] = getOpcodeRep((char)0, Character.MAX_VALUE, 1340);
        {int[] a = {1341,1342}; op[1340] = getOpcodeCat(a);}
        op[1341] = getOpcodeRnm(183, 1452); // value-separator
        {int[] a = {1343,1344,1345,1346,1347}; op[1342] = getOpcodeAlt(a);}
        op[1343] = getOpcodeRnm(171, 1378); // annotationInUri
        op[1344] = getOpcodeRnm(172, 1390); // primitivePropertyInUri
        op[1345] = getOpcodeRnm(170, 1372); // complexPropertyInUri
        op[1346] = getOpcodeRnm(168, 1349); // collectionPropertyInUri
        op[1347] = getOpcodeRnm(173, 1396); // navigationPropertyInUri
        op[1348] = getOpcodeRnm(178, 1427); // end-object
        {int[] a = {1350,1356}; op[1349] = getOpcodeAlt(a);}
        {int[] a = {1351,1352,1353,1354,1355}; op[1350] = getOpcodeCat(a);}
        op[1351] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1352] = getOpcodeRnm(218, 1618); // primitiveColProperty
        op[1353] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1354] = getOpcodeRnm(182, 1448); // name-separator
        op[1355] = getOpcodeRnm(169, 1362); // primitiveColInUri
        {int[] a = {1357,1358,1359,1360,1361}; op[1356] = getOpcodeCat(a);}
        op[1357] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1358] = getOpcodeRnm(220, 1620); // complexColProperty
        op[1359] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1360] = getOpcodeRnm(182, 1448); // name-separator
        op[1361] = getOpcodeRnm(166, 1319); // complexColInUri
        {int[] a = {1363,1364,1371}; op[1362] = getOpcodeCat(a);}
        op[1363] = getOpcodeRnm(179, 1433); // begin-array
        op[1364] = getOpcodeRep((char)0, (char)1, 1365);
        {int[] a = {1366,1367}; op[1365] = getOpcodeCat(a);}
        op[1366] = getOpcodeRnm(184, 1456); // primitiveLiteralInJSON
        op[1367] = getOpcodeRep((char)0, Character.MAX_VALUE, 1368);
        {int[] a = {1369,1370}; op[1368] = getOpcodeCat(a);}
        op[1369] = getOpcodeRnm(183, 1452); // value-separator
        op[1370] = getOpcodeRnm(184, 1456); // primitiveLiteralInJSON
        op[1371] = getOpcodeRnm(180, 1439); // end-array
        {int[] a = {1373,1374,1375,1376,1377}; op[1372] = getOpcodeCat(a);}
        op[1373] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1374] = getOpcodeRnm(219, 1619); // complexProperty
        op[1375] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1376] = getOpcodeRnm(182, 1448); // name-separator
        op[1377] = getOpcodeRnm(167, 1329); // complexInUri
        {int[] a = {1379,1380,1381,1382,1383,1384,1385}; op[1378] = getOpcodeCat(a);}
        op[1379] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1380] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[1381] = getOpcodeTls(a);}
        op[1382] = getOpcodeRnm(208, 1566); // termName
        op[1383] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1384] = getOpcodeRnm(182, 1448); // name-separator
        {int[] a = {1386,1387,1388,1389}; op[1385] = getOpcodeAlt(a);}
        op[1386] = getOpcodeRnm(167, 1329); // complexInUri
        op[1387] = getOpcodeRnm(166, 1319); // complexColInUri
        op[1388] = getOpcodeRnm(184, 1456); // primitiveLiteralInJSON
        op[1389] = getOpcodeRnm(169, 1362); // primitiveColInUri
        {int[] a = {1391,1392,1393,1394,1395}; op[1390] = getOpcodeCat(a);}
        op[1391] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1392] = getOpcodeRnm(215, 1613); // primitiveProperty
        op[1393] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1394] = getOpcodeRnm(182, 1448); // name-separator
        op[1395] = getOpcodeRnm(184, 1456); // primitiveLiteralInJSON
        {int[] a = {1397,1398}; op[1396] = getOpcodeAlt(a);}
        op[1397] = getOpcodeRnm(174, 1399); // singleNavPropInJSON
        op[1398] = getOpcodeRnm(175, 1405); // collectionNavPropInJSON
        {int[] a = {1400,1401,1402,1403,1404}; op[1399] = getOpcodeCat(a);}
        op[1400] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1401] = getOpcodeRnm(223, 1625); // entityNavigationProperty
        op[1402] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1403] = getOpcodeRnm(182, 1448); // name-separator
        op[1404] = getOpcodeRnm(94, 758); // rootExpr
        {int[] a = {1406,1407,1408,1409,1410}; op[1405] = getOpcodeCat(a);}
        op[1406] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1407] = getOpcodeRnm(224, 1626); // entityColNavigationProperty
        op[1408] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1409] = getOpcodeRnm(182, 1448); // name-separator
        op[1410] = getOpcodeRnm(176, 1411); // rootExprCol
        {int[] a = {1412,1413,1420}; op[1411] = getOpcodeCat(a);}
        op[1412] = getOpcodeRnm(179, 1433); // begin-array
        op[1413] = getOpcodeRep((char)0, (char)1, 1414);
        {int[] a = {1415,1416}; op[1414] = getOpcodeCat(a);}
        op[1415] = getOpcodeRnm(94, 758); // rootExpr
        op[1416] = getOpcodeRep((char)0, Character.MAX_VALUE, 1417);
        {int[] a = {1418,1419}; op[1417] = getOpcodeCat(a);}
        op[1418] = getOpcodeRnm(183, 1452); // value-separator
        op[1419] = getOpcodeRnm(94, 758); // rootExpr
        op[1420] = getOpcodeRnm(180, 1439); // end-array
        {int[] a = {1422,1423,1426}; op[1421] = getOpcodeCat(a);}
        op[1422] = getOpcodeRnm(339, 2313); // BWS
        {int[] a = {1424,1425}; op[1423] = getOpcodeAlt(a);}
        {char[] a = {123}; op[1424] = getOpcodeTls(a);}
        {char[] a = {37,55,66}; op[1425] = getOpcodeTls(a);}
        op[1426] = getOpcodeRnm(339, 2313); // BWS
        {int[] a = {1428,1429,1432}; op[1427] = getOpcodeCat(a);}
        op[1428] = getOpcodeRnm(339, 2313); // BWS
        {int[] a = {1430,1431}; op[1429] = getOpcodeAlt(a);}
        {char[] a = {125}; op[1430] = getOpcodeTls(a);}
        {char[] a = {37,55,68}; op[1431] = getOpcodeTls(a);}
        op[1432] = getOpcodeRnm(339, 2313); // BWS
        {int[] a = {1434,1435,1438}; op[1433] = getOpcodeCat(a);}
        op[1434] = getOpcodeRnm(339, 2313); // BWS
        {int[] a = {1436,1437}; op[1435] = getOpcodeAlt(a);}
        {char[] a = {91}; op[1436] = getOpcodeTls(a);}
        {char[] a = {37,53,66}; op[1437] = getOpcodeTls(a);}
        op[1438] = getOpcodeRnm(339, 2313); // BWS
        {int[] a = {1440,1441,1444}; op[1439] = getOpcodeCat(a);}
        op[1440] = getOpcodeRnm(339, 2313); // BWS
        {int[] a = {1442,1443}; op[1441] = getOpcodeAlt(a);}
        {char[] a = {93}; op[1442] = getOpcodeTls(a);}
        {char[] a = {37,53,68}; op[1443] = getOpcodeTls(a);}
        op[1444] = getOpcodeRnm(339, 2313); // BWS
        {int[] a = {1446,1447}; op[1445] = getOpcodeAlt(a);}
        op[1446] = getOpcodeRnm(391, 2743); // DQUOTE
        {char[] a = {37,50,50}; op[1447] = getOpcodeTls(a);}
        {int[] a = {1449,1450,1451}; op[1448] = getOpcodeCat(a);}
        op[1449] = getOpcodeRnm(339, 2313); // BWS
        op[1450] = getOpcodeRnm(341, 2317); // COLON
        op[1451] = getOpcodeRnm(339, 2313); // BWS
        {int[] a = {1453,1454,1455}; op[1452] = getOpcodeCat(a);}
        op[1453] = getOpcodeRnm(339, 2313); // BWS
        op[1454] = getOpcodeRnm(342, 2320); // COMMA
        op[1455] = getOpcodeRnm(339, 2313); // BWS
        {int[] a = {1457,1458,1459,1460,1461}; op[1456] = getOpcodeAlt(a);}
        op[1457] = getOpcodeRnm(185, 1462); // stringInJSON
        op[1458] = getOpcodeRnm(189, 1497); // numberInJSON
        {char[] a = {116,114,117,101}; op[1459] = getOpcodeTbs(a);}
        {char[] a = {102,97,108,115,101}; op[1460] = getOpcodeTbs(a);}
        {char[] a = {110,117,108,108}; op[1461] = getOpcodeTbs(a);}
        {int[] a = {1463,1464,1466}; op[1462] = getOpcodeCat(a);}
        op[1463] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1464] = getOpcodeRep((char)0, Character.MAX_VALUE, 1465);
        op[1465] = getOpcodeRnm(186, 1467); // charInJSON
        op[1466] = getOpcodeRnm(181, 1445); // quotation-mark
        {int[] a = {1468,1469,1470}; op[1467] = getOpcodeAlt(a);}
        op[1468] = getOpcodeRnm(382, 2668); // qchar-unescaped
        op[1469] = getOpcodeRnm(187, 1487); // qchar-JSON-special
        {int[] a = {1471,1472}; op[1470] = getOpcodeCat(a);}
        op[1471] = getOpcodeRnm(188, 1494); // escape
        {int[] a = {1473,1474,1475,1478,1479,1480,1481,1482,1483}; op[1472] = getOpcodeAlt(a);}
        op[1473] = getOpcodeRnm(181, 1445); // quotation-mark
        op[1474] = getOpcodeRnm(188, 1494); // escape
        {int[] a = {1476,1477}; op[1475] = getOpcodeAlt(a);}
        {char[] a = {47}; op[1476] = getOpcodeTls(a);}
        {char[] a = {37,50,70}; op[1477] = getOpcodeTls(a);}
        {char[] a = {98}; op[1478] = getOpcodeTbs(a);}
        {char[] a = {102}; op[1479] = getOpcodeTbs(a);}
        {char[] a = {110}; op[1480] = getOpcodeTbs(a);}
        {char[] a = {114}; op[1481] = getOpcodeTbs(a);}
        {char[] a = {116}; op[1482] = getOpcodeTbs(a);}
        {int[] a = {1484,1485}; op[1483] = getOpcodeCat(a);}
        {char[] a = {117}; op[1484] = getOpcodeTbs(a);}
        op[1485] = getOpcodeRep((char)4, (char)4, 1486);
        op[1486] = getOpcodeRnm(389, 2733); // HEXDIG
        {int[] a = {1488,1489,1490,1491,1492,1493}; op[1487] = getOpcodeAlt(a);}
        op[1488] = getOpcodeRnm(392, 2744); // SP
        {char[] a = {58}; op[1489] = getOpcodeTls(a);}
        {char[] a = {123}; op[1490] = getOpcodeTls(a);}
        {char[] a = {125}; op[1491] = getOpcodeTls(a);}
        {char[] a = {91}; op[1492] = getOpcodeTls(a);}
        {char[] a = {93}; op[1493] = getOpcodeTls(a);}
        {int[] a = {1495,1496}; op[1494] = getOpcodeAlt(a);}
        {char[] a = {92}; op[1495] = getOpcodeTls(a);}
        {char[] a = {37,53,67}; op[1496] = getOpcodeTls(a);}
        {int[] a = {1498,1500,1501,1503}; op[1497] = getOpcodeCat(a);}
        op[1498] = getOpcodeRep((char)0, (char)1, 1499);
        {char[] a = {45}; op[1499] = getOpcodeTls(a);}
        op[1500] = getOpcodeRnm(190, 1505); // int
        op[1501] = getOpcodeRep((char)0, (char)1, 1502);
        op[1502] = getOpcodeRnm(191, 1511); // frac
        op[1503] = getOpcodeRep((char)0, (char)1, 1504);
        op[1504] = getOpcodeRnm(192, 1515); // exp
        {int[] a = {1506,1507}; op[1505] = getOpcodeAlt(a);}
        {char[] a = {48}; op[1506] = getOpcodeTls(a);}
        {int[] a = {1508,1509}; op[1507] = getOpcodeCat(a);}
        op[1508] = getOpcodeRnm(266, 1911); // oneToNine
        op[1509] = getOpcodeRep((char)0, Character.MAX_VALUE, 1510);
        op[1510] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1512,1513}; op[1511] = getOpcodeCat(a);}
        {char[] a = {46}; op[1512] = getOpcodeTls(a);}
        op[1513] = getOpcodeRep((char)1, Character.MAX_VALUE, 1514);
        op[1514] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1516,1517,1521}; op[1515] = getOpcodeCat(a);}
        {char[] a = {101}; op[1516] = getOpcodeTls(a);}
        op[1517] = getOpcodeRep((char)0, (char)1, 1518);
        {int[] a = {1519,1520}; op[1518] = getOpcodeAlt(a);}
        {char[] a = {45}; op[1519] = getOpcodeTls(a);}
        {char[] a = {43}; op[1520] = getOpcodeTls(a);}
        op[1521] = getOpcodeRep((char)1, Character.MAX_VALUE, 1522);
        op[1522] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1524,1525,1526,1527,1528}; op[1523] = getOpcodeAlt(a);}
        op[1524] = getOpcodeRnm(195, 1536); // qualifiedEntityTypeName
        op[1525] = getOpcodeRnm(196, 1540); // qualifiedComplexTypeName
        op[1526] = getOpcodeRnm(197, 1544); // qualifiedTypeDefinitionName
        op[1527] = getOpcodeRnm(198, 1548); // qualifiedEnumTypeName
        op[1528] = getOpcodeRnm(212, 1578); // primitiveTypeName
        {int[] a = {1530,1531}; op[1529] = getOpcodeAlt(a);}
        op[1530] = getOpcodeRnm(193, 1523); // singleQualifiedTypeName
        {int[] a = {1532,1533,1534,1535}; op[1531] = getOpcodeCat(a);}
        {char[] a = {67,111,108,108,101,99,116,105,111,110}; op[1532] = getOpcodeTbs(a);}
        op[1533] = getOpcodeRnm(348, 2337); // OPEN
        op[1534] = getOpcodeRnm(193, 1523); // singleQualifiedTypeName
        op[1535] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {1537,1538,1539}; op[1536] = getOpcodeCat(a);}
        op[1537] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[1538] = getOpcodeTls(a);}
        op[1539] = getOpcodeRnm(203, 1561); // entityTypeName
        {int[] a = {1541,1542,1543}; op[1540] = getOpcodeCat(a);}
        op[1541] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[1542] = getOpcodeTls(a);}
        op[1543] = getOpcodeRnm(204, 1562); // complexTypeName
        {int[] a = {1545,1546,1547}; op[1544] = getOpcodeCat(a);}
        op[1545] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[1546] = getOpcodeTls(a);}
        op[1547] = getOpcodeRnm(205, 1563); // typeDefinitionName
        {int[] a = {1549,1550,1551}; op[1548] = getOpcodeCat(a);}
        op[1549] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[1550] = getOpcodeTls(a);}
        op[1551] = getOpcodeRnm(206, 1564); // enumerationTypeName
        {int[] a = {1553,1554}; op[1552] = getOpcodeCat(a);}
        op[1553] = getOpcodeRnm(200, 1558); // namespacePart
        op[1554] = getOpcodeRep((char)0, Character.MAX_VALUE, 1555);
        {int[] a = {1556,1557}; op[1555] = getOpcodeCat(a);}
        {char[] a = {46}; op[1556] = getOpcodeTls(a);}
        op[1557] = getOpcodeRnm(200, 1558); // namespacePart
        op[1558] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1559] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1560] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1561] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1562] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1563] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1564] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1565] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1566] = getOpcodeRnm(209, 1567); // odataIdentifier
        {int[] a = {1568,1569}; op[1567] = getOpcodeCat(a);}
        op[1568] = getOpcodeRnm(210, 1571); // identifierLeadingCharacter
        op[1569] = getOpcodeRep((char)0, (char)127, 1570);
        op[1570] = getOpcodeRnm(211, 1574); // identifierCharacter
        {int[] a = {1572,1573}; op[1571] = getOpcodeAlt(a);}
        op[1572] = getOpcodeRnm(387, 2729); // ALPHA
        {char[] a = {95}; op[1573] = getOpcodeTls(a);}
        {int[] a = {1575,1576,1577}; op[1574] = getOpcodeAlt(a);}
        op[1575] = getOpcodeRnm(387, 2729); // ALPHA
        {char[] a = {95}; op[1576] = getOpcodeTls(a);}
        op[1577] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1579,1580}; op[1578] = getOpcodeCat(a);}
        {char[] a = {69,100,109,46}; op[1579] = getOpcodeTbs(a);}
        {int[] a = {1581,1582,1583,1584,1585,1586,1587,1588,1589,1590,1591,1592,1593,1594,1595,1596,1597,1598}; op[1580] = getOpcodeAlt(a);}
        {char[] a = {66,105,110,97,114,121}; op[1581] = getOpcodeTbs(a);}
        {char[] a = {66,111,111,108,101,97,110}; op[1582] = getOpcodeTbs(a);}
        {char[] a = {66,121,116,101}; op[1583] = getOpcodeTbs(a);}
        {char[] a = {68,97,116,101}; op[1584] = getOpcodeTbs(a);}
        {char[] a = {68,97,116,101,84,105,109,101,79,102,102,115,101,116}; op[1585] = getOpcodeTbs(a);}
        {char[] a = {68,101,99,105,109,97,108}; op[1586] = getOpcodeTbs(a);}
        {char[] a = {68,111,117,98,108,101}; op[1587] = getOpcodeTbs(a);}
        {char[] a = {68,117,114,97,116,105,111,110}; op[1588] = getOpcodeTbs(a);}
        {char[] a = {71,117,105,100}; op[1589] = getOpcodeTbs(a);}
        {char[] a = {73,110,116,49,54}; op[1590] = getOpcodeTbs(a);}
        {char[] a = {73,110,116,51,50}; op[1591] = getOpcodeTbs(a);}
        {char[] a = {73,110,116,54,52}; op[1592] = getOpcodeTbs(a);}
        {char[] a = {83,66,121,116,101}; op[1593] = getOpcodeTbs(a);}
        {char[] a = {83,105,110,103,108,101}; op[1594] = getOpcodeTbs(a);}
        {char[] a = {83,116,114,101,97,109}; op[1595] = getOpcodeTbs(a);}
        {char[] a = {83,116,114,105,110,103}; op[1596] = getOpcodeTbs(a);}
        {char[] a = {84,105,109,101,79,102,68,97,121}; op[1597] = getOpcodeTbs(a);}
        {int[] a = {1599,1600}; op[1598] = getOpcodeCat(a);}
        op[1599] = getOpcodeRnm(213, 1602); // abstractSpatialTypeName
        op[1600] = getOpcodeRep((char)0, (char)1, 1601);
        op[1601] = getOpcodeRnm(214, 1605); // concreteSpatialTypeName
        {int[] a = {1603,1604}; op[1602] = getOpcodeAlt(a);}
        {char[] a = {71,101,111,103,114,97,112,104,121}; op[1603] = getOpcodeTbs(a);}
        {char[] a = {71,101,111,109,101,116,114,121}; op[1604] = getOpcodeTbs(a);}
        {int[] a = {1606,1607,1608,1609,1610,1611,1612}; op[1605] = getOpcodeAlt(a);}
        {char[] a = {67,111,108,108,101,99,116,105,111,110}; op[1606] = getOpcodeTbs(a);}
        {char[] a = {76,105,110,101,83,116,114,105,110,103}; op[1607] = getOpcodeTbs(a);}
        {char[] a = {77,117,108,116,105,76,105,110,101,83,116,114,105,110,103}; op[1608] = getOpcodeTbs(a);}
        {char[] a = {77,117,108,116,105,80,111,105,110,116}; op[1609] = getOpcodeTbs(a);}
        {char[] a = {77,117,108,116,105,80,111,108,121,103,111,110}; op[1610] = getOpcodeTbs(a);}
        {char[] a = {80,111,105,110,116}; op[1611] = getOpcodeTbs(a);}
        {char[] a = {80,111,108,121,103,111,110}; op[1612] = getOpcodeTbs(a);}
        {int[] a = {1614,1615}; op[1613] = getOpcodeAlt(a);}
        op[1614] = getOpcodeRnm(216, 1616); // primitiveKeyProperty
        op[1615] = getOpcodeRnm(217, 1617); // primitiveNonKeyProperty
        op[1616] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1617] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1618] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1619] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1620] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1621] = getOpcodeRnm(209, 1567); // odataIdentifier
        {int[] a = {1623,1624}; op[1622] = getOpcodeAlt(a);}
        op[1623] = getOpcodeRnm(223, 1625); // entityNavigationProperty
        op[1624] = getOpcodeRnm(224, 1626); // entityColNavigationProperty
        op[1625] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1626] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1627] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1628] = getOpcodeRnm(209, 1567); // odataIdentifier
        {int[] a = {1630,1631,1632,1633,1634,1635}; op[1629] = getOpcodeAlt(a);}
        op[1630] = getOpcodeRnm(228, 1636); // entityFunction
        op[1631] = getOpcodeRnm(229, 1637); // entityColFunction
        op[1632] = getOpcodeRnm(230, 1638); // complexFunction
        op[1633] = getOpcodeRnm(231, 1639); // complexColFunction
        op[1634] = getOpcodeRnm(232, 1640); // primitiveFunction
        op[1635] = getOpcodeRnm(233, 1641); // primitiveColFunction
        op[1636] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1637] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1638] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1639] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1640] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1641] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1642] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1643] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1644] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1645] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1646] = getOpcodeRnm(209, 1567); // odataIdentifier
        op[1647] = getOpcodeRnm(209, 1567); // odataIdentifier
        {int[] a = {1649,1650,1651,1652,1653,1654,1655,1656,1657,1658,1659,1660,1661,1662,1663,1664,1665,1666,1667,1668,1669,1670,1671,1672,1673,1674,1675,1676,1677,1678,1679,1680}; op[1648] = getOpcodeAlt(a);}
        op[1649] = getOpcodeRnm(242, 1705); // nullValue
        op[1650] = getOpcodeRnm(248, 1755); // booleanValue
        op[1651] = getOpcodeRnm(253, 1784); // guidValue
        op[1652] = getOpcodeRnm(261, 1831); // dateValue
        op[1653] = getOpcodeRnm(262, 1837); // dateTimeOffsetValue
        op[1654] = getOpcodeRnm(265, 1899); // timeOfDayValue
        op[1655] = getOpcodeRnm(249, 1758); // decimalValue
        op[1656] = getOpcodeRnm(250, 1768); // doubleValue
        op[1657] = getOpcodeRnm(251, 1779); // singleValue
        op[1658] = getOpcodeRnm(255, 1801); // sbyteValue
        op[1659] = getOpcodeRnm(254, 1799); // byteValue
        op[1660] = getOpcodeRnm(256, 1806); // int16Value
        op[1661] = getOpcodeRnm(257, 1811); // int32Value
        op[1662] = getOpcodeRnm(258, 1816); // int64Value
        op[1663] = getOpcodeRnm(259, 1821); // string
        op[1664] = getOpcodeRnm(263, 1862); // duration
        op[1665] = getOpcodeRnm(243, 1706); // binary
        op[1666] = getOpcodeRnm(275, 1982); // enum
        op[1667] = getOpcodeRnm(279, 1997); // geographyCollection
        op[1668] = getOpcodeRnm(283, 2021); // geographyLineString
        op[1669] = getOpcodeRnm(287, 2040); // geographyMultiLineString
        op[1670] = getOpcodeRnm(290, 2058); // geographyMultiPoint
        op[1671] = getOpcodeRnm(293, 2076); // geographyMultiPolygon
        op[1672] = getOpcodeRnm(296, 2094); // geographyPoint
        op[1673] = getOpcodeRnm(302, 2119); // geographyPolygon
        op[1674] = getOpcodeRnm(307, 2146); // geometryCollection
        op[1675] = getOpcodeRnm(308, 2151); // geometryLineString
        op[1676] = getOpcodeRnm(309, 2156); // geometryMultiLineString
        op[1677] = getOpcodeRnm(310, 2161); // geometryMultiPoint
        op[1678] = getOpcodeRnm(311, 2166); // geometryMultiPolygon
        op[1679] = getOpcodeRnm(312, 2171); // geometryPoint
        op[1680] = getOpcodeRnm(313, 2176); // geometryPolygon
        {int[] a = {1682,1683,1684,1685,1686,1687,1688,1689,1690,1691,1692,1693,1694,1695,1696,1697,1698,1699,1700,1701,1702,1703,1704}; op[1681] = getOpcodeAlt(a);}
        op[1682] = getOpcodeRnm(248, 1755); // booleanValue
        op[1683] = getOpcodeRnm(253, 1784); // guidValue
        op[1684] = getOpcodeRnm(264, 1867); // durationValue
        op[1685] = getOpcodeRnm(261, 1831); // dateValue
        op[1686] = getOpcodeRnm(262, 1837); // dateTimeOffsetValue
        op[1687] = getOpcodeRnm(265, 1899); // timeOfDayValue
        op[1688] = getOpcodeRnm(276, 1987); // enumValue
        op[1689] = getOpcodeRnm(280, 2002); // fullCollectionLiteral
        op[1690] = getOpcodeRnm(284, 2026); // fullLineStringLiteral
        op[1691] = getOpcodeRnm(291, 2063); // fullMultiPointLiteral
        op[1692] = getOpcodeRnm(288, 2045); // fullMultiLineStringLiteral
        op[1693] = getOpcodeRnm(294, 2081); // fullMultiPolygonLiteral
        op[1694] = getOpcodeRnm(297, 2099); // fullPointLiteral
        op[1695] = getOpcodeRnm(303, 2124); // fullPolygonLiteral
        op[1696] = getOpcodeRnm(249, 1758); // decimalValue
        op[1697] = getOpcodeRnm(250, 1768); // doubleValue
        op[1698] = getOpcodeRnm(251, 1779); // singleValue
        op[1699] = getOpcodeRnm(255, 1801); // sbyteValue
        op[1700] = getOpcodeRnm(254, 1799); // byteValue
        op[1701] = getOpcodeRnm(256, 1806); // int16Value
        op[1702] = getOpcodeRnm(257, 1811); // int32Value
        op[1703] = getOpcodeRnm(258, 1816); // int64Value
        op[1704] = getOpcodeRnm(244, 1711); // binaryValue
        {char[] a = {110,117,108,108}; op[1705] = getOpcodeTbs(a);}
        {int[] a = {1707,1708,1709,1710}; op[1706] = getOpcodeCat(a);}
        {char[] a = {98,105,110,97,114,121}; op[1707] = getOpcodeTls(a);}
        op[1708] = getOpcodeRnm(347, 2334); // SQUOTE
        op[1709] = getOpcodeRnm(244, 1711); // binaryValue
        op[1710] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {1712,1715}; op[1711] = getOpcodeCat(a);}
        op[1712] = getOpcodeRep((char)0, Character.MAX_VALUE, 1713);
        op[1713] = getOpcodeRep((char)4, (char)4, 1714);
        op[1714] = getOpcodeRnm(247, 1750); // base64char
        op[1715] = getOpcodeRep((char)0, (char)1, 1716);
        {int[] a = {1717,1718}; op[1716] = getOpcodeAlt(a);}
        op[1717] = getOpcodeRnm(245, 1719); // base64b16
        op[1718] = getOpcodeRnm(246, 1741); // base64b8
        {int[] a = {1720,1722,1739}; op[1719] = getOpcodeCat(a);}
        op[1720] = getOpcodeRep((char)2, (char)2, 1721);
        op[1721] = getOpcodeRnm(247, 1750); // base64char
        {int[] a = {1723,1724,1725,1726,1727,1728,1729,1730,1731,1732,1733,1734,1735,1736,1737,1738}; op[1722] = getOpcodeAlt(a);}
        {char[] a = {65}; op[1723] = getOpcodeTbs(a);}
        {char[] a = {69}; op[1724] = getOpcodeTbs(a);}
        {char[] a = {73}; op[1725] = getOpcodeTbs(a);}
        {char[] a = {77}; op[1726] = getOpcodeTbs(a);}
        {char[] a = {81}; op[1727] = getOpcodeTbs(a);}
        {char[] a = {85}; op[1728] = getOpcodeTbs(a);}
        {char[] a = {89}; op[1729] = getOpcodeTbs(a);}
        {char[] a = {99}; op[1730] = getOpcodeTbs(a);}
        {char[] a = {103}; op[1731] = getOpcodeTbs(a);}
        {char[] a = {107}; op[1732] = getOpcodeTbs(a);}
        {char[] a = {111}; op[1733] = getOpcodeTbs(a);}
        {char[] a = {115}; op[1734] = getOpcodeTbs(a);}
        {char[] a = {119}; op[1735] = getOpcodeTbs(a);}
        {char[] a = {48}; op[1736] = getOpcodeTbs(a);}
        {char[] a = {52}; op[1737] = getOpcodeTbs(a);}
        {char[] a = {56}; op[1738] = getOpcodeTbs(a);}
        op[1739] = getOpcodeRep((char)0, (char)1, 1740);
        {char[] a = {61}; op[1740] = getOpcodeTls(a);}
        {int[] a = {1742,1743,1748}; op[1741] = getOpcodeCat(a);}
        op[1742] = getOpcodeRnm(247, 1750); // base64char
        {int[] a = {1744,1745,1746,1747}; op[1743] = getOpcodeAlt(a);}
        {char[] a = {65}; op[1744] = getOpcodeTbs(a);}
        {char[] a = {81}; op[1745] = getOpcodeTbs(a);}
        {char[] a = {103}; op[1746] = getOpcodeTbs(a);}
        {char[] a = {119}; op[1747] = getOpcodeTbs(a);}
        op[1748] = getOpcodeRep((char)0, (char)1, 1749);
        {char[] a = {61,61}; op[1749] = getOpcodeTls(a);}
        {int[] a = {1751,1752,1753,1754}; op[1750] = getOpcodeAlt(a);}
        op[1751] = getOpcodeRnm(387, 2729); // ALPHA
        op[1752] = getOpcodeRnm(388, 2732); // DIGIT
        {char[] a = {45}; op[1753] = getOpcodeTls(a);}
        {char[] a = {95}; op[1754] = getOpcodeTls(a);}
        {int[] a = {1756,1757}; op[1755] = getOpcodeAlt(a);}
        {char[] a = {116,114,117,101}; op[1756] = getOpcodeTls(a);}
        {char[] a = {102,97,108,115,101}; op[1757] = getOpcodeTls(a);}
        {int[] a = {1759,1761,1763}; op[1758] = getOpcodeCat(a);}
        op[1759] = getOpcodeRep((char)0, (char)1, 1760);
        op[1760] = getOpcodeRnm(344, 2324); // SIGN
        op[1761] = getOpcodeRep((char)1, Character.MAX_VALUE, 1762);
        op[1762] = getOpcodeRnm(388, 2732); // DIGIT
        op[1763] = getOpcodeRep((char)0, (char)1, 1764);
        {int[] a = {1765,1766}; op[1764] = getOpcodeCat(a);}
        {char[] a = {46}; op[1765] = getOpcodeTls(a);}
        op[1766] = getOpcodeRep((char)1, Character.MAX_VALUE, 1767);
        op[1767] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1769,1778}; op[1768] = getOpcodeAlt(a);}
        {int[] a = {1770,1771}; op[1769] = getOpcodeCat(a);}
        op[1770] = getOpcodeRnm(249, 1758); // decimalValue
        op[1771] = getOpcodeRep((char)0, (char)1, 1772);
        {int[] a = {1773,1774,1776}; op[1772] = getOpcodeCat(a);}
        {char[] a = {101}; op[1773] = getOpcodeTls(a);}
        op[1774] = getOpcodeRep((char)0, (char)1, 1775);
        op[1775] = getOpcodeRnm(344, 2324); // SIGN
        op[1776] = getOpcodeRep((char)1, Character.MAX_VALUE, 1777);
        op[1777] = getOpcodeRnm(388, 2732); // DIGIT
        op[1778] = getOpcodeRnm(252, 1780); // nanInfinity
        op[1779] = getOpcodeRnm(250, 1768); // doubleValue
        {int[] a = {1781,1782,1783}; op[1780] = getOpcodeAlt(a);}
        {char[] a = {78,97,78}; op[1781] = getOpcodeTbs(a);}
        {char[] a = {45,73,78,70}; op[1782] = getOpcodeTbs(a);}
        {char[] a = {73,78,70}; op[1783] = getOpcodeTbs(a);}
        {int[] a = {1785,1787,1788,1790,1791,1793,1794,1796,1797}; op[1784] = getOpcodeCat(a);}
        op[1785] = getOpcodeRep((char)8, (char)8, 1786);
        op[1786] = getOpcodeRnm(389, 2733); // HEXDIG
        {char[] a = {45}; op[1787] = getOpcodeTls(a);}
        op[1788] = getOpcodeRep((char)4, (char)4, 1789);
        op[1789] = getOpcodeRnm(389, 2733); // HEXDIG
        {char[] a = {45}; op[1790] = getOpcodeTls(a);}
        op[1791] = getOpcodeRep((char)4, (char)4, 1792);
        op[1792] = getOpcodeRnm(389, 2733); // HEXDIG
        {char[] a = {45}; op[1793] = getOpcodeTls(a);}
        op[1794] = getOpcodeRep((char)4, (char)4, 1795);
        op[1795] = getOpcodeRnm(389, 2733); // HEXDIG
        {char[] a = {45}; op[1796] = getOpcodeTls(a);}
        op[1797] = getOpcodeRep((char)12, (char)12, 1798);
        op[1798] = getOpcodeRnm(389, 2733); // HEXDIG
        op[1799] = getOpcodeRep((char)1, (char)3, 1800);
        op[1800] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1802,1804}; op[1801] = getOpcodeCat(a);}
        op[1802] = getOpcodeRep((char)0, (char)1, 1803);
        op[1803] = getOpcodeRnm(344, 2324); // SIGN
        op[1804] = getOpcodeRep((char)1, (char)3, 1805);
        op[1805] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1807,1809}; op[1806] = getOpcodeCat(a);}
        op[1807] = getOpcodeRep((char)0, (char)1, 1808);
        op[1808] = getOpcodeRnm(344, 2324); // SIGN
        op[1809] = getOpcodeRep((char)1, (char)5, 1810);
        op[1810] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1812,1814}; op[1811] = getOpcodeCat(a);}
        op[1812] = getOpcodeRep((char)0, (char)1, 1813);
        op[1813] = getOpcodeRnm(344, 2324); // SIGN
        op[1814] = getOpcodeRep((char)1, (char)10, 1815);
        op[1815] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1817,1819}; op[1816] = getOpcodeCat(a);}
        op[1817] = getOpcodeRep((char)0, (char)1, 1818);
        op[1818] = getOpcodeRnm(344, 2324); // SIGN
        op[1819] = getOpcodeRep((char)1, (char)19, 1820);
        op[1820] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1822,1823,1827}; op[1821] = getOpcodeCat(a);}
        op[1822] = getOpcodeRnm(347, 2334); // SQUOTE
        op[1823] = getOpcodeRep((char)0, Character.MAX_VALUE, 1824);
        {int[] a = {1825,1826}; op[1824] = getOpcodeAlt(a);}
        op[1825] = getOpcodeRnm(260, 1828); // SQUOTE-in-string
        op[1826] = getOpcodeRnm(377, 2602); // pchar-no-SQUOTE
        op[1827] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {1829,1830}; op[1828] = getOpcodeCat(a);}
        op[1829] = getOpcodeRnm(347, 2334); // SQUOTE
        op[1830] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {1832,1833,1834,1835,1836}; op[1831] = getOpcodeCat(a);}
        op[1832] = getOpcodeRnm(268, 1930); // year
        {char[] a = {45}; op[1833] = getOpcodeTls(a);}
        op[1834] = getOpcodeRnm(269, 1942); // month
        {char[] a = {45}; op[1835] = getOpcodeTls(a);}
        op[1836] = getOpcodeRnm(270, 1952); // day
        {int[] a = {1838,1839,1840,1841,1842,1843,1844,1845,1846,1847,1855}; op[1837] = getOpcodeCat(a);}
        op[1838] = getOpcodeRnm(268, 1930); // year
        {char[] a = {45}; op[1839] = getOpcodeTls(a);}
        op[1840] = getOpcodeRnm(269, 1942); // month
        {char[] a = {45}; op[1841] = getOpcodeTls(a);}
        op[1842] = getOpcodeRnm(270, 1952); // day
        {char[] a = {84}; op[1843] = getOpcodeTls(a);}
        op[1844] = getOpcodeRnm(271, 1966); // hour
        {char[] a = {58}; op[1845] = getOpcodeTls(a);}
        op[1846] = getOpcodeRnm(272, 1978); // minute
        op[1847] = getOpcodeRep((char)0, (char)1, 1848);
        {int[] a = {1849,1850,1851}; op[1848] = getOpcodeCat(a);}
        {char[] a = {58}; op[1849] = getOpcodeTls(a);}
        op[1850] = getOpcodeRnm(273, 1979); // second
        op[1851] = getOpcodeRep((char)0, (char)1, 1852);
        {int[] a = {1853,1854}; op[1852] = getOpcodeCat(a);}
        {char[] a = {46}; op[1853] = getOpcodeTls(a);}
        op[1854] = getOpcodeRnm(274, 1980); // fractionalSeconds
        {int[] a = {1856,1857}; op[1855] = getOpcodeAlt(a);}
        {char[] a = {90}; op[1856] = getOpcodeTls(a);}
        {int[] a = {1858,1859,1860,1861}; op[1857] = getOpcodeCat(a);}
        op[1858] = getOpcodeRnm(344, 2324); // SIGN
        op[1859] = getOpcodeRnm(271, 1966); // hour
        {char[] a = {58}; op[1860] = getOpcodeTls(a);}
        op[1861] = getOpcodeRnm(272, 1978); // minute
        {int[] a = {1863,1864,1865,1866}; op[1862] = getOpcodeCat(a);}
        {char[] a = {100,117,114,97,116,105,111,110}; op[1863] = getOpcodeTls(a);}
        op[1864] = getOpcodeRnm(347, 2334); // SQUOTE
        op[1865] = getOpcodeRnm(264, 1867); // durationValue
        op[1866] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {1868,1870,1871,1876}; op[1867] = getOpcodeCat(a);}
        op[1868] = getOpcodeRep((char)0, (char)1, 1869);
        op[1869] = getOpcodeRnm(344, 2324); // SIGN
        {char[] a = {80}; op[1870] = getOpcodeTls(a);}
        op[1871] = getOpcodeRep((char)0, (char)1, 1872);
        {int[] a = {1873,1875}; op[1872] = getOpcodeCat(a);}
        op[1873] = getOpcodeRep((char)1, Character.MAX_VALUE, 1874);
        op[1874] = getOpcodeRnm(388, 2732); // DIGIT
        {char[] a = {68}; op[1875] = getOpcodeTls(a);}
        op[1876] = getOpcodeRep((char)0, (char)1, 1877);
        {int[] a = {1878,1879,1884,1889}; op[1877] = getOpcodeCat(a);}
        {char[] a = {84}; op[1878] = getOpcodeTls(a);}
        op[1879] = getOpcodeRep((char)0, (char)1, 1880);
        {int[] a = {1881,1883}; op[1880] = getOpcodeCat(a);}
        op[1881] = getOpcodeRep((char)1, Character.MAX_VALUE, 1882);
        op[1882] = getOpcodeRnm(388, 2732); // DIGIT
        {char[] a = {72}; op[1883] = getOpcodeTls(a);}
        op[1884] = getOpcodeRep((char)0, (char)1, 1885);
        {int[] a = {1886,1888}; op[1885] = getOpcodeCat(a);}
        op[1886] = getOpcodeRep((char)1, Character.MAX_VALUE, 1887);
        op[1887] = getOpcodeRnm(388, 2732); // DIGIT
        {char[] a = {77}; op[1888] = getOpcodeTls(a);}
        op[1889] = getOpcodeRep((char)0, (char)1, 1890);
        {int[] a = {1891,1893,1898}; op[1890] = getOpcodeCat(a);}
        op[1891] = getOpcodeRep((char)1, Character.MAX_VALUE, 1892);
        op[1892] = getOpcodeRnm(388, 2732); // DIGIT
        op[1893] = getOpcodeRep((char)0, (char)1, 1894);
        {int[] a = {1895,1896}; op[1894] = getOpcodeCat(a);}
        {char[] a = {46}; op[1895] = getOpcodeTls(a);}
        op[1896] = getOpcodeRep((char)1, Character.MAX_VALUE, 1897);
        op[1897] = getOpcodeRnm(388, 2732); // DIGIT
        {char[] a = {83}; op[1898] = getOpcodeTls(a);}
        {int[] a = {1900,1901,1902,1903}; op[1899] = getOpcodeCat(a);}
        op[1900] = getOpcodeRnm(271, 1966); // hour
        {char[] a = {58}; op[1901] = getOpcodeTls(a);}
        op[1902] = getOpcodeRnm(272, 1978); // minute
        op[1903] = getOpcodeRep((char)0, (char)1, 1904);
        {int[] a = {1905,1906,1907}; op[1904] = getOpcodeCat(a);}
        {char[] a = {58}; op[1905] = getOpcodeTls(a);}
        op[1906] = getOpcodeRnm(273, 1979); // second
        op[1907] = getOpcodeRep((char)0, (char)1, 1908);
        {int[] a = {1909,1910}; op[1908] = getOpcodeCat(a);}
        {char[] a = {46}; op[1909] = getOpcodeTls(a);}
        op[1910] = getOpcodeRnm(274, 1980); // fractionalSeconds
        {int[] a = {1912,1913,1914,1915,1916,1917,1918,1919,1920}; op[1911] = getOpcodeAlt(a);}
        {char[] a = {49}; op[1912] = getOpcodeTls(a);}
        {char[] a = {50}; op[1913] = getOpcodeTls(a);}
        {char[] a = {51}; op[1914] = getOpcodeTls(a);}
        {char[] a = {52}; op[1915] = getOpcodeTls(a);}
        {char[] a = {53}; op[1916] = getOpcodeTls(a);}
        {char[] a = {54}; op[1917] = getOpcodeTls(a);}
        {char[] a = {55}; op[1918] = getOpcodeTls(a);}
        {char[] a = {56}; op[1919] = getOpcodeTls(a);}
        {char[] a = {57}; op[1920] = getOpcodeTls(a);}
        {int[] a = {1922,1929}; op[1921] = getOpcodeCat(a);}
        {int[] a = {1923,1924,1925,1926,1927,1928}; op[1922] = getOpcodeAlt(a);}
        {char[] a = {48}; op[1923] = getOpcodeTls(a);}
        {char[] a = {49}; op[1924] = getOpcodeTls(a);}
        {char[] a = {50}; op[1925] = getOpcodeTls(a);}
        {char[] a = {51}; op[1926] = getOpcodeTls(a);}
        {char[] a = {52}; op[1927] = getOpcodeTls(a);}
        {char[] a = {53}; op[1928] = getOpcodeTls(a);}
        op[1929] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1931,1933}; op[1930] = getOpcodeCat(a);}
        op[1931] = getOpcodeRep((char)0, (char)1, 1932);
        {char[] a = {45}; op[1932] = getOpcodeTls(a);}
        {int[] a = {1934,1938}; op[1933] = getOpcodeAlt(a);}
        {int[] a = {1935,1936}; op[1934] = getOpcodeCat(a);}
        {char[] a = {48}; op[1935] = getOpcodeTls(a);}
        op[1936] = getOpcodeRep((char)3, (char)3, 1937);
        op[1937] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1939,1940}; op[1938] = getOpcodeCat(a);}
        op[1939] = getOpcodeRnm(266, 1911); // oneToNine
        op[1940] = getOpcodeRep((char)3, Character.MAX_VALUE, 1941);
        op[1941] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1943,1946}; op[1942] = getOpcodeAlt(a);}
        {int[] a = {1944,1945}; op[1943] = getOpcodeCat(a);}
        {char[] a = {48}; op[1944] = getOpcodeTls(a);}
        op[1945] = getOpcodeRnm(266, 1911); // oneToNine
        {int[] a = {1947,1948}; op[1946] = getOpcodeCat(a);}
        {char[] a = {49}; op[1947] = getOpcodeTls(a);}
        {int[] a = {1949,1950,1951}; op[1948] = getOpcodeAlt(a);}
        {char[] a = {48}; op[1949] = getOpcodeTls(a);}
        {char[] a = {49}; op[1950] = getOpcodeTls(a);}
        {char[] a = {50}; op[1951] = getOpcodeTls(a);}
        {int[] a = {1953,1956,1961}; op[1952] = getOpcodeAlt(a);}
        {int[] a = {1954,1955}; op[1953] = getOpcodeCat(a);}
        {char[] a = {48}; op[1954] = getOpcodeTls(a);}
        op[1955] = getOpcodeRnm(266, 1911); // oneToNine
        {int[] a = {1957,1960}; op[1956] = getOpcodeCat(a);}
        {int[] a = {1958,1959}; op[1957] = getOpcodeAlt(a);}
        {char[] a = {49}; op[1958] = getOpcodeTls(a);}
        {char[] a = {50}; op[1959] = getOpcodeTls(a);}
        op[1960] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1962,1963}; op[1961] = getOpcodeCat(a);}
        {char[] a = {51}; op[1962] = getOpcodeTls(a);}
        {int[] a = {1964,1965}; op[1963] = getOpcodeAlt(a);}
        {char[] a = {48}; op[1964] = getOpcodeTls(a);}
        {char[] a = {49}; op[1965] = getOpcodeTls(a);}
        {int[] a = {1967,1972}; op[1966] = getOpcodeAlt(a);}
        {int[] a = {1968,1971}; op[1967] = getOpcodeCat(a);}
        {int[] a = {1969,1970}; op[1968] = getOpcodeAlt(a);}
        {char[] a = {48}; op[1969] = getOpcodeTls(a);}
        {char[] a = {49}; op[1970] = getOpcodeTls(a);}
        op[1971] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1973,1974}; op[1972] = getOpcodeCat(a);}
        {char[] a = {50}; op[1973] = getOpcodeTls(a);}
        {int[] a = {1975,1976,1977}; op[1974] = getOpcodeAlt(a);}
        {char[] a = {49}; op[1975] = getOpcodeTls(a);}
        {char[] a = {50}; op[1976] = getOpcodeTls(a);}
        {char[] a = {51}; op[1977] = getOpcodeTls(a);}
        op[1978] = getOpcodeRnm(267, 1921); // zeroToFiftyNine
        op[1979] = getOpcodeRnm(267, 1921); // zeroToFiftyNine
        op[1980] = getOpcodeRep((char)1, (char)12, 1981);
        op[1981] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {1983,1984,1985,1986}; op[1982] = getOpcodeCat(a);}
        op[1983] = getOpcodeRnm(198, 1548); // qualifiedEnumTypeName
        op[1984] = getOpcodeRnm(347, 2334); // SQUOTE
        op[1985] = getOpcodeRnm(276, 1987); // enumValue
        op[1986] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {1988,1989}; op[1987] = getOpcodeCat(a);}
        op[1988] = getOpcodeRnm(277, 1993); // singleEnumValue
        op[1989] = getOpcodeRep((char)0, Character.MAX_VALUE, 1990);
        {int[] a = {1991,1992}; op[1990] = getOpcodeCat(a);}
        op[1991] = getOpcodeRnm(342, 2320); // COMMA
        op[1992] = getOpcodeRnm(277, 1993); // singleEnumValue
        {int[] a = {1994,1995}; op[1993] = getOpcodeAlt(a);}
        op[1994] = getOpcodeRnm(207, 1565); // enumerationMember
        op[1995] = getOpcodeRnm(278, 1996); // enumMemberValue
        op[1996] = getOpcodeRnm(258, 1816); // int64Value
        {int[] a = {1998,1999,2000,2001}; op[1997] = getOpcodeCat(a);}
        op[1998] = getOpcodeRnm(314, 2181); // geographyPrefix
        op[1999] = getOpcodeRnm(347, 2334); // SQUOTE
        op[2000] = getOpcodeRnm(280, 2002); // fullCollectionLiteral
        op[2001] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {2003,2004}; op[2002] = getOpcodeCat(a);}
        op[2003] = getOpcodeRnm(298, 2102); // sridLiteral
        op[2004] = getOpcodeRnm(281, 2005); // collectionLiteral
        {int[] a = {2006,2007,2008,2012}; op[2005] = getOpcodeCat(a);}
        {char[] a = {67,111,108,108,101,99,116,105,111,110,40}; op[2006] = getOpcodeTls(a);}
        op[2007] = getOpcodeRnm(282, 2013); // geoLiteral
        op[2008] = getOpcodeRep((char)0, Character.MAX_VALUE, 2009);
        {int[] a = {2010,2011}; op[2009] = getOpcodeCat(a);}
        op[2010] = getOpcodeRnm(342, 2320); // COMMA
        op[2011] = getOpcodeRnm(282, 2013); // geoLiteral
        op[2012] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {2014,2015,2016,2017,2018,2019,2020}; op[2013] = getOpcodeAlt(a);}
        op[2014] = getOpcodeRnm(281, 2005); // collectionLiteral
        op[2015] = getOpcodeRnm(285, 2029); // lineStringLiteral
        op[2016] = getOpcodeRnm(292, 2066); // multiPointLiteral
        op[2017] = getOpcodeRnm(289, 2048); // multiLineStringLiteral
        op[2018] = getOpcodeRnm(295, 2084); // multiPolygonLiteral
        op[2019] = getOpcodeRnm(299, 2108); // pointLiteral
        op[2020] = getOpcodeRnm(304, 2127); // polygonLiteral
        {int[] a = {2022,2023,2024,2025}; op[2021] = getOpcodeCat(a);}
        op[2022] = getOpcodeRnm(314, 2181); // geographyPrefix
        op[2023] = getOpcodeRnm(347, 2334); // SQUOTE
        op[2024] = getOpcodeRnm(284, 2026); // fullLineStringLiteral
        op[2025] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {2027,2028}; op[2026] = getOpcodeCat(a);}
        op[2027] = getOpcodeRnm(298, 2102); // sridLiteral
        op[2028] = getOpcodeRnm(285, 2029); // lineStringLiteral
        {int[] a = {2030,2031}; op[2029] = getOpcodeCat(a);}
        {char[] a = {76,105,110,101,83,116,114,105,110,103}; op[2030] = getOpcodeTls(a);}
        op[2031] = getOpcodeRnm(286, 2032); // lineStringData
        {int[] a = {2033,2034,2035,2039}; op[2032] = getOpcodeCat(a);}
        op[2033] = getOpcodeRnm(348, 2337); // OPEN
        op[2034] = getOpcodeRnm(301, 2115); // positionLiteral
        op[2035] = getOpcodeRep((char)1, Character.MAX_VALUE, 2036);
        {int[] a = {2037,2038}; op[2036] = getOpcodeCat(a);}
        op[2037] = getOpcodeRnm(342, 2320); // COMMA
        op[2038] = getOpcodeRnm(301, 2115); // positionLiteral
        op[2039] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {2041,2042,2043,2044}; op[2040] = getOpcodeCat(a);}
        op[2041] = getOpcodeRnm(314, 2181); // geographyPrefix
        op[2042] = getOpcodeRnm(347, 2334); // SQUOTE
        op[2043] = getOpcodeRnm(288, 2045); // fullMultiLineStringLiteral
        op[2044] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {2046,2047}; op[2045] = getOpcodeCat(a);}
        op[2046] = getOpcodeRnm(298, 2102); // sridLiteral
        op[2047] = getOpcodeRnm(289, 2048); // multiLineStringLiteral
        {int[] a = {2049,2050,2057}; op[2048] = getOpcodeCat(a);}
        {char[] a = {77,117,108,116,105,76,105,110,101,83,116,114,105,110,103,40}; op[2049] = getOpcodeTls(a);}
        op[2050] = getOpcodeRep((char)0, (char)1, 2051);
        {int[] a = {2052,2053}; op[2051] = getOpcodeCat(a);}
        op[2052] = getOpcodeRnm(286, 2032); // lineStringData
        op[2053] = getOpcodeRep((char)0, Character.MAX_VALUE, 2054);
        {int[] a = {2055,2056}; op[2054] = getOpcodeCat(a);}
        op[2055] = getOpcodeRnm(342, 2320); // COMMA
        op[2056] = getOpcodeRnm(286, 2032); // lineStringData
        op[2057] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {2059,2060,2061,2062}; op[2058] = getOpcodeCat(a);}
        op[2059] = getOpcodeRnm(314, 2181); // geographyPrefix
        op[2060] = getOpcodeRnm(347, 2334); // SQUOTE
        op[2061] = getOpcodeRnm(291, 2063); // fullMultiPointLiteral
        op[2062] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {2064,2065}; op[2063] = getOpcodeCat(a);}
        op[2064] = getOpcodeRnm(298, 2102); // sridLiteral
        op[2065] = getOpcodeRnm(292, 2066); // multiPointLiteral
        {int[] a = {2067,2068,2075}; op[2066] = getOpcodeCat(a);}
        {char[] a = {77,117,108,116,105,80,111,105,110,116,40}; op[2067] = getOpcodeTls(a);}
        op[2068] = getOpcodeRep((char)0, (char)1, 2069);
        {int[] a = {2070,2071}; op[2069] = getOpcodeCat(a);}
        op[2070] = getOpcodeRnm(300, 2111); // pointData
        op[2071] = getOpcodeRep((char)0, Character.MAX_VALUE, 2072);
        {int[] a = {2073,2074}; op[2072] = getOpcodeCat(a);}
        op[2073] = getOpcodeRnm(342, 2320); // COMMA
        op[2074] = getOpcodeRnm(300, 2111); // pointData
        op[2075] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {2077,2078,2079,2080}; op[2076] = getOpcodeCat(a);}
        op[2077] = getOpcodeRnm(314, 2181); // geographyPrefix
        op[2078] = getOpcodeRnm(347, 2334); // SQUOTE
        op[2079] = getOpcodeRnm(294, 2081); // fullMultiPolygonLiteral
        op[2080] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {2082,2083}; op[2081] = getOpcodeCat(a);}
        op[2082] = getOpcodeRnm(298, 2102); // sridLiteral
        op[2083] = getOpcodeRnm(295, 2084); // multiPolygonLiteral
        {int[] a = {2085,2086,2093}; op[2084] = getOpcodeCat(a);}
        {char[] a = {77,117,108,116,105,80,111,108,121,103,111,110,40}; op[2085] = getOpcodeTls(a);}
        op[2086] = getOpcodeRep((char)0, (char)1, 2087);
        {int[] a = {2088,2089}; op[2087] = getOpcodeCat(a);}
        op[2088] = getOpcodeRnm(305, 2130); // polygonData
        op[2089] = getOpcodeRep((char)0, Character.MAX_VALUE, 2090);
        {int[] a = {2091,2092}; op[2090] = getOpcodeCat(a);}
        op[2091] = getOpcodeRnm(342, 2320); // COMMA
        op[2092] = getOpcodeRnm(305, 2130); // polygonData
        op[2093] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {2095,2096,2097,2098}; op[2094] = getOpcodeCat(a);}
        op[2095] = getOpcodeRnm(314, 2181); // geographyPrefix
        op[2096] = getOpcodeRnm(347, 2334); // SQUOTE
        op[2097] = getOpcodeRnm(297, 2099); // fullPointLiteral
        op[2098] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {2100,2101}; op[2099] = getOpcodeCat(a);}
        op[2100] = getOpcodeRnm(298, 2102); // sridLiteral
        op[2101] = getOpcodeRnm(299, 2108); // pointLiteral
        {int[] a = {2103,2104,2105,2107}; op[2102] = getOpcodeCat(a);}
        {char[] a = {83,82,73,68}; op[2103] = getOpcodeTls(a);}
        op[2104] = getOpcodeRnm(343, 2323); // EQ
        op[2105] = getOpcodeRep((char)1, (char)5, 2106);
        op[2106] = getOpcodeRnm(388, 2732); // DIGIT
        op[2107] = getOpcodeRnm(345, 2328); // SEMI
        {int[] a = {2109,2110}; op[2108] = getOpcodeCat(a);}
        {char[] a = {80,111,105,110,116}; op[2109] = getOpcodeTls(a);}
        op[2110] = getOpcodeRnm(300, 2111); // pointData
        {int[] a = {2112,2113,2114}; op[2111] = getOpcodeCat(a);}
        op[2112] = getOpcodeRnm(348, 2337); // OPEN
        op[2113] = getOpcodeRnm(301, 2115); // positionLiteral
        op[2114] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {2116,2117,2118}; op[2115] = getOpcodeCat(a);}
        op[2116] = getOpcodeRnm(250, 1768); // doubleValue
        op[2117] = getOpcodeRnm(392, 2744); // SP
        op[2118] = getOpcodeRnm(250, 1768); // doubleValue
        {int[] a = {2120,2121,2122,2123}; op[2119] = getOpcodeCat(a);}
        op[2120] = getOpcodeRnm(314, 2181); // geographyPrefix
        op[2121] = getOpcodeRnm(347, 2334); // SQUOTE
        op[2122] = getOpcodeRnm(303, 2124); // fullPolygonLiteral
        op[2123] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {2125,2126}; op[2124] = getOpcodeCat(a);}
        op[2125] = getOpcodeRnm(298, 2102); // sridLiteral
        op[2126] = getOpcodeRnm(304, 2127); // polygonLiteral
        {int[] a = {2128,2129}; op[2127] = getOpcodeCat(a);}
        {char[] a = {80,111,108,121,103,111,110}; op[2128] = getOpcodeTls(a);}
        op[2129] = getOpcodeRnm(305, 2130); // polygonData
        {int[] a = {2131,2132,2133,2137}; op[2130] = getOpcodeCat(a);}
        op[2131] = getOpcodeRnm(348, 2337); // OPEN
        op[2132] = getOpcodeRnm(306, 2138); // ringLiteral
        op[2133] = getOpcodeRep((char)0, Character.MAX_VALUE, 2134);
        {int[] a = {2135,2136}; op[2134] = getOpcodeCat(a);}
        op[2135] = getOpcodeRnm(342, 2320); // COMMA
        op[2136] = getOpcodeRnm(306, 2138); // ringLiteral
        op[2137] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {2139,2140,2141,2145}; op[2138] = getOpcodeCat(a);}
        op[2139] = getOpcodeRnm(348, 2337); // OPEN
        op[2140] = getOpcodeRnm(301, 2115); // positionLiteral
        op[2141] = getOpcodeRep((char)0, Character.MAX_VALUE, 2142);
        {int[] a = {2143,2144}; op[2142] = getOpcodeCat(a);}
        op[2143] = getOpcodeRnm(342, 2320); // COMMA
        op[2144] = getOpcodeRnm(301, 2115); // positionLiteral
        op[2145] = getOpcodeRnm(349, 2340); // CLOSE
        {int[] a = {2147,2148,2149,2150}; op[2146] = getOpcodeCat(a);}
        op[2147] = getOpcodeRnm(315, 2182); // geometryPrefix
        op[2148] = getOpcodeRnm(347, 2334); // SQUOTE
        op[2149] = getOpcodeRnm(280, 2002); // fullCollectionLiteral
        op[2150] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {2152,2153,2154,2155}; op[2151] = getOpcodeCat(a);}
        op[2152] = getOpcodeRnm(315, 2182); // geometryPrefix
        op[2153] = getOpcodeRnm(347, 2334); // SQUOTE
        op[2154] = getOpcodeRnm(284, 2026); // fullLineStringLiteral
        op[2155] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {2157,2158,2159,2160}; op[2156] = getOpcodeCat(a);}
        op[2157] = getOpcodeRnm(315, 2182); // geometryPrefix
        op[2158] = getOpcodeRnm(347, 2334); // SQUOTE
        op[2159] = getOpcodeRnm(288, 2045); // fullMultiLineStringLiteral
        op[2160] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {2162,2163,2164,2165}; op[2161] = getOpcodeCat(a);}
        op[2162] = getOpcodeRnm(315, 2182); // geometryPrefix
        op[2163] = getOpcodeRnm(347, 2334); // SQUOTE
        op[2164] = getOpcodeRnm(291, 2063); // fullMultiPointLiteral
        op[2165] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {2167,2168,2169,2170}; op[2166] = getOpcodeCat(a);}
        op[2167] = getOpcodeRnm(315, 2182); // geometryPrefix
        op[2168] = getOpcodeRnm(347, 2334); // SQUOTE
        op[2169] = getOpcodeRnm(294, 2081); // fullMultiPolygonLiteral
        op[2170] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {2172,2173,2174,2175}; op[2171] = getOpcodeCat(a);}
        op[2172] = getOpcodeRnm(315, 2182); // geometryPrefix
        op[2173] = getOpcodeRnm(347, 2334); // SQUOTE
        op[2174] = getOpcodeRnm(297, 2099); // fullPointLiteral
        op[2175] = getOpcodeRnm(347, 2334); // SQUOTE
        {int[] a = {2177,2178,2179,2180}; op[2176] = getOpcodeCat(a);}
        op[2177] = getOpcodeRnm(315, 2182); // geometryPrefix
        op[2178] = getOpcodeRnm(347, 2334); // SQUOTE
        op[2179] = getOpcodeRnm(303, 2124); // fullPolygonLiteral
        op[2180] = getOpcodeRnm(347, 2334); // SQUOTE
        {char[] a = {103,101,111,103,114,97,112,104,121}; op[2181] = getOpcodeTls(a);}
        {char[] a = {103,101,111,109,101,116,114,121}; op[2182] = getOpcodeTls(a);}
        {int[] a = {2184,2185,2186,2187,2188,2189}; op[2183] = getOpcodeAlt(a);}
        op[2184] = getOpcodeRnm(317, 2190); // content-id
        op[2185] = getOpcodeRnm(318, 2196); // odata-entityid
        op[2186] = getOpcodeRnm(319, 2201); // odata-isolation
        op[2187] = getOpcodeRnm(320, 2206); // odata-maxversion
        op[2188] = getOpcodeRnm(321, 2211); // odata-version
        op[2189] = getOpcodeRnm(322, 2216); // prefer
        {int[] a = {2191,2192,2193,2194}; op[2190] = getOpcodeCat(a);}
        {char[] a = {67,111,110,116,101,110,116,45,73,68}; op[2191] = getOpcodeTls(a);}
        op[2192] = getOpcodeRnm(341, 2317); // COLON
        op[2193] = getOpcodeRnm(337, 2301); // OWS
        op[2194] = getOpcodeRep((char)1, Character.MAX_VALUE, 2195);
        op[2195] = getOpcodeRnm(374, 2581); // unreserved
        {int[] a = {2197,2198,2199,2200}; op[2196] = getOpcodeCat(a);}
        {char[] a = {79,68,97,116,97,45,69,110,116,105,116,121,73,68}; op[2197] = getOpcodeTls(a);}
        op[2198] = getOpcodeRnm(341, 2317); // COLON
        op[2199] = getOpcodeRnm(337, 2301); // OWS
        op[2200] = getOpcodeRnm(385, 2723); // IRI-in-header
        {int[] a = {2202,2203,2204,2205}; op[2201] = getOpcodeCat(a);}
        {char[] a = {79,68,97,116,97,45,73,115,111,108,97,116,105,111,110}; op[2202] = getOpcodeTls(a);}
        op[2203] = getOpcodeRnm(341, 2317); // COLON
        op[2204] = getOpcodeRnm(337, 2301); // OWS
        {char[] a = {115,110,97,112,115,104,111,116}; op[2205] = getOpcodeTls(a);}
        {int[] a = {2207,2208,2209,2210}; op[2206] = getOpcodeCat(a);}
        {char[] a = {79,68,97,116,97,45,77,97,120,86,101,114,115,105,111,110}; op[2207] = getOpcodeTls(a);}
        op[2208] = getOpcodeRnm(341, 2317); // COLON
        op[2209] = getOpcodeRnm(337, 2301); // OWS
        {char[] a = {52,46,48}; op[2210] = getOpcodeTls(a);}
        {int[] a = {2212,2213,2214,2215}; op[2211] = getOpcodeCat(a);}
        {char[] a = {79,68,97,116,97,45,86,101,114,115,105,111,110}; op[2212] = getOpcodeTls(a);}
        op[2213] = getOpcodeRnm(341, 2317); // COLON
        op[2214] = getOpcodeRnm(337, 2301); // OWS
        {char[] a = {52,46,48}; op[2215] = getOpcodeTls(a);}
        {int[] a = {2217,2218,2219,2220,2221}; op[2216] = getOpcodeCat(a);}
        {char[] a = {80,114,101,102,101,114}; op[2217] = getOpcodeTls(a);}
        op[2218] = getOpcodeRnm(341, 2317); // COLON
        op[2219] = getOpcodeRnm(337, 2301); // OWS
        op[2220] = getOpcodeRnm(323, 2225); // preference
        op[2221] = getOpcodeRep((char)0, Character.MAX_VALUE, 2222);
        {int[] a = {2223,2224}; op[2222] = getOpcodeCat(a);}
        op[2223] = getOpcodeRnm(342, 2320); // COMMA
        op[2224] = getOpcodeRnm(323, 2225); // preference
        {int[] a = {2226,2227,2228,2229,2230,2231,2232,2233,2234}; op[2225] = getOpcodeAlt(a);}
        op[2226] = getOpcodeRnm(324, 2235); // allowEntityReferencesPreference
        op[2227] = getOpcodeRnm(325, 2236); // callbackPreference
        op[2228] = getOpcodeRnm(326, 2248); // continueOnErrorPreference
        op[2229] = getOpcodeRnm(327, 2249); // includeAnnotationsPreference
        op[2230] = getOpcodeRnm(331, 2275); // maxpagesizePreference
        op[2231] = getOpcodeRnm(332, 2283); // respondAsyncPreference
        op[2232] = getOpcodeRnm(333, 2284); // returnPreference
        op[2233] = getOpcodeRnm(334, 2292); // trackChangesPreference
        op[2234] = getOpcodeRnm(335, 2293); // waitPreference
        {char[] a = {111,100,97,116,97,46,97,108,108,111,119,45,101,110,116,105,116,121,114,101,102,101,114,101,110,99,101,115}; op[2235] = getOpcodeTls(a);}
        {int[] a = {2237,2238,2239,2240,2241,2242,2243,2244,2245,2246,2247}; op[2236] = getOpcodeCat(a);}
        {char[] a = {111,100,97,116,97,46,99,97,108,108,98,97,99,107}; op[2237] = getOpcodeTls(a);}
        op[2238] = getOpcodeRnm(337, 2301); // OWS
        {char[] a = {59}; op[2239] = getOpcodeTls(a);}
        op[2240] = getOpcodeRnm(337, 2301); // OWS
        {char[] a = {117,114,108}; op[2241] = getOpcodeTls(a);}
        op[2242] = getOpcodeRnm(339, 2313); // BWS
        op[2243] = getOpcodeRnm(343, 2323); // EQ
        op[2244] = getOpcodeRnm(339, 2313); // BWS
        op[2245] = getOpcodeRnm(391, 2743); // DQUOTE
        op[2246] = getOpcodeRnm(350, 2343); // URI
        op[2247] = getOpcodeRnm(391, 2743); // DQUOTE
        {char[] a = {111,100,97,116,97,46,99,111,110,116,105,110,117,101,45,111,110,45,101,114,114,111,114}; op[2248] = getOpcodeTls(a);}
        {int[] a = {2250,2251,2252,2253,2254,2255,2256}; op[2249] = getOpcodeCat(a);}
        {char[] a = {111,100,97,116,97,46,105,110,99,108,117,100,101,45,97,110,110,111,116,97,116,105,111,110,115}; op[2250] = getOpcodeTls(a);}
        op[2251] = getOpcodeRnm(339, 2313); // BWS
        op[2252] = getOpcodeRnm(343, 2323); // EQ
        op[2253] = getOpcodeRnm(339, 2313); // BWS
        op[2254] = getOpcodeRnm(391, 2743); // DQUOTE
        op[2255] = getOpcodeRnm(328, 2257); // annotationsList
        op[2256] = getOpcodeRnm(391, 2743); // DQUOTE
        {int[] a = {2258,2259}; op[2257] = getOpcodeCat(a);}
        op[2258] = getOpcodeRnm(329, 2263); // annotationIdentifier
        op[2259] = getOpcodeRep((char)0, Character.MAX_VALUE, 2260);
        {int[] a = {2261,2262}; op[2260] = getOpcodeCat(a);}
        op[2261] = getOpcodeRnm(342, 2320); // COMMA
        op[2262] = getOpcodeRnm(329, 2263); // annotationIdentifier
        {int[] a = {2264,2266}; op[2263] = getOpcodeCat(a);}
        op[2264] = getOpcodeRep((char)0, (char)1, 2265);
        op[2265] = getOpcodeRnm(330, 2274); // excludeOperator
        {int[] a = {2267,2268}; op[2266] = getOpcodeAlt(a);}
        op[2267] = getOpcodeRnm(346, 2331); // STAR
        {int[] a = {2269,2270,2271}; op[2268] = getOpcodeCat(a);}
        op[2269] = getOpcodeRnm(199, 1552); // namespace
        {char[] a = {46}; op[2270] = getOpcodeTls(a);}
        {int[] a = {2272,2273}; op[2271] = getOpcodeAlt(a);}
        op[2272] = getOpcodeRnm(208, 1566); // termName
        op[2273] = getOpcodeRnm(346, 2331); // STAR
        {char[] a = {45}; op[2274] = getOpcodeTls(a);}
        {int[] a = {2276,2277,2278,2279,2280,2281}; op[2275] = getOpcodeCat(a);}
        {char[] a = {111,100,97,116,97,46,109,97,120,112,97,103,101,115,105,122,101}; op[2276] = getOpcodeTls(a);}
        op[2277] = getOpcodeRnm(339, 2313); // BWS
        op[2278] = getOpcodeRnm(343, 2323); // EQ
        op[2279] = getOpcodeRnm(339, 2313); // BWS
        op[2280] = getOpcodeRnm(266, 1911); // oneToNine
        op[2281] = getOpcodeRep((char)0, Character.MAX_VALUE, 2282);
        op[2282] = getOpcodeRnm(388, 2732); // DIGIT
        {char[] a = {114,101,115,112,111,110,100,45,97,115,121,110,99}; op[2283] = getOpcodeTls(a);}
        {int[] a = {2285,2286,2287,2288,2289}; op[2284] = getOpcodeCat(a);}
        {char[] a = {114,101,116,117,114,110}; op[2285] = getOpcodeTls(a);}
        op[2286] = getOpcodeRnm(339, 2313); // BWS
        op[2287] = getOpcodeRnm(343, 2323); // EQ
        op[2288] = getOpcodeRnm(339, 2313); // BWS
        {int[] a = {2290,2291}; op[2289] = getOpcodeAlt(a);}
        {char[] a = {114,101,112,114,101,115,101,110,116,97,116,105,111,110}; op[2290] = getOpcodeTbs(a);}
        {char[] a = {109,105,110,105,109,97,108}; op[2291] = getOpcodeTbs(a);}
        {char[] a = {111,100,97,116,97,46,116,114,97,99,107,45,99,104,97,110,103,101,115}; op[2292] = getOpcodeTls(a);}
        {int[] a = {2294,2295,2296,2297,2298}; op[2293] = getOpcodeCat(a);}
        {char[] a = {119,97,105,116}; op[2294] = getOpcodeTls(a);}
        op[2295] = getOpcodeRnm(339, 2313); // BWS
        op[2296] = getOpcodeRnm(343, 2323); // EQ
        op[2297] = getOpcodeRnm(339, 2313); // BWS
        op[2298] = getOpcodeRep((char)1, Character.MAX_VALUE, 2299);
        op[2299] = getOpcodeRnm(388, 2732); // DIGIT
        op[2300] = getOpcodeTrg((char)128, (char)255);
        op[2301] = getOpcodeRep((char)0, Character.MAX_VALUE, 2302);
        {int[] a = {2303,2304,2305,2306}; op[2302] = getOpcodeAlt(a);}
        op[2303] = getOpcodeRnm(392, 2744); // SP
        op[2304] = getOpcodeRnm(393, 2745); // HTAB
        {char[] a = {37,50,48}; op[2305] = getOpcodeTls(a);}
        {char[] a = {37,48,57}; op[2306] = getOpcodeTls(a);}
        op[2307] = getOpcodeRep((char)1, Character.MAX_VALUE, 2308);
        {int[] a = {2309,2310,2311,2312}; op[2308] = getOpcodeAlt(a);}
        op[2309] = getOpcodeRnm(392, 2744); // SP
        op[2310] = getOpcodeRnm(393, 2745); // HTAB
        {char[] a = {37,50,48}; op[2311] = getOpcodeTls(a);}
        {char[] a = {37,48,57}; op[2312] = getOpcodeTls(a);}
        op[2313] = getOpcodeRnm(337, 2301); // OWS
        {int[] a = {2315,2316}; op[2314] = getOpcodeAlt(a);}
        {char[] a = {64}; op[2315] = getOpcodeTls(a);}
        {char[] a = {37,52,48}; op[2316] = getOpcodeTls(a);}
        {int[] a = {2318,2319}; op[2317] = getOpcodeAlt(a);}
        {char[] a = {58}; op[2318] = getOpcodeTls(a);}
        {char[] a = {37,51,65}; op[2319] = getOpcodeTls(a);}
        {int[] a = {2321,2322}; op[2320] = getOpcodeAlt(a);}
        {char[] a = {44}; op[2321] = getOpcodeTls(a);}
        {char[] a = {37,50,67}; op[2322] = getOpcodeTls(a);}
        {char[] a = {61}; op[2323] = getOpcodeTls(a);}
        {int[] a = {2325,2326,2327}; op[2324] = getOpcodeAlt(a);}
        {char[] a = {43}; op[2325] = getOpcodeTls(a);}
        {char[] a = {37,50,66}; op[2326] = getOpcodeTls(a);}
        {char[] a = {45}; op[2327] = getOpcodeTls(a);}
        {int[] a = {2329,2330}; op[2328] = getOpcodeAlt(a);}
        {char[] a = {59}; op[2329] = getOpcodeTls(a);}
        {char[] a = {37,51,66}; op[2330] = getOpcodeTls(a);}
        {int[] a = {2332,2333}; op[2331] = getOpcodeAlt(a);}
        {char[] a = {42}; op[2332] = getOpcodeTls(a);}
        {char[] a = {37,50,65}; op[2333] = getOpcodeTls(a);}
        {int[] a = {2335,2336}; op[2334] = getOpcodeAlt(a);}
        {char[] a = {39}; op[2335] = getOpcodeTls(a);}
        {char[] a = {37,50,55}; op[2336] = getOpcodeTls(a);}
        {int[] a = {2338,2339}; op[2337] = getOpcodeAlt(a);}
        {char[] a = {40}; op[2338] = getOpcodeTls(a);}
        {char[] a = {37,50,56}; op[2339] = getOpcodeTls(a);}
        {int[] a = {2341,2342}; op[2340] = getOpcodeAlt(a);}
        {char[] a = {41}; op[2341] = getOpcodeTls(a);}
        {char[] a = {37,50,57}; op[2342] = getOpcodeTls(a);}
        {int[] a = {2344,2345,2346,2347,2351}; op[2343] = getOpcodeCat(a);}
        op[2344] = getOpcodeRnm(352, 2362); // scheme
        {char[] a = {58}; op[2345] = getOpcodeTls(a);}
        op[2346] = getOpcodeRnm(351, 2355); // hier-part
        op[2347] = getOpcodeRep((char)0, (char)1, 2348);
        {int[] a = {2349,2350}; op[2348] = getOpcodeCat(a);}
        {char[] a = {63}; op[2349] = getOpcodeTls(a);}
        op[2350] = getOpcodeRnm(371, 2567); // query
        op[2351] = getOpcodeRep((char)0, (char)1, 2352);
        {int[] a = {2353,2354}; op[2352] = getOpcodeCat(a);}
        {char[] a = {35}; op[2353] = getOpcodeTls(a);}
        op[2354] = getOpcodeRnm(372, 2572); // fragment
        {int[] a = {2356,2360,2361}; op[2355] = getOpcodeAlt(a);}
        {int[] a = {2357,2358,2359}; op[2356] = getOpcodeCat(a);}
        {char[] a = {47,47}; op[2357] = getOpcodeTls(a);}
        op[2358] = getOpcodeRnm(353, 2371); // authority
        op[2359] = getOpcodeRnm(365, 2538); // path-abempty
        op[2360] = getOpcodeRnm(366, 2542); // path-absolute
        op[2361] = getOpcodeRnm(367, 2551); // path-rootless
        {int[] a = {2363,2364}; op[2362] = getOpcodeCat(a);}
        op[2363] = getOpcodeRnm(387, 2729); // ALPHA
        op[2364] = getOpcodeRep((char)0, Character.MAX_VALUE, 2365);
        {int[] a = {2366,2367,2368,2369,2370}; op[2365] = getOpcodeAlt(a);}
        op[2366] = getOpcodeRnm(387, 2729); // ALPHA
        op[2367] = getOpcodeRnm(388, 2732); // DIGIT
        {char[] a = {43}; op[2368] = getOpcodeTls(a);}
        {char[] a = {45}; op[2369] = getOpcodeTls(a);}
        {char[] a = {46}; op[2370] = getOpcodeTls(a);}
        {int[] a = {2372,2376,2377}; op[2371] = getOpcodeCat(a);}
        op[2372] = getOpcodeRep((char)0, (char)1, 2373);
        {int[] a = {2374,2375}; op[2373] = getOpcodeCat(a);}
        op[2374] = getOpcodeRnm(354, 2381); // userinfo
        {char[] a = {64}; op[2375] = getOpcodeTls(a);}
        op[2376] = getOpcodeRnm(355, 2387); // host
        op[2377] = getOpcodeRep((char)0, (char)1, 2378);
        {int[] a = {2379,2380}; op[2378] = getOpcodeCat(a);}
        {char[] a = {58}; op[2379] = getOpcodeTls(a);}
        op[2380] = getOpcodeRnm(356, 2391); // port
        op[2381] = getOpcodeRep((char)0, Character.MAX_VALUE, 2382);
        {int[] a = {2383,2384,2385,2386}; op[2382] = getOpcodeAlt(a);}
        op[2383] = getOpcodeRnm(374, 2581); // unreserved
        op[2384] = getOpcodeRnm(373, 2577); // pct-encoded
        op[2385] = getOpcodeRnm(375, 2588); // sub-delims
        {char[] a = {58}; op[2386] = getOpcodeTls(a);}
        {int[] a = {2388,2389,2390}; op[2387] = getOpcodeAlt(a);}
        op[2388] = getOpcodeRnm(357, 2393); // IP-literal
        op[2389] = getOpcodeRnm(362, 2509); // IPv4address
        op[2390] = getOpcodeRnm(364, 2533); // reg-name
        op[2391] = getOpcodeRep((char)0, Character.MAX_VALUE, 2392);
        op[2392] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {2394,2395,2398}; op[2393] = getOpcodeCat(a);}
        {char[] a = {91}; op[2394] = getOpcodeTls(a);}
        {int[] a = {2396,2397}; op[2395] = getOpcodeAlt(a);}
        op[2396] = getOpcodeRnm(359, 2409); // IPv6address
        op[2397] = getOpcodeRnm(358, 2399); // IPvFuture
        {char[] a = {93}; op[2398] = getOpcodeTls(a);}
        {int[] a = {2400,2401,2403,2404}; op[2399] = getOpcodeCat(a);}
        {char[] a = {118}; op[2400] = getOpcodeTls(a);}
        op[2401] = getOpcodeRep((char)1, Character.MAX_VALUE, 2402);
        op[2402] = getOpcodeRnm(389, 2733); // HEXDIG
        {char[] a = {46}; op[2403] = getOpcodeTls(a);}
        op[2404] = getOpcodeRep((char)1, Character.MAX_VALUE, 2405);
        {int[] a = {2406,2407,2408}; op[2405] = getOpcodeAlt(a);}
        op[2406] = getOpcodeRnm(374, 2581); // unreserved
        op[2407] = getOpcodeRnm(375, 2588); // sub-delims
        {char[] a = {58}; op[2408] = getOpcodeTls(a);}
        {int[] a = {2410,2416,2423,2432,2446,2460,2472,2482,2492}; op[2409] = getOpcodeAlt(a);}
        {int[] a = {2411,2415}; op[2410] = getOpcodeCat(a);}
        op[2411] = getOpcodeRep((char)6, (char)6, 2412);
        {int[] a = {2413,2414}; op[2412] = getOpcodeCat(a);}
        op[2413] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58}; op[2414] = getOpcodeTls(a);}
        op[2415] = getOpcodeRnm(361, 2503); // ls32
        {int[] a = {2417,2418,2422}; op[2416] = getOpcodeCat(a);}
        {char[] a = {58,58}; op[2417] = getOpcodeTls(a);}
        op[2418] = getOpcodeRep((char)5, (char)5, 2419);
        {int[] a = {2420,2421}; op[2419] = getOpcodeCat(a);}
        op[2420] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58}; op[2421] = getOpcodeTls(a);}
        op[2422] = getOpcodeRnm(361, 2503); // ls32
        {int[] a = {2424,2426,2427,2431}; op[2423] = getOpcodeCat(a);}
        op[2424] = getOpcodeRep((char)0, (char)1, 2425);
        op[2425] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58,58}; op[2426] = getOpcodeTls(a);}
        op[2427] = getOpcodeRep((char)4, (char)4, 2428);
        {int[] a = {2429,2430}; op[2428] = getOpcodeCat(a);}
        op[2429] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58}; op[2430] = getOpcodeTls(a);}
        op[2431] = getOpcodeRnm(361, 2503); // ls32
        {int[] a = {2433,2440,2441,2445}; op[2432] = getOpcodeCat(a);}
        op[2433] = getOpcodeRep((char)0, (char)1, 2434);
        {int[] a = {2435,2439}; op[2434] = getOpcodeCat(a);}
        op[2435] = getOpcodeRep((char)0, (char)1, 2436);
        {int[] a = {2437,2438}; op[2436] = getOpcodeCat(a);}
        op[2437] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58}; op[2438] = getOpcodeTls(a);}
        op[2439] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58,58}; op[2440] = getOpcodeTls(a);}
        op[2441] = getOpcodeRep((char)3, (char)3, 2442);
        {int[] a = {2443,2444}; op[2442] = getOpcodeCat(a);}
        op[2443] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58}; op[2444] = getOpcodeTls(a);}
        op[2445] = getOpcodeRnm(361, 2503); // ls32
        {int[] a = {2447,2454,2455,2459}; op[2446] = getOpcodeCat(a);}
        op[2447] = getOpcodeRep((char)0, (char)1, 2448);
        {int[] a = {2449,2453}; op[2448] = getOpcodeCat(a);}
        op[2449] = getOpcodeRep((char)0, (char)2, 2450);
        {int[] a = {2451,2452}; op[2450] = getOpcodeCat(a);}
        op[2451] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58}; op[2452] = getOpcodeTls(a);}
        op[2453] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58,58}; op[2454] = getOpcodeTls(a);}
        op[2455] = getOpcodeRep((char)2, (char)2, 2456);
        {int[] a = {2457,2458}; op[2456] = getOpcodeCat(a);}
        op[2457] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58}; op[2458] = getOpcodeTls(a);}
        op[2459] = getOpcodeRnm(361, 2503); // ls32
        {int[] a = {2461,2468,2469,2470,2471}; op[2460] = getOpcodeCat(a);}
        op[2461] = getOpcodeRep((char)0, (char)1, 2462);
        {int[] a = {2463,2467}; op[2462] = getOpcodeCat(a);}
        op[2463] = getOpcodeRep((char)0, (char)3, 2464);
        {int[] a = {2465,2466}; op[2464] = getOpcodeCat(a);}
        op[2465] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58}; op[2466] = getOpcodeTls(a);}
        op[2467] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58,58}; op[2468] = getOpcodeTls(a);}
        op[2469] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58}; op[2470] = getOpcodeTls(a);}
        op[2471] = getOpcodeRnm(361, 2503); // ls32
        {int[] a = {2473,2480,2481}; op[2472] = getOpcodeCat(a);}
        op[2473] = getOpcodeRep((char)0, (char)1, 2474);
        {int[] a = {2475,2479}; op[2474] = getOpcodeCat(a);}
        op[2475] = getOpcodeRep((char)0, (char)4, 2476);
        {int[] a = {2477,2478}; op[2476] = getOpcodeCat(a);}
        op[2477] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58}; op[2478] = getOpcodeTls(a);}
        op[2479] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58,58}; op[2480] = getOpcodeTls(a);}
        op[2481] = getOpcodeRnm(361, 2503); // ls32
        {int[] a = {2483,2490,2491}; op[2482] = getOpcodeCat(a);}
        op[2483] = getOpcodeRep((char)0, (char)1, 2484);
        {int[] a = {2485,2489}; op[2484] = getOpcodeCat(a);}
        op[2485] = getOpcodeRep((char)0, (char)5, 2486);
        {int[] a = {2487,2488}; op[2486] = getOpcodeCat(a);}
        op[2487] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58}; op[2488] = getOpcodeTls(a);}
        op[2489] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58,58}; op[2490] = getOpcodeTls(a);}
        op[2491] = getOpcodeRnm(360, 2501); // h16
        {int[] a = {2493,2500}; op[2492] = getOpcodeCat(a);}
        op[2493] = getOpcodeRep((char)0, (char)1, 2494);
        {int[] a = {2495,2499}; op[2494] = getOpcodeCat(a);}
        op[2495] = getOpcodeRep((char)0, (char)6, 2496);
        {int[] a = {2497,2498}; op[2496] = getOpcodeCat(a);}
        op[2497] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58}; op[2498] = getOpcodeTls(a);}
        op[2499] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58,58}; op[2500] = getOpcodeTls(a);}
        op[2501] = getOpcodeRep((char)1, (char)4, 2502);
        op[2502] = getOpcodeRnm(389, 2733); // HEXDIG
        {int[] a = {2504,2508}; op[2503] = getOpcodeAlt(a);}
        {int[] a = {2505,2506,2507}; op[2504] = getOpcodeCat(a);}
        op[2505] = getOpcodeRnm(360, 2501); // h16
        {char[] a = {58}; op[2506] = getOpcodeTls(a);}
        op[2507] = getOpcodeRnm(360, 2501); // h16
        op[2508] = getOpcodeRnm(362, 2509); // IPv4address
        {int[] a = {2510,2511,2512,2513,2514,2515,2516}; op[2509] = getOpcodeCat(a);}
        op[2510] = getOpcodeRnm(363, 2517); // dec-octet
        {char[] a = {46}; op[2511] = getOpcodeTls(a);}
        op[2512] = getOpcodeRnm(363, 2517); // dec-octet
        {char[] a = {46}; op[2513] = getOpcodeTls(a);}
        op[2514] = getOpcodeRnm(363, 2517); // dec-octet
        {char[] a = {46}; op[2515] = getOpcodeTls(a);}
        op[2516] = getOpcodeRnm(363, 2517); // dec-octet
        {int[] a = {2518,2522,2526,2529,2532}; op[2517] = getOpcodeAlt(a);}
        {int[] a = {2519,2520}; op[2518] = getOpcodeCat(a);}
        {char[] a = {49}; op[2519] = getOpcodeTls(a);}
        op[2520] = getOpcodeRep((char)2, (char)2, 2521);
        op[2521] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {2523,2524,2525}; op[2522] = getOpcodeCat(a);}
        {char[] a = {50}; op[2523] = getOpcodeTls(a);}
        op[2524] = getOpcodeTrg((char)48, (char)52);
        op[2525] = getOpcodeRnm(388, 2732); // DIGIT
        {int[] a = {2527,2528}; op[2526] = getOpcodeCat(a);}
        {char[] a = {50,53}; op[2527] = getOpcodeTls(a);}
        op[2528] = getOpcodeTrg((char)48, (char)53);
        {int[] a = {2530,2531}; op[2529] = getOpcodeCat(a);}
        op[2530] = getOpcodeTrg((char)49, (char)57);
        op[2531] = getOpcodeRnm(388, 2732); // DIGIT
        op[2532] = getOpcodeRnm(388, 2732); // DIGIT
        op[2533] = getOpcodeRep((char)0, Character.MAX_VALUE, 2534);
        {int[] a = {2535,2536,2537}; op[2534] = getOpcodeAlt(a);}
        op[2535] = getOpcodeRnm(374, 2581); // unreserved
        op[2536] = getOpcodeRnm(373, 2577); // pct-encoded
        op[2537] = getOpcodeRnm(375, 2588); // sub-delims
        op[2538] = getOpcodeRep((char)0, Character.MAX_VALUE, 2539);
        {int[] a = {2540,2541}; op[2539] = getOpcodeCat(a);}
        {char[] a = {47}; op[2540] = getOpcodeTls(a);}
        op[2541] = getOpcodeRnm(368, 2557); // segment
        {int[] a = {2543,2544}; op[2542] = getOpcodeCat(a);}
        {char[] a = {47}; op[2543] = getOpcodeTls(a);}
        op[2544] = getOpcodeRep((char)0, (char)1, 2545);
        {int[] a = {2546,2547}; op[2545] = getOpcodeCat(a);}
        op[2546] = getOpcodeRnm(369, 2559); // segment-nz
        op[2547] = getOpcodeRep((char)0, Character.MAX_VALUE, 2548);
        {int[] a = {2549,2550}; op[2548] = getOpcodeCat(a);}
        {char[] a = {47}; op[2549] = getOpcodeTls(a);}
        op[2550] = getOpcodeRnm(368, 2557); // segment
        {int[] a = {2552,2553}; op[2551] = getOpcodeCat(a);}
        op[2552] = getOpcodeRnm(369, 2559); // segment-nz
        op[2553] = getOpcodeRep((char)0, Character.MAX_VALUE, 2554);
        {int[] a = {2555,2556}; op[2554] = getOpcodeCat(a);}
        {char[] a = {47}; op[2555] = getOpcodeTls(a);}
        op[2556] = getOpcodeRnm(368, 2557); // segment
        op[2557] = getOpcodeRep((char)0, Character.MAX_VALUE, 2558);
        op[2558] = getOpcodeRnm(370, 2561); // pchar
        op[2559] = getOpcodeRep((char)1, Character.MAX_VALUE, 2560);
        op[2560] = getOpcodeRnm(370, 2561); // pchar
        {int[] a = {2562,2563,2564,2565,2566}; op[2561] = getOpcodeAlt(a);}
        op[2562] = getOpcodeRnm(374, 2581); // unreserved
        op[2563] = getOpcodeRnm(373, 2577); // pct-encoded
        op[2564] = getOpcodeRnm(375, 2588); // sub-delims
        {char[] a = {58}; op[2565] = getOpcodeTls(a);}
        {char[] a = {64}; op[2566] = getOpcodeTls(a);}
        op[2567] = getOpcodeRep((char)0, Character.MAX_VALUE, 2568);
        {int[] a = {2569,2570,2571}; op[2568] = getOpcodeAlt(a);}
        op[2569] = getOpcodeRnm(370, 2561); // pchar
        {char[] a = {47}; op[2570] = getOpcodeTls(a);}
        {char[] a = {63}; op[2571] = getOpcodeTls(a);}
        op[2572] = getOpcodeRep((char)0, Character.MAX_VALUE, 2573);
        {int[] a = {2574,2575,2576}; op[2573] = getOpcodeAlt(a);}
        op[2574] = getOpcodeRnm(370, 2561); // pchar
        {char[] a = {47}; op[2575] = getOpcodeTls(a);}
        {char[] a = {63}; op[2576] = getOpcodeTls(a);}
        {int[] a = {2578,2579,2580}; op[2577] = getOpcodeCat(a);}
        {char[] a = {37}; op[2578] = getOpcodeTls(a);}
        op[2579] = getOpcodeRnm(389, 2733); // HEXDIG
        op[2580] = getOpcodeRnm(389, 2733); // HEXDIG
        {int[] a = {2582,2583,2584,2585,2586,2587}; op[2581] = getOpcodeAlt(a);}
        op[2582] = getOpcodeRnm(387, 2729); // ALPHA
        op[2583] = getOpcodeRnm(388, 2732); // DIGIT
        {char[] a = {45}; op[2584] = getOpcodeTls(a);}
        {char[] a = {46}; op[2585] = getOpcodeTls(a);}
        {char[] a = {95}; op[2586] = getOpcodeTls(a);}
        {char[] a = {126}; op[2587] = getOpcodeTls(a);}
        {int[] a = {2589,2590,2591,2592,2593}; op[2588] = getOpcodeAlt(a);}
        {char[] a = {36}; op[2589] = getOpcodeTls(a);}
        {char[] a = {38}; op[2590] = getOpcodeTls(a);}
        {char[] a = {39}; op[2591] = getOpcodeTls(a);}
        {char[] a = {61}; op[2592] = getOpcodeTls(a);}
        op[2593] = getOpcodeRnm(376, 2594); // other-delims
        {int[] a = {2595,2596,2597,2598,2599,2600,2601}; op[2594] = getOpcodeAlt(a);}
        {char[] a = {33}; op[2595] = getOpcodeTls(a);}
        {char[] a = {40}; op[2596] = getOpcodeTls(a);}
        {char[] a = {41}; op[2597] = getOpcodeTls(a);}
        {char[] a = {42}; op[2598] = getOpcodeTls(a);}
        {char[] a = {43}; op[2599] = getOpcodeTls(a);}
        {char[] a = {44}; op[2600] = getOpcodeTls(a);}
        {char[] a = {59}; op[2601] = getOpcodeTls(a);}
        {int[] a = {2603,2604,2605,2606,2607,2608,2609,2610}; op[2602] = getOpcodeAlt(a);}
        op[2603] = getOpcodeRnm(374, 2581); // unreserved
        op[2604] = getOpcodeRnm(378, 2611); // pct-encoded-no-SQUOTE
        op[2605] = getOpcodeRnm(376, 2594); // other-delims
        {char[] a = {36}; op[2606] = getOpcodeTls(a);}
        {char[] a = {38}; op[2607] = getOpcodeTls(a);}
        {char[] a = {61}; op[2608] = getOpcodeTls(a);}
        {char[] a = {58}; op[2609] = getOpcodeTls(a);}
        {char[] a = {64}; op[2610] = getOpcodeTls(a);}
        {int[] a = {2612,2625}; op[2611] = getOpcodeAlt(a);}
        {int[] a = {2613,2614,2624}; op[2612] = getOpcodeCat(a);}
        {char[] a = {37}; op[2613] = getOpcodeTls(a);}
        {int[] a = {2615,2616,2617,2618,2619,2620,2621,2622,2623}; op[2614] = getOpcodeAlt(a);}
        {char[] a = {48}; op[2615] = getOpcodeTls(a);}
        {char[] a = {49}; op[2616] = getOpcodeTls(a);}
        {char[] a = {51}; op[2617] = getOpcodeTls(a);}
        {char[] a = {52}; op[2618] = getOpcodeTls(a);}
        {char[] a = {53}; op[2619] = getOpcodeTls(a);}
        {char[] a = {54}; op[2620] = getOpcodeTls(a);}
        {char[] a = {56}; op[2621] = getOpcodeTls(a);}
        {char[] a = {57}; op[2622] = getOpcodeTls(a);}
        op[2623] = getOpcodeRnm(390, 2736); // A-to-F
        op[2624] = getOpcodeRnm(389, 2733); // HEXDIG
        {int[] a = {2626,2627,2628}; op[2625] = getOpcodeCat(a);}
        {char[] a = {37}; op[2626] = getOpcodeTls(a);}
        {char[] a = {50}; op[2627] = getOpcodeTls(a);}
        {int[] a = {2629,2630,2631,2632,2633,2634,2635,2636,2637,2638}; op[2628] = getOpcodeAlt(a);}
        {char[] a = {48}; op[2629] = getOpcodeTls(a);}
        {char[] a = {49}; op[2630] = getOpcodeTls(a);}
        {char[] a = {50}; op[2631] = getOpcodeTls(a);}
        {char[] a = {51}; op[2632] = getOpcodeTls(a);}
        {char[] a = {52}; op[2633] = getOpcodeTls(a);}
        {char[] a = {53}; op[2634] = getOpcodeTls(a);}
        {char[] a = {54}; op[2635] = getOpcodeTls(a);}
        {char[] a = {56}; op[2636] = getOpcodeTls(a);}
        {char[] a = {57}; op[2637] = getOpcodeTls(a);}
        op[2638] = getOpcodeRnm(390, 2736); // A-to-F
        {int[] a = {2640,2641,2642,2643,2644,2645,2646,2647,2648,2649}; op[2639] = getOpcodeAlt(a);}
        op[2640] = getOpcodeRnm(374, 2581); // unreserved
        op[2641] = getOpcodeRnm(373, 2577); // pct-encoded
        op[2642] = getOpcodeRnm(376, 2594); // other-delims
        {char[] a = {58}; op[2643] = getOpcodeTls(a);}
        {char[] a = {64}; op[2644] = getOpcodeTls(a);}
        {char[] a = {47}; op[2645] = getOpcodeTls(a);}
        {char[] a = {63}; op[2646] = getOpcodeTls(a);}
        {char[] a = {36}; op[2647] = getOpcodeTls(a);}
        {char[] a = {39}; op[2648] = getOpcodeTls(a);}
        {char[] a = {61}; op[2649] = getOpcodeTls(a);}
        {int[] a = {2651,2652,2653,2654,2655,2656,2657,2658,2659}; op[2650] = getOpcodeAlt(a);}
        op[2651] = getOpcodeRnm(374, 2581); // unreserved
        op[2652] = getOpcodeRnm(373, 2577); // pct-encoded
        op[2653] = getOpcodeRnm(376, 2594); // other-delims
        {char[] a = {58}; op[2654] = getOpcodeTls(a);}
        {char[] a = {64}; op[2655] = getOpcodeTls(a);}
        {char[] a = {47}; op[2656] = getOpcodeTls(a);}
        {char[] a = {63}; op[2657] = getOpcodeTls(a);}
        {char[] a = {36}; op[2658] = getOpcodeTls(a);}
        {char[] a = {39}; op[2659] = getOpcodeTls(a);}
        {int[] a = {2661,2662,2663,2664,2665,2666,2667}; op[2660] = getOpcodeAlt(a);}
        op[2661] = getOpcodeRnm(374, 2581); // unreserved
        op[2662] = getOpcodeRnm(373, 2577); // pct-encoded
        op[2663] = getOpcodeRnm(376, 2594); // other-delims
        {char[] a = {58}; op[2664] = getOpcodeTls(a);}
        {char[] a = {47}; op[2665] = getOpcodeTls(a);}
        {char[] a = {63}; op[2666] = getOpcodeTls(a);}
        {char[] a = {39}; op[2667] = getOpcodeTls(a);}
        {int[] a = {2669,2670,2671,2672,2673,2674,2675,2676,2677,2678}; op[2668] = getOpcodeAlt(a);}
        op[2669] = getOpcodeRnm(374, 2581); // unreserved
        op[2670] = getOpcodeRnm(383, 2679); // pct-encoded-unescaped
        op[2671] = getOpcodeRnm(376, 2594); // other-delims
        {char[] a = {58}; op[2672] = getOpcodeTls(a);}
        {char[] a = {64}; op[2673] = getOpcodeTls(a);}
        {char[] a = {47}; op[2674] = getOpcodeTls(a);}
        {char[] a = {63}; op[2675] = getOpcodeTls(a);}
        {char[] a = {36}; op[2676] = getOpcodeTls(a);}
        {char[] a = {39}; op[2677] = getOpcodeTls(a);}
        {char[] a = {61}; op[2678] = getOpcodeTls(a);}
        {int[] a = {2680,2692,2706}; op[2679] = getOpcodeAlt(a);}
        {int[] a = {2681,2682,2691}; op[2680] = getOpcodeCat(a);}
        {char[] a = {37}; op[2681] = getOpcodeTls(a);}
        {int[] a = {2683,2684,2685,2686,2687,2688,2689,2690}; op[2682] = getOpcodeAlt(a);}
        {char[] a = {48}; op[2683] = getOpcodeTls(a);}
        {char[] a = {49}; op[2684] = getOpcodeTls(a);}
        {char[] a = {51}; op[2685] = getOpcodeTls(a);}
        {char[] a = {52}; op[2686] = getOpcodeTls(a);}
        {char[] a = {54}; op[2687] = getOpcodeTls(a);}
        {char[] a = {56}; op[2688] = getOpcodeTls(a);}
        {char[] a = {57}; op[2689] = getOpcodeTls(a);}
        op[2690] = getOpcodeRnm(390, 2736); // A-to-F
        op[2691] = getOpcodeRnm(389, 2733); // HEXDIG
        {int[] a = {2693,2694,2695}; op[2692] = getOpcodeCat(a);}
        {char[] a = {37}; op[2693] = getOpcodeTls(a);}
        {char[] a = {50}; op[2694] = getOpcodeTls(a);}
        {int[] a = {2696,2697,2698,2699,2700,2701,2702,2703,2704,2705}; op[2695] = getOpcodeAlt(a);}
        {char[] a = {48}; op[2696] = getOpcodeTls(a);}
        {char[] a = {49}; op[2697] = getOpcodeTls(a);}
        {char[] a = {51}; op[2698] = getOpcodeTls(a);}
        {char[] a = {52}; op[2699] = getOpcodeTls(a);}
        {char[] a = {53}; op[2700] = getOpcodeTls(a);}
        {char[] a = {54}; op[2701] = getOpcodeTls(a);}
        {char[] a = {55}; op[2702] = getOpcodeTls(a);}
        {char[] a = {56}; op[2703] = getOpcodeTls(a);}
        {char[] a = {57}; op[2704] = getOpcodeTls(a);}
        op[2705] = getOpcodeRnm(390, 2736); // A-to-F
        {int[] a = {2707,2708,2709}; op[2706] = getOpcodeCat(a);}
        {char[] a = {37}; op[2707] = getOpcodeTls(a);}
        {char[] a = {53}; op[2708] = getOpcodeTls(a);}
        {int[] a = {2710,2711,2712,2713,2714,2715}; op[2709] = getOpcodeAlt(a);}
        op[2710] = getOpcodeRnm(388, 2732); // DIGIT
        {char[] a = {65}; op[2711] = getOpcodeTls(a);}
        {char[] a = {66}; op[2712] = getOpcodeTls(a);}
        {char[] a = {68}; op[2713] = getOpcodeTls(a);}
        {char[] a = {69}; op[2714] = getOpcodeTls(a);}
        {char[] a = {70}; op[2715] = getOpcodeTls(a);}
        {int[] a = {2717,2718}; op[2716] = getOpcodeAlt(a);}
        op[2717] = getOpcodeRnm(382, 2668); // qchar-unescaped
        {int[] a = {2719,2720}; op[2718] = getOpcodeCat(a);}
        op[2719] = getOpcodeRnm(188, 1494); // escape
        {int[] a = {2721,2722}; op[2720] = getOpcodeAlt(a);}
        op[2721] = getOpcodeRnm(188, 1494); // escape
        op[2722] = getOpcodeRnm(181, 1445); // quotation-mark
        op[2723] = getOpcodeRep((char)1, Character.MAX_VALUE, 2724);
        {int[] a = {2725,2726}; op[2724] = getOpcodeAlt(a);}
        op[2725] = getOpcodeRnm(394, 2746); // VCHAR
        op[2726] = getOpcodeRnm(336, 2300); // obs-text
        op[2727] = getOpcodeRep((char)1, Character.MAX_VALUE, 2728);
        op[2728] = getOpcodeRnm(379, 2639); // qchar-no-AMP
        {int[] a = {2730,2731}; op[2729] = getOpcodeAlt(a);}
        op[2730] = getOpcodeTrg((char)65, (char)90);
        op[2731] = getOpcodeTrg((char)97, (char)122);
        op[2732] = getOpcodeTrg((char)48, (char)57);
        {int[] a = {2734,2735}; op[2733] = getOpcodeAlt(a);}
        op[2734] = getOpcodeRnm(388, 2732); // DIGIT
        op[2735] = getOpcodeRnm(390, 2736); // A-to-F
        {int[] a = {2737,2738,2739,2740,2741,2742}; op[2736] = getOpcodeAlt(a);}
        {char[] a = {65}; op[2737] = getOpcodeTls(a);}
        {char[] a = {66}; op[2738] = getOpcodeTls(a);}
        {char[] a = {67}; op[2739] = getOpcodeTls(a);}
        {char[] a = {68}; op[2740] = getOpcodeTls(a);}
        {char[] a = {69}; op[2741] = getOpcodeTls(a);}
        {char[] a = {70}; op[2742] = getOpcodeTls(a);}
        {char[] a = {34}; op[2743] = getOpcodeTbs(a);}
        {char[] a = {32}; op[2744] = getOpcodeTbs(a);}
        {char[] a = {9}; op[2745] = getOpcodeTbs(a);}
        op[2746] = getOpcodeTrg((char)33, (char)126);
        return op;
    }

    public static void display(PrintStream out){
        out.println(";");
        out.println("; tools.xor.odor.ODataParser");
        out.println(";");
        out.println(";------------------------------------------------------------------------------");
        out.println("; odata-abnf-construction-rules");
        out.println(";------------------------------------------------------------------------------");
        out.println(";     OData Version 4.0");
        out.println(";     OASIS Standard");
        out.println(";     24 February 2014");
        out.println(";     Copyright (c) OASIS Open 2014. All Rights Reserved.");
        out.println(";     Source: http://docs.oasis-open.org/odata/odata/v4.0/os/abnf/");
        out.println(";");
        out.println("; Technical Committee:");
        out.println(";   OASIS Open Data Protocol (OData) TC");
        out.println(";");
        out.println("; Chairs:");
        out.println(";   - Barbara Hartel (barbara.hartel@sap.com), SAP AG");
        out.println(";   - Ram Jeyaraman (Ram.Jeyaraman@microsoft.com), Microsoft");
        out.println(";");
        out.println("; Editors:");
        out.println(";   - Ralf Handl (ralf.handl@sap.com), SAP AG");
        out.println(";   - Michael Pizzo (mikep@microsoft.com), Microsoft");
        out.println(";");
        out.println("; Additional artifacts: ");
        out.println(";   This grammar is one component of a Work Product which consists of:");
        out.println(";   - OData Version 4.0 Part 1: Protocol");
        out.println(";   - OData Version 4.0 Part 2: URL Conventions");
        out.println(";   - OData Version 4.0 Part 3: Common Schema Definition Language (CSDL)");
        out.println(";   - OData ABNF Construction Rules Version 4.0 (this document)");
        out.println(";   - OData ABNF Test Cases");
        out.println(";   - OData Core Vocabulary");
        out.println(";   - OData Measures Vocabulary");
        out.println(";   - OData Metadata Service Entity Model");
        out.println(";   - OData EDMX XML Schema");
        out.println(";   - OData EDM XML Schema");
        out.println(";");
        out.println("; Related work:");
        out.println(";   This work product is related to the following two Work Products, each of ");
        out.println(";   which define alternate formats for OData payloads");
        out.println(";   - OData JSON Format Version 4.0");
        out.println(";   - OData Atom Format Version 4.0");
        out.println(";   This specification replaces or supersedes:");
        out.println(";   - None");
        out.println(";");
        out.println("; Declared XML namespaces:");
        out.println(";   - None");
        out.println(";");
        out.println("; Abstract:");
        out.println(";   The Open Data Protocol (OData) enables the creation of REST-based data");
        out.println(";   services, which allow resources, identified using Uniform Resource");
        out.println(";   Identifiers (URLs) and defined in a data model, to be published and ");
        out.println(";   edited by Web clients using simple HTTP messages. This document defines");
        out.println(";   the URL syntax for requests and the serialization format for primitive ");
        out.println(";   literals in request and response payloads.");
        out.println(";");
        out.println("; Overview:");
        out.println(";   This grammar uses the ABNF defined in RFC5234 with one extension: literals ");
        out.println(";   enclosed in single quotes (e.g. '$metadata') are treated case-sensitive. ");
        out.println(";");
        out.println(";   The following rules assume that URIs have been percent-encoding normalized");
        out.println(";   as described in section 6.2.2.2 of RFC3986 ");
        out.println(";   (http://tools.ietf.org/html/rfc3986#section-6.2.2.2)");
        out.println(";   before applying the grammar to them, i.e. all characters in the unreserved ");
        out.println(";   set (see rule \"unreserved\" below) are plain literals and NOT");
        out.println(";   percent-encoded. ");
        out.println(";");
        out.println(";   For characters outside the unreserved set the rules explicitly state ");
        out.println(";   whether the percent-encoded representation is treated identical to the");
        out.println(";   plain literal representation.");
        out.println("; ");
        out.println(";   One prominent example is the single quote that delimits OData primitive  ");
        out.println(";   type literals: %27 and ' are treated identically, so a single quote within ");
        out.println(";   a string literal is \"encoded\" as two consecutive single quotes in either");
        out.println(";   literal or percent-encoded representation.");
        out.println(";");
        out.println("; Contents:");
        out.println(";   1. Resource Path");
        out.println(";   2. Query Options");
        out.println(";   3. Context URL Fragments");
        out.println(";   4. Expressions");
        out.println(";   5. JSON format for function parameters");
        out.println(";   6. Names and identifiers");
        out.println(";   7. Literal Data Values");
        out.println(";   8. Header values");
        out.println(";   9. Punctuation");
        out.println(";");
        out.println(";   A. URI syntax [RFC3986]");
        out.println(";   B. IRI syntax [RFC3986]");
        out.println(";   C. ABNF core definitions [RFC5234]");
        out.println(";");
        out.println(";------------------------------------------------------------------------------");
        out.println("dummyStartRule = odataUri / header / primitiveValue ; just to please the test parser");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("");
        out.println("odataUri = serviceRoot [ odataRelativeUri ]  ");
        out.println("");
        out.println("serviceRoot = ( \"https\" / \"http\" )                    ; Note: case-insensitive ");
        out.println("              \"://\" host [ \":\" port ]");
        out.println("              \"/\" *( segment-nz \"/\" )");
        out.println("");
        out.println("odataRelativeUri = '$batch'                           ; Note: case-sensitive!");
        out.println("                 / '$entity' \"?\" entityOptions  ");
        out.println("                 / '$entity' \"/\" qualifiedEntityTypeName \"?\" entityCastOptions  ");
        out.println("                 / '$metadata' [ \"?\" format ] [ context ]");
        out.println("                 / resourcePath [ \"?\" queryOptions ]");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 1. Resource Path");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("resourcePath = entitySetName                  [ collectionNavigation ] ");
        out.println("             / singletonEntity                [ singleNavigation ]");
        out.println("             / actionImportCall ");
        out.println("             / entityColFunctionImportCall    [ collectionNavigation ] ");
        out.println("             / entityFunctionImportCall       [ singleNavigation ] ");
        out.println("             / complexColFunctionImportCall   [ collectionPath ] ");
        out.println("             / complexFunctionImportCall      [ complexPath ] ");
        out.println("             / primitiveColFunctionImportCall [ collectionPath ] ");
        out.println("             / primitiveFunctionImportCall    [ singlePath ] ");
        out.println("             / crossjoin");
        out.println("             / '$all'");
        out.println("");
        out.println("collectionNavigation = [ \"/\" qualifiedEntityTypeName ] [ collectionNavPath ]");
        out.println("collectionNavPath    = keyPredicate [ singleNavigation ]");
        out.println("                     / collectionPath");
        out.println("                     / ref");
        out.println("");
        out.println("keyPredicate     = simpleKey / compoundKey");
        out.println("simpleKey        = OPEN keyPropertyValue CLOSE");
        out.println("compoundKey      = OPEN keyValuePair *( COMMA keyValuePair ) CLOSE");
        out.println("keyValuePair     = ( primitiveKeyProperty / keyPropertyAlias ) EQ keyPropertyValue");
        out.println("keyPropertyValue = primitiveLiteral");
        out.println("keyPropertyAlias = odataIdentifier");
        out.println("");
        out.println("singleNavigation = [ \"/\" qualifiedEntityTypeName ] ");
        out.println("                   [ \"/\" propertyPath");
        out.println("                   / boundOperation");
        out.println("                   / ref ");
        out.println("                   / value  ; request the media resource of a media entity ");
        out.println("                   ]");
        out.println("");
        out.println("propertyPath = entityColNavigationProperty [ collectionNavigation ]");
        out.println("             / entityNavigationProperty    [ singleNavigation ]");
        out.println("             / complexColProperty          [ collectionPath ]");
        out.println("             / complexProperty             [ complexPath ]");
        out.println("             / primitiveColProperty        [ collectionPath ]");
        out.println("             / primitiveProperty           [ singlePath ]");
        out.println("             / streamProperty              [ boundOperation ]");
        out.println("");
        out.println("collectionPath = count / boundOperation");
        out.println("");
        out.println("singlePath     = value / boundOperation");
        out.println("");
        out.println("complexPath    = [ \"/\" qualifiedComplexTypeName ] ");
        out.println("                 ( \"/\" propertyPath ");
        out.println("                 / boundOperation");
        out.println("                 )");
        out.println("");
        out.println("count = '/$count'");
        out.println("ref   = '/$ref'");
        out.println("value = '/$value'");
        out.println("");
        out.println("; boundOperation segments can only be composed if the type of the previous segment ");
        out.println("; matches the type of the first parameter of the action or function being called.");
        out.println("; Note that the rule name reflects the return type of the function.");
        out.println("boundOperation = \"/\" ( boundActionCall");
        out.println("                     / boundEntityColFuncCall    [ collectionNavigation ] ");
        out.println("                     / boundEntityFuncCall       [ singleNavigation ] ");
        out.println("                     / boundComplexColFuncCall   [ collectionPath ] ");
        out.println("                     / boundComplexFuncCall      [ complexPath ]");
        out.println("                     / boundPrimitiveColFuncCall [ collectionPath ] ");
        out.println("                     / boundPrimitiveFuncCall    [ singlePath ] ");
        out.println("                     )");
        out.println("");
        out.println("actionImportCall = actionImport");
        out.println("boundActionCall  = namespace \".\" action");
        out.println("                   ; with the added restriction that the binding parameter MUST be either an entity or collection of entities");
        out.println("                   ; and is specified by reference using the URI immediately preceding (to the left) of the boundActionCall");
        out.println("");
        out.println("; The following boundXxxFuncCall rules have the added restrictions that");
        out.println(";  - the function MUST support binding, and ");
        out.println(";  - the binding parameter type MUST match the type of resource identified by the ");
        out.println(";    URI immediately preceding (to the left) of the boundXxxFuncCall, and");
        out.println(";  - the functionParameters MUST NOT include the bindingParameter.");
        out.println("boundEntityFuncCall       = namespace \".\" entityFunction       functionParameters");
        out.println("boundEntityColFuncCall    = namespace \".\" entityColFunction    functionParameters");
        out.println("boundComplexFuncCall      = namespace \".\" complexFunction      functionParameters");
        out.println("boundComplexColFuncCall   = namespace \".\" complexColFunction   functionParameters");
        out.println("boundPrimitiveFuncCall    = namespace \".\" primitiveFunction    functionParameters");
        out.println("boundPrimitiveColFuncCall = namespace \".\" primitiveColFunction functionParameters");
        out.println("");
        out.println("entityFunctionImportCall       = entityFunctionImport       functionParameters");
        out.println("entityColFunctionImportCall    = entityColFunctionImport    functionParameters");
        out.println("complexFunctionImportCall      = complexFunctionImport      functionParameters");
        out.println("complexColFunctionImportCall   = complexColFunctionImport   functionParameters");
        out.println("primitiveFunctionImportCall    = primitiveFunctionImport    functionParameters");
        out.println("primitiveColFunctionImportCall = primitiveColFunctionImport functionParameters");
        out.println("");
        out.println("functionParameters = OPEN [ functionParameter *( COMMA functionParameter ) ] CLOSE");
        out.println("functionParameter  = parameterName EQ ( parameterAlias / primitiveLiteral )");
        out.println("parameterName      = odataIdentifier");
        out.println("parameterAlias     = AT odataIdentifier");
        out.println("");
        out.println("crossjoin = '$crossjoin' OPEN");
        out.println("            entitySetName *( COMMA entitySetName )");
        out.println("            CLOSE");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 2. Query Options");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("queryOptions = queryOption *( \"&\" queryOption )        ");
        out.println("queryOption  = systemQueryOption  ");
        out.println("             / aliasAndValue ");
        out.println("             / customQueryOption  ");
        out.println("             ");
        out.println("entityOptions  = *( entityIdOption \"&\" ) id *( \"&\" entityIdOption )");
        out.println("entityIdOption = format");
        out.println("               / customQueryOption");
        out.println("entityCastOptions = *( entityCastOption \"&\" ) id *( \"&\" entityCastOption )");
        out.println("entityCastOption  = entityIdOption");
        out.println("                  / expand ");
        out.println("                  / select");
        out.println("");
        out.println("id = '$id' EQ IRI-in-query       ");
        out.println("");
        out.println("systemQueryOption = expand ");
        out.println("                  / filter ");
        out.println("                  / format ");
        out.println("                  / id");
        out.println("                  / inlinecount ");
        out.println("                  / orderby ");
        out.println("                  / search");
        out.println("                  / select ");
        out.println("                  / skip ");
        out.println("                  / skiptoken");
        out.println("                  / top ");
        out.println("");
        out.println("expand            = '$expand' EQ expandItem *( COMMA expandItem )");
        out.println("expandItem        = STAR [ ref / OPEN levels CLOSE ]");
        out.println("                  / expandPath");
        out.println("                    [ ref   [ OPEN expandRefOption   *( SEMI expandRefOption   ) CLOSE ]");
        out.println("                    / count [ OPEN expandCountOption *( SEMI expandCountOption ) CLOSE ]");
        out.println("                    /         OPEN expandOption      *( SEMI expandOption      ) CLOSE ");
        out.println("                    ]");
        out.println("expandPath        = [ qualifiedEntityTypeName \"/\" ] ");
        out.println("                    *( ( complexProperty / complexColProperty ) \"/\" [ qualifiedComplexTypeName \"/\" ] )");
        out.println("                    navigationProperty ");
        out.println("                    [ \"/\" qualifiedEntityTypeName ]");
        out.println("expandCountOption = filter");
        out.println("                  / search");
        out.println("expandRefOption   = expandCountOption");
        out.println("                  / orderby");
        out.println("                  / skip ");
        out.println("                  / top ");
        out.println("                  / inlinecount");
        out.println("expandOption      = expandRefOption");
        out.println("                  / select ");
        out.println("                  / expand");
        out.println("                  / levels");
        out.println("                ");
        out.println("levels = '$levels' EQ ( 1*DIGIT / 'max' )");
        out.println("");
        out.println("filter = '$filter' EQ boolCommonExpr");
        out.println("");
        out.println("orderby     = '$orderby' EQ orderbyItem *( COMMA orderbyItem )");
        out.println("orderbyItem = commonExpr [ RWS ( 'asc' / 'desc' ) ]");
        out.println("");
        out.println("skip = '$skip' EQ 1*DIGIT");
        out.println("top  = '$top'  EQ 1*DIGIT");
        out.println("");
        out.println("format = '$format' EQ");
        out.println("         ( \"atom\"");
        out.println("         / \"json\" ");
        out.println("         / \"xml\"");
        out.println("         / 1*pchar \"/\" 1*pchar ; <a data service specific value indicating a");
        out.println("         )                     ; format specific to the specific data service> or");
        out.println("                               ; <An IANA-defined [IANA-MMT] content type>");
        out.println("                          ");
        out.println("inlinecount = '$count' EQ booleanValue");
        out.println("");
        out.println("search     = '$search' EQ BWS searchExpr");
        out.println("searchExpr = ( OPEN BWS searchExpr BWS CLOSE");
        out.println("             / searchTerm ");
        out.println("             ) [ searchOrExpr");
        out.println("               / searchAndExpr");
        out.println("               ]");
        out.println("");
        out.println("searchOrExpr  = RWS 'OR'  RWS searchExpr");
        out.println("searchAndExpr = RWS [ 'AND' RWS ] searchExpr");
        out.println("");
        out.println("searchTerm   = [ 'NOT' RWS ] ( searchPhrase / searchWord )");
        out.println("searchPhrase = quotation-mark 1*qchar-no-AMP-DQUOTE quotation-mark");
        out.println("searchWord   = 1*ALPHA ; Actually: any character from the Unicode categories L or Nl, ");
        out.println("                       ; but not the words AND, OR, and NOT");
        out.println("");
        out.println("select         = '$select' EQ selectItem *( COMMA selectItem )");
        out.println("selectItem     = STAR");
        out.println("               / allOperationsInSchema ");
        out.println("               / [ qualifiedEntityTypeName \"/\" ] ");
        out.println("                 ( selectProperty");
        out.println("                 / qualifiedActionName  ");
        out.println("                 / qualifiedFunctionName  ");
        out.println("                 )");
        out.println("selectProperty = primitiveProperty  ");
        out.println("               / primitiveColProperty ");
        out.println("               / navigationProperty");
        out.println("               / selectPath [ \"/\" selectProperty ]");
        out.println("selectPath     = ( complexProperty / complexColProperty ) [ \"/\" qualifiedComplexTypeName ]               ");
        out.println("");
        out.println("");
        out.println("allOperationsInSchema = namespace \".\" STAR                 ");
        out.println("");
        out.println("; The parameterNames uniquely identify the bound function overload");
        out.println("; only if it has overloads.");
        out.println("qualifiedActionName   = namespace \".\" action");
        out.println("qualifiedFunctionName = namespace \".\" function [ OPEN parameterNames CLOSE ]");
        out.println("");
        out.println("; The names of all non-binding parameters, separated by commas ");
        out.println("parameterNames = parameterName *( COMMA parameterName )");
        out.println("");
        out.println("skiptoken = '$skiptoken' EQ 1*( qchar-no-AMP )");
        out.println("");
        out.println("aliasAndValue = parameterAlias EQ parameterValue");
        out.println("");
        out.println("parameterValue = arrayOrObject");
        out.println("               / commonExpr");
        out.println("");
        out.println("customQueryOption = customName [ EQ customValue ]");
        out.println("customName        = qchar-no-AMP-EQ-AT-DOLLAR *( qchar-no-AMP-EQ ) ");
        out.println("customValue       = *( qchar-no-AMP )");
        out.println("");
        out.println("     ");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 3. Context URL Fragments");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("context         = \"#\" contextFragment");
        out.println("contextFragment = 'Collection($ref)'");
        out.println("                / '$ref'");
        out.println("                / 'Collection(Edm.EntityType)'");
        out.println("                / 'Collection(Edm.ComplexType)'");
        out.println("                / singletonEntity");
        out.println("                / qualifiedTypeName");
        out.println("                / entitySet ( '/$deletedEntity' / '/$link' / '/$deletedLink' )");
        out.println("                / entitySet keyPredicate \"/\" contextPropertyPath");
        out.println("                / entitySet [ selectList ] [ '/$entity' / '/$delta' ]");
        out.println("                ");
        out.println("entitySet = entitySetName *( containmentNavigation ) [ \"/\" qualifiedEntityTypeName ]");
        out.println("            ");
        out.println("containmentNavigation = keyPredicate [ \"/\" qualifiedEntityTypeName ]");
        out.println("                        *( \"/\" complexProperty [ \"/\" qualifiedComplexTypeName ] ) \"/\" navigationProperty   ");
        out.println("");
        out.println("selectList         = OPEN selectListItem *( COMMA selectListItem ) CLOSE");
        out.println("selectListItem     = STAR ; all structural properties");
        out.println("                   / allOperationsInSchema ");
        out.println("                   / [ qualifiedEntityTypeName \"/\" ] ");
        out.println("                     ( qualifiedActionName");
        out.println("                     / qualifiedFunctionName ");
        out.println("                     / selectListProperty");
        out.println("                     )");
        out.println("selectListProperty = primitiveProperty  ");
        out.println("                   / primitiveColProperty ");
        out.println("                   / navigationProperty [ '+' ] [ selectList ]");
        out.println("                   / selectPath [ \"/\" selectListProperty ]");
        out.println("");
        out.println("contextPropertyPath = primitiveProperty");
        out.println("                    / primitiveColProperty");
        out.println("                    / complexColProperty");
        out.println("                    / complexProperty [ [ \"/\" qualifiedComplexTypeName ] \"/\" contextPropertyPath ]");
        out.println("                 ");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 4. Expressions");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("; Note: a boolCommonExpr is also a commonExpr, e.g. sort by Boolean ");
        out.println("commonExpr = ( primitiveLiteral");
        out.println("             / parameterAlias");
        out.println("             / arrayOrObject");
        out.println("             / rootExpr");
        out.println("             / firstMemberExpr");
        out.println("             / functionExpr");
        out.println("             / negateExpr ");
        out.println("             / methodCallExpr ");
        out.println("             / parenExpr ");
        out.println("             / castExpr ");
        out.println("             ) ");
        out.println("             [ addExpr ");
        out.println("             / subExpr ");
        out.println("             / mulExpr ");
        out.println("             / divExpr ");
        out.println("             / modExpr");
        out.println("             ]  ");
        out.println("");
        out.println("boolCommonExpr = ( isofExpr ");
        out.println("                 / boolMethodCallExpr ");
        out.println("                 / notExpr  ");
        out.println("                 / commonExpr");
        out.println("                   [ eqExpr ");
        out.println("                   / neExpr ");
        out.println("                   / ltExpr  ");
        out.println("                   / leExpr  ");
        out.println("                   / gtExpr ");
        out.println("                   / geExpr ");
        out.println("                   / hasExpr ");
        out.println("                   ]");
        out.println("                 / boolParenExpr");
        out.println("                 ) [ andExpr / orExpr ] ");
        out.println("");
        out.println("rootExpr = '$root/' ( entitySetName keyPredicate / singletonEntity ) [ singleNavigationExpr ]");
        out.println("");
        out.println("firstMemberExpr = memberExpr");
        out.println("                / inscopeVariableExpr [ \"/\" memberExpr ]");
        out.println("");
        out.println("memberExpr = [ qualifiedEntityTypeName \"/\" ]");
        out.println("             ( propertyPathExpr");
        out.println("             / boundFunctionExpr ");
        out.println("             )");
        out.println("             ");
        out.println("propertyPathExpr = ( entityColNavigationProperty [ collectionNavigationExpr ] ");
        out.println("                   / entityNavigationProperty    [ singleNavigationExpr ] ");
        out.println("                   / complexColProperty          [ collectionPathExpr ]");
        out.println("                   / complexProperty             [ complexPathExpr ] ");
        out.println("                   / primitiveColProperty        [ collectionPathExpr ]");
        out.println("                   / primitiveProperty           [ singlePathExpr ]");
        out.println("                   / streamProperty");
        out.println("                   )");
        out.println("                   ");
        out.println("inscopeVariableExpr       = implicitVariableExpr ");
        out.println("                          / lambdaVariableExpr ; only allowed inside a lambdaPredicateExpr");
        out.println("implicitVariableExpr      = '$it'              ; references the unnamed outer variable of the query");
        out.println("lambdaVariableExpr        = odataIdentifier");
        out.println("");
        out.println("collectionNavigationExpr = [ \"/\" qualifiedEntityTypeName ]");
        out.println("                           ( keyPredicate [ singleNavigationExpr ] ");
        out.println("                           / collectionPathExpr ");
        out.println("                           )");
        out.println("");
        out.println("singleNavigationExpr = \"/\" memberExpr");
        out.println("");
        out.println("collectionPathExpr = count ");
        out.println("                   / \"/\" boundFunctionExpr");
        out.println("                   / \"/\" anyExpr");
        out.println("                   / \"/\" allExpr");
        out.println(" ");
        out.println("complexPathExpr = \"/\" [ qualifiedComplexTypeName \"/\" ]");
        out.println("                  ( propertyPathExpr ");
        out.println("                  / boundFunctionExpr ");
        out.println("                  )");
        out.println("");
        out.println("singlePathExpr = \"/\" boundFunctionExpr");
        out.println("");
        out.println("boundFunctionExpr = functionExpr ; boundFunction segments can only be composed if the type of the    ");
        out.println("                                 ; previous segment matches the type of the first function parameter");
        out.println("                                     ");
        out.println("functionExpr = namespace \".\"");
        out.println("               ( entityColFunction    functionExprParameters [ collectionNavigationExpr ] ");
        out.println("               / entityFunction       functionExprParameters [ singleNavigationExpr ] ");
        out.println("               / complexColFunction   functionExprParameters [ collectionPathExpr ]");
        out.println("               / complexFunction      functionExprParameters [ complexPathExpr ] ");
        out.println("               / primitiveColFunction functionExprParameters [ collectionPathExpr ] ");
        out.println("               / primitiveFunction    functionExprParameters [ singlePathExpr ] ");
        out.println("               )");
        out.println("");
        out.println("functionExprParameters = OPEN [ functionExprParameter *( COMMA functionExprParameter ) ] CLOSE");
        out.println("functionExprParameter  = parameterName EQ ( parameterAlias / parameterValue )");
        out.println("");
        out.println("anyExpr = 'any' OPEN BWS [ lambdaVariableExpr BWS COLON BWS lambdaPredicateExpr ] BWS CLOSE");
        out.println("allExpr = 'all' OPEN BWS   lambdaVariableExpr BWS COLON BWS lambdaPredicateExpr   BWS CLOSE");
        out.println("lambdaPredicateExpr = boolCommonExpr ; containing at least one lambdaVariableExpr");
        out.println("");
        out.println("methodCallExpr = indexOfMethodCallExpr ");
        out.println("               / toLowerMethodCallExpr ");
        out.println("               / toUpperMethodCallExpr  ");
        out.println("               / trimMethodCallExpr ");
        out.println("               / substringMethodCallExpr ");
        out.println("               / concatMethodCallExpr ");
        out.println("               / lengthMethodCallExpr ");
        out.println("               / yearMethodCallExpr ");
        out.println("               / monthMethodCallExpr ");
        out.println("               / dayMethodCallExpr ");
        out.println("               / hourMethodCallExpr ");
        out.println("               / minuteMethodCallExpr ");
        out.println("               / secondMethodCallExpr ");
        out.println("               / fractionalsecondsMethodCallExpr");
        out.println("               / totalsecondsMethodCallExpr");
        out.println("               / dateMethodCallExpr ");
        out.println("               / timeMethodCallExpr ");
        out.println("               / roundMethodCallExpr ");
        out.println("               / floorMethodCallExpr ");
        out.println("               / ceilingMethodCallExpr ");
        out.println("               / distanceMethodCallExpr ");
        out.println("               / geoLengthMethodCallExpr ");
        out.println("               / totalOffsetMinutesMethodCallExpr");
        out.println("               / minDateTimeMethodCallExpr");
        out.println("               / maxDateTimeMethodCallExpr");
        out.println("               / nowMethodCallExpr");
        out.println("");
        out.println("boolMethodCallExpr = endsWithMethodCallExpr ");
        out.println("                   / startsWithMethodCallExpr ");
        out.println("                   / containsMethodCallExpr                                          ");
        out.println("                   / intersectsMethodCallExpr ");
        out.println("");
        out.println("containsMethodCallExpr   = 'contains'   OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("startsWithMethodCallExpr = 'startswith' OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("endsWithMethodCallExpr   = 'endswith'   OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("lengthMethodCallExpr     = 'length'     OPEN BWS commonExpr BWS CLOSE");
        out.println("indexOfMethodCallExpr    = 'indexof'    OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("substringMethodCallExpr  = 'substring'  OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS [ COMMA BWS commonExpr BWS ] CLOSE");
        out.println("toLowerMethodCallExpr    = 'tolower'    OPEN BWS commonExpr BWS CLOSE");
        out.println("toUpperMethodCallExpr    = 'toupper'    OPEN BWS commonExpr BWS CLOSE");
        out.println("trimMethodCallExpr       = 'trim'       OPEN BWS commonExpr BWS CLOSE");
        out.println("concatMethodCallExpr     = 'concat'     OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("");
        out.println("yearMethodCallExpr               = 'year'               OPEN BWS commonExpr BWS CLOSE");
        out.println("monthMethodCallExpr              = 'month'              OPEN BWS commonExpr BWS CLOSE");
        out.println("dayMethodCallExpr                = 'day'                OPEN BWS commonExpr BWS CLOSE");
        out.println("hourMethodCallExpr               = 'hour'               OPEN BWS commonExpr BWS CLOSE");
        out.println("minuteMethodCallExpr             = 'minute'             OPEN BWS commonExpr BWS CLOSE");
        out.println("secondMethodCallExpr             = 'second'             OPEN BWS commonExpr BWS CLOSE");
        out.println("fractionalsecondsMethodCallExpr  = 'fractionalseconds'  OPEN BWS commonExpr BWS CLOSE");
        out.println("totalsecondsMethodCallExpr       = 'totalseconds'       OPEN BWS commonExpr BWS CLOSE");
        out.println("dateMethodCallExpr               = 'date'               OPEN BWS commonExpr BWS CLOSE");
        out.println("timeMethodCallExpr               = 'time'               OPEN BWS commonExpr BWS CLOSE");
        out.println("totalOffsetMinutesMethodCallExpr = 'totaloffsetminutes' OPEN BWS commonExpr BWS CLOSE ");
        out.println("");
        out.println("minDateTimeMethodCallExpr = 'mindatetime(' BWS ')'");
        out.println("maxDateTimeMethodCallExpr = 'maxdatetime(' BWS ')'");
        out.println("nowMethodCallExpr         = 'now(' BWS ')'");
        out.println("");
        out.println("roundMethodCallExpr   = 'round'   OPEN BWS commonExpr BWS CLOSE");
        out.println("floorMethodCallExpr   = 'floor'   OPEN BWS commonExpr BWS CLOSE");
        out.println("ceilingMethodCallExpr = 'ceiling' OPEN BWS commonExpr BWS CLOSE");
        out.println("");
        out.println("distanceMethodCallExpr   = 'geo.distance'   OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("geoLengthMethodCallExpr  = 'geo.length'     OPEN BWS commonExpr BWS CLOSE");
        out.println("intersectsMethodCallExpr = 'geo.intersects' OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("");
        out.println("boolParenExpr = OPEN BWS boolCommonExpr BWS CLOSE");
        out.println("parenExpr     = OPEN BWS commonExpr     BWS CLOSE");
        out.println("");
        out.println("andExpr = RWS 'and' RWS boolCommonExpr");
        out.println("orExpr  = RWS 'or'  RWS boolCommonExpr");
        out.println("");
        out.println("eqExpr = RWS 'eq' RWS commonExpr     ");
        out.println("neExpr = RWS 'ne' RWS commonExpr");
        out.println("ltExpr = RWS 'lt' RWS commonExpr");
        out.println("leExpr = RWS 'le' RWS commonExpr");
        out.println("gtExpr = RWS 'gt' RWS commonExpr");
        out.println("geExpr = RWS 'ge' RWS commonExpr");
        out.println("");
        out.println("hasExpr = RWS 'has' RWS commonExpr");
        out.println("");
        out.println("addExpr = RWS 'add' RWS commonExpr");
        out.println("subExpr = RWS 'sub' RWS commonExpr");
        out.println("mulExpr = RWS 'mul' RWS commonExpr");
        out.println("divExpr = RWS 'div' RWS commonExpr");
        out.println("modExpr = RWS 'mod' RWS commonExpr");
        out.println("");
        out.println("negateExpr = \"-\" BWS commonExpr");
        out.println("");
        out.println("notExpr = 'not' RWS boolCommonExpr");
        out.println("");
        out.println("isofExpr = 'isof' OPEN BWS [ commonExpr BWS COMMA BWS ] qualifiedTypeName BWS CLOSE");
        out.println("castExpr = 'cast' OPEN BWS [ commonExpr BWS COMMA BWS ] qualifiedTypeName BWS CLOSE");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 5. JSON format for function parameters");
        out.println(";------------------------------------------------------------------------------");
        out.println("; Note: the query part of a URI needs to be partially percent-decoded before");
        out.println("; applying these rules, see comment at the top of this file");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("arrayOrObject = complexColInUri  ");
        out.println("              / complexInUri");
        out.println("              / rootExprCol");
        out.println("              / primitiveColInUri");
        out.println("               ");
        out.println("complexColInUri = begin-array ");
        out.println("                  [ complexInUri *( value-separator complexInUri ) ] ");
        out.println("                  end-array");
        out.println("                  ");
        out.println("complexInUri = begin-object");
        out.println("               [ ( annotationInUri ");
        out.println("                 / primitivePropertyInUri ");
        out.println("                 / complexPropertyInUri ");
        out.println("                 / collectionPropertyInUri  ");
        out.println("                 / navigationPropertyInUri");
        out.println("                 )");
        out.println("                 *( value-separator ");
        out.println("                    ( annotationInUri ");
        out.println("                    / primitivePropertyInUri ");
        out.println("                    / complexPropertyInUri ");
        out.println("                    / collectionPropertyInUri  ");
        out.println("                    / navigationPropertyInUri");
        out.println("                    ) ");
        out.println("                  )");
        out.println("               ]  ");
        out.println("               end-object");
        out.println("");
        out.println("collectionPropertyInUri = ( quotation-mark primitiveColProperty quotation-mark ");
        out.println("                            name-separator ");
        out.println("                            primitiveColInUri ");
        out.println("                          ) ");
        out.println("                        / ( quotation-mark complexColProperty quotation-mark ");
        out.println("                            name-separator ");
        out.println("                            complexColInUri");
        out.println("                          )");
        out.println("");
        out.println("primitiveColInUri = begin-array ");
        out.println("                    [ primitiveLiteralInJSON *( value-separator primitiveLiteralInJSON ) ] ");
        out.println("                    end-array");
        out.println("                    ");
        out.println("complexPropertyInUri = quotation-mark complexProperty quotation-mark ");
        out.println("                       name-separator ");
        out.println("                       complexInUri");
        out.println("                            ");
        out.println("annotationInUri = quotation-mark namespace \".\" termName quotation-mark");
        out.println("                  name-separator");
        out.println("                  ( complexInUri / complexColInUri / primitiveLiteralInJSON / primitiveColInUri )");
        out.println("");
        out.println("primitivePropertyInUri = quotation-mark primitiveProperty quotation-mark ");
        out.println("                         name-separator ");
        out.println("                         primitiveLiteralInJSON");
        out.println("");
        out.println("navigationPropertyInUri = singleNavPropInJSON");
        out.println("                        / collectionNavPropInJSON");
        out.println("singleNavPropInJSON     = quotation-mark entityNavigationProperty quotation-mark");
        out.println("													name-separator");
        out.println("													rootExpr");
        out.println("collectionNavPropInJSON = quotation-mark entityColNavigationProperty quotation-mark");
        out.println("													name-separator");
        out.println("													rootExprCol");
        out.println("");
        out.println("rootExprCol = begin-array ");
        out.println("              [ rootExpr *( value-separator rootExpr ) ]");
        out.println("              end-array");
        out.println("                                        ");
        out.println("; JSON syntax: adapted to URI restrictions from [RFC4627]                 ");
        out.println("begin-object = BWS ( \"{\" / \"%7B\" ) BWS");
        out.println("end-object   = BWS ( \"}\" / \"%7D\" ) BWS");
        out.println("");
        out.println("begin-array = BWS ( \"[\" / \"%5B\" ) BWS ");
        out.println("end-array   = BWS ( \"]\" / \"%5D\" ) BWS");
        out.println("");
        out.println("quotation-mark  = DQUOTE / \"%22\"");
        out.println("name-separator  = BWS COLON BWS");
        out.println("value-separator = BWS COMMA BWS");
        out.println("");
        out.println("primitiveLiteralInJSON = stringInJSON");
        out.println("                       / numberInJSON");
        out.println("                       / 'true' ");
        out.println("                       / 'false'");
        out.println("                       / 'null'");
        out.println("");
        out.println("stringInJSON = quotation-mark *charInJSON quotation-mark");
        out.println("charInJSON   = qchar-unescaped  ");
        out.println("             / qchar-JSON-special    ");
        out.println("             / escape ( quotation-mark ");
        out.println("                      / escape");
        out.println("                      / ( \"/\" / \"%2F\" ) ; solidus         U+002F");
        out.println("                      / 'b'             ; backspace       U+0008                ");
        out.println("                      / 'f'             ; form feed       U+000C");
        out.println("                      / 'n'             ; line feed       U+000A");
        out.println("                      / 'r'             ; carriage return U+000D");
        out.println("                      / 't'             ; tab             U+0009");
        out.println("                      / 'u' 4HEXDIG     ;                 U+XXXX");
        out.println("                      )");
        out.println("");
        out.println("qchar-JSON-special = SP / \":\" / \"{\" / \"}\" / \"[\" / \"]\" ; some agents put these unencoded into the query part of a URL");
        out.println("");
        out.println("escape = \"\\\" / \"%5C\"     ; reverse solidus U+005C");
        out.println("");
        out.println("numberInJSON = [ \"-\" ] int [ frac ] [ exp ]");
        out.println("int          = \"0\" / ( oneToNine *DIGIT )");
        out.println("frac         = \".\" 1*DIGIT");
        out.println("exp          = \"e\" [ \"-\" / \"+\" ] 1*DIGIT");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 6. Names and identifiers");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("singleQualifiedTypeName = qualifiedEntityTypeName ");
        out.println("                        / qualifiedComplexTypeName");
        out.println("                        / qualifiedTypeDefinitionName");
        out.println("                        / qualifiedEnumTypeName");
        out.println("                        / primitiveTypeName ");
        out.println("                  ");
        out.println("qualifiedTypeName = singleQualifiedTypeName                  ");
        out.println("                  / 'Collection' OPEN singleQualifiedTypeName CLOSE");
        out.println("");
        out.println("qualifiedEntityTypeName     = namespace \".\" entityTypeName");
        out.println("qualifiedComplexTypeName    = namespace \".\" complexTypeName");
        out.println("qualifiedTypeDefinitionName = namespace \".\" typeDefinitionName ");
        out.println("qualifiedEnumTypeName       = namespace \".\" enumerationTypeName");
        out.println("");
        out.println("; an alias is just a single-part namespace");
        out.println("namespace     = namespacePart *( \".\" namespacePart )");
        out.println("namespacePart = odataIdentifier");
        out.println("");
        out.println("entitySetName       = odataIdentifier");
        out.println("singletonEntity     = odataIdentifier          ");
        out.println("entityTypeName      = odataIdentifier");
        out.println("complexTypeName     = odataIdentifier");
        out.println("typeDefinitionName  = odataIdentifier ");
        out.println("enumerationTypeName = odataIdentifier");
        out.println("enumerationMember   = odataIdentifier");
        out.println("termName            = odataIdentifier");
        out.println("");
        out.println("; Note: this pattern is overly restrictive, the normative definition is type TSimpleIdentifier in OData EDM XML Schema");
        out.println("odataIdentifier             = identifierLeadingCharacter *127identifierCharacter");
        out.println("identifierLeadingCharacter  = ALPHA / \"_\"         ; plus Unicode characters from the categories L or Nl");
        out.println("identifierCharacter         = ALPHA / \"_\" / DIGIT ; plus Unicode characters from the categories L, Nl, Nd, Mn, Mc, Pc, or Cf");
        out.println("");
        out.println("primitiveTypeName = 'Edm.' ( 'Binary'");
        out.println("                           / 'Boolean'");
        out.println("                           / 'Byte'");
        out.println("                           / 'Date' ");
        out.println("                           / 'DateTimeOffset'");
        out.println("                           / 'Decimal'");
        out.println("                           / 'Double'");
        out.println("                           / 'Duration' ");
        out.println("                           / 'Guid' ");
        out.println("                           / 'Int16'");
        out.println("                           / 'Int32'");
        out.println("                           / 'Int64'");
        out.println("                           / 'SByte'");
        out.println("                           / 'Single'");
        out.println("                           / 'Stream'");
        out.println("                           / 'String'");
        out.println("                           / 'TimeOfDay'");
        out.println("                           / abstractSpatialTypeName [ concreteSpatialTypeName ] ");
        out.println("                           )");
        out.println("abstractSpatialTypeName = 'Geography'");
        out.println("                        / 'Geometry'");
        out.println("concreteSpatialTypeName = 'Collection'");
        out.println("                        / 'LineString'");
        out.println("                        / 'MultiLineString'");
        out.println("                        / 'MultiPoint'");
        out.println("                        / 'MultiPolygon'");
        out.println("                        / 'Point'");
        out.println("                        / 'Polygon'");
        out.println("");
        out.println("primitiveProperty       = primitiveKeyProperty / primitiveNonKeyProperty");
        out.println("primitiveKeyProperty    = odataIdentifier");
        out.println("primitiveNonKeyProperty = odataIdentifier");
        out.println("primitiveColProperty    = odataIdentifier");
        out.println("complexProperty         = odataIdentifier");
        out.println("complexColProperty      = odataIdentifier");
        out.println("streamProperty          = odataIdentifier");
        out.println("");
        out.println("navigationProperty          = entityNavigationProperty / entityColNavigationProperty  ");
        out.println("entityNavigationProperty    = odataIdentifier");
        out.println("entityColNavigationProperty = odataIdentifier");
        out.println("");
        out.println("action       = odataIdentifier");
        out.println("actionImport = odataIdentifier");
        out.println("");
        out.println("function = entityFunction ");
        out.println("         / entityColFunction ");
        out.println("         / complexFunction ");
        out.println("         / complexColFunction ");
        out.println("         / primitiveFunction ");
        out.println("         / primitiveColFunction");
        out.println("         ");
        out.println("entityFunction       = odataIdentifier");
        out.println("entityColFunction    = odataIdentifier");
        out.println("complexFunction      = odataIdentifier");
        out.println("complexColFunction   = odataIdentifier");
        out.println("primitiveFunction    = odataIdentifier");
        out.println("primitiveColFunction = odataIdentifier");
        out.println("");
        out.println("entityFunctionImport       = odataIdentifier");
        out.println("entityColFunctionImport    = odataIdentifier");
        out.println("complexFunctionImport      = odataIdentifier");
        out.println("complexColFunctionImport   = odataIdentifier");
        out.println("primitiveFunctionImport    = odataIdentifier");
        out.println("primitiveColFunctionImport = odataIdentifier");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 7. Literal Data Values");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("; in URLs");
        out.println("primitiveLiteral = nullValue                  ; plain values up to int64Value");
        out.println("                 / booleanValue ");
        out.println("                 / guidValue ");
        out.println("                 / dateValue");
        out.println("                 / dateTimeOffsetValue ");
        out.println("                 / timeOfDayValue");
        out.println("                 / decimalValue ");
        out.println("                 / doubleValue ");
        out.println("                 / singleValue ");
        out.println("                 / sbyteValue ");
        out.println("                 / byteValue");
        out.println("                 / int16Value ");
        out.println("                 / int32Value ");
        out.println("                 / int64Value ");
        out.println("                 / string                     ; single-quoted");
        out.println("                 / duration                   ; all others are quoted and prefixed");
        out.println("                 / binary ");
        out.println("                 / enum");
        out.println("                 / geographyCollection ");
        out.println("                 / geographyLineString ");
        out.println("                 / geographyMultiLineString ");
        out.println("                 / geographyMultiPoint ");
        out.println("                 / geographyMultiPolygon ");
        out.println("                 / geographyPoint ");
        out.println("                 / geographyPolygon ");
        out.println("                 / geometryCollection ");
        out.println("                 / geometryLineString ");
        out.println("                 / geometryMultiLineString ");
        out.println("                 / geometryMultiPoint ");
        out.println("                 / geometryMultiPolygon ");
        out.println("                 / geometryPoint ");
        out.println("                 / geometryPolygon");
        out.println("         ");
        out.println("; in Atom and JSON message bodies and CSDL DefaultValue attributes                 ");
        out.println("primitiveValue = booleanValue");
        out.println("               / guidValue");
        out.println("               / durationValue");
        out.println("               / dateValue");
        out.println("               / dateTimeOffsetValue ");
        out.println("               / timeOfDayValue");
        out.println("               / enumValue");
        out.println("               / fullCollectionLiteral");
        out.println("               / fullLineStringLiteral");
        out.println("               / fullMultiPointLiteral");
        out.println("               / fullMultiLineStringLiteral");
        out.println("               / fullMultiPolygonLiteral");
        out.println("               / fullPointLiteral");
        out.println("               / fullPolygonLiteral");
        out.println("               / decimalValue ");
        out.println("               / doubleValue ");
        out.println("               / singleValue ");
        out.println("               / sbyteValue ");
        out.println("               / byteValue");
        out.println("               / int16Value ");
        out.println("               / int32Value ");
        out.println("               / int64Value ");
        out.println("               / binaryValue ");
        out.println("               ; also valid are:");
        out.println("               ; - any XML string for strings in Atom and CSDL documents");
        out.println("               ; - any JSON string for JSON documents ");
        out.println("");
        out.println("nullValue = 'null' ");
        out.println("");
        out.println("; TODO: base64url                                                ");
        out.println("binary      = \"binary\" SQUOTE binaryValue SQUOTE");
        out.println("binaryValue = *(4base64char) [ base64b16  / base64b8 ]");
        out.println("base64b16   = 2base64char ( 'A' / 'E' / 'I' / 'M' / 'Q' / 'U' / 'Y' / 'c' / 'g' / 'k' / 'o' / 's' / 'w' / '0' / '4' / '8' )   [ \"=\" ]");
        out.println("base64b8    = base64char ( 'A' / 'Q' / 'g' / 'w' ) [ \"==\" ]");
        out.println("base64char  = ALPHA / DIGIT / \"-\" / \"_\"");
        out.println("");
        out.println("booleanValue = \"true\" / \"false\"");
        out.println("");
        out.println("decimalValue = [SIGN] 1*DIGIT [\".\" 1*DIGIT]");
        out.println("");
        out.println("doubleValue = decimalValue [ \"e\" [SIGN] 1*DIGIT ] / nanInfinity ; IEEE 754 binary64 floating-point number (15-17 decimal digits)");
        out.println("singleValue = doubleValue                                       ; IEEE 754 binary32 floating-point number (6-9 decimal digits)");
        out.println("nanInfinity = 'NaN' / '-INF' / 'INF'");
        out.println("");
        out.println("guidValue = 8HEXDIG \"-\" 4HEXDIG \"-\" 4HEXDIG \"-\" 4HEXDIG \"-\" 12HEXDIG ");
        out.println("");
        out.println("byteValue  = 1*3DIGIT           ; numbers in the range from 0 to 255");
        out.println("sbyteValue = [ sign ] 1*3DIGIT  ; numbers in the range from -128 to 127");
        out.println("int16Value = [ sign ] 1*5DIGIT  ; numbers in the range from -32768 to 32767        ");
        out.println("int32Value = [ sign ] 1*10DIGIT ; numbers in the range from -2147483648 to 2147483647");
        out.println("int64Value = [ sign ] 1*19DIGIT ; numbers in the range from -9223372036854775808 to 9223372036854775807");
        out.println("");
        out.println("string           = SQUOTE *( SQUOTE-in-string / pchar-no-SQUOTE ) SQUOTE");
        out.println("SQUOTE-in-string = SQUOTE SQUOTE ; two consecutive single quotes represent one within a string literal");
        out.println("");
        out.println("dateValue = year \"-\" month \"-\" day");
        out.println("");
        out.println("dateTimeOffsetValue = year \"-\" month \"-\" day \"T\" hour \":\" minute [ \":\" second [ \".\" fractionalSeconds ] ] ( \"Z\" / sign hour \":\" minute )");
        out.println("");
        out.println("duration      = \"duration\" SQUOTE durationValue SQUOTE");
        out.println("durationValue = [ sign ] \"P\" [ 1*DIGIT \"D\" ] [ \"T\" [ 1*DIGIT \"H\" ] [ 1*DIGIT \"M\" ] [ 1*DIGIT [ \".\" 1*DIGIT ] \"S\" ] ]");
        out.println("     ; the above is an approximation of the rules for an xml dayTimeDuration.");
        out.println("     ; see the lexical representation for dayTimeDuration in http://www.w3.org/TR/xmlschema11-2#dayTimeDuration for more information");
        out.println("");
        out.println("timeOfDayValue = hour \":\" minute [ \":\" second [ \".\" fractionalSeconds ] ]");
        out.println(" ");
        out.println("oneToNine       = \"1\" / \"2\" / \"3\" / \"4\" / \"5\" / \"6\" / \"7\" / \"8\" / \"9\" ");
        out.println("zeroToFiftyNine = ( \"0\" / \"1\" / \"2\" / \"3\" / \"4\" / \"5\" ) DIGIT");
        out.println("year  = [ \"-\" ] ( \"0\" 3DIGIT / oneToNine 3*DIGIT )");
        out.println("month = \"0\" oneToNine");
        out.println("      / \"1\" ( \"0\" / \"1\" / \"2\" )");
        out.println("day   = \"0\" oneToNine");
        out.println("      / ( \"1\" / \"2\" ) DIGIT");
        out.println("      / \"3\" ( \"0\" / \"1\" )");
        out.println("hour   = ( \"0\" / \"1\" ) DIGIT");
        out.println("       / \"2\" ( \"1\" / \"2\" / \"3\" ) ");
        out.println("minute = zeroToFiftyNine");
        out.println("second = zeroToFiftyNine       ");
        out.println("fractionalSeconds = 1*12DIGIT");
        out.println("");
        out.println("enum            = qualifiedEnumTypeName SQUOTE enumValue SQUOTE");
        out.println("enumValue       = singleEnumValue *( COMMA singleEnumValue )");
        out.println("singleEnumValue = enumerationMember / enumMemberValue");
        out.println("enumMemberValue = int64Value");
        out.println("");
        out.println("geographyCollection   = geographyPrefix SQUOTE fullCollectionLiteral SQUOTE");
        out.println("fullCollectionLiteral = sridLiteral collectionLiteral");
        out.println("collectionLiteral     = \"Collection(\" geoLiteral *( COMMA geoLiteral ) CLOSE");
        out.println("geoLiteral            = collectionLiteral");
        out.println("                      / lineStringLiteral");
        out.println("                      / multiPointLiteral");
        out.println("                      / multiLineStringLiteral");
        out.println("                      / multiPolygonLiteral");
        out.println("                      / pointLiteral");
        out.println("                      / polygonLiteral");
        out.println("");
        out.println("geographyLineString   = geographyPrefix SQUOTE fullLineStringLiteral SQUOTE");
        out.println("fullLineStringLiteral = sridLiteral lineStringLiteral");
        out.println("lineStringLiteral     = \"LineString\" lineStringData");
        out.println("lineStringData        = OPEN positionLiteral 1*( COMMA positionLiteral ) CLOSE");
        out.println("");
        out.println("geographyMultiLineString   = geographyPrefix SQUOTE fullMultiLineStringLiteral SQUOTE");
        out.println("fullMultiLineStringLiteral = sridLiteral multiLineStringLiteral");
        out.println("multiLineStringLiteral     = \"MultiLineString(\" [ lineStringData *( COMMA lineStringData ) ] CLOSE");
        out.println("");
        out.println("geographyMultiPoint   = geographyPrefix SQUOTE fullMultiPointLiteral SQUOTE");
        out.println("fullMultiPointLiteral = sridLiteral multiPointLiteral");
        out.println("multiPointLiteral     = \"MultiPoint(\" [ pointData *( COMMA pointData ) ] CLOSE");
        out.println("");
        out.println("geographyMultiPolygon   = geographyPrefix SQUOTE fullMultiPolygonLiteral SQUOTE");
        out.println("fullMultiPolygonLiteral = sridLiteral multiPolygonLiteral");
        out.println("multiPolygonLiteral     = \"MultiPolygon(\" [ polygonData *( COMMA polygonData ) ] CLOSE");
        out.println("");
        out.println("geographyPoint   = geographyPrefix SQUOTE fullPointLiteral SQUOTE");
        out.println("fullPointLiteral = sridLiteral pointLiteral");
        out.println("sridLiteral      = \"SRID\" EQ 1*5DIGIT SEMI");
        out.println("pointLiteral     =\"Point\" pointData");
        out.println("pointData        = OPEN positionLiteral CLOSE");
        out.println("positionLiteral  = doubleValue SP doubleValue  ; longitude, then latitude");
        out.println("");
        out.println("geographyPolygon   = geographyPrefix SQUOTE fullPolygonLiteral SQUOTE");
        out.println("fullPolygonLiteral = sridLiteral polygonLiteral");
        out.println("polygonLiteral     = \"Polygon\" polygonData");
        out.println("polygonData        = OPEN ringLiteral *( COMMA ringLiteral ) CLOSE");
        out.println("ringLiteral        = OPEN positionLiteral *( COMMA positionLiteral ) CLOSE");
        out.println("                   ; Within each ringLiteral, the first and last positionLiteral elements MUST be an exact syntactic match to each other.");
        out.println("                   ; Within the polygonData, the ringLiterals MUST specify their points in appropriate winding order. ");
        out.println("                   ; In order of traversal, points to the left side of the ring are interpreted as being in the polygon.");
        out.println("");
        out.println("geometryCollection      = geometryPrefix SQUOTE fullCollectionLiteral      SQUOTE");
        out.println("geometryLineString      = geometryPrefix SQUOTE fullLineStringLiteral      SQUOTE");
        out.println("geometryMultiLineString = geometryPrefix SQUOTE fullMultiLineStringLiteral SQUOTE");
        out.println("geometryMultiPoint      = geometryPrefix SQUOTE fullMultiPointLiteral      SQUOTE");
        out.println("geometryMultiPolygon    = geometryPrefix SQUOTE fullMultiPolygonLiteral    SQUOTE");
        out.println("geometryPoint           = geometryPrefix SQUOTE fullPointLiteral           SQUOTE");
        out.println("geometryPolygon         = geometryPrefix SQUOTE fullPolygonLiteral         SQUOTE");
        out.println("");
        out.println("geographyPrefix = \"geography\"");
        out.println("geometryPrefix  = \"geometry\" ");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 8. Header values");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("header = content-id");
        out.println("       / odata-entityid");
        out.println("       / odata-isolation");
        out.println("       / odata-maxversion");
        out.println("       / odata-version");
        out.println("       / prefer");
        out.println("");
        out.println("content-id = \"Content-ID\" COLON OWS 1*unreserved");
        out.println("       ");
        out.println("odata-entityid   = \"OData-EntityID\"   COLON OWS IRI-in-header");
        out.println("odata-isolation  = \"OData-Isolation\"  COLON OWS \"snapshot\"");
        out.println("odata-maxversion = \"OData-MaxVersion\" COLON OWS \"4.0\"     ");
        out.println("odata-version    = \"OData-Version\"    COLON OWS \"4.0\"     ");
        out.println("      ");
        out.println("prefer     = \"Prefer\" COLON OWS preference *( COMMA preference )       ");
        out.println("preference = allowEntityReferencesPreference");
        out.println("           / callbackPreference");
        out.println("           / continueOnErrorPreference");
        out.println("           / includeAnnotationsPreference");
        out.println("           / maxpagesizePreference");
        out.println("           / respondAsyncPreference");
        out.println("           / returnPreference");
        out.println("           / trackChangesPreference");
        out.println("           / waitPreference");
        out.println("           ; and everything allowed by http://tools.ietf.org/html/draft-snell-http-prefer-18");
        out.println("           ; / token [ BWS \"=\" BWS word ] *( OWS \";\" [ OWS parameter ] )");
        out.println("           ");
        out.println("allowEntityReferencesPreference = \"odata.allow-entityreferences\"");
        out.println("");
        out.println("callbackPreference = \"odata.callback\" OWS \";\" OWS \"url\" BWS EQ BWS DQUOTE URI DQUOTE");
        out.println("");
        out.println("continueOnErrorPreference = \"odata.continue-on-error\"           ");
        out.println("           ");
        out.println("includeAnnotationsPreference = \"odata.include-annotations\" BWS EQ BWS DQUOTE annotationsList DQUOTE");
        out.println("annotationsList      = annotationIdentifier *(COMMA annotationIdentifier)");
        out.println("annotationIdentifier = [ excludeOperator ]");
        out.println("                       ( STAR ");
        out.println("                       / namespace \".\" ( termName / STAR ) ");
        out.println("                       ) ");
        out.println("excludeOperator      = \"-\"");
        out.println("           ");
        out.println("maxpagesizePreference = \"odata.maxpagesize\" BWS EQ BWS oneToNine *DIGIT         ");
        out.println("");
        out.println("respondAsyncPreference = \"respond-async\"");
        out.println("");
        out.println("returnPreference = \"return\" BWS EQ BWS ( 'representation' / 'minimal' )");
        out.println("");
        out.println("trackChangesPreference = \"odata.track-changes\"");
        out.println("");
        out.println("waitPreference = \"wait\" BWS EQ BWS 1*DIGIT");
        out.println("");
        out.println(";parameter      = token [ BWS \"=\" BWS word ]");
        out.println(";word           = token / quoted-string");
        out.println(";token          = 1*tchar");
        out.println(";tchar          = \"!\" / \"#\" / \"$\" / \"%\" / \"&\" / \"'\" / \"*\"");
        out.println(";               / \"+\" / \"-\" / \".\" / \"^\" / \"_\" / \"`\" / \"|\" / \"~\"");
        out.println(";               / DIGIT / ALPHA");
        out.println(";quoted-string  = DQUOTE *( qdtext / quoted-pair ) DQUOTE");
        out.println(";qdtext         = %x21 / %x23-5B / %x5D-7E / obs-text / OWS");
        out.println("obs-text       = %x80-FF");
        out.println(";quoted-pair    = \"\\\" ( HTAB / SP / VCHAR / obs-text )");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 9. Punctuation");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("OWS =  *( SP / HTAB / \"%20\" / \"%09\" )  ; \"optional\" whitespace ");
        out.println("RWS = 1*( SP / HTAB / \"%20\" / \"%09\" )  ; \"required\" whitespace ");
        out.println("BWS = OWS                              ; \"bad\" whitespace ");
        out.println("");
        out.println("AT     = \"@\" / \"%40\"");
        out.println("COLON  = \":\" / \"%3A\"");
        out.println("COMMA  = \",\" / \"%2C\"");
        out.println("EQ     = \"=\"");
        out.println("SIGN   = \"+\" / \"%2B\" / \"-\"");
        out.println("SEMI   = \";\" / \"%3B\"");
        out.println("STAR   = \"*\" / \"%2A\"");
        out.println("SQUOTE = \"'\" / \"%27\"");
        out.println("");
        out.println("OPEN  = \"(\" / \"%28\"");
        out.println("CLOSE = \")\" / \"%29\"");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; A. URI syntax [RFC3986]");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("URI           = scheme \":\" hier-part [ \"?\" query ] [ \"#\" fragment ]");
        out.println("hier-part     = \"//\" authority path-abempty");
        out.println("              / path-absolute");
        out.println("              / path-rootless");
        out.println(";              / path-empty");
        out.println(";URI-reference = URI / relative-ref");
        out.println(";absolute-URI  = scheme \":\" hier-part [ \"?\" query ]");
        out.println(";relative-ref  = relative-part [ \"?\" query ] [ \"#\" fragment ]");
        out.println(";relative-part = \"//\" authority path-abempty");
        out.println(";              / path-absolute");
        out.println(";              / path-noscheme");
        out.println(";              / path-empty");
        out.println("scheme        = ALPHA *( ALPHA / DIGIT / \"+\" / \"-\" / \".\" )");
        out.println("authority     = [ userinfo \"@\" ] host [ \":\" port ]");
        out.println("userinfo      = *( unreserved / pct-encoded / sub-delims / \":\" )");
        out.println("host          = IP-literal / IPv4address / reg-name");
        out.println("port          = *DIGIT");
        out.println("IP-literal    = \"[\" ( IPv6address / IPvFuture  ) \"]\"");
        out.println("IPvFuture     = \"v\" 1*HEXDIG \".\" 1*( unreserved / sub-delims / \":\" )");
        out.println("IPv6address   =                            6( h16 \":\" ) ls32");
        out.println("                 /                       \"::\" 5( h16 \":\" ) ls32");
        out.println("                 / [               h16 ] \"::\" 4( h16 \":\" ) ls32");
        out.println("                 / [ *1( h16 \":\" ) h16 ] \"::\" 3( h16 \":\" ) ls32");
        out.println("                 / [ *2( h16 \":\" ) h16 ] \"::\" 2( h16 \":\" ) ls32");
        out.println("                 / [ *3( h16 \":\" ) h16 ] \"::\"    h16 \":\"   ls32");
        out.println("                 / [ *4( h16 \":\" ) h16 ] \"::\"              ls32");
        out.println("                 / [ *5( h16 \":\" ) h16 ] \"::\"              h16");
        out.println("                 / [ *6( h16 \":\" ) h16 ] \"::\"");
        out.println("h16           = 1*4HEXDIG");
        out.println("ls32          = ( h16 \":\" h16 ) / IPv4address");
        out.println("IPv4address   = dec-octet \".\" dec-octet \".\" dec-octet \".\" dec-octet");
        out.println("dec-octet     = \"1\" 2DIGIT            ; 100-199");
        out.println("              / \"2\" %x30-34 DIGIT     ; 200-249");
        out.println("              / \"25\" %x30-35          ; 250-255");
        out.println("              / %x31-39 DIGIT         ; 10-99");
        out.println("              / DIGIT                 ; 0-9");
        out.println("reg-name      = *( unreserved / pct-encoded / sub-delims )");
        out.println(";path          = path-abempty    ; begins with \"/\" or is empty");
        out.println(";              / path-absolute   ; begins with \"/\" but not \"//\"");
        out.println(";              / path-noscheme   ; begins with a non-colon segment");
        out.println(";              / path-rootless   ; begins with a segment");
        out.println(";              / path-empty      ; zero characters");
        out.println("path-abempty  = *( \"/\" segment )");
        out.println("path-absolute = \"/\" [ segment-nz *( \"/\" segment ) ]");
        out.println(";path-noscheme = segment-nz-nc *( \"/\" segment )");
        out.println("path-rootless = segment-nz *( \"/\" segment )");
        out.println(";path-empty    = \"\"");
        out.println("segment       = *pchar");
        out.println("segment-nz    = 1*pchar");
        out.println(";segment-nz-nc = 1*( unreserved / pct-encoded / sub-delims / \"@\" ) ; non-zero-length segment without any colon \":\"");
        out.println("pchar         = unreserved / pct-encoded / sub-delims / \":\" / \"@\"");
        out.println("query         = *( pchar / \"/\" / \"?\" )");
        out.println("fragment      = *( pchar / \"/\" / \"?\" )");
        out.println("pct-encoded   = \"%\" HEXDIG HEXDIG");
        out.println("unreserved    = ALPHA / DIGIT / \"-\" / \".\" / \"_\" / \"~\"");
        out.println(";reserved      = gen-delims / sub-delims");
        out.println(";gen-delims    = \":\" / \"/\" / \"?\" / \"#\" / \"[\" / \"]\" / \"@\"");
        out.println(";sub-delims    = \"!\" / \"$\" / \"&\" / \"'\" / \"(\" / \")\" / \"*\" / \"+\" / \",\" / \";\" / \"=\"");
        out.println("sub-delims     =       \"$\" / \"&\" / \"'\" /                                     \"=\" / other-delims");
        out.println("other-delims   = \"!\" /                   \"(\" / \")\" / \"*\" / \"+\" / \",\" / \";\"");
        out.println("");
        out.println("pchar-no-SQUOTE       = unreserved / pct-encoded-no-SQUOTE / other-delims / \"$\" / \"&\" / \"=\" / \":\" / \"@\"");
        out.println("pct-encoded-no-SQUOTE = \"%\" ( \"0\" / \"1\" /   \"3\" / \"4\" / \"5\" / \"6\" / \"8\" / \"9\" / A-to-F ) HEXDIG ");
        out.println("                      / \"%\" \"2\" ( \"0\" / \"1\" / \"2\" / \"3\" / \"4\" / \"5\" / \"6\" /   \"8\" / \"9\" / A-to-F )");
        out.println("");
        out.println("qchar-no-AMP              = unreserved / pct-encoded / other-delims / \":\" / \"@\" / \"/\" / \"?\" / \"$\" / \"'\" / \"=\"");
        out.println("qchar-no-AMP-EQ           = unreserved / pct-encoded / other-delims / \":\" / \"@\" / \"/\" / \"?\" / \"$\" / \"'\"");
        out.println("qchar-no-AMP-EQ-AT-DOLLAR = unreserved / pct-encoded / other-delims / \":\" /       \"/\" / \"?\" /       \"'\"");
        out.println("");
        out.println("qchar-unescaped       = unreserved / pct-encoded-unescaped / other-delims / \":\" / \"@\" / \"/\" / \"?\" / \"$\" / \"'\" / \"=\"");
        out.println("pct-encoded-unescaped = \"%\" ( \"0\" / \"1\" /   \"3\" / \"4\" /   \"6\" / \"8\" / \"9\" / A-to-F ) HEXDIG ");
        out.println("                      / \"%\" \"2\" ( \"0\" / \"1\" /   \"3\" / \"4\" / \"5\" / \"6\" / \"7\" / \"8\" / \"9\" / A-to-F ) ");
        out.println("                      / \"%\" \"5\" ( DIGIT / \"A\" / \"B\" /   \"D\" / \"E\" / \"F\" )");
        out.println("");
        out.println("qchar-no-AMP-DQUOTE   = qchar-unescaped ");
        out.println("                      / escape ( escape / quotation-mark )");
        out.println("                 ");
        out.println("                 ");
        out.println(";------------------------------------------------------------------------------");
        out.println("; B. IRI syntax [RFC3987]");
        out.println(";------------------------------------------------------------------------------");
        out.println("; Note: these are over-generous stubs, for the actual patterns refer to RFC3987");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("IRI-in-header = 1*( VCHAR / obs-text )");
        out.println("IRI-in-query  = 1*qchar-no-AMP");
        out.println("");
        out.println("                      ");
        out.println(";------------------------------------------------------------------------------");
        out.println("; C. ABNF core definitions [RFC5234]");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("ALPHA  = %x41-5A / %x61-7A ");
        out.println("DIGIT  = %x30-39 ");
        out.println("HEXDIG = DIGIT / A-to-F");
        out.println("A-to-F = \"A\" / \"B\" / \"C\" / \"D\" / \"E\" / \"F\" ");
        out.println("DQUOTE = %x22");
        out.println("SP     = %x20 ");
        out.println("HTAB   = %x09 ");
        out.println(";WSP    = SP / HTAB ");
        out.println(";LWSP = *(WSP / CRLF WSP) ");
        out.println("VCHAR = %x21-7E ");
        out.println(";CHAR = %x01-7F");
        out.println(";LOCTET = %x00-FF ");
        out.println(";CR     = %x0D ");
        out.println(";LF     = %x0A ");
        out.println(";CRLF   = CR LF");
        out.println(";BIT = \"0\" / \"1\" ");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; End of odata-abnf-construction-rules");
        out.println(";------------------------------------------------------------------------------");
    }
}
