import java.util.*;

public abstract class Type {

    public static final IntType intType = new IntType();
    public static final BoolType boolType = new BoolType();

    public ProcType procType() {
        throw new PLCCException("Type error", this + ": not a procedure type");
    }

    public static final ProcType ii_i = compile("ii>i");
    public static final ProcType i_i  = compile("i>i");
    public static final ProcType ii_b = compile("ii>b");
    public static final ProcType i_b  = compile("i>b");
    public static final ProcType bb_b = compile("bb>b");
    public static final ProcType b_b  = compile("b>b");

    // return the "type" of the character at position i in String s
    public static Type decodeType(String s, int i) {
        char c = s.charAt(i);
        switch(c) {
            case 'i':
                return intType;
            case 'b':
                return boolType;
            case '>':
                return null;
            default:
                throw new PLCCException("Type error", "decodeType failure");
        }
    }

    public static ProcType compile(String s) {
        List<Type> paramTypeList = new ArrayList<Type>();
        int i = 0; // index into the string
        while(true) {
            Type t = decodeType(s, i++);
            if (t == null)
                break;
            paramTypeList.add(t);
        }
        Type returnType = decodeType(s, i);
        return new ProcType(paramTypeList, returnType);
    }

    public abstract void checkEquals(Type t);

    public static Type [] toArray(List<Type> typeList) {
        int n = typeList.size();
        return typeList.toArray(new Type[n]); // return an array
    }

    public static void checkEquals(Type t1, Type t2) {
        t1.checkEquals(t2);
    }

    public static void checkEqualTypes(List<Type> typeList1,
                                       List<Type> typeList2) {
        if (typeList1.size() != typeList2.size())
            throw new PLCCException("Type error", "argument number mismatch");
        Iterator<Type> typeIterator1 = typeList1.iterator();
        Iterator<Type> typeIterator2 = typeList2.iterator();
        while (typeIterator1.hasNext()) {
            Type t1 = typeIterator1.next();
            Type t2 = typeIterator2.next();
            t1.checkEquals(t2);
        }
    }

    // check to see if this is a ProcType
    public void checkProcType() {
        throw new PLCCException("Type error",
                            this + ": attempt to apply a non-procedure");
    }

    // default type check of this compared to a ProcType
    public void checkProcType(ProcType t) {
        typeMismatch(this, t);
    }

    // default type check of this compared to a BoolType
    public void checkBoolType(BoolType t) {
        typeMismatch(this, t);
    }

    // default type check of this compared to an IntType
    public void checkIntType(IntType t) {
        typeMismatch(this, t);
    }

    public static void typeMismatch(Type t1, Type t2) {
        throw new PLCCException("Type error",
                                "type mismatch: " + t1 + " != " + t2);
    }

    public static void main(String [] args) {
        System.out.println(intType);
        System.out.println(boolType);
        System.out.println(ii_i);
        System.out.println(i_b);
        System.out.println(bb_b);
    }

}