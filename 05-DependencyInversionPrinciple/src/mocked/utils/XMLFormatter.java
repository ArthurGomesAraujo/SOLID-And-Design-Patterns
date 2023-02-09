package mocked.utils;

public class XMLFormatter implements Formatter {

    public String format(Message message) throws FormatException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsXML(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new FormatException(e);
        }
    }
}
