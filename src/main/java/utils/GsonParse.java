package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Root;
import models.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class GsonParse {

    public static Root root;
    private static List<User> users;

    public static Root parse() {
        if (root == null) {
            Gson gson = new Gson();
            try (Reader reader = new FileReader("configFile.json")) {
                root = gson.fromJson(reader, Root.class);
                return root;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return root;
    }

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
        return users;
    }
}