package after.refactor;

import mocked.utils.Formatter;
import mocked.utils.Message;

import java.io.IOException;
import java.io.PrintWriter;

public class MessagePrinter {

    public void writeMessage(Formatter formatter, PrintWriter writer, Message msg) throws IOException {
        writer.println(formatter.format(msg));
        writer.flush();
    }
}
