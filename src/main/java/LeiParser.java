import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class LeiParser extends DefaultHandler {

    // list to hold lei:LEIRecord tag
    private List<LeiRecord> leiRecordList = null;
    private LeiRecord leiRecord = null;
    private StringBuilder data = null;

    // getter method for leiRecordList
    public List<LeiRecord> getLeiRecordList() {
        return leiRecordList;
    }

    boolean bLEI = false;
    boolean bLegalName = false;
    boolean bCity = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if(qName.equalsIgnoreCase("lei:LEI")){
            bLEI =true;
        }

        if (qName.equalsIgnoreCase("LegalName")) {

            // create a new legalNAme and put it in Map
            String leiName = attributes.getValue("lang");

            // initialize LeiRecord object and set legalName Attributes
            leiRecord = new LeiRecord();
            leiRecord.setLegalName(leiName);

            // initialize list
            if (leiRecordList == null) {
                leiRecordList = new ArrayList();

            } else if (qName.equalsIgnoreCase("lei:City")) {
                bCity = true;
            }
        }
        // create the data container
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(bLEI){
            leiRecord.setLEI(data.toString());
            bLEI = false;
        }

        if (bCity) {
            leiRecord.setCity(data.toString());
            bCity = false;
        }
        if (qName.equalsIgnoreCase("LegalName")) {
            // add legalName to the list
            leiRecordList.add(leiRecord);

        }
    }

    @Override
    public void characters (char ch[], int start, int length){
        data.append(new String(ch,start,length));
    }



}
