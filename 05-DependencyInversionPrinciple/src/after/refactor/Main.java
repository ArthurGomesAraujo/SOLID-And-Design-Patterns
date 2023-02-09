package after.refactor;

import mocked.utils.JSONFormatter;
import mocked.utils.Message;
import mocked.utils.XMLFormatter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        Message msg = new Message("This is a message");
        MessagePrinter printer = new MessagePrinter();

        try(PrintWriter writer = new PrintWriter(new FileWriter("tst_message.txt"))) {
            printer.writeMessage(new XMLFormatter(), writer, msg);
        }
    }
}
