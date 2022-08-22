package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.User;

import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GsonParseUserList {

    private static List<User> users;

    public static List<User> formUsersList() {

        if (users == null) {
            Gson gson = new Gson();

            try (Reader reader = new FileReader("testDataUser.json")) {

                users = new Gson().fromJson(reader, new TypeToken<List<User>>() {
                }.getType());

                return users;

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}