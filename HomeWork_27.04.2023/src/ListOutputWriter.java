import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;

public class ListOutputWriter extends Writer {

    private final List<String> stringList;

    public ListOutputWriter(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        String str = new String(cbuf, off, len);
        write(str);
    }

    @Override
    public void write(String string) throws IOException {
        stringList.add(string);
    }

    @Override
    public void flush() throws IOException {
        //
    }

    @Override
    public void close() throws IOException {
        //
    }


}
