package mocked.utils;

public class ObjectMapper {

    public <T> T readValue(Object objToRead, Class<T> type) {
        return (T) objToRead;
    }
}
