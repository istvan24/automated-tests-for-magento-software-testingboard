//TODO
package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import objectModels.LoginModel;
import org.testng.annotations.DataProvider;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class DataProviders {

    @DataProvider(name = "jsonDataProvider")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src\\test\\resources\\Data\\testData.json");

        LoginModel[] lmList = objectMapper.readValue(file, LoginModel[].class);

        for (LoginModel lm : lmList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }

    @DataProvider(name = "xmlDataProvider")
    public Iterator<Object[]> xmlDpCollection() throws JAXBException {
        Collection<Object[]> dp = new ArrayList<>();
        File file = new File("src\\test\\resources\\Data\\testData.xml");

        LoginModel loginModel = (LoginModel) unMarshalObjectModel(file, LoginModel.class);

        dp.add(new Object[]{loginModel});
        return dp.iterator();
    }

    private Object unMarshalObjectModel(File f, Class<?>... classesToBeBound) throws JAXBException {
        //setting up Class context for return object from xml
        JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);

        //loading of xml file that need to be mapped and mapping it
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return unmarshaller.unmarshal(f);
    }
}