package th.co.pt.ptgapp.config;


import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import th.co.pt.ptgapp.utils.PtgProperties;


import java.io.*;
import java.util.*;


@Service
public class PtgPropertiesServiceImpl implements PtgProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(PtgPropertiesServiceImpl.class);


    private ResourceLoader resourceLoader;


    public PtgPropertiesServiceImpl(ResourceLoader resourceLoader) {

        this.resourceLoader = resourceLoader;
    }

    //    @PostConstruct
    public String getStringProperty(String word) throws  Exception{
        String ret ="";
        Map<String, Integer> wordCount = new HashMap<>();
        try {
            LOGGER.info("GeoLocationServiceImpl: Trying to load GeoLite2-Country database...");

            Resource resource = resourceLoader.getResource("classpath:PtgLabConfigText.properties");
            InputStream dbAsStream = resource.getInputStream(); // <-- this is the difference

            StringWriter writer = new StringWriter();
            IOUtils.copy(dbAsStream, writer, "UTF-8");
            String theString = writer.toString();ret= theString;



            //--------------
            Reader  bReader = new BufferedReader(new InputStreamReader(dbAsStream, "UTF-8"));

            int n=0;
            char[] buff = new char[1024];

//            while ((n = bReader.read(buff)) != -1) {
            int j=0;


            while (theString.split(word).length >0) {
//                writer = new StringWriter();
//                writer.write(buff, 0, n);
                String StrArr[] = theString.split(word);
                String retStr =  StrArr[j+1];

//                for(int j = 0; j>=StrArr.length;j++) {
                if (!retStr.startsWith("#")&&(retStr.indexOf("#")!=0)) {
                    String StrFindVal[] = retStr.split("=");
                    String tokentmp="";
//                    for(int run=0;StrFindVal.length-1>=run;run++){
//                        tokentmp=tokentmp+"|"+StrFindVal[run];
//                    }
//                    if(tokentmp.split("|")[0].equals("|"))
                    tokentmp = StrFindVal[1].replaceAll("(\r\n)", "=");
                    ret = tokentmp.split("=")[0];
                    break;
                    //result.add(new SingleInstance(line));
                }
                j++;
            }



            LOGGER.info("GeoLocationServiceImpl: Database was loaded successfully.");

        } catch (NullPointerException e) {
            LOGGER.error("Database reader cound not be initialized. ", e);
        }
        return ret;
    }
    public static final String getResourceString(String parm)
            throws MissingResourceException {
        return "";//.getString(parm);
    }
    //    @PreDestroy
//    public void preDestroy() {
//        if (reader != null) {
//            try {
//                reader.close();
//            } catch (IOException e) {
//                LOGGER.error("Failed to close the reader.");
//            }
//        }
//    }
//public static Set<SingleInstance> loadData(File file , String param)

}