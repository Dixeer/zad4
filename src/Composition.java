import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Composition <T> implements Executeable <T>, Iterable <Executeable<T>>
{
    List<Executeable <T>> executableL;

    public Composition(Executeable <T>... executables)
    {
        executableL = new ArrayList<>();
        for (Executeable <T> executeable : executables)
            executableL.add(executeable);
    }

    public Composition(List<Executeable <T>> exe)
    {
        executableL = exe;
    }

    @Override
    public T execute(T i)
    {
        T res = i;
        for (Executeable <T> executeable : executableL)
            res = executeable.execute(res);
        return res;
    }

    @Override
    public Iterator<Executeable <T>> iterator()
    {
        return new EIterator<>(executableL);
    }
    public void add(Executeable <T> executeable) {
        executableL.add(executeable);
    }
}
