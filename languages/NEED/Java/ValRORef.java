public class ValRORef extends ValRef {

    public ValRORef(Val val) {
        super(val);
    }

    public Val setRef(Val v) {
        throw new PLCCException("cannot modify a read-only reference");
    }

}