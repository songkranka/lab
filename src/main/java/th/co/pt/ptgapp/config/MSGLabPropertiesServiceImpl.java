package th.co.pt.ptgapp.config;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import th.co.pt.ptgapp.utils.MsgLabProperties;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
@Service
public class MSGLabPropertiesServiceImpl implements MsgLabProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(PtgPropertiesServiceImpl.class);


    private ResourceLoader resourceLoader;


    public MSGLabPropertiesServiceImpl(ResourceLoader resourceLoader) {

        this.resourceLoader = resourceLoader;
    }
    public String getMsgLabProperty(String word) throws  Exception {
        String ret = "";
        Map<String, Integer> wordCount = new HashMap<>();
        try {
            LOGGER.info("GeoLocationServiceImpl: Trying to load GeoLite2-Country database...");
//            ResourceBundle ResourceBundleResponse =  ResourceBundle.getBundle("classpath:PtgLabConfigText.properties");
            Resource resource = resourceLoader.getResource("classpath:MsgLabConfig.properties");
            InputStream dbAsStream = resource.getInputStream(); // <-- this is the difference
//            InputStreamReader      inputStreamReader      = new InputStreamReader(dbAsStream);
            StringWriter writer = new StringWriter();
            IOUtils.copy(dbAsStream, writer, "UTF-8");
            String theString = writer.toString();ret= theString;
//            List<String> lines =IOUtils.readLines(dbAsStream, "UTF-8");
//            for (String line : lines) {
//                if (!line.startsWith("#")) {
//                    ret= line;
//                    //result.add(new SingleInstance(line));
//                }
//            }


            //--------------
            Reader bReader = new BufferedReader(new InputStreamReader(dbAsStream, "UTF-8"));

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
        }
        catch (Exception e){

        }
        return ret;
    }
}
