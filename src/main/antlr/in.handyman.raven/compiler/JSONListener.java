// Generated from java-escape by ANTLR 4.11.1

package in.handyman.raven.compiler;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JSONParser}.
 */
public interface JSONListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link JSONParser#json}.
     *
     * @param ctx the parse tree
     */
    void enterJson(JSONParser.JsonContext ctx);

    /**
     * Exit a parse tree produced by {@link JSONParser#json}.
     *
     * @param ctx the parse tree
     */
    void exitJson(JSONParser.JsonContext ctx);

    /**
     * Enter a parse tree produced by {@link JSONParser#obj}.
     *
     * @param ctx the parse tree
     */
    void enterObj(JSONParser.ObjContext ctx);

    /**
     * Exit a parse tree produced by {@link JSONParser#obj}.
     *
     * @param ctx the parse tree
     */
    void exitObj(JSONParser.ObjContext ctx);

    /**
     * Enter a parse tree produced by {@link JSONParser#pair}.
     *
     * @param ctx the parse tree
     */
    void enterPair(JSONParser.PairContext ctx);

    /**
     * Exit a parse tree produced by {@link JSONParser#pair}.
     *
     * @param ctx the parse tree
     */
    void exitPair(JSONParser.PairContext ctx);

    /**
     * Enter a parse tree produced by {@link JSONParser#arr}.
     *
     * @param ctx the parse tree
     */
    void enterArr(JSONParser.ArrContext ctx);

    /**
     * Exit a parse tree produced by {@link JSONParser#arr}.
     *
     * @param ctx the parse tree
     */
    void exitArr(JSONParser.ArrContext ctx);

    /**
     * Enter a parse tree produced by {@link JSONParser#jValue}.
     *
     * @param ctx the parse tree
     */
    void enterJValue(JSONParser.JValueContext ctx);

    /**
     * Exit a parse tree produced by {@link JSONParser#jValue}.
     *
     * @param ctx the parse tree
     */
    void exitJValue(JSONParser.JValueContext ctx);
}