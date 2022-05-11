package adapter;

import com.ivanshestakov.converter.XmlConverter;

public class XmlSerializerAdapter {
    private static XmlConverter xmlConverter = new XmlConverter();

    public XmlSerializerAdapter() {
    }

    public String toXml(Object o) {
        return(xmlConverter.convertToXml(o));
    }

    public <T> T toObject(Class<T> returned, String str){
        return (xmlConverter.convertToObject(returned,str));
    }
}
