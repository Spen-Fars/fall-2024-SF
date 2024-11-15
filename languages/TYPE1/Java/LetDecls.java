//LetDecls:top//
//LetDecls:import//
import java.util.*;

// <letDecls> **= <VAR> EQUALS <exp>
public class LetDecls /*LetDecls:class*/ {

    public static final String $className = "LetDecls";
    public static final String $ruleString =
        "<letDecls> **= <VAR> EQUALS <exp>";

    public List<Token> varList;
    public List<Exp> expList;

    public LetDecls(List<Token> varList, List<Exp> expList) {
        // check for duplicates during parsing
        Env.checkDuplicates(varList, " in let/letrec LHS identifiers");
//LetDecls:init//
        this.varList = varList;
        this.expList = expList;
    }

    public static LetDecls parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<letDecls>", scn$.lno);
        List<Token> varList = new ArrayList<Token>();
        List<Exp> expList = new ArrayList<Exp>();
        while (true) {
            Token t$ = scn$.cur();
            Token.Match match$ = t$.match;
            switch(match$) {
            case VAR:
                varList.add(scn$.match(Token.Match.VAR, trace$));
                scn$.match(Token.Match.EQUALS, trace$);
                expList.add(Exp.parse(scn$, trace$));
                continue;
            default:
                return new LetDecls(varList, expList);
            }
        }

    }

    public Env addBindings(Env env) {
        Rands rands = new Rands(expList);
        List<Val> valList = rands.evalRands(env);
        List<Ref> refList = Ref.valsToRefs(valList);
        Bindings bindings = new Bindings(varList, refList);
        return env.extendEnvRef(bindings);
    }
    
    public Env addLetrecBindings(Env env) {
        Env nenv = env.extendEnvRef(new Bindings(varList.size()));
        Iterator<Token> varIter = varList.iterator();
        Iterator<Exp> expIter = expList.iterator();
        while (varIter.hasNext()) {
            String str = varIter.next().toString();
            Val val = expIter.next().eval(nenv);
            Ref ref = new ValRef(val);
            nenv.add(new Binding(str, ref));
        }
        return nenv;
    }
    
    public TypeEnv addTypeBindings(TypeEnv tenv) {
        List<String> stringVarList = new ArrayList<String>(varList.size());
        for(Token t : varList)
            stringVarList.add(t.toString());
        Rands rands = new Rands(expList);
        List<Type> typeList = rands.evalTypeRands(tenv);
        TypeBindings typeBindings = new TypeBindings(stringVarList, typeList);
        return tenv.extendTypeEnv(typeBindings);
    }
    
    public TypeEnv addLetrecTypeBindings(TypeEnv tenv) {
        List<String> stringVarList = new ArrayList<String>(varList.size());
        for(Token t : varList) {
            stringVarList.add(t.toString());
        }
        tenv = tenv.extendTypeEnv(new TypeBindings());
        Iterator<Token> varIter = varList.iterator();
        Iterator<Exp> expIter = expList.iterator();
        while (varIter.hasNext()) {
            String str = varIter.next().toString();
            Type typ = expIter.next().evalType(tenv);
            tenv.add(new TypeBinding(str, typ));
        }
        return tenv;
    }
    
    public String toString() {
        return " ...LetDecls... ";
    }

//LetDecls//
}
