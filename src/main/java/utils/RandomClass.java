package utils;

import org.assertj.core.internal.bytebuddy.utility.RandomString;

public class RandomClass {

    public String generateString() {
        RandomString rs = new RandomString();
        return rs.nextString();
    }
}
