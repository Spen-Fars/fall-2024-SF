import java.util.*;

public class Bindings {

    public List<Binding> bindingList;

    // create an empty list of bindings
    public Bindings() {
        bindingList = new ArrayList<Binding>();
    }

    public Bindings(int capacity) {
        bindingList = new ArrayList<Binding>(capacity);
    }

    public Bindings(List<Binding> bindingList) {
        this.bindingList = bindingList;
    }

    public Binding lookup(String sym) {
        for (Binding b: bindingList)
            if (sym.equals(b.id))
                return b;
        return null;
    }

    // idList is a list of Tokens/Strings (whatever has a toString())
    // refList is a list of Refs
    public Bindings(List<?> idList, List<Ref> refList) {
        if (idList.size() != refList.size())
            throw new PLCCException("List sizes mismatch");
        bindingList = new ArrayList<Binding>(idList.size());
        Iterator<?> idIterator = idList.iterator();
        Iterator<Ref> refIterator = refList.iterator();
        while (idIterator.hasNext()) {
            String s = idIterator.next().toString();
            Ref r = refIterator.next();
            this.add(new Binding(s, r));
        }
    }

    public void add(Binding b) {
        bindingList.add(b);
    }

    public void add(String s, Ref r) {
        add(new Binding(s, r));
    }

    public int size() {
        return bindingList.size();
    }

    public String toString() {
        String s = "";
        for (Binding b : bindingList)
            s += b + "\n";
        return s;
    }
}