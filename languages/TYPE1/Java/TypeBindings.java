import java.util.*;

public class TypeBindings {

    public List<TypeBinding> bindingList;

    // create an empty list of bindings
    public TypeBindings() {
        bindingList = new ArrayList<TypeBinding>();
    }

    public TypeBindings(int capacity) {
        bindingList = new ArrayList<TypeBinding>(capacity);
    }

    public TypeBindings(List<TypeBinding> bindingList) {
        this.bindingList = bindingList;
    }

    // idList is a list of Tokens/Strings
    // typeList is a list of Types
    public TypeBindings(List<?> idList, List<Type> typeList) {
        if (idList.size() != typeList.size())
            throw new PLCCException("Type Bindings error",
                                "List size mismatch");
        bindingList = new ArrayList<TypeBinding>(idList.size());
        Iterator<?> idIterator = idList.iterator();
        Iterator<Type> typeIterator = typeList.iterator();
        while (idIterator.hasNext()) {
            String id = idIterator.next().toString();
            Type typ = typeIterator.next();
            bindingList.add(new TypeBinding(id, typ));
        }
    }

    public void add(String s, Type t) {
        bindingList.add(new TypeBinding(s, t));
    }

    public void add(TypeBinding b) {
        bindingList.add(b);
    }

    public int size() {
        return bindingList.size();
    }

    public String toString() {
        String s = "";
        for (TypeBinding b : bindingList)
            s += " " + b;
        return s;
    }
}