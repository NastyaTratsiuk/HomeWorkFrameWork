package utils;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider(name = "testUsers")
    public static Iterator<Object[]> getFileList() {
        List<User> users = GsonParse.formUsersList();
        List<Object[]> data = new ArrayList<>();
        for (User user : users) {
            data.add(new Object[]{user});
        }
        return data.iterator();
    }
}
