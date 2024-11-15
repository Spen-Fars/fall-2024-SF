import java.util.*;

public abstract class Ref {

    public static List<Ref> valsToRefs(List<Val> valList) {
        List<Ref> refList = new ArrayList<Ref>(valList.size());
        for (Val v : valList)
            refList.add(new ValRef(v));
        return refList;
    }

    public abstract Val deRef();
    public abstract Val setRef(Val v);
}