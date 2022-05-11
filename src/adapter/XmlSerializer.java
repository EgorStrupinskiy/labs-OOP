package adapter;

public interface XmlSerializer {

    String toXml(final Object o);

    Object toObject(final String xml);

}
