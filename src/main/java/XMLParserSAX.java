import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLParserSAX {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        {
            LeiParser leiParser = new LeiParser();
            saxParser.parse(new File("C:\\Users\\XXXXX\\Desktop\\LEI.xml"), leiParser);
            //Get Entity list
            List<LeiRecord> leiRecordList =leiParser.getLeiRecordList();
            for (LeiRecord leiRecord : leiRecordList){
                System.out.println(leiRecord);
            }
        }
    }
}