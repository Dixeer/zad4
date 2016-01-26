import java.util.List;
import java.util.Iterator;

class EIterator <T> implements Iterator<Executeable <T>>
{
    List<Executeable <T>> executableL;
    int cur;

    public EIterator(List<Executeable <T>> executable)
    {
        this.executableL = executable;
        cur = 0;
    }

    @Override
    public boolean hasNext()
    {
        return cur < executableL.size();
    }

    @Override
    public Executeable <T> next()
    {
        return executableL.get(cur++);
    }
}
